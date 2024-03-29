package org.usfirst.frc.team435.robot.commands;

import org.usfirst.frc.team435.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterControl extends Command {

	ShooterDirection direction;
	
    public ShooterControl(ShooterDirection direction) {
        requires(Robot.shooter);
        setTimeout(.5);
        setInterruptible(false);
        this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	switch(direction){
			case FORWARD:
				Robot.shooter.extendPiston();
			break;
			case REVERSE:
				Robot.shooter.retractPiston();
			break;
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
