package Components;
import static Wrappers.Initializer.color_sensor;
import static Wrappers.Initializer.encoder_storage;
import static Wrappers.Initializer.motor_storage;
import static Wrappers.Initializer.sensor_distance;
import static Wrappers.Initializer.gm1;
import static Wrappers.Initializer.shooter_transfer;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import Wrappers.Initializer;
public class Storage {

    int artefacts[] = new int[4];
    double position_slot[]={0,15,135,285};
    int action=1;
    double deposit_angle,launch;
    private ElapsedTime timer=new ElapsedTime();
    public enum StorageState {
        COLLECTING, PREPARE_SHOOTING, SHOOTING
}
    private StorageState current_state=StorageState.COLLECTING;

    public Storage(){
        deposit_angle=position_slot[1];
                motor_storage.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


       public double get_error(double position){
           double error=(encoder_storage.getVoltage()*360)/3.3;
           error=position-error;
           if(error>180)
               error=error-360;
           if (error < -180) error = error + 360;
           return error;
        }

        public void storage_rotation(double error){

        if(Math.abs(error)<2){
            motor_storage.setPower(0);
            launch=1;
        }

            else
                motor_storage.setPower(error*0.02);
        }

        public void new_artefact(){
            shooter_transfer.setPosition(0);
                if (sensor_distance.getDistance(DistanceUnit.MM) < 50) {
                    int red = color_sensor.red();
                    int blue = color_sensor.blue();
                    int green = color_sensor.green();
                    if (action <= 3) {
                        if (green < 400 && red > 800 && blue > 800) {
                            artefacts[action] = 2;
                        } else {
                            artefacts[action] = 1;
                        }
                        action++;
                    }
                }
            if(action>3)
                current_state=StorageState.PREPARE_SHOOTING;
            }
            public void update(){

                 switch (current_state) {
                    case COLLECTING:

                         new_artefact();
                         if(action<=3){
                            storage_rotation(get_error(position_slot[action]));
                            launch=0;
                         }
                         break;

                     case PREPARE_SHOOTING:
                         if(artefacts[1]==1){
                             storage_rotation(get_error(180));
                         }
                         else if(artefacts[2]==1){
                             storage_rotation(get_error(60));
                         }
                         else{
                             storage_rotation(get_error(300));
                         }
                         shooter_transfer.setPosition(0.5);
                         if (launch == 1 && gm1.circle) {
                             timer.reset();
                             current_state = StorageState.SHOOTING;
                         }

                         break;
                     case SHOOTING:
                         if (timer.milliseconds() < 2000) {
                             motor_storage.setPower(-1);
                         } else {
                             motor_storage.setPower(0);
                             launch = 0;
                             action = 1;
                             current_state = StorageState.COLLECTING;
                         }
                 }


        }

}
