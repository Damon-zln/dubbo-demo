package com.dazhan.dubboconsumer.controller;

import com.dazhan.dubboapi.service.SayHello;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangliunian
 * <p>
 * createTime: 2020-03-21 12:40 上午
 * description:
 */
@RestController
@RequestMapping("test")
public class SayHelloConsumer {
    // Dubbo远程调用注解
    @Reference(version = "${dubbo.service.version}")
    private SayHello sayHello;

    @RequestMapping(value = "v1", method = RequestMethod.GET)
    public String getResult() {
        return sayHello.sayHello("dubbo+nacos");
    }
}
