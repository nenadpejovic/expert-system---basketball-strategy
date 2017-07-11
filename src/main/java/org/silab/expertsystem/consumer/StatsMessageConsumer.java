package org.silab.expertsystem.consumer;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class StatsMessageConsumer implements Runnable{


	@Override
	public void run() {
		try {
		 ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	        Connection connection = connectionFactory.createConnection();
	        connection.start();

	        Session session = connection.createSession(false,
	                Session.AUTO_ACKNOWLEDGE);

	        Destination destination = session.createQueue("test.queque");

	        MessageConsumer consumer = session.createConsumer(destination);

	        MessageListener listener = new MessageListener() {

			@Override
			public void onMessage(Message message) {
                try {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        System.out.println("Received message"
                                + textMessage.getText() + "'");
                    }
                } catch (JMSException e) {
                    System.out.println("Caught:" + e);
                    e.printStackTrace();
                }
				
			}
	        };
	    	consumer.setMessageListener(listener);
	    	System.in.read();
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
