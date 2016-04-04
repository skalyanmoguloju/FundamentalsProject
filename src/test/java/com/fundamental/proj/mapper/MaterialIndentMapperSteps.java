package com.fundamental.proj.mapper;


import com.fundamental.proj.controller.bean.MaterialIndentBean;
import com.fundamental.proj.model.MaterialIndent;
import com.fundamental.proj.model.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
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

        expectedMaterialIndentBean = materialIndentMapper.mapItemBean(materialIndent);
    }

    @Then("^mapItemBean returns a materialIndentBean$")
    public void mapitembean_returns_a_materialIndentBean() throws Throwable {

    }

    /************************************************/
    /*
     * Test mapBeanToMaterialIndent()
     */

    /***********************************************/

    @When("^mapBeanToMaterialIndent is called for MaterialIndentMapper$")
    public void mapbeantomaterialindent_is_called_for_MaterialIndentMapper() throws Throwable {
        materialIndentBean = new MaterialIndentBean();

        expectedMaterialIndent = materialIndentMapper.mapBeanToMaterialIndent(materialIndentBean);
    }

    @Then("^mapBeanToMaterialIndent returns a MaterialIndent$")
    public void mapbeantomaterialindent_returns_a_MaterialIndent() throws Throwable {

    }

    /************************************************/
    /*
     * Test mapItemBean(List)
     */

    /***********************************************/
    @When("^mapItemBeanList is called for MaterialIndentMapper$")
    public void mapitembeanlist_is_called_for_MaterialIndentMapper() throws Throwable {
        listMaterialIndents = new ArrayList<MaterialIndent>();

        listMaterialIndentBean = materialIndentMapper.mapItemBean(listMaterialIndents);
    }

    @Then("^mapItemBeanList returns a list of materialIndentBeans$")
    public void mapitembeanlist_returns_a_list_of_materialIndentBeans() throws Throwable {

    }
}
