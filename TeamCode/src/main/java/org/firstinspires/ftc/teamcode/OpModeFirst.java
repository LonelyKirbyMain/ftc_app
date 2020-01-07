package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import static org.firstinspires.ftc.teamcode.Utils.getBatteryVoltage;

@TeleOp(name="Sbev's first steps", group="Iterative Opmode")
public class OpModeFirst extends OpMode {
    //time
    private ElapsedTime runtime = new ElapsedTime();

    // Motor variables
    private DcMotor FL = null;
    private DcMotor FR = null;
    private DcMotor BL = null;
    private DcMotor BR = null;

    //private Servo claw = null; //temporary uncomment for testing
    private Servo capstoneDropper = null;
    private Servo foundationMoverA = null;
    private Servo foundationMoverB = null;
    //------------------------------------------// claw variables:
    private static final double INCREMENT = 0.01;     // amount to slew servo each CYCLE_MS cycle
    private static final double MAX_POS = 1.0;     // Maximum rotational position
    private static final double MIN_POS = 0.5;     // Minimum rotational position
    //------------------------------------------// foundation variables:



    private double leftPower;
    private double rightPower;
    //private double clawPosition; //temporary uncomment for testing

    boolean dropped;


    @Override
    public void init() {
        //telemetry
        telemetry.addData("Status", "Initialized");

        //getting all the motors
        FL = hardwareMap.get(DcMotor.class, "fl");
        FR = hardwareMap.get(DcMotor.class, "fr");
        BL = hardwareMap.get(DcMotor.class, "bl");
        BR = hardwareMap.get(DcMotor.class, "br");
        //claw = hardwareMap.get(Servo.class, "claw"); //temporary uncomment for testing
        capstoneDropper = hardwareMap.get(Servo.class, "cd");
        foundationMoverA = hardwareMap.get(Servo.class, "fa");
        foundationMoverB = hardwareMap.get(Servo.class, "fb");

        //accounting for how the motors are mounted
        FL.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.REVERSE);
        FR.setDirection(DcMotor.Direction.FORWARD);
        BR.setDirection(DcMotor.Direction.FORWARD);

        capstoneDropper.setPosition(0.9);//temporarily changed by Ethan for testing purposes
        foundationMoverB.setPosition(0);//temporarily changed

        foundationMoverA.setPosition(0);//also changed

    }
    @Override
    public void start(){
        runtime.reset();
        //claw.setPosition((MAX_POS + MIN_POS) / 2);
        dropped = true;

    }

    @Override
    public void loop() {
        //these variables store power for left wheels and right wheels

        setDrivePower();
        //setClawPosition();

        if (gamepad1.a) {
            dropped = true;
        }

        FL.setPower(leftPower);
        BL.setPower(leftPower);
        FR.setPower(rightPower);
        BR.setPower(rightPower);
        //claw.setPosition(clawPosition);

        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);

    }

    private void setDrivePower() {

        if (Utils.getBatteryVoltage(hardwareMap) < 12.0d) {
            telemetry.addLine("Warning! Battery voltage is low");
        }

        telemetry.addData("Battery", "Voltage: %.2f", getBatteryVoltage(hardwareMap));

        //stores gamepad sticks in variables
        double drive = -gamepad1.left_stick_y;
        double turn = gamepad1.right_stick_x;

        //sets left and right power
        leftPower = Range.clip(drive + turn, -1.0, 1.0);
        rightPower = Range.clip(drive - turn, -1.0, 1.0);

        //Precision Mode
        boolean precisionMode = gamepad1.left_bumper;
        if (precisionMode) {  //if precision mode is on, left power and right power are set to 10% of what they would otherwise be.
            leftPower *= 0.1;
            rightPower *= 0.1;
        }

        if (gamepad1.a) changeServoPosition(capstoneDropper, 0.01);//Moves Capstone dropper
        else if (gamepad1.b) changeServoPosition(capstoneDropper, -0.01);//Moves capstone dropper

        //if (gamepad1.dpad_up)changeServoPosition(claw,0.01);
        //else if (gamepad1.dpad_down)changeServoPosition(claw, -0.01);

        if (gamepad1.x) {
            changeServoPosition(foundationMoverA, 0.01);
            changeServoPosition(foundationMoverB, 0.01);
        } else if (gamepad1.y) {
            changeServoPosition(foundationMoverA, -0.01);
            changeServoPosition(foundationMoverB, -0.01);
        }
        telemetry.addData("capstoneDropper:", capstoneDropper.getPosition());
        telemetry.addData("foundationMoverA:", foundationMoverA.getPosition());
        telemetry.addData("foundationMoverB:", foundationMoverB.getPosition());
        //telemetry.addData("claw", claw.getPosition());
    }

    /*private void setClawPosition() {
        double position = 0; //claw.getPosition();
        double increment = ((-gamepad2.right_stick_y + 1) / 2) * INCREMENT;
        position = Math.min(Math.max(position + increment, MIN_POS), MAX_POS);
        //telemetry.addData("Servo", "position: %.2f", position);
        clawPosition = position;

    }*/

    void changeServoPosition(Servo servo, double increment) {
        servo.setPosition(servo.getPosition() + increment);
    }

}
