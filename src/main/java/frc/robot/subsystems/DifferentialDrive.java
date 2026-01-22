// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.MathUtil;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.hardware.CANcoder;

import frc.robot.Constants.MotorIDs;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.SensorIDs;



public class DifferentialDrive extends SubsystemBase {
  private final TalonFX frontLeft = new TalonFX(MotorIDs.kMotorFrontLeft);
  private final TalonFX frontRight = new TalonFX(MotorIDs.kMotorFrontRight);
  private final TalonFX backLeft = new TalonFX(MotorIDs.kMotorBackLeft);
  private final TalonFX backRight = new TalonFX(MotorIDs.kMotorBackRight);
  
  public DifferentialDrive() {
    frontLeft.set(0);
    frontRight.set(0);
    backLeft.set(0);
    backRight.set(0);
  }
  
  public void leftSpeed(double speed) {
    speed = Math.clamp(speed, -1.0, 1.0);
    frontLeft.set(speed);
    backLeft.set(speed);
  }

  public void rightSpeed(double speed) {
    speed = Math.clamp(speed, -1, 1.0);
    frontRight.set(speed);
    backRight.set(speed);
  }
} 