package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.RobotMap;
import org.usfirst.frc.team4501.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	public enum ShifterState{
		SF_HIGH, SF_LOW;
	}
	
	RobotDrive drive;
	
	Talon rightTalon;
	Talon leftTalon;
	
	DoubleSolenoid shifter;
	ShifterState state;
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public DriveTrain(){
		this.leftTalon = new Talon(RobotMap.LEFTMOTOR);
		this.rightTalon = new Talon(RobotMap.RIGHTMOTOR);
		
		this.drive = new RobotDrive(leftTalon, rightTalon);
		this.shifter = new DoubleSolenoid(RobotMap.SOLENOID_HIGHGEAR, RobotMap.SOLENOID_LOWGEAR);
    }
    
    public void initDefaultCommand(){
    	setDefaultCommand(new DriveArcade());
    }
    
    public void arcadeDrive(double forward, double rotate){
    	drive.arcadeDrive(forward, rotate);
    }
    
    public void highGear() {
    	shifter.set(Value.kReverse);
    	state = ShifterState.SF_HIGH;
    }
    
    public void lowGear() {
    	shifter.set(Value.kForward);
    	state = ShifterState.SF_LOW;
    }
    
    public void set(ShifterState state) {
    	switch (state) {
    	case SF_HIGH:
    		this.highGear();
    		break;
    		
    	case SF_LOW:
    		this.lowGear();
    		break;
    	}
    }
    public ShifterState getState() {
    	return state;
    }
}

