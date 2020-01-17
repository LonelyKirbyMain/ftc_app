package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "TeamedWithGodRedLBlueR", group = "Autonomous")
public class TeamedWithGodRedLBlueR extends AutonomousFramework {
    @Override
    public void runOpMode() throws InterruptedException {
        runSetup();
        driveCm(1,60,60);
        turnDegrees(-1,95);
        driveCm(1,88,88);

    }
}
