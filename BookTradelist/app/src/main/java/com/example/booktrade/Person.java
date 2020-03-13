package com.example.booktrade;



public class Person {

    private String book_name;
    private String price;
    private String seller_name;
    private String phno;
    private String web;
    private String add;
    private String pref;

    public Person(String book_name, String price, String seller_name, String phno, String web, String add, String pref) {
        this.book_name = book_name;
        this.price = price;
        this.seller_name = seller_name;
        this.phno = phno;
        this.web = web;
        this.add = add;
        this.pref = pref;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getPref() {
        return pref;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }
}


