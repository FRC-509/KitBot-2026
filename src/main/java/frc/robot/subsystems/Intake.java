// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.robot.Constants;
import frc.robot.Constants.MechanismVelocityConstants;

import frc.robot.Constants.MotorIDs;
import frc.robot.Constants.OperatorConstants;


public class Intake extends SubsystemBase {
  public final TalonFX intakeMotor = new TalonFX(0);


  public Intake() {
    intakeMotor.set(0);
  }
  private void intakeSpeed(){
    intakeMotor.set(0.75);
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  // public boolean exampleCondition() {
  //   // Query some boolean state, such as a digital sensor.
  //   return false;
  // }
  /* 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  */

}
