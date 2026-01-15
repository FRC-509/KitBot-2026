// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.controls.VelocityDutyCycle;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;

import frc.robot.Constants.DriveConstants;


public class DifferentialDrive extends SubsystemBase {
  public final PWMTalonFX frontLeft = new PWMTalonFX(0);
  public final PWMTalonFX frontRight = new PWMTalonFX(0);
  public final PWMTalonFX backLeft = new PWMTalonFX(0);
  public final PWMTalonFX backRight = new PWMTalonFX(0);
  
public final VelocityDutyCycle closedloop = new VelocityDutyCycle(0).withEnableFOC(false);
  
  /** Creates a new ExampleSubsystem. */
  public DifferentialDrive() {

  
  }

  public void getLeftSpeed(){

  }

  public void getRightSpeed(){

  }
 public void leftDrive(double speed){
  //checking for speed in range
  if(speed > DriveConstants.kMaxDriveVelocity) speed = 1;
  if(speed < DriveConstants.kMinDriveVelocity) speed = -1;

  frontLeft.set(speed);
  backLeft.set(speed);

 }

 public void rightDrive(double speed){
  //checking for speed in range
  if(speed > 1) speed = 1;
  if(speed < -1) speed = -1;
  
  frontRight.set(speed);
  backRight.set(speed);
 }

 /**
  * this is a helper method for the controller
  * @param forward hi
  * @param right
  */
 public void drive(double forward, double right){
  double leftSpeed = forward + right;
  double rightSpeed = forward - right;
  leftDrive(leftSpeed);
  rightDrive(rightSpeed);
}






  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {

this.drive(0, 0);

    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  
}
