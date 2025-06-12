package org.firstinspires.ftc.teamcode.pedroPathing.util

import com.pedropathing.follower.Follower
import com.pedropathing.localization.Pose
import com.pedropathing.pathgen.PathChain

fun isClose(path: PathChain, pathState:Int, follower:Follower): Boolean {
    var target: Pose = Pose(path.getPath(pathState-1).getPoint(1.0).x, path.getPath(pathState-1).getPoint(1.0).y)
    var x:Boolean = false
    var y:Boolean = false

    x = if(follower.pose.x < target.x) {
        follower.pose.x > target.x - 0.2
    } else {
        follower.pose.x < target.x + 0.2
    }

    y = if(follower.pose.y < target.y) {
        follower.pose.y > target.y - 0.2
    } else {
        follower.pose.y < target.y + 0.2
    }

    return x && y
}

