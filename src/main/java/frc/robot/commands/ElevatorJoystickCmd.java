// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ElevaterSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class ElevatorJoystickCmd extends CommandBase {
 
 // we want to use the parallel subsystem that we have created but we also want only one intance per command
private  ElevaterSubsystem elevaterSubsystem;
//speed of the motors
  private double speed; 
 
  public ElevatorJoystickCmd(ElevaterSubsystem elevaterSubsystem, double speed) {
   this.elevaterSubsystem = elevaterSubsystem;
   this.speed = speed;
   //all commands that use the elevater subsystem should wait for this command to finish
   addRequirements(elevaterSubsystem);
  }

  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    elevaterSubsystem.setMotor(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevaterSubsystem.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
