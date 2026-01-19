// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.MechanismVelocityConstants;
import frc.robot.Constants.MotorIDs;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;


public class Shooter extends SubsystemBase {
  private final TalonFX shooterMotor = new TalonFX(MotorIDs.kMotorShooter);
  private final VoltageOut openLoop = new VoltageOut(0).withEnableFOC(false);
  /** Creates a new ExampleSubsystem. */
  public Shooter() {
    TalonFXConfiguration shooterConfig = new TalonFXConfiguration();

    // PID value assignment
    shooterConfig.Slot0.kP = Constants.PIDConstants.Shooter.kShooterP;
    shooterConfig.Slot0.kI = Constants.PIDConstants.Shooter.kShooterI;
    shooterConfig.Slot0.kD = Constants.PIDConstants.Shooter.kShooterD;
    shooterConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;

    shooterMotor.getConfigurator().apply(shooterConfig);
  }

  // shoots fuel that the robot sucks up
  public void shootFuel(){
    shooterMotor.setControl(openLoop.withOutput(MechanismVelocityConstants.kshooterFuelVelocity));
  }

  public void stopShooter(){
    shooterMotor.setControl(openLoop.withOutput(0));
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
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
