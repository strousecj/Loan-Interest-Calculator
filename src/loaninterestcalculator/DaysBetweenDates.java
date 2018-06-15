/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loaninterestcalculator;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author chandler.strouse
 */
public class DaysBetweenDates {
        
    public static long daysBetweenDates(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        long numDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converts from milliseconds into days
        return numDays;
    }
}
