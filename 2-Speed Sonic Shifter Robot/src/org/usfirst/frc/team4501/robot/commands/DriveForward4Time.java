package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForward4Time extends Command {
	DriveTrain driveTrain;
	Timer timer;
	
	double speed;
	double runTime;
	boolean finished = false;
    public DriveForward4Time(double xspeed, double time) {
    	requires(Robot.driveTrain);
    	driveTrain = Robot.driveTrain;
    	
    	this.speed = xspeed;
    	timer = new Timer();
    	this.runTime = time;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.stop();
    	timer.reset();
    	timer.start();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Run Time", timer.get());
    	driveTrain.arcadeDrive(-speed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double currentTime = timer.get();
        
        if (this.runTime <= currentTime) {
        	return true;
        } else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
