package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.OI;
import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SeperateDrive extends Command {
	OI oi;
	DriveTrain driveTrain;

    public SeperateDrive() {
    	requires(driveTrain);
    
   
    	
    	oi = Robot.oi;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rSpeed = oi.getXboxY();
    	double lSpeed = oi.getXboxY2();
    	driveTrain.seperateDrive(rSpeed, lSpeed);  	
    	
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
    }
}
