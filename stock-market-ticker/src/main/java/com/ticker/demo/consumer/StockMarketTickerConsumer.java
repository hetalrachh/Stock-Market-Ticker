package com.ticker.demo.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ticker.demo.bean.StockMarketTickerStorage;

@Component
public class StockMarketTickerConsumer implements MessageListener {

	@Autowired
	private StockMarketTickerStorage storage;

	@Override
	public void onMessage(Message message) {
		System.out.println("Received tata message " + message);
		try {
			String symbol = message.getStringProperty("tataSymbol");
			float price = message.getFloatProperty("tataPrice");
			double change_1hr = message.getDoubleProperty("change_1hr_tata");
			double change_24hr = message.getDoubleProperty("change_24hr_tata");
			System.out.println("Received " + symbol + " " + price);
			storage.setTataPrice(price);
			storage.setTataSymbol(symbol);
			storage.setChange_1hr_tata(change_1hr);
			storage.setChange_24hr_tata(change_24hr);

			symbol = message.getStringProperty("ciplaSymbol");
			price = message.getFloatProperty("ciplaPrice");
			change_1hr = message.getDoubleProperty("change_1hr_cipla");
			change_24hr = message.getDoubleProperty("change_24hr_cipla");
			System.out.println("Received " + symbol + " " + price);
			storage.setCiplaPrice(price);
			storage.setCiplaSymbol(symbol);
			storage.setChange_1hr_cipla(change_1hr);
			storage.setChange_24hr_cipla(change_24hr);

			symbol = message.getStringProperty("asianSymbol");
			price = message.getFloatProperty("asianPrice");
			change_1hr = message.getDoubleProperty("change_1hr_asian");
			change_24hr = message.getDoubleProperty("change_24hr_asian");
			System.out.println("Received " + symbol + " " + price);
			storage.setAsianPrice(price);
			storage.setAsianSymbol(symbol);
			storage.setChange_1hr_asian(change_1hr);
			storage.setChange_24hr_asian(change_24hr);

		} catch (JMSException e) {

			System.out.println("Exception cooured while consuming message " + e.getMessage());
		}

	}

}