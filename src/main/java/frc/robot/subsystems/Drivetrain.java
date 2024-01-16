package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DrivetrainConstants;

public class Drivetrain extends SubsystemBase {
    private CANSparkMax m_leftMotor1 = new CANSparkMax(DrivetrainConstants.LEFT_MOTOR_1_PORT, MotorType.kBrushless);
    private CANSparkMax m_leftMotor2 = new CANSparkMax(DrivetrainConstants.LEFT_MOTOR_2_PORT, MotorType.kBrushless);

    private CANSparkMax m_rightMotor1 = new CANSparkMax(DrivetrainConstants.RIGHT_MOTOR_1_PORT, MotorType.kBrushless);
    private CANSparkMax m_rightMotor2 = new CANSparkMax(DrivetrainConstants.RIGHT_MOTOR_2_PORT, MotorType.kBrushless);

    private DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor1, m_rightMotor1);

    public Drivetrain () {
        m_leftMotor2.follow(m_leftMotor1);
        m_rightMotor2.follow(m_rightMotor1);

        m_leftMotor1.setInverted(true);
    }

    public Command drive(double speed, double rotation) {
        return run(() -> m_drive.arcadeDrive(speed, rotation));
    }

    public Command drive(DoubleSupplier speedSupplier, DoubleSupplier rotationSupplier) {
        return run(() -> m_drive.arcadeDrive(speedSupplier.getAsDouble(), rotationSupplier.getAsDouble()));
    }
}
