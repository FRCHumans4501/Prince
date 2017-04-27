package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.subsystems.DriveTrain;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
//import edu.wpi.first.wpilibj.command.WaitCommand;
//import edu.wpi.first.wpilibj.command.WaitUntilCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class MoveBackwardAutoCommand extends CommandGroup {
	DriveTrain driveTrain;

	public MoveBackwardAutoCommand() {
		requires(Robot.driveTrain);
		driveTrain = Robot.driveTrain;
		addSequential(new PusherRetract());
		addSequential(new PositionPickup());
		addSequential(new WaitCommand(1));

		
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
	}

}
