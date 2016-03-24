package com.fundamental.proj.mapper;

import com.fundamental.proj.controller.bean.MaterialIndentBean;
import com.fundamental.proj.model.MaterialIndent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sai on 3/24/16.
 */
@Component
public class MaterialIndentMapper {
    public MaterialIndentBean mapItemBean(MaterialIndent materialIndent){
        MaterialIndentBean materialIndentBean = new MaterialIndentBean();
        materialIndentBean.setCard_cvv(materialIndent.getCard_cvv());
        materialIndentBean.setCard_exp(materialIndent.getCard_exp());
        materialIndentBean.setCard_number(materialIndent.getCard_number());
        materialIndentBean.setIndent_id(materialIndent.getIndent_id());
        materialIndentBean.setPrice(materialIndent.getPrice());
        materialIndentBean.setPurchase_id(materialIndent.getPurchase_id());
        materialIndentBean.setUser_id(materialIndent.getUser_id());

        return materialIndentBean;
    }

    public MaterialIndent mapBeanToMaterialIndent(MaterialIndentBean materialIndentBean){
        MaterialIndent materialIndent = new MaterialIndent();
        materialIndent.setCard_cvv(materialIndentBean.getCard_cvv());
        materialIndent.setCard_exp(materialIndentBean.getCard_exp());
        materialIndent.setCard_number(materialIndentBean.getCard_number());
        materialIndent.setIndent_id(materialIndentBean.getIndent_id());
        materialIndent.setPrice(materialIndentBean.getPrice());
        materialIndent.setPurchase_id(materialIndentBean.getPurchase_id());
        materialIndent.setUser_id(materialIndentBean.getUser_id());
        return materialIndent;
    }

    public List<MaterialIndentBean> mapItemBean(List<MaterialIndent> materialIndentes)
    {
        List<MaterialIndentBean> materialIndentBeans = new ArrayList<MaterialIndentBean>();
        for(MaterialIndent materialIndent:materialIndentes){
            materialIndentBeans.add((mapItemBean(materialIndent)));
        }
        return materialIndentBeans;
    }
}
