package Methods;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class OperationsTest {

    @Test
    void addTest1() {
        Operations operations = new Operations();
        assertEquals("2*X^4+2*X^3+2*X^2+2", operations.addSubTwoPolynomial("2*X^3","2*X^4+2*X^2+2",'+'));
    }
    @Test
    void addTest2() {
        Operations operations = new Operations();
        assertEquals("3*X^4+2*X^3+4*X^2-10*X+7", operations.addSubTwoPolynomial("2*X^3+3*X^2-5*X+1","1*X^2+3*X^4-5*X+6",'+'));
    }    @Test
    void addTest3() {
        Operations operations = new Operations();
        assertEquals("2*X^3+1*X^2", operations.addSubTwoPolynomial("1*X^2","2*X^3",'+'));

    }

    @Test
    void subTest1() {
        Operations operations = new Operations();
        assertEquals("2*X^4-2*X^3+2*X^2+2", operations.addSubTwoPolynomial("2*X^4+2*X^2+2","2*X^3",'-'));
    }
    @Test
    void subTest2() {
        Operations operations = new Operations();
        assertEquals("3*X^4-2*X^3-2*X^2+5", operations.addSubTwoPolynomial("1*X^2+3*X^4-5*X+6","2*X^3+3*X^2-5*X+1",'-'));
    }
    @Test
    void subTest3() {
        Operations operations = new Operations();
        assertEquals("-2*X^3+1*X^2", operations.addSubTwoPolynomial("1*X^2","2*X^3",'-'));
    }

    @Test
    void multiTest1() {
        Operations operations = new Operations();
        assertEquals("4*X^8+8*X^7+4*X^6", operations.multiplicationTwoPolynomial("2*X^4+2*X^3","2*X^4+2*X^3"));
    }
    @Test
    void multiTest2() {
        Operations operations = new Operations();
        assertEquals("4*X^8+4*X^7", operations.multiplicationTwoPolynomial("2*X^4","2*X^4+2*X^3"));
    }
    @Test
    void multiTest3() {
        Operations operations = new Operations();
        assertEquals("4*X^8+4*X^7", operations.multiplicationTwoPolynomial("2*X^4+2*X^3","2*X^4"));
    }

    @Test
    void derivateTest1() {
        Operations operations = new Operations();
        assertEquals("6*X^2", operations.derivateTwoPolynomial("2*X^3"));
    }
    @Test
    void derivateTest2() {
        Operations operations = new Operations();
        assertEquals("6*X^2+4*X^1", operations.derivateTwoPolynomial("2*X^3+2*X^2+1"));
    }
    @Test
    void derivateTest3() {
        Operations operations = new Operations();
        assertEquals("2*X^0", operations.derivateTwoPolynomial("2*X^1"));
    }

    @Test
    void integrationTest1() {
        Operations operations = new Operations();
        assertEquals("0.5*X^4", operations.integrationTwoPolynomials("2*X^3"));
    }
    @Test
    void integrationTest2() {
        Operations operations = new Operations();
        assertEquals("0.5*X^4+1*X^1", operations.integrationTwoPolynomials("2*X^3+1"));
    }

    @Test
    void integrationTest3() {
        Operations operations = new Operations();
        assertEquals("0.5*X^4+0.6666667*X^3+1*X^1", operations.integrationTwoPolynomials("2*X^3+2*X^2+1"));
    }


}