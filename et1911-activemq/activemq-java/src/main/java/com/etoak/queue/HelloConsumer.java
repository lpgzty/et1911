package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloConsumer {

	public static void main(String[] args) throws Exception{
		//创键connectionFaction
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		//创建connection
		Connection connection = factory.createConnection();
		connection.start();
		//创建session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建Destination(消费来来源)
		Queue helloQueue = session.createQueue("hello3");
		//创建消费者
		MessageConsumer Consumer = session.createConsumer(helloQueue);
		//创建消息
		TextMessage text = (TextMessage)Consumer.receive();
		
		
		System.out.println(text.getText().toString());
		
		Consumer.close();
		session.close();
		connection.close();
		
	}

}
