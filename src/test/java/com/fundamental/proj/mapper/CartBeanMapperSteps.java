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

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class CartBeanMapperSteps {

    @Mock
    private ItemsBeanMapper mockedItemsBeanMapper;

    @Mock
    private ItemsBean mockedItemsBean;

    @InjectMocks
    private CartBeanMapper cartBeanMapper;

    private CartBean expectedCartBean;
    private ItemsBean expectedItemsBean;
    private Cart expectedCart;

    @Given("^mock CartBeanMapper is initialized$")
    public void mock_CartBeanMapper_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedItemsBeanMapper, mockedItemsBean);
    }

    /************************************************/
    /*
     * Test mapItemBean()
     */
    /***********************************************/
    @When("^mapItemBean is called$")
    public void mapitembean_is_called() throws Throwable {
        Mockito.when(mockedItemsBeanMapper.mapItemBean(Mockito.any(Items.class))).thenReturn(expectedItemsBean);
    }

    @And("^expected cartBean is initialized$")
    public void expected_cartBean_is_initialized() throws Throwable {
        Items items = new Items();
        expectedItemsBean = new ItemsBean();
        expectedCart = new Cart();

        expectedCart.setPrice(3L);
        expectedCart.setQuantity(4L);
        expectedCart.setUser_id(1L);
        expectedCart.setCart_id(2L);
        expectedCart.setItems(items);
    }

    @Then("^mapItemBean returns a cartbean$")
    public void mapitembean_returns_a_cartbean() throws Throwable {
        CartBean actualCartBean = cartBeanMapper.mapItemBean(expectedCart);

        Assert.assertEquals(actualCartBean.getPrice(), expectedCart.getPrice(), 1E-15);
        Assert.assertEquals(actualCartBean.getQuantity(), expectedCart.getQuantity());
        Assert.assertEquals(actualCartBean.getUser_id(), expectedCart.getUser_id());
        Assert.assertEquals(actualCartBean.getCart_id(), expectedCart.getCart_id());

    }

    /************************************************/
    /*
     * Test mapBeanToCart()
     */
    /***********************************************/

    @When("^expected cart is initialized$")
    public void expected_cart_is_initialized() throws Throwable {
        expectedCartBean = new CartBean();
        expectedCartBean.setPrice(3F);
        expectedCartBean.setQuantity(3L);
        expectedCartBean.setUser_id(1L);
        expectedCartBean.setCart_id(2L);
    }

    @Then("^mapBeanToCart returns a cart$")
    public void mapbeantocart_returns_a_cart() throws Throwable {
        Cart actualCart = cartBeanMapper.mapBeanToCart(expectedCartBean);

        Assert.assertEquals(actualCart.getPrice(), expectedCartBean.getPrice(), 1E-15);
        Assert.assertEquals(actualCart.getQuantity(), expectedCartBean.getQuantity());
        Assert.assertEquals(actualCart.getUser_id(), expectedCartBean.getUser_id());
        Assert.assertEquals(actualCart.getCart_id(), expectedCartBean.getCart_id());
    }

    @When("^expected empty cart is initialized$")
    public void expected_empty_cart_is_initialized() throws Throwable {
        expectedCartBean = new CartBean();
    }

    @Then("^mapBeanToCart returns empty$")
    public void mapbeantocart_returns_empty() throws Throwable {
        Cart actualCart = cartBeanMapper.mapBeanToCart(expectedCartBean);

        Assert.assertEquals(actualCart.getPrice(), expectedCartBean.getPrice(), 1E-15);
        Assert.assertEquals(actualCart.getQuantity(), expectedCartBean.getQuantity());
        Assert.assertEquals(actualCart.getCart_id(), expectedCartBean.getCart_id());
        Assert.assertEquals(actualCart.getUser_id(), expectedCartBean.getUser_id());
    }

    /************************************************/
    /*
     * Test mapItemsBean()
     */
    /***********************************************/
    @When("^expected list of cartbeans is initialized for mapItemsBean$")
    public void expected_list_of_cartbeans_is_initialized_for_mapItemsBean() throws Throwable {
        Items items = new Items();
        expectedCart = new Cart();

        expectedCart.setPrice(3L);
        expectedCart.setQuantity(4L);
        expectedCart.setUser_id(1L);
        expectedCart.setCart_id(2L);
        expectedCart.setItems(items);
    }

    @Then("^mapItemsBean returns some cartbeans$")
    public void mapitemsbean_returns_some_cartbeans() throws Throwable {
        List<Cart> cartList = new ArrayList<Cart>();
        cartList.add(expectedCart);

        List<CartBean> actualListCart = cartBeanMapper.mapItemsBean(cartList);

        Assert.assertEquals(actualListCart.size(), cartList.size());
        for(int x=0; x < cartList.size(); x++) {
            Assert.assertEquals(actualListCart.get(x).getUser_id(), cartList.get(x).getUser_id());
            Assert.assertEquals(actualListCart.get(x).getPrice(), cartList.get(x).getPrice(), 1E-15);
            Assert.assertEquals(actualListCart.get(x).getCart_id(), cartList.get(x).getCart_id());
            Assert.assertEquals(actualListCart.get(x).getQuantity(), cartList.get(x).getQuantity());

        }

    }
}
