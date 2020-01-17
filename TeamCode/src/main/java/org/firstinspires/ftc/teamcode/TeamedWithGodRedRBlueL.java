package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "TeamedWithGodRedRBlueL", group = "Autonomous")
public class TeamedWithGodRedRBlueL extends AutonomousFramework {
    @Override
    public void runOpMode() throws InterruptedException {
        runSetup();
        driveCm(1,60,60);
        turnDegrees(1,90);
        driveCm(1,88,88);

    }
}
