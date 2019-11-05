package com.onlineshop.pojo;

public class BillItem {
    private int amount;
    private Good good;
    private int price;
    private int bid;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Good getGood() {
        return good;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setGood(Good good) {
        this.good = good;
    }

}
