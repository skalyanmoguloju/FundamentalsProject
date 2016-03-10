package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.ItemsBean;
import com.fundamental.proj.model.Items;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 3/9/16.
 */
@Component
public class ItemsBeanMapper {
    public ItemsBean mapItemBean(Items items){
        ItemsBean itemsBean = new ItemsBean();
        itemsBean.setCategory(items.getCategory());
        itemsBean.setDate(items.getDate());
        itemsBean.setImages(items.getImages());
        itemsBean.setItem_description(items.getItem_description());
        itemsBean.setItem_id(items.getItem_id());
        itemsBean.setItem_name(items.getItem_name());
        itemsBean.setOnsale_count(items.getOnsale_count());
        itemsBean.setPrice(items.getPrice());
        itemsBean.setSold_count(items.getSold_count());
        return itemsBean;
    }

    public Items mapBeanToItems(ItemsBean itemsBean){
        Items items = new Items();
        items.setCategory(itemsBean.getCategory());
        items.setDate(itemsBean.getDate());
        items.setImages(itemsBean.getImages());
        items.setItem_description(itemsBean.getItem_description());
        items.setItem_id(itemsBean.getItem_id());
        items.setItem_name(itemsBean.getItem_name());
        items.setOnsale_count(itemsBean.getOnsale_count());
        items.setPrice(itemsBean.getPrice());
        items.setSold_count(itemsBean.getSold_count());
        return items;
    }

    public List<ItemsBean> mapItemBean(List<Items> itemses)
    {
        List<ItemsBean> itemsBeans = new ArrayList<ItemsBean>();
        for(Items items:itemses){
            itemsBeans.add((mapItemBean(items)));
        }
        return itemsBeans;
    }
}
