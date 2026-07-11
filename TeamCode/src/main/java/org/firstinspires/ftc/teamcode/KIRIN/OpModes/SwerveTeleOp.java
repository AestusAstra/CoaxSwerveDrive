package org.firstinspires.ftc.teamcode.KIRIN.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.KIRIN.RobotConstants;
import org.firstinspires.ftc.teamcode.KIRIN.Subsystems.Robot;

@TeleOp(name = "SwerveTeleop (Lizard.  Lizard.  Lizard)", group = "main")
public class SwerveTeleOp extends LinearOpMode {
    Robot robot;

    @Override
    public void runOpMode() {
        robot = new Robot(telemetry, hardwareMap);
        long lastLoopTime = 0;

        while (opModeIsActive()) {
            //inputs
            double DriveScale = RobotConstants.SpeedScale;
            double RotScale = RobotConstants.RotScale;
            double forward = gamepad1.left_stick_y * DriveScale;
            double strafe = gamepad1.left_stick_x * DriveScale;
            double rot = gamepad1.right_stick_x * RotScale;

            // THAT'S WHAT I'M TALKING ABOUT!
            robot.drive(forward, strafe, rot);




            //droop time checker zoop zoop zop
            long currentTime = System.currentTimeMillis();
            long loopTime = currentTime - lastLoopTime;
            lastLoopTime = currentTime;

            telemetry.addData("Loop Time (ms)", loopTime);
            telemetry.addData("Frequency (Hz)", 1000.0 / loopTime);
            telemetry.update();
        }




    }




}
