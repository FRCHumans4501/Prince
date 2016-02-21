package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.OI;
import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class FullIntake extends CommandGroup {
	Shooter shooter;
	OI oi;

	public FullIntake() {
		requires(Robot.shooter);
		shooter = Robot.shooter;
		oi = Robot.oi;
		
		addSequential(new PusherRetract());
		addSequential(new IntakeShooterArcade());
	}
}
