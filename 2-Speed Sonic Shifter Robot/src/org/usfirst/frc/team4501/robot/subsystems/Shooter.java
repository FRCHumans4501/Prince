package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.OI;
import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.RobotMap;
import org.usfirst.frc.team4501.robot.commands.ShooterIdle;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	
	RobotDrive shooter;
	OI oi;

	CANTalon lShooterTalon;
	CANTalon rShooterTalon;

	DoubleSolenoid pusher;
	DoubleSolenoid vertical;

	public Shooter() {
		oi = Robot.oi;
		this.lShooterTalon = new CANTalon(RobotMap.LEFTCANMOTOR);
		this.rShooterTalon = new CANTalon(RobotMap.RIGHTCANMOTOR);
		this.shooter = new RobotDrive(lShooterTalon, rShooterTalon);
		this.pusher = new DoubleSolenoid(RobotMap.Solenoids.SHOOTER_EX, RobotMap.Solenoids.SHOOTER_RT);
		this.vertical = new DoubleSolenoid(RobotMap.Solenoids.GOINGUP, RobotMap.Solenoids.GOINDOWN);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ShooterIdle());
	}

	public void shooterArcade() {
		
		shooter.arcadeDrive(100, 0);
	}
	
	public void intakeshooterArcade(){
		shooter.arcadeDrive(-.75, 0);
	}

	public void shooterStop() {
		shooter.arcadeDrive(0, 0);
	}


	public void pusherExtend() {
		pusher.set(Value.kForward);
	}

	public void pusherRetract() {
		pusher.set(Value.kReverse);
	}
	
	public void ShooterVerticalUp() {
		vertical.set(Value.kForward);
	}
	
	public void ShooterVerticalDown() {
		vertical.set(Value.kReverse);
	}
}