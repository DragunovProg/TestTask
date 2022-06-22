package ua.dragunov.implemica;


import org.junit.Test;

import static org.junit.Assert.*;

public class TestTaskExecutorTest {


    @Test
    public void isCorrectExpression () {
        String expression = "(())(())()";
        assertTrue(TestTaskExecutor.validate(expression));
    }

    @Test
    public void isNotCorrectExpression() {
        String expression = "(())(())()(";
        assertFalse(TestTaskExecutor.validate(expression));
    }

    @Test
    public void equalsIsSixHundredFortyEight() {
        assertEquals(648, TestTaskExecutor
                .digitSum(TestTaskExecutor.factorial(100)));
    }
}