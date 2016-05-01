package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.ItemsBean;
import com.fundamental.proj.mapper.ItemsBeanMapper;
import com.fundamental.proj.model.Items;
import com.fundamental.proj.service.ItemsService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class ItemsDelegateSteps {

    @Mock
    private ItemsService mockedItemsService;

    @Mock
    private ItemsBeanMapper mockedItemsBeanMapper;

    @Mock
    private List<Items> mockedListItems;

    @Mock
    private Items mockedItems;

    @InjectMocks
    private ItemsDelegate itemsDelegate;

    private List<ItemsBean> expectedListItemBean;
    private List<Items> expectedListItem;
    private List<Long> expectedListSoldCount;
    private List<String> expectedListItems;

    @Given("^mock ItemsDelegate is initialized$")
    public void mock_itemsrespository_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedItemsService, mockedItemsBeanMapper, mockedListItems);
    }

    /************************************************/
    /*
     * Test getAllItems()
     */
    /***********************************************/
    @When("^getAllItems\\(\\) is called for ItemsDelegate$")
    public void getallitems_is_called_ItemsDelegate() throws Throwable {
        Mockito.when(mockedItemsService.getAllItems()).thenReturn(mockedListItems);
        Mockito.when(mockedItemsBeanMapper.mapItemBean(mockedListItems)).thenReturn(expectedListItemBean);
    }

    @And("^expected list of itembeans is initialized$")
    public void expected_list_of_itembeans_is_initialized() throws Throwable {
        ItemsBean items1 = new ItemsBean();
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

        expectedListItemBean = new ArrayList<ItemsBean>();
        expectedListItemBean.add(items1);
    }

    @Then("^a list of itembeans is returned for getAllItems$")
    public void a_list_of_itembeans_is_returned_for_getAllItems() throws Throwable {
        List<ItemsBean> actualListItemsBean = itemsDelegate.getAllItems();

        Assert.assertEquals(actualListItemsBean.size(), actualListItemsBean.size());
        for (int x=0; x<expectedListItemBean.size(); x++) {
            Assert.assertEquals(actualListItemsBean.get(x).getCategory(), expectedListItemBean.get(x).getCategory());
            Assert.assertEquals(actualListItemsBean.get(x).getDate(), expectedListItemBean.get(x).getDate());
            Assert.assertEquals(actualListItemsBean.get(x).getImages(), expectedListItemBean.get(x).getImages());
            Assert.assertEquals(actualListItemsBean.get(x).getItem_id(), expectedListItemBean.get(x).getItem_id());
            Assert.assertEquals(actualListItemsBean.get(x).getItem_name(), expectedListItemBean.get(x).getItem_name());
            Assert.assertEquals(actualListItemsBean.get(x).getItem_description(), expectedListItemBean.get(x).getItem_description());
            Assert.assertEquals(actualListItemsBean.get(x).getOnsale_count(), expectedListItemBean.get(x).getOnsale_count());
            Assert.assertEquals(actualListItemsBean.get(x).getPrice(), expectedListItemBean.get(x).getPrice(), 1E-15);
            Assert.assertEquals(actualListItemsBean.get(x).getUser_id(), expectedListItemBean.get(x).getUser_id());
            Assert.assertEquals(actualListItemsBean.get(x).getSold_count(), expectedListItemBean.get(x).getSold_count());
        }

        // verify getAllItems has been called successfully
        Mockito.verify(mockedItemsService).getAllItems();
        Mockito.verify(mockedItemsBeanMapper).mapItemBean(mockedListItems);
    }

    @And("^expected null list of itembeans is initialized$")
    public void expected_null_list_of_itembeans_is_initialized() throws Throwable {
        expectedListItemBean = null;
    }

    @Then("^a list of itembeans is null for getAllItems$")
    public void a_list_of_itembeans_is_null_for_getAllItems() throws Throwable {
        List<ItemsBean> actualListItemsBean = itemsDelegate.getAllItems();

        Assert.assertNull(actualListItemsBean);

        // verify getAllItems has been called successfully
        Mockito.verify(mockedItemsService).getAllItems();
        Mockito.verify(mockedItemsBeanMapper).mapItemBean(mockedListItems);

    }

    @And("^expected empty list of itembeans is initialized$")
    public void expected_empty_list_of_itembeans_is_initialized() throws Throwable {
        expectedListItemBean = new ArrayList<ItemsBean>();
    }

    @Then("^a list of itembeans is empty for getAllItems$")
    public void a_list_of_itembeans_is_empty_for_getAllItems() throws Throwable {
        List<ItemsBean> actualListItemsBean = itemsDelegate.getAllItems();

        Assert.assertEquals(actualListItemsBean.size(), 0);

        // verify getAllItems has been called successfully
        Mockito.verify(mockedItemsService).getAllItems();
        Mockito.verify(mockedItemsBeanMapper).mapItemBean(mockedListItems);
    }

    /************************************************/
    /*
     * Test addItem()
     */
    /***********************************************/
    @When("^addItem\\(\\) is called for ItemsDelegate$")
    public void additem_is_called_ItemsDelegate() throws Throwable {
        Mockito.when(mockedItemsBeanMapper.mapBeanToItems(Mockito.any(ItemsBean.class))).thenReturn(mockedItems);
        Mockito.doNothing().when(mockedItemsService).addItem(mockedItems);
    }

    @Then("^addItem has been called successfully$")
    public void additem_has_been_called_successfully() throws Throwable {
        ItemsBean itemsBean = new ItemsBean();
        itemsDelegate.addItem(itemsBean);

        // verify addItem has been called
        Mockito.verify(mockedItemsBeanMapper).mapBeanToItems(itemsBean);
        Mockito.verify(mockedItemsService).addItem(mockedItems);
    }

    /************************************************/
    /*
     * Test getAllItemsContainingSearchTerm()
     */
    /***********************************************/
    @When("^getAllItemsContainingSearchTerm\\(\\) is called for ItemsDelegate$")
    public void getallitemscontainingsearchterm_is_called_for_ItemsDelegate() throws Throwable {
        Mockito.when(mockedItemsService.getAllItemsContainingSearchTerm(Mockito.anyString(), Mockito.anyString())).thenReturn(mockedListItems);
        Mockito.when(mockedItemsBeanMapper.mapItemBean(mockedListItems)).thenReturn(expectedListItemBean);
    }

    @Then("^a list of itembeans is returned for getAllItemsContainingSearchTerm$")
    public void a_list_of_itembeans_is_returned_for_getAllItemsContainingSearchTerm() throws Throwable {
        List<ItemsBean> actualList = itemsDelegate.getAllItemsContainingSearchTerm("s", "c");
        Assert.assertEquals(actualList.size(), expectedListItemBean.size());
        Assert.assertEquals(actualList.get(0), expectedListItemBean.get(0));
        Mockito.verify(mockedItemsService).getAllItemsContainingSearchTerm("s", "c");
        Mockito.verify(mockedItemsBeanMapper).mapItemBean(mockedListItems);
    }

    /************************************************/
    /*
     * Test updateSoldCount()
     */
    /***********************************************/
    @Given("^expected soldcount is initialized$")
    public void expected_soldcount_is_initialized() throws Throwable {
        expectedListSoldCount = new ArrayList<Long>();
        expectedListSoldCount.add(1L);
    }

    @When("^updateSoldCount\\(\\) is called for ItemsDelegate$")
    public void updatesoldcount_is_called_for_ItemsDelegate() throws Throwable {
        Mockito.when(mockedItemsBeanMapper.mapBeanToItems(Mockito.any(ItemsBean.class))).thenReturn(mockedItems);
        Mockito.when(mockedItemsService.updateSoldCount(mockedItems)).thenReturn(expectedListSoldCount);
    }

    @Then("^soldcount is returned for updateSoldCount$")
    public void soldcount_is_returned_for_updateSoldCount() throws Throwable {
        ItemsBean itemsBean = new ItemsBean();
        List<Long> actualList = itemsDelegate.updateSoldCount(itemsBean);
        Assert.assertEquals(actualList.size(), expectedListSoldCount.size());
        Assert.assertEquals(actualList.get(0), expectedListSoldCount.get(0));
        Mockito.verify(mockedItemsBeanMapper).mapBeanToItems(itemsBean);
        Mockito.verify(mockedItemsService).updateSoldCount(mockedItems);
    }

    @Given("^expected list of items is initialized for getAllCatgs$")
    public void expected_list_of_items_is_initialized_for_getAllCatgs() throws Throwable {
        expectedListItems = new ArrayList<String>();
        expectedListItems.add("item1");
    }

    @When("^getAllCatgs\\(\\) is called for ItemsDelegate$")
    public void getallcatgs_is_called_for_ItemsDelegate() throws Throwable {
        Mockito.when(mockedItemsService.getAllCatgs()).thenReturn(expectedListItems);
    }

    @Then("^a list of items is returned for getAllCatgs$")
    public void a_list_of_items_is_returned_for_getAllCatgs() throws Throwable {
        List<String> list = itemsDelegate.getAllCatgs();
        Assert.assertEquals(list.size(), expectedListItems.size());
        Assert.assertEquals(list.get(0), expectedListItems.get(0));
    }

    @When("^getAllCatItemsContainingSearchTerm\\(\\) is called for ItemsDelegate$")
    public void getallcatitemscontainingsearchterm_is_called_for_ItemsDelegate() throws Throwable {
        expectedListItem = new ArrayList<Items>();
        expectedListItem.add(new Items());
        Mockito.when(mockedItemsService.getAllCatItemsContainingSearchTerm(Mockito.anyString())).thenReturn(expectedListItem);
    }

    @Then("^a list of itembeans is returned for getAllCatItemsContainingSearchTerm$")
    public void a_list_of_itembeans_is_returned_for_getAllCatItemsContainingSearchTerm() throws Throwable {
        List<ItemsBean> list = itemsDelegate.getAllCatItemsContainingSearchTerm("cat");
        Assert.assertEquals(list.size(), 0);
    }

}
