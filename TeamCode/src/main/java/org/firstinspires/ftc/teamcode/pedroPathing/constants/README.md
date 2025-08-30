# Explanation

Constants is where we save our follower and localizer constants. This allows PedroPathing to map our robot to the field
(via the localizer) and the follower is what actually makes us move and follow our autonomous code. Please write 
inside each file when you edit them, and also edit the readme inside of the auto folder to add the date you tuned it.
These constants are tuned whenever the robot's mass density per unit area changes dramatically. This 
pretty much means we retune when we

A) Change odometry pod locations

B) Change the mass of the robot (considerably, like a kilo or two more)

C) Move the robot's mass around drastically

D) Alter anything regarding the movement of the robot (like wheels, and the belts)

E) If the robot acts weird when path following