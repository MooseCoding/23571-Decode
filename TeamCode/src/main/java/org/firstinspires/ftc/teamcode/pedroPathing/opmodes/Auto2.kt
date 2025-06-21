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
    private val initPose: Pose = Pose(0.0,0.0,0.0) // Initial pose of the robot

    // This is the function to generate the path that we'll use to traverse the field on
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
                    // Use positive integers on the interval [1, pathChain.length] to have your logic code
                    // This is when your position will be at the start of pathChain[i] where i is your integer
                }
            }
            follower.followPath(path.getPath(pathState)) // Follow the path
            pathState++ // Increase our path state
        }
    }

    override fun init() {
        follower = Follower(hardwareMap, FConstants::class.java, LConstants::class.java) // Setting up the follower
        follower.setStartingPose(initPose) // Setting intial pose of the robot on the field for follower
        path = GeneratedPath() // Generating our path
    }

    override fun loop() {
        follower.update() // Update our follower to get our current information

        autonomousPathUpdate() // Update our autonomous path to continue or run any thing we need

        telemetry.apply {
            addData("Robot X Position", follower.pose.x)
            addData("Robot Y Position", follower.pose.y)
            addData("Robot Heading", follower.pose.heading)
        } // Add logging data
        telemetry.update() // Send logging data
    }

}