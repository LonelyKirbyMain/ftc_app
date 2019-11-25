package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "TeamedWithGod", group = "Autonomous")
public class TeamedWithGod extends AutonomousFirst {
    @Override
    public void runOpMode() throws InterruptedException {
        runSetup();
        sleep(25000);
        driveCm(1,88,88);

    }
}
