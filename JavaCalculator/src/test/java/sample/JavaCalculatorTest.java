/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sample;

import com.mycompany.javacalculator.JavaCalculator;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ruchikagupta
 */
public class JavaCalculatorTest {
    
    private final JavaCalculator instance = new JavaCalculator();
    public JavaCalculatorTest() {
        
    }
    

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }
    
    /**
     *  string expression = "add(1, 2)"
     *  final calculated value = 3
     */
    public void testAccessStringData1() throws Exception {
        String strInput = "add(1, 2)";
        int expectedResult = 3;
        long functionResult = instance.finalresult(strInput);
        assertEquals(expectedResult,functionResult);      //pass
    }

 
    /**
     * Test of finalresult method, of class JavaCalculator.
     */
    @org.junit.jupiter.api.Test
    public void testFinalresult() {
        String strInput = "mult(add(4, 2)), div(9, 3))))))";
        int expectedResult = 18;
        long functionResult = instance.finalresult(strInput);
        assertEquals(expectedResult,functionResult); 
    }
    

    /**
     * Test of convertToSymbolList method, of class JavaCalculator.
     */
    @org.junit.jupiter.api.Test
    public void test() {
        String strInput = "mult(add(4, 2)), div(9, 3))))))";
        int expectedResult = 18;
        long functionResult = instance.finalresult(strInput);
        assertEquals(expectedResult,functionResult); 
 
    }

    /**
     * Test of isInt method, of class JavaCalculator.
     */
    @org.junit.jupiter.api.Test
    public void testConvertToSymbolList() {
        System.out.println("isInt");
        String strNum = "";
        JavaCalculator instance = new JavaCalculator();
        String strInput = "add(1, mult(2, 3))";
        ArrayList<Object> expectedResult = new ArrayList<Object>(){
                                                                {add("+");add("1");add("*");add("2");add("3"); }};
        ArrayList<Object>  functionResult = instance.convertToSymbolList(strInput);

        assertEquals(expectedResult.toString(), functionResult.toString()); 
    }

    /**
     * Test of main method, of class JavaCalculator.
     */
    @org.junit.jupiter.api.Test
    public void testMain() {
        System.out.println("main");
        JavaCalculator instance = new JavaCalculator();
        long result = instance.finalresult("add(1, 2)");
        
        assertEquals(3, result);
    }
    
}
