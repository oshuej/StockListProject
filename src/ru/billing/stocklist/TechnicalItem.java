package ru.billing.stocklist;

import java.util.StringJoiner;

// ex 2-1
public class TechnicalItem extends GenericItem {

    private short warrantyTime;

    public short getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    public TechnicalItem(){
    }

    public TechnicalItem(String name,
                         float price,
                         TechnicalItem analogue,
                         Category category,
                         short warrantyTime) {
        super(name, price, analogue, category);
        this.warrantyTime = warrantyTime;
    }

    @Override
    public void printAll() {
        System.out.printf("ID: %d, " +
                        "Name: %-10s, " +
                        "price:%8.2f, " +
                        "Analogue ID: %s, " +
                        "Product Category: %-10s, " +
                        "Warranty time in days: %d \n",
                this.getID(), this.getName(), this.getPrice(),
                (this.getAnalogue() == null) ? "no" : this.getAnalogue().getID(),
                this.getProductCategory(), this.warrantyTime
        );
    }

    // ex 2-2 optional
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TechnicalItem)) {
            return false;
        }

        TechnicalItem technicalItem = (TechnicalItem) o;

        return this.getID() == technicalItem.getID() &&
                this.getName().equals(technicalItem.getName()) &&
                this.getPrice() == technicalItem.getPrice() &&
                this.getAnalogue().equals(technicalItem.getAnalogue()) &&
                this.getProductCategory() == technicalItem.getProductCategory() &&
                this.warrantyTime == technicalItem.warrantyTime;
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
                .add("warrantyTime=" + this.warrantyTime)
                .toString();
    }
}
