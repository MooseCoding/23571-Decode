package org.firstinspires.ftc.teamcode.dairy.commands

import dev.frozenmilk.mercurial.commands.Command
import dev.frozenmilk.mercurial.commands.Lambda
import dev.frozenmilk.mercurial.commands.groups.Sequential
import org.firstinspires.ftc.teamcode.dairy.subsystems.Template

val lambda1: Lambda = Lambda("Test Lambda 1")
val lambda2: Lambda = Lambda("Test Lambda 2")

// Example for creating a lambda for the command
fun Template(): Lambda  {
    return Lambda("insert_name") // Insert a name
        .setRequirements(Template) // Note this is the subsyste you will be using
        .setExecute {} // Have any things you want to run in here
        .setFinish{
            false // False means that we stop the lambda after the execution finishes
        }
}

// Example for creating a sequential for the command
fun Template2(): Sequential {
    return Sequential(
        lambda1, // The first command we want to run
        lambda2  // The second command
        // Any subsequent commands
    )
}