package com.etoak.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloPublisher {

	public static void main(String[] args) throws Exception{
		//1.建connectionFactory
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		//2.创建Connection,并调用start方法
		Connection connection = factory.createConnection();
		connection.start();
		//3.创建Session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//4.通过session创建队列
		Topic topic = session.createTopic("topic");
		//5.通过session创建生产者
		MessageProducer producer = session.createProducer(topic);
		//6.通过session创建消息
		MapMessage msg = session.createMapMessage();
		msg.setString("name", "topic msg");
		msg.setInt("id",1);
		
		//7.发送消息
		
		producer.send(msg);
		producer.close();
		session.close();
		connection.close();
		
		
	}

}
