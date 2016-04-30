package com.fundamental.proj.service;

import com.fundamental.proj.model.Items;
import com.fundamental.proj.repository.ItemsRepository;
import com.sun.mail.imap.protocol.Item;
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
import java.util.Date;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class ItemsServiceSteps {

    @Mock
    private ItemsRepository mockedItemsRepository;

    @InjectMocks
    private ItemsService itemsService;

    private List<Items> expectedListItems;
    private List<Long> expectedListSoldCounts;
    private List<String> expectedListCatgs;

    @Given("^mock ItemsService is initialized$")
    public void mock_itemsservice_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedItemsRepository);
    }

    /************************************************/
    /*
     * Test getAllItems()
     */
    /***********************************************/
    @When("^getAllItems\\(\\) is called$")
    public void getallitems_is_called() throws Throwable {
        Mockito.when(mockedItemsRepository.getAllItems()).thenReturn(expectedListItems);
    }

    @And("^expected list of items is initialized$")
    public void expected_list_of_items_is_initialized() throws Throwable {
        Items items1 = new Items();
        items1.setCategory("A");
        items1.setDate(new Date());
        items1.setImages("img1");
        items1.setItem_id(1L);
        items1.setItem_name("item 1");
        items1.setItem_description("description 1");
        items1.setOnsale_count(1);
        items1.setSold_count(1);
        items1.setPrice(100L);
        items1.setUser_id(1L);

        Items items2 = new Items();
        items2.setCategory("B");
        items2.setDate(new Date());
        items2.setImages("img2");
        items2.setItem_id(2L);
        items2.setItem_name("item 2");
        items2.setItem_description("description 2");
        items2.setOnsale_count(2);
        items2.setSold_count(2);
        items2.setPrice(200L);
        items2.setUser_id(2L);

        expectedListItems = new ArrayList<Items>();
        expectedListItems.add(items1);
        expectedListItems.add(items2);
    }

    @Then("^a list of items is returned for getAllItems$")
    public void a_list_of_items_is_returned_for_getAllItems() throws Throwable {
        List<Items> actualListItems = itemsService.getAllItems();

        Assert.assertEquals(actualListItems.size(), expectedListItems.size());
        for (int x=0; x<expectedListItems.size(); x++) {
            Assert.assertEquals(actualListItems.get(x).getCategory(), expectedListItems.get(x).getCategory());
            Assert.assertEquals(actualListItems.get(x).getDate(), expectedListItems.get(x).getDate());
            Assert.assertEquals(actualListItems.get(x).getImages(), expectedListItems.get(x).getImages());
            Assert.assertEquals(actualListItems.get(x).getItem_id(), expectedListItems.get(x).getItem_id());
            Assert.assertEquals(actualListItems.get(x).getItem_name(), expectedListItems.get(x).getItem_name());
            Assert.assertEquals(actualListItems.get(x).getItem_description(), expectedListItems.get(x).getItem_description());
            Assert.assertEquals(actualListItems.get(x).getOnsale_count(), expectedListItems.get(x).getOnsale_count());
            Assert.assertEquals(actualListItems.get(x).getSold_count(), expectedListItems.get(x).getSold_count());
            Assert.assertEquals(actualListItems.get(x).getPrice(), expectedListItems.get(x).getPrice(), 1E-15);
            Assert.assertEquals(actualListItems.get(x).getUser_id(), expectedListItems.get(x).getUser_id());
        }

        // verify getAllItems method is called
        Mockito.verify(mockedItemsRepository).getAllItems();
    }

    @And("^expected null list of items is initialized$")
    public void expected_null_list_of_items_is_initialized() throws Throwable {
        expectedListItems = null;
    }

    @Then("^a list of items is null for getAllItems$")
    public void a_list_of_items_is_null_for_getAllItems() throws Throwable {
        List<Items> actualListItems = itemsService.getAllItems();

        Assert.assertNull(actualListItems);

        // verify getAllItems method is called
        Mockito.verify(mockedItemsRepository).getAllItems();
    }

    @And("^expected empty list of items is initialized$")
    public void expected_empty_list_of_items_is_initialized() throws Throwable {
        expectedListItems = new ArrayList<Items>();
    }

    @Then("^a list of items is empty for getAllItems$")
    public void a_list_of_items_is_empty_for_getAllItems() throws Throwable {
        List<Items> actualListItems = itemsService.getAllItems();

        Assert.assertEquals(actualListItems.size(), 0);

        // verify getAllItems method is called
        Mockito.verify(mockedItemsRepository).getAllItems();
    }

    /************************************************/
    /*
     * Test addItem()
     */
    /***********************************************/
    @When("^addItem\\(\\) is called$")
    public void additem_is_called() throws Throwable {
        Mockito.when(mockedItemsRepository.addItem(Mockito.any(Items.class))).thenReturn(new ArrayList<Long>());
    }

    @Then("^addItem has been called successfully called$")
    public void additem_has_been_called_successfully_called() throws Throwable {
        Items items = new Items();
        itemsService.addItem(items);

        // verify addItem method is called
        Mockito.verify(mockedItemsRepository).addItem(items);
    }

    /************************************************/
    /*
     * Test getAllItemsContainingSearchTerm()
     */
    /***********************************************/
    @When("^getAllItemsContainingSearchTerm\\(\\) is called$")
    public void getallitemscontainingsearchterm_is_called() throws Throwable {
        Mockito.when(mockedItemsRepository.getAllItemsContainingSearchTerm(Mockito.anyString(),Mockito.anyString())).thenReturn(expectedListItems);
    }

    @Then("^a list of items is returned for getAllItemsContainingSearchTerm in getAllItems$")
    public void a_list_of_items_is_returned_for_getAllItemsContainingSearchTerm_in_getAllItems() throws Throwable {
        List<Items> actualListItems = itemsService.getAllItemsContainingSearchTerm("some term","v");

        Assert.assertEquals(actualListItems.size(), expectedListItems.size());
        for (int x=0; x<expectedListItems.size(); x++) {
            Assert.assertEquals(actualListItems.get(x).getCategory(), expectedListItems.get(x).getCategory());
            Assert.assertEquals(actualListItems.get(x).getDate(), expectedListItems.get(x).getDate());
            Assert.assertEquals(actualListItems.get(x).getImages(), expectedListItems.get(x).getImages());
            Assert.assertEquals(actualListItems.get(x).getItem_id(), expectedListItems.get(x).getItem_id());
            Assert.assertEquals(actualListItems.get(x).getItem_name(), expectedListItems.get(x).getItem_name());
            Assert.assertEquals(actualListItems.get(x).getItem_description(), expectedListItems.get(x).getItem_description());
            Assert.assertEquals(actualListItems.get(x).getUser_id(), expectedListItems.get(x).getUser_id());
            Assert.assertEquals(actualListItems.get(x).getOnsale_count(), expectedListItems.get(x).getOnsale_count());
            Assert.assertEquals(actualListItems.get(x).getSold_count(), expectedListItems.get(x).getSold_count());
            Assert.assertEquals(actualListItems.get(x).getPrice(), expectedListItems.get(x).getPrice(), 1E-15);
        }

        Mockito.verify(mockedItemsRepository).getAllItemsContainingSearchTerm("some term","v");
    }

    /************************************************/
    /*
     * Test updateSoldCount()
     */
    /***********************************************/
    @Given("^expected list of sold_counts is initialized$")
    public void expected_list_of_sold_counts_is_initialized() throws Throwable {
        expectedListSoldCounts = new ArrayList<Long>();
        expectedListSoldCounts.add(3L);
    }

    @When("^updateSoldCount\\(\\) is called$")
    public void updatesoldcount_is_called() throws Throwable {
        Mockito.when(mockedItemsRepository.updateSoldCount(Mockito.any(Items.class))).thenReturn(expectedListSoldCounts);
    }

    @Then("^a list of sold_counts is returned for getAllItems$")
    public void a_list_of_sold_counts_is_returned_for_getAllItems() throws Throwable {
        Items items = new Items();
        List<Long> actualListSoldCounts = itemsService.updateSoldCount(items);

        Assert.assertEquals(actualListSoldCounts.size(), expectedListSoldCounts.size());
        Assert.assertEquals(actualListSoldCounts.get(0), expectedListSoldCounts.get(0));
        Mockito.verify(mockedItemsRepository).updateSoldCount(items);
    }

    @When("^getAllCatItemsContainingSearchTerm\\(\\) is called$")
    public void getallcatitemscontainingsearchterm_is_called() throws Throwable {
        Mockito.when(mockedItemsRepository.getAllCatItemsContainingSearchTerm(Mockito.anyString())).thenReturn(expectedListItems);
    }

    @Then("^a list of items is returned for getAllCatItemsContainingSearchTerm$")
    public void a_list_of_items_is_returned_for_getAllCatItemsContainingSearchTerm() throws Throwable {
        List<Items> actualListItems = itemsService.getAllCatItemsContainingSearchTerm("some term");

        Assert.assertEquals(actualListItems.size(), expectedListItems.size());
        for (int x=0; x<expectedListItems.size(); x++) {
            Assert.assertEquals(actualListItems.get(x).getCategory(), expectedListItems.get(x).getCategory());
            Assert.assertEquals(actualListItems.get(x).getDate(), expectedListItems.get(x).getDate());
            Assert.assertEquals(actualListItems.get(x).getImages(), expectedListItems.get(x).getImages());
            Assert.assertEquals(actualListItems.get(x).getItem_id(), expectedListItems.get(x).getItem_id());
            Assert.assertEquals(actualListItems.get(x).getItem_name(), expectedListItems.get(x).getItem_name());
            Assert.assertEquals(actualListItems.get(x).getItem_description(), expectedListItems.get(x).getItem_description());
            Assert.assertEquals(actualListItems.get(x).getUser_id(), expectedListItems.get(x).getUser_id());
            Assert.assertEquals(actualListItems.get(x).getOnsale_count(), expectedListItems.get(x).getOnsale_count());
            Assert.assertEquals(actualListItems.get(x).getPrice(), expectedListItems.get(x).getPrice(), 1E-15);
            Assert.assertEquals(actualListItems.get(x).getSold_count(), expectedListItems.get(x).getSold_count());
        }

        Mockito.verify(mockedItemsRepository).getAllCatItemsContainingSearchTerm("some term");
    }

    @Given("^expected list of catgs is initialized for getAllCatgs in ItemsService$")
    public void expected_list_of_catgs_is_initialized_for_getAllCatgs_in_ItemsService() throws Throwable {
        expectedListCatgs = new ArrayList<String>();
        expectedListCatgs.add("cat1");
    }

    @When("^getAllCatgs\\(\\) is called$")
    public void getallcatgs_is_called() throws Throwable {
       Mockito.when(mockedItemsRepository.getAllCatgs()).thenReturn(expectedListCatgs);
    }

    @Then("^a list of catgs is returned for getAllCatgs in ItemsService$")
    public void a_list_of_catgs_is_returned_for_getAllCatgs_in_ItemsService() throws Throwable {
        List<String> result = itemsService.getAllCatgs();
        Assert.assertEquals(result.size(), expectedListCatgs.size());
        Assert.assertEquals(result.get(0), expectedListCatgs.get(0));
    }

}
