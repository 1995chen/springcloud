package com.test.eurekaclient.customer.controller;

import com.test.common.model.AppRes;
import com.test.eurekaclient.customer.service.remote.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TestController {

    private final DiscoveryClient discoveryClient;

    private final ProviderService providerService;

    public TestController(DiscoveryClient discoveryClient, ProviderService providerService) {
        this.discoveryClient = discoveryClient;
        this.providerService = providerService;
    }

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        log.info("this is provider-01");
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/hello/{applicationName}")
    public String sayHello(@PathVariable String applicationName) {
        AppRes res = providerService.getInstances(applicationName);
        log.info("res is {}", res);
        return "customer say Hello!";
    }
}
