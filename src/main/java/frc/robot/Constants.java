// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  /*
  pigeon 0
  1-4 driveTrain Motors
  shooter 5
  intake 6
  encoders 7-8
  
  
  
  */



  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static class MotorIDs {
    public static final int kMotorFrontLeft = 1; //placeholder for ID
    public static final int kMotorFrontRight = 3; //placeholder for ID
    public static final int kMotorBackLeft = 2; //placeholder for ID
    public static final int kMotorBackRight = 4; //placeholder for ID
    public static final int kMotorIntake = 6; //placeholder for ID
    public static final int kMotorShooter = 5;
  }
  public static class SensorIDs {
    public static final int kEncoderLeftDriveBase = 0; //Placeholder
    public static final int kEncoderRightDriveBase = 0; //Placeholder
    public static final String kCANivore = "canivore"; //placeholder
    public static final int kpigeon = 0;
  }
  public static class DriveConstants {
    public static final double kMaxDriveVelocity = 1;
    public static final double kMinDriveVelocity = -1;
    public static final double kMaxDriveVoltage = 6.0;
    public static final double kMinDriveVoltage = -6.0;
    public static final double kNoDriveVoltage = 0.0;
  }

  public static class MechanismVelocityConstants {
    public static final double koutakeFuelVelocity = -0.2;
    public static final double kintakeFuelVelocity = 0.2;
    public static final double kshooterFuelVelocity = 0.5;
  }
}
