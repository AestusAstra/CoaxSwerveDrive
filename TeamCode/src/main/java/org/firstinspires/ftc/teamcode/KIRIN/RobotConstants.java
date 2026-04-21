package org.firstinspires.ftc.teamcode.KIRIN;

import com.acmerobotics.dashboard.config.Config;

@Config
public class RobotConstants {
    /*DO NOT CHANGE THE @Config at the start, FTC dashboard needs it to function
    * please do not mess with my constants.
    * */

    //Pod rotation PID
    public static double SwerveModKp = 0.0;
    public static double SwerveModKi = 0.0;
    public static double SwerveModKd = 0.0;
    public static double SwerveModKf = 0.0;
    public static double SwerveModKl = 0.0;

    //SpeedScale controls max speed, RotScale affects rotation speed and precision
    public static double SpeedScale = 1.0;
    public static double RotScale = 1.0;

    //Module offsets.  Unneeded if servos zeroed properly.
    public static double FR_mod_offset = 0;
    public static double BR_mod_offset = 0;
    public static double FL_mod_offset = 0;
    public static double BL_mod_offset = 0;

    //possible module speed PIDs?


    //Heading Control PIDs

}
