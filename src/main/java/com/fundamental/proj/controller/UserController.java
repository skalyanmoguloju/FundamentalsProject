package com.fundamental.proj.controller;
import com.fundamental.proj.controller.bean.*;
import com.fundamental.proj.delegate.*;
import com.fundamental.proj.util.EmailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map.Entry;

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

    @Autowired
    private OrdersDelegate ordersDelegate;

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

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> PurchaseItem(@RequestBody MaterialIndentBean materialIndentBean, @RequestBody AddressBean addressBean) {
        //HIBERNETCALLS
        List<Long> s = new LinkedList<Long>();
        try {
<<<<<<< HEAD
            //Date date = new Date();
            //materialIndentBean.setIndent_date(date);
            List<Long> l = materialIndentDelegate.addSale(materialIndentBean);
=======
            Date date = new Date();
            materialIndentBean.setIndent_date(date);
            List<Long> l = materialIndentDelegate.addSale(materialIndentBean, addressBean.getAddress_Id());
>>>>>>> 36c0c129fcaeec63cd0c2c9d315c273bb7dee186
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
            UserBean userBean = new UserBean();
            userBean.setId(materialIndentBean.getUserBean().getId());
            String email = userDelegate.getUserInfo(userBean).get(0).getEmail();

            /* get list of cartbeans */
            List<CartBean> cartBeans = cartDelegate.getCart(materialIndentBean.getUserBean().getId());

            /* Clear Cart */
            cartDelegate.clearCart(materialIndentBean.getUserBean().getId());

            /* send email for purchased items */
            //Date date = new Date();
            //materialIndentBean.setIndent_date(date);
            EmailNotification ev = new EmailNotification();
            ev.sendEmailOrderConfirmation(email, materialIndentBean, cartBeans);
            ev.sendEmailOrderConfirmation("daniel.dddao@gmail.com", materialIndentBean, cartBeans);

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

    @RequestMapping(value = "/groupOrdersByOrderNumber", method = RequestMethod.POST)
    @ResponseBody
    public List<List<OrdersBean>> groupOrdersByOrderNumber(@RequestBody List<OrdersBean> ordersBeanList) {
        //HIBERNETCALLS
        List<List<OrdersBean>> ordersBeanLists = new ArrayList<List<OrdersBean>>();
        for (OrdersBean ordersBean : ordersBeanList) {
            if (ordersBeanLists.size() == 0) {
                List<OrdersBean> listOrderBean = new ArrayList<OrdersBean>();
                listOrderBean.add(ordersBean);
                ordersBeanLists.add(listOrderBean);
                System.out.println("NEW " + ordersBean.getOrder_id());
            } else {
                long indent_id = ordersBean.getMaterialIndentBean().getIndent_id();
                long order_id = ordersBean.getOrder_id();
                for (int x=0; x < ordersBeanLists.size(); x++) {
                    OrdersBean ordersBeanCompared = ordersBeanLists.get(x).get(0);
                    if (indent_id == ordersBeanCompared.getMaterialIndentBean().getIndent_id() && order_id != ordersBeanCompared.getOrder_id()) {
                        ordersBeanLists.get(x).add(ordersBean);
                        System.out.println("IF " + ordersBean.getOrder_id());
                        break;
                    } else if (x == (ordersBeanLists.size()-1)) {
                        List<OrdersBean> listOrderBean = new ArrayList<OrdersBean>();
                        listOrderBean.add(ordersBean);
                        ordersBeanLists.add(listOrderBean);
                        System.out.println("ELSE" + ordersBean.getOrder_id());
                        break;
                    }
                }
            }
        }
        return ordersBeanLists;
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

<<<<<<< HEAD
    @RequestMapping(value = "/edit info")
    public String editInfo() {
        return "WEB-INF/views/home/editInfo";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> updatePassword(@RequestBody UserBean userBean) {
        List<Long> s = new ArrayList<Long>();
        try {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userDelegate.resetPassword(userBean.getId(), passwordEncoder.encode(userBean.getPwsd()));
            s.add(userBean.getId());
            return s;
        } catch (Exception e) {
            return s;
        }
    }

    @RequestMapping(value = "/updateOtherInfo", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> updateOtherInfo(@RequestBody UserBean userBean) {
        List<Long> s = new ArrayList<Long>();
        try {
            userDelegate.updateOtherInfo(userBean);
            s.add(userBean.getId());
            return s;
        } catch (Exception e) {
            return s;
        }
    }

    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> updateAddress(@RequestBody AddressBean addressBean) {
        List<Long> s = new ArrayList<Long>();
        try {
            addressDelegate.updateAddress(addressBean);
            s.add(addressBean.getUser_id());
            return s;
        } catch (Exception e) {
            return s;
        }
    }
=======
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

>>>>>>> 36c0c129fcaeec63cd0c2c9d315c273bb7dee186
}
