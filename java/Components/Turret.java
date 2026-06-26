package Components;
import static Wrappers.Initializer.turet_1;
import static Wrappers.Initializer.turet_2;


import Wrappers.Odo;

public class Turret {

    double goal_x=0, goal_y=0;
    public void update(){

        double delta_x= goal_x-Odo.getX();
        double delta_y= goal_y-Odo.getY();

        double turet_angle_begining= Math.atan2(delta_y,delta_x);

        double turret_angle_final = turet_angle_begining-Odo.getHeading();

        double turet_servo_angle=Math.toDegrees(turret_angle_final)/360+0.5;
        turet_1.setPosition(turet_servo_angle);
        turet_2.setPosition(turet_servo_angle);
    }
}
