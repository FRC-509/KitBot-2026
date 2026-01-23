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
  public final TalonFX frontLeft = new TalonFX(MotorIDs.kMotorFrontLeft);
  public final TalonFX frontRight = new TalonFX(MotorIDs.kMotorFrontRight);
  public final TalonFX backLeft = new TalonFX(MotorIDs.kMotorBackLeft);
  public final TalonFX backRight = new TalonFX(MotorIDs.kMotorBackRight);
  
  public final CANcoder leftEncoder = new CANcoder(SensorIDs.kEncoderLeftDriveBase, SensorIDs.kCANivore);
  public final CANcoder rightEncoder = new CANcoder(SensorIDs.kEncoderRightDriveBase, SensorIDs.kCANivore);
  
public final VelocityDutyCycle closedloop = new VelocityDutyCycle(0).withEnableFOC(false);


  public DifferentialDrive(PigeonWrapper pigeon) {

    this.pigeon = pigeon;

    pigeon.getYaw();

    TalonFXConfiguration driveConfig = new TalonFXConfiguration();

    //PID value assignment
    driveConfig.Slot0.kP = Constants.PIDConstants.Drive.kDriveP;
    driveConfig.Slot0.kI = Constants.PIDConstants.Drive.kDriveI;
    driveConfig.Slot0.kD = Constants.PIDConstants.Drive.kDriveD;
    driveConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;

    // Assigning encoder as feedback device
    driveConfig.Feedback.FeedbackRemoteSensorID = leftEncoder.getDeviceID();
    driveConfig.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.RemoteCANcoder;
    
    frontLeft.getConfigurator().apply(driveConfig);
    frontRight.getConfigurator().apply(driveConfig);
    backLeft.getConfigurator().apply(driveConfig);
    backRight.getConfigurator().apply(driveConfig);
  }
   
  // leftDrive controls the speed of the left side of the tank bot
 private void leftDrive(double speed){

  //checking for speed in range
  speed = MathUtil.clamp(speed, DriveConstants.kMinDriveVelocity, DriveConstants.kMaxDriveVelocity);
  
  frontLeft.setControl(closedloop.withVelocity(speed * DriveConstants.kMaxDriveVoltage));
  backLeft.setControl(closedloop.withVelocity(speed * DriveConstants.kMaxDriveVoltage));
  SmartDashboard.putNumber("Left DriveTrain Speed: ", speed);
 }

//We Love mr. skibidihorn and fvelocity - Zack philopino boy.

// rightDrive controls the speed of the right side of the tank bot
 private void rightDrive(double speed){

  //checking for speed in range
  speed = MathUtil.clamp(speed, DriveConstants.kMinDriveVelocity, DriveConstants.kMaxDriveVelocity);
  
  frontRight.setControl(closedloop.withVelocity(speed * DriveConstants.kMaxDriveVoltage));
  backRight.setControl(closedloop.withVelocity(speed * DriveConstants.kMaxDriveVoltage));
  SmartDashboard.putNumber("Right DriveTrain Speed: ", speed);
 }

 /**
  * this is a helper method for the controller
  * @param forward
  * @param right
  */
  //drive controls the direction the tank bot moves

public void end(){
  rightDrive(0);
  leftDrive(0);
}

public Rotation2d getYaw(){
  if (RobotBase.isSimulation()){
    return Rotation2d.fromRadians(simHeading);
  }
  return pigeon.getRotation2d();
}

private void leftSide(double speed){
      frontLeft.set(speed);
      backLeft.set(speed);
    }
    private void rightSide(double speed){
      frontRight.set(speed);
      backRight.set(speed);
    }
    public void drive(double forward, double right){
      double rightSpeed = forward + right;
      double leftSpeed = forward - right;
      rightSide(Math.clamp(rightSpeed, -1.00,  1.00));
      leftSide(Math.clamp(leftSpeed,  -1.00,  1.00));
    }
}