package com.io.management.model;

import javax.persistence.*;


@Entity(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ProductId;
    private String productScanCode;
    private String productName;
    private int sunday;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private int saturday;
    private int quantitySold;
    private double price;
    private double totalProductSale;
    private int quantityLeft;
    @Transient
    private int quantity;

    @Transient
    private String searchText;

    @Transient
    private String dayOfWeek;

    public Product() {
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductScanCode() {
        return productScanCode;
    }

    public void setProductScanCode(String productScanCode) {
        this.productScanCode = productScanCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSunday() {
        return sunday;
    }

    public void setSunday(int sunday) {
        this.sunday = sunday;
    }

    public int getMonday() {
        return monday;
    }

    public void setMonday(int monday) {
        this.monday = monday;
    }

    public int getTuesday() {
        return tuesday;
    }

    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    public int getWednesday() {
        return wednesday;
    }

    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }

    public int getThursday() {
        return thursday;
    }

    public void setThursday(int thursday) {
        this.thursday = thursday;
    }

    public int getFriday() {
        return friday;
    }

    public void setFriday(int friday) {
        this.friday = friday;
    }

    public int getSaturday() {
        return saturday;
    }

    public void setSaturday(int saturday) {
        this.saturday = saturday;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalProductSale() {
        return totalProductSale;
    }

    public void setTotalProductSale(double totalProductSale) {
        this.totalProductSale = totalProductSale;
    }

    public int getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
