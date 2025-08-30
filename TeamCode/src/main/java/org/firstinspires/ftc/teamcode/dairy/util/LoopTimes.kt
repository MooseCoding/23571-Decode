package org.firstinspires.ftc.teamcode.dairy.util

import dev.frozenmilk.dairy.core.Feature
import dev.frozenmilk.dairy.core.dependency.Dependency
import dev.frozenmilk.dairy.core.dependency.annotation.SingleAnnotation
import dev.frozenmilk.dairy.core.wrapper.Wrapper
import org.firstinspires.ftc.robotcore.external.Telemetry
import java.lang.annotation.Inherited

class LoopTimes(): Feature {
    override var dependency: Dependency<*> = SingleAnnotation(
        Attach::class.java
    )

    private val startTime = System.nanoTime()
    private var lastTime = startTime
    private var loops = 0


    private fun time(telemetry: Telemetry) {
        val currentTime = System.nanoTime()
        val instantLoopTime = .000001 * (currentTime - lastTime)
        val instantHz = 1 / (instantLoopTime / 1000)
        val averageLoopTime = (.000001 * (currentTime - startTime)) / loops
        val averageHz = loops / (averageLoopTime / 1000)

        telemetry.addData("Instantaneous Loop Time", instantLoopTime)
        telemetry.addData("Instantaneous Loop Hz", instantHz)
        telemetry.addData("Average Loop Time", averageLoopTime)
        telemetry.addData("Average Loop Hz", averageHz)

        lastTime = currentTime
        loops += 1
    }

    override fun preUserInitHook(opMode: Wrapper) {}

    override fun postUserInitHook(opMode: Wrapper) {
        time(opMode.opMode.telemetry)
    }

    override fun postUserInitLoopHook(opMode: Wrapper) {
        time(opMode.opMode.telemetry)
    }

    override fun postUserStartHook(opMode: Wrapper) {
        time(opMode.opMode.telemetry)
    }

    override fun postUserLoopHook(opMode: Wrapper) {
        time(opMode.opMode.telemetry)
    }

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.CLASS)
    @Inherited
    annotation class Attach
}