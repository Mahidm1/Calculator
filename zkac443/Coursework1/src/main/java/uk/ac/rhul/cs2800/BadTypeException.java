package uk.ac.rhul.cs2800;

/**
 * An exception class representing an error when attempting to access the wrong type in an {@link Entry}.
 */
public class BadTypeException extends RuntimeException {

    /**
     * Constructs a new {@code BadType} exception with the specified error message.
     *
     * @param message The error message describing the bad type encountered.
     */
    public BadTypeException(String message) {
        super(message);
    }
}
