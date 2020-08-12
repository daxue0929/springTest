package com.daxue.firstboot.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author daxue0929
 * @date 2020/08/12
 **/
@Data
@Component
@ConfigurationProperties(prefix = "yaml")
public class YamlModel {
    private String str;

    private int num;

    private double dNum;

    private Date birth;
}
