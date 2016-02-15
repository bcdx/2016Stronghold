
package org.usfirst.frc.team4856.robot;

import java.io.IOException; //from newer GRIP code

import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team4856.robot.commands.Autonomous;
import org.usfirst.frc.team4856.robot.commands.TankDriveWithJoysticks;
import org.usfirst.frc.team4856.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4856.robot.subsystems.Elevator;
import org.usfirst.frc.team4856.robot.subsystems.ElevatorWithoutPot;
import org.usfirst.frc.team4856.robot.subsystems.Grabber;

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
	public static Elevator elevator;
	public static ElevatorWithoutPot elevatorwithoutpot;
	public static Grabber grabber;
	public static Command autonomousCommand;

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
    public void robotInit() {
		elevator = new Elevator();
		elevatorwithoutpot = new ElevatorWithoutPot();
		chassis = new DriveTrain();
		grabber = new Grabber();
		oi = new OI();
		autonomousCommand = new Autonomous(); }
		
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

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
       autonomousCommand.cancel();
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
         
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
