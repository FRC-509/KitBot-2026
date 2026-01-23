// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DifferentialDrive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;


public class DriveCommand extends Command {

  DifferentialDrive driver;
  DoubleSupplier stickX;
  DoubleSupplier stickY;

  public DriveCommand(DifferentialDrive subsystem, DoubleSupplier stickX, DoubleSupplier stickY) {
    this.driver = subsystem;
    this.stickX = stickX;
    this.stickY = stickY;
  }


  @Override
  public void execute() {

    double x = stickX.getAsDouble();
    double y = stickY.getAsDouble();
    double leftSpeed = y + x;
    double rightSpeed = y - x;

    driver.leftSpeed(leftSpeed);
    driver.rightSpeed(rightSpeed);
  }
}
