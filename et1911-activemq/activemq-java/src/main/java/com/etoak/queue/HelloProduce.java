package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloProduce {

	public static void main(String[] args) throws Exception {
		//创建ConnectionFactory(用户名,密码,链接地址)
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		
		//通过ConnectionFactory创建connection
		Connection connection = factory.createConnection();
		connection.start();
		//通过Connection创建session
		Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		
		//通过session创建
		Queue helloQueue = session.createQueue("hello3");
		
		MessageProducer producer = session.createProducer(helloQueue);
		
		TextMessage msg = session.createTextMessage("这是第一个Hello Word消息队列");
		
		producer.send(msg);
		
		producer.close();
		session.close();
		connection.close();
		System.out.println("ok");
				
				
	}

}






























