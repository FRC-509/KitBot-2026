package frc.robot.commands;
import frc.robot.subsystems.Intake;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;

public class IntakeCommand extends Command {
    private final Intake m_subsystem;
    private final boolean isOut;
    private BooleanSupplier finished;
    
    public IntakeCommand(Intake m_subsystem, boolean isOut, BooleanSupplier finished){
        this.m_subsystem = m_subsystem;
        this.isOut = isOut;
        this.finished = finished;
        addRequirements(this.m_subsystem);
    }
    @Override
    public void execute() {
        if (isOut) {
            executeOuttake();
        } else {
            executeIntake();
        }
    }
    
    @Override
    public boolean isFinished() {
        return finished.getAsBoolean();
    }

    @Override
    public void end(boolean isInterrupted) {
        m_subsystem.stopIntake();
    }
    public void executeIntake() {
        m_subsystem.intakeFuel();
    }
    public void executeOuttake() {
        m_subsystem.outtakeFuel();
    }
    
    public void stop() {
        m_subsystem.stopIntake();
    }
}
