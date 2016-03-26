package com.fundamental.proj.controller.bean;

/**
 * Created by sai on 3/24/16.
 */
public class MaterialIndentBean {
    private long indent_id;
    private long user_id;

    private float price;

    private String card_number;

    private String card_cvv;
    private String card_exp;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getIndent_id() {
        return indent_id;
    }

    public void setIndent_id(long indent_id) {
        this.indent_id = indent_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCard_cvv() {
        return card_cvv;
    }

    public void setCard_cvv(String card_cvv) {
        this.card_cvv = card_cvv;
    }

    public String getCard_exp() {
        return card_exp;
    }

    public void setCard_exp(String card_exp) {
        this.card_exp = card_exp;
    }





}
