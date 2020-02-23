/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;

public class IRSensorSubsystem extends SubsystemBase {
  private AnalogInput intakeSensor = new AnalogInput(0);
  //private AnalogInput indexSensor = new AnalogInput(1);

  public IRSensorSubsystem() {

  }

  @Override
  public void periodic() {
  }

  public boolean intakeHasBall(){
    System.out.println(intakeSensor.getVoltage());
    return intakeSensor.getVoltage() < 1;
  }
}
