package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.MaterialIndentBean;
import com.fundamental.proj.controller.bean.SalesBean;
import com.fundamental.proj.mapper.MaterialIndentMapper;
import com.fundamental.proj.model.MaterialIndent;
import com.fundamental.proj.model.Sales;
import com.fundamental.proj.service.MaterialIndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 3/24/16.
 */
@Service
public class MaterialIndentDelegate {

    @Autowired
    private MaterialIndentService materialIndentService;

    @Autowired
    private MaterialIndentMapper materialIndentMapper;

    @Transactional
    public List<Long> addSale(MaterialIndentBean materialIndentBean, long address_id)
    {
        MaterialIndent materialIndent;
        materialIndent = materialIndentMapper.mapBeanToMaterialIndent(materialIndentBean);
        return materialIndentService.addSale(materialIndent, address_id);
    }
}
