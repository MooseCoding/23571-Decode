package org.firstinspires.ftc.teamcode.dairy.util

import com.qualcomm.hardware.lynx.LynxModule
import dev.frozenmilk.dairy.core.Feature
import dev.frozenmilk.dairy.core.dependency.Dependency
import dev.frozenmilk.dairy.core.dependency.annotation.SingleAnnotation
import dev.frozenmilk.dairy.core.wrapper.Wrapper
import org.firstinspires.ftc.teamcode.dairy.subsystems.Outtake.Attach

object BulkReads : Feature {
    @Target(AnnotationTarget.CLASS)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Attach

    override var dependency: Dependency<*> = SingleAnnotation(Attach::class.java)

    private lateinit var modules: List<LynxModule>

    override fun preUserInitHook(opMode: Wrapper) {
        modules = opMode.opMode.hardwareMap.getAll(LynxModule::class.java)
        modules.forEach {it.bulkCachingMode = LynxModule.BulkCachingMode.MANUAL}
    }

    override fun preUserInitLoopHook(opMode: Wrapper) {
        modules.forEach { it.clearBulkCache() }
    }

    override fun preUserStartHook(opMode: Wrapper) {
        modules.forEach { it.clearBulkCache() }
    }

    override fun preUserLoopHook(opMode: Wrapper) {
        modules.forEach { it.clearBulkCache() }
    }

    override fun cleanup(opMode: Wrapper) {
        modules = emptyList()
    }
}