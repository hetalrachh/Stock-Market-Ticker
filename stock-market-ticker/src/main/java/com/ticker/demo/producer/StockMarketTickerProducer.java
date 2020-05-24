package com.ticker.demo.producer;

import java.util.ArrayList;
import java.util.Random;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class StockMarketTickerProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	private final ArrayList<String> symbols = new ArrayList<String>(3);
	private final Random pricePicker = new Random();

	/* This method initializes symbols */
	public void initializeSymbols() {
		symbols.add("TATAMOTORS");
		symbols.add("CIPLA");
		symbols.add("ASIANPAINT");
	}

	/*This method sends message to the queue using JMS template*/
	public void sendMessage() throws InterruptedException {

		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {

				try {

					Message message = session.createTextMessage();
					message.setStringProperty("tataSymbol", symbols.get(0));
					message.setFloatProperty("tataPrice", pricePicker.nextFloat() * 10);
					message.setDoubleProperty("change_1hr_tata", pricePicker.nextDouble() * 50);
					message.setDoubleProperty("change_24hr_tata", pricePicker.nextDouble() * 100);

					message.setStringProperty("ciplaSymbol", symbols.get(1));
					message.setFloatProperty("ciplaPrice", pricePicker.nextFloat() * 10);
					message.setDoubleProperty("change_1hr_cipla", pricePicker.nextDouble() * 50);
					message.setDoubleProperty("change_24hr_cipla", pricePicker.nextDouble() * 100);

					message.setStringProperty("asianSymbol", symbols.get(1));
					message.setFloatProperty("asianPrice", pricePicker.nextFloat() * 10);
					message.setDoubleProperty("change_1hr_asian", pricePicker.nextDouble() * 50);
					message.setDoubleProperty("change_24hr_asian", pricePicker.nextDouble() * 100);

					return message;

				} catch (JMSException e) {

					System.out.println("Exception occured while producing message " + e.getMessage());
				}
				return null;

			}

		});

	}

}
