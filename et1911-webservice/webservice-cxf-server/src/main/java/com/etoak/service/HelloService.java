package com.etoak.service;
import javax.jws.WebService;

/**
 * Created by LPG on 2020-05-29.
 */

@WebService(serviceName = "HelloServiceWS",
        portName = "HelloServiceWSPort")
public interface HelloService {

    String sayHello(String name);
}
