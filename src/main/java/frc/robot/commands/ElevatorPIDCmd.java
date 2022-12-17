package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevaterSubsystem;

public class ElevatorPIDCmd extends CommandBase{

    private final ElevaterSubsystem elevatorSubsystem;
    private final PIDController pidController;
     
    public ElevatorPIDCmd(ElevaterSubsystem elevatorSubsystem, double setPoint){
     this.elevatorSubsystem = elevatorSubsystem;
     this.pidController = new PIDController(3, 0, 0.8);
     pidController.setSetpoint(setPoint);
     addRequirements(elevatorSubsystem);
    }
    @Override
    public void initialize() {
        System.out.println("ElevatorPIDCmd started!");
        pidController.reset();
    }
    @Override
    public void execute() {
        double speed = pidController.calculate(elevatorSubsystem.getEncoderFeet());
        elevatorSubsystem.setMotor(speed);
    }
    @Override
    public void end(boolean interrupted) {
        elevatorSubsystem.setMotor(0);
        System.out.println("ElevatorPIDCmd ended!");
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}
