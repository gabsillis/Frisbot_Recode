package org.usfirst.frc.team435.robot.subsystems;

import org.usfirst.frc.team435.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	
	private double speed = 0;
	private boolean active = false;
	private boolean pistonExtended;
	
	/**
	 * Returns the state of the wheels in the shooter
	 * 
	 * @return True if the wheels are spinning
	 */
	public boolean isActive() {
		return active;
	}
	
	public void setShooterSpeed(double speed) {
		if (speed == 0)
			stopShooter();
		else {
			RobotMap.frontShooter.set(speed);
			RobotMap.rearShooter.set(speed);
			this.speed = speed;
			active = true;
		}
	}
	
	public void stopShooter() {
		active = false;
		RobotMap.frontShooter.set(0);
		RobotMap.rearShooter.set(0);
		speed = 0;
	}
	
	public void extendPiston(){
		RobotMap.solenoid.set(Value.kForward);
		pistonExtended = true;
	}
	
	public void retractPiston(){
		RobotMap.solenoid.set(Value.kReverse);
		pistonExtended = false;
	}
	
	public boolean isPistonExtended(){
		return pistonExtended;
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public Shooter(){
		retractPiston();
	}
	
	public void update(){
		setShooterSpeed(speed);
	}
	
	public void initDefaultCommand() {}
}
