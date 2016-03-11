package com.fundamental.proj.controller;
import com.fundamental.proj.controller.bean.ItemsBean;
import com.fundamental.proj.controller.bean.RolesBean;
import com.fundamental.proj.controller.bean.SalesBean;
import com.fundamental.proj.delegate.ItemsDelegate;
import com.fundamental.proj.delegate.SalesDelegate;
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

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sai on 3/6/16.
 */
@Controller
public class UserController {

    @Autowired
    private ItemsDelegate itemsDelegate;

    @Autowired
    private SalesDelegate salesDelegate;

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
    public List<String> PurchaseItem(@RequestBody SalesBean salesBean) {
        //HIBERNETCALLS
        List<String> s = new LinkedList<String>();
        try {
            salesBean.setPrice(salesBean.getPrice()*salesBean.getQuantity());
           salesDelegate.addSale(salesBean);
            //String passwordToCompare = itemsDelegate.  .getUserPasswordWithEmail(userBean);
            return s;

        } catch (Exception e) {
            return s;
        }

    }


}
