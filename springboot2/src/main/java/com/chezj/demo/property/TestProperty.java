package com.chezj.demo.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: bangsun
 * @date: 2020/9/14 14:09
 */

@Data
@Component
@ConfigurationProperties(prefix = "testproperty")
public class TestProperty {
    private String testname;
    private String testpassword;
}
