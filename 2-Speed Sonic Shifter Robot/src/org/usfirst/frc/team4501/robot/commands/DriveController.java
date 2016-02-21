package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.OI;
import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveController extends Command {

	public static DriveController instance = new DriveController();

	public enum DriveMode {
		TANK, ARCADE, ARCADETRIGGER
	};

	public static DriveMode driveMode;

	DriveTrain driveTrain;
	OI oi;

	public DriveController() {
		requires(Robot.driveTrain);
		driveTrain = Robot.driveTrain;
		oi = Robot.oi;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double rotate = oi.getLeftXboxX();

		switch (driveMode) {
		case ARCADE:
			double forward = Robot.oi.getLeftXboxY();
			driveTrain.arcadeDrive(forward, rotate);
			break;

		case ARCADETRIGGER:
			double forwardTrigger = Robot.oi.getRightTrigger();
			double reverseTrigger = Robot.oi.getLeftTrigger();
			double squaredRotate = Robot.oi.getRightXboxX();
			driveTrain.arcadeTriggerDrive(forwardTrigger, reverseTrigger, rotate, squaredRotate);
			break;

		case TANK:
			double leftForward = oi.getLeftXboxY();
			double rightForward = oi.getRightXboxY();
			driveTrain.tankDrive(leftForward, rightForward);
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
