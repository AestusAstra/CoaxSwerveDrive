package org.firstinspires.ftc.teamcode.KIRIN.Subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.KIRIN.RobotConstants;
import org.firstinspires.ftc.teamcode.KIRIN.Util.CrServoCaching;
import org.firstinspires.ftc.teamcode.KIRIN.Util.myDcMotorEx;


public class SwerveModule {
    double Kp = RobotConstants.SwerveModKp;
    double Ki = RobotConstants.SwerveModKi;
    double Kd = RobotConstants.SwerveModKd;
    double Kf = RobotConstants.SwerveModKf;
    double Kl = RobotConstants.SwerveModKl;

    public SwerveModule(myDcMotorEx m, CrServoCaching S) {
        m.setDirection(DcMotorSimple.Direction.FORWARD);
        m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        m.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        m.setPowerThresholds(0.05, 0.05);



    }

}

