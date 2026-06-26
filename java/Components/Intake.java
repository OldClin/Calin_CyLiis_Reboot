package Components;
import static Wrappers.Initializer.gm1;
import static Wrappers.Initializer.motor_intake;

import Wrappers.Initializer;
public class Intake {
    public void update(){
        if(gm1.right_bumper){
            motor_intake.setPower(1);
        }
        else if(gm1.left_bumper){
            motor_intake.setPower(-1);
        }
        else
            motor_intake.setPower(0);
    }
}
