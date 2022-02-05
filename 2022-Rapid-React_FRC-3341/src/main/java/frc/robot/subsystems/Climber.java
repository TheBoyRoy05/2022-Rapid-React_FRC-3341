// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  
  private final WPI_TalonSRX frontLeftRot;
  private final WPI_TalonSRX frontRightRot;
  private final WPI_TalonSRX backLeftRot;
  private final WPI_TalonSRX backRightRot;
  private final WPI_TalonSRX frontLeftEx;
  private final WPI_TalonSRX frontRightEx;
  private final WPI_TalonSRX backLeftEx;
  private final WPI_TalonSRX backRightEx;

  public Climber() {
    frontLeftRot = new WPI_TalonSRX(Constants.Ports.frontLeftRotPort);
    frontRightRot = new WPI_TalonSRX(Constants.Ports.frontRightRotPort);
    backLeftRot = new WPI_TalonSRX(Constants.Ports.backLeftRotPort);
    backRightRot = new WPI_TalonSRX(Constants.Ports.backRightRotPort);
    frontLeftEx = new WPI_TalonSRX(Constants.Ports.frontLeftExPort);
    frontRightEx = new WPI_TalonSRX(Constants.Ports.frontRightExPort);
    backLeftEx = new WPI_TalonSRX(Constants.Ports.backLeftExPort);
    backRightEx = new WPI_TalonSRX(Constants.Ports.backRightExPort);

    frontLeftRot.configFactoryDefault();
    frontLeftRot.setInverted(false);
    frontLeftRot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    frontRightRot.configFactoryDefault();
    frontRightRot.setInverted(false);
    frontRightRot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    backLeftRot.configFactoryDefault();
    backLeftRot.setInverted(false);
    backLeftRot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    backRightRot.configFactoryDefault();
    backRightRot.setInverted(false);
    backRightRot.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
  }

  public double getAngleFrontLeft(){
    return toRadians(frontLeftRot.getSelectedSensorPosition());
  }

  public double getAngleFrontRight(){
    return toRadians(frontRightRot.getSelectedSensorPosition());
  }

  public double getAngleBackLeft(){
    return toRadians(backLeftRot.getSelectedSensorPosition());
  }

  public double getAngleBackRight(){
    return toRadians(backRightRot.getSelectedSensorPosition());
  }

  public double toRadians(double motorPos){
    return motorPos * 2 * Math.PI / 4096.0;
  }

  public void rotate(int motorNum, double speed){
    if(motorNum == 1) frontLeftRot.set(ControlMode.PercentOutput, speed);
    else if(motorNum == 2) frontRightRot.set(ControlMode.PercentOutput, speed);
    else if(motorNum == 3) backLeftRot.set(ControlMode.PercentOutput, speed);
    else if(motorNum == 4) backRightRot.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
