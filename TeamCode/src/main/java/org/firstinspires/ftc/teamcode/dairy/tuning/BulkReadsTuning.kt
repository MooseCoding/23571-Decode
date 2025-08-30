package org.firstinspires.ftc.teamcode.dairy.tuning

import com.acmerobotics.dashboard.FtcDashboard
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import dev.frozenmilk.dairy.core.FeatureRegistrar
import dev.frozenmilk.dairy.core.FeatureRegistrar.checkFeatures
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.dairy.util.BulkReads
import org.firstinspires.ftc.teamcode.dairy.util.LoopTimes

@BulkReads.Attach
@LoopTimes.Attach
@FeatureRegistrar.LogDependencyResolutionExceptions

@TeleOp
class BulkReadsTuning: OpMode() {
    init {
    }

    lateinit var t: MultipleTelemetry

    override fun init() {
        t = MultipleTelemetry(telemetry, FtcDashboard.getInstance().telemetry)
    }


    override fun loop() {
        t.update()
    }

}