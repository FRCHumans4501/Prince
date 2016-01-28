package org.usfirst.frc.team4501.robot;

import org.usfirst.frc.team4501.robot.commands.AutonomousCommand;
import org.usfirst.frc.team4501.robot.commands.DriveArcade;
import org.usfirst.frc.team4501.robot.commands.DriveIdle;
import org.usfirst.frc.team4501.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4501.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;

	Command autonomousCommand;

	CameraServer server;
	NetworkTable table;
	
	private final static String[] GRIP_ARGS = new String[]{
			"/usr/local/frc/JRE/bin/java", "-jar",
	        "/home/lvuser/grip.jar", "/home/lvuser/project.grip"};
	
	private final NetworkTable grip = NetworkTable.getTable("grip");
	
	public Robot() {
		server = CameraServer.getInstance();
		server.setQuality(50);
		// the camera name (ex "cam0") can be found through the roborio web
		// interface
		server.startAutomaticCapture("cam0");
		table = NetworkTable.getTable("GRIP/myContorsReport");
	}

	/**
	 * start up automatic capture you should see the video stream from the
	 * webcam in your FRC PC Dashboard.
	 */
	public void operatorControl() {

		while (isOperatorControl() && isEnabled()) {
			/** robot code here! **/
			Timer.delay(0.005); // wait for a motor update time
		}
	}

	// Subsystems
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Shooter shooter = new Shooter();

	public void robotInit() {
		oi = new OI();
		

		driveTrain.initGyro();
		autonomousCommand = new AutonomousCommand();
		
		/*
		 *  Vision Stuff had errors so I had to disable
		 try {
	            Runtime.getRuntime().exec(GRIP_ARGS);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        */
	    }
		
	

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		driveTrain.sensorReset();

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		 /* Get published values from GRIP using NetworkTables */
        for (double area : grip.getNumberArray("targets/area", new double[0])) {
            System.out.println("Got contour with area=" + area);
        }
    }


	
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.

		if (autonomousCommand != null)
			autonomousCommand.cancel();

		driveTrain.sensorReset();

		Scheduler.getInstance().add(new DriveArcade());
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

		Scheduler.getInstance().add(new DriveIdle());

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		driveTrain.getSensors();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
