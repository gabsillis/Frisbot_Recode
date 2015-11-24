package org.usfirst.frc.team435.robot.subsystems;

import org.usfirst.frc.team435.robot.OI;
import org.usfirst.frc.team435.robot.Robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDString extends Subsystem {
	
	public static final int DATA_SIZE = 4;
	public static final int SHOOTER_ACTIVE_INDEX = 0;
	public static final int SHOOTER_SPEED_INDEX = 1;
	public static final int SHOOTING_INDEX = 2;
	public static final int EASTER_EGG_INDEX = 3;
	
    I2C i2c;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {}
    
    public LEDString(){
    	i2c = new I2C(Port.kMXP, 168);
    }
    
    public void sendData(){
    	byte[] data = new byte[DATA_SIZE];
    	if(Robot.shooter.isActive()) data[SHOOTER_ACTIVE_INDEX] = 1;
    	else data[SHOOTER_ACTIVE_INDEX] = 0;
    	data[SHOOTER_SPEED_INDEX] = ((byte)((Robot.shooter.getSpeed() * 256) - 127));
    	if(Robot.shooter.isPistonExtended()) data[SHOOTING_INDEX] = 1;
    	else data[SHOOTING_INDEX] = 0;
    	if(OI.driveStick.getRawButton(4) && OI.driveStick.getRawButton(3) && OI.driveStick.getRawButton(5)) data[EASTER_EGG_INDEX] = 1;
    	else data[EASTER_EGG_INDEX] = 0;
    	i2c.writeBulk(data);
    }
}

