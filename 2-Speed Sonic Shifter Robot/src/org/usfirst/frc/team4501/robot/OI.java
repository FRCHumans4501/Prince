package org.usfirst.frc.team4501.robot;

import org.usfirst.frc.team4501.robot.commands.*;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	XboxController controller = new XboxController(0);
	Joystick shooter = new Joystick(1);
	
	Button shiftHigh = new JoystickButton(controller, controller.BUTTON_A);
	Button shiftLow = new JoystickButton(controller, controller.BUTTON_B);
	Button ShooterStart = new JoystickButton(shooter, 1);
	
	public OI() {
		//Shifting
		shiftHigh.whenPressed(new ShiftUp());
		shiftLow.whenPressed(new ShiftDown());
		
		//Shooter
		ShooterStart.whenPressed(new ShooterArcade());
		ShooterStart.whenReleased(new ShooterIdle());
		
	}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	
	public double getLeftXboxX() {
		return controller.getX(Hand.kLeft);
	}
	
	public double getLeftXboxY() {
		return controller.getY(Hand.kLeft);
	}

	public double getRightXboxX() {
		return controller.getX(Hand.kRight);
	}
	
	public double getRightXboxY() {
		return controller.getY(Hand.kRight);
	}
	
	public double getShooterX() {
		return shooter.getX();
	}
	
	public double getShooterY() {
		return shooter.getY();
	}
	
	public double getShooterThrottle() {
		return shooter.getZ();
	}
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

