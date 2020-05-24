package com.ticker.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ticker.demo.bean.StockMarketTickerStorage;
import com.ticker.demo.producer.StockMarketTickerProducer;

@RestController
public class StockMarketTickerController {

	@Autowired
	private StockMarketTickerProducer producer;

	@Autowired
	private StockMarketTickerStorage storage;

	/*This method calls the producer which produces message to a queue*/
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/getStockUpdates", method = RequestMethod.GET)
	public String getUpdates() throws InterruptedException {
	
		// Make call to ActiveMQ producer that will produce the updates
		producer.sendMessage();
		Gson gson = new Gson();
		System.out.println("Converted json " + gson.toJson(storage).toString());
		return gson.toJson(storage).toString();
	}

	/*This method initializes an arraylist with the stock market symbols*/
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/initializeSymbols", method = RequestMethod.GET)
	public void initializeSymbols() {
		//initialize stock ticker symbols
		producer.initializeSymbols();
	}

}
