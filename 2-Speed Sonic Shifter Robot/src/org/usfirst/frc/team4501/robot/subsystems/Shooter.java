package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.OI;
import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.RobotMap;
import org.usfirst.frc.team4501.robot.commands.ShooterIdle;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	RobotDrive shooter;
	OI oi;

	Talon lShooterTalon;
	Talon rShooterTalon;

	public Shooter() {
		oi = Robot.oi;
		this.lShooterTalon = new Talon(RobotMap.LEFTSHOOTERMOTOR);
		this.rShooterTalon = new Talon(RobotMap.RIGHTSHOOTERMOTOR);
		this.shooter = new RobotDrive(lShooterTalon, rShooterTalon);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ShooterIdle());
	}

	public void shooterArcade() {
		double shooterSpeed = Robot.oi.getShooterThrottle();
		shooter.arcadeDrive(shooterSpeed, 0);
	}

	public void shooterStop() {
		shooter.arcadeDrive(0, 0);
	}
}