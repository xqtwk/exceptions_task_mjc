package main.exceptions;

public class ZeroArgumentException extends IllegalArgumentException{
    public ZeroArgumentException() {

    }

    public ZeroArgumentException(String message) {
        super(message);
    }
}
