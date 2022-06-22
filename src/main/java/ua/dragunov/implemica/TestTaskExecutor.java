package ua.dragunov.implemica;

import java.math.BigInteger;
import java.util.Stack;


/**
 * The Util class that implements test task methods
 *
 * @author Igor Dragunov
 * @version  1.0
 * */

public class TestTaskExecutor {

    /**
     * The method checks if the string matches the given criteria,
     * in particular, corresponds this one to correct math expression
     * for example : '(())' - is correct
     *               ')(()' - not correct
     *
     *
     * @param expression - a given expression
     * @return {@code true} if the particular string is correct and {@code false} otherwise
     * */
    public static boolean validate(String expression) {
        Stack<Character> brackets = new Stack<>();

        if (expression.length() % 2 != 0) {
            return false;
        }

        for (int i  = 0;i < expression.length();i++) {
            if(expression.charAt(i) == '(') {
                brackets.push(expression.charAt(i));
            }
            if (expression.charAt(i) == ')') {
                if (brackets.isEmpty() || brackets.pop() != '(') {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * method for calculation factorial
     *
     * @param value - value to calculate factorial
     * @return a BigInteger number, because a received number can be more than {@code int} and {@code long}
     * */
    public static BigInteger factorial(int value)  {
        if (value <= 1) {
            return BigInteger.ONE;
        }

        return factorial(value - 1).multiply(BigInteger.valueOf(value));
    }

    /**
     * The method that calculates the sum of digits of the given value
     *
     * @param value - BigInteger value in which the sum of the digits is calculated
     * @return int - sum of the digit
     * */
    public static int digitSum(BigInteger value) {
        int sum = 0;

        for (int i = 0;i < value.toString().length();i++) {
            sum += Integer.parseInt(value.toString().substring(i, i + 1));
        }

        return sum;
    }

}
