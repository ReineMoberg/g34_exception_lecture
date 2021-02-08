package se.lexicon.exceptions;

public class FileFormatException extends RuntimeException {

    private String message;

    public FileFormatException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
