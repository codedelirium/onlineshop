package com.onlineshop.pojo;

public class User {
    private int id;
    private int money;
    private String pwd;
    private String name;
    private int type;
    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type){this.type = type;}

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public int getType(){return type;}

    public int getMoney() {
        return money;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

}

