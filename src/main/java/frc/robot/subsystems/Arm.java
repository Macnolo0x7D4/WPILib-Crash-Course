package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    private Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 1);

    public Arm() {
        m_solenoid.set(false);
    }

    public Command toggle() {
        return Commands.runOnce(() -> m_solenoid.toggle(), this);
    }
}
