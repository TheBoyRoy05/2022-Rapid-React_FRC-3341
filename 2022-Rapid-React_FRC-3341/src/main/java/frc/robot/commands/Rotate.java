// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Climber;

public class Rotate extends CommandBase {
  /** Creates a new Rotate. */
  ArmFeedforward arm = new ArmFeedforward(Constants.charConsts.ks, Constants.charConsts.kcos, Constants.charConsts.kv);
  PIDController pid = new PIDController(Constants.pidConsts.pidP, Constants.pidConsts.pidI, Constants.pidConsts.pidD);
  private Climber climber;
  private int motorNum;
  private double angle;

  public Rotate(Climber climber, int motorNum, double angle) {
    addRequirements(climber);
    this.angle = angle;
    this.motorNum = motorNum;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pid.setSetpoint(angle);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double climberAngle = Math.PI / 2;
    if(motorNum == 1) climberAngle = climber.getAngleFrontLeft();
    else if (motorNum == 2) climberAngle = climber.getAngleFrontRight();
    else if (motorNum == 3) climberAngle = climber.getAngleBackLeft();
    else if (motorNum == 4) climberAngle = climber.getAngleBackRight();
    climber.rotate(motorNum, pid.calculate(climberAngle) + arm.calculate(angle, 0));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
