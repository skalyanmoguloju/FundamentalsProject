package com.fundamental.proj.controller;
import com.fundamental.proj.controller.bean.*;
import com.fundamental.proj.delegate.*;
import com.fundamental.proj.util.EmailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by sai on 3/6/16.
 */
@Controller
public class UserController {

    @Autowired
    private ItemsDelegate itemsDelegate;

    @Autowired
    private SalesDelegate salesDelegate;

    @Autowired
    private CartDelegate cartDelegate;


    private AddressBean addressBean = new AddressBean();


    private UserBean userBean = new UserBean();

    @Autowired
    private OrdersDelegate ordersDelegate;

    @Autowired
    private ReturnDelegate returnDelegate;

    @Autowired
    private UserDelegate userDelegate;

    @Autowired
    private MaterialIndentDelegate materialIndentDelegate;

    @Autowired
    private AddressDelegate addressDelegate;

    @RequestMapping(value = "/view")
    public String view() {
        return "WEB-INF/views/home/view";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public List<ItemsBean> getAllItems() {
        //HIBERNETCALLS
        List<ItemsBean> s = itemsDelegate.getAllItems();
        return s;
    }

    @RequestMapping(value = "/add admin")
    public String addAdminPage() {
        return "WEB-INF/views/home/addAdmin";
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> addNewAdmin() {
        //HIBERNETCALLS
        return userDelegate.addNewAdmin();
    }

    @RequestMapping(value = "/manage managers")
    public String addManagerPage() {
        return "WEB-INF/views/home/manageManagers";
    }

    @RequestMapping(value = "/addManager", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> addNewManager() {
        return userDelegate.addNewManager();
    }

    @RequestMapping(value = "/listManagers", method = RequestMethod.POST)
    @ResponseBody
    public List<UserBean> getAllManagers() {
        return userDelegate.getAllManagers();
    }

    @RequestMapping(value = "/promoteManager", method = RequestMethod.POST)
    @ResponseBody
    public List<String> promoteManager(@RequestBody long user_id) {
        List<String> s = new ArrayList<String>();
        try {
            userDelegate.promoteManager(user_id);
            s.add("" + user_id);
            return s;
        } catch (Exception e) {
            return s;
        }
    }

    @RequestMapping(value = "/add item")
    public String addItemPage() {
        return "WEB-INF/views/home/addItem";
    }


    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    @ResponseBody
    public List<String> AddItem(@RequestBody ItemsBean itemsBean) {
        //HIBERNETCALLS
        List<String> s = new LinkedList<String>();
        try {
            itemsBean.setDate(Calendar.getInstance().getTime());
            itemsBean.setSold_count(0);
            itemsDelegate.addItem(itemsBean);
            s.add(itemsBean.getItem_name());
            //String passwordToCompare = itemsDelegate.  .getUserPasswordWithEmail(userBean);
            return s;

        } catch (Exception e) {
            return s;
        }

    }
    @RequestMapping(value = "/order1", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> saveUser(@RequestBody UserBean userBean1)
    {
        List<Long> s = new LinkedList<Long>();
        userBean = userBean1;
        return s;
    }
    @RequestMapping(value = "/order2", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> saveAddress(@RequestBody AddressBean addressBean1)
    {
        List<Long> s = new LinkedList<Long>();
        addressBean = addressBean1;
        return s;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> PurchaseItem(@RequestBody MaterialIndentBean materialIndentBean) {
        //HIBERNETCALLS
        List<Long> s = new LinkedList<Long>();
        try {
            Date date = new Date();
            materialIndentBean.setIndent_date(date);
            materialIndentBean.setUserBean(userBean);
            materialIndentBean.setAddressBean(addressBean);
            List<Long> l = materialIndentDelegate.addSale(materialIndentBean);
            //String passwordToCompare = itemsDelegate.  .getUserPasswordWithEmail(userBean);

            return l;

        } catch (Exception e) {
            return s;
        }

    }

    @RequestMapping(value = "/newOrderEmailNotification", method = RequestMethod.POST)
    @ResponseBody
    public List<String> newOrderEmailNotification(@RequestBody MaterialIndentBean materialIndentBean) {
        //HIBERNETCALLS
        List<String> s = new LinkedList<String>();
        try {

            /* get user's email */
            String email = userDelegate.getUserInfo(userBean).get(0).getEmail();

            /* get list of cartbeans */
            List<CartBean> cartBeans = cartDelegate.getCart(userBean.getId());

            /* Clear Cart */
            cartDelegate.clearCart(userBean.getId());

            /* send email for purchased items */
            Date date = new Date();
            materialIndentBean.setIndent_date(date);
            EmailNotification ev = new EmailNotification();
            ev.sendEmailOrderConfirmation(email, materialIndentBean, cartBeans);
//            ev.sendEmailOrderConfirmation("daniel.dddao@gmail.com", materialIndentBean, cartBeans);

            s.add(email);
            return s;

        } catch (Exception e) {
            return s;
        }

    }

    @RequestMapping(value = "/cart")
    public String CartItem() {
        return "WEB-INF/views/home/cart";

    }

    @RequestMapping(value = "/listResults", method = RequestMethod.POST)
    @ResponseBody
    public List<ItemsBean> getSearchResultItems(@RequestBody String searchTerm) {
        String term = searchTerm.substring(15,(searchTerm.length()-2));
        List<ItemsBean> s = itemsDelegate.getAllItemsContainingSearchTerm(term);
        return s;
    }

    @RequestMapping(value = "/getCart", method = RequestMethod.POST)
    @ResponseBody
    public List<CartBean> userInfo(@RequestBody UserBean userBean) {
        //HYBERNETCALLS
        return cartDelegate.getCart(userBean.getId());
    }

    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    @ResponseBody
    public List<String> AddToCart(@RequestBody CartBean cartBean) {
        //HIBERNETCALLS
        List<String> s = new LinkedList<String>();
        try {
            cartDelegate.AddToCart(cartBean, 0);
            //String passwordToCompare = itemsDelegate.  .getUserPasswordWithEmail(userBean);
            return s;

        } catch (Exception e) {
            return s;
        }

    }

    @RequestMapping(value = "/updateCart", method = RequestMethod.POST)
    @ResponseBody
    public List<String> updateCart(@RequestBody CartBean cartBean) {
        //HIBERNETCALLS
        List<String> s = new LinkedList<String>();
        try {
            cartDelegate.AddToCart(cartBean, 1);
            //String passwordToCompare = itemsDelegate.  .getUserPasswordWithEmail(userBean);
            return s;

        } catch (Exception e) {
            return s;
        }

    }

    @RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
    @ResponseBody
    public List<String> deleteCart(@RequestBody CartBean cartBean) {
        //HIBERNETCALLS
        List<String> s = new LinkedList<String>();
        try {
            cartDelegate.AddToCart(cartBean, 2);
            //String passwordToCompare = itemsDelegate.  .getUserPasswordWithEmail(userBean);
            return s;

        } catch (Exception e) {
            return s;
        }

    }
    @RequestMapping(value = "/allorders", method = RequestMethod.POST)
    @ResponseBody
    public List<OrdersBean> getAllOrders(@RequestBody UserBean userBean) {
        //HIBERNETCALLS
        return ordersDelegate.getAllOrderss(userBean.getId());
    }
    @RequestMapping(value = "/view orders")
    public String allOrdersPage() {
        return "WEB-INF/views/home/vieworders";
    }

    @RequestMapping(value = "/userAddress", method = RequestMethod.POST)
    @ResponseBody
    public List<AddressBean> userAddress(@RequestBody UserBean userBean) {
        //HYBERNETCALLS
        List<AddressBean> u = addressDelegate.getAddress(userBean.getId());
        return u;
    }

    @RequestMapping(value = "/updateSoldCount", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> updateSoldCount(@RequestBody ItemsBean itemsBean) {
        //HYBERNETCALLS
        long sold_count = ordersDelegate.getTotalSold(itemsBean.getItem_id()).get(0);
        itemsBean.setSold_count((int) sold_count);
        List<Long> list = itemsDelegate.updateSoldCount(itemsBean);
        return list;
    }

    @RequestMapping(value = "/received orders")
    public String receivedOrdersPage() {
        return "WEB-INF/views/home/receivedorders";
    }
    @RequestMapping(value = "/recvorders", method = RequestMethod.POST)
    @ResponseBody
    public List<OrdersBean> getReceivedOrders(@RequestBody UserBean userBean) {
        //HIBERNETCALLS
        return ordersDelegate.getReceivedORders(userBean.getId());
    }

    @RequestMapping(value = "/approveOrder", method = RequestMethod.POST)
    @ResponseBody
    public List<String> ApproveOrders(@RequestBody OrdersBean orders) {
        //HIBERNETCALLS
        ordersDelegate.udpateOrders(orders.getOrder_id());
        List<String> s = new LinkedList<String>();
        return s;
    }

    @RequestMapping(value = "/returnrequest", method = RequestMethod.POST)
    @ResponseBody
    public List<String> ReturnRequest(@RequestBody ReturnBean returnBean) {
        //HIBERNETCALLS

        OrdersBean ordersBean = new OrdersBean();
        ordersBean.setOrder_id(returnBean.getReturn_id());
        returnBean.setOrdersBean(ordersDelegate.getOrders(returnBean.getReturn_id()).get(0));
        returnBean.setReturn_id(0);
        List<String> s = new LinkedList<String>();
        s.add(returnDelegate.returnRequest(returnBean));
        return s;
    }

}
