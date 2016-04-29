package com.fundamental.proj.controller;
import com.fundamental.proj.controller.bean.*;
import com.fundamental.proj.delegate.*;
import com.fundamental.proj.mapper.AddressBeanMapper;
import com.fundamental.proj.util.EmailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private AddressBeanMapper addressBeanMapper = new AddressBeanMapper();

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

    @RequestMapping(value = "/catList", method = RequestMethod.POST)
    @ResponseBody
    public List<String> getAllCatgs() {
        //HIBERNETCALLS
        List<String> s = itemsDelegate.getAllCatgs();
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

    @RequestMapping(value = "/manage users")
    public String addManagerPage() {
        return "WEB-INF/views/home/manageUsers";
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

    @RequestMapping(value = "/listNewManagers", method = RequestMethod.POST)
    @ResponseBody
    public List<UserBean> getAllNewManagers() {
        return userDelegate.getAllNewManagers();
    }

    @RequestMapping(value = "/approveManager", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> approveManager(@RequestBody long user_id) {
        List<Long> s = new ArrayList<Long>();
        try {
            userDelegate.approveManager(user_id);
            s.add(user_id);
            return s;
        } catch (Exception e) {
            return s;
        }
    }

    @RequestMapping(value = "/declineManager", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> declineManager(@RequestBody long user_id) {
        List<Long> s = new ArrayList<Long>();
        try {
            userDelegate.declineManager(user_id);
            s.add(user_id);
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
    public List<Long> saveUser(@RequestBody UserBean userBean1) {
        List<Long> s = new LinkedList<Long>();
        userBean = userBean1;
        return s;
    }

    @RequestMapping(value = "/order2", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> saveAddress(@RequestBody AddressBean addressBean1) {
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

            //Date date = new Date();
            //materialIndentBean.setIndent_date(date);

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
            //Date date = new Date();
            //materialIndentBean.setIndent_date(date);
            EmailNotification ev = new EmailNotification();
            ev.sendEmailOrderConfirmation(email, materialIndentBean, cartBeans);

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
    public List<ItemsBean> getSearchResultItems(@RequestBody ItemsBean itemsBean) {
        String searchTerm = itemsBean.getItem_name();
        String cat = itemsBean.getCategory();

        List<ItemsBean> s = itemsDelegate.getAllItemsContainingSearchTerm(searchTerm,cat);
        return s;
    }
    @RequestMapping(value = "/catgResults", method = RequestMethod.POST)
    @ResponseBody
    public List<ItemsBean> getCatgResultItems(@RequestBody ItemsBean itemsBean) {
        List<ItemsBean> s = itemsDelegate.getAllCatItemsContainingSearchTerm(itemsBean.getCategory());

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

    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    @ResponseBody
    public List<String> updateAddress(@RequestBody AddressBean addressBean) {
        List<String> s = new LinkedList<String>();
        try {
            addressDelegate.updateAddress(addressBean);
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

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    @ResponseBody
    public List<AddressBean> newAddress(@RequestBody AddressBean addressBean1) {
        List<AddressBean> s = new LinkedList<AddressBean>();
        List<Long> id = addressDelegate.addAddress(addressBean1);
        addressBean1.setAddress_Id(id.get(0));
        s.add(addressBean1);
        return s;
    }

    @RequestMapping(value = "/allorders", method = RequestMethod.POST)
    @ResponseBody
    public List<OrdersBean> getAllOrders(@RequestBody UserBean userBean) {
        //HIBERNETCALLS
        return ordersDelegate.getAllOrderss(userBean.getId());
    }

    @RequestMapping(value = "/groupOrdersByOrderNumber", method = RequestMethod.POST)
    @ResponseBody
    public List<List<OrdersBean>> groupOrdersByOrderNumber(@RequestBody OrdersBean[] ordersBeanList) {
        //HIBERNETCALLS
        List<List<OrdersBean>> ordersBeanLists = new ArrayList<List<OrdersBean>>();
        for (OrdersBean ordersBean : ordersBeanList) {
            if (ordersBeanLists.size() == 0) {
                List<OrdersBean> listOrderBean = new ArrayList<OrdersBean>();
                listOrderBean.add(ordersBean);
                ordersBeanLists.add(listOrderBean);
            } else {
                long indent_id = ordersBean.getMaterialIndentBean().getIndent_id();
                long order_id = ordersBean.getOrder_id();
                for (int x = 0; x < ordersBeanLists.size(); x++) {
                    OrdersBean ordersBeanCompared = ordersBeanLists.get(x).get(0);
                    if (indent_id == ordersBeanCompared.getMaterialIndentBean().getIndent_id() && order_id != ordersBeanCompared.getOrder_id()) {
                        ordersBeanLists.get(x).add(ordersBean);
                        break;
                    } else if (x == (ordersBeanLists.size() - 1)) {
                        List<OrdersBean> listOrderBean = new ArrayList<OrdersBean>();
                        listOrderBean.add(ordersBean);
                        ordersBeanLists.add(listOrderBean);
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

    @RequestMapping(value = "/updateShippingAddress", method = RequestMethod.POST)
    @ResponseBody
    public List<Long> updateShippingAddress(@RequestBody AddressBean addressBean1) {
        List<Long> s = new ArrayList<Long>();
        addressDelegate.updateAddress(addressBean1);
        return s;
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
    @RequestMapping(value = "/recvretorders", method = RequestMethod.POST)
    @ResponseBody
    public List<ReturnBean> getRecReturnedOrders(@RequestBody UserBean userBean) {
        //HIBERNETCALLS
        return returnDelegate.getRecRetOrders(userBean.getId());
    }

    @RequestMapping(value = "/retorders", method = RequestMethod.POST)
    @ResponseBody
    public List<ReturnBean> getReturnedOrders(@RequestBody UserBean userBean) {
        //HIBERNETCALLS
        return returnDelegate.getRetOrders(userBean.getId());
    }
}

