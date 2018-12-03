# FoodTruckFinder
Finds food trucks in san francisco that are open. Displays names and addresses in batches of 10.
Written in java 11 by Joey Quaranta.

Q: How to install dependencies?
A: None needed. I wanted to make this program as easy to run for non tech savvy users as possible.

Q: How to build and run program?
A: $ javac Main.java && java Main

Q: Write-up: What would you do differently if this were to be a full-scale web app?
A: I'll ignore the product differences for now, as that's a different conversation. For starters I'd include more external libraries, since I'd be able to keep them on the server instead of relying on the user being able to install them. I'd definitely utilize a good JSON parser like GSON to make the code more readable and more easily scalable (ex needed to be upgraded to include a column that calculated time to close.) I would also consider using an external text table formatter depending on design specifications. Another thing I would consider doing is rewriting the logic for searching for trucks. Currently the program holds the list of open trucks in memory, at the time of testing this was only like 20 trucks, but I could see that list being a lot bigger at peak times. If limiting caching was more important, it might be worth it to requery the api for every batch of 10. However by doing this and adhering to sorting, this could dramtically increase the time of execution, since each truck would have to be selected in order, potentially running in O(n^2) (every truck would have to go through the list to make sure that it was next in order.) I would double check with product owners and stakeholders on the importance of alphabetical sorting, because if the sorting could be cut, the program would be able to easily pop the next 10 open trucks "off the top" of the api query, requiring little to no caching, and staying at near instant speed. We could also move this data into a database and update it on a cadence, which would allow the user to enjoy sorted data with little to no additional caching and fast runtime, but keeping that data in a db when it's already available through api is probably overkill. 