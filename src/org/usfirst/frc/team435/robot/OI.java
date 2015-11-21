package org.usfirst.frc.team435.robot;

import org.usfirst.frc.team435.robot.commands.CompressorControl;
import org.usfirst.frc.team435.robot.commands.ShooterControl;
import org.usfirst.frc.team435.robot.commands.ShooterDirection;
import org.usfirst.frc.team435.robot.commands.ShooterSpeedControl;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static final int DRIVE_STICK_PORT 			= 0;
    
    public static final int SMO_STICK_PORT 				= 1;
    public static final int SHOOT_BUTTON_ID				= 1;
    public static final int COMPRESSOR_ON_BUTTON_ID		= 2;
    public static final int COMPRESSOR_OFF_BUTTON_ID	= 3;
    public static final int WHEELS_ON_BUTTON_ID			= 4;
    public static final int WHEELS_OFF_BUTTON_ID		= 5;
    
    public static Joystick driveStick = new Joystick(DRIVE_STICK_PORT);
    
    public static Joystick smoStick = new Joystick(DRIVE_STICK_PORT);
    public static JoystickButton shootButton = new JoystickButton(smoStick, SHOOT_BUTTON_ID);
    public static JoystickButton compressorOnButton = new JoystickButton(smoStick, COMPRESSOR_ON_BUTTON_ID);
    public static JoystickButton compressorOffButton = new JoystickButton(smoStick, COMPRESSOR_OFF_BUTTON_ID);
    public static JoystickButton wheelsOnButton = new JoystickButton(smoStick, WHEELS_ON_BUTTON_ID);
    public static JoystickButton wheelsOffButton = new JoystickButton(smoStick, WHEELS_OFF_BUTTON_ID);
    
    public OI(){
    	shootButton.whenPressed(new ShooterControl(ShooterDirection.FORWARD));
    	shootButton.whenReleased(new ShooterControl(ShooterDirection.REVERSE));
    	wheelsOnButton.whenPressed(new ShooterSpeedControl(Robot.shooter.getSpeed()));
    	wheelsOffButton.whenPressed(new ShooterSpeedControl(0));
    	compressorOnButton.whenPressed(new CompressorControl(true));
    	compressorOffButton.whenPressed(new CompressorControl(false));
    }
}

