package com.test.eurekaclient.provider01.controller;

import com.test.common.model.AppRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class TestController {

    private final DiscoveryClient discoveryClient;

    public TestController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping("/service-instances/{applicationName}")
    public AppRes serviceInstancesByApplicationName(
            @PathVariable String applicationName) throws InterruptedException {
        // 随机sleep
        Random random = new Random();
        int x = random.nextInt(8);
        log.info("sleep {}", x);
        TimeUnit.SECONDS.sleep(x);
//        if (applicationName.equals("test")) {
//            throw new RuntimeException("throw ex !!!");
//        }
        log.info("this is provider-01");
        List<ServiceInstance> instanceList = this.discoveryClient.getInstances(applicationName);
        AppRes appRes = new AppRes();
        appRes.setReplyName("provider-01");
        List<String> serviceList = new ArrayList<>();
        for (ServiceInstance instance : instanceList) {
            serviceList.add(String.format("%s:%s", instance.getHost(), instance.getPort()));
        }
        appRes.setServiceList(serviceList);
        return appRes;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "provider-01 say Hello!";
    }
}
