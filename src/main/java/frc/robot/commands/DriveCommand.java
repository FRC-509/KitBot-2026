// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DifferentialDrive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class DriveCommand extends Command {
  @SuppressWarnings("PMD.UnusedPrivateField")
  private final DifferentialDrive diffDrive;
  private final DoubleSupplier dumpSumpForward;
  private final DoubleSupplier dumpSumpRight;


  /**
   * Creates a new ExampleCommand.
   *
   * @param DifferentialDrive The subsystem used by this command.
   */
  public DriveCommand(DifferentialDrive diffDrive, DoubleSupplier dumpSumpForward, DoubleSupplier dumpSumpRight) {
    this.diffDrive = diffDrive;
    this.dumpSumpForward = dumpSumpForward;
    this.dumpSumpRight = dumpSumpRight;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(diffDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    diffDrive.drive(dumpSumpForward.getAsDouble(), dumpSumpRight.getAsDouble());
    SmartDashboard.putBoolean("DriveTrain Active: ", true);
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  diffDrive.drive(0,0);
    SmartDashboard.putBoolean("DriveTrain Active: ", false);
}
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    
    return true;
  }
}
