//package com.fundamental.proj.mapper;
//
//import com.fundamental.proj.controller.bean.CartBean;
//import com.fundamental.proj.controller.bean.ItemsBean;
//import com.fundamental.proj.model.Cart;
//import cucumber.api.java.en.Given;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
///**
// * Created by Daniel Dao on 3/8/16.
// */
//public class SalesBeanMapperSteps {
//
//    @Mock
//    private ItemsBeanMapper mockedItemsBeanMapper;
//
//    @Mock
//    private ItemsBean mockedItemsBean;
//
//    @InjectMocks
//    private CartBeanMapper cartBeanMapper;
//
//    private CartBean expectedCartBean;
//    private ItemsBean expectedItemsBean;
//    private Cart expectedCart;
//
//    @Given("^mock CartBeanMapper is initialized$")
//    public void mock_CartBeanMapper_is_initialized() throws Throwable {
//        MockitoAnnotations.initMocks(this);
//        Mockito.reset(mockedItemsBeanMapper, mockedItemsBean);
//    }
//
//    /************************************************/
//    /*
//     * Test mapItemBean()
//     */
//    /***********************************************/
//
//}
