package com.fundamental.proj.model;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

/**
 * Created by Madeline on 3/23/16.
 */
public class ItemsSteps {
    private Items items;

    @Given("^items is set up$")
    public void items_is_set_up() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        items = new Items();
    }

    @When("^items user_id (\\d+) is set$")
    public void items_user_id_is_set(int arg1) throws Throwable {
        items.setUser_id(arg1);
    }

    @Then("^items getUser_id returns (\\d+)$")
    public void items_getUser_id_returns(int arg1) throws Throwable {
        Assert.assertEquals(items.getUser_id(), arg1);
    }

    @When("^items item_id (\\d+) is set$")
    public void items_item_id_is_set(int arg1) throws Throwable {
        items.setItem_id(arg1);
    }

    @Then("^items getItem_id returns (\\d+)$")
    public void items_getItem_id_returns(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(items.getItem_id(), arg1);
    }

    @When("^items item_name \"([^\"]*)\" is set$")
    public void items_item_name_is_set(String arg1) throws Throwable {
        items.setItem_name(arg1);
    }

    @Then("^items get_item_name returns \"([^\"]*)\"$")
    public void items_get_item_name_returns(String arg1) throws Throwable {
        Assert.assertEquals(items.getItem_name(), arg1);

    }

    @When("^item_description \"([^\"]*)\" is set$")
    public void item_description_is_set(String arg1) throws Throwable {
        items.setItem_description(arg1);
    }

    @Then("^getItem_description returns \"([^\"]*)\"$")
    public void getitem_description_returns(String arg1) throws Throwable {
        Assert.assertEquals(items.getItem_description(), arg1);

    }

    @When("^onsale_count (\\d+) is set$")
    public void onsale_count_is_set(int arg1) throws Throwable {
        items.setOnsale_count(arg1);
    }

    @Then("^getOnsale_count returns (\\d+)$")
    public void getonsale_count_returns(int arg1) throws Throwable {
        Assert.assertEquals(items.getOnsale_count(), arg1);

    }

    @When("^sold_count (\\d+) is set$")
    public void sold_count_is_set(int arg1) throws Throwable {
        items.setSold_count(arg1);
    }

    @Then("^sold_count returns (\\d+)$")
    public void sold_count_returns(int arg1) throws Throwable {
        Assert.assertEquals(items.getSold_count(), arg1);

    }

    @When("^category \"([^\"]*)\" is set$")
    public void category_is_set(String arg1) throws Throwable {
        items.setCategory(arg1);
    }

    @Then("^getCategory returns \"([^\"]*)\"$")
    public void getcategory_returns(String arg1) throws Throwable {
        Assert.assertEquals(items.getCategory(), arg1);
    }

    @When("^images  \"([^\"]*)\" is set$")
    public void images_is_set(String arg1) throws Throwable {
        items.setImages(arg1);
    }

    @Then("^getImages returns \"([^\"]*)\"$")
    public void getimages_returns(String arg1) throws Throwable {
        Assert.assertEquals(items.getImages(), arg1);
    }

    @When("^items price  (\\d+) is set$")
    public void items_price_is_set(int arg1) throws Throwable {
        items.setPrice(arg1);
    }

    @Then("^items getPrice returns (\\d+)$")
    public void items_getPrice_returns(int arg1) throws Throwable {
        Assert.assertEquals(items.getPrice(), arg1, 1E-15);
    }

    @When("^date  now is set$")
    public void date_now_is_set() throws Throwable {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        Date dateOne = df.parse("2011-02-08 10:00:00 +0200");
        items.setDate(dateOne);
    }

    @Then("^getDate returns current date$")
    public void getdate_returns_current_date() throws Throwable {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        Date dateOne = df.parse("2011-02-08 10:00:00 +0200");
        Assert.assertEquals(items.getDate(), dateOne);
    }
}
