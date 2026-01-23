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


        LEDLightStates(LEDPattern solid) {
                    //TODO Auto-generated constructor stub
                }
        
                private final String color;

        // LEDLightStates(String color) {this.color = color; }

        // private final int ledAddress;

        // LEDLightStates(int ledAddress){
        //     this.ledType = ledAddress;
        }
    

    private LEDLightStates ledState;
    
        
        
    
        public LEDLight(){
    
            this.ledState = LEDLightStates.STOP;
    
            ledLight.setLength(Constants.LEDLight.kLEDLightLength);
            ledLight.start();

        }
    
    

    // public void setState(LEDState ledState){
    //     this.ledState = LEDLightStates.STOP;
    // }

    public void displayLED(LEDLightStates desiredState, boolean stop){
        if (stop) ledState = LEDLightStates.STOP;

        switch(desiredState){
            case(desiredState.get):
                Optional<Alliance> alliance = DriverStation.getAlliance();
                ledState = (alliance.get() == Alliance.Blue) ? LEDLightStates.BLUE_ALLIANCE : LEDLightStates.RED_ALLIANCE;
            case("climb"):
                ledState = LEDLightStates.CLIMB;
            case("turret"):
                ledState = LEDLightStates.TURRET_TRACKING;
                
            ledState.applyTo(ledBuffer);
            ledLight.setData(ledBuffer);
        }
    }

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

    @Override
    public void initialize(){}

    @Override
    public void execute(){}

    @Override 
    public void end(boolean interupted){}

    @Override
    public void isFinished(){}
}