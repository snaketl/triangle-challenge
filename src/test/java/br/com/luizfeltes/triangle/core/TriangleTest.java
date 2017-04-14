package br.com.luizfeltes.triangle.core;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the test class of Triangle
 * 
 * @author Luiz Feltes
 * @see Triangle
 * @see TriangleType
 */
public class TriangleTest {

    /**
     * Should convert the values from array of String
     */
    @Test
    public void shouldConvertFromStringArray() {
        Arrays.asList(
                with("1", "1", "1"),
                with("2", "1", "2")
        ).forEach(Triangle::of);
    }

    /**
     * Should return an TriangleException when invalid values on array
     */
    @Test
    public void shouldReturnTriangleExceptionFromInvalidArrayValues() {
        Arrays.asList(
                null,
                with("a", "b", "c"),
                with("1", "1"),
                with("1", "1", "1", "1"),
                with("0", "0", "0"),
                with("-1", "-1", "-1"),
                with("-5.5", "-5.5", "-5.5")
        ).forEach((sides) -> {
            try {
                Triangle.of(sides);
                fail();
            } catch (TriangleException e) {
            }
        });
    }

    /**
     * Should return EQUILATERAL type gives the values
     */
    @Test
    public void shouldBeEquilateral() {
        Arrays.asList(
                with("1", "1", "1"),
                with("1.1", "1.1", "1.1"),
                with("999", "999", "999")
        ).forEach((sides) -> {
            assertEquals(TriangleType.EQUILATERAL, Triangle.of(sides).getType());
        });
    }

    /**
     * Should return ISOSCELES type gives the values
     */
    @Test
    public void shouldBeIsosceles() {
        Arrays.asList(
                with("2", "2", "3"),
                with("1.1", "1.1", "2.1"),
                with("999", "999", "100")
        ).forEach((sides) -> {
            assertEquals(TriangleType.ISOSCELES, Triangle.of(sides).getType());
        });
    }

    /**
     * Should return SCALENE type gives the values
     */
    @Test
    public void shouldBeScalene() {
        Arrays.asList(
                with("2", "3", "4"),
                with("1.1", "2.2", "3.3")
        ).forEach((sides) -> {
            assertEquals(TriangleType.SCALENE, Triangle.of(sides).getType());
        });
    }

    /**
     * Internal method to help create sides based on String varargs
     * 
     * @param values the String value of the side
     * @return an Array of String with the sides
     */
    private String[] with(String... values) {
        return values;
    }

    /**
     * Internal method to help create sides based on three String values
     * 
     * @param a the side A
     * @param b the side B
     * @param c the side C
     * @return an Array of String with the sides
     */
    private String[] with(String a, String b, String c) {
        return new String[] {a, b, c};
    }

}
