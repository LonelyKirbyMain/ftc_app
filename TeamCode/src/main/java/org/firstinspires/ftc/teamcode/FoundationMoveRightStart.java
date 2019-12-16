package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = ":FoundationMoveRightStart", group = "Autonomous")
public class FoundationMoveRightStart extends AutonomousFirst {
    @Override
    public void runOpMode() throws InterruptedException {
        runSetup();
        turnDegrees(1,25);
        driveCm(1,82,82);
        turnDegrees(1, -25);
        //servo command attach
        driveCm(1,72,72);
        turnDegrees(1,10);
        //servo command release
        turnDegrees(1,80);
        driveCm(1,120,120);

    }
}
