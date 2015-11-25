package org.usfirst.frc.team435.robot.subsystems;

import org.usfirst.frc.team435.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    public void drive(double x, double y, double rot){
    	RobotMap.drive.mecanumDrive_Cartesian(x, y, rot, 0);
    }

    public void initDefaultCommand() {}
}