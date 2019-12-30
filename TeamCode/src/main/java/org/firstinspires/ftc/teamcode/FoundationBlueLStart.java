package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = ":FoundationBlueLStart", group = "Autonomous")
public class FoundationBlueLStart extends AutonomousFramework {
    @Override
    public void runOpMode() throws InterruptedException {
        runSetup();
        turnDegrees(1,-25);
        driveCm(1,82,82);
        turnDegrees(1, 25);
        //servo command attach
        driveCm(1,72,72);
        turnDegrees(1,-10);
        //servo command release
        turnDegrees(1,-80);
        driveCm(1,120,120);
    }
    /*Left Start, Facing away from wall, Turns a bit to the left, moves forward
    turns back to the right the same amount
    attaches the foundation mover
    drives over to build zone
    Moves foundation over build zone
     */

}
