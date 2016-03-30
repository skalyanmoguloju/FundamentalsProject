Feature: Check SalesBeanMapper

  #
  # Check mapSalesBean()
  #
  Scenario: mapSalesBean returns salesBean
    Given SalesBeanMapper is initialized
    When mapSalesBean is called for SalesBeanMapper
    Then mapSalesBean returns a salesBean

  #
  # Check mapBeanToSales()
  #
  Scenario: mapBeanToSales returns sales
    Given SalesBeanMapper is initialized
    When mapBeanToSales is called for RolesBeanMapper
    Then mapBeanToSales returns a sales

  #
  # Check mapSalesBean(List)
  #
  Scenario: mapSalesBean(List) returns list of salesBean
    Given SalesBeanMapper is initialized
    When mapSalesBeanList is called for SalesBeanMapper
    Then mapSalesBeanList returns a list of salesBean