
package loaninterestcalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Purpose of class is to make sure the data being entered is valid
public class DataValidator {
    public static boolean isDateValid(String dateToValidate, String dateFormat){
        if (dateToValidate == null){
            return false;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        
        try{
            //if not valid, will throw parse exception
            Date date = sdf.parse(dateToValidate);
        } catch (ParseException e){
            //e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    public static boolean isPrincipalValid(String principal){
        if(principal == null){
            return false;
        }
        
        if(principal.matches("[0-9]{1,13}(\\.[0-9]*)?")){ // principal is a number smaller than 1 Trillion
            if(Double.parseDouble(principal) <= 0){ // principal is not greater than 0
                return false;
            }
            return true; // principal is a valid number greater than 0
        }
       
        return false; // principal is not a number
    }
    
    public static boolean isInterestRateValid(String rate){
        if(rate == null){
            return false;
        }
        
        if(rate.matches("[0-9]{1,3}(\\.[0-9]*)?")){ // % interest rate is a number smaller than 100
            if(Double.parseDouble(rate) <= 0){ // rate is not greater than 0
                return false;
            }
            return true; // rate is a valid number greater than 0
        }
        
        return false; // interest rate is not a number
    }
}
