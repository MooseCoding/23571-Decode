package org.firstinspires.ftc.teamcode.dairy.subsystems

import com.acmerobotics.dashboard.config.Config
import com.qualcomm.robotcore.hardware.DcMotorSimple
import dev.frozenmilk.dairy.core.FeatureRegistrar
import dev.frozenmilk.dairy.core.dependency.Dependency
import dev.frozenmilk.dairy.core.dependency.annotation.SingleAnnotation
import dev.frozenmilk.dairy.core.wrapper.Wrapper
import dev.frozenmilk.mercurial.Mercurial.gamepad1
import dev.frozenmilk.mercurial.Mercurial.gamepad2
import dev.frozenmilk.mercurial.commands.Lambda
import dev.frozenmilk.mercurial.subsystems.Subsystem
import java.lang.annotation.Inherited
import kotlin.math.abs
import kotlin.math.max

@Config // Required for FTC Dash to be active
object Drivetrain: Subsystem {
    // next 6 lines are boilerplate for Mercurial
    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.CLASS)
    @MustBeDocumented
    @Inherited
    annotation class Attach
    override var dependency: Dependency<*> = Subsystem.DEFAULT_DEPENDENCY and SingleAnnotation(Attach::class.java)

    // Getting the motors by a standarized system
    val fL by subsystemCell {
        FeatureRegistrar.activeOpMode.hardwareMap.dcMotor.get("frontLeft")
    }

    val bL by subsystemCell {
        FeatureRegistrar.activeOpMode.hardwareMap.dcMotor.get("backLeft")
    }

    val bR by subsystemCell {
        FeatureRegistrar.activeOpMode.hardwareMap.dcMotor.get("backRight")
    }

    val fR by subsystemCell {
        FeatureRegistrar.activeOpMode.hardwareMap.dcMotor.get("frontRight")
    }

    // This is after we press init pretty much setting up the update loop
    override fun postUserInitHook(opMode: Wrapper){
        fL!!.direction = DcMotorSimple.Direction.REVERSE
        bL!!.direction = DcMotorSimple.Direction.REVERSE

        defaultCommand = driveUpdate()
    }

    override fun postUserLoopHook(opMode: Wrapper) {
        // Additional loop stuff can go here
    }

    // Use @JvmField when we want to use FTC Dash
    @JvmField var driver1: Boolean = true


    // Our Drive command running the drive logic
    fun driveUpdate(): Lambda = Lambda("Drive")
        .setRequirements(Drivetrain)
        .setExecute {
        var max: Double

        // read the gamepads
        var axial: Double = gamepad1.leftStickY.state
        var lateral: Double = gamepad1.leftStickX.state
        var yaw: Double = gamepad1.rightStickX.state

        // see if driver 1 is controlling
        if(!driver1) {
            axial = gamepad2.leftStickY.state
            lateral = gamepad2.leftStickX.state
            yaw = gamepad2.rightStickX.state
        }

        var leftFrontPower: Double = (axial + lateral) + yaw
        var rightFrontPower: Double = (axial - lateral) - yaw
        var leftBackPower: Double = (axial - lateral) + yaw
        var rightBackPower: Double = (axial + lateral) - yaw


        max = max(abs(leftFrontPower), abs(rightFrontPower))
        max = max(max, abs(leftBackPower))
        max = max(max, abs(rightBackPower))

        if (max > 1.0) {
            leftFrontPower /= max
            rightFrontPower /= max
            leftBackPower /= max
            rightBackPower /= max
        }

        fL!!.power = leftFrontPower
        bL!!.power = leftBackPower
        bR!!.power = rightBackPower
        fR!!.power = rightFrontPower
        }
        .setFinish {
            false
        }
}