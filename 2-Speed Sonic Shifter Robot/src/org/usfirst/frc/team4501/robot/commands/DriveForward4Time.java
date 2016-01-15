package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward4Time extends Command {
	DriveTrain driveTrain;
	Timer timer;
	
	double speed;
	double runTime;
	boolean finished = false;
    public DriveForward4Time(double speed, double time) {
    	requires(Robot.driveTrain);
    	driveTrain = Robot.driveTrain;
    	
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
    	driveTrain.arcadeDrive(this.speed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double currentTime = timer.get();
        
        if (runTime > currentTime) {
        	return false;
        } else {
        	return true;
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
