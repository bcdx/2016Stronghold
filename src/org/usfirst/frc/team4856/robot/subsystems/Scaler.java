package org.usfirst.frc.team4856.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
// */
public class Scaler extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
		private SpeedController scalerMotor;
		
	public Scaler () {
		super();                                                                                                                                                                                      
		scalerMotor = new Victor (5);
		
	}
	
   public void extend() {
	   scalerMotor.set(1);
   }
 
	
   public void retract () {
	   scalerMotor.set(-1);
	}
   
   public void stop() {
   		scalerMotor.set(0);
   }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


