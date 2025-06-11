package org.firstinspires.ftc.teamcode.dairy.subsystems

import com.acmerobotics.dashboard.config.Config
import com.qualcomm.robotcore.hardware.DcMotorSimple
import dev.frozenmilk.dairy.core.FeatureRegistrar
import dev.frozenmilk.dairy.core.dependency.Dependency
import dev.frozenmilk.dairy.core.dependency.annotation.SingleAnnotation
import dev.frozenmilk.dairy.core.wrapper.Wrapper
import dev.frozenmilk.mercurial.commands.Lambda
import dev.frozenmilk.mercurial.subsystems.Subsystem
import org.firstinspires.ftc.teamcode.dairy.control.PID
import org.firstinspires.ftc.teamcode.dairy.util.Waiter
import java.lang.annotation.Inherited

@Config
object Outtake : Subsystem {
    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.CLASS)
    @MustBeDocumented
    @Inherited
    annotation class Attach

    override var dependency: Dependency<*> =
        Subsystem.DEFAULT_DEPENDENCY and SingleAnnotation(Attach::class.java)

    val motor by subsystemCell {
        FeatureRegistrar.activeOpMode.hardwareMap.dcMotor.get("motor_name")
    }

    override fun postUserInitHook(opMode: Wrapper) {

    }

    override fun postUserLoopHook(opMode: Wrapper) {

    }

}