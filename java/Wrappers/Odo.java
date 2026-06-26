package Wrappers;


import static Wrappers.Initializer.pp;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
public class Odo {
    public double offsetX = 0 ,offestY = 0;
    public Odo(HardwareMap hw){
        pp.setOffsets(offsetX,offestY, DistanceUnit.MM);
        pp.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        pp.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
    }
    public void update(){
        pp.update();
    }
    public static double getX(){
        return pp.getPosX(DistanceUnit.MM);
    }
    public static double getY(){
        return  pp.getPosY(DistanceUnit.MM);
    }
    public static double getHeading(){
        return pp.getHeading(AngleUnit.RADIANS);
    }
}
