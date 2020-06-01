package com.etoak.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;

/**
 * Created by LPG on 2020-06-01.
 */
public class AuthlnInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

    public AuthlnInterceptor() {
        super(Phase.PREPARE_SEND);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        Header header = message.getHeader(new QName("et1911"));

        if(header != null ){
            Element et1911 = (Element)header.getObject();

            NodeList nameNodelList = et1911.getElementsByTagName("name");
            String name = nameNodelList.item(0).getTextContent();

            NodeList passwordNodelList = et1911.getElementsByTagName("password");
            String password = passwordNodelList.item(0).getTextContent();

            if("et1911".equals(name) && "123456".equals(password)){
                System.out.println("验证通过");
                return;
            }
        }

        System.out.println("验证失败");
        throw new Fault(new IllegalArgumentException("用户名或密码错误"));

    }
}
