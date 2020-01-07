package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = ":FoundationRedRStart", group = "Autonomous")
public class FoundationRedRStart extends AutonomousFramework {
    @Override
    public void runOpMode() throws InterruptedException {
        runSetup();
        driveCm(1,10,10);
        turnDegrees(1,45);
        driveCm(1,50,50);
        turnDegrees(1, 135);
        driveCm(-0.5,20,20);
        moveFoundationMover(0.8);
        sleep(800);
        driveCm(1,40,40);
        moveFoundationMover(0);
        sleep(800);
        driveCm(1,10,10);
        turnDegrees(1,95);
        driveCm(1,70,70);
        turnDegrees(1,90);
        driveCm(1,120,120);
        turnDegrees(1,90);
        driveCm(1, 70,70);
        turnDegrees(-1,90);
        driveCm(-0.5,20,20);
        moveFoundationMover(0.8);
        driveCm(-1,40,40);
        moveFoundationMover(0);
        driveCm(1,10,10);
        turnDegrees(-1,90);
        driveCm(1,70,70);
        turnDegrees(-1,90);
        driveCm(1,75,75);
        turnDegrees(1,90);
        driveCm(1,50,50);
    }
}

/*Foundation mover from Red Team Right start1
 Right start is on tile adjacent to the building zone
 Touching the wall and centered

This function can only move the foundation

 */