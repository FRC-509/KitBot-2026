package frc.robot.commands;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;

public class StartIntake extends Command {
    private final Intake m_subsystem;
    
    public StartIntake(Intake m_subsystem){
        this.m_subsystem = m_subsystem;
        addRequirements(this.m_subsystem);
    }
    
    @Override
    public void initialize(){
        m_subsystem.intakeFuel();
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
