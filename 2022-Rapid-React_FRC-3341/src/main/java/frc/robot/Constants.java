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
    public final class Ports{
        public static final int frontLeftRotPort = 0;
        public static final int frontRightRotPort = 0;
        public static final int backLeftRotPort = 0;
        public static final int backRightRotPort = 0;
        public static final int frontLeftExPort = 0;
        public static final int frontRightExPort = 0;
        public static final int backLeftExPort = 0;
        public static final int backRightExPort = 0;
    }

    public final class MotorNums{
        public static final int frontLeftRot = 1;
        public static final int frontRightRot = 2;
        public static final int backLeftRot = 3;
        public static final int backRightRot = 4;
        public static final int frontLeftEx = 5;
        public static final int frontRightEx = 6;
        public static final int backLeftEx = 7;
        public static final int backRightEx = 8;
    }

    public static final class pidConsts{
        public static final double pidP = 0;
        public static final double pidI = 0;
        public static final double pidD = 0;
  }
  
  public static final class charConsts{
        public static final double ks = 0;
        public static final double kcos = 0;
        public static final double kv = 0;
        public static final double ka = 0;
  }
}
