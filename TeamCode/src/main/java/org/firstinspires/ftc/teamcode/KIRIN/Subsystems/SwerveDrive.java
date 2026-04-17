package org.firstinspires.ftc.teamcode.KIRIN.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.KIRIN.Util.CrServoCaching;
import org.firstinspires.ftc.teamcode.KIRIN.Util.myDcMotorEx;

public class SwerveDrive {

    //Motors :)
    private final myDcMotorEx FRmotor, FLmotor, BRmotor, BLmotor;
    //Servos :)
    private final CrServoCaching FRServo, FLServo, BRServo, BLServo;

    public SwerveModule FRmod, FLmod, BRmod, BLmod;
    public SwerveDrive(HardwareMap hardwareMap) {

        //I tried to pull all the hardware from one file, but i guess this system will have to do
        FRmotor = new myDcMotorEx(hardwareMap.get(DcMotorEx.class, "FRmotor"));
        FLmotor =new myDcMotorEx(hardwareMap.get(DcMotorEx.class, "FRmotor"));
        BRmotor =new myDcMotorEx(hardwareMap.get(DcMotorEx.class, "FRmotor"));
        BLmotor =new myDcMotorEx(hardwareMap.get(DcMotorEx.class, "FRmotor"));

        FRServo = new CrServoCaching(hardwareMap.get(CRServo.class, "FRServo"));
        FLServo = new CrServoCaching(hardwareMap.get(CRServo.class, "FRServo"));
        BRServo = new CrServoCaching(hardwareMap.get(CRServo.class, "FRServo"));
        BLServo = new CrServoCaching(hardwareMap.get(CRServo.class, "FRServo"));


        // Creating new Module instances so we can command them.  Woodedoo :)
        FRmod = new SwerveModule(FRmotor, FRServo);
        FLmod = new SwerveModule(FLmotor, FLServo);
        BRmod = new SwerveModule(BRmotor, BRServo);
        BLmod = new SwerveModule(BLmotor, BLServo);

    }

    //Motor Behavior
    public void drive (double forward, double strafe, double rot) {
        double WheelSpeed = Math.sqrt((forward) * (forward)+(strafe)* (strafe));
        double ModHeadingRef = Math.atan2(forward, strafe);





    }






        //Servo Behavior







        }




