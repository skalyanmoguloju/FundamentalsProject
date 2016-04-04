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
public class SalesBeanSteps {
    @Mock
    private SalesBean mockedSalesBean;

    @InjectMocks
    private SalesBean salesBean;
    private long sale_id;
    private long item_id;
    private long user_id;
    private float price;
    private long quantity;
    private String card_number;
    private String exp_date;
    private String card_cvv;


    @Given("^mock SalesBean is initialized$")
    public void mock_SalesBean_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedSalesBean);
    }

    @When("^getSale_id\\(\\) is called$")
    public void getsale_id_is_called() throws Throwable {
        mockedSalesBean.getSale_id();
        Mockito.verify(mockedSalesBean).getSale_id();
    }

    @Then("^a sale id is returned$")
    public void a_sale_id_is_returned() throws Throwable {
        long actualSaleId = salesBean.getSale_id();

        Assert.assertEquals(actualSaleId, sale_id);
    }

    @When("^setSale_id\\(\\) is called$")
    public void setsale_id_is_called() throws Throwable {
        salesBean.setSale_id(sale_id);
        mockedSalesBean.setSale_id(sale_id);
        Mockito.verify(mockedSalesBean).setSale_id(sale_id);
    }

    @Then("^setSale_id\\(\\) is successfully called$")
    public void setsale_id_is_successfully_called() throws Throwable {
        sale_id = 3;
        mockedSalesBean.setSale_id(3);

        // verify setId has been called successfully
        Mockito.verify(mockedSalesBean).setSale_id(3);
    }

    @When("^getItem_id\\(\\) is called$")
    public void getitem_id_is_called() throws Throwable {
        mockedSalesBean.getItem_id();
        Mockito.verify(mockedSalesBean).getItem_id();
    }

    @Then("^an item_id is returned$")
    public void an_item_id_is_returned() throws Throwable {
        long actualItemId = salesBean.getItem_id();

        Assert.assertEquals(actualItemId, item_id);
    }

    @When("^setItem_id\\(\\) is called$")
    public void setitem_id_is_called() throws Throwable {
        salesBean.setItem_id(item_id);
        mockedSalesBean.setItem_id(item_id);
        Mockito.verify(mockedSalesBean).setItem_id(item_id);
    }

    @Then("^setItem_id\\(\\) is successfully called$")
    public void setitem_id_is_successfully_called() throws Throwable {
        item_id = 3;
        mockedSalesBean.setItem_id(item_id);

        // verify setId has been called successfully
        Mockito.verify(mockedSalesBean).setItem_id(item_id);
    }

    @When("^a sales bean getUser_id\\(\\) is called$")
    public void a_sales_bean_getUser_id_is_called() throws Throwable {
        mockedSalesBean.getUser_id();
        Mockito.verify(mockedSalesBean).getUser_id();
    }

    @Then("^a sales bean user id is returned$")
    public void a_sales_bean_user_id_is_returned() throws Throwable {
        long actualUserId = salesBean.getUser_id();

        Assert.assertEquals(actualUserId, user_id);
    }

    @When("^setUser_id\\(\\) for sales bean is called$")
    public void setuser_id_for_sales_bean_is_called() throws Throwable {
        salesBean.setUser_id(user_id);
        mockedSalesBean.setUser_id(user_id);
        Mockito.verify(mockedSalesBean).setUser_id(user_id);
    }

    @Then("^setUser_id\\(\\) for sales bean is successfully called$")
    public void setuser_id_for_sales_bean_is_successfully_called() throws Throwable {
        user_id = 3;
        mockedSalesBean.setUser_id(user_id);

        // verify setId has been called successfully
        Mockito.verify(mockedSalesBean).setUser_id(user_id);
    }

    @When("^getPrice\\(\\) for sales bean is called$")
    public void getprice_for_sales_bean_is_called() throws Throwable {
        mockedSalesBean.getPrice();
        Mockito.verify(mockedSalesBean).getPrice();
    }

    @Then("^a price string for sales bean is returned$")
    public void a_price_string_for_sales_bean_is_returned() throws Throwable {
        float actualPrice = salesBean.getPrice();

        Assert.assertEquals(actualPrice, price, 0.0001);
    }

    @When("^setPrice\\(\\) for sale bean is called$")
    public void setprice_for_sale_bean_is_called() throws Throwable {
        salesBean.setPrice(price);
        mockedSalesBean.setPrice(price);
        Mockito.verify(mockedSalesBean).setPrice(price);
    }

    @Then("^setPrice\\(\\) for sale bean is successfully called$")
    public void setprice_for_sale_bean_is_successfully_called() throws Throwable {
        price = 3;
        mockedSalesBean.setPrice(price);

        // verify setId has been called successfully
        Mockito.verify(mockedSalesBean).setPrice(price);
    }

    @When("^getQuantity\\(\\) for sales bean is called$")
    public void getquantity_for_sales_bean_is_called() throws Throwable {
        mockedSalesBean.getQuantity();
        Mockito.verify(mockedSalesBean).getQuantity();
    }

    @Then("^a quantity string for sales bean is returned$")
    public void a_quantity_string_for_sales_bean_is_returned() throws Throwable {
        long actualQuantity = salesBean.getQuantity();

        Assert.assertEquals(actualQuantity, quantity);
    }

    @When("^setQuantity\\(\\) for sales bean is called$")
    public void setquantity_for_sales_bean_is_called() throws Throwable {
        salesBean.setQuantity(quantity);
        mockedSalesBean.setQuantity(quantity);
        Mockito.verify(mockedSalesBean).setQuantity(quantity);
    }

    @Then("^setQuantity\\(\\) for sales bean is successfully called$")
    public void setquantity_for_sales_bean_is_successfully_called() throws Throwable {
        quantity = 3;
        mockedSalesBean.setQuantity(quantity);

        // verify setId has been called successfully
        Mockito.verify(mockedSalesBean).setQuantity(quantity);
    }

    @When("^getCard_number\\(\\) is called$")
    public void getcard_number_is_called() throws Throwable {
        mockedSalesBean.getCard_number();
        Mockito.verify(mockedSalesBean).getCard_number();
    }

    @Then("^a card number string is returned$")
    public void a_card_number_string_is_returned() throws Throwable {
        String actualCardNumber = salesBean.getCard_number();

        Assert.assertEquals(actualCardNumber, card_number);
    }

    @When("^setCard_number\\(\\) is called$")
    public void setcard_number_is_called() throws Throwable {
        salesBean.setCard_number(card_number);
        mockedSalesBean.setCard_number(card_number);
        Mockito.verify(mockedSalesBean).setCard_number(card_number);
    }

    @Then("^setCard_number\\(\\) is successfully called$")
    public void setcard_number_is_successfully_called() throws Throwable {
        card_number = "00000000000";
        mockedSalesBean.setCard_number(card_number);

        // verify setId has been called successfully
        Mockito.verify(mockedSalesBean).setCard_number(card_number);
    }

    @When("^getExp_date is called$")
    public void getexp_date_is_called() throws Throwable {
        mockedSalesBean.getExp_date();
        Mockito.verify(mockedSalesBean).getExp_date();
    }

    @Then("^an exp date string is returned$")
    public void an_exp_date_string_is_returned() throws Throwable {
        String actualExpDate = salesBean.getExp_date();

        Assert.assertEquals(actualExpDate, exp_date);
    }

    @When("^setExp_date\\(\\) is called$")
    public void setexp_date_is_called() throws Throwable {
        salesBean.setExp_date(exp_date);
        mockedSalesBean.setExp_date(exp_date);
        Mockito.verify(mockedSalesBean).setExp_date(exp_date);
    }

    @Then("^setExp_date\\(\\) is successfully called$")
    public void setexp_date_is_successfully_called() throws Throwable {
        exp_date = "09/04/1994";
        mockedSalesBean.setExp_date(exp_date);

        // verify setId has been called successfully
        Mockito.verify(mockedSalesBean).setExp_date(exp_date);
    }

    @When("^getCard_cvv\\(\\) is called$")
    public void getcard_cvv_is_called() throws Throwable {
        mockedSalesBean.getCard_cvv();
        Mockito.verify(mockedSalesBean).getCard_cvv();
    }

    @Then("^a card cvv is returned$")
    public void a_card_cvv_is_returned() throws Throwable {
        String actualCard_cvv = salesBean.getCard_cvv();

        Assert.assertEquals(actualCard_cvv, card_cvv);
    }

    @When("^setCard_cvv\\(\\) is called$")
    public void setcard_cvv_is_called() throws Throwable {
        salesBean.setCard_cvv(card_cvv);
        mockedSalesBean.setCard_cvv(card_cvv);
        Mockito.verify(mockedSalesBean).setCard_cvv(card_cvv);
    }

    @Then("^setCard_cvv\\(\\) is successfully called$")
    public void setcard_cvv_is_successfully_called() throws Throwable {
        card_cvv = "card_cvv";
        mockedSalesBean.setCard_cvv(card_cvv);

        // verify setId has been called successfully
        Mockito.verify(mockedSalesBean).setCard_cvv(card_cvv);
    }
}
