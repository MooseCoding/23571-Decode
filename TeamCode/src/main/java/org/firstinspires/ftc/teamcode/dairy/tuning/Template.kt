package org.firstinspires.ftc.teamcode.dairy.tuning

import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import dev.frozenmilk.mercurial.Mercurial
import org.firstinspires.ftc.teamcode.dairy.subsystems.Template

@Mercurial.Attach
@Template.Attach // Attach the subsystem or subsystems that you will be testing

@TeleOp
@Disabled // Always disable your tuning programs unless in use, only exception is the drive one
class Template: OpMode() {
    override fun init() {
        // Setup your controller if needed
    }

    override fun loop() {
        // Add any needed telemetry here
    }
}