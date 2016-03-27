package com.fundamental.proj.controller;
import com.fundamental.proj.controller.bean.*;
import com.fundamental.proj.delegate.*;
import com.fundamental.proj.model.MaterialIndent;
import com.fundamental.proj.model.Orders;
import com.fundamental.proj.util.EmailVerification;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

    @RequestMapping(value = "/add manager")
    public String addManagerPage() {
        return "WEB-INF/views/home/addManager";
    }

    @RequestMapping(value = "/addManager", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> addNewManager() {
        return userDelegate.addNewManager();
    }

    @RequestMapping(value = "/add item")
    public String addItemPage() {
        return "WEB-INF/views/home/addItem";
    }


    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    @ResponseBody
    public List<String> AddeItem(@RequestBody ItemsBean itemsBean) {
        //HIBERNETCALLS
        List<String> s = new LinkedList<String>();
        try {
            itemsBean.setDate(Calendar.getInstance().getTime());
            itemsBean.setSold_count(0);
            itemsDelegate.addItem(itemsBean);
            //String passwordToCompare = itemsDelegate.  .getUserPasswordWithEmail(userBean);
            return s;

        } catch (Exception e) {
            return s;
        }

    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseBody
    public List<String> PurchaseItem(@RequestBody MaterialIndentBean materialIndentBean) {
        //HIBERNETCALLS
        List<String> s = new LinkedList<String>();
        try {
            Date date = new Date();
            materialIndentBean.setIndent_date(date);
            materialIndentDelegate.addSale(materialIndentBean);
            //String passwordToCompare = itemsDelegate.  .getUserPasswordWithEmail(userBean);
            return s;

        } catch (Exception e) {
            return s;
        }

    }

    @RequestMapping(value = "/cart")
    public String CartItem() {
        return "WEB-INF/views/home/cart";

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

}
