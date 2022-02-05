// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.lang.invoke.ConstantCallSite;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Climber;


public class Extend extends CommandBase {
  /** Creates a new Extend. */
  private DigitalInput input;
  private Climber climber;
  private int motorNum, steps, direction;
  private boolean currInput;

  public Extend(Climber climber, int motorNum, int steps) {
    addRequirements(climber);
    this.climber = climber;
    this.motorNum = motorNum;
    this.steps = steps;
    if(steps > 0) direction = 1;
    else if(steps < 0) direction = -1;
    input = new DigitalInput(Constants.DIOPorts.refSensor);
    currInput = input.get();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(steps != 0){
      if(input.get() != currInput && input.get()){
        steps -= direction;
      }
      climber.extend(motorNum, direction);
      currInput = input.get();
    }
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
