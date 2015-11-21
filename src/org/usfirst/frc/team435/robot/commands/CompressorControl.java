package org.usfirst.frc.team435.robot.commands;

import org.usfirst.frc.team435.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CompressorControl extends Command {

	private boolean on;
	
    public CompressorControl(boolean on) {
    	this.on = on;
    }
    
    protected void initialize() {
    	if(on){
    		RobotMap.compressor.start();
    	} else {
    		RobotMap.compressor.stop();
    	}
    }
    protected void execute() {}
    protected boolean isFinished() {
        return true;
    }
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
