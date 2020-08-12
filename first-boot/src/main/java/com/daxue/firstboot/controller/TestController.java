package com.daxue.firstboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daxue0929
 * @date 2020/08/11
 **/
@RestController
public class TestController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
