package org.picstories.library.exceptions;

/**
 * @author arman.shamenov
 */
public class SerializationException extends Exception {

    public SerializationException(String message) {
        super(message);
    }

    public SerializationException(Throwable cause) {
        super(cause);
    }

    public SerializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
