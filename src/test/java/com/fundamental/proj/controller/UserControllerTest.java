package com.fundamental.proj.controller;

import com.fundamental.proj.controller.bean.*;
import com.fundamental.proj.delegate.*;
import com.fundamental.proj.model.Address;
import org.hibernate.search.indexes.serialization.javaserialization.impl.Add;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Date;
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
    private ReturnDelegate mockedReturnDelegate;

    @Mock
    private ItemsBean mockedItemsBean;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedUserDelegate, mockedItemsDelegate, mockedCartDelegate, mockedOrdersDelegate, mockedMaterialIndentDelegate, mockedItemsBean, mockedAddressDelegate, mockedReturnDelegate);
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
        Assert.assertEquals(result, "WEB-INF/views/home/manageUsers");
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
    public void getAllManagersTest() {
        UserBean userBean = new UserBean();
        List<UserBean> list = new ArrayList<UserBean>();
        list.add(userBean);

        Mockito.when(mockedUserDelegate.getAllManagers()).thenReturn(list);
        List<UserBean> result = userController.getAllManagers();
        Assert.assertEquals(result.size(), list.size());
        Assert.assertEquals(result.get(0), list.get(0));
        Mockito.verify(mockedUserDelegate).getAllManagers();
    }

    @Test
    public void promoteManagerTest() {
        Mockito.doNothing().when(mockedUserDelegate).promoteManager(Mockito.anyLong());
        List<String> result = userController.promoteManager(1L);
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get(0), "1");
        Mockito.verify(mockedUserDelegate).promoteManager(1L);
    }

    @Test
    public void getAllNewManagersTest() {
        UserBean userBean = new UserBean();
        List<UserBean> list = new ArrayList<UserBean>();
        list.add(userBean);

        Mockito.when(mockedUserDelegate.getAllNewManagers()).thenReturn(list);
        List<UserBean> result = userController.getAllNewManagers();
        Assert.assertEquals(result.size(), list.size());
        Assert.assertEquals(result.get(0), list.get(0));
        Mockito.verify(mockedUserDelegate).getAllNewManagers();
    }

    @Test
    public void approveManagerTest() {
        Mockito.doNothing().when(mockedUserDelegate).approveManager(Mockito.anyLong());
        List<Long> result = userController.approveManager(1L);
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get(0), 1L, 1E-15);
        Mockito.verify(mockedUserDelegate).approveManager(1L);
    }

    @Test
    public void declineManagerTest() {
        Mockito.doNothing().when(mockedUserDelegate).declineManager(Mockito.anyLong());
        List<Long> result = userController.declineManager(1L);
        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(result.get(0), 1L, 1E-15);
        Mockito.verify(mockedUserDelegate).declineManager(1L);
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
    public void saveUserTest() {
        UserBean userBean = new UserBean();
        List<Long> list = userController.saveUser(userBean);
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void saveAddressTest() {
        AddressBean addressBean = new AddressBean();
        List<Long> list = userController.saveAddress(addressBean);
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void purchaseItemTest() {
        MaterialIndentBean materialIndentBean = new MaterialIndentBean();
        List<Long> list = new ArrayList<Long>();
        Mockito.when(mockedMaterialIndentDelegate.addSale(Mockito.any(MaterialIndentBean.class))).thenReturn(list);
        List<Long> result = userController.PurchaseItem(materialIndentBean);
        Assert.assertEquals(result.size(), list.size());
        Mockito.verify(mockedMaterialIndentDelegate).addSale(materialIndentBean);
    }

    @Test
    public void newOrderEmailNotificationTest() {
        MaterialIndentBean materialIndentBean = new MaterialIndentBean();
        materialIndentBean.setIndent_id(1L);
        materialIndentBean.setIndent_date(new Date());
        List<CartBean> cartBeans = new ArrayList<CartBean>();
        CartBean cartBean = new CartBean();
        ItemsBean itemsBean = new ItemsBean();
        itemsBean.setItem_name("name");
        itemsBean.setItem_description("des");
        itemsBean.setSize("size");
        cartBean.setQuantity(3);
        cartBean.setPrice(300F);
        cartBean.setItemsBean(new ItemsBean());
        cartBeans.add(cartBean);
        UserBean userBean = new UserBean();
        userBean.setEmail("daniel.dddao@gmail.com");
        List<UserBean> userBeans = new ArrayList<UserBean>();
        userBeans.add(userBean);

        Mockito.when(mockedUserDelegate.getUserInfo(Mockito.any(UserBean.class))).thenReturn(userBeans);
        Mockito.when(mockedCartDelegate.getCart(Mockito.anyLong())).thenReturn(cartBeans);
        Mockito.doNothing().when(mockedCartDelegate).clearCart(Mockito.anyLong());

        List<String> list = userController.newOrderEmailNotification(materialIndentBean);
        Assert.assertEquals(list.size(), 0);
    }


    @Test
    public void cartItemTest() {
        String result = userController.CartItem();
        Assert.assertEquals(result, "WEB-INF/views/home/cart");
    }

    @Test
    public void getSearchResultItemsTest() {
        ItemsBean itemsBean = new ItemsBean();
        itemsBean.setItem_name("name");
        itemsBean.setCategory("cat");
        List<ItemsBean> list = new ArrayList<ItemsBean>();
        list.add(new ItemsBean());

        Mockito.when(mockedItemsDelegate.getAllItemsContainingSearchTerm(Mockito.anyString(), Mockito.anyString())).thenReturn(list);
        List<ItemsBean> result = userController.getSearchResultItems(itemsBean);
        Assert.assertEquals(result.size(), list.size());
        Assert.assertEquals(result.get(0), list.get(0));
        Mockito.verify(mockedItemsDelegate).getAllItemsContainingSearchTerm("name", "cat");
    }

    @Test
    public void getCatgResultItemsTest() {
        ItemsBean itemsBean = new ItemsBean();
        itemsBean.setItem_name("name");
        itemsBean.setCategory("cat");
        List<ItemsBean> list = new ArrayList<ItemsBean>();
        list.add(new ItemsBean());

        Mockito.when(mockedItemsDelegate.getAllCatItemsContainingSearchTerm(Mockito.anyString())).thenReturn(list);
        List<ItemsBean> result = userController.getCatgResultItems(itemsBean);
        Assert.assertEquals(result.size(), list.size());
        Assert.assertEquals(result.get(0), list.get(0));
        Mockito.verify(mockedItemsDelegate).getAllCatItemsContainingSearchTerm("cat");
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
    public void updateAddressTest() {
        AddressBean addressBean = new AddressBean();

        Mockito.doNothing().when(mockedAddressDelegate).updateAddress(addressBean);
        List<String> result = userController.updateAddress(addressBean);
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void deleteCartTest() {
        CartBean cartBean = new CartBean();

        List<String> result = userController.deleteCart(cartBean);
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void newAddressTest() {
        AddressBean addressBean = new AddressBean();
        List<Long> list = new ArrayList<Long>();
        list.add(1L);

        Mockito.when(mockedAddressDelegate.addAddress(Mockito.any(AddressBean.class))).thenReturn(list);
        List<AddressBean> result = userController.newAddress(addressBean);
        Assert.assertEquals(result.size(), 1);
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
    public void groupOrdersByOrderNumberTest() {
        OrdersBean ordersBean1 = new OrdersBean();
        MaterialIndentBean materialIndentBean = new MaterialIndentBean();
        materialIndentBean.setIndent_id(1L);
        ordersBean1.setMaterialIndentBean(materialIndentBean);
        List<OrdersBean> list = new ArrayList<OrdersBean>();
        list.add(ordersBean1);

        List<List<OrdersBean>> listlist = userController.groupOrdersByOrderNumber(list);
        Assert.assertEquals(listlist.size(), 1);

        OrdersBean ordersBean2 = new OrdersBean();
        ordersBean2.setMaterialIndentBean(materialIndentBean);
        list.add(ordersBean2);
        listlist = userController.groupOrdersByOrderNumber(list);
        Assert.assertEquals(listlist.size(), 2);

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

    @Test
    public void editInfo() {
        String result = userController.editInfo();
        Assert.assertEquals(result, "WEB-INF/views/home/editInfo");
    }

    @Test
    public void updatePasswordTest() {
        UserBean userBean = new UserBean();
        List<Long> list = userController.updatePassword(userBean);
        Assert.assertEquals(list.size(), 0);

        userBean.setId(1L);
        userBean.setPwsd("password");
        list = userController.updatePassword(userBean);
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void updateOtherInfoTest() {
        UserBean userBean = new UserBean();
        Mockito.doNothing().when(mockedUserDelegate).updateOtherInfo(Mockito.any(UserBean.class));
        List<Long> list = userController.updateOtherInfo(userBean);
        Assert.assertEquals(list.size(), 1);
    }

    @Test
    public void updateShippingAddressTest() {
        AddressBean addressBean = new AddressBean();
        Mockito.doNothing().when(mockedAddressDelegate).updateAddress(Mockito.any(AddressBean.class));
        List<Long> list = userController.updateShippingAddress(addressBean);
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void receivedOrdersPageTest() {
        String result = userController.receivedOrdersPage();
        Assert.assertEquals(result, "WEB-INF/views/home/receivedorders");
    }

    @Test
    public void getReceivedOrdersTest() {
        UserBean userBean = new UserBean();
        List<OrdersBean> list = new ArrayList<OrdersBean>();
        list.add(new OrdersBean());

        Mockito.when(mockedOrdersDelegate.getReceivedORders(Mockito.anyLong())).thenReturn(list);
        List<OrdersBean> result = userController.getReceivedOrders(userBean);
        Assert.assertEquals(result.size(), list.size());
    }

    @Test
    public void ApproveOrdersTest() {
        OrdersBean ordersBean = new OrdersBean();
        ordersBean.setOrder_id(1L);

        Mockito.doNothing().when(mockedOrdersDelegate).udpateOrders(Mockito.anyLong());
        List<String> result = userController.ApproveOrders(ordersBean);
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void ReturnRequestTest() {
        ReturnBean returnBean = new ReturnBean();
        returnBean.setReturn_id(1L);
        List<OrdersBean> list = new ArrayList<OrdersBean>();
        list.add(new OrdersBean());

        Mockito.when(mockedOrdersDelegate.getOrders(Mockito.anyLong())).thenReturn(list);
        Mockito.when(mockedReturnDelegate.returnRequest(Mockito.any(ReturnBean.class))).thenReturn("");
        List<String> result = userController.ReturnRequest(returnBean);
        Assert.assertEquals(result.size(), 1);
    }

    @Test
    public void getRecReturnedOrdersTest() {
        UserBean userBean = new UserBean();
        userBean.setId(1L);

        List<ReturnBean> list = new ArrayList<ReturnBean>();

        Mockito.when(mockedReturnDelegate.getRecRetOrders(Mockito.anyLong())).thenReturn(list);
        List<ReturnBean> result = userController.getRecReturnedOrders(userBean);
        Assert.assertEquals(result.size(), list.size());
    }

    @Test
    public void getReturnedOrdersTest() {
        UserBean userBean = new UserBean();
        userBean.setId(1L);

        List<ReturnBean> list = new ArrayList<ReturnBean>();

        Mockito.when(mockedReturnDelegate.getRetOrders(Mockito.anyLong())).thenReturn(list);
        List<ReturnBean> result = userController.getReturnedOrders(userBean);
        Assert.assertEquals(result.size(), list.size());
    }
}
