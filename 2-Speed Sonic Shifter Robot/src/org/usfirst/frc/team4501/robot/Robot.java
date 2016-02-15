package org.usfirst.frc.team4501.robot;

import org.usfirst.frc.team4501.robot.commands.AutonomousCommand;
import org.usfirst.frc.team4501.robot.commands.DriveController;
import org.usfirst.frc.team4501.robot.commands.DriveController.DriveMode;
import org.usfirst.frc.team4501.robot.commands.DriveIdle;
import org.usfirst.frc.team4501.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4501.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;

	// Subsystems
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Shooter shooter = new Shooter();

	SendableChooser driveChooser;
	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();

		autonomousCommand = new AutonomousCommand();

		driveChooser = new SendableChooser();
		driveChooser.addDefault("Arcade Drive", DriveController.DriveMode.ARCADE);
		driveChooser.addObject("Tank Drive", DriveController.DriveMode.TANK);
		SmartDashboard.putData("Drive Chooser", driveChooser);
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		System.out.println("Robot.autonomousInit()");
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
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

		driveTrain.sensorReset();

		DriveController.driveMode = (DriveMode) driveChooser.getSelected();
		System.out.println("Robot.teleopInit() mode = " + DriveController.driveMode);
		DriveController.instance.start();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {
		driveTrain.sensorReset();
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
