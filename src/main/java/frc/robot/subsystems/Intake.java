// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import com.ctre.phoenix6.controls.VoltageOut;


public class Intake extends SubsystemBase {
  private final TalonFX rotationalMotor = new TalonFX(0);
  private final VoltageOut openLoop = new VoltageOut(0).withEnableFOC(false);
   
  
  /** Creates a new ExampleSubsystem. */
  public Intake() {}


  public void outakeFuel(){
      rotationalMotor.setControl(openLoop.withOutput(koutakeFuelVelocity));
      SmartDashboard.putBoolean(getName(), true);
  }

  public void intakeFuel(){
    rotationalmotor.setControl(openLoop.withOutput(kintakeFuelVelocity));
    SmartDashboard.putBoolean(getName(), true);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
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

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
