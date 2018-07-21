/**
 * Write a description of class DatabaseManager here.
 *
 * @author Anjali Varghese
 * @version 19/10/2017
 * Car class contains all the attributes of a car 
 * it contains set methods for Regno,Yearmade,Colour,Carmake,Carmodel and price
 * it contains get methods for Regno,Yearmade,Colour,Carmake,Carmodel and price
 */
import java.util.Scanner;

public class Car
{
    private String regno;
    private int yearmade;
    private String[] colour;
    private String carmake;
    private String carmodel;
    private int price;
    InputCheck checker;

    public Car()
    {
     regno = " ";
     yearmade = 0;
     String[] colour = new String [3];
     carmake = " ";
     carmodel = " ";
     price = 0; 
     checker = new InputCheck();
    }
    
    //method to get the colour of the car
    public String[] getColour()
    {
      return colour;
    }
    
    //method to get the carmake of the car
    public String getCarmake()
    {
      return carmake;
    }
    
    //method to get the carmodel of the car
    public String getCarmodel()
    {
        return carmodel;
    }
    
    //method to get the registration number
    public String getRegno()
    {
        return regno;
    }
   
    //method to get the price of the car
    public int getPrice()
    {
     return price;
    }  
    
    //method to get the yearmade
    public int getYearmade()
    {
        return yearmade;
    }   
    
    //method to set the registration number
    public void setRegno(String regno)
    {
        if(checker.acceptRegno(regno))
        this.regno = regno;
        else
        this.regno = "";
    }
   
    //method to set the yearmade of the car
    public void setYearmade(int yearmade)
    {
        if(checker.acceptYearmade(Integer.toString(yearmade)))
        this.yearmade = yearmade;
        else
        this.yearmade = 0;
    }
    
    //method to set the colour of the  car
    public void setColour(String[] colours)
    {
        for (int i=0 ; i<colours.length ; i++)
         {
           if(colours[i] != null)
           {
           if(checker.isStringspace(colours[i]))
           colour = colours;
           else
           colour[i] = "";
         }
        }
          
    }
    
    //method to set the carmake of the car
    public void setCarmake(String carmake)
    {
        if(checker.isString(carmake))
        this.carmake = carmake;
        else
        this.carmake = "";
    }
    
    //method to set the carmodel of the car
    public void setCarmodel(String carmodel)
    {
        if(checker.isString(carmodel))
        this.carmodel = carmodel;
        else
        this.carmodel = "";
    }
    
    //method to set the price
    public void setPrice(int price)
    {
        if(checker.isString(Integer.toString(price)))
        this.price = price;
        else
        this.price = 0;
    }

}