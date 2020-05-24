package com.ticker.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class StockMarketTickerStorage {

	private String tataSymbol;
	private float tataPrice;
	private double change_1hr_tata;
	private double change_24hr_tata;

	private String ciplaSymbol;
	private float ciplaPrice;
	private double change_1hr_cipla;
	private double change_24hr_cipla;

	private String asianSymbol;
	private float asianPrice;
	private double change_1hr_asian;
	private double change_24hr_asian;

	public String getAsianSymbol() {
		return asianSymbol;
	}

	public void setAsianSymbol(String asianSymbol) {
		this.asianSymbol = asianSymbol;
	}

	public float getAsianPrice() {
		return asianPrice;
	}

	public void setAsianPrice(float asianPrice) {
		this.asianPrice = asianPrice;
	}

	public double getChange_1hr_asian() {
		return change_1hr_asian;
	}

	public void setChange_1hr_asian(double change_1hr_asian) {
		this.change_1hr_asian = change_1hr_asian;
	}

	public double getChange_24hr_asian() {
		return change_24hr_asian;
	}

	public void setChange_24hr_asian(double change_24hr_asian) {
		this.change_24hr_asian = change_24hr_asian;
	}

	public String getCiplaSymbol() {
		return ciplaSymbol;
	}

	public void setCiplaSymbol(String ciplaSymbol) {
		this.ciplaSymbol = ciplaSymbol;
	}

	public float getCiplaPrice() {
		return ciplaPrice;
	}

	public void setCiplaPrice(float ciplaPrice) {
		this.ciplaPrice = ciplaPrice;
	}

	public double getChange_1hr_cipla() {
		return change_1hr_cipla;
	}

	public void setChange_1hr_cipla(double change_1hr_cipla) {
		this.change_1hr_cipla = change_1hr_cipla;
	}

	public double getChange_24hr_cipla() {
		return change_24hr_cipla;
	}

	public void setChange_24hr_cipla(double change_24hr_cipla) {
		this.change_24hr_cipla = change_24hr_cipla;
	}

	public String getTataSymbol() {
		return tataSymbol;
	}

	public void setTataSymbol(String tataSymbol) {
		this.tataSymbol = tataSymbol;
	}

	public float getTataPrice() {
		return tataPrice;
	}

	public void setTataPrice(float tataPrice) {
		this.tataPrice = tataPrice;
	}

	public double getChange_1hr_tata() {
		return change_1hr_tata;
	}

	public void setChange_1hr_tata(double change_1hr_tata) {
		this.change_1hr_tata = change_1hr_tata;
	}

	public double getChange_24hr_tata() {
		return change_24hr_tata;
	}

	public void setChange_24hr_tata(double change_24hr_tata) {
		this.change_24hr_tata = change_24hr_tata;
	}

	@Override
	public String toString() {
		return "StockMarketTickerStorage [tataSymbol=" + tataSymbol + ", tataPrice=" + tataPrice + ", change_1hr_tata="
				+ change_1hr_tata + ", change_24hr_tata=" + change_24hr_tata + ", ciplaSymbol=" + ciplaSymbol
				+ ", ciplaPrice=" + ciplaPrice + ", change_1hr_cipla=" + change_1hr_cipla + ", change_24hr_cipla="
				+ change_24hr_cipla + ", asianPrice=" + asianPrice + ", change_1hr_asian=" + change_1hr_asian
				+ ", change_24hr_asian=" + change_24hr_asian + "]";
	}

}
