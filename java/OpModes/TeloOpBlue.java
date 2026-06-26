package OpModes;


import static Wrappers.Initializer.gm1;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import Components.Intake;
import Components.Storage;
import Components.Turret;
import Wrappers.Initializer;
import Components.Chassis;
import Wrappers.Odo;

@TeleOp
public class TeloOpBlue extends LinearOpMode {
    Chassis chassis;
    Turret turret;
    Storage storage;
    Intake intake;
    Odo odometrie;
    public void runOpMode(){
        Initializer.start(hardwareMap);
        chassis = new Chassis();
        turret = new Turret();
        storage = new Storage();
        intake = new Intake();
        odometrie = new Odo(hardwareMap);
        waitForStart();

        while (opModeIsActive()){
            gm1.copy(gamepad1);
            chassis.update();
            intake.update();
            storage.update();
            turret.update();
        }
    }
}
