package com.fundamental.proj.repository;

import com.fundamental.proj.model.Address;
import com.fundamental.proj.model.Cart;
import com.fundamental.proj.model.Items;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Dao on 3/8/16.
 */

public class AddressRepositorySteps {

    @Mock
    private SessionFactory mockedSessionFactory;

    @Mock
    private Session mockedSession;

    @Mock
    private Query mockedQuery;

    @InjectMocks
    private AddressRepository addressRepository;

    private List<Address> expectedListAddress;

    @Given("^mock AddressRepository is initialized$")
    public void mock_addressrepository_is_initialized() throws Throwable {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(mockedSessionFactory, mockedSession, mockedQuery);
    }

    /************************************************/
    /*
     * Test updateAddress()
     */
    /***********************************************/

    @When("^updateAddress\\(\\) is called for AddressRepository$")
    public void updateaddress_is_called_for_AddressRepository() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.doNothing().when(mockedSession).saveOrUpdate(Mockito.any(Address.class));
    }

    @Then("^updateAddress has been called successfully for AddressRepository$")
    public void updateaddress_has_been_called_successfully_for_AddressRepository() throws Throwable {
        Address address = new Address();
        addressRepository.updateAddress(address);
        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).saveOrUpdate(address);
    }

    /************************************************/
    /*
     * Test getAddress()
     */
    /***********************************************/
    @Given("^expected list of addresses is initialized for AddressRepository$")
    public void expected_list_of_addresses_is_initialized_for_AddressRepository() throws Throwable {
        expectedListAddress = new ArrayList<Address>();
        expectedListAddress.add(new Address());
    }

    @When("^getAddress\\(\\) is called for AddressRepository$")
    public void getaddress_is_called_for_AddressRepository() throws Throwable {
        Mockito.when(mockedSessionFactory.getCurrentSession()).thenReturn(mockedSession);
        Mockito.when(mockedSession.createQuery("from Address where user_id=:uid")).thenReturn(mockedQuery);
        Mockito.when(mockedQuery.list()).thenReturn(expectedListAddress);
    }

    @Then("^a list of addresses is returned for getAddress in AddressRepository$")
    public void a_list_of_addresses_is_returned_for_getAddress_in_AddressRepository() throws Throwable {
        List<Address> actualList = addressRepository.getAddress(1L);
        Assert.assertEquals(actualList.size(), expectedListAddress.size());
        Assert.assertEquals(actualList.get(0), expectedListAddress.get(0));

        Mockito.verify(mockedSessionFactory).getCurrentSession();
        Mockito.verify(mockedSession).createQuery("from Address where user_id=:uid");
        Mockito.verify(mockedQuery).list();
    }

}
