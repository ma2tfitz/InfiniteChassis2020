/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class LimelightDistanceCommand extends CommandBase {
  
  private static final double TARGET_AREA = 0.99;
  private static final double MAX_AREA_ABS_ERROR = 0.005;

  private DriveSubsystem m_robotDrive;
  private LimelightSubsystem m_limelight;

  public LimelightDistanceCommand(LimelightSubsystem limelight, DriveSubsystem robotDrive) {
    m_limelight = limelight;
    m_robotDrive = robotDrive;
    addRequirements(m_limelight, m_robotDrive);
  }
  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    double leftSpeed = 0.0;
    double rightSpeed = 0.0;
    if (!m_limelight.hasTarget()){
      leftSpeed = 0.0;
      rightSpeed = 0.0;
    } else {
        double v = (TARGET_AREA - m_limelight.getArea()) * 3.00;
        if(v > 0){
          v += 0.001;
        } else if (v < 0){
          v -= 0.001;
        }
        v = MathUtil.clamp(v, -0.60, 0.60);
        leftSpeed = v;
        rightSpeed = v;
    }
    SmartDashboard.putNumber("Left Speed", leftSpeed);    
    SmartDashboard.putNumber("Right Speed", rightSpeed);
    m_robotDrive.tankDrive(leftSpeed, rightSpeed);    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return !m_limelight.hasTarget() || Math.abs(TARGET_AREA - m_limelight.getArea()) < MAX_AREA_ABS_ERROR;
  }
}
