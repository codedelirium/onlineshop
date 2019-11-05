package com.onlineshop.pojo;

public class Cart {
    private int id;
    private int amount;
    private int total;
    private int price;
    private Good good;
    private int user_id;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setGood(Good good){
        this.good = good;
    }

    public Good getGood(){
        return good;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getUser_id() {
        return user_id;
    }
}
