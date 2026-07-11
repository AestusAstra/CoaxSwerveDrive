package org.firstinspires.ftc.teamcode.KIRIN.Subsystems;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.KIRIN.Util.SquIDcontroller;
import org.firstinspires.ftc.teamcode.KIRIN.Util.myDcMotorEx;

public class FLASH {

    private final myDcMotorEx SlideMotor;

    private final double oldPos = 0;

    private final AnalogInput slideEncoder;

    private final SquIDcontroller Squiddy = new SquIDcontroller(0,0,0);


    public FLASH(HardwareMap hardwareMap) {
        //hardware init and set behavior so it doesn't misbehave
        SlideMotor = new myDcMotorEx(hardwareMap.get(DcMotorEx.class, "Extendo" ));
        SlideMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        SlideMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SlideMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        slideEncoder = hardwareMap.get(AnalogInput.class, "SE");




        //WHAT IN THE KILOMETER IS A FEEDFORWARD

        //WE do not understand control theory

    }

    public void Lightning(double posref){
        if (Math.abs(posref - oldPos)>0.05){
            Squiddy.setSquIDCoefficients(0,0,0);
            double CurrentPos = slideEncoder.getVoltage() /3.3 * 360;
        }

        SlideMotor.setPower(0);

    }
}
