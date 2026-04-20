package org.firstinspires.ftc.teamcode.KIRIN.Subsystems;
import com.qualcomm.robotcore.hardware.AnalogInput;
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
    //encoders
    private final AnalogInput FRE, FLE, BRE, BLE;

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

        FRE = hardwareMap.get(AnalogInput.class, "FRE");
        FLE = hardwareMap.get(AnalogInput.class, "FLE");
        BRE = hardwareMap.get(AnalogInput.class, "BRE");
        BLE = hardwareMap.get(AnalogInput.class, "BLE");


        // Creating new Module instances so we can command them.  Woodedoo :)
        FRmod = new SwerveModule(FRmotor, FRServo, FRE, 1, 0,0);
        FLmod = new SwerveModule(FLmotor, FLServo, FLE, 1, 180,0);
        BRmod = new SwerveModule(BRmotor, BRServo, BRE, -1, 180,0);
        BLmod = new SwerveModule(BLmotor, BLServo, BLE, 1, 180,0);

    }

    //Heading Correction







    //Module Behavior
    public void drive (double forward, double strafe, double rot) {
        double WheelSpeed = Math.sqrt(Math.pow(forward, 2) + Math.pow(strafe, 2));
        double ModHeadingRef = Math.atan2(forward, strafe)*180/Math.PI;
        FRmod.drive(WheelSpeed, ModHeadingRef);
        FLmod.drive(WheelSpeed, ModHeadingRef);
        BRmod.drive(WheelSpeed, ModHeadingRef);
        BLmod.drive(WheelSpeed, ModHeadingRef);
    }






        //Servo Behavior







        }




