package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = ":FoundationBlueRStart", group = "Autonomous")
public class FoundationBlueRStart extends AutonomousFramework {
    @Override
    public void runOpMode() throws InterruptedException {
        runSetup();
        driveCm(1,176,176);
        turnDegrees(1,65);
        driveCm(1,82,82);
        turnDegrees(1, -155);
        //servo command attach
        driveCm(1,72,72);
        turnDegrees(1,-10);
        //servo command release
        turnDegrees(1,-80);
        driveCm(1,120,120);

    }
    /* Start on Right Facing Towards Bridge
    Drive to Left Start and Turn 65 Degrees
    Drive forward, turn around to face away from foundation
    Grab Foundation
    Drive back, turn a bit so foundation is over
    Release, drive to line
     */
}
