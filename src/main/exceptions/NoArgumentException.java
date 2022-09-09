package main.exceptions;

public class NoArgumentException extends IllegalArgumentException{
    public NoArgumentException() {

    }

    public NoArgumentException(String message) {
        super(message);
    }
}
