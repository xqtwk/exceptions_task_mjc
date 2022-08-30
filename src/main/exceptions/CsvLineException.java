package main.exceptions;

import java.util.Arrays;

public class CsvLineException extends Exception{
    public CsvLineException(String message) {
        super(message);
    }

    public CsvLineException(String message, Throwable cause) {
        super(message, cause);
    }
    public CsvLineException(String[] values){
        super(Arrays.toString(values));
    }

    public CsvLineException(String[] values, Throwable cause){
        super(Arrays.toString(values));
    }
}
