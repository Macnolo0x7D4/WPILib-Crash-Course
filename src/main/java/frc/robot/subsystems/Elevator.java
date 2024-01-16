package frc.robot.subsystems;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorConstants;

public class Elevator extends SubsystemBase {
    private TalonFX m_motor = new TalonFX(ElevatorConstants.ELEVATOR_MOTOR_PORT);
    private PIDController m_pid = new PIDController(2, 0, 0);

    public Command move(double pos) {
        return runOnce(() -> m_pid.setSetpoint(pos));
    }

    @Override
    public void periodic() {
        StatusSignal<Double> positionSupplier = m_motor.getPosition();
        
        double speed = m_pid.calculate(positionSupplier.getValueAsDouble());
        m_motor.set(speed);
    }
}
