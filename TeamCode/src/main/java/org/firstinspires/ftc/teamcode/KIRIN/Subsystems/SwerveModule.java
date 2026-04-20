package org.firstinspires.ftc.teamcode.KIRIN.Subsystems;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.KIRIN.RobotConstants;
import org.firstinspires.ftc.teamcode.KIRIN.Util.CrServoCaching;
import org.firstinspires.ftc.teamcode.KIRIN.Util.PIDcontroller;
import org.firstinspires.ftc.teamcode.KIRIN.Util.myDcMotorEx;


public class SwerveModule {
    double Kp = RobotConstants.SwerveModKp;
    double Ki = RobotConstants.SwerveModKi;
    double Kd = RobotConstants.SwerveModKd;
    double Kf = RobotConstants.SwerveModKf;
    double Kl = RobotConstants.SwerveModKl;

    private final myDcMotorEx motor;
    private final CrServoCaching servo;
    private final AnalogInput Encoder;

    static double Offset;

    private final PIDcontroller ModHeadingPID = new PIDcontroller(0,0,0,0,0);

    public SwerveModule(myDcMotorEx m, CrServoCaching S, AnalogInput e, double fb, double lr, double offset) {
        motor = m;
        servo = S;
        Encoder = e;
        Offset = offset;
        m.setDirection(DcMotorSimple.Direction.FORWARD);
        m.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        m.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        m.setPowerThresholds(0.05, 0.05);




    }



    public void drive (double WheelSpeed, double ModHeadingRef){
        //update PIDcontroller
        ModHeadingPID.setPIDgains(Kp, Ki, Kd, Kf, Kl);

        double ModHeading = Encoder.getVoltage()/3.3 * 360 - SwerveModule.Offset;
        servo.setPower(ModHeadingPID.pidOut(ModHeadingRef - ModHeading));
        motor.setPower(WheelSpeed);





    }

}
