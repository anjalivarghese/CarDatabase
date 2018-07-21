/**
 * Write a description of class DatabaseManager here.
 *
 * @author Anjali Varghese
 * @version 19/10/2017
 * Database Manager class stores all the details of the cars in a database
 * It also contains different methods to search for cars on different parameters
 * It also contains method to edit a car's colour and price 
 */
import java.util.*; 
import java.io.*;
public class DatabaseManager
{
    public ArrayList<Car> CarList;
    private String filename;
    FileReader inputFile;
    Scanner parser;
    String regno;
    String carmake;
    String carmodel;
    Car car;
    PrintWriter outputFile;
    private ArrayList<Car> Search;

    public DatabaseManager()
    {
        CarList = new ArrayList<Car>();  
        filename = "usedcars.txt";
        Search = new ArrayList<Car>();
        regno = " ";
        carmake =" ";
        carmodel = " ";
    }
    
    //method to search for a car by its age
    public ArrayList<Car> byAge(int age)
    {
        int number=age;
        Search.clear();

        for(Car car : getCarList()) 
        {
            if(car.getYearmade() >= (2017-number))
            {
                Search.add(car);
            }

        }
        return Search;
    }    
    
     //method to search for a car by a colour
    public ArrayList<Car> byColour(String colour)
    {
      Search.clear();
      
       for(Car car : getCarList()) 
        {
            String [] colourcompare=car.getColour();
            
            for(int i=0 ; i<colourcompare.length ;i++)
            {
                    if(colourcompare[i].equalsIgnoreCase(colour))
                    Search.add(car);
            }
            
       }
       return Search;
    }

    //method to search for a car by its price
    public ArrayList<Car> byPrice(int pricemin,int pricemax)
    {
        Search.clear();
        int maximum=pricemax;
        int minimum=pricemin;

        for(Car car : getCarList()) 
        {
            if(car.getPrice() >= minimum && car.getPrice() <= maximum)
            {
                Search.add(car);
            }

        }
        return Search;
    } 

     //method to edit the price of a car
    public void editPrice(int price,int index)
     {
       getCar(index).setPrice(price);
       System.out.println("Price edited");
     }
     
     public void editColour(String [] colour,int index)
     {
      getCar(index).setColour(colour);
      System.out.println("Colour edited");
     }
     
     //method to get a car at a position
    public Car getCar(int index)
    {
        return CarList.get(index);
    }
    
    //method to get the car arraylist
    public ArrayList<Car> getCarList()
    {
        return CarList;
    }
    
    //method to delete a car
    public void delete(int index)
    {
     CarList.remove(getCar(index));
    }

    //method to add a car to the arraylist
    public void setCarList(Car car)
    {
        CarList.add(car);
    }
    
    //method to search for a car with a registration number
    public int searchRegno(String regno)
   {
        regno=regno;
        for(Car car : getCarList()) 
        {
            if(car.getRegno().equalsIgnoreCase(regno))
            return CarList.indexOf(car);
        }
       
        return -1;
    }
    
    //method to read the input file
    public void reader()
    {
        String[] attribute = new String[8];
        String line = " ";

        for(int i=0 ; i<8 ; i++)
        {
            attribute[i]=" ";
        }

        try
        {
            inputFile = new FileReader(filename);
            try
            {    
                parser = new Scanner(inputFile);
                while(parser.hasNextLine())
                {
                    line= parser.nextLine();
                    attribute = line.split(",");

                    String[] colour ={attribute[2],attribute[3],attribute[4]};

                    car = new Car();
                    car.setRegno(attribute[0]);
                    car.setYearmade(Integer.parseInt(attribute[1]));
                    car.setColour(colour);
                    car.setCarmake(attribute[5]);
                    car.setCarmodel(attribute[6]);
                    car.setPrice(Integer.parseInt(attribute[7])); 
                    
                    setCarList(car);
                }
            }
            finally
            {
                inputFile.close();
            }
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + "not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occurs");
        }
    }
    
    //method to know if a car exists in the arraylist
    public boolean statusRegno(String regno)
    {
        this.regno=regno;
        int flag = 0;

        for(Car car : getCarList()) 
        {
            if(car.getRegno().equalsIgnoreCase(regno))
            flag = 1;
        }

        if(flag==1)
            return true;
        else
            return false;
    }

    //method to search for a car through its carmake
    public ArrayList<Car> searchCarmake(String carmake,String carmodel)
    {
        int flag = 0;
        this.carmake=carmake;
        this.carmodel=carmodel;
        Search.clear();

        for(Car car : getCarList()) 
        {
            if(carmodel.equalsIgnoreCase("ANY"))
            {
                if(car.getCarmake().equalsIgnoreCase(carmake))
                    Search.add(car);
                flag =1;
            }
            else
            {
                if(car.getCarmake().equalsIgnoreCase(carmake))
                {
                    if(car.getCarmodel().equalsIgnoreCase(carmodel))
                        Search.add(car);
                    flag = 1;
                }
            }
        }
        return Search;
    }

    
                 
  //method to print colours in a particular format       
   public String printColour(String[] colour)
   {
      String output = "";
      for (int i=0 ; i< colour.length ; i++)
      {
          output+=colour[i]+",";
      }
       
      return output;
   }
     
    //method to convert a set of values to a string
     public String toString(Car car) 
    {
        return (car.getRegno()+ ","
                    + car.getYearmade()+","
                    + printColour(car.getColour())+ 
                     car.getCarmake()+","
                    +car.getCarmodel()+","
                  + car.getPrice());
    }
    
     //method to write into file
     public void writer()
    {
        try
        {
            outputFile=new PrintWriter(filename);
            try
            {    
                for(int i=0; i< getCarList().size(); i++)
                {
                 outputFile.println(toString(getCar(i)));
                }
            }
            finally
            {
                outputFile.close();
            }
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occurs");
        } 
    }
        
}