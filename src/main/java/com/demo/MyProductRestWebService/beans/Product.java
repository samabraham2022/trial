package com.demo.MyProductRestWebService.beans;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private LocalDate expirydate;
    private int cid;

    public Product(int id, String name, int quantity, double price, LocalDate expirydate, int cid) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expirydate = expirydate;
        this.cid = cid;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(LocalDate expirydate) {
        this.expirydate = expirydate;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        String str = expirydate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", expirydate=" + str +
                ", cid=" + cid +
                '}';
    }
}

