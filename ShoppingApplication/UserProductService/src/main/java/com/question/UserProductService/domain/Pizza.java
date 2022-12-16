package com.question.UserProductService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Pizza {



    @Id
    private String pizzaName;
    private String topping;
    private String size;
    private String quantity;
    private String price;
    private String details;


    public Pizza() {
    }

    public Pizza(String pizzaName, String topping, String size, String quantity, String price, String details) {
        this.pizzaName = pizzaName;
        this.topping = topping;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.details = details;

    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaName='" + pizzaName + '\'' +
                ", topping='" + topping + '\'' +
                ", size='" + size + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
