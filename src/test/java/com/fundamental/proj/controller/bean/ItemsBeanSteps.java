package com.fundamental.proj.controller.bean;

import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Date;
/**
 * Created by Madeline on 3/20/16.
 */
public class ItemsBeanSteps {
    @Mock
    private ItemsBean mockedItemsBean;

    @InjectMocks
    private ItemsBean itemsBean;
    private Date date;
    private long user_id;
    private long item_id;
    private String item_name;
    private String item_description;
    private int onsale_count;
    private int sold_count;
    private String category;
    private String images;
    private long price;

    @Given("^mock ItemsBean is initialized$")
    public void mock_ItemsBean_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedItemsBean);
    }

    @When("^getDate\\(\\) is called$")
    public void getdate_is_called() throws Throwable {
        mockedItemsBean.getDate();
        Mockito.verify(mockedItemsBean).getDate();
    }

    @When("^setDate\\(\\) is called$")
    public void setdate_is_called() throws Throwable {
        itemsBean.setDate(date);
        mockedItemsBean.setDate(date);
        Mockito.verify(mockedItemsBean).setDate(date);
    }

    @Then("^setDate\\(\\) is successfully called$")
    public void setdate_is_successfully_called() throws Throwable {
        date = new Date();
        mockedItemsBean.setDate(date);

        Mockito.verify(mockedItemsBean).setDate(date);
    }

    @When("^getItem_Id\\(\\) is called$")
    public void getitem_id_is_called() throws Throwable {
        mockedItemsBean.getItem_id();
        Mockito.verify(mockedItemsBean).getItem_id();
    }

    @When("^setItem_Id\\(\\) is called$")
    public void setitem_id_is_called() throws Throwable {
        itemsBean.setItem_id(item_id);
        mockedItemsBean.setItem_id(item_id);
        Mockito.verify(mockedItemsBean).setItem_id(item_id);
    }

    @Then("^setItem_Id\\(\\) is successfully called$")
    public void setitem_id_is_successfully_called() throws Throwable {
        item_id = 3;
        mockedItemsBean.setItem_id(item_id);

        Mockito.verify(mockedItemsBean).setItem_id(item_id);
    }

    @When("^getItem_name\\(\\) is called$")
    public void getitem_name_is_called() throws Throwable {
        mockedItemsBean.getItem_name();
        Mockito.verify(mockedItemsBean).getItem_name();
    }

    @When("^setItem_name\\(\\) is called$")
    public void setitem_name_is_called() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        itemsBean.setItem_name(item_name);
        mockedItemsBean.setItem_name(item_name);
        Mockito.verify(mockedItemsBean).setItem_name(item_name);
    }

    @Then("^setItem_namel\\(\\) is successfully called$")
    public void setitem_namel_is_successfully_called() throws Throwable {
        item_name = "ItemName";
        mockedItemsBean.setItem_name(item_name);

        Mockito.verify(mockedItemsBean).setItem_name(item_name);
    }

    @When("^getItem_description\\(\\) is called$")
    public void getitem_description_is_called() throws Throwable {
        mockedItemsBean.getItem_description();
        Mockito.verify(mockedItemsBean).getItem_description();
    }

    @Then("^a description string is returned$")
    public void a_description_string_is_returned() throws Throwable {
        String actualDescription = itemsBean.getItem_description();

        Assert.assertEquals(actualDescription, item_description);
    }

    @When("^setItem_description\\(\\) is called$")
    public void setitem_description_is_called() throws Throwable {
        itemsBean.setItem_description(item_description);
        mockedItemsBean.setItem_description(item_description);
        Mockito.verify(mockedItemsBean).setItem_description(item_description);
    }

    @Then("^setItem_description\\(\\) is successfully called$")
    public void setitem_description_is_successfully_called() throws Throwable {
        item_description = "ItemDescription";
        mockedItemsBean.setItem_description(item_description);

        Mockito.verify(mockedItemsBean).setItem_description(item_description);
    }

    @When("^getOnsale_count\\(\\) is called$")
    public void getonsale_count_is_called() throws Throwable {
        mockedItemsBean.getOnsale_count();
        Mockito.verify(mockedItemsBean).getOnsale_count();
    }

    @Then("^an on sale count is returned$")
    public void an_on_sale_count_is_returned() throws Throwable {
        int actualOnSaleCount = itemsBean.getOnsale_count();

        Assert.assertEquals(actualOnSaleCount, onsale_count);
    }

    @When("^setOnsale_count\\(\\) is called$")
    public void setonsale_count_is_called() throws Throwable {
        itemsBean.setOnsale_count(onsale_count);
        mockedItemsBean.setOnsale_count(onsale_count);
        Mockito.verify(mockedItemsBean).setOnsale_count(onsale_count);
    }

    @Then("^setOnsale_count\\(\\) is successfully called$")
    public void setonsale_count_is_successfully_called() throws Throwable {
        onsale_count = 10;
        mockedItemsBean.setOnsale_count(onsale_count);

        Mockito.verify(mockedItemsBean).setOnsale_count(onsale_count);
    }

    @When("^getSold_count\\(\\) is called$")
    public void getsold_count_is_called() throws Throwable {
        mockedItemsBean.getSold_count();
        Mockito.verify(mockedItemsBean).getSold_count();
    }

    @Then("^a sold count is returned$")
    public void a_sold_count_is_returned() throws Throwable {
        int actualSoldCount = itemsBean.getSold_count();

        Assert.assertEquals(actualSoldCount, sold_count);
    }

    @When("^setSold_count\\(\\) is called$")
    public void setsold_count_is_called() throws Throwable {
        itemsBean.setSold_count(sold_count);
        mockedItemsBean.setSold_count(sold_count);
        Mockito.verify(mockedItemsBean).setSold_count(sold_count);
    }

    @Then("^setSold_count\\(\\) is successfully called$")
    public void setsold_count_is_successfully_called() throws Throwable {
        sold_count = 10;
        mockedItemsBean.setSold_count(sold_count);

        Mockito.verify(mockedItemsBean).setSold_count(sold_count);
    }

    @When("^getCategory is called$")
    public void getcategory_is_called() throws Throwable {
        mockedItemsBean.getCategory();
        Mockito.verify(mockedItemsBean).getCategory();
    }

    @Then("^a category string is returned$")
    public void a_category_string_is_returned() throws Throwable {
        String actualCategory = itemsBean.getCategory();

        Assert.assertEquals(actualCategory, category);
    }

    @When("^setCategory\\(\\) is called$")
    public void setcategory_is_called() throws Throwable {
        itemsBean.setCategory(category);
        mockedItemsBean.setCategory(category);
        Mockito.verify(mockedItemsBean).setCategory(category);
    }

    @Then("^setCategory\\(\\) is successfully called$")
    public void setcategory_is_successfully_called() throws Throwable {
        category = "ItemCategory";
        mockedItemsBean.setCategory(category);

        Mockito.verify(mockedItemsBean).setCategory(category);
    }

    @When("^getImages\\(\\) is called$")
    public void getimages_is_called() throws Throwable {
        mockedItemsBean.getImages();
        Mockito.verify(mockedItemsBean).getImages();
    }

    @Then("^an images list is returned$")
    public void an_images_list_is_returned() throws Throwable {
        String actualImages = itemsBean.getImages();

        Assert.assertEquals(actualImages, images);
    }

    @When("^setImages\\(\\) is called$")
    public void setimages_is_called() throws Throwable {
        itemsBean.setImages(images);
        mockedItemsBean.setImages(images);
        Mockito.verify(mockedItemsBean).setImages(images);
    }

    @Then("^setImages\\(\\) is successfully called$")
    public void setimages_is_successfully_called() throws Throwable {
        images = "Images";
        mockedItemsBean.setImages(images);

        Mockito.verify(mockedItemsBean).setImages(images);
    }

    @When("^getPrice\\(\\) is called$")
    public void getprice_is_called() throws Throwable {
        mockedItemsBean.getPrice();
        Mockito.verify(mockedItemsBean).getPrice();
    }

    @Then("^a price is returned$")
    public void a_price_is_returned() throws Throwable {
        double actualPrice = itemsBean.getPrice();

        Assert.assertEquals(actualPrice, price, 1E-15);
    }

    @When("^setPrice\\(\\) is called$")
    public void setprice_is_called() throws Throwable {
        itemsBean.setPrice(price);
        mockedItemsBean.setPrice(price);
        Mockito.verify(mockedItemsBean).setPrice(price);
    }

    @Then("^setPrice\\(\\) is successfully called$")
    public void setprice_is_successfully_called() throws Throwable {
        price = 100;
        mockedItemsBean.setPrice(price);

        Mockito.verify(mockedItemsBean).setPrice(price);
    }

    @When("^getUser_id\\(\\) is called$")
    public void getuser_id_is_called() throws Throwable {
        mockedItemsBean.getUser_id();
        Mockito.verify(mockedItemsBean).getUser_id();
    }

    @Then("^a user id is returned$")
    public void a_user_id_is_returned() throws Throwable {
        long actualUserId = itemsBean.getUser_id();

        Assert.assertEquals(actualUserId, user_id);
    }

    @When("^setUser_id\\(\\) is called$")
    public void setuser_id_is_called() throws Throwable {
        itemsBean.setUser_id(user_id);
        mockedItemsBean.setUser_id(user_id);
        Mockito.verify(mockedItemsBean).setUser_id(user_id);
    }

    @Then("^setUser_id\\(\\) is successfully called$")
    public void setuser_id_is_successfully_called() throws Throwable {
        user_id = 3;
        mockedItemsBean.setUser_id(user_id);

        Mockito.verify(mockedItemsBean).setUser_id(user_id);
    }

    @Then("^an item date is returned$")
    public void an_item_date_is_returned() throws Throwable {
        Date actualDate = itemsBean.getDate();

        Assert.assertEquals(actualDate, date);
    }

    @Then("^an item id is returned$")
    public void an_item_id_is_returned() throws Throwable {
        long actualItemId = itemsBean.getItem_id();

        Assert.assertEquals(actualItemId, item_id);
    }

    @Then("^an item name string is returned$")
    public void an_item_name_string_is_returned() throws Throwable {
        String actualItemName  = itemsBean.getItem_name();

        Assert.assertEquals(actualItemName, item_name);
    }
}
