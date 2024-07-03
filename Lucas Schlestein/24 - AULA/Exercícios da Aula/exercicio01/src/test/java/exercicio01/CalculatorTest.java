package exercicio01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    static Calculator calculator;
    static Double a;
    static Double b;
    static Double result;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        calculator = new Calculator();
        a = 5.0;
        b = 10.0;
        result = 0.0;
    }

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("Antes de cada teste");
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        result = calculator.add(a, b);
        assertEquals(15, result);
    }

    @Test
    void testSubtract() {
        result = calculator.subtract(a, b);
        assertEquals(-5, result);
    }

    @Test
    void testDivByZero() {
        b = 0.0;
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        String message = exception.getMessage();
        String expected = "Division by zero";
        assertEquals(expected, message);
    }

    @Test
    void testMultiply() {
        result = calculator.multiply(a, b);
        assertEquals(50, result);
    }

    @Test
    void testDivide() {
        a = 10.0;
        b = 5.0;
        result = calculator.divide(a, b);
        assertEquals(2, result);
    }

    @Test
    void testPow() {
        a = 2.0;
        b = 2.0;
        result = calculator.pow(a, b);
        assertEquals(4, result);
    }

    @Test
    void testSqrt() {
        a = 4.0;
        result = calculator.sqrt(a);
        assertEquals(2, result);
    }

}