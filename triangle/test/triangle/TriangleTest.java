package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

import static triangle.Triangle.Type;
import static triangle.Triangle.Type.*;

/**
 * Test class for the Triangle implementation.
 */
public class TriangleTest {

    public void line_coverage(){
        Type actual = Triangle.classify(-1, 10, 10);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(10, -1, 10);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(10, 10, -1);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(1, 2, 3);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(3, 1, 2);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(2, 3, 1);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(5, 4, 3);
        assertEquals(actual,SCALENE);
        actual = Triangle.classify(3, 5, 4);
        assertEquals(actual,SCALENE);
        actual = Triangle.classify(4, 3, 5);
        assertEquals(actual,SCALENE);
        actual = Triangle.classify(4, 4, 4);
        assertEquals(actual,EQUILATERAL);
        actual = Triangle.classify(4, 4, 2);
        assertEquals(actual,ISOSCELES);
        actual = Triangle.classify(4, 2, 4);
        assertEquals(actual,ISOSCELES);
        actual = Triangle.classify(2, 4, 4);
        assertEquals(actual,ISOSCELES);
        actual = Triangle.classify(2, 2, 4);
        assertEquals(actual,INVALID);

    }
    public void branch_coverage(){
        Type actual = Triangle.classify(-1, 10, 10);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(10, -1, 10);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(10, 10, -1);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(1, 2, 3);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(3, 1, 2);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(2, 3, 1);
        assertEquals(actual,INVALID);
        actual = Triangle.classify(4, 4, 4);
        assertEquals(actual,EQUILATERAL);
        test_ExpectedISO();
        test_InvalidISO();

    }

    @Test
    public void mutation_adequate(){
        test_ExpectedEQ();
        test_ExpectedISO();
        test_ExpectedSCA();
        test_InitalInput();
        test_InvalidISO();
        test_InvalidISCA();
    }
    public void test_InitalInput() {
        Type actual = Triangle.classify(0, 10, 10);
        Type expected = INVALID;
        assertEquals(actual, expected);
        actual = Triangle.classify(10, 0, 10);
        assertEquals(actual, expected);
        actual = Triangle.classify(10, 10, 0);
        assertEquals(actual, expected);
        actual = Triangle.classify(Integer.MIN_VALUE, 10, 10);
        assertEquals(actual, expected);
        actual = Triangle.classify(10, 10, Integer.MIN_VALUE);
        assertEquals(actual, expected);
        actual = Triangle.classify(10, Integer.MIN_VALUE, 10);
        assertEquals(actual, expected);
        actual = Triangle.classify(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(actual, expected);
        actual = Triangle.classify(0, 0, 0);
        assertEquals(actual, expected);
    }

    public void test_ExpectedEQ() {
        Type actual = Triangle.classify(10, 10, 10);
        Type expected = EQUILATERAL;
        assertEquals(actual, expected);
        actual = Triangle.classify(1, 1, 1);
        assertEquals(actual, expected);
        actual = Triangle.classify(10, 10, 10);
        assertEquals(actual, expected);
        actual = Triangle.classify(100, 100, 100);
        assertEquals(actual, expected);
    }

    public void test_ExpectedISO() {
        Type actual = Triangle.classify(15, 20, 15);
        Type expected = ISOSCELES;
        assertEquals(actual, expected);
        actual = Triangle.classify(3, 4, 3);
        assertEquals(actual, expected);
        actual = Triangle.classify(7, 7, 8);
        assertEquals(actual, expected);
        actual = Triangle.classify(10, 100, 100);
        assertEquals(actual, expected);
    }

    public void test_ExpectedSCA() {
        Type actual = Triangle.classify(2, 3, 4);
        Type expected = SCALENE;
        assertEquals(actual, expected);
        actual = Triangle.classify(4, 2, 3);
        assertEquals(actual, expected);
        actual = Triangle.classify(3, 4, 2);
        assertEquals(actual, expected);
        actual = Triangle.classify(9, 5, 10);
        assertEquals(actual, expected);

    }


    public void test_InvalidISCA() {
        Type actual = Triangle.classify(10, 20, 30);
        Type expected = INVALID;
        assertEquals(actual, expected);
        actual = Triangle.classify(20, 30, 10);
        assertEquals(actual, expected);
        actual = Triangle.classify(1, 2, 1000);
        assertEquals(actual, expected);
        actual = Triangle.classify(1000, 1, 1001);
        assertEquals(actual, expected);
        actual = Triangle.classify(3, 2, 1);
        assertEquals(actual, expected);
    }

    public void test_InvalidISO() {
        Type actual = Triangle.classify(10, 10, 20);
        Type expected = INVALID;
        assertEquals(actual, expected);
        actual = Triangle.classify(10, 20, 10);
        assertEquals(actual, expected);
        actual = Triangle.classify(20, 10, 10);
        assertEquals(actual, expected);
        actual = Triangle.classify(21, 10, 10);
        assertEquals(actual, expected);
        actual = Triangle.classify(10, 21, 10);
        assertEquals(actual, expected);
        actual = Triangle.classify(10, 10, 21);
        assertEquals(actual, expected);

    }

//    @Test
//    public void test_Boundries() {
//        Type actual = Triangle.classify(Integer.MAX_VALUE-4, Integer.MAX_VALUE-2, Integer.MAX_VALUE);
//        assertEquals(actual, SCALENE);
//        actual = Triangle.classify(10, Integer.MAX_VALUE, Integer.MAX_VALUE);
//        assertEquals(actual, ISOSCELES);
//        actual = Triangle.classify(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
//        assertEquals(actual, EQUILATERAL);
//        actual = Triangle.classify(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
//        assertEquals(actual, INVALID);
//    }
}
