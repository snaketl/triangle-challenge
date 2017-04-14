package br.com.luizfeltes.triangle.core;

/**
 * This is a triangle class with three sides.
 *
 * @author Luiz Feltes
 */
public class Triangle {

    /** Side A */
    private final double a;
    /** Side B */
    private final double b;
    /** Side C */
    private final double c;

    /**
     * Constructs a Triangle object with three sides.
     * The sides must be valid sides of a triangle, positive and greater than zeros.
     * Otherwise will raise a TriangleException.
     * The rule is based on triangle inequality formula:  
     * https://en.wikipedia.org/wiki/Triangle_inequality
     *
     * @param a the side A
     * @param b the side B
     * @param c the side C
     */
    public Triangle(double a, double b, double c) {
        throwIf(a <= 0 || b <= 0 || c <= 0,
                "Should be positive values greater than zeros!", a, b, c);
        throwIf(a >= b + c || c >= b + a || b >= a + c,
                "Should be valid values to build a triangle using the Triangle inequality formula!", a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Return the side A
     *
     * @return the side A
     */
    public double getA() {
        return a;
    }

    /**
     * Return the side B
     *
     * @return the side B
     */
    public double getB() {
        return b;
    }

    /**
     * Return the side C
     *
     * @return the side C
     */
    public double getC() {
        return c;
    }

    /**
     * Return the type of Triangle object
     *
     * @see TriangleType
     * @return the type
     */
    public TriangleType getType() {
        if (a == b && b == c) return TriangleType.EQUILATERAL;
        if (b == c || a == b || c == a) return TriangleType.ISOSCELES;
        return TriangleType.SCALENE;
    }

    /**
     * Builder of a Triangle object using an array of String with three sides
     *
     * @param values the array of string with three sides
     * @return
     */
    public static Triangle of(String[] values) {
        if (values == null) {
            throw new TriangleException("Should not be null!");
        }
        if (values.length != 3) {
            throw TriangleException.of("Should have 3 sides!", null, values);
        }
        try {
            return new Triangle(Double.valueOf(values[0]), Double.valueOf(values[1]), Double.valueOf(values[2]));
        } catch (TriangleException e) {
            throw e;
        } catch (Exception e) {
            throw TriangleException.of("Should be valid sides!", e, values);
        }
    }

    /**
     * Return a string representation of the Triangle
     *
     * @return the string representation of the Triangle
     */
    @Override
    public String toString() {
        return "Triangle{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    /**
     * Returns a hash code value for the Triangle
     * This method is supported for the benefit of hash tables
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.a) ^ (Double.doubleToLongBits(this.a) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.b) ^ (Double.doubleToLongBits(this.b) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.c) ^ (Double.doubleToLongBits(this.c) >>> 32));
        return hash;
    }

    /**
     * Indicates whether some other Triangle is "equal to" this one.
     *
     * @param obj the other Triangle
     * @return true if this object is the same as the obj
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Triangle other = (Triangle) obj;
        if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(other.a)) {
            return false;
        }
        if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(other.b)) {
            return false;
        }
        if (Double.doubleToLongBits(this.c) != Double.doubleToLongBits(other.c)) {
            return false;
        }
        return true;
    }

    /**
     * Internal method to throw a TriangleException if the condition is true
     *
     * @param condition the condition
     * @param message the detail message
     * @param a the side A
     * @param b the side B
     * @param c the side C
     */
    private void throwIf(boolean condition, String message, double a, double b, double c) {
        if (condition) throw TriangleException.of(message, null, a, b, c);
    }

}
