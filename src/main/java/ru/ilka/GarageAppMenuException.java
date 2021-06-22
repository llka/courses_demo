package ru.ilka;

public class GarageAppMenuException extends Exception {
    public GarageAppMenuException() {
    }

    public GarageAppMenuException(String message) {
        super(message);
    }

    public GarageAppMenuException(String message, Throwable cause) {
        super(message, cause);
    }

    public GarageAppMenuException(Throwable cause) {
        super(cause);
    }

    public GarageAppMenuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
