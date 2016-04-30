package com.fundamental.proj.service;

import com.fundamental.proj.model.Address;
import com.fundamental.proj.model.Cart;
import com.fundamental.proj.model.Items;
import com.fundamental.proj.repository.AddressRepository;
import com.fundamental.proj.repository.CartRepository;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hibernate.search.indexes.serialization.javaserialization.impl.Add;
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

public class AddressServiceSteps {

    @Mock
    private AddressRepository mockedAddressRepository;

    @InjectMocks
    private AddressService addressService;

    private List<Address> expectedListAddress;
    private List<Long> expectedListIds;

    @Given("^mock AddressService is initialized$")
    public void mock_addressservice_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedAddressRepository);
    }

    /************************************************/
    /*
     * Test updateAddress()
     */
    /***********************************************/
    @When("^updateAddress\\(\\) is called$")
    public void updateaddress_is_called() throws Throwable {
        Mockito.doNothing().when(mockedAddressRepository).updateAddress(Mockito.any(Address.class));
    }

    @Then("^updateAddress has been called successfully called$")
    public void updateaddress_has_been_called_successfully_called() throws Throwable {
        Address address = new Address();
        addressService.updateAddress(address);
        Mockito.verify(mockedAddressRepository).updateAddress(address);
    }

    /************************************************/
    /*
     * Test getAddress()
     */
    /***********************************************/
    @And("^expected list of addresses is initialized$")
    public void expected_list_of_addresses_is_initialized() throws Throwable {
        expectedListAddress = new ArrayList<Address>();
        expectedListAddress.add(new Address());
    }

    @When("^getAddress\\(\\) is called$")
    public void getaddress_is_called() throws Throwable {
        Mockito.when(mockedAddressRepository.getAddress(Mockito.anyLong())).thenReturn(expectedListAddress);
    }

    @Then("^a list of addresses is returned for getAddress$")
    public void a_list_of_addresses_is_returned_for_getAddress() throws Throwable {
        List<Address> actualListAddress = addressService.getAddress(1L);
        Assert.assertEquals(actualListAddress.size(), expectedListAddress.size());
        Assert.assertEquals(actualListAddress.get(0), expectedListAddress.get(0));
        Mockito.verify(mockedAddressRepository).getAddress(1L);
    }

    @Given("^expected list of ids is initialized for addAddress$")
    public void expected_list_of_ids_is_initialized_for_addAddress() throws Throwable {
        expectedListIds = new ArrayList<Long>();
        expectedListIds.add(1L);
    }

    @When("^addAddress\\(\\) is called$")
    public void addaddress_is_called() throws Throwable {
        Mockito.when(mockedAddressRepository.addAddress(Mockito.any(Address.class))).thenReturn(expectedListIds);
    }

    @Then("^a list of ids is returned for addAddress$")
    public void a_list_of_ids_is_returned_for_addAddress() throws Throwable {
        List<Long> result = addressService.addAddress(new Address());
        Assert.assertEquals(result.size(), expectedListIds.size());
        Assert.assertEquals(result.get(0), expectedListIds.get(0));
    }

}
