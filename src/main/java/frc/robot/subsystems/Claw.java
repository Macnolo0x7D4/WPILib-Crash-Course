package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClawConstants;

public class Claw extends SubsystemBase {    
    private Servo m_servo = new Servo(ClawConstants.CLAW_SERVO_PORT);

    public Claw() {
        m_servo.set(0.5);
    }

    public Command open() {
        return runOnce(() -> m_servo.set(0));
    }

    public Command close() {
        return runOnce(() -> m_servo.set(0.5));
    }
}