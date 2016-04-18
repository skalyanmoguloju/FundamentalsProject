package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.ReturnBean;
import com.fundamental.proj.mapper.ReturnBeanMapper;
import com.fundamental.proj.model.Orders;
import com.fundamental.proj.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 4/16/16.
 */
@Service
public class ReturnDelegate {

    @Autowired
    private ReturnService returnService;

    @Autowired
    private ReturnBeanMapper returnBeanMapper;

    @Transactional
    public String returnRequest(ReturnBean returnBean)
    {
        return returnService.returnRequest(returnBeanMapper.mapBeanToReturn(returnBean));
    }

    @Transactional
    public List<ReturnBean> getRecRetOrders(long user_id)
    {
        return returnBeanMapper.mapReturnBean(returnService.getRecRetOrders(user_id));
    }

    @Transactional
    public List<ReturnBean> getRetOrders(long user_id)
    {
        return returnBeanMapper.mapReturnBean(returnService.getRetOrders(user_id));
    }
}
