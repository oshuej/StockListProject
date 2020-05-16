package ru.billing.stocklist;

import java.util.Date;
import java.util.StringJoiner;

// ex 2-1
public class FoodItem extends GenericItem {

    private Date dateOfIncome;
    private short expires;

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }

    public FoodItem(){
    }

    public FoodItem(String name) {
        super(name, 0.5f, Category.FOOD);
    }

    public FoodItem(String name, float price, short expires) {
        super(name, price, Category.FOOD);
        this.expires = expires;
    }


    public FoodItem(String name, float price, FoodItem analogue, Date dateOfIncome, short expires) {
        super(name, price, analogue);
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    public FoodItem(String name,
                    float price,
                    FoodItem analogue,
                    Category category,
                    Date dateOfIncome,
                    short expires) {
        super(name, price, analogue, category);
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    @Override
    public void printAll() {
        System.out.printf("ID: %d, " +
                        "Name: %-10s, " +
                        "price: %8.2f, " +
                        "Analogue ID: %s, " +
                        "Product Category: %-10s, " +
                        "Date of Income: %tc, " +
                        "Expire after: %d \n",
                this.getID(), this.getName(), this.getPrice(),
                (this.getAnalogue() == null) ? "no" : this.getAnalogue().getID(),
                this.getProductCategory(), this.dateOfIncome, this.expires
        );
    }

    // ex 2-2 optional
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof FoodItem)) {
            return false;
        }

        FoodItem foodItem = (FoodItem) o;

        return this.getID() == foodItem.getID() &&
                this.getName().equals(foodItem.getName()) &&
                this.getPrice() == foodItem.getPrice() &&
                this.getAnalogue().equals(foodItem.getAnalogue()) &&
                this.getProductCategory() == foodItem.getProductCategory() &&
                this.dateOfIncome == foodItem.dateOfIncome &&
                this.expires == foodItem.expires;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return new StringJoiner(" | " ,
                GenericItem.class.getSimpleName() + " { ",
                " }")
                .add("ID=" + this.getID())
                .add("name=" + this.getName())
                .add("price=" + this.getPrice())
                .add((this.getAnalogue() == null) ? "analogue=null" : "analogue=" + this.getAnalogue().toString())
                .add("productCategory=" + this.getProductCategory())
                .add("dateOfIncome=" + this.dateOfIncome)
                .add("expires=" + this.expires)
                .toString();
    }
}
