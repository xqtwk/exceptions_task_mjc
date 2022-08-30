package main.exceptions;

public class OutOfBoundArgumentException extends IllegalArgumentException{
    public OutOfBoundArgumentException() {
    }

    public OutOfBoundArgumentException(String s) {
        super(s);
    }
}
