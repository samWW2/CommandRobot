package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevaterSubsystem extends SubsystemBase{
    private Spark elevatorMotor = new Spark(4);
    private Encoder encoder = new Encoder(4,5);
    private final double kDriveTick2Feet= 1.0/4096 * 6 * Math.PI / 12;

    public ElevaterSubsystem() {
      
    }
    
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Elevator encoder value", getEncoderFeet());
    }

    public void setMotor(double speed) {
        elevatorMotor.set(speed);
    }
    public double getEncoderFeet() {
        return encoder.get() * kDriveTick2Feet;
    }
}
