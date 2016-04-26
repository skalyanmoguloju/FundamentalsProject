package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.AddressBean;
import com.fundamental.proj.controller.bean.CartBean;
import com.fundamental.proj.mapper.AddressBeanMapper;
import com.fundamental.proj.model.Address;
import com.fundamental.proj.model.Cart;
import com.fundamental.proj.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 4/4/16.
 */
@Service
public class AddressDelegate {
    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressBeanMapper addressBeanMapper;

    @Transactional
    public void updateAddress(AddressBean  addressBean1)
    {
        Address address = addressBeanMapper.mapBeanToAddress(addressBean1);
        addressService.updateAddress(address);
    }

    @Transactional
    public List<AddressBean> getAddress(long user_id)
    {
        return addressBeanMapper.mapAddressBean(addressService.getAddress(user_id));
    }

}
