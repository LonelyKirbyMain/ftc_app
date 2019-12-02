package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

//This is a test autonomous to see if I can extend AutonomousFramework to avoid rewriting code.
@Autonomous(name = "Test", group = "Autonomous")
public class Test extends AutonomousFramework {
    @Override
    public void runOpMode() throws InterruptedException {
        runSetup();
        Utils.moveToEncoderPosition(armVertical, armVertical.getCurrentPosition() + 1000, 1);
        while(armVertical.isBusy() && opModeIsActive) {
            telemetry.addData(armVertical.getCurrentPosition(), )
        }

    }
}
