package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.CartBean;
import com.fundamental.proj.controller.bean.ItemsBean;
import com.fundamental.proj.mapper.CartBeanMapper;
import com.fundamental.proj.model.Cart;
import com.fundamental.proj.service.CartService;

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

public class CartDelegateSteps {

    @Mock
    private CartService mockedCartService;

    @Mock
    private CartBeanMapper mockedCartBeanMapper;

    @Mock
    private Cart mockedCart;

    @Mock
    private CartBean mockedCartBean;

    @Mock
    private List<Cart> mockedListCart;

    @InjectMocks
    private CartDelegate cartDelegate;

    private List<CartBean> expectedListCartBean;

    @Given("^mock CartDelegate is initialized$")
    public void mock_CartDelegate_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedCartService, mockedCartBeanMapper, mockedCart, mockedListCart, mockedCartBean);
    }

    /************************************************/
    /*
     * Test updateCart()
     */
    /***********************************************/
    @When("^updateCart\\(\\) is called for CartDelegate$")
    public void updatecart_is_called_CartDelegate() throws Throwable {
        Mockito.when(mockedCartBeanMapper.mapBeanToCart(Mockito.any(CartBean.class))).thenReturn(mockedCart);
        Mockito.doNothing().when(mockedCartService).updateCart(mockedCart);
    }

    @Then("^updateCart has been called successfully")
    public void updatecart_has_been_called_successfully() throws Throwable {
        CartBean cartBean = new CartBean();
        cartDelegate.updateCart(cartBean);

        // verify updateCart has been called successfully
        Mockito.verify(mockedCartBeanMapper).mapBeanToCart(cartBean);
        Mockito.verify(mockedCartService).updateCart(mockedCart);
    }

    /************************************************/
    /*
     * Test getCart()
     */
    /***********************************************/
    @When("^getCart\\(\\) is called for CartDelegate$")
    public void getcart_is_called_CartDelegate() throws Throwable {
        Mockito.when(mockedCartService.getCart(Mockito.anyLong())).thenReturn(mockedListCart);
        Mockito.when(mockedCartBeanMapper.mapItemsBean(mockedListCart)).thenReturn(expectedListCartBean);
    }

    @And("^expected list of cartbeans is initialized$")
    public void expected_list_of_cartbeans_is_initialized() throws Throwable {
        CartBean cart1 = new CartBean();
        ItemsBean itemsBean = new ItemsBean();
        cart1.setItemsBean(itemsBean);
        cart1.setCart_id(1L);
        cart1.setUser_id(1L);
        cart1.setQuantity(3);
        cart1.setPrice(1F);

        expectedListCartBean = new ArrayList<CartBean>();
        expectedListCartBean.add(cart1);
    }

    @Then("^a list of cartbeans is returned for CartDelegate")
    public void a_list_of_cartbeans_is_returned_for_cartDelegate() throws Throwable {
        Long userid = 1L;
        List<CartBean> actualListCartBean = cartDelegate.getCart(userid);

        Assert.assertEquals(actualListCartBean.size(), expectedListCartBean.size());
        for (int x=0; x<expectedListCartBean.size(); x++) {
            Assert.assertEquals(actualListCartBean.get(x).getUser_id(), expectedListCartBean.get(x).getUser_id());
            Assert.assertEquals(actualListCartBean.get(x).getCart_id(), expectedListCartBean.get(x).getCart_id());
            Assert.assertEquals(actualListCartBean.get(x).getItemsBean(), expectedListCartBean.get(x).getItemsBean());
            Assert.assertEquals(actualListCartBean.get(x).getPrice(), expectedListCartBean.get(x).getPrice(), 1e-15);
            Assert.assertEquals(actualListCartBean.get(x).getQuantity(), expectedListCartBean.get(x).getQuantity());
        }

        // verify getCart has been called successfully
        Mockito.verify(mockedCartService).getCart(userid);
        Mockito.verify(mockedCartBeanMapper).mapItemsBean(mockedListCart);
    }

    @And("^expected null list of cartbeans is initialized$")
    public void expected_null_list_of_cartbeans_is_initialized() throws Throwable {
        expectedListCartBean = null;
    }

    @Then("^a list of cartbeans is null for CartDelegate$")
    public void a_list_of_cartbeans_is_null_for_CartDelegate() throws Throwable {
        Long userid = 1L;
        List<CartBean> actualListCart = cartDelegate.getCart(userid);

        Assert.assertNull(actualListCart);

        // verify getCart has been called successfully
        Mockito.verify(mockedCartService).getCart(userid);
        Mockito.verify(mockedCartBeanMapper).mapItemsBean(mockedListCart);
    }

    @And("^expected empty list of cartbeans is initialized$")
    public void expected_empty_list_of_cartbeans_is_initialized() throws Throwable {
        expectedListCartBean = new ArrayList<CartBean>();
    }

    @Then("^a list of cartbeans is empty for CartDelegate$")
    public void a_list_of_cartbeans_is_empty_for_cartDelegate() throws Throwable {
        Long userid = 1L;
        List<CartBean> actualListCart = cartDelegate.getCart(userid);

        Assert.assertEquals(actualListCart.size(), expectedListCartBean.size());

        // verify getCart has been called successfully
        Mockito.verify(mockedCartService).getCart(userid);
        Mockito.verify(mockedCartBeanMapper).mapItemsBean(mockedListCart);
    }

    /************************************************/
    /*
     * Test AddToCart()
     */
    /***********************************************/

    @When("^AddToCart\\(\\) is called for CartDelegate$")
    public void addtocart_is_called_for_CartDelegate() throws Throwable {
        Mockito.when(mockedCartBeanMapper.mapBeanToCart(Mockito.any(CartBean.class))).thenReturn(mockedCart);
        Mockito.doNothing().when(mockedCartService).AddToCart(Mockito.eq(mockedCart), Mockito.anyInt());
    }

    @Then("^AddToCart has been called successfully$")
    public void addtocart_has_been_called_successfully() throws Throwable {
        CartBean cartBean = new CartBean();
        int flag = 0;
        cartDelegate.AddToCart(cartBean, flag);
        Mockito.verify(mockedCartBeanMapper).mapBeanToCart(cartBean);
        Mockito.verify(mockedCartService).AddToCart(mockedCart, flag);
    }
}
