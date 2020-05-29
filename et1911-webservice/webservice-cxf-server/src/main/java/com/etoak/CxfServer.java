package com.etoak;

import com.etoak.service.HelloService;
import com.etoak.service.impl.HelloServiceImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Created by LPG on 2020-05-29.
 */
public class CxfServer {
    public static void main(String[] args) {
        //创建jaxWSServerFactory
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();

        //设置wsdl地址
        factory.setAddress("http://localhost:8090/hello");

        factory.setServiceClass(HelloService.class);

        factory.setServiceBean(new HelloServiceImpl());

        Server server  = factory.create();
        server.start();
        System.out.println("Server start");


    }
}
