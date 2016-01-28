package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.RobotMap;
import org.usfirst.frc.team4501.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
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

	public enum ShifterState{
		SF_HIGH, SF_LOW;
	}
	
	RobotDrive drive;
	
	
	
	Talon rightTalon;
	Talon leftTalon;
	
	DoubleSolenoid shifter;
	ShifterState state; 
	
	Encoder L_Encoder;
	Encoder R_Encoder;
	ADXL362 rioAccel;
	ADXRS450_Gyro rioGyro;
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public DriveTrain(){
		this.leftTalon = new Talon(RobotMap.LEFTMOTOR);
		this.rightTalon = new Talon(RobotMap.RIGHTMOTOR);
		
		this.drive = new RobotDrive(leftTalon, rightTalon);
		this.shifter = new DoubleSolenoid(RobotMap.SOLENOID_HIGHGEAR, RobotMap.SOLENOID_LOWGEAR);
		
		this.rioGyro = new ADXRS450_Gyro();
		
		this.L_Encoder = new Encoder(RobotMap.Encoders.L_A, RobotMap.Encoders.L_B);
		this.R_Encoder = new Encoder(RobotMap.Encoders.R_A, RobotMap.Encoders.R_B);
		
	
    }
    
    public void initDefaultCommand(){
    	setDefaultCommand(new DriveArcade());
    }
    
    public void arcadeDrive(double forward, double rotate){
    	drive.arcadeDrive(forward, rotate);
    }
    
    public void initGyro(){
    	rioGyro.calibrate();
    	rioGyro.reset();
    }
    
    public void sensorReset(){
    	rioGyro.reset();
    	L_Encoder.reset();
    	R_Encoder.reset();
    }
    

    public void getSensors(){
    	long gyroAngle = Math.round(rioGyro.getAngle());
    	SmartDashboard.putNumber("Gyro Angle", gyroAngle);
    	SmartDashboard.putNumber("Gyro Rate", rioGyro.getRate());
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
    
 
    


