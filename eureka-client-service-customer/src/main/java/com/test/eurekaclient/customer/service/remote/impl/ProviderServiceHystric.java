package com.test.eurekaclient.customer.service.remote.impl;

import com.test.common.model.AppRes;
import com.test.eurekaclient.customer.service.remote.IProviderService;
import org.springframework.stereotype.Service;


@Service
public class ProviderServiceHystric implements IProviderService {

    @Override
    public AppRes getInstances(String applicationName) {
        AppRes appRes = new AppRes();
        appRes.setStatus(500);
        appRes.setMessage("调用失败，服务被降级");
        return appRes;
    }
}
