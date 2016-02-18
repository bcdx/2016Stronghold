
package org.usfirst.frc.team4856.robot;

import java.io.IOException; //from newer GRIP code

import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team4856.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4856.robot.subsystems.Pusher;
//import org.usfirst.frc.team4856.robot.subsystems.Scaler;
import org.usfirst.frc.team4856.robot.subsystems.Shooter;

/**
 * The VM (virtual machine) is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	//NetworkTable table; // older GRIP code
	/**
	 * Declaration of variables. (e.g., chassis is an instance of DriveTrain)
	 */
	public static DriveTrain chassis;
	public static OI oi;
	
	
	public static Shooter shooter;
	//public static Scaler scaler;
	public static Pusher pusher;
	public static Command autonomousCommand;
	
	CANTalon left1 = new CANTalon(0);
	CANTalon left2 = new CANTalon (1);
	CANTalon right1 = new CANTalon (2);
	CANTalon right2 = new CANTalon (3);
	//Victor scalerMotor = new Victor (5);
	
	Joystick leftStick = new Joystick(0);
	Joystick rightStick = new Joystick(1);
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    // instantiate the command used for the autonomous period
    //autonomousCommand = new ExampleCommand();
	//oi MUST be last so the program knows where to look for the correct methods
   // public Robot (){
    	//table = NetworkTable.getTable("GRIP/myContoursReport");
    //} //older GRIP code
    
    //private final NetworkTable grip = NetworkTable.getTable("grip"); //newer GRIP code
    
    @Override //newer GRIP code
		
		/* //START of newer GRIP code:
		try {
			new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		} */ //END of newer GRIP code
		
		//START of older GRIP code:
		/*double[] defaultValue = new double[0];
		double angle = 0;
		while (true) {
			double[] widths = table.getNumberArray("width", defaultValue);
			for (double width : widths) {
				double distance = -0.000002*width*width*width*width+0.000277*width*width*width-0.011785*width*width-0.019093*width+10.0866;
				//converting from pixels to meters
				angle = 0.052*distance*distance*distance*distance-1.03*distance*distance*distance+8.49*distance*distance-37.29*distance+93.64;
				//find angle from distance (using regression if v0 = 30)
			}
			System.out.print("widths: ");
			for (double width : widths) {
				System.out.print(width + " ");
			}
			System.out.print(angle);
			System.out.println();
			Timer.delay(1);
		} //END of older GRIP code
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousInit() {
        // schedule the autonomous command (example)
    	//if (the autonomousCommand does not return a null set (is not teleop), then run the autonomousCommand
    	  autonomousCommand.start();
    }

    @Override //newer GRIP code
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        /*
    //START of newer GRIP code:
        // Get published values from GRIP using NetworkTables
        double angle = 0;
        for (double width : grip.getNumberArray("targets/width", new double[0])) {
        	double distance = -0.000002*width*width*width*width+0.000277*width*width*width-0.011785*width*width-0.019093*width+10.0866;
			//converting from pixels to meters
        	
			angle = 0.052*distance*distance*distance*distance-1.03*distance*distance*distance+8.49*distance*distance-37.29*distance+93.64;
			//find angle from distance (using regression if v0 = 30)
			
			System.out.println("Got contour with width=" + width);
			System.out.print(angle);
			
		} //END of newer GRIP code
		*/
    }
    
    public void robotInit(){
    	shooter = new Shooter();
		oi = new OI ();
		
		double angle = 0;
    	while (true){
    		double width = 36.0;
    		double distance = 0;
    		
    		distance = -0.000002*width*width*width*width+0.000277*width*width*width-0.011785*width*width-0.019093*width+10.0866;
    		angle = 0.052*distance*distance*distance*distance-1.03*distance*distance*distance+8.49*distance*distance-37.29*distance+93.64;
    		
    		System.out.println("width: " + width);
    		System.out.println("distance: " + distance);
    		System.out.println("angle: " + angle);
    	}
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
       //autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        double leftAxis = leftStick.getY();
		left1.set(-1*leftAxis);
		
		left2.changeControlMode(CANTalon.TalonControlMode.Follower);
		left2.set(left1.getDeviceID());
		
		double rightAxis = rightStick.getY();
		right1.set(rightAxis);
		
		right2.changeControlMode(CANTalon.TalonControlMode.Follower);
		right2.set(right1.getDeviceID());
         
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
