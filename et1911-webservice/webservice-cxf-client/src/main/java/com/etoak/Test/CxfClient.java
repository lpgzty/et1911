package com.etoak.Test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Created by LPG on 2020-06-01.
 */
public class CxfClient {
    public static void main(String[] args) {
        // JaxWsProxyFactoryBean
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        // 设置wsdl地址
       // factory.setAddress("http://localhost:8000/hello?wsdl");

        // 设置服务接口
        //factory.setServiceClass(HelloService.class);

        // 创建远程服务代理
        //HelloService service = (HelloService)factory.create();
       // System.out.println(service);
        // 调用远程方法
       // System.out.println(service.sayHello("CXF"));
    }
}
