package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class FireBall extends CommandGroup {
	Shooter shooter;
    
    public  FireBall() {
    	requires(Robot.shooter);
    	shooter = Robot.shooter;

        // Add Commands here:
    	addSequential(new PusherExtend());
    	addSequential(new WaitCommand(2));
    	addSequential(new PusherRetract());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}