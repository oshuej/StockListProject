package ru.billing.stocklist;

import java.util.StringJoiner;

public class GenericItem implements Cloneable {

    private static int currentID = 0;

    private int ID; // ID товара
    private String name; // Наименование товара
    private float price; // Цена товара
    private GenericItem analogue; // for optional requirement
    private Category productCategory = Category.GENERAL;

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        GenericItem.currentID = currentID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public GenericItem getAnalogue() {
        return analogue;
    }

    public void setAnalogue(GenericItem analogue) {
        this.analogue = analogue;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public GenericItem(){
        this.ID = GenericItem.currentID++;
    }

    public GenericItem(String name, float price, Category category) {
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.productCategory = category;
    }

    public GenericItem(String name, float price, GenericItem analogue) {
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.analogue = analogue;
    }

    public GenericItem(String name,
                       float price,
                       GenericItem analogue,
                       Category category
                       ) {
        this.ID = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.analogue = analogue;
        this.productCategory = category;
    }

    public void printAll(){
        System.out.printf(
                "ID: %d, Name: %-10s, price:%8.2f, Analogue ID: %s, Product Category: %-10s \n",
                this.ID, this.name, this.price, (this.analogue == null) ? "no" : this.analogue.ID, this.productCategory
        );
    }

    // ex 2-2 optional
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof GenericItem)) {
            return false;
        }

        GenericItem genericItem = (GenericItem) o;

        return this.ID == genericItem.ID &&
                this.name.equals(genericItem.name) &&
                this.price == genericItem.price &&
                ((this.analogue != null && genericItem.analogue != null) ?
                        this.analogue.equals(genericItem.analogue) :
                        (this.analogue == null && genericItem.analogue == null)
                ) &&
                this.productCategory == genericItem.productCategory;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        return (this.analogue == null) ? clone : this.analogue.clone();
    }

    @Override
    public String toString() {
        return new StringJoiner(" | " ,
                GenericItem.class.getSimpleName() + " { ",
                " }")
                .add("ID=" + this.ID)
                .add("name=" + this.name)
                .add("price=" + this.price)
                .add((this.analogue == null) ? "analogue=null" : "analogue=" + this.analogue.toString())
                .add("productCategory=" + this.productCategory)
                .toString();
    }
}

