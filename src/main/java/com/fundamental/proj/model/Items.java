package com.fundamental.proj.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sai on 3/5/16.
 */
@Entity
@Table(name = "Items")
public class Items {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long item_id;

    @Column(name = "item_name")
    private String item_name;
    @Column(name = "item_description")
    private String item_description;
    @Column(name = "onsale_count")
    private int onsale_count;
    @Column(name = "sold_count")
    private int sold_count;
    @Column(name = "category")
    private String category;
    @Column(name = "images")
    private String images;
    @Column(name = "price")
    private long price;
    @Column(name = "date")
    private Date date;

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public int getOnsale_count() {
        return onsale_count;
    }

    public void setOnsale_count(int onsale_count) {
        this.onsale_count = onsale_count;
    }

    public int getSold_count() {
        return sold_count;
    }

    public void setSold_count(int sold_count) {
        this.sold_count = sold_count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
