package org.usfirst.frc.team4856.robot.subsystems;


//import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team4856.robot.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Talon;


import org.usfirst.frc.team4856.robot.Robot;
import org.usfirst.frc.team4856.robot.commands.TankDriveWithJoysticks;

/**
 *
 */
public class Shooter extends PIDSubsystem {
	private DigitalInput insideContact;
    private DigitalInput outsideContact;
  
    
    

// Subsystem is the parent class of DriveTrain.
// Though inheritance, DriveTrain inherits all the traits of the class Subsystem, and will have any new traits we assign to it.
	
	private SpeedController shooterMotor;
	private SpeedController angleMotor;
	private static final double Kp = -2; //Kp = proportional (present error values), in response to diff between observed + setpoint
    private static final double Ki = 0.0; //Ki = integral(past error values), looks at past info + determines level to achieve stability
    private static final double Kd =0.0; //Kd = differential (future error values), looks at future outcome + adjusts rate of change to compensate
    public static final double value = 3.5,
            value2 = 1.75; //set values?
    AnalogPotentiometer pot = new AnalogPotentiometer(0, 360, 30);
    
 // Subsystem is the parent class of DriveTrain.
 // Though inheritance, DriveTrain inherits all the traits of the class Subsystem, and will have any new traits we assign to it.
     
     //private SpeedController grabberMotor;


	
	public Shooter () {
		//super();
		super("Shooter", Kp, Ki, Kd);
        pot = new AnalogPotentiometer(0, 90, 0); //(0,270,-135) -135 < x < 135
        AnalogInput ai = new AnalogInput(1);
        pot = new AnalogPotentiometer(ai, 90, 0);
       
        setSetpoint(value);
        enable();
		shooterMotor = new Victor (3);//grabberMotor runs the grabber 
		insideContact = new DigitalInput(3);
	    outsideContact = new DigitalInput(5);
	    angleMotor = new Victor (4);
	    
	    /*pot = new AnalogPotentiometer(0, 360, 30);
	    AnalogInput ai = new AnalogInput(1);
	    pot = new AnalogPotentiometer(ai, 360, 30);
	    double degrees = pot.get();*/
	    
        LiveWindow.addActuator("insideContact", "LimitSwitch", insideContact);
        LiveWindow.addActuator("outsideContact", "LimitSwitch", outsideContact);
	
	}
    
    // Put methods for controlling this subsystem here. Call these from Commands.

    public void initDefaultCommand() {
    	//setDefaultCommand(new OpenGrabber());
  //when no other command is running, the default command is tankdrivewithjoystick. Consult the command TankDriveWithJoystick for more info.

    	
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        double degrees = pot.get();
        return degrees;
        }

        protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        }

    public void pickUp() {
    	shooterMotor.set(0.62);//picking up the ball - check whether speed should be positive or negative
    }
    
	public void shoot() {
	    shooterMotor.set(-0.99);//shooting
	}
	
	
    public void stop() {
    	shooterMotor.set(0);
    	angleMotor.set(0);
		

    }
    
    public void setAngleManually(Joystick shooterStick){
    	angleMotor.set(shooterStick.getY());
    	
    }
    
    /*public void setAngleManually(double speed) {
    	angleMotor.set(speed);
    }
    */
    
   /* public boolean isFullyClosed() {
    	//return false;
    	return !insideContact.get();
    } 
    
    public boolean isFullyOpen() {
    	//return false;
    	return !outsideContact.get();
    }
    
   */ 
    
	
}