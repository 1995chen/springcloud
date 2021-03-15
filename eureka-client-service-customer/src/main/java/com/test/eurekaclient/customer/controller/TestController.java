package com.test.eurekaclient.customer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.common.model.AppRes;
import com.test.eurekaclient.customer.service.remote.IProviderService;
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

    private final IProviderService IProviderService;

    public TestController(DiscoveryClient discoveryClient, IProviderService IProviderService) {
        this.discoveryClient = discoveryClient;
        this.IProviderService = IProviderService;
    }

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        log.info("this is customer");
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/hello/{applicationName}")
    public String sayHello(@PathVariable String applicationName) throws JsonProcessingException {
        AppRes res = IProviderService.getInstances(applicationName);
        log.info("res is {}", res);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(res);
    }
}
