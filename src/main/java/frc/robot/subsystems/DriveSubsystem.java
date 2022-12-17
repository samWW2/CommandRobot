// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;




//change the name of the class to "DriveSubsystem"
//pay attention that the class extends SubsystemBase
public class DriveSubsystem extends SubsystemBase {
  
  private final WPI_TalonSRX leftMotor1 = new WPI_TalonSRX(0);
  private final WPI_TalonSRX leftMotor2 = new WPI_TalonSRX(1);
  private final WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(2);
  private final WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(3);
  private final double kDriveTick2Feet= 1.0/4096 * 6 * Math.PI / 12;
  // encoders on dio ports
  private Encoder leftEncoder = new Encoder(0, 1);
  private Encoder rightEncoder = new Encoder(2, 3);
  //gets encoder value
  public double getEncoderValue(){
    return (leftEncoder.get() + rightEncoder.get()) / 2 * kDriveTick2Feet;
  }
  //similar to the init call
  public DriveSubsystem() {
    rightMotor1 .setInverted(true);
    rightMotor2.setInverted(true);
    rightMotor2.follow(rightMotor1);
    leftMotor2.follow(leftMotor1);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Drive encoder value", getEncoderValue());
  }
  public void setMotors(double leftSpeed, double rightSpeed) {
    leftMotor1.set(leftSpeed);
    rightMotor1.set(rightSpeed);
}

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
