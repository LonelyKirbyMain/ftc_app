package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = ":FoundationBlueLStart", group = "Autonomous")
public class FoundationBlueLStart extends AutonomousFramework {
    @Override
    public void runOpMode() throws InterruptedException {
        runSetup();
        driveCm(1,10,10);
        turnDegrees(-1,45);
        driveCm(1,50,50);
        turnDegrees(-1, 135);
        driveCm(-0.5,30,30);
        moveFoundationMover(0.8);
        sleep(800);
        driveCm(1,50,50);
        moveFoundationMover(0);
        sleep(800);
        driveCm(1,10,10);
        turnDegrees(-1,95);
        driveCm(1,70,70);
        turnDegrees(-1,90);
        driveCm(1,120,120);
        turnDegrees(-1,90);
        driveCm(1, 70,70);
        turnDegrees(1,90);
        driveCm(-0.5,20,20);
        moveFoundationMover(0.8);
        driveCm(-1,40,40);
        moveFoundationMover(0);

        driveCm(1,20,20);
        turnDegrees(1,90);
        driveCm(1,70,70);
        turnDegrees(1,90);
        driveCm(1,90,90);
        turnDegrees(-1,90);
        driveCm(1,50,50);
    }
    /*Left Start, Facing away from wall, Turns a bit to the left, moves forward
    turns back to the right the same amount
    attaches the foundation mover
    drives over to build zone
    Moves foundation over build zone
     */

}
