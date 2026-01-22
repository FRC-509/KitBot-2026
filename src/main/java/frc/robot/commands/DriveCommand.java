// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DifferentialDrive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;


public class DriveCommand extends Command {

  DifferentialDrive subsystem;
  double x;
  double y;

  public DriveCommand(DifferentialDrive subsystem, double x, double y) {
    this.subsystem = subsystem;
    this.x = x;
    this.y = y;
  }


  @Override
  public void execute() {

    double leftSpeed = y + x;
    double rightSpeed = y - x;

    subsystem.leftSpeed(leftSpeed);
    subsystem.rightSpeed(rightSpeed);
  }

  
  @Override
  public boolean isFinished() {
    return true;
  }
}
