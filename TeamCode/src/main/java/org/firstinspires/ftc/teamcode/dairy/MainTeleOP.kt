package org.firstinspires.ftc.teamcode.dairy

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import dev.frozenmilk.mercurial.Mercurial
import org.firstinspires.ftc.teamcode.dairy.subsystems.Drivetrain

// Use @subsystem.Attach to use a subsystem and make sure Mercurial is attached
@Mercurial.Attach
@Drivetrain.Attach
@TeleOp
class MainTeleOP: OpMode() {
    override fun init() {
        // Use Mercurial.gamepadX.button.onTrue or such

    }

    override fun init_loop() {
    }

    override fun start() {
    }

    override fun loop() {
        telemetry.apply {}
        telemetry.update()
    }

}
