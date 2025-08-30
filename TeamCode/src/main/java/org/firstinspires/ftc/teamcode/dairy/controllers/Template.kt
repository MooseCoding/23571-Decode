package org.firstinspires.ftc.teamcode.dairy.control

import com.acmerobotics.dashboard.config.Config
import com.qualcomm.robotcore.hardware.DcMotor

class Template(
    var motor: DcMotor // or any other input type but let's use a motor
) {

    fun calculate():Double { // Calculate will calculate the value the motor/input will have to run at
        return 0.0+0.0 // Whatever you need to calculate
    }

    var target:Int = 0 // So we can set the target easily

    fun update(): Double {
        return calculate() // Update pretty much returns calculate and if you need to do any other checks, have them here
    }
}