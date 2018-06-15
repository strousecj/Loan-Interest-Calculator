/*******************************************************************************
 * LoanInterestCalculator.java
 * A simple calculator to calculate compounding interest on loans.
 * 
 * Author: Chandler Strouse
 * Last Update: 08/23/2017
 * 
 ******************************************************************************/

package loaninterestcalculator;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.io.IOException;
import java.util.InputMismatchException;
import static loaninterestcalculator.DataValidator.*;
import static loaninterestcalculator.DaysBetweenDates.*;

public class LoanInterestCalculator {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String fp = "output.txt"; // name of file that will be output
            PrintWriter writer = new PrintWriter(fp, "UTF-8"); // for writing to file
            Loan loan = new Loan();
            
            /*** Set loan principal *******************************************/
            System.out.println("Please enter the loan principal: ");
            String principalIn = scanner.next();
            while(!isPrincipalValid(principalIn)){ // error checking
                System.out.println("Number is invalid. Please enter a number greater than 0:");
                principalIn = scanner.next();
            }
            loan.setPrincipal(Double.parseDouble(principalIn));

            /*** Set loan % interest rate *************************************/
            System.out.println("Please enter the loan's % interest rate:");
            String interestIn = scanner.next();
            while(!isInterestRateValid(interestIn)){ // error checking
                System.out.println("Please enter a valid interest rate greater than 0%:");
                interestIn = scanner.next();
            }
            loan.setInterestRate(Double.parseDouble(interestIn));

            /*** Set loan beginning and ending dates **************************/
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            DecimalFormat numberFormat = new DecimalFormat("#.00"); // format the interest in dollars
            String startDateIn, endDateIn;
            Date startDate, endDate;
            char multDateRange;
            int loanCounter = 1; // always at least 1 loan to start
            double individualLoanInterest;
            do {
                System.out.println("Please enter loan start date in format mm/dd/yyyy:");
                startDateIn = scanner.next();
                while(!isDateValid(startDateIn, "MM/dd/yyyy")){ // makes sure start date is valid and properly formatted
                    System.out.println("Date is invalid. Please enter a valid date:");
                    startDateIn = scanner.next();
                }
                startDate = dateFormat.parse(startDateIn);
                
                System.out.println("Please enter loan end date in format mm/dd/yyyy:");
                endDateIn = scanner.next();
                while(!isDateValid(endDateIn, "MM/dd/yyyy")){ // makes sure end date is valid and properly formatted
                    System.out.println("Date is invalid. Please enter a valid date:");
                    endDateIn = scanner.next();
                }
                endDate = dateFormat.parse(endDateIn);
                loan.setNumDays(daysBetweenDates(startDate, endDate));
                
                individualLoanInterest = loan.calcLoanInterest();
                loan.setInterest(loan.getInterest() + individualLoanInterest);
                
                /*** Writes loan info to text file *********************************/
                writer.println("Loan " + loanCounter);
                writer.println("    Principal: $" + loan.getPrincipal());
                writer.println("    % Interest Rate: " + loan.getInterestRate() + "%");
                writer.println("    Number of days: " + daysBetweenDates(startDate, endDate) + " days");
                writer.println("    Loan Interest: $" + numberFormat.format(individualLoanInterest));
                writer.println("");
                
                System.out.println("Is there another date range? (Y/N):");
                multDateRange = Character.toUpperCase(scanner.next().charAt(0)); // converts to uppercase
                while (multDateRange != 'Y' && multDateRange != 'N') {
                    System.out.println("Please enter a 'Y' for Yes or 'N' for No:");
                    multDateRange = Character.toUpperCase(scanner.next().charAt(0));
                }
                if (multDateRange == 'Y') {
                    System.out.println("Please enter the principal for the next date range:");
                    principalIn = scanner.next();
                    while(!isPrincipalValid(principalIn)){
                        System.out.println("Number is invalid. Please enter a number greater than 0:");
                        principalIn = scanner.next();
                    }
                    loan.setPrincipal(Double.parseDouble(principalIn));
                }
                loanCounter++;
            } while (multDateRange != 'N'); // repeat if there is another set of loans

            System.out.println("You owe $" + numberFormat.format(loan.getInterest()) + " in interest.");
            writer.println("Total interest owed: $" + numberFormat.format(loan.getInterest())); // writes total to file output
            writer.close(); // closes writing to file
            System.out.println("Press ENTER to exit...");
            System.in.read(); // prevents program from closing until user presses ENTER
        } catch (ParseException | IOException | InputMismatchException e) {
        }
    } // end main()
}
