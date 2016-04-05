package com.fundamental.proj.service;

import com.fundamental.proj.model.Address;
import com.fundamental.proj.model.Cart;
import com.fundamental.proj.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 4/4/16.
 */
@Service
public class AddressService{
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public void updateAddress(Address address)
    {
        addressRepository.updateAddress(address);
    }

    @Transactional
    public List<Address> getAddress(long user_id)
    {
        return addressRepository.getAddress(user_id);
    }
}
