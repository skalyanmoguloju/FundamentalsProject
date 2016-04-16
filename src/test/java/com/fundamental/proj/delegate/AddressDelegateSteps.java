package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.AddressBean;
import com.fundamental.proj.controller.bean.CartBean;
import com.fundamental.proj.controller.bean.ItemsBean;
import com.fundamental.proj.mapper.AddressBeanMapper;
import com.fundamental.proj.mapper.CartBeanMapper;
import com.fundamental.proj.model.Address;
import com.fundamental.proj.model.Cart;
import com.fundamental.proj.service.AddressService;
import com.fundamental.proj.service.CartService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class AddressDelegateSteps {

    @Mock
    private AddressService mockedAddressService;

    @Mock
    private AddressBeanMapper mockedAddressBeanMapper;

    @Mock
    private Address mockedAddress;

    @Mock
    private List<Address> mockedAddressList;

    @InjectMocks
    private AddressDelegate addressDelegate;

    private List<AddressBean> expectedListAddressBean;

    @Given("^mock AddressDelegate is initialized$")
    public void mock_addressDelegate_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedAddressBeanMapper, mockedAddressService, mockedAddress, mockedAddressList);
    }

    /************************************************/
    /*
     * Test updateAddress()
     */
    /***********************************************/

    @When("^updateAddress\\(\\) is called for AddressDelegate$")
    public void updateaddress_is_called_for_AddressDelegate() throws Throwable {
        Mockito.when(mockedAddressBeanMapper.mapBeanToAddress(Mockito.any(AddressBean.class))).thenReturn(mockedAddress);
        Mockito.doNothing().when(mockedAddressService).updateAddress(mockedAddress);
    }

    @Then("^updateAddress has been called successfully for AddressDelegate$")
    public void updateaddress_has_been_called_successfully_for_AddressDelegate() throws Throwable {
        AddressBean addressBean = new AddressBean();
        addressDelegate.updateAddress(addressBean);
        Mockito.verify(mockedAddressBeanMapper).mapBeanToAddress(addressBean);
        Mockito.verify(mockedAddressService).updateAddress(mockedAddress);
    }

    /************************************************/
    /*
     * Test getAddress()
     */
    /***********************************************/
    @Given("^expected list of addressBeans is initialized$")
    public void expected_list_of_addressBeans_is_initialized() throws Throwable {
        expectedListAddressBean = new ArrayList<AddressBean>();
        expectedListAddressBean.add(new AddressBean());
    }

    @When("^getAddress\\(\\) is called for AddressDelegate$")
    public void getaddress_is_called_for_AddressDelegate() throws Throwable {
        Mockito.when(mockedAddressService.getAddress(Mockito.anyLong())).thenReturn(mockedAddressList);
        Mockito.when(mockedAddressBeanMapper.mapAddressBean(mockedAddressList)).thenReturn(expectedListAddressBean);
    }

    @Then("^a list of addressBeans is returned for getAddress$")
    public void a_list_of_addressBeans_is_returned_for_getAddress() throws Throwable {
        List<AddressBean> actualList = addressDelegate.getAddress(1L);
        Assert.assertEquals(actualList.size(), expectedListAddressBean.size());
        Assert.assertEquals(actualList.get(0), expectedListAddressBean.get(0));
        Mockito.verify(mockedAddressService).getAddress(1L);
        Mockito.verify(mockedAddressBeanMapper).mapAddressBean(mockedAddressList);
    }

}
