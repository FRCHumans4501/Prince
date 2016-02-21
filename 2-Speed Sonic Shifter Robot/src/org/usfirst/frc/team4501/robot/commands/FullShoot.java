package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.OI;
import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class FullShoot extends CommandGroup {
	Shooter shooter;
	OI oi;

	public FullShoot() {
		requires(Robot.driveTrain);
		requires(Robot.shooter);
		shooter = Robot.shooter;
		oi = Robot.oi;
		addSequential(new PusherRetract());
		addParallel(new FullShooterSpin());
		addSequential(new WaitCommand(1));
		addSequential(new PusherExtend());
		addSequential(new WaitCommand(.1));
		addSequential(new PusherRetract());
		addSequential(new ShooterIdle());

	}
}
