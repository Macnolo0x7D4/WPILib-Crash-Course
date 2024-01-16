package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;

public class Autos {
    public static Command auto1(Drivetrain drivetrain, Claw claw) {
        return Commands.sequence(
            Commands.parallel(
                drivetrain.drive(1, 0),
                claw.open()
            ),
            new WaitCommand(5),
            drivetrain.drive(0, 0)
        );
    }
}
