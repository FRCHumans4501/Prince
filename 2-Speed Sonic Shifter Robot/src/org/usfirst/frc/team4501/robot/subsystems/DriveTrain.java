package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.RobotMap;
import org.usfirst.frc.team4501.robot.commands.DriveController;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

	protected enum ShifterState{
		SF_HIGH, SF_LOW;
	}
	
	RobotDrive drive;
	
	Talon rightTalon;
	Talon leftTalon;
	
	DoubleSolenoid shifter;
	protected ShifterState state; 
	
	Encoder L_Encoder;
	Encoder R_Encoder;
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public DriveTrain(){
		this.leftTalon = new Talon(RobotMap.LEFTMOTOR);
		this.rightTalon = new Talon(RobotMap.RIGHTMOTOR);
		
		this.drive = new RobotDrive(leftTalon, rightTalon);
		this.shifter = new DoubleSolenoid(RobotMap.SOLENOID_HIGHGEAR, RobotMap.SOLENOID_LOWGEAR);
		
		this.L_Encoder = new Encoder(RobotMap.Encoders.L_A, RobotMap.Encoders.L_B);
		this.R_Encoder = new Encoder(RobotMap.Encoders.R_A, RobotMap.Encoders.R_B);
		
		System.out.println("DriveTrain.DriveTrain() plz Halp");
    }
    
    public void initDefaultCommand(){
    	System.out.println("initDefaultCommand: Execute");
    	setDefaultCommand(DriveController.instance);
    }
    
    public void arcadeDrive(double forward, double reverse, double rotate){
    	double movement = forward - reverse;
    	drive.arcadeDrive(movement, rotate);
    }

    public void arcadeDrive(double forward, double rotate){
    	drive.arcadeDrive(forward, rotate);
    }
    
    public void tankDrive(double leftValue, double rightValue){
    	drive.tankDrive(leftValue, rightValue);
    }
    
    public void stopMotors(){
    	leftTalon.set(0);
    	rightTalon.set(0);
    }
    
    public void sensorReset(){
    	L_Encoder.reset();
    	R_Encoder.reset();
    	System.out.println("DriveTrain.sensorReset()");
    }
    

    public void getSensors(){
    	SmartDashboard.putNumber("Right Encoder Distance", -this.R_Encoder.getDistance());
    	SmartDashboard.putNumber("Left Encoder Distance", this.L_Encoder.getDistance());
    	SmartDashboard.putNumber("Right Encoder Rate", -this.R_Encoder.getRate());
    	SmartDashboard.putNumber("Left Encoder Rate", this.L_Encoder.getRate());
    	SmartDashboard.putNumber("Right Rotations", (-this.R_Encoder.getDistance()/2085));
    }
    
    public void highGear() {
    	shifter.set(Value.kReverse);
    	state = ShifterState.SF_HIGH;
    }
    
    public void lowGear() {
    	shifter.set(Value.kForward);
    	state = ShifterState.SF_LOW;
    }
    
    public void setGear(ShifterState state) {
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
    
 
    


