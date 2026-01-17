// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ShooterCommand extends Command {
  @SuppressWarnings("PMD.UnusedPrivateField")
  private final Shooter shooter;

  /**
   * Creates a new ExampleCommand.
   *
   * @param Shooter The subsystem used by this command.
   */
  public ShooterCommand(Shooter shooter) {
    this.shooter = shooter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.shootFuel();
    SmartDashboard.putBoolean("Shooter Active: ", true);
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stopShooter();
    SmartDashboard.putBoolean("Shooter Active: ", false);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return false;
  }
}
