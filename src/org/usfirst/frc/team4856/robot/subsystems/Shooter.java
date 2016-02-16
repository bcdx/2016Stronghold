package org.usfirst.frc.team4856.robot.subsystems;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;


import org.usfirst.frc.team4856.robot.Robot;
//import org.usfirst.frc.team4856.robot.commands.TankDriveWithJoystick;
/**
 *
 */
public class Shooter extends PIDSubsystem {
    
    private static final double Kp = -2; //Kp = proportional (present error values), in response to diff between observed + setpoint
    private static final double Ki = 0.0; //Ki = integral(past error values), looks at past info + determines level to achieve stability
    private static final double Kd =0.0; //Kd = differential (future error values), looks at future outcome + adjusts rate of change to compensate
   
    public static final double value = 3.5,
            value2 = 1.75; //set values?
    
    CANTalon talon1 = new CANTalon(0);
 
    //CANTalon talon2 = new CANTalon(1);
    //CANTalon talon3 = new CANTalon(2);
    //CANTalon talon4 = new CANTalon(3);
    //CANTalon talon5 = new CANTalon(4);

    AnalogPotentiometer pot = new AnalogPotentiometer(0, 360, 30);
    
// Subsystem is the parent class of DriveTrain.
// Though inheritance, DriveTrain inherits all the traits of the class Subsystem, and will have any new traits we assign to it.
    
    private SpeedController shooterMotor;
    private SpeedController angleMotor; 
    
    public Shooter() {
        super("Shooter", Kp, Ki, Kd);
       //(0,270,-135) -135 < x < 135
        AnalogInput ai = new AnalogInput(1);
        pot = new AnalogPotentiometer(ai, 90, 0);
        
        shooterMotor = new Victor (3);
        angleMotor = new Victor (4);
        
        setSetpoint(value);
        enable();
    }
    
    // Put methods for controlling this subsystem here. Call these from Commands.

    public void initDefaultCommand() {
        
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void pickUp(){
    	shooterMotor.set(0.58); //picking up the ball - check whether speed should be positive or negative
    }
    
    public void shoot(){
    	shooterMotor.set(-0.99); //shooting 
    }
    
    public void stop() {
       shooterMotor.set(0);
       angleMotor.set(0);
    }
    
    public void setAngle (Joystick stick){
    	double speed = stick.getY();
    	angleMotor.set(speed);
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
}

