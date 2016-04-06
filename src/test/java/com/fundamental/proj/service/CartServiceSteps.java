package com.fundamental.proj.service;

import com.fundamental.proj.model.Cart;
import com.fundamental.proj.model.Items;
import com.fundamental.proj.repository.CartRepository;
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

public class CartServiceSteps {

    @Mock
    private CartRepository mockedCartRepository;

    @InjectMocks
    private CartService cartService;

    private List<Cart> expectedListCart;

    @Given("^mock CartService is initialized$")
    public void mock_cartservice_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedCartRepository);
    }

    /************************************************/
    /*
     * Test updateCart()
     */
    /***********************************************/
    @When("^updateCart\\(\\) is called$")
    public void updatecart_is_called() throws Throwable {
        Mockito.doNothing().when(mockedCartRepository).updateCart(Mockito.any(Cart.class));
    }

    @Then("^updateCart has been called successfully called$")
    public void updatecart_has_been_called_successfully_called() throws Throwable {
        Cart cart = new Cart();
        cartService.updateCart(cart);

        // verify updateCart has been called successfully
        Mockito.verify(mockedCartRepository).updateCart(cart);
    }

    /************************************************/
    /*
     * Test getCart()
     */
    /***********************************************/
    @When("^getCart\\(\\) is called$")
    public void getcart_is_called() throws Throwable {
        Mockito.when(mockedCartRepository.getCart(Mockito.any(Long.class))).thenReturn(expectedListCart);
    }

    @And("^expected list of carts is initialized$")
    public void expected_list_of_carts_is_initialized() throws Throwable {
        Cart cart1 = new Cart();
        cart1.setUser_id(1L);
        cart1.setCart_id(1L);
        cart1.setItems(new Items());
        cart1.setPrice(1);
        cart1.setQuantity(1);

        Cart cart2 = new Cart();
        cart2.setUser_id(1L);
        cart2.setCart_id(2L);
        cart2.setItems(new Items());
        cart2.setPrice(2);
        cart2.setQuantity(2);

        Cart cart3 = new Cart();
        cart3.setUser_id(1L);
        cart3.setCart_id(3L);
        cart3.setItems(new Items());
        cart3.setPrice(3);
        cart3.setQuantity(3);

        expectedListCart = new ArrayList<Cart>();
        expectedListCart.add(cart1);
        expectedListCart.add(cart2);
        expectedListCart.add(cart3);
    }

    @Then("^a list of carts is returned for getCart$")
    public void a_list_of_carts_is_returned_for_getCart() throws Throwable {
        List<Cart> actualListCart = cartService.getCart(1L);

        Assert.assertEquals(actualListCart.size(), expectedListCart.size());
        for (int x=0; x<expectedListCart.size(); x++) {
            Assert.assertEquals(actualListCart.get(x).getUser_id(), expectedListCart.get(x).getUser_id());
            Assert.assertEquals(actualListCart.get(x).getCart_id(), expectedListCart.get(x).getCart_id());
            Assert.assertEquals(actualListCart.get(x).getItems(), expectedListCart.get(x).getItems());
            Assert.assertEquals(actualListCart.get(x).getPrice(), expectedListCart.get(x).getPrice(), 1e-15);
            Assert.assertEquals(actualListCart.get(x).getQuantity(), expectedListCart.get(x).getQuantity());
        }

        // verify getCart has been called successfully
        Mockito.verify(mockedCartRepository).getCart(1L);
    }

    @And("^expected null list of carts is initialized$")
    public void expected_null_list_of_carts_is_initialized() throws Throwable {
        expectedListCart = null;
    }

    @Then("^a list of carts is null for getCart$")
    public void a_list_of_carts_is_null_for_getCart() throws Throwable {
        List<Cart> actualListCart = cartService.getCart(1L);

        Assert.assertNull(actualListCart);

        // verify getCart has been called successfully
        Mockito.verify(mockedCartRepository).getCart(1L);
    }

    @And("^expected empty list of carts is initialized$")
    public void expected_empty_list_of_carts_is_initialized() throws Throwable {
        expectedListCart = new ArrayList<Cart>();
    }

    @Then("^a list of carts is empty for getCart$")
    public void a_list_of_carts_is_empty_for_getCart() throws Throwable {
        List<Cart> actualListCart = cartService.getCart(1L);

        Assert.assertEquals(actualListCart.size(), expectedListCart.size());

        // verify getCart has been called successfully
        Mockito.verify(mockedCartRepository).getCart(1L);
    }

    /************************************************/
    /*
     * Test AddToCart()
     */
    /***********************************************/
    @When("^AddToCart\\(\\) is called$")
    public void addtocart_is_called() throws Throwable {
        Mockito.doNothing().when(mockedCartRepository).AddToCart(Mockito.any(Cart.class), Mockito.anyInt());
    }

    @Then("^AddToCart has been called successfully called$")
    public void addtocart_has_been_called_successfully_called() throws Throwable {
        Cart cart = new Cart();
        cartService.AddToCart(cart, 1);

        // verify updateCart has been called successfully
        Mockito.verify(mockedCartRepository).AddToCart(cart, 1);
    }

}
