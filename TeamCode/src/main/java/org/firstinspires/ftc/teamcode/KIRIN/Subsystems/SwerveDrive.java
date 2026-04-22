package org.firstinspires.ftc.teamcode.KIRIN.Subsystems;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.KIRIN.RobotConstants;
import org.firstinspires.ftc.teamcode.KIRIN.Util.CrServoCaching;
import org.firstinspires.ftc.teamcode.KIRIN.Util.myDcMotorEx;

public class SwerveDrive {

    public SwerveModule FR_mod, FL_mod, BR_mod, BL_mod;

    double FR_mod_offset = RobotConstants.FR_mod_offset;
    double BR_mod_offset = RobotConstants.BR_mod_offset;
    double FL_mod_offset = RobotConstants.FL_mod_offset;
    double BL_mod_offset = RobotConstants.BL_mod_offset;

    public SwerveDrive(HardwareMap hardwareMap) {

        //I tried to pull all the hardware from one file, but I guess this system will have to do
        //Motors :)
        myDcMotorEx FR_motor = new myDcMotorEx(hardwareMap.get(DcMotorEx.class, "FR_motor"));
        myDcMotorEx FL_motor = new myDcMotorEx(hardwareMap.get(DcMotorEx.class, "FL_motor"));
        myDcMotorEx BR_motor = new myDcMotorEx(hardwareMap.get(DcMotorEx.class, "BR_motor"));
        myDcMotorEx BL_motor = new myDcMotorEx(hardwareMap.get(DcMotorEx.class, "BL_motor"));

        //Servos :)
        CrServoCaching FRServo = new CrServoCaching(hardwareMap.get(CRServo.class, "FRServo"));
        CrServoCaching FLServo = new CrServoCaching(hardwareMap.get(CRServo.class, "FRServo"));
        CrServoCaching BRServo = new CrServoCaching(hardwareMap.get(CRServo.class, "FRServo"));
        CrServoCaching BLServo = new CrServoCaching(hardwareMap.get(CRServo.class, "FRServo"));

        //encoders
        AnalogInput FRE = hardwareMap.get(AnalogInput.class, "FRE");
        AnalogInput FLE = hardwareMap.get(AnalogInput.class, "FLE");
        AnalogInput BRE = hardwareMap.get(AnalogInput.class, "BRE");
        AnalogInput BLE = hardwareMap.get(AnalogInput.class, "BLE");


        // Creating new Module instances so we can command them.  Woopdedoo :)
        FR_mod = new SwerveModule(FR_motor, FRServo, FRE, FR_mod_offset);
        FL_mod = new SwerveModule(FL_motor, FLServo, FLE, BR_mod_offset);
        BR_mod = new SwerveModule(BR_motor, BRServo, BRE, FL_mod_offset);
        BL_mod = new SwerveModule(BL_motor, BLServo, BLE, BL_mod_offset);

    }

    //Heading Correction







    //Module Behavior
    public void drive (double forward, double strafe, double rot, double heading) {

        double heading_rad = Math.toRadians(heading);
        double strafe1 = Math.cos(heading_rad) * strafe - Math.sin(heading_rad) * forward;
        double forward1 = Math.sin(heading_rad) * forward + Math.cos(heading_rad) * strafe;

        //Kinematics (Wheel Specific Vectors)
        // Vx = strafe + rot * Ry
        // Vy = forward - rot * Rx
        // FR , Rx= 1, Ry = 1
        double FR_strafe1 = strafe1 + (rot * 1);
        double FR_forward1 = forward1 - (rot * 1);
        double FRModSpeed = Math.sqrt(Math.pow(FR_strafe1, 2) + Math.pow(FR_forward1, 2));

        //FL, Rx = -1, Ry = 1
        double FL_strafe1 = strafe1 + (rot * 1);
        double FL_forward1 = forward1 - (rot * -1);
        double FLModSpeed = Math.sqrt(Math.pow(FL_strafe1, 2) + Math.pow(FL_forward1, 2));

        //BR, Rx = 1, Ry = -1
        double BR_strafe1 = strafe1 + (rot * -1);
        double BR_forward1 = forward1 - (rot * 1);
        double BRModSpeed = Math.sqrt(Math.pow(BR_strafe1, 2) + Math.pow(BR_forward1, 2));

        //BL, Rx = -1, Ry = -1
        double BL_strafe1 = strafe1 + (rot * -1);
        double BL_forward1 = forward1 - (rot * -1);
        double BLModSpeed = Math.sqrt(Math.pow(BL_strafe1, 2) + Math.pow(BL_forward1, 2));

        //Find the actual angle set
        double FR_ModHeadingRef = Math.atan2(FR_forward1, FR_strafe1)*180/Math.PI;
        double FL_ModHeadingRef = Math.atan2(FL_forward1, FL_strafe1)*180/Math.PI;
        double BR_ModHeadingRef = Math.atan2(BR_forward1, BR_strafe1)*180/Math.PI;
        double BL_ModHeadingRef = Math.atan2(BL_forward1, BL_strafe1)*180/Math.PI;

        //find motor power
        double max1 = Math.max(Math.abs(FRModSpeed), Math.abs(FLModSpeed));
        double max2 = Math.max(Math.abs(BRModSpeed), Math.abs(BLModSpeed));
        double MAX = Math.max(max1, max2);

        if (MAX > 1){
            FRModSpeed /= MAX;
            FLModSpeed /= MAX;
            BRModSpeed /= MAX;
            BLModSpeed /= MAX;

        }
        //set drive commands
        FR_mod.drive(FRModSpeed, FR_ModHeadingRef);
        FL_mod.drive(FLModSpeed, FL_ModHeadingRef);
        BR_mod.drive(BRModSpeed, BR_ModHeadingRef);
        BL_mod.drive(BLModSpeed, BL_ModHeadingRef);
    }
}