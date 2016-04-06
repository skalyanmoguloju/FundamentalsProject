package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.CartBean;
import com.fundamental.proj.controller.bean.ItemsBean;
import com.fundamental.proj.model.Cart;
import com.fundamental.proj.model.Items;
import cucumber.api.java.en.And;
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
public class CartBeanMapperSteps {

    private CartBeanMapper cartBeanMapper;

    private CartBean expectedCartBean;
    private CartBean actualCartBean;
    private Cart expectedCart;
    private Cart actualCart;
    private List<Cart> cartList;
    private List<CartBean> actualListCart;

    /************************************************/
    /*
     * Test mapItemBean()
     */
    /***********************************************/

    @Given("^expected cart is initialized for CartBeanMapper$")
    public void expected_cart_is_initialized_Cartbean() throws Throwable {
        Items items = new Items();
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

        expectedCart = new Cart();
        expectedCart.setPrice(3L);
        expectedCart.setQuantity(4);
        expectedCart.setUser_id(1L);
        expectedCart.setCart_id(2L);
        expectedCart.setItems(items);
    }

    @When("^mapItemBean is called$")
    public void mapitembean_is_called() throws Throwable {
        cartBeanMapper = new CartBeanMapper();
        actualCartBean = cartBeanMapper.mapItemBean(expectedCart);
    }

    @Then("^mapItemBean returns a cartbean$")
    public void mapitembean_returns_a_cartbean() throws Throwable {

        Assert.assertEquals(actualCartBean.getPrice(), expectedCart.getPrice(), 1E-15);
        Assert.assertEquals(actualCartBean.getQuantity(), expectedCart.getQuantity());
        Assert.assertEquals(actualCartBean.getUser_id(), expectedCart.getUser_id());
        Assert.assertEquals(actualCartBean.getCart_id(), expectedCart.getCart_id());

        // Test itemsBean
        ItemsBean actualItemsBean = actualCartBean.getItemsBean();
        ItemsBean expectedItemsBean = new ItemsBeanMapper().mapItemBean(expectedCart.getItems());
        Assert.assertEquals(actualItemsBean.getCategory(), expectedItemsBean.getCategory());
        Assert.assertEquals(actualItemsBean.getDate(), expectedItemsBean.getDate());
        Assert.assertEquals(actualItemsBean.getImages(), expectedItemsBean.getImages());
        Assert.assertEquals(actualItemsBean.getItem_description(), expectedItemsBean.getItem_description());
        Assert.assertEquals(actualItemsBean.getItem_id(), expectedItemsBean.getItem_id());
        Assert.assertEquals(actualItemsBean.getItem_name(), expectedItemsBean.getItem_name());
        Assert.assertEquals(actualItemsBean.getOnsale_count(), expectedItemsBean.getOnsale_count());
        Assert.assertEquals(actualItemsBean.getPrice(), expectedItemsBean.getPrice(), 1E-15);
        Assert.assertEquals(actualItemsBean.getUser_id(), expectedItemsBean.getUser_id());
        Assert.assertEquals(actualItemsBean.getSold_count(), expectedItemsBean.getSold_count());
    }

    /************************************************/
    /*
     * Test mapBeanToCart()
     */
    /***********************************************/

    @Given("^expected cartbean is initialized for CartBeanMapper$")
    public void expected_cartbean_is_initialized() throws Throwable {
        ItemsBean itemsBean = new ItemsBean();
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

        expectedCartBean = new CartBean();
        expectedCartBean.setPrice(3F);
        expectedCartBean.setQuantity(3);
        expectedCartBean.setUser_id(1L);
        expectedCartBean.setCart_id(2L);
        expectedCartBean.setItemsBean(itemsBean);
    }

    @When("^mapBeanToCart is called$")
    public void mapbeantocart_is_called() throws Throwable {
        cartBeanMapper = new CartBeanMapper();
        actualCart = cartBeanMapper.mapBeanToCart(expectedCartBean);
    }

    @Then("^mapBeanToCart returns a cart$")
    public void mapbeantocart_returns_a_cart() throws Throwable {

        Assert.assertEquals(actualCart.getPrice(), expectedCartBean.getPrice(), 1E-15);
        Assert.assertEquals(actualCart.getQuantity(), expectedCartBean.getQuantity());
        Assert.assertEquals(actualCart.getUser_id(), expectedCartBean.getUser_id());
        Assert.assertEquals(actualCart.getCart_id(), expectedCartBean.getCart_id());

        // Test items
        Items actualItems = actualCart.getItems();
        Items expectedItems = new ItemsBeanMapper().mapBeanToItems(expectedCartBean.getItemsBean());
        Assert.assertEquals(actualItems.getCategory(), expectedItems.getCategory());
        Assert.assertEquals(actualItems.getDate(), expectedItems.getDate());
        Assert.assertEquals(actualItems.getImages(), expectedItems.getImages());
        Assert.assertEquals(actualItems.getItem_description(), expectedItems.getItem_description());
        Assert.assertEquals(actualItems.getItem_id(), expectedItems.getItem_id());
        Assert.assertEquals(actualItems.getItem_name(), expectedItems.getItem_name());
        Assert.assertEquals(actualItems.getOnsale_count(), expectedItems.getOnsale_count());
        Assert.assertEquals(actualItems.getPrice(), expectedItems.getPrice(), 1E-15);
        Assert.assertEquals(actualItems.getUser_id(), expectedItems.getUser_id());
        Assert.assertEquals(actualItems.getSold_count(), expectedItems.getSold_count());
    }

    /************************************************/
    /*
     * Test mapItemsBean(List)
     */
    /***********************************************/
    @When("^expected list of cartbeans is initialized for CartBeanMapper")
    public void expected_list_of_cartbeans_is_initialized_for_mapItemsBean() throws Throwable {
        Items items = new Items();
        expectedCart = new Cart();

        expectedCart.setPrice(3L);
        expectedCart.setQuantity(4);
        expectedCart.setUser_id(1L);
        expectedCart.setCart_id(2L);
        expectedCart.setItems(items);

        cartList = new ArrayList<Cart>();
        cartList.add(expectedCart);
    }

    @When("^mapItemsBeanList is called$")
    public void mapitemsbeanlist_is_called() throws Throwable {
        cartBeanMapper = new CartBeanMapper();
        actualListCart = cartBeanMapper.mapItemsBean(cartList);

    }

    @Then("^mapItemsBeanList returns some cartbeans$")
    public void mapitemsbean_returns_some_cartbeans() throws Throwable {
        Assert.assertEquals(actualListCart.size(), cartList.size());
        for(int x=0; x < cartList.size(); x++) {
            Assert.assertEquals(actualListCart.get(x).getUser_id(), cartList.get(x).getUser_id());
            Assert.assertEquals(actualListCart.get(x).getPrice(), cartList.get(x).getPrice(), 1E-15);
            Assert.assertEquals(actualListCart.get(x).getCart_id(), cartList.get(x).getCart_id());
            Assert.assertEquals(actualListCart.get(x).getQuantity(), cartList.get(x).getQuantity());
        }
    }
}
