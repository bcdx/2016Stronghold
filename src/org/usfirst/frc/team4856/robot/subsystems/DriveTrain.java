package org.usfirst.frc.team4856.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick.AxisType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;


//USELESS CAN DELETE
/**
 *
 */
public class DriveTrain extends Subsystem {
	

// Subsystem is the parent class of DriveTrain.
// Though inheritance, DriveTrain inherits all the traits of the class Subsystem, and will have any new traits we assign to it.
	
	
	//private RobotDrive chassis;

	//private Encoder testEnc;
	
	public DriveTrain () {
		super();

	}
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

   public void initDefaultCommand() {
    	//setDefaultCommand(new TankDriveWithJoysticks());
  //when no other command is running, the default command is tankdrivewithjoystick. Consult the command TankDriveWithJoystick for more info.
    
    	
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /*public void drive(double left1, double right1) {
		chassis.tankDrive(0.8*left1, 0.8*right1); //tankDrive has already been defined in RobotDrive
		
//left and right are dummy variables that stand in for the values that we will define in the following section:
	}
    public void drive(Joystick leftStick, Joystick rightStick) {
		drive(leftStick.getY(), rightStick.getY());
//the value for the left wheels will be controlled by the y value of the left joystick. Same for the right joystick.
	}*/
}