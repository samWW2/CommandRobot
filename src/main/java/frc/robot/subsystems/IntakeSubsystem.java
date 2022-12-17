package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private Spark intakeLeftMotor = new Spark(5);
    private Spark intakeRightMotor = new Spark(6);

    public IntakeSubsystem() {}

    @Override
    public void periodic() {
    }
    public void setPosition(boolean open) {
        if (open) {
            intakeLeftMotor.set(-1);
            intakeRightMotor.set(-1);
        } else {
            intakeLeftMotor.set(1);
            intakeRightMotor.set(1);
        }
    }
}
