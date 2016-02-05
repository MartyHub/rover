package org.sweet.rover;

public class RoverException extends RuntimeException {

    private static final long serialVersionUID = -1855923128642980104L;

    public RoverException(final String format, final Object... args) {
        super(String.format(format, args));
    }

    public RoverException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RoverException(final String format, final Throwable cause, final Object... args) {
        super(String.format(format, args), cause);
    }

    public static RoverException unknown(final Object value) {
        return new RoverException("Don't know how to handle <%s>", value);
    }
}
