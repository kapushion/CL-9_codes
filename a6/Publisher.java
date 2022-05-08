//============================================================================
//
//  Name        : Publisher.java
//  Author      : Sachin Vijaykumar Kunte
//  Copyright   : Copyright ©2019 by Sachin Kunte All rights reserved.
//  Description : A Java program for a Publisher implementation  
//  contact     : kuntesv@gmail.com
//
//============================================================================

package pubsub;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
// JMS messages are sent and received using a Session. We will
// create here a non-transactional session object. If you want
// to use transactions you should set the first parameter to 'true'
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("Mumbai indians");
		MessageProducer producer = session.createProducer(topic);
// We will send a small text message saying 'Hello'
		TextMessage message = session.createTextMessage();
		message.setText("200/5");
// Here we are sending the message!
		producer.send(message);
		System.out.println("Sent message '" + message.getText() + "'");
		connection.close();
		
		ConnectionFactory connectionFactory1 = new ActiveMQConnectionFactory(url);
		Connection connection1 = connectionFactory1.createConnection();
		connection1.start();
// JMS messages are sent and received using a Session. We will
// create here a non-transactional session object. If you want
// to use transactions you should set the first parameter to 'true'
		Session session1 = connection1.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic1 = session1.createTopic("CSK");
		MessageProducer producer1 = session1.createProducer(topic1);
// We will send a small text message saying 'Hello'
		TextMessage message1 = session1.createTextMessage();
		message1.setText("190/5");
// Here we are sending the message!
		producer1.send(message);
		System.out.println("Sent message '" + message1.getText() + "'");
		connection.close();
	}
}