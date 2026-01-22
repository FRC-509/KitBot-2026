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
  //0s not real - change later
  public final TalonFX frontLeftMotor = new TalonFX(0);
  public final TalonFX backLeftMotor = new TalonFX(0);
  public final TalonFX frontRightMotor = new TalonFX(0);
  public final TalonFX backRightMotor = new TalonFX(0);


  public DifferentialDrive() {
    leftSide.set(0);
    rightSide.set(0);
}

private void leftSide(double speed){
      frontLeftMotor.set(speed);
      backLeftMotor.set(speed);
    }
    private void rightSide(double speed){
      frontRightMotor.set(speed);
      backRightMotor.set(speed);
    }
    public void drive(double forward, double right){
      double rightSpeed = forward + right;
      double leftSpeed = forward - right;
      rightSide(Math.clamp(rightSpeed, -1.00,  1.00));
      leftSide(Math.clamp(leftSpeed,  -1.00,  1.00));
    }
}