// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

/** An example command that uses an example subsystem. */
public class ShooterCommand extends Command {
  private final Shooter shooterN;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShooterCommand(Shooter shooter) {
    shooterN = shooter;

    addRequirements(shooter.);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    // maybe -0.75
    shooterN.shoot();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}
