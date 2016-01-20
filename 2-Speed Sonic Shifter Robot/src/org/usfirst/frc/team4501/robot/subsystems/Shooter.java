package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.RobotMap;
import org.usfirst.frc.team4501.robot.commands.ShooterArcade;
import org.usfirst.frc.team4501.robot.commands.ShooterIdle;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    RobotDrive shooter;
    
    Talon lShooterTalon;
    Talon rShooterTalon;

    public Shooter(){
    	this.lShooterTalon = new Talon(RobotMap.LEFTSHOOTERMOTOR);
    	this.rShooterTalon = new Talon(RobotMap.RIGHTSHOOTERMOTOR);
    	this.shooter = new RobotDrive(lShooterTalon, rShooterTalon);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new ShooterArcade());
    }
    
    public void shooterArcade(double speed){
    	shooter.arcadeDrive(speed, 0);
    }
}

