/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.javacalculator;


import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 *
 * @author ruchikagupta
 */
public class JavaCalculator {

    
    /* Cllls the necessary helper functions to implement a calculator program
    * @param strInput entered by the user while calling the file
    * @return the calculated value of the expression entered
    */
    
    public long finalresult(String strInput){
        ArrayList<Object> arrayList = convertToSymbolList(strInput);
        long result;
        
        result = performMathOperation(arrayList);
        System.out.println(result);
        return result;
    }
    
    /*Iterates through our input string and converts it into math expressions with numbers
    * add(1, mult(2, 3)) becomes  [+, 1, *, 2, 3]
    * @param strInput in the form of "add(1, mult(2, 3))"
    * @return arrayMathList which contains the calculations to be performed for 2 digits preceding the sign
    */
    public ArrayList<Object> convertToSymbolList(String strInput){
        ArrayList<Object> arrayMathList = new ArrayList<>();
        
        //Look up function similar to split in python 
        StringTokenizer stringTokens = new StringTokenizer(strInput," (),");
        
        // Checking and displaying the Tokens,  form of iteration through the tokens
        while (stringTokens.hasMoreTokens()){
            String token = stringTokens.nextToken();
            switch (token){
                case "add" -> arrayMathList.add('+');
                case "sub" -> arrayMathList.add('-');
                case "mult" -> arrayMathList.add('*');
                case "div" -> arrayMathList.add('/');
                default -> arrayMathList.add(token);
            }
        }
        return arrayMathList;
    }
    
    /**
     * Returns true if an input string is a number else false.
     * @param strNum is a numerical string
     * @return Boolean (TRUE/FALSE)
     */
    public boolean isInt(String strNum){
        try {
            Integer.parseInt(strNum);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Iterates through our array list for every 2 integers and when encounters a mathematical sign, performs the mathematical operation
     * @param arrayList like [+,2,5]
     * @return Long the equivalent calculator value, 7
     */
    public long performMathOperation(ArrayList<Object> arrayList){
        Stack <Long> answerStack = new Stack<>();
        for(int i = arrayList.size() - 1; i >= 0; i--){
            String item = String.valueOf(arrayList.get(i));
            if(isInt(item)) {
                answerStack.push(Long.valueOf(item));
            }
            else{
                long operand1 = answerStack.pop();
                long operand2 = answerStack.pop();

                switch(item){
                    case "+" -> answerStack.push(operand1 + operand2);
                    case "-" -> answerStack.push(operand1 - operand2);
                    case "*" -> answerStack.push(operand1 * operand2);
                    case "/" -> {
                        //Divide by zero error
                        if(operand2 == 0){
                            throw new IllegalArgumentException();
                        }
                        answerStack.push(operand1 / operand2);
                    }
                }
            }
        }
       
        return answerStack.peek();
    }
    
    /**
    * Assumptions :
    * The input format should be correct.
    * The text input can contain the following keywords: "add","sub","mult" and/or "div"
    * The closing and opening brackets must match
    * Each function accepts exactly 2 numbers
    */
    public static void main(String[] args) {
        
        //No input entered, throw error
        if (args.length == 0){
            throw new RuntimeException();
        }
        //throw new RuntimeException();
        JavaCalculator calculatorObj = new JavaCalculator();
        calculatorObj.finalresult(args[0]);
    }
}
