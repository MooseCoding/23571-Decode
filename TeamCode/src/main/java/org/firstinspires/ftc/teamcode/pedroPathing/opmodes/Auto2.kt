package org.firstinspires.ftc.teamcode.pedroPathing.opmodes

import com.pedropathing.follower.Follower
import com.pedropathing.localization.Pose
import com.pedropathing.pathgen.BezierLine
import com.pedropathing.pathgen.PathBuilder
import com.pedropathing.pathgen.PathChain
import com.pedropathing.pathgen.Point
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import dev.frozenmilk.mercurial.Mercurial
import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants
import org.firstinspires.ftc.teamcode.pedroPathing.util.isClose

// THIS IS FOR THE OTHER SIDE AUTO (ie other start position)

@Mercurial.Attach

@Autonomous
class Auto2: OpMode() {

    // Variables and their setup
    private lateinit var follower: Follower // this is the follower for PP
    private lateinit var path: PathChain // this is the path we'll follow
    private var pathState: Int = 0 // This is counting which path we are currently on
    private val init_pose: Pose = Pose(0.0,0.0,0.0) // Intial pose of the robot

    fun GeneratedPath(): PathChain {
        val builder = PathBuilder()

        // Put the generated path from PP's Vercel in here

        builder.addPath(
            BezierLine(
                Point(0.0,0.0, Point.CARTESIAN),
                Point(0.0,0.0, Point.CARTESIAN),
            )
        )

        return builder.build()
    }
    fun autonomousPathUpdate() { // Note only increment path state when you can check isClose
        if(pathState == 0) {
            // This is the intial then we go into the switch statement
            pathState++
        }
        if(isClose(path, pathState,follower)) {
            when (pathState) {
                -1 -> {
                    // Use this as the end condition
                }

                1 -> {

                }
            }
        }
    }

    override fun init() {
        follower = Follower(hardwareMap, FConstants::class.java, LConstants::class.java)
        follower.setStartingPose(init_pose) // Setting intial pose of the robot on the field for follower
        path = GeneratedPath()
    }

    override fun loop() {
        autonomousPathUpdate()
        telemetry.apply {}
        telemetry.update()
    }

}