package org.usfirst.frc.team4856.robot;
import edu.wpi.first.wpilibj.Relay;
//import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;





//import org.usfirst.frc.team4856.robot.commands.SpikeOn;

import org.usfirst.frc.team4856.robot.commands.BackwardShooter;
//import org.usfirst.frc.team4856.robot.commands.Extend;
import org.usfirst.frc.team4856.robot.commands.SetAngleManually;

import org.usfirst.frc.team4856.robot.commands.ForwardShooter;
import org.usfirst.frc.team4856.robot.commands.Push;
import org.usfirst.frc.team4856.robot.commands.ScaleUp;
import org.usfirst.frc.team4856.robot.commands.ScaleDown ;

//import org.usfirst.frc.team4856.robot.commands.TankDriveWithJoysticks;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//declares variables of Joystick type (i.e. lefStick is an instance of Joystick.)
	//0, 1, and 2 refer to USB ports
	//uses leftStick and rightStick for tank drive and elevatorStick to control the elevator
	// public Joystick leftStick = new Joystick(0);
	// public Joystick rightStick = new Joystick(1);
	 public Joystick shooterStick = new Joystick(2); 

	 //public OI() is a constructor of the OI class (defines/intializes the OI class)
	public OI() {
	 JoystickButton pickUp = new JoystickButton(shooterStick,3);
	 JoystickButton shoot = new JoystickButton(shooterStick,4);
	 JoystickButton push = new JoystickButton (shooterStick, 2);
	 JoystickButton scaleUp = new JoystickButton(shooterStick,5);
	 JoystickButton scaleDown = new JoystickButton (shooterStick, 6);
	 
//	 JoystickButton pushBall = new JoystickButton(shooterStick, 5);
	// JoystickButton retreatPusher = new JoystickButton(shooterStick, 6);
	 //JoystickButton extend = new JoystickButton (shooterStick, 6);
	 //JoystickButton retract = new JoystickButton (shooterStick, 7); 
	
	 //(e.g. when the up button is held, the program runs the LiftElevator command)
	 pickUp.whileHeld(new BackwardShooter());
	 shoot.whileHeld(new ForwardShooter());
	// moveShooter.whenPressed(new SetAngleManually());
	 push.whileHeld(new Push());
	 scaleUp.whileHeld(new ScaleUp());
	 scaleDown.whileHeld(new ScaleDown());
//	 retreatPusher.whileHeld(new Pull());
	 /*extend.whileHeld(new Extend());
	 retract.whileHeld(new Retract());
	 push.whenPressed(new Push());
	 push.whenReleased(new Pull());*/
	 
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

