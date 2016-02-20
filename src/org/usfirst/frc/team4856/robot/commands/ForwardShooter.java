package org.usfirst.frc.team4856.robot.commands;

import org.usfirst.frc.team4856.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ForwardShooter extends Command {

    public ForwardShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    	setTimeout(0.01);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("start shoot");
    	Robot.shooter.shoot();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
   

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.stop();
    	//Robot.grabber.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
