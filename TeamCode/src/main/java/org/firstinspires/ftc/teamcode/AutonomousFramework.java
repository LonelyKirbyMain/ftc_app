package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
@Autonomous(name = "AutonomousFramework", group = "Autonomous")
public class AutonomousFramework extends LinearOpMode {
    //------------------------------------------// claw variables:
    static final double INCREMENT = 0.01;     // amount to slew servo each CYCLE_MS cycle
    static final int CYCLE_MS = 50;     // period of each cycle
    static final double MAX_POS = 1.0;     // Maximum rotational position
    static final double MIN_POS = 0.0;     // Minimum rotational position
    //time
    private ElapsedTime runtime = new ElapsedTime();
    // Motor variables
    DcMotor FL = null;
    DcMotor FR = null;
    DcMotor BL = null;
    DcMotor BR = null;
    //DcMotor armVertical = null;
    private double leftPower;
    private double rightPower;
    private double clawPosition;
    Servo claw = null;
    Servo foundationMoverA = null;
    Servo foundationMoverB = null;
    Servo capstoneDropper = null;

    static final double ROBOT_WIDTH = 41; //cm. From wheel to wheel. THIS VALUE IS NOT CORRECT TODO: get a more accurate #
    //private static final double WHEEL_DIAMETER = 10.16; //cm.
    static final double COUNTS_PER_CM = 1000 / 28.25; //cm.
    //]static final double ARM_VERTICAL_COUNTS_PER_CM = 0; //TODO: test

    @Override
    public void runOpMode() throws InterruptedException {
        runSetup();

        //begin of actual code

    }

    /**
     * Sets up motors and resets the runtime.
     */
    void runSetup() {
        //setup
        FL = hardwareMap.get(DcMotor.class, "fl");
        FR = hardwareMap.get(DcMotor.class, "fr");
        BL = hardwareMap.get(DcMotor.class, "bl");
        BR = hardwareMap.get(DcMotor.class, "br");
        //armVertical = hardwareMap.get(DcMotor.class, "av");
        capstoneDropper = hardwareMap.get(Servo.class, "cd");
        foundationMoverA = hardwareMap.get(Servo.class, "fa");
        foundationMoverB = hardwareMap.get(Servo.class, "fb");

        //accounting for how the motors are mounted
        FL.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.REVERSE);
        FR.setDirection(DcMotor.Direction.FORWARD);
        BR.setDirection(DcMotor.Direction.FORWARD);
        //armVertical.setDirection(DcMotor.Direction.FORWARD);

        capstoneDropper.setPosition(0.9);//temporarily changed by Ethan for testing purposes
        foundationMoverB.setPosition(0);//temporarily changed
        foundationMoverA.setPosition(0);//also changed

        runtime.reset();

        waitForStart();
    }


    void setClawPosition() {

    }

    //Copied this over from OpModeFirst for Servo Coding   -Ethan
    void changeServoPosition(Servo servo, double increment) {
        servo.setPosition(servo.getPosition() + increment);
    }

    //A function that can move the foundation mover for autonomous    -Ethan
    void moveFoundationMover (double position) {
        foundationMoverB.setPosition(position);
        foundationMoverA.setPosition(position);
    }
    void moveClaw(double position) {
        claw.setPosition(position);
    }


    //felt cute, might delete later, idk
    void DriveForSeconds(double seconds, double rPower, double lPower) {
        double targetTime = runtime.time() + seconds;
        while (runtime.time() < targetTime && opModeIsActive()) {
            leftPower = lPower;
            rightPower = rPower;
        }
    }


    /**
     * Drives some amount of centimeters on each side at some speed.
     *
     * @param speed   the speed, between 0 and 1 please.
     * @param leftCm  the distance in cm to move the left of the robot.
     * @param rightCm the distance in cm to move the right of the robot.
     */
    void driveCm(double speed, double leftCm, double rightCm) {
        driveTicks(speed, (int) (leftCm * COUNTS_PER_CM), (int) (rightCm * COUNTS_PER_CM));

    }

    void driveTicks(double speed, int leftTicks, int rightTicks) {
        int FLTarget;  //Target positions (in ticks)
        int FRTarget; //for the motors.
        int BLTarget;
        int BRTarget;

        if (speed < 0) {
            FLTarget = FL.getCurrentPosition() - leftTicks; //maths
            FRTarget = FR.getCurrentPosition() - rightTicks;
            BLTarget = BL.getCurrentPosition() - leftTicks;
            BRTarget = BR.getCurrentPosition() - rightTicks;
        } else {
            FLTarget = FL.getCurrentPosition() + leftTicks; //maths
            FRTarget = FR.getCurrentPosition() + rightTicks;
            BLTarget = BL.getCurrentPosition() + leftTicks;
            BRTarget = BR.getCurrentPosition() + rightTicks;
        }
        FL.setTargetPosition(FLTarget); //set the target positions mmmm
        FR.setTargetPosition(FRTarget);
        BL.setTargetPosition(BLTarget);
        BR.setTargetPosition(BRTarget);

        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION); //set the run mode to the correct one
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //removed the absolute value function to allow backwards motion
        FL.setPower(speed); //go fast (or slow, i guess. you do you)
        FR.setPower(speed);
        BL.setPower(speed);
        BR.setPower(speed);

        //keep looping while opmode is active and the motors are working.
        //do the telemetry so i know what the hell is going on.
        while (opModeIsActive() && FL.isBusy() && FR.isBusy() && BL.isBusy() && BR.isBusy()) { //yell debug stuff. I should probably add more later for *debug purposes* owo
            //telemetry.addData("Path:", "%.3f cm :%.3f cm", leftCm, rightCm);
            //telemetry.update();
        }

        FL.setPower(0); //HALT!
        FR.setPower(0); //HALT!
        BL.setPower(0); //HALT!
        BR.setPower(0); //HALT! Who goes there?

        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //set motors back to normal run mode w/ encoders very cool.
        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    /**
     * Executes a point turn for given number of degrees clockwise.
     *
     * @param speed   the speed to turn at, between 0 and 1 please.
     * @param degrees how far to turn, from -360 to 360. Turns right if positive, left if negative.
     */
    void turnDegrees(double speed, double degrees) {
        double radians = Math.toRadians(degrees);
        telemetry.addData("Radians: ", "%.3f", radians);
        double turnDistance = radians * ROBOT_WIDTH / 2;
        driveCm(speed, turnDistance, -turnDistance);
    }
}
