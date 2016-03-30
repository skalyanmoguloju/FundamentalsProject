package com.fundamental.proj.controller.bean;

import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by Madeline on 3/21/16.
 */
public class CartBeanSteps {
    @Mock
    private CartBean mockedCartBean;

    @InjectMocks
    private CartBean cartBean;
    private long user_id;
    private long quantity;
    private float price;
    private ItemsBean itemsBean;
    private long cart_id;

    @Given("^mock CartBean is initialized$")
    public void mock_CartBean_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedCartBean);
    }

    @When("^setItemsBean\\(\\) is called$")
    public void setitemsbean_is_called() throws Throwable {
        cartBean.setItemsBean(itemsBean);
        mockedCartBean.setItemsBean(itemsBean);
        Mockito.verify(mockedCartBean).setItemsBean(itemsBean);
    }

    @Then("^setItemsBean\\(\\) is successfully called$")
    public void setitemsbean_is_successfully_called() throws Throwable {
        itemsBean = new ItemsBean();
        mockedCartBean.setItemsBean(itemsBean);

        // verify setId has been called successfully
        Mockito.verify(mockedCartBean).setItemsBean(itemsBean);
    }

    @When("^getCart_id\\(\\) is called$")
    public void getcart_id_is_called() throws Throwable {
        mockedCartBean.getCart_id();
        Mockito.verify(mockedCartBean).getCart_id();
    }

    @Then("^a cart id is returned$")
    public void a_cart_id_is_returned() throws Throwable {
        long actualCart_id = cartBean.getCart_id();

        Assert.assertEquals(actualCart_id, cart_id);
    }

    @When("^setCart_id\\(\\) is called$")
    public void setcart_id_is_called() throws Throwable {
        cartBean.setCart_id(cart_id);
        mockedCartBean.setCart_id(cart_id);
        Mockito.verify(mockedCartBean).setCart_id(cart_id);
    }

    @Then("^setCart_id\\(\\) is successfully called$")
    public void setcart_id_is_successfully_called() throws Throwable {
        cart_id = 3;
        mockedCartBean.setCart_id(cart_id);

        // verify setId has been called successfully
        Mockito.verify(mockedCartBean).setCart_id(cart_id);
    }

    @When("^getUser_id\\(\\) for cart bean is called$")
    public void getuser_id_for_cart_bean_is_called() throws Throwable {
        mockedCartBean.getUser_id();
        Mockito.verify(mockedCartBean).getUser_id();
    }

    @Then("^a cart bean user id is returned$")
    public void a_cart_bean_user_id_is_returned() throws Throwable {
        long actualUser_id = cartBean.getUser_id();

        Assert.assertEquals(actualUser_id, user_id);
    }

    @When("^setUser_id\\(\\) for cart bean is called$")
    public void setuser_id_for_cart_bean_is_called() throws Throwable {
        cartBean.setUser_id(user_id);
        mockedCartBean.setUser_id(user_id);
        Mockito.verify(mockedCartBean).setUser_id(user_id);
    }

    @Then("^setUser_id\\(\\) for cart bean is successfully called$")
    public void setuser_id_for_cart_bean_is_successfully_called() throws Throwable {
        user_id = 3;
        mockedCartBean.setUser_id(user_id);

        // verify setId has been called successfully
        Mockito.verify(mockedCartBean).setUser_id(user_id);
    }

    @When("^getQuantity\\(\\) is called$")
    public void getquantity_is_called() throws Throwable {
        mockedCartBean.getQuantity();
        Mockito.verify(mockedCartBean).getQuantity();
    }

    @Then("^a quantity string is returned$")
    public void a_quantity_string_is_returned() throws Throwable {
        long actualQuantity = cartBean.getQuantity();

        Assert.assertEquals(actualQuantity, quantity);
    }

    @When("^setQuantity\\(\\) is called$")
    public void setquantity_is_called() throws Throwable {
        cartBean.setQuantity(quantity);
        mockedCartBean.setQuantity(quantity);
        Mockito.verify(mockedCartBean).setQuantity(quantity);
    }

    @Then("^setQuantity\\(\\) is successfully called$")
    public void setquantity_is_successfully_called() throws Throwable {
        quantity = 3;
        mockedCartBean.setQuantity(quantity);

        // verify setId has been called successfully
        Mockito.verify(mockedCartBean).setQuantity(quantity);
    }

    @When("^getPrice\\(\\) for cart bean is called$")
    public void getprice_for_cart_bean_is_called() throws Throwable {
        mockedCartBean.getPrice();
        Mockito.verify(mockedCartBean).getPrice();
    }

    @Then("^a price for cart bean is returned$")
    public void a_price_for_cart_bean_is_returned() throws Throwable {
        float actualPrice = cartBean.getPrice();

        Assert.assertEquals(actualPrice, price, 0.001);
    }

    @When("^setPrice\\(\\) for cart bean is called$")
    public void setprice_for_cart_bean_is_called() throws Throwable {
        cartBean.setPrice(price);
        mockedCartBean.setPrice(price);
        Mockito.verify(mockedCartBean).setPrice(price);
    }

    @Then("^setPrice\\(\\) for cart bean is successfully called$")
    public void setprice_for_cart_bean_is_successfully_called() throws Throwable {
        price = 3;
        mockedCartBean.setPrice(price);
        Mockito.verify(mockedCartBean).setPrice(price);
    }
}
