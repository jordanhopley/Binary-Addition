/**
 *
 * Provides error detection for input string validation.
 *
 * @author Jordan Hopley
 *
 */
public class InvalidStringException extends Error {

    public InvalidStringException(String message) {
        super(message);
    }

}
