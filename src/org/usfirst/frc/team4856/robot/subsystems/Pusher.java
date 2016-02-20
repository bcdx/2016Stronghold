package org.usfirst.frc.team4856.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pusher extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController pusherMotor;
	
	public Pusher () {
		super();                                                                                                                                                                                      
		pusherMotor = new Victor (6);
	}
	
	public void push() {
		   pusherMotor.set(1);
	   }
	 
		
//	   public void pull() {
//		   pusherMotor.set(-1);
//		}
	   
	   public void stop() {
	   		pusherMotor.set(0);
	   }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

