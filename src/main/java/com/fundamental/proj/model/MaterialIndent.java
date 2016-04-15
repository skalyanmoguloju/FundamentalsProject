package com.fundamental.proj.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sai on 3/24/16.
 */
@Entity
@Table(name = "materialindent")
public class MaterialIndent {
    @Id
    @Column(name = "indent_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long indent_id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "price")
    private float price;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "card_cvv")
    private String card_cvv;

    @Column(name = "card_exp")
    private String card_exp;

    @Column(name = "indent_date")
    private Date indent_date;

    public Date getIndent_date() {
        return indent_date;
    }

    public void setIndent_date(Date indent_date) {
        this.indent_date = indent_date;
    }

    public long getIndent_id() {
        return indent_id;
    }

    public void setIndent_id(long indent_id) {
        this.indent_id = indent_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
