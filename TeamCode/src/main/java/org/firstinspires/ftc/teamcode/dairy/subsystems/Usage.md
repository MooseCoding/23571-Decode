#  INSTRUCTIONS FOR SUBSYSTEM CREATION

Copy and paste the Template.kt object into your desired Subsystem.kt file

Then rename the Template object to Subsystem

Do not make a vision subsystem, let me (Topher) write the code for that one, it will be weirder and not a normal subsystem. I can handle it 



# STEPS FOR SUBSYSTEM CREATION

Here are the steps to make a subsystem

- [ ] Figure out your logic and make sure that its not already a subsystem or can be incorporated into an already created one

- [ ] Follow first instructions for making the file

- [ ] Grab your hardware map things (motor, sensor, servos) 

- [ ] Make your lambdas for interfacing with the hardware (note: I'd recommend using targets/parameters for motors and just individual lambdas for servos), note please do not include any mention of gamepads outside of the drivetrain, drivetrain is universally the same, your subsystem is not

- [ ] Make your default command, for motors this could include a controller (like PID) 

- [ ] Write a tuner program for your subsystem to evaluate ALL functions of it, include necessary telemetry output or comments about what data you need

- [ ] Tune your subsystem off the tuner (eg setting position for servos) and make commments about when you last tuned it and how to do it

- [ ] Use your subsystem like normal

- [ ] Profit