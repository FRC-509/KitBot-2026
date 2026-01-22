
public final class LEDLightPatterns {
    
    public static class SolidColors {
        private final LEDPattern red = LEDPattern.solid(Color.kRed); // not tracking
        private final LEDPattern blue = LEDPattern.solid(Color.kOrange); // manually aiming?
        private final LEDPattern green = LEDPattern.solid(Color.kGreen); // tracking the hub

        private final LEDPattern black = LEDPattern.solid(Color.kBlack);
    }

    public static class RaindbowPattern {
        private final LEDPattern rainbow = LEDPattern.rainbow(255, 128); // climb
        
        private final LEDPattern scrollingRainbow =
            m_rainbow.scrollAtAbsoluteSpeed(MetersPerSecond.of(1), kLedSpacing);
    }



}