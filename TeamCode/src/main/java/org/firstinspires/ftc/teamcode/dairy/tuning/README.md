# Explanation

Tuning is where we can have our opmodes that tune the robot. So if we want to test a subsystem, we can make a tuner for that. This allows us to debug our code easier and test functionality while not making any weird changes to the code. 

# Instructions

Name your tuning files as such (in camel case):

SubsystemTuning.kt


# Rules

MAKE SURE YOUR TESTING IS CLEARED OUT AT THE END OF EACH FILE

Have an @Disabled in the annotations of your tuner when not in use, so it doesn't clog up the driver hub.

Make sure that this one program can fully debug any issue on your subsystem 


Only exception is Drive.kt due to its importance and because I said so 


