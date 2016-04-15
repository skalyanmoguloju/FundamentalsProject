package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.AddressBean;
import com.fundamental.proj.model.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 4/4/16.
 */
@Component
public class AddressBeanMapper {

    public AddressBean mapAddressBean(Address address){
        ItemsBeanMapper itemsBeanMapper = new ItemsBeanMapper();
        AddressBean addressBean = new AddressBean();
        addressBean.setAddress_Id(address.getAddress_Id());
        addressBean.setCity(address.getCity());
        addressBean.setLine1(address.getLine1());
        addressBean.setLine2(address.getLine2());
        addressBean.setState(address.getState());
        addressBean.setUser_id(address.getUser_id());
        addressBean.setZip(address.getZip());
        return addressBean;
    }

    public Address mapBeanToAddress(AddressBean addressBean){
        ItemsBeanMapper itemsBeanMapper = new ItemsBeanMapper();
        Address address = new Address();
        address.setAddress_Id(addressBean.getAddress_Id());
        address.setCity(addressBean.getCity());
        address.setUser_id(addressBean.getUser_id());
        address.setLine1(addressBean.getLine1());
        address.setLine2(addressBean.getLine2());
        address.setState(addressBean.getState());
        address.setZip(addressBean.getZip());
        return address;
    }

    public List<AddressBean> mapAddressBean(List<Address> addresss)
    {
        List<AddressBean> addressBeans = new ArrayList<AddressBean>();
        for(Address address:addresss){
            addressBeans.add(mapAddressBean(address));
        }
        return addressBeans;
    }
}
