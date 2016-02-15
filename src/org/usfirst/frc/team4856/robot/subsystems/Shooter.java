package org.usfirst.frc.team4856.robot.subsystems;

//import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

import org.usfirst.frc.team4856.robot.Robot;
//import org.usfirst.frc.team4856.robot.commands.TankDriveWithJoystick;
/**
 *
 */
public class Shooter extends Subsystem {
	private DigitalInput insideContact;
    private DigitalInput outsideContact;
   
    CANTalon talon1 = new CANTalon(0);
    //CANTalon talon2 = new CANTalon(1);
    //CANTalon talon3 = new CANTalon(2);
    //CANTalon talon4 = new CANTalon(3);
    //CANTalon talon5 = new CANTalon(4);

    //public Relay spike = new Relay(0);
    //AnalogPotentiometer pot = new AnalogPotentiometer(0, 360, 30);
    

// Subsystem is the parent class of DriveTrain.
// Though inheritance, DriveTrain inherits all the traits of the class Subsystem, and will have any new traits we assign to it.
	
	//private SpeedController grabberMotor;
	
	public Shooter () {
		super();                                                                                                                                                                                      
		//grabberMotor = new Victor (4);//grabberMotor runs the grabber 
		insideContact = new DigitalInput(3);
	    outsideContact = new DigitalInput(5);
	    
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
    public void open() {
    	if(isFullyOpen()){
    		stop();
    	} else {
    	    //grabberMotor.set(0.62);//picking up the ball
    		talon1.set(-0.5);
    		//talon2.set(-1.0);
    		//talon3.set(-1.0);
    		//talon4.set(-1.0);
    		//talon5.set(-1.0);

    	}
    	
    	
    }
    
	public void close() {
	    if(isFullyClosed()){
	    	stop(); //why are you doing this to us
	    } else {
	    	//grabberMotor.set(-0.99);//shooting
	    	talon1.set(0.5);
    		//talon2.set(1.0);
    		//talon3.set(1.0);
    		//talon4.set(1.0);
    		//talon5.set(1.0);
	    }
	    	
	}
	
	
    public void stop() {
    	//grabberMotor.set(0);
		//testTalon.set(0);

    }
    
   /* public void spikeOn(){ 
    	long t= System.currentTimeMillis();
    	long end = t+3000;
    	while(System.currentTimeMillis() < end) {
        	spike.set(Relay.Value.kForward);
    	}
    	
    } */
  
    
    public boolean isFullyClosed() {
    	//return false;
    	return !insideContact.get();
    } 
    
    public boolean isFullyOpen() {
    	//return false;
    	return !outsideContact.get();
    }
    
    
    
	
}