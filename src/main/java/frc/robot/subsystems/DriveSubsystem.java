/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.Robot;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new Drive.
   */
  public DriveSubsystem() {
    RobotContainer.m_robotContainer.backLeftMotor.follow(RobotContainer.m_robotContainer.frontLeftMotor);
    RobotContainer.m_robotContainer.backRightMotor.follow(RobotContainer.m_robotContainer.frontRightMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
