package com.example.javaprojektfx.model;

public class Dish extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String name;

    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String description;

    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String price;

    @ForeignKey(table = "Category", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int category_id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
