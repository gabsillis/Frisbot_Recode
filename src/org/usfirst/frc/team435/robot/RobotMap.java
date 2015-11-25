package org.usfirst.frc.team435.robot;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int FRONT_SHOOTER 				= 5;
    public static final int REAR_SHOOTER 				= 6;
    public static final int SHOOTER_SOLENOID_FORWARD 	= 0; // If the solenoid sits forward and retracts
    public static final int SHOOTER_SOLENOID_REVERSE 	= 1; // with a trigger pull switch these
    
    public static final int FRONT_LEFT_MOTOR 			= 1;
    public static final int REAR_LEFT_MOTOR 			= 2;
    public static final int FRONT_RIGHT_MOTOR 			= 3;
    public static final int REAR_RIGHT_MOTOR 			= 4;
    
    public static SpeedController frontShooter = new CANJaguar(FRONT_SHOOTER);
    public static SpeedController rearShooter = new CANJaguar(REAR_SHOOTER);
    
    public static Compressor compressor = new Compressor();
    public static DoubleSolenoid solenoid = new DoubleSolenoid(SHOOTER_SOLENOID_FORWARD, SHOOTER_SOLENOID_REVERSE);
    
    public static SpeedController frontLeftMotor = new CANJaguar(FRONT_LEFT_MOTOR);
    public static SpeedController rearLeftMotor = new CANJaguar(REAR_LEFT_MOTOR);
    public static SpeedController frontRightMotor = new CANJaguar(FRONT_RIGHT_MOTOR);
    public static SpeedController rearRightMotor = new CANJaguar(REAR_RIGHT_MOTOR);
    
    public static RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
}
