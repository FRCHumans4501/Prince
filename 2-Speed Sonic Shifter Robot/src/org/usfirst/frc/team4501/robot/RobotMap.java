package org.usfirst.frc.team4501.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int LEFTMOTOR = 0, RIGHTMOTOR = 1;
	
	public static final int SOLENOID_HIGHGEAR = 0, SOLENOID_LOWGEAR = 1;
	
	public static final int GYRO = 0;
	
	public static class Encoders {
		public static final int 
				ENCODER_RL_A = 2, ENCODER_RL_B = 3, // Rear Left
				ENCODER_RR_A = 4, ENCODER_RR_B = 5, // Rear Right
				ENCODER_FL_A = 6, ENCODER_FL_B = 7, // Front Left
				ENCODER_FR_A = 8, ENCODER_FR_B = 9; // Front Right
	}
	
	
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
