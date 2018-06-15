/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loaninterestcalculator;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chandler.strouse
 */
public class LoanInterestCalculatorTest {
    
    public LoanInterestCalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class LoanInterestCalculator.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        LoanInterestCalculator.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of daysBetweenDates method, of class LoanInterestCalculator.
     */
    @Test
    public void testDaysBetweenDates() {
        System.out.println("daysBetweenDates");
        Date d1 = null;
        Date d2 = null;
        long expResult = 0L;
        long result = LoanInterestCalculator.daysBetweenDates(d1, d2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
