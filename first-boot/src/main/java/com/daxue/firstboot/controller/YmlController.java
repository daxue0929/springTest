package com.daxue.firstboot.controller;

import com.daxue.firstboot.model.YamlModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daxue0929
 * @date 2020/08/12
 **/
@RestController
public class YmlController {

    @Autowired
    YamlModel yamlModel;

    @RequestMapping(value = "/yml")
    public String yml() {
        return yamlModel.toString();
    }

}
