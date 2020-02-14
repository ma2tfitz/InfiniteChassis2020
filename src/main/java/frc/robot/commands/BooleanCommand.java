/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example command that uses an example subsystem.
 */
public class BooleanCommand extends CommandBase {

  private boolean testBool = false;
  /**
   * Creates a new BooleanCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public BooleanCommand() {
  }

  public boolean getTestBool() {
    return testBool;
  }

  public void sendTestBool() {
    SmartDashboard.putBoolean("TestBool", testBool);
  }
    
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    testBool = true;
    sendTestBool();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      testBool = false;
      sendTestBool();
      if (interrupted) {
	      System.out.println("***** testBool interrupted");
      }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
