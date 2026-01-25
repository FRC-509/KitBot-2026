package frc.robot.subsystems.LEDLights;

import java.util.Optional;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Constants;

public class LEDLight extends SubsystemBase{

    private final AddressableLED ledLight = new AddressableLED(Constants.LEDLight.kLEDLightPort);
    private final AddressableLEDBuffer ledBuffer = new AddressableLEDBuffer(Constants.LEDLight.kLEDLightLength); 
    
    public enum LEDLightStates {

        BLUE_ALLIANCE(LEDPattern.solid(Color.kRed)),
        RED_ALLIANCE(LEDPattern.solid(Color.kOrange)),
        
        CLIMB(LEDPattern.rainbow(255, 128)),
        
        TURRET_TRACKING(LEDPattern.solid(Color.kGreen)),

        STOP(LEDPattern.solid(Color.kBlack));

        private final LEDPattern ledPattern;

        LEDLightStates(LEDPattern ledPattern){
            this.ledPattern = ledPattern;
        }
        public void applyTo(AddressableLEDBuffer ledBuffer){
        ledPattern.applyTo(ledBuffer);
    }
    }
    

    private LEDLightStates ledState;
    
        
        
    
        public LEDLight(){
    
            this.ledState = LEDLightStates.STOP;
    
            ledLight.setLength(Constants.LEDLight.kLEDLightLength);
            ledLight.start();

        }
    
    
    
    public void displayLED(LEDLightStates desiredState){
        
        switch(desiredState){
            case BLUE_ALLIANCE:
            case RED_ALLIANCE:
                Optional<Alliance> alliance = DriverStation.getAlliance();
                ledState = (alliance.get() == Alliance.Blue) ? LEDLightStates.BLUE_ALLIANCE : LEDLightStates.RED_ALLIANCE;
                break;

            case CLIMB:
                ledState = LEDLightStates.CLIMB;
                break;
            case TURRET_TRACKING:
                ledState = LEDLightStates.TURRET_TRACKING;
                break;    
            case STOP:
                ledState = LEDLightStates.STOP;
                break;
            

        }
    
        setState(ledState);
    }

    public void setState(LEDLightStates state){
        ledState = state;

        ledState.applyTo(ledBuffer);
        ledLight.setData(ledBuffer);
    }

    //

    // public void stop(){
    //     ledState = LEDLightStates.STOP;
    //     ledState.applyTo(ledBuffer);
    //     ledLight.setData(ledBuffer);
    // }

    // public void allianceState(){
    //     String alliance = DriverStation.getAlliance();

    //     ledState = alliance ? LEDLightStates.BLUE_ALLIANCE : LEDLightStates.RED_ALLIANCE;
    //     ledState.applyTo(ledBuffer);
    //     ledLight.setData(ledBuffer);
    // }

    // public void displayMechanismLED(boolean hubTracking){
    //     ledState = hubTracking ? LEDLightStates.TURRET_TRACKING : LEDLightStates.CLIMB;
    //     ledState = applyTo(ledBuffer);
    //     ledLight.setData(ledBuffer);
    // }

    // @Override
    // public void initialize(){}

    // @Override
    // public void execute(){}

    // @Override 
    // public void end(boolean interupted){}

    // @Override
    // public void isFinished(){}
}