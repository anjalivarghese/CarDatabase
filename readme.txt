This program implements a simple Used Car Warehouse Database System. 
The aim of the Used Car Warehouse Database System is for a warehouse to keep a database of the used car, and to perform operations such as searching for cars, adding/deleting cars, displaying the details of cars, etc.
The Used Car Warehouse Database System should provide the following features :
maintains a list (using a Java Collection class) of Car objects
o each Car object represents a single “car”
each “car” should contain the following information:
? Registration Number (e.g. 8RT2WT)
? Year Made (e.g. 2013)
? Colour (e.g. white). A car can have up to 3 different colours.
? Car Make (e.g. Toyota)
? Car Model (e.g. Corolla)
? Price (e.g. $15000)
lists the details of an existing car (or cars)
• produces a report of cars based on some criteria
• loads a list of cars from a text file
• saves the list of current cars to a text file

When the Used Car Warehouse Database System starts, it should automatically load a text file called "usedcars.txt" which contains details of all used cars currently kept by the warehouse. 

When the program is running, it should repeatedly display the main menu with these options:
(1) Search Cars
(2) Add Car
(3) Delete Car
(4) Exit System

Option (1) of the main menu allows the user to search for cars in the database. The user should be asked what criteria(s) he/she wants to use to search for cars. The following sub-menu and options should be displayed:
Car Searching Options:
(1) By Registration Number
(2) By Car Make and Car Model
(3) By Age
(4) By Price (range)
(5) Back to Main Menu

Inputs other than 1-5 (e.g. 0, x, abc, @#$% etc.) should be rejected, and an error message should be printed. The menu should be displayed repeatedly, until the user chooses Option (5).

• If the user chooses option (1), you should ask the user to input a registration number. A valid registration number should only contain maximum 6 characters combination of English alphabet or digit (that is, “A”-“Z”, “a”-“z” or “0-9”). If the input contains any invalid character (e.g. empty space, “#”, “&”, “\” etc.) or more than 6 characters, an error message should be displayed and ask the user for another valid input. If it is a valid input, search the database for any car with the specific car registration number. Display all information of this car if found, or display “No such car with this Registration Number” if not found.

If the user chooses option (2), you should ask the user to input a Car Make first. A valid Car Make should only contain English alphabet or digit. If the input contains any invalid character (e.g. empty space, “#”, “&”, “\” etc.), an error message should be displayed and ask the user for another valid input. If it is a valid input, ask the user to input a Car Model. The same validity checking applies. The user can input a Car Model (e.g. “Corolla”) or “ANY”. If “ANY” is inputted, the program should display all car models of this Car Make from the database. Display all information of cars with this Car Make and this Car Model (or all Car Models if “ANY” is inputted) if found, or display “No such car with this Car Make and Car Model” if not found.

If the user chooses option (3), you should ask the user to input a non-negative integer (e.g. 0, 1, 5, 12 etc.) to indicate the maximum age of cars he/she wants to search. A validity checking should be applied here. Display all information of cars with this maximum age if found, or display “No such car with this maximum age” if not found. For example, if the user inputs 0, all cars made in 2017 should be displayed. If the user inputs 3, all cars made in 2014, 2015, 2016, 2017 should be displayed.

If the user chooses option (4), you should ask the user to input a minimum price and a maximum price of cars he/she wants to search. Both inputs should be a positive integer and the maximum price should be equal to or greater than the minimum price. A validity checking should be applied here. Display all information of cars with this range if found, or display “No such car with this range” if not found. For example, if the user inputs minimum price = 1000 and maximum price = 3000, all cars priced from $1000 to $3000 (both inclusive) should be displayed.

If the user chooses option (5), the program should go back to the main menu.

Option (2) of the main menu allows the user to add a new car to the database. (Appropriated input validity checking should be applied.)

Option (3) of the main menu allows the user to delete an existing car from the database. The user should be asked to search the car by Registration Number. (Appropriated input validity checking should be applied.)

Option (4) of the main menu exits the program. All the cars currently in memory are automatically saved back to "usedcars.txt".

Inputs other than 1-4 (e.g. 0, x, abc, @#$% etc.) to this main menu should be rejected, and an error message should be printed. The menu should be displayed repeatedly, until the user chooses Option (4).







