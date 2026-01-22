package frc.robot.subsystem;



public class LEDLight{

    private final AddressableLED ledLight = new AddressableLED(Constants.LEDLight.kLEDLightPort);
    private final AddressableLEDBuffer ledBuffer = new AddressableLEDBuffer(Constants.LEDLight.kLEDLightLength); 
    
    public enum LEDLightStates {

        BLUE_ALLIANCE(LEDLightPatterns.SolidColors.blue),
        RED_ALLIANCE(LEDLightPatterns.SolidColors.red),
        
        CLIMB(LEDLightPatterns.RaindbowPattern.rainbow),
        
        TURRET_TRACKING(LEDLightpatterns.SolidColors.green),

        STOP(LEDLightPatterns.SolidColors.black);

        private final String color;

        // LEDLightStates(String color) {this.color = color; }

        // private final int ledAddress;

        // LEDLightStates(int ledAddress){
        //     this.ledType = ledAddress;
        }
    }

    private final LEDState ledState;
    

    public LEDLight(){

        this.ledState = LEDLightStates

        ledLight.setLength(Constants.LEDLight.kLEDLightLength);
        ledLight.start();
    }

    // public void setState(LEDState ledState){
    //     this.ledState = LEDLightStates.STOP;
    // }

    public void displayLED(LEDLightStates desiredState, boolean stop){
        if (stop) ledState = LEDLightStates.STOP;

        switch(desiredState){
            case(desiredState.):
                String alliance = DriverStation.getAlliance();
                ledState = alliance ? LEDLightStates.BLUE_ALLIANCE : LEDLightStates.RED_ALLIANCE;
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