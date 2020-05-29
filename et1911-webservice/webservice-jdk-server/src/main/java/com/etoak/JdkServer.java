package com.etoak;

import com.etoak.service.impl.HelloServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by LPG on 2020-05-29.
 */
public class JdkServer {

    public static void main(String[] args) {

        //webservice的一个服务
        //两个参数 : 1.发布的地址(wsdl的地址)   2.暴露的服务
        Endpoint.publish("http://localhost:8080/hello",new HelloServiceImpl());
        System.out.println("Service Start");
    }
}
