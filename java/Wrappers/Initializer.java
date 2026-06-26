package Wrappers;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class
Initializer {
    public static GoBildaPinpointDriver pp;
    public static DcMotorEx frontLeft;
    public static DcMotorEx frontRight;
    public static DcMotorEx backLeft;
    public static DcMotorEx backRight;
    public static Gamepad gm1;
    public static Servo turet_1;
    public static Servo turet_2;
    public static  DcMotorEx motor_intake;
    public static AnalogInput encoder_storage;
    public static  DcMotorEx motor_storage;
    public static ColorSensor color_sensor;
    public static DistanceSensor sensor_distance;
    public static Servo shooter_transfer;
    public static DcMotorEx shooter_1;
    public static DcMotorEx shooter_2;
    public static void start(HardwareMap hardwareMap){
        gm1 = new Gamepad();
        pp = hardwareMap.get(GoBildaPinpointDriver.class,"pinpoint");
        frontLeft = hardwareMap.get(DcMotorEx.class,"frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class,"frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class,"backLeft");
        backRight = hardwareMap.get(DcMotorEx.class,"backRight");
        turet_1 = hardwareMap.get(Servo.class, "servo 1 tureta");
        turet_2 = hardwareMap.get(Servo.class, "servo 2 tureta");
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motor_intake= hardwareMap.get(DcMotorEx.class, "Motor intake");
        encoder_storage = hardwareMap.get(AnalogInput.class,"encoder storage");
        motor_storage= hardwareMap.get(DcMotorEx.class,"motor storage");
        sensor_distance= hardwareMap.get(DistanceSensor.class,"sensor distance");
        color_sensor =hardwareMap.get(ColorSensor.class,"color sensor");
        shooter_transfer=hardwareMap.get(Servo.class,"servo transfer");
        shooter_1 = hardwareMap.get(DcMotorEx.class,"motor shooter 1");
        shooter_2 = hardwareMap.get(DcMotorEx.class,"motor shooter 2");
    }
}
