package Components;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.HardwareMap;

import OpModes.TeloOpBlue;
import Wrappers.Odo;
public class Shooter {
    Odo odometrie =new Odo(hardwareMap);
    double goal_x= 140, goal_y=140;
        public void update(){
            double delta_x=goal_x-odometrie.getX();
            double delta_y= goal_y-odometrie.getY();
            double distance_robot_goal=Math.sqrt(delta_x*delta_x+delta_y*delta_y);
        }
}
