package org.firstinspires.ftc.teamcode.dairy.tuning

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import dev.frozenmilk.dairy.core.FeatureRegistrar
import dev.frozenmilk.dairy.core.FeatureRegistrar.checkFeatures
import org.firstinspires.ftc.teamcode.dairy.util.BulkReads

@BulkReads.Attach
@FeatureRegistrar.LogDependencyResolutionExceptions

@TeleOp
class BulkReadsTuning: OpMode() {
    init {
    }

    override fun init() {}

    override fun loop() {}

}