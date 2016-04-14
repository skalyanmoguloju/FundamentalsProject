package com.fundamental.proj.controller;

import com.fundamental.proj.controller.bean.*;
import com.fundamental.proj.delegate.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Dao on 4/3/16.
 */
public class UserControllerTest {

    @Mock
    private UserDelegate mockedUserDelegate;

    @Mock
    private ItemsDelegate mockedItemsDelegate;

    @Mock
    private CartDelegate mockedCartDelegate;

    @Mock
    private OrdersDelegate mockedOrdersDelegate;

    @Mock
    private MaterialIndentDelegate mockedMaterialIndentDelegate;

    @Mock
    private AddressDelegate mockedAddressDelegate;

    @Mock
    private ItemsBean mockedItemsBean;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedUserDelegate, mockedItemsDelegate, mockedCartDelegate, mockedOrdersDelegate, mockedMaterialIndentDelegate, mockedItemsBean, mockedAddressDelegate);
    }

    @Test
    public void viewTest() {
        String result = userController.view();
        Assert.assertEquals(result, "WEB-INF/views/home/view");
    }

    @Test
    public void getAllItemsTest() {
        List<ItemsBean> list = new ArrayList<ItemsBean>();
        list.add(new ItemsBean());

        Mockito.when(mockedItemsDelegate.getAllItems()).thenReturn(list);
        List<ItemsBean> result = userController.getAllItems();
        Assert.assertEquals(result.size(), list.size());
        Assert.assertEquals(result.get(0), list.get(0));

        Mockito.verify(mockedItemsDelegate).getAllItems();
    }

    @Test
    public void addAdminPageTest() {
        String result = userController.addAdminPage();
        Assert.assertEquals(result, "WEB-INF/views/home/addAdmin");
    }

    @Test
    public void addNewAdminTest() {
        List<Long> list = new ArrayList<Long>();
        list.add(1L);

        Mockito.when(mockedUserDelegate.addNewAdmin()).thenReturn(list);
        List<Long> result = userController.addNewAdmin();
        Assert.assertEquals(result.size(), list.size());
        Assert.assertEquals(result.get(0), list.get(0));

        Mockito.verify(mockedUserDelegate).addNewAdmin();
    }

    @Test
    public void addManagerPageTest() {
        String result = userController.addManagerPage();
        Assert.assertEquals(result, "WEB-INF/views/home/addManager");
    }

    @Test
    public void addNewManagerTest() {
        List<Long> list = new ArrayList<Long>();
        list.add(1L);

        Mockito.when(mockedUserDelegate.addNewManager()).thenReturn(list);
        List<Long> result = userController.addNewManager();
        Assert.assertEquals(result.size(), list.size());
        Assert.assertEquals(result.get(0), list.get(0));

        Mockito.verify(mockedUserDelegate).addNewManager();
    }

    @Test
    public void addItemPage() {
        String result = userController.addItemPage();
        Assert.assertEquals(result, "WEB-INF/views/home/addItem");
    }

    @Test
    public void addItemTest() {
        List<String> list = new ArrayList<String>();
        list.add("test");
        ItemsBean itemsBean = new ItemsBean();
        itemsBean.setItem_name("test");

        Mockito.doNothing().when(mockedItemsDelegate).addItem(Mockito.any(ItemsBean.class));
        List<String> result = userController.AddItem(itemsBean);
        Assert.assertEquals(result.size(), list.size());
        Assert.assertEquals(result.get(0), list.get(0));
        Mockito.verify(mockedItemsDelegate).addItem(itemsBean);
    }

    @Test
    public void purchaseItemTest() {
        MaterialIndentBean materialIndentBean = new MaterialIndentBean();

        Mockito.doNothing().when(mockedMaterialIndentDelegate).addSale(Mockito.any(MaterialIndentBean.class));
        List<Long> result = userController.PurchaseItem(materialIndentBean);
        Assert.assertEquals(result.size(), 0);
        Mockito.verify(mockedMaterialIndentDelegate).addSale(materialIndentBean);
    }

    @Test
    public void cartItemTest() {
        String result = userController.CartItem();
        Assert.assertEquals(result, "WEB-INF/views/home/cart");
    }

    @Test
    public void getSearchResultItemsTest() {
        String searchterm = "test search term123456";
        List<ItemsBean> list = new ArrayList<ItemsBean>();
        list.add(new ItemsBean());

        Mockito.when(mockedItemsDelegate.getAllItemsContainingSearchTerm(Mockito.anyString())).thenReturn(list);
        List<ItemsBean> result = userController.getSearchResultItems(searchterm);
        Assert.assertEquals(result.size(), list.size());
        Assert.assertEquals(result.get(0), list.get(0));
        Mockito.verify(mockedItemsDelegate).getAllItemsContainingSearchTerm("m1234");
    }

    @Test
    public void userInfoTest() {
        UserBean userBean = new UserBean();
        userBean.setId(1L);
        List<CartBean> list = new ArrayList<CartBean>();
        list.add(new CartBean());

        Mockito.when(mockedCartDelegate.getCart(Mockito.anyLong())).thenReturn(list);
        List<CartBean> result = userController.userInfo(userBean);
        Assert.assertEquals(result.size(), list.size());
        Assert.assertEquals(result.get(0), list.get(0));
        Mockito.verify(mockedCartDelegate).getCart(userBean.getId());
    }

    @Test
    public void addToCartTest() {
        CartBean cartBean = new CartBean();

        List<String> result = userController.AddToCart(cartBean);
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void updateCartTest() {
        CartBean cartBean = new CartBean();

        List<String> result = userController.updateCart(cartBean);
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void deleteCartTest() {
        CartBean cartBean = new CartBean();

        List<String> result = userController.deleteCart(cartBean);
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void getAllOrdersTest() {
        UserBean userBean = new UserBean();
        userBean.setId(1L);
        List<OrdersBean> list = new ArrayList<OrdersBean>();
        list.add(new OrdersBean());

        Mockito.when(mockedOrdersDelegate.getAllOrderss(Mockito.anyLong())).thenReturn(list);
        List<OrdersBean> result = userController.getAllOrders(userBean);
        Assert.assertEquals(result.size(), list.size());

        Mockito.verify(mockedOrdersDelegate).getAllOrderss(1L);
    }

    @Test
    public void allOrdersPageTest() {
        String result = userController.allOrdersPage();
        Assert.assertEquals(result, "WEB-INF/views/home/vieworders");
    }

    @Test
    public void userAddressTest() {
        AddressBean addressBean = new AddressBean();
        List<AddressBean> list = new ArrayList<AddressBean>();
        list.add(addressBean);

        Mockito.when(mockedAddressDelegate.getAddress(Mockito.anyLong())).thenReturn(list);
        UserBean userBean = new UserBean();
        userBean.setId(1L);
        List<AddressBean> actualList = userController.userAddress(userBean);
        Assert.assertEquals(actualList.size(), list.size());
        Assert.assertEquals(actualList.get(0), list.get(0));

        Mockito.verify(mockedAddressDelegate).getAddress(userBean.getId());
    }

    @Test
    public void updateSoldCountTest() {
        List<Long> list = new ArrayList<Long>();
        list.add(3L);

        ItemsBean itemsBean = new ItemsBean();
        itemsBean.setItem_id(1L);

        Mockito.when(mockedOrdersDelegate.getTotalSold(Mockito.anyLong())).thenReturn(list);
        Mockito.when(mockedItemsDelegate.updateSoldCount(itemsBean)).thenReturn(list);

        List<Long> actualList = userController.updateSoldCount(itemsBean);
        Assert.assertEquals(actualList.size(), list.size());
        Assert.assertEquals(actualList.get(0), list.get(0));

        Mockito.verify(mockedOrdersDelegate).getTotalSold(itemsBean.getItem_id());
        Mockito.verify(mockedItemsDelegate).updateSoldCount(itemsBean);
    }

}
