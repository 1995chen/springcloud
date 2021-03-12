package com.test.eurekaclient.customer.service.remote;

import com.test.common.model.AppRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "provider-service")
public interface ProviderService {

    @GetMapping("/service-instances/{applicationName}")
    AppRes getInstances(@PathVariable String applicationName);

}
