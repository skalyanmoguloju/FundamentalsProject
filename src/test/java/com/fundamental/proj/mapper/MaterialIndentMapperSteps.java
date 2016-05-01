package com.fundamental.proj.mapper;


import com.fundamental.proj.controller.bean.AddressBean;
import com.fundamental.proj.controller.bean.MaterialIndentBean;
import com.fundamental.proj.controller.bean.UserBean;
import com.fundamental.proj.model.Address;
import com.fundamental.proj.model.MaterialIndent;
import com.fundamental.proj.model.User;
import cucumber.api.java.cs.A;
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
public class MaterialIndentMapperSteps {

    private MaterialIndentMapper materialIndentMapper;

    private MaterialIndent materialIndent;
    private MaterialIndent expectedMaterialIndent;

    private MaterialIndentBean materialIndentBean;
    private MaterialIndentBean expectedMaterialIndentBean;

    private List<MaterialIndent> listMaterialIndents;
    private List<MaterialIndentBean> listMaterialIndentBean;

    /************************************************/
    /*
     * Test mapItemBean()
     */

    /***********************************************/
    @Given("^MaterialIndentMapper is initialized$")
    public void materialindentmapper_is_initialized() throws Throwable {
        materialIndentMapper = new MaterialIndentMapper();
    }

    @When("^mapItemBean is called for MaterialIndentMapper$")
    public void mapitembean_is_called_for_MaterialIndentMapper() throws Throwable {
        materialIndent = new MaterialIndent();
        materialIndent.setAddress(new Address());
        materialIndent.setCard_cvv("CBB");
        materialIndent.setCard_exp("exp");
        materialIndent.setCard_number("number");
        materialIndent.setIndent_date(new Date());
        materialIndent.setIndent_id(1L);
        materialIndent.setPrice(3);
        materialIndent.setUser(new User());
        expectedMaterialIndentBean = materialIndentMapper.mapItemBean(materialIndent);
    }

    @Then("^mapItemBean returns a materialIndentBean$")
    public void mapitembean_returns_a_materialIndentBean() throws Throwable {
        Assert.assertEquals(expectedMaterialIndentBean.getCard_cvv(), materialIndent.getCard_cvv());
        Assert.assertEquals(expectedMaterialIndentBean.getCard_exp(), materialIndent.getCard_exp());
        Assert.assertEquals(expectedMaterialIndentBean.getCard_number(), materialIndent.getCard_number());
        Assert.assertEquals(expectedMaterialIndentBean.getIndent_date(), materialIndent.getIndent_date());
        Assert.assertEquals(expectedMaterialIndentBean.getIndent_id(), materialIndent.getIndent_id());
        Assert.assertEquals(expectedMaterialIndentBean.getPrice(), materialIndent.getPrice(), 1E-15);
    }

    /************************************************/
    /*
     * Test mapBeanToMaterialIndent()
     */

    /***********************************************/

    @When("^mapBeanToMaterialIndent is called for MaterialIndentMapper$")
    public void mapbeantomaterialindent_is_called_for_MaterialIndentMapper() throws Throwable {
        materialIndentBean = new MaterialIndentBean();
        materialIndentBean.setCard_cvv("CBB");
        materialIndentBean.setCard_exp("exp");
        materialIndentBean.setCard_number("number");
        materialIndentBean.setIndent_date(new Date());
        materialIndentBean.setIndent_id(1L);
        materialIndentBean.setPrice(3);
        materialIndentBean.setAddressBean(new AddressBean());
        materialIndentBean.setUserBean(new UserBean());
        expectedMaterialIndent = materialIndentMapper.mapBeanToMaterialIndent(materialIndentBean);
    }

    @Then("^mapBeanToMaterialIndent returns a MaterialIndent$")
    public void mapbeantomaterialindent_returns_a_MaterialIndent() throws Throwable {
        Assert.assertEquals(expectedMaterialIndent.getCard_cvv(), materialIndentBean.getCard_cvv());
        Assert.assertEquals(expectedMaterialIndent.getCard_exp(), materialIndentBean.getCard_exp());
        Assert.assertEquals(expectedMaterialIndent.getCard_number(), materialIndentBean.getCard_number());
        Assert.assertEquals(expectedMaterialIndent.getIndent_date(), materialIndentBean.getIndent_date());
        Assert.assertEquals(expectedMaterialIndent.getIndent_id(), materialIndentBean.getIndent_id());
        Assert.assertEquals(expectedMaterialIndent.getPrice(), materialIndentBean.getPrice(), 1E-14);
    }

    /************************************************/
    /*
     * Test mapItemBean(List)
     */

    /***********************************************/
    @When("^mapItemBeanList is called for MaterialIndentMapper$")
    public void mapitembeanlist_is_called_for_MaterialIndentMapper() throws Throwable {
        listMaterialIndents = new ArrayList<MaterialIndent>();
        materialIndent = new MaterialIndent();
        materialIndent.setAddress(new Address());
        materialIndent.setCard_cvv("CBB");
        materialIndent.setCard_exp("exp");
        materialIndent.setCard_number("number");
        materialIndent.setIndent_date(new Date());
        materialIndent.setIndent_id(1L);
        materialIndent.setPrice(3);
        materialIndent.setUser(new User());
        listMaterialIndents.add(materialIndent);
        listMaterialIndentBean = materialIndentMapper.mapItemBean(listMaterialIndents);
    }

    @Then("^mapItemBeanList returns a list of materialIndentBeans$")
    public void mapitembeanlist_returns_a_list_of_materialIndentBeans() throws Throwable {
        Assert.assertEquals(listMaterialIndentBean.size(), listMaterialIndents.size());
    }
}
