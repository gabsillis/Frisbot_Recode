package org.usfirst.frc.team435.robot.subsystems;

import org.usfirst.frc.team435.robot.Robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDString extends Subsystem {
	
	public static final int DATA_SIZE = 3;
	public static final int SHOOTER_ACTIVE_INDEX = 0;
	public static final int SHOOTER_SPEED_INDEX = 1;
	public static final int SHOOTING_INDEX = 2;
	
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
    	i2c.writeBulk(data);
    }
}

