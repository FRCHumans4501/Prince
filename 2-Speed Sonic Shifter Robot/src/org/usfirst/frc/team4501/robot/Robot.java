
package org.usfirst.frc.team4501.robot;

import org.usfirst.frc.team4501.robot.commands.DriveArcade;
import org.usfirst.frc.team4501.robot.commands.DriveIdle;
import org.usfirst.frc.team4501.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

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
    
    // Subsystems
    public static final DriveTrain driveTrain = new DriveTrain();
    
    public static Gyro gyro;
    
    public static Encoder encoder;
    
    public void robotInit() {
		oi = new OI();
		gyro = new Gyro(RobotMap.GYRO);
		
		
		
		
        // instantiate the command used for the autonomous period
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
       
    	gyro.reset();
    	
    	
		//driveTrain.resetEncoders();
    	
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
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        
        gyro.reset();
        
        Scheduler.getInstance().add(new DriveArcade());
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	gyro.reset();
    	
    	Scheduler.getInstance().add(new DriveIdle());
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	DriveTrain.update();
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
