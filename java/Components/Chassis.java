package Components;
import static Wrappers.Initializer.backLeft;
import static Wrappers.Initializer.backRight;
import static Wrappers.Initializer.frontLeft;
import static Wrappers.Initializer.frontRight;
import static Wrappers.Initializer.gm1;

import com.qualcomm.robotcore.hardware.DcMotor;
import Wrappers.Odo;
public class Chassis {
    public static double lateralMultiplier = 1.2;

    public Chassis(){
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void update(){
        double X = gm1.left_stick_x * lateralMultiplier;
        double Y = -gm1.left_stick_y;

        double heading = -Odo.getHeading();
        double x = X * Math.cos(heading) - Y * Math.sin(heading);
        double y = X * Math.sin(heading) + Y * Math.cos(heading);

        double yaw = gm1.right_trigger - gm1.left_trigger;

        double putere_sf = y + x + yaw;
        double putere_ss = y - x + yaw;
        double putere_df = y - x - yaw;
        double putere_ds = y + x - yaw;

        double max = Math.max(Math.abs(putere_sf), Math.max(Math.abs(putere_ss), Math.max(Math.abs(putere_df), Math.abs(putere_ds))));

        if (max > 1.0) {
            frontLeft.setPower(putere_sf / max);
            backLeft.setPower(putere_ss / max);
            frontRight.setPower(putere_df / max);
            backRight.setPower(putere_ds / max);
        } else {
            frontLeft.setPower(putere_sf);
            backLeft.setPower(putere_ss);
            frontRight.setPower(putere_df);
            backRight.setPower(putere_ds);
        }
    }
}