package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;

public class RobotContainer {
    private Drivetrain m_drivetrain = new Drivetrain();
    private Arm m_arm = new Arm();
    private Claw m_claw = new Claw();
    private Elevator m_elevator = new Elevator();
    
    private CommandXboxController m_controller = new CommandXboxController(OperatorConstants.CONTROLLER_PORT);

    public RobotContainer() {
        m_controller.a().onTrue(m_arm.toggle());

        m_controller.b().onTrue(m_claw.open()).onFalse(m_claw.close());

        m_controller.x().onTrue(m_elevator.move(0));
        m_controller.y().onTrue(m_elevator.move(5));

        m_drivetrain.setDefaultCommand(m_drivetrain.drive(() -> m_controller.getLeftY(), () -> m_controller.getRightX()));
    }

    public Command getAutonomous() {
        return Autos.auto1(m_drivetrain, m_claw);
    }
}
