package org.firstinspires.ftc.teamcode.KIRIN.Util;

public class MathsOperations {
    public static double AngleWrap(double angle) {
        while (angle < 0){
        angle += 360;
        }

        while (angle > 360){
            angle -=360;
        }

        return angle;
    }

    //replaces turning a module by 180 degrees with reversing motor power.
    public static double[] efficientTurn(double reference,double state,double power){
        double error = reference-state;

        while(error>90) {
            power *=-1;
            reference -= 180;
            error = reference-state;
        }
        return new double[]{reference,power};
    }
}