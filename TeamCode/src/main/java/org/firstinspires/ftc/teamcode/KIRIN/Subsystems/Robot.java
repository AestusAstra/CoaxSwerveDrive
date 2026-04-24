package org.firstinspires.ftc.teamcode.KIRIN.Subsystems;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.photon.PhotonCore;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Robot {
    public final GoBildaPinpointDriver odo;
    private final SwerveDrive Swerve;
    double heading = 0;


    // Setup in your Robot class if you have one, or in init at start of opMode
    // Don't do manual or auto bulk caching elsewhere - do it here.
    public Robot (Telemetry telemetry, HardwareMap hardwareMap) {
        //PhotonCore to lower loop times
        PhotonCore.CONTROL_HUB.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        PhotonCore.EXPANSION_HUB.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        PhotonCore.experimental.setMaximumParallelCommands(8); // Can be adjusted based on user preference - but raising this number further can cause issues
        PhotonCore.enable();

        //Odometry, heading
        odo = hardwareMap.get(GoBildaPinpointDriver .class, "odo");
        odo.setOffsets(0, 0, DistanceUnit.MM);
        odo.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        odo.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD,
                GoBildaPinpointDriver.EncoderDirection.REVERSED);

        //Subsystems
        Swerve = new SwerveDrive(telemetry, hardwareMap);
    }

    public void drive(double strafe, double forward, double rot) {
        if (odo != null){odo.getHeading(AngleUnit.DEGREES);
        }
        Swerve.drive(strafe, forward, rot, heading);
    }

}