package org.firstinspires.ftc.teamcode.KIRIN.Subsystems;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.photon.PhotonCore;

public class Robot {

    private final SwerveDrive Swerve;


    // Setup in your Robot class if you have one, or in init at start of opMode
// Don't do manual or auto bulk caching elsewhere - do it here.

    public Robot (HardwareMap hardwareMap) {
        PhotonCore.CONTROL_HUB.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        PhotonCore.EXPANSION_HUB.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        PhotonCore.experimental.setMaximumParallelCommands(8); // Can be adjusted based on user preference - but raising this number further can cause issues
        PhotonCore.enable();

        Swerve = new SwerveDrive(hardwareMap);


    }

    public void drive(double strafe, double forward, double rot) {
        Swerve.drive(strafe, forward, rot);

    }




}


