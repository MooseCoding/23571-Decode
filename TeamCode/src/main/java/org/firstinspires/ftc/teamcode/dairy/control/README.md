# Controllers

The controls folder is where we can setup our controllers for anything and if we had a needed controller, we can make it. A controller refines our data we read from the robot and figures out what to do to achieve whatever we tell it to do, then we can take that output from the controller and set it to the motors power. See the example code's Lift subsystem for how it works.

# Examples

PID - normal PID

PIDF - u_pid + u_ff

LQR - linear quadratic regression (x dot = Ax+Bu, and setup a set of Diff Eqs)

