package main.exceptions;


import java.awt.event.FocusEvent;

public class MissingFileException extends Exception{
    public MissingFileException () {
    }

    public MissingFileException(String message) {
        super(message);
    }
}
