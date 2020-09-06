package ru.geekbrains.main.site.at.utils;

public class ButtonNotFoundException extends RuntimeException{
    public ButtonNotFoundException() {
    }

    public ButtonNotFoundException(String message) {
        super(message);
    }

    public ButtonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ButtonNotFoundException(Throwable cause) {
        super(cause);
    }

    public ButtonNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
