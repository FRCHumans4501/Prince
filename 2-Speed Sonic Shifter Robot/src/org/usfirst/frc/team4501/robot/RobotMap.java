package org.usfirst.frc.team4501.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int LEFTMOTOR = 0, RIGHTMOTOR = 1;

	public static final int LEFTSHOOTERMOTOR = 3, RIGHTSHOOTERMOTOR = 2;

	public static class Solenoids {
		public static final int HIGHGEAR = 2, LOWGEAR =
				3, GOINGUP = 0, GOINDOWN = 1, SHOOTER_EX = 4,
			SHOOTER_RT = 5;
	}

	public static class Encoders {
		public static final int L_A = 2, L_B = 3, // Left
				R_A = 0, R_B = 1; // Right
	}
	
	public static final int GYRO=6;
	
	
	
		//public static final int GYROBASE=7;

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
