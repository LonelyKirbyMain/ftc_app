package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "TeamedWithGod", group = "Autonomous")
public class TeamedWithGod extends AutonomousFirst {
    @Override
    public void runOpMode() throws InterruptedException {
        runSetup();
        driveCm(1,88,88);

    }
}
