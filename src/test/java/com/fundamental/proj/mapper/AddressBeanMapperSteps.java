package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.AddressBean;
import com.fundamental.proj.controller.bean.CartBean;
import com.fundamental.proj.controller.bean.ItemsBean;
import com.fundamental.proj.model.Address;
import com.fundamental.proj.model.Cart;
import com.fundamental.proj.model.Items;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */
public class AddressBeanMapperSteps {

    private AddressBeanMapper addressBeanMapper;

    private AddressBean expectedAddressBean;
    private AddressBean actualAddressBean;
    private Address expectedAddress;
    private Address actualAddress;
    private List<Address> addressList;
    private List<AddressBean> actualListAdress;

    /************************************************/
    /*
     * Test mapItemBean()
     */
    /***********************************************/
    @Given("^expected address is initialized for AddressBeanMapper$")
    public void expected_address_is_initialized_for_AddressBeanMapper() throws Throwable {
        expectedAddress = new Address();
        expectedAddress.setUser_id(1L);
        expectedAddress.setAddress_Id(1L);
        expectedAddress.setCity("city");
        expectedAddress.setZip(52240);
        expectedAddress.setState("State");
        expectedAddress.setLine1("line 1");
        expectedAddress.setLine2("line 2");
    }

    @When("^mapItemBean is called for AddressBeanMapper$")
    public void mapitembean_is_called_for_AddressBeanMapper() throws Throwable {
        addressBeanMapper = new AddressBeanMapper();
        actualAddressBean = addressBeanMapper.mapAddressBean(expectedAddress);
    }

    @Then("^mapItemBean returns a addressBean$")
    public void mapitembean_returns_a_addressBean() throws Throwable {
        Assert.assertEquals(actualAddressBean.getZip(), expectedAddress.getZip());
        Assert.assertEquals(actualAddressBean.getState(), expectedAddress.getState());
        Assert.assertEquals(actualAddressBean.getCity(), expectedAddress.getCity());
        Assert.assertEquals(actualAddressBean.getLine1(), expectedAddress.getLine1());
        Assert.assertEquals(actualAddressBean.getLine2(), expectedAddress.getLine2());
        Assert.assertEquals(actualAddressBean.getAddress_Id(), expectedAddress.getAddress_Id());
        Assert.assertEquals(actualAddressBean.getUser_id(), expectedAddress.getUser_id());
    }

    @Given("^expected addressbean is initialized for AddressBeanMapper$")
    public void expected_addressbean_is_initialized_for_AddressBeanMapper() throws Throwable {
        expectedAddressBean = new AddressBean();
        expectedAddressBean.setUser_id(1L);
        expectedAddressBean.setAddress_Id(1L);
        expectedAddressBean.setCity("city");
        expectedAddressBean.setZip(52240);
        expectedAddressBean.setState("State");
        expectedAddressBean.setLine1("line 1");
        expectedAddressBean.setLine2("line 2");
    }

    @When("^mapBeanToAddress is called$")
    public void mapbeantoaddress_is_called() throws Throwable {
        addressBeanMapper = new AddressBeanMapper();
        actualAddress = addressBeanMapper.mapBeanToAddress(expectedAddressBean);
    }

    @Then("^mapBeanToAddress returns an address$")
    public void mapbeantoaddress_returns_an_address() throws Throwable {
        Assert.assertEquals(actualAddress.getZip(), expectedAddressBean.getZip());
        Assert.assertEquals(actualAddress.getState(), expectedAddressBean.getState());
        Assert.assertEquals(actualAddress.getCity(), expectedAddressBean.getCity());
        Assert.assertEquals(actualAddress.getLine1(), expectedAddressBean.getLine1());
        Assert.assertEquals(actualAddress.getLine2(), expectedAddressBean.getLine2());
        Assert.assertEquals(actualAddress.getUser_id(), expectedAddressBean.getUser_id());
        Assert.assertEquals(actualAddress.getAddress_Id(), expectedAddressBean.getAddress_Id());
    }

    @Given("^expected list of addresses is initialized for AddressBeanMapper$")
    public void expected_list_of_addresses_is_initialized_for_AddressBeanMapper() throws Throwable {
        expectedAddress = new Address();
        expectedAddress.setUser_id(1L);
        expectedAddress.setAddress_Id(1L);
        expectedAddress.setCity("city");
        expectedAddress.setZip(52240);
        expectedAddress.setState("State");
        expectedAddress.setLine1("line 1");
        expectedAddress.setLine2("line 2");
        addressList = new ArrayList<Address>();
        addressList.add(expectedAddress);
    }

    @When("^mapItemsBeanList is called for AddressBeanMapper$")
    public void mapitemsbeanlist_is_called_for_AddressBeanMapper() throws Throwable {
        addressBeanMapper = new AddressBeanMapper();
        actualListAdress = addressBeanMapper.mapAddressBean(addressList);
    }

    @Then("^mapItemsBeanList returns some addressBeans$")
    public void mapitemsbeanlist_returns_some_addressBeans() throws Throwable {
        Assert.assertEquals(actualListAdress.size(), addressList.size());
        actualAddressBean = actualListAdress.get(0);
        expectedAddress = addressList.get(0);

        Assert.assertEquals(actualAddressBean.getZip(), expectedAddress.getZip());
        Assert.assertEquals(actualAddressBean.getState(), expectedAddress.getState());
        Assert.assertEquals(actualAddressBean.getCity(), expectedAddress.getCity());
        Assert.assertEquals(actualAddressBean.getLine1(), expectedAddress.getLine1());
        Assert.assertEquals(actualAddressBean.getLine2(), expectedAddress.getLine2());
        Assert.assertEquals(actualAddressBean.getAddress_Id(), expectedAddress.getAddress_Id());
        Assert.assertEquals(actualAddressBean.getUser_id(), expectedAddress.getUser_id());
    }
}
