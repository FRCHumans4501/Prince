package org.usfirst.frc.team4501.robot;
import edu.wpi.first.wpilibj.Joystick;

public class XboxController extends Joystick {
	
	public class ControllerCoordinates {
		public double x, y;
		
		public ControllerCoordinates(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// Trigger Types
	public enum Trigger {
		LEFT, RIGHT
	}
	
	// Deadzone
	public static final double DEADZONE = 0.275;

	// Stick Maps
	public static final int STICK_LX = 0, STICK_LY = 1,
			TRIGGER_L = 2, TRIGGER_R = 3,
			STICK_RX = 4, STICK_RY = 5;

	// Button Maps
	public static final int BUTTON_A = 1, BUTTON_B = 2, BUTTON_X = 3,
			BUTTON_Y = 4, BUMPER_R = 5, BUMPER_L = 6, BUTTON_BACK = 7,
			BUTTON_START = 8, BUTTON_STICKL = 9, BUTTON_STICKR = 10;
	
	public XboxController(int port) {
		super(port);
	}
	
	public ControllerCoordinates processDeadzone(ControllerCoordinates coords, double deadzone) {
		double x = coords.x;
		double y = coords.y;
		double magnetude = Math.sqrt(x*x + y*y);
		double angle = Math.atan2(y, x);
		
		if (deadzone > 1) deadzone = 1;
		if (deadzone < 0) deadzone = 0;
		
		if (magnetude > deadzone) {
			magnetude = (magnetude - deadzone) / (1.0 - deadzone);
			x = magnetude * Math.cos(angle);
			y = magnetude * Math.sin(angle);
		} else {
			x = 0;
			y = 0;
		}
		
		return new ControllerCoordinates(x, y);
	}
	
	public ControllerCoordinates getCurrrentCoordiantes(Hand hand) {
		if (hand == Hand.kLeft) {
			return new ControllerCoordinates(this.getRawAxis(STICK_LX), this.getRawAxis(STICK_LY));
		} else {
			return new ControllerCoordinates(this.getRawAxis(STICK_RX), this.getRawAxis(STICK_RY));
		}
	}
	
	public double getRawTrigger(Trigger trigger) {
		if (trigger == Trigger.LEFT) {
			return this.getRawAxis(TRIGGER_L);
		} else {
			return this.getRawAxis(TRIGGER_R);
		}
	}

}
