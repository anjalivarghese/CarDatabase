/**
 * Write a description of class InputCheck here.
 *
 * @author Anjali Varghese
 * @version (19/10/2017)
 * InputCheck class validates the input provided by the users
 * It contains different methods to validate if an input String is numberic , alphanumeric or only contains alphabets
 */
public class InputCheck
{  
    //method to check if the registration number is accpted
    public boolean acceptRegno(String y)
    {
        boolean flag=false;
        
        if(y.length() <= 6)
            {
                flag = true;
                if(!isString(y))
                flag = false;
            } 
            else
            flag=false;
            
        return flag;
    }
    
    //methd to search if the input only contains numbers between 1 and 3
    public boolean acceptNumber(String number)
    {
        boolean flag = false;
        
        if(isStringNumeric(number.trim(),1))
            {
                if(Integer.parseInt(number) <=3 && Integer.parseInt(number) >=1)
                flag = true;
            }
             else
                flag=false;
                
        return flag;
    }
    
    //method to check if the year is accepted
    public boolean acceptYearmade(String yearmade)
    {
        boolean flag = false;
        
        if(isStringNumeric(yearmade.trim(),4))
            {
                if(Integer.parseInt(yearmade) <=2017 && Integer.parseInt(yearmade) >=1800)
                flag = true;
            }
             else
                flag=false;
                
        return flag;
    }
    
    public boolean acceptPrice(String price)
     {   boolean flag = false;
        
        if(isDigit(price))
            {
                if(!price.equals("0"))
                flag = true;
            }
             else
                flag = false;
                
        return flag;
    }
    
    
    //method to check if the input is a numeric input  of a specific length 
    public boolean isStringNumeric(String y,int a)
    {
        if (y.length() != a)        //to check the length of the string 
            return false;
        int i = 0;
        while (i < y.length())
        {
            if (y.charAt(i) == '\n')     //to check if the input is enter
                return false;
            else
            if (!(Character.isDigit(y.charAt(i))))    
                return false;
            i++;
        }
        return true;
    }
    
    //methid to check if the input is a string without no empty space 
    public boolean isString(String y)
    {
        if (y.length() == 0)     //to check the length of the string 
            return false;
        int i = 0;
        while (i < y.length())
        {
            if (y.charAt(i) == '\n')     //to check if the input is a space
                return false;
            else
            if (!(Character.isLetter(y.charAt(i)) || Character.isDigit(y.charAt(i))))    //to check if the the character is an alphabet or a number
                return false;
            i++;
        }
        return true;
    }
    
   //method to check if the input is a string with may contain an empty space
   public boolean isStringspace(String y)
    {
        if (y.length() == 0)     //to check the length of the string 
            return false;
        int i = 0;
        while (i < y.length())
        {
            if(y.charAt(i) == '\n')
            return false;
            else
            if (!(Character.isLetter(y.charAt(i)) || y.charAt(i) == ' '))   //to check if the the character is an alphabet or a number
            return false;
            i++;
        }
        return true;
    }
    
    public boolean isDigit(String y)
    {
        if (y.length() == 0)     //to check the length of the string 
            return false;
            
        int i = 0;
        while (i < y.length())
        {
            if (y.charAt(i) == '\n')     //to check if the input is enter
                return false;
            else
            if (!(Character.isDigit(y.charAt(i))))    
                return false;
            i++;
        }
        return true;
    }
}
