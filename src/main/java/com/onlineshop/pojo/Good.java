package com.onlineshop.pojo;

public class Good {
    private int id;
    private int price;
    private String description;
    private int reserve;
    private String image;
    private int type;
    private String name;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public int getReserve() {
        return reserve;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

}
