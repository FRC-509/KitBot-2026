// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.Constants.MechanismVelocityConstants;

import frc.robot.Constants.MotorIDs;
import frc.robot.Constants.OperatorConstants;


public class Intake extends SubsystemBase {
  private final TalonFX rotationalMotor = new TalonFX(MotorIDs.kMotorIntake);
  private final VoltageOut openLoop = new VoltageOut(0).withEnableFOC(false);

  public Intake() {
  }

  // outakeFuel controls the velocity of the fuel when shot
  public void outtakeFuel(){
      rotationalMotor.setControl(openLoop.withOutput(MechanismVelocityConstants.koutakeFuelVelocity));
      SmartDashboard.putBoolean(getName(), true);
  }
  // intakeFuel controls the velocity of the fuel when sucked up
  public void intakeFuel(){
    rotationalMotor.setControl(openLoop.withOutput(MechanismVelocityConstants.kintakeFuelVelocity));
    SmartDashboard.putBoolean(getName(), true);
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
  public void stopIntake() {
    rotationalMotor.setControl(openLoop.withOutput(0));
  }
  /* 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  */

}
