package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.ReturnBean;
import com.fundamental.proj.model.Returns;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 4/16/16.
 */
@Component
public class ReturnBeanMapper {

    public ReturnBean mapReturnBean(Returns returns){
        OrdersBeanMapper ordersBeanMapper = new OrdersBeanMapper();
        ReturnBean returnBean = new ReturnBean();
        returnBean.setDescription(returns.getDescription());
        returnBean.setResolution(returns.getResolution());
        returnBean.setOrdersBean(ordersBeanMapper.mapOrdersBean(returns.getOrders()));
        returnBean.setReturn_count(returns.getReturn_count());
        returnBean.setReturn_id(returns.getReturn_id());
        return returnBean;
    }

    public Returns mapBeanToReturn(ReturnBean returnBean){
        OrdersBeanMapper ordersBeanMapper = new OrdersBeanMapper();
        Returns returns = new Returns();
        returns.setDescription(returnBean.getDescription());
        returns.setOrders(ordersBeanMapper.mapBeanToOrders(returnBean.getOrdersBean()));
        returns.setResolution(returnBean.getResolution());
        returns.setReturn_id(returnBean.getReturn_id());
        returns.setReturn_count(returnBean.getReturn_count());
        return returns;
    }

    public List<ReturnBean> mapReturnBean(List<Returns> returnss)
    {
        List<ReturnBean> returnBeans = new ArrayList<ReturnBean>();
        for(Returns returns:returnss){
            returnBeans.add(mapReturnBean(returns));
        }
        return returnBeans;
    }
}
