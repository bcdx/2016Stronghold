package org.usfirst.frc.team4856.robot.commands;
import org.usfirst.frc.team4856.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousWithShoot extends CommandGroup {
	CANTalon left1= new CANTalon(0);
	CANTalon left2= new CANTalon(1);
	CANTalon right1= new CANTalon(2);
	CANTalon right2= new CANTalon(3);
	
    public  AutonomousWithShoot() {
//    	requires(Robot.shooter);
//    	requires(Robot.pusher);
    	// Use requires() here to declare subsystem dependencies
    	Scheduler.getInstance().run();
        //drives forward for certain amount of time
//   	 long t= System.currentTimeMillis();
//   	 long end = t+5000;
//   	 while(System.currentTimeMillis() < end){
   		 	left1.set(0.45);
            left2.changeControlMode(CANTalon.TalonControlMode.Follower);
            left2.set(left1.getDeviceID());
            right1.set(-0.5);
            right2.changeControlMode(CANTalon.TalonControlMode.Follower);
            right2.set(right1.getDeviceID()); 
//   	 	}   
            
            left1.setSafetyEnabled(true); //hopefully will stop motors after 3 sec 2/26 AT
            right1.setSafetyEnabled(true);
            left1.setExpiration(3.0);
            left1.set(0);
            right1.setExpiration(3.0);
            right1.set(0);
            
            Robot.shooter.shoot();
        	Timer.delay(3);
        	Robot.pusher.push();
        	Timer.delay(2);
        	Robot.shooter.stop();
        	Robot.pusher.stop();
            
            
          
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

