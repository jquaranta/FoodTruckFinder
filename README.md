# FoodTruckFinder
Finds food trucks in san francisco that are open. Displays names and addresses in batches of 10.
Written in java 11 by Joey Quaranta.

Q: How to install dependencies?
A: None needed. I wanted to make this program as easy to run for non tech savvy users as possible.

Q: How to build and run program?
A: $ javac Main.java && java Main

Q: Write-up: What would you do differently if this were to be a full-scale web app?
A: I'll ignore the product differences for now, as that's a different conversation. For starters I'd include more external libraries, since I'd be able to keep them on the server instead of relying on the user being able to install them. I'd definitely utilize a good JSON parser like GSON to make the code more readable and more easily scalable (ex needed to be upgraded to include a column that calculated time to close.) I would also consider using an external text table formatter depending on design specifications. 