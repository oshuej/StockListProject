package ru.billing.exceptions;

import ru.billing.stocklist.GenericItem;

// lab 6 ex 6-1
public class ItemAlreadyExistsException extends Exception {

    private GenericItem item;

    public GenericItem getItem() {
        return item;
    }

    public void setItem(GenericItem item) {
        this.item = item;
    }

    public ItemAlreadyExistsException(GenericItem item) {
        this.item = item;
    }

    public String toString() {
        return "Incorrect ID in " + this.item.toString();
    }
}
