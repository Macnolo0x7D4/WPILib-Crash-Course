package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private RobotContainer m_container;
  private Command m_auto = null;

  @Override
  public void robotInit() {
    m_container = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    m_auto = m_container.getAutonomous();

    if (m_auto != null) {
      m_auto.schedule();
    }
  }

  @Override
  public void teleopInit() {
    if (m_auto != null) {
      CommandScheduler.getInstance().cancel(m_auto);
    }
  }
}
