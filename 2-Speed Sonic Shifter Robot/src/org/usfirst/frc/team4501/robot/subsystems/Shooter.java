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

	protected enum PusherState {
		PS_EXT, PS_RET;
	}
	
	RobotDrive shooter;
	OI oi;

	CANTalon lShooterTalon;
	CANTalon rShooterTalon;

	DoubleSolenoid pusher;
	protected PusherState state;

	public Shooter() {
		oi = Robot.oi;
		this.lShooterTalon = new CANTalon(RobotMap.LEFTCANMOTOR);
		this.rShooterTalon = new CANTalon(RobotMap.RIGHTCANMOTOR);
		this.shooter = new RobotDrive(lShooterTalon, rShooterTalon);
		this.pusher = new DoubleSolenoid(RobotMap.SOLENOID_SHOOTER_EX, RobotMap.SOLENOID_SHOOTER_RT);
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


	public void pusherExtend() {
		pusher.set(Value.kForward);
		state = PusherState.PS_EXT;
	}

	public void pusherRetract() {
		pusher.set(Value.kReverse);
		state = PusherState.PS_RET;
	}

	public void setPusher(PusherState state) {
		switch (state) {
		case PS_EXT:
			this.pusherExtend();
			break;

		case PS_RET:
			this.pusherRetract();
			break;
		}
	}
	
	public PusherState getState(){
		return state;
	}
}