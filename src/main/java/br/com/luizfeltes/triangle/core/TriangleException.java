package br.com.luizfeltes.triangle.core;

/**
 * This is an exception for invalid or inappropriate triangle
 * 
 * @author Luiz Feltes
 * @see Triangle
 */
public class TriangleException extends RuntimeException {

    /**
     * Constructs a TriangleException with a message
     * 
     * @param message 
     */
    public TriangleException(String message) {
        super(message);
    }

    /**
     * Constructs a TriangleException with a message and a cause
     * 
     * @param message the detail message
     * @param cause the cause
     */
    public TriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Builder of a TriangleException object with a message, a cause and the values
     * 
     * @param message the detail message
     * @param cause the cause
     * @param a the side a
     * @param b the side b
     * @param c the side c
     * @return a new TriangleException object
     */
    public static TriangleException of(String message, Throwable cause, double a, double b, double c) {
        return of(message, cause, String.valueOf(a), String.valueOf(b), String.valueOf(c));
    }
    
    /**
     * Builder of a TriangleException object with a message, a cause and the values
     * 
     * @param message the detail message
     * @param cause the cause
     * @param values the values of triangle
     * @return a new TriangleException object
     */
    public static TriangleException of(String message, Throwable cause, String[] values) {        
        if (values == null) {
            return new TriangleException(message, cause);
        }
        String a = values.length >= 1 ? values[0] : "0";
        String b = values.length >= 2 ? values[1] : "0";
        String c = values.length >= 3 ? values[2] : "0";
        return of(message, cause, a, b, c);
    }
    
    /**
     * Builder of a TriangleException object with a message, a cause and the values
     * 
     * @param message the detail message
     * @param cause the cause
     * @param a the side a
     * @param b the side b
     * @param c the side c
     * @return a new TriangleException object
     */
    public static TriangleException of(String message, Throwable cause, String a, String b, String c) {
        return new TriangleException(String.format(message + " Input was: a=%s, b=%s, c=%s", a, b, c), cause);
    }    
    
}
