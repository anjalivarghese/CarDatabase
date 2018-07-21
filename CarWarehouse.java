/**
 * Write a description of class CarWarehouse here.
 *
 * @author Anjali Varghese
 * @version (19/10/2017)
 * CarWarehouse is the class that handles the user interface
 * It displays the main menu ,search menu and edit menu
 */
import java.util.*;    

public class CarWarehouse
{
    Scanner console;
    InputCheck checker;
    DatabaseManager carlist;

    public CarWarehouse()
    {
        console = new Scanner(System.in);
        checker = new InputCheck();
        carlist = new DatabaseManager();
    }
    
    
    private void addCar()
    {
        String regno = " ";
        int yearmade = 0;
        String[] colour = new String[3];
        String carmake = " " ;
        String carmodel = " ";
        int price = 0;
        boolean flag = false;

        System.out.print("\nEnter the new car details \n");

        do
        {
            regno = addRegno();
            flag = carlist.statusRegno(regno);
            if(flag)
             System.out.println("Registration Number entered is not unique ");
        }while(flag);

        yearmade = addYearmade();
        colour = addColour();
        carmake = addMake();
        carmodel = addModel();
        price = addPrice();

        Car car = new Car();
        
        car.setRegno(regno);
        car.setYearmade(yearmade);
        car.setColour(colour);
        car.setCarmake(carmake);
        car.setCarmodel(carmodel);
        car.setPrice(price); 
        
        carlist.setCarList(car);
        print(carlist.getCarList());
    }

    //method to input colour
    private String[] addColour()
    {   
        String number = "";
        boolean flag = false;
        String[] colour = new String[3];

        do
        {   System.out.print("\nHow many colours do you want to enter?\n");
            number = console.nextLine();

            if(!checker.acceptNumber(number.trim()))
            System.out.println("The number is not valid , Enter  it again");
            
        }while(!checker.acceptNumber(number.trim()));

        for(int i=0 ; i<3 ; i++)
        {
            colour[i] = "";
        }

        for(int i=0; i<Integer.parseInt(number.trim()) ; i++)
        {
            do
            {
                System.out.print("\nEnter colour:\n");
                colour[i] = console.nextLine();
                if(!checker.isStringspace(colour[i].trim()))
                System.out.print("\nYou have entered the colour wrong , Please enter colour again\n");

            }while(!checker.isStringspace(colour[i]));
        }

        return colour;

    }
    
        //method to input carmake
    private String addMake()
    {
        String carmake = " ";

        do
        {
            System.out.print("\nEnter Car Make:\n");
            carmake = console.nextLine();

            if(!checker.isString(carmake))
            System.out.print("\nYou have entered the car make wrong , Please enter it again\n");

        }while(!checker.isString(carmake.trim()));

        return carmake.trim();
    }

    //method to input carmodel
    private String addModel()
    {
        String carmodel = " ";

        do
        {
            System.out.print("\nEnter Car Model:\n");
            carmodel = console.nextLine();

            if(!checker.isString(carmodel))
                System.out.print("\nYou have entered the car model wrong , Please enter it again\n");

        }while(!checker.isString(carmodel.trim()));

        return carmodel.trim();
    }

    //method to input car price
    private int addPrice()
    { 
        String price = "";

        do
        {
            System.out.print("\nEnter the price of the car in dollars:\n");
            price = console.nextLine();

            if(!checker.acceptPrice(price))
            System.out.print("\nYou have entered the price wrong , Please enter it again\n");

        }while(!checker.isDigit(price.trim()));

        return Integer.parseInt(price.trim());
    }
    //method to accpet regno
    private String addRegno()
    {
        String regno = " ";

        do
        {
            System.out.print("\nEnter Registration Number:\n");
            regno = console.nextLine();
            
            if(!checker.acceptRegno(regno.trim()))
            System.out.println("The registration number is not valid , Enter  it again . ");
            
        }while(!checker.acceptRegno(regno.trim()));

        return regno.trim();
    }

    //method to accept yearmade
    private int addYearmade()
    {
        String yearmade = "";
        boolean flag = true;

        do
        {
            System.out.print("\nEnter year made:\n");
            yearmade = console.nextLine();

            if(!checker.acceptYearmade(yearmade.trim()))
            System.out.print("\nYou have entered the year wrong , Please enter it again\n");

        }while(!checker.acceptYearmade(yearmade.trim()));

        return Integer.parseInt(yearmade.trim());
    }
    
    
    //method to search by age
    private void byAge()
    {
        ArrayList<Car> Output =  new ArrayList<Car>();
        String age=" ";

        do
        {   
            System.out.println("Enter the maximum age of the car you want to search");
            age = console.nextLine(); 
            if(!checker.isDigit(age))
            System.out.println("You have enterd a non-positive integer");
        }while(!checker.isDigit(age));

        Output=carlist.byAge(Integer.parseInt(age));

        if(Output.isEmpty())
            System.out.println("No such car found with the maximum age");
        else
            print(Output);
    }    
  
    //method to search by colour
    private void byColour()
    {
        ArrayList<Car> Output =  new ArrayList<Car>();
        String number=" ";
        boolean flag = false;
        String colour = "";

            do
            {
                System.out.print("\nEnter colour:\n");
                colour = console.nextLine();
                if(!checker.isStringspace(colour.trim()))
                System.out.print("\nYou have entered the colour wrong , Please enter colour again\n");

            }while(!checker.isStringspace(colour));

        Output=carlist.byColour(colour);
        
         if(Output.isEmpty())
            System.out.println("No colour found with that colour");
        else
            print(Output);
    }
    //method to search by price
    private void byPrice()
    {
        ArrayList<Car> Output =  new ArrayList<Car>();
        String pricemin = " ";
        String pricemax = " ";
        int flag = 0;
        int quit = 0;

        do
        {   
            System.out.println("Enter the minimum price you want to search ");
            pricemin = console.nextLine();
            if(!checker.isDigit(pricemin))
                System.out.println("You have not entered a valid input");
            else
                flag = 1;
        }while(flag!=1);

        do
        {   
            System.out.println("Enter the maximum price you want to search ");
            pricemax = console.nextLine();

            if(!checker.isDigit(pricemax) || pricemax.equals("0"))
               { 
                   System.out.println("You have entered an invalid input");
                   quit = 1;
                }
            else
            if(Integer.parseInt(pricemax) < Integer.parseInt(pricemin))
                {
                    System.out.println("You have entered a number that is lesser than the minimum price");
                    quit = 1;
                }
            else
                quit = 0;
        }while(quit==1);

        Output=carlist.byPrice(Integer.parseInt(pricemin),Integer.parseInt(pricemax));
        if(Output.isEmpty())
            System.out.println("No such car in that range");
        else
            print(Output);
    }    
   
    
    //method to search for car
    private void carSearch()
    {
        String choice="";
        
        if(carlist.getCarList().isEmpty())      //Checks if the arraylist is empty 
        System.out.println("You do not have any cars in the database to search ");
        else
        {
        do
        {    
            System.out.print("\n ---------------------------------------------------MENU------------------------------------------------\n");
            System.out.print("                                      Car Searching Options                                               \n");
            System.out.print("==========================================================================================================\n");
            System.out.print("                              \n(1) By Registration Number                                                \n");
            System.out.print("                    \n(2) By Car Make and Car Model                                                       \n");
            System.out.print("                                      \n(3) By Age                                                        \n");
            System.out.print("                                                    \n(4) By Price                                        \n");
            System.out.print("                                                    \n(5) By Colour                                       \n");
            System.out.print("      \n(6) Back to the Main Menu                                                                         \n");
            System.out.println("                                               \nEnter your choice:                                    ");
            choice = console.nextLine();

            if(!checker.isStringNumeric(choice.trim(),1))
                System.out.println("\nEnter a valid choice ");
            else
            {
                switch (choice)
                {
                    case "1" :
                    searchRegno();
                    break;

                    case "2" :
                    searchCarmake();
                    break;

                    case "3" :
                    byAge();
                    break;

                    case "4" :        
                    byPrice();
                    break;

                    case "5" :  
                    byColour();
                    break;
                    
                    case "6" :        
                    break;

                    default:
                    System.out.print("\nInvalid option ! Please Enter your choice again:"); 
                }
            }
        }
        while(!choice.equals("6")); 
    }
    }
    
    //method to delete
    private void delete()
    {
        String regno = addRegno();
        int index= carlist.searchRegno(regno);
        if(index==-1)
        System.out.println("Error ! Car not found");
        else
        carlist.delete(index);
    }

    public void displayMenu()
    {
        carlist.reader();
        String choice = "";
        do
        {    
            System.out.print("\n ---------------------------------------------------MENU------------------------------------------------\n");
            System.out.print("                                      Welcome to the Car Wash Database                                    \n");
            System.out.print("==========================================================================================================\n");
            System.out.print("                                            \n(1) Search Cars                                             \n");
            System.out.print("                                            \n(2) Add Cars                                                \n");
            System.out.print("                                            \n(3) Delete Cars                                             \n");
            System.out.print("                                            \n(4) Edit Cars                                               \n");
            System.out.print("                                            \n(5) View Cars in Database                                   \n");
            System.out.print("                                            \n(6) Exit database                                           \n");
            System.out.println("                                          \nEnter your choice:                                            ");
            choice = console.nextLine();

            if(!checker.isStringNumeric(choice.trim(),1))
                System.out.println("\nEnter a valid choice \n");
            else
            {
                switch (choice)
                {
                    case "1":
                    carSearch();      //Search for a Car
                    break;

                    case "2" :
                    addCar();               //method to add a Car
                    break;

                    case "3" :
                    delete();               //method to delete Cars
                    break;
                    
                    case "4" :      //method to edit the car   
                    editCar();
                    break;
                    
                    case "5" :       //method to view the cars in the database 
                    System.out.println("The database contains the following cars\n");
                    print(carlist.getCarList());
                    break;
                    
                    case "6" :  
                    carlist.writer();       //exit the program
                    System.out.println("\nThe database has been updated to the file");
                    System.out.println("\nThank you , You have exited the database");
                    break;

                    default:
                    System.out.print("\nInvalid option ! Please Enter your choice again:"); 
                }
            }
        }
        while(!choice.equals("6"));     //checks if the choice is  less than 6 and repeats the menu 
    }
    
    //method to edit car by price
    private void editByprice(int index)
    {
      int price=addPrice();
      carlist.editPrice(price,index);
    }

    //method to edit car bycolour
    private void editBycolour(int index)
    {
      String[] colour = addColour();
      carlist.editColour(colour,index);
    }

    //method to edit car
    private void editCar()
    {
     String choice = " ";
     String regno = addRegno();
     int index = carlist.searchRegno(regno);

     if(index==-1)
            System.out.println("Error ! Car not found");
        else
         {   System.out.println("Car Found , What do you want to edit ");
             do
        {    
            System.out.print("\n ---------------------------------------------------MENU------------------------------------------------\n");
            System.out.print("                                      Welcome to the Edit Menu                                            \n");
            System.out.print("==========================================================================================================\n");
            System.out.print("                                            \n(1) Edit Colour                                             \n");
            System.out.print("                                            \n(2) Edit price                                              \n");
            System.out.print("                                            \n(3) Go back to main menu                                    \n");
            System.out.println("                                          \nEnter your choice:                                            ");
            choice = console.nextLine();

            if(!checker.isStringNumeric(choice.trim(),1))
                System.out.println("\nEnter a valid choice \n");
            else
            {
                switch (choice)
                {
                    case "1":
                    editBycolour(index);      //Search for a Car
                    break;

                    case "2" :
                    editByprice(index);               //method to add a Car
                    break;
                    
                    case "3" :
                    break;
                }
            }
        }
        while(!choice.equals("3"));     //checks if the choice is  less than 5 and repeats the menu 
    }
    }
        
    //method to print arraylist
    private void print(ArrayList<Car> Cars)
    {
        for(int i=0; i< Cars.size(); i++)
        {
            System.out.println(carlist.toString(Cars.get(i)));
        }
    }

    //method to search for carmake
    private void searchCarmake()
    {
        ArrayList<Car> Output =  new ArrayList<Car>();
        String carmake = addMake();
        String carmodel = addModel();
        Output = carlist.searchCarmake(carmake,carmodel);
        if(Output.isEmpty())
            System.out.println("No such car with that Car make and model");
        else
            print(Output);
    }   
    //method to search by registration number
    private void searchRegno()
    {
        String regno = addRegno();
        int index= carlist.searchRegno(regno);
        if(index==-1)
        System.out.println("Error ! Car not found");
        else
        System.out.println(carlist.toString(carlist.getCar(index)));
    }

}
