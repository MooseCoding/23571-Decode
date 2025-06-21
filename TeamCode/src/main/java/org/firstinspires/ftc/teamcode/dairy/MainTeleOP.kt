package org.firstinspires.ftc.teamcode.dairy

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import dev.frozenmilk.mercurial.Mercurial
import org.firstinspires.ftc.teamcode.dairy.subsystems.Drivetrain
import org.firstinspires.ftc.teamcode.dairy.subsystems.Endgame
import org.firstinspires.ftc.teamcode.dairy.subsystems.Outtake
import org.firstinspires.ftc.teamcode.dairy.subsystems.Intake
import org.firstinspires.ftc.teamcode.dairy.util.BulkReads

// Use @subsystem.Attach to use a subsystem and make sure Mercurial is attached
@Mercurial.Attach
@Drivetrain.Attach
@Intake.Attach
@Outtake.Attach
@Endgame.Attach
@BulkReads.Attach

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
