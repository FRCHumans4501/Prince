package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.OI;
import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.XboxController.Trigger;
import org.usfirst.frc.team4501.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveController extends Command {
	
	public static DriveController instance = new DriveController();
	
	public enum DriveMode{TANK, ARCADE};
	
	public static DriveMode driveMode;
	
	DriveTrain driveTrain;
	OI oi;
	
    public DriveController() {
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain = Robot.driveTrain;
    	oi = Robot.oi;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	switch(driveMode){
    	case ARCADE:
        	driveTrain.arcadeDrive(true);
        	break;
        	
    	case TANK:
    		driveTrain.tankDrive();
    		break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("DriveController.interrupted()");
    }
}
