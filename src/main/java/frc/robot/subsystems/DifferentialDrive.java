// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;

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

public class DifferentialDrive<PigeonWrapper> extends SubsystemBase {
  private final TalonFX frontLeft = new TalonFX(MotorIDs.kMotorFrontLeft);
  private final TalonFX frontRight = new TalonFX(MotorIDs.kMotorFrontRight);
  private final TalonFX backLeft = new TalonFX(MotorIDs.kMotorBackLeft);
  private final TalonFX backRight = new TalonFX(MotorIDs.kMotorBackRight);

  private final CANcoder leftEncoder = new CANcoder(SensorIDs.kEncoderLeftDriveBase, SensorIDs.kCANivore);
  private final CANcoder rightEncoder = new CANcoder(SensorIDs.kEncoderRightDriveBase, SensorIDs.kCANivore);

  private final VelocityDutyCycle closedloop = new VelocityDutyCycle(0).withEnableFOC(false);

  // private final PigeonWrapper pigeon;

  private final VelocityDutyCycle rightVelocityClosedLoop = new VelocityDutyCycle(0);
  private final VelocityDutyCycle leftVelocityClosedLoop = new VelocityDutyCycle(0);

  // public DifferentialDrive(PigeonWrapper pigeon) {

  // this.pigeon = pigeon;
  // }
  public DifferentialDrive() {
    frontLeft.setControl(leftVelocityClosedLoop);
    frontRight.setControl(rightVelocityClosedLoop);
    backLeft.setControl(leftVelocityClosedLoop);
    backRight.setControl(rightVelocityClosedLoop);
  }

  public void leftSpeed(double speed) {
    speed = Math.clamp(speed, -1, 1);
    frontLeft.setControl(leftVelocityClosedLoop.withVelocity(DriveConstants.kMaxDriveVelocity * speed));
    backLeft.setControl(leftVelocityClosedLoop.withVelocity(DriveConstants.kMaxDriveVelocity * speed));
    SmartDashboard.putNumber("Right DriveTrain Speed: ", speed);
  }

  public void stop() {
    rightSpeed(0);
    leftSpeed(0);
  }

  // public Rotation2d getYaw() {
  //   if (RobotBase.isSimulation())
  //     // return Rotation2d.fromRadians(simHeading);
  // }

  public void rightSpeed(double speed) {
    speed = Math.clamp(speed, -1, 1);
    frontRight.setControl(rightVelocityClosedLoop.withVelocity(DriveConstants.kMaxDriveVelocity * speed));
    backRight.setControl(rightVelocityClosedLoop.withVelocity(DriveConstants.kMaxDriveVelocity * speed));
  }
}