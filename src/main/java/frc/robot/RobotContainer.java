// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// i know its with an o and not an e
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.DriveForwardCmd;
//import subsystem
import frc.robot.commands.ElevatorJoystickCmd;
import frc.robot.commands.ElevatorPIDCmd;
import frc.robot.commands.IntakeSetCmd;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ElevaterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;



public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ElevaterSubsystem elevatorSubsystem = new ElevaterSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final Joystick joy = new Joystick(8);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    intakeSubsystem.setDefaultCommand(new IntakeSetCmd(intakeSubsystem, true));
    driveSubsystem.setDefaultCommand(new ArcadeDriveCmd(driveSubsystem, () -> -joy.getRawAxis(1), () -> joy.getRawAxis(3)));
        
    elevatorSubsystem.setDefaultCommand(new ElevatorJoystickCmd(elevatorSubsystem, 0));
    configureButtonBindings();
  }

 
   
  private void configureButtonBindings() {
    // gets the joystick and the button pressed
  
    new JoystickButton(joy, 1).whileActiveOnce(new ElevatorJoystickCmd(elevatorSubsystem, 0.5));
    new JoystickButton(joy, 2).whileActiveOnce(new ElevatorJoystickCmd(elevatorSubsystem, -0.5));
    new JoystickButton(joy, 3).whileActiveOnce(new ElevatorPIDCmd(elevatorSubsystem, 1.5));
    new JoystickButton(joy, 4).whileActiveOnce(new ElevatorPIDCmd(elevatorSubsystem, 0));
    new JoystickButton(joy, 5).whileActiveOnce(new IntakeSetCmd(intakeSubsystem, false));
  }

  
  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(new DriveForwardCmd(driveSubsystem, 1.5), 
    new ParallelCommandGroup(new IntakeSetCmd(intakeSubsystem, false) ,  new ElevatorPIDCmd(elevatorSubsystem, 1.5)));
    
  }
}
