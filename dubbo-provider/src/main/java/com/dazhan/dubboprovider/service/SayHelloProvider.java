package com.dazhan.dubboprovider.service;

import com.dazhan.dubboapi.service.SayHello;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author zhangliunian
 * <p>
 * createTime: 2020-03-21 12:34 上午
 * description:
 */
@Service(version = "${dubbo.service.version}") // 使用@Service 注解暴露接口，要注意这个注解是dubbo的，不是spring的
public class SayHelloProvider implements SayHello {

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s]: Hello, %s", serviceName, name);
    }
}
