// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DifferentialDrive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class DriveCommand extends Command {
  @SuppressWarnings("PMD.UnusedPrivateField")
  //private final Subsystems m_subsystem;
  private final DifferentialDrive tankDrive;
  private final DoubleSupplier rightSupplier;
  private final DoubleSupplier forwardSupplier;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand (DifferentialDrive drive, DoubleSupplier right, DoubleSupplier forward) {
    tankDrive = drive;
    rightSupplier = right;
    forwardSupplier = forward;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() { 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    tankDrive.drive(forwardSupplier.getAsDouble(), rightSupplier.getAsDouble());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}