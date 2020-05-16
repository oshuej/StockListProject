package ru.billing.exceptions;

// lab 6 ex 6-1
public class CatalogLoadException extends Exception {

    public CatalogLoadException(Exception e) {
        e.printStackTrace();
    }
}
