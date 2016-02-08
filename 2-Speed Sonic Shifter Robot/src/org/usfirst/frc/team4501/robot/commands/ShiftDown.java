package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftDown extends Command {

    public ShiftDown() {
    	requires(Robot.driveTrain);
    }
    
   

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.lowGear();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        System.out.println("ShiftDown: Finished");
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
