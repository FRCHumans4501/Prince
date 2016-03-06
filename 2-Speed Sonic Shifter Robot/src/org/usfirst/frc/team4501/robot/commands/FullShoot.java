package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.OI;
import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class FullShoot extends CommandGroup {
	Shooter shooter;
	OI oi;

	public FullShoot(int Mode) {
		requires(Robot.driveTrain);
		requires(Robot.shooter);
		addSequential(new PusherRetract());
		if (Mode == 1) {
			addParallel(new FullShooterSpin());
		} else if (Mode == 2) {
			addParallel(new NinetyFiveShooter());
		} else if (Mode == 3) {
			addParallel(new NinetyPercentShoot());
		} else if (Mode == 4) {
			addParallel(new EightyFiveShooter());
		} else if (Mode == 5) {
			addParallel(new EightyShooter());
		} else {
			DriverStation.reportError("Mode was Null/not Correct", true);
		}
		addSequential(new WaitCommand(1));
		addSequential(new PusherExtend());
		addSequential(new WaitCommand(.1));
		addSequential(new PusherRetract());
		addSequential(new ShooterIdle());

	}
}
