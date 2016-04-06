package com.fundamental.proj.repository;

import com.fundamental.proj.model.Items;

import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.junit.Assert;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.BDDMockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class ItemsRepositorySteps {

    @Mock
    private SessionFactory mockedSessionFactory;

    @Mock
    private Session mockedSession;

    @Mock
    private Query mockedQuery;

    @InjectMocks
    private ItemsRepository itemsRepository;

    private List<Items> expectedListItems;
    private List<Long> expectedListIDs;
    private List<Long> expectedListsoldcount;

    @Given("^mock ItemsRepository is initialized$")
    public void mock_itemsrespository_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedSessionFactory, mockedSession, mockedQuery);
    }

    /************************************************/
    /*
     * Test getAllItems()
     */
    /***********************************************/
    @When("^getAllItems\\(\\) is called$")
    public void getallitems_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("from Items")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListItems);
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
        items2.setSold_count(3);
        items2.setPrice(200L);
        items2.setUser_id(2L);

        expectedListItems = new ArrayList<Items>();
        expectedListItems.add(items1);
        expectedListItems.add(items2);
    }

    @Then("^a list of items is returned for getAllItems$")
    public void a_list_of_items_is_returned_for_getAllItems() throws Throwable {
        List<Items> actualListItems = itemsRepository.getAllItems();

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
            Assert.assertEquals(actualListItems.get(x).getUser_id(), expectedListItems.get(x).getUser_id());
            Assert.assertEquals(actualListItems.get(x).getPrice(), expectedListItems.get(x).getPrice(), 1E-15);
        }

        // verify getAllItems has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("from Items");
        Mockito.verify(mockedQuery).list();
    }

    @And("^expected null list of items is initialized$")
    public void expected_null_list_of_items_is_initialized() throws Throwable {
        expectedListItems = null;
    }

    @Then("^a list of items is null for getAllItems$")
    public void a_list_of_items_is_null_for_getAllItems() throws Throwable {
        List<Items> actualListItems = itemsRepository.getAllItems();

        Assert.assertNull(actualListItems);

        // verify getAllItems has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("from Items");
        Mockito.verify(mockedQuery).list();

    }

    @And("^expected empty list of items is initialized$")
    public void expected_empty_list_of_items_is_initialized() throws Throwable {
        expectedListItems = new ArrayList<Items>();
    }

    @Then("^a list of items is empty for getAllItems$")
    public void a_list_of_items_is_empty_for_getAllItems() throws Throwable {
        List<Items> actualListItems = itemsRepository.getAllItems();

        Assert.assertEquals(actualListItems.size(), 0);

        // verify getAllItems has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("from Items");
        Mockito.verify(mockedQuery).list();
    }
    /************************************************/
    /*
     * Test getAllItemsContainingSearchTerm()
     */
    /***********************************************/
    @When("^getAllItemsContainingSearchTerm\\(\\) is called for ItemsRepository$")
    public void getallitemscontainingsearchterm_is_called_for_ItemsRepository() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("from Items")).thenReturn(mockedQuery);
        Mockito.when(mockedSession.createQuery("FROM Items where item_name LIKE :searchTerm or item_description LIKE :searchTerm or category LIKE :searchTerm")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListItems);
    }

    @Then("^a list of items is returned for getAllItemsContainingSearchTerm$")
    public void a_list_of_items_is_returned_for_getAllItemsContainingSearchTerm() throws Throwable {
        List<Items> actualListItems = itemsRepository.getAllItemsContainingSearchTerm("");
        Assert.assertEquals(actualListItems.size(), expectedListItems.size());
        Assert.assertEquals(actualListItems.get(0), expectedListItems.get(0));

        actualListItems = itemsRepository.getAllItemsContainingSearchTerm("notempty");
        Assert.assertEquals(actualListItems.size(), expectedListItems.size());
        Assert.assertEquals(actualListItems.get(0), expectedListItems.get(0));
        Mockito.verify(mockedSessionFactory, Mockito.atLeastOnce()).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("FROM Items where item_name LIKE :searchTerm or item_description LIKE :searchTerm or category LIKE :searchTerm");
        Mockito.verify(mockedSession).createQuery("from Items");
        Mockito.verify(mockedQuery, Mockito.atLeastOnce()).list();
    }


    /************************************************/
    /*
     * Test addItem()
     */
    /***********************************************/
    @When("^addItem\\(\\) is called$")
    public void additem_is_called() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.doNothing().when(mockedSession).persist(Mockito.any(Items.class));
        Mockito.when(mockedSession.createQuery("select max(item_id) from Items ")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListIDs);
        Mockito.doNothing().when(mockedSession).flush();
        Mockito.when(mockedQuery.list()).thenReturn(expectedListIDs);
    }

    @And("^expected list of ids is initialized$")
    public void expected_list_of_ids_is_initialized() throws Throwable {
        expectedListIDs = new ArrayList<Long>();
        expectedListIDs.add(1L);
    }

    @Then("^a list of ids is returned for addItem$")
    public void a_list_of_ids_is_returned_for_addItem() throws Throwable {
        Items items = new Items();
        List<Long> actualListIDs = itemsRepository.addItem(items);

        Assert.assertEquals(actualListIDs.size(), expectedListIDs.size());
        for (int x=0; x<expectedListIDs.size(); x++)
            Assert.assertEquals(expectedListIDs.get(x), actualListIDs.get(x));

        // verify addItem has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).persist(items);
        Mockito.verify(mockedSession).createQuery("select max(item_id) from Items ");
        Mockito.verify(mockedSession).flush();
        Mockito.verify(mockedQuery, Mockito.atLeast(2)).list();
    }

    @And("^expected null list of ids is initialized$")
    public void expected_null_list_of_ids_is_initialized() throws Throwable {
        expectedListIDs = null;
    }

    @Then("^a list of ids is null for addItem$")
    public void a_list_of_ids_is_null_for_addItem() throws Throwable {
        Items items = new Items();
        List<Long> actualListIDs = itemsRepository.addItem(items);

        Assert.assertNull(actualListIDs);

        // verify addItem has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).persist(items);
        Mockito.verify(mockedSession).createQuery("select max(item_id) from Items ");
        Mockito.verify(mockedSession).flush();
        Mockito.verify(mockedQuery, Mockito.atLeast(2)).list();
    }

    @And("^expected empty list of ids is initialized$")
    public void expected_empty_list_of_ids_is_initialized() throws Throwable {
        expectedListIDs = new ArrayList<Long>();
    }

    @When("^addItem\\(\\) throws exception$")
    public void additem_throws_exception() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.doNothing().when(mockedSession).persist(Mockito.any(Items.class));
        Mockito.when(mockedSession.createQuery(Mockito.anyString())).thenReturn(mockedQuery);
        BDDMockito.given(mockedQuery.list()).willThrow(Exception.class);
    }

    @Then("^a list of ids is empty for addItem$")
    @Test (expected = Exception.class)
    public void a_list_of_ids_is_empty_for_addItem() throws Throwable {
        Items items = new Items();
        List<Long> actualListIDs = itemsRepository.addItem(items);

        Assert.assertEquals(actualListIDs.size(), 0);

        // verify addItem has been called successfully
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).persist(items);
        Mockito.verify(mockedSession).createQuery("select max(item_id) from Items ");
        Mockito.verify(mockedQuery).list();
    }

    /************************************************/
    /*
     * Test updateSoldCount()
     */
    /***********************************************/
    @Given("^expected list of soldcount is initialized$")
    public void expected_list_of_soldcount_is_initialized() throws Throwable {
        expectedListsoldcount = new ArrayList<Long>();
        expectedListsoldcount.add(3L);
    }

    @When("^updateSoldCount\\(\\) is called for ItemsRepository$")
    public void updatesoldcount_is_called_for_ItemsRepository() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("select sold_count from Items where item_id=:itemid")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListsoldcount);
    }

    @Then("^a list of soldcount is returned for updateSoldCount$")
    public void a_list_of_soldcount_is_returned_for_updateSoldCount() throws Throwable {
        Items items = new Items();
        List<Long> actualListSoldCount = itemsRepository.updateSoldCount(items);
        Assert.assertEquals(actualListSoldCount.size(), expectedListsoldcount.size());
        Assert.assertEquals(actualListSoldCount.get(0), expectedListsoldcount.get(0));

        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("select sold_count from Items where item_id=:itemid");
        Mockito.verify(mockedQuery).list();
    }

    @Given("^expected empty list of soldcount is initialized$")
    public void expected_empty_list_of_soldcount_is_initialized() throws Throwable {
        expectedListsoldcount = new ArrayList<Long>();
    }

    @When("^updateSoldCount\\(\\) throws exception$")
    public void updatesoldcount_throws_exception() throws Throwable {
        BDDMockito.given(mockedSessionFactory.getCurrentSession()).willThrow(Exception.class);
    }

    @Then("^a list of soldcount is empty$")
    @Test (expected = Exception.class)
    public void a_list_of_soldcount_is_empty() throws Throwable {
        Items items = new Items();
        List<Long> actualListSoldCount = itemsRepository.updateSoldCount(items);
        Assert.assertEquals(actualListSoldCount.size(), expectedListsoldcount.size());
        Mockito.verify(mockedSessionFactory).getCurrentSession();
    }

}
