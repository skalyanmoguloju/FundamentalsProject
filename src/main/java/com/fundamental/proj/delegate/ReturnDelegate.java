package com.fundamental.proj.delegate;

import com.fundamental.proj.controller.bean.ReturnBean;
import com.fundamental.proj.mapper.ReturnBeanMapper;
import com.fundamental.proj.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sai on 4/16/16.
 */
@Service
public class ReturnDelegate {

    @Autowired
    private ReturnService returnService;

    @Autowired
    private ReturnBeanMapper returnBeanMapper;

    @Transactional
    public String returnRequest(ReturnBean returnBean)
    {
        return returnService.returnRequest(returnBeanMapper.mapBeanToReturn(returnBean));
    }
}
