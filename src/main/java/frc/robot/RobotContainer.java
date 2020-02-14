/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.BooleanCommand;
import frc.robot.commands.LimelightAutoTrack;
import frc.robot.subsystems.Limelight;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static DifferentialDrive m_drive;
  public static XboxController driverXbox = new XboxController(1);
  public static Limelight m_limelight = new Limelight();
  public static RobotContainer m_robotContainer = new RobotContainer();
  //public final Limelight m_exampleSubsystem = new Limelight();

  public CANSparkMax frontLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
  public CANSparkMax frontRightMotor = new CANSparkMax(2, MotorType.kBrushless);
  public CANSparkMax backLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
  public CANSparkMax backRightMotor = new CANSparkMax(4, MotorType.kBrushless);

// The robot's subsystems and commands are defined here...

  private static final int A_BUTTON_XBOX = 1;
  private static final int B_BUTTON_XBOX = 2;
  private static final int X_BUTTON_XBOX = 3;
  private static final int Y_BUTTON_XBOX = 4;
  private static final int LEFT_BUMPER_XBOX = 5;
  private static final int RIGHT_BUMPER_XBOX = 6;
  private static final int BACK_ARROW = 7;
  private static final int START_ARROW = 8;
  private static final int JOYSTICK_RIGHT_CLICK = 10;
  private static final int JOYSTICK_LEFT_CLICK = 9;

  private final XboxController driverXBox = new XboxController(1);
  private final XboxController controllerXBox = new XboxController(2);

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton limelightButton = new JoystickButton(driverXBox, X_BUTTON_XBOX);
    limelightButton.whileHeld(new LimelightAutoTrack());

    JoystickButton toggleButton = new JoystickButton(driverXBox, A_BUTTON_XBOX);
    toggleButton.toggleWhenPressed(new BooleanCommand());
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  //   return m_autoCommand;
  // }
}
