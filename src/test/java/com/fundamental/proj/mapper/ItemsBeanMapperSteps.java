package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.ItemsBean;
import com.fundamental.proj.model.Items;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Daniel Dao on 3/8/16.
 */
public class ItemsBeanMapperSteps {

    private ItemsBeanMapper itemsBeanMapper;

    private Items items;
    private ItemsBean itemsBean;
    private List<Items> listItems;
    private List<ItemsBean> listItemsBean;

    /************************************************/
    /*
     * Test mapItemBean()
     */
    /***********************************************/
    @Given("^an Items is initialized$")
    public void an_Items_is_initialized() throws Throwable {
        items = new Items();
        items.setCategory("categ");
        items.setDate(new Date());
        items.setImages("img");
        items.setItem_description("Description");
        items.setItem_id(1L);
        items.setItem_name("name");
        items.setOnsale_count(3);
        items.setPrice(3L);
        items.setSold_count(3);
        items.setUser_id(2L);
    }

    @When("^mapItemBean is called for ItemsBeanMapper$")
    public void mapitembean_is_called_for_ItemsBeanMapper() throws Throwable {
        itemsBeanMapper = new ItemsBeanMapper();
        itemsBean = itemsBeanMapper.mapItemBean(items);
    }

    @Then("^mapItemBean returns a ItemBean$")
    public void mapitembean_returns_a_ItemBean() throws Throwable {
        Assert.assertEquals(itemsBean.getCategory(), items.getCategory());
        Assert.assertEquals(itemsBean.getDate(), items.getDate());
        Assert.assertEquals(itemsBean.getImages(), items.getImages());
        Assert.assertEquals(itemsBean.getItem_description(), items.getItem_description());
        Assert.assertEquals(itemsBean.getItem_id(), items.getItem_id());
        Assert.assertEquals(itemsBean.getItem_name(), items.getItem_name());
        Assert.assertEquals(itemsBean.getOnsale_count(), items.getOnsale_count());
        Assert.assertEquals(itemsBean.getPrice(), items.getSold_count());
        Assert.assertEquals(itemsBean.getSold_count(), items.getSold_count());
        Assert.assertEquals(itemsBean.getUser_id(), items.getUser_id());
    }

    /************************************************/
    /*
     * Test mapBeanToItems()
     */
    /***********************************************/
    @Given("^an ItemsBean is initialized$")
    public void an_ItemsBean_is_initialized() throws Throwable {
        itemsBean = new ItemsBean();
        itemsBean.setCategory("category");
        itemsBean.setDate(new Date());
        itemsBean.setImages("img");
        itemsBean.setItem_description("Description");
        itemsBean.setItem_id(3L);
        itemsBean.setItem_name("name");
        itemsBean.setOnsale_count(3);
        itemsBean.setPrice(30L);
        itemsBean.setSold_count(3);
        itemsBean.setUser_id(20L);
    }

    @When("^mapBeanToItems is called for ItemsBeanMapper$")
    public void mapbeantoitems_is_called_for_ItemsBeanMapper() throws Throwable {
        itemsBeanMapper = new ItemsBeanMapper();
        items = itemsBeanMapper.mapBeanToItems(itemsBean);
    }

    @Then("^mapBeanToItems returns an Items$")
    public void mapbeantoitems_returns_an_Items() throws Throwable {
        Assert.assertEquals(itemsBean.getCategory(), items.getCategory());
        Assert.assertEquals(itemsBean.getDate(), items.getDate());
        Assert.assertEquals(itemsBean.getImages(), items.getImages());
        Assert.assertEquals(itemsBean.getItem_description(), items.getItem_description());
        Assert.assertEquals(itemsBean.getItem_id(), items.getItem_id());
        Assert.assertEquals(itemsBean.getItem_name(), items.getItem_name());
        Assert.assertEquals(itemsBean.getOnsale_count(), items.getOnsale_count());
        Assert.assertEquals(itemsBean.getPrice(), items.getPrice());
        Assert.assertEquals(itemsBean.getUser_id(), items.getUser_id());
        Assert.assertEquals(itemsBean.getSold_count(), items.getSold_count());
    }

    /************************************************/
    /*
     * Test mapItemBean(List)
     */
    /***********************************************/
    @Given("^a list of Items is initialized$")
    public void a_list_of_Items_is_initialized() throws Throwable {
        listItems = new ArrayList<Items>();
        Items items1 = new Items();
        items1.setCategory("categ");
        items1.setDate(new Date());
        items1.setImages("img");
        items1.setItem_description("Description");
        items1.setItem_id(1L);
        items1.setItem_name("name");
        items1.setOnsale_count(3);
        items1.setPrice(3L);
        items1.setSold_count(3);
        items1.setUser_id(2L);


        Items items2 = new Items();
        items2.setCategory("category");
        items2.setDate(new Date());
        items2.setImages("img2");
        items2.setItem_description("Description2");
        items2.setItem_id(2L);
        items2.setItem_name("name2");
        items2.setOnsale_count(32);
        items2.setPrice(32L);
        items2.setSold_count(32);
        items2.setUser_id(22L);

        listItems.add(items1);
        listItems.add(items2);
    }

    @When("^mapItemBean\\(List\\) is called for ItemsBeanMapper$")
    public void mapitembean_List_is_called_for_ItemsBeanMapper() throws Throwable {
        itemsBeanMapper = new ItemsBeanMapper();
        listItemsBean = itemsBeanMapper.mapItemBean(listItems);
    }

    @Then("^mapItemBean\\(List\\) returns a list of ItemBeans$")
    public void mapitembean_List_returns_a_list_of_ItemBeans() throws Throwable {
        Assert.assertEquals(listItemsBean.size(), listItems.size());
        for (int x=0; x<listItems.size(); x++) {
            Assert.assertEquals(listItems.get(x).getCategory(), listItemsBean.get(x).getCategory());
            Assert.assertEquals(listItems.get(x).getDate(), listItemsBean.get(x).getDate());
            Assert.assertEquals(listItems.get(x).getImages(), listItemsBean.get(x).getImages());
            Assert.assertEquals(listItems.get(x).getItem_description(), listItemsBean.get(x).getItem_description());
            Assert.assertEquals(listItems.get(x).getItem_id(), listItemsBean.get(x).getItem_id());
            Assert.assertEquals(listItems.get(x).getItem_name(), listItemsBean.get(x).getItem_name());
            Assert.assertEquals(listItems.get(x).getOnsale_count(), listItemsBean.get(x).getOnsale_count());
            Assert.assertEquals(listItems.get(x).getPrice(), listItemsBean.get(x).getPrice());
            Assert.assertEquals(listItems.get(x).getUser_id(), listItemsBean.get(x).getUser_id());
            Assert.assertEquals(listItems.get(x).getSold_count(), listItemsBean.get(x).getSold_count());
        }
    }

}
