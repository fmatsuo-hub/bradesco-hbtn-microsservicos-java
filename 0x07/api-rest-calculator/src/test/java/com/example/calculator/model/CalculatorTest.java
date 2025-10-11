package com.example.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void sumTest() {
        Double result = calculator.sum(2.0, 3.0);
        assertEquals(5.0, result);
    }

    @Test
    void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> calculator.sum(null, 2.0));
        assertThrows(NullPointerException.class, () -> calculator.sum(1.0, null));
    }

    @Test
    void subTest() {
        Double result = calculator.sub(10.0, 4.5);
        assertEquals(5.5, result);
    }

    @Test
    void divideTest() {
        Double result = calculator.divide(10.0, 2.0);
        assertEquals(5.0, result);
    }

    @Test
    void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10.0, 0.0));
    }

    @Test
    void factorialTest() {
        assertEquals(1, calculator.factorial(1));
        assertEquals(2, calculator.factorial(2));
        assertEquals(6, calculator.factorial(3));
        assertEquals(24, calculator.factorial(4));
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(Integer.valueOf(1), calculator.integerToBinary(1));
        assertEquals(Integer.valueOf(101), calculator.integerToBinary(5)); // 5 -> "101" -> 101 as integer
        assertEquals(Integer.valueOf(10100), calculator.integerToBinary(20));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("1", calculator.integerToHexadecimal(1));
        assertEquals("5", calculator.integerToHexadecimal(5));
        assertEquals("AA", calculator.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate d1 = LocalDate.of(2020, 3, 15);
        LocalDate d2 = LocalDate.of(2020, 3, 29);
        assertEquals(14, calculator.calculeDayBetweenDate(d1, d2));

        assertEquals(14, calculator.calculeDayBetweenDate(d2, d1));
    }
}
