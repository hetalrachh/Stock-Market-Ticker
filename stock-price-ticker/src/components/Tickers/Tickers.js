import React, { Component } from "react";
import "./Tickers.css";
import Ticker from "../Ticker/Ticker";
import { INFO_UPDATE } from "../../constants";
import axios from "axios";

class Tickers extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [
        {
          id: "tatamotors",
          name: "Tata Motors Ltd.",
          symbol: "TATAMOTORS",
          price: "1",
          percent_change_1h: "0",
          percent_change_24h: "0",
        },
        {
          id: "cipla",
          name: "Cipla Ltd.",
          symbol: "CIPLA",
          price: "1",
          percent_change_1h: "0",
          percent_change_24h: "0",
        },
        {
          id: "asianpaints",
          name: "Asian Paints Ltd.",
          symbol: "ASIANPAINT",
          price: "1",
          percent_change_1h: "0",
          percent_change_24h: "0",
        },
      ],
    };
    this.callStockUpdatesAPI = this.callStockUpdatesAPI.bind(this);
  }

  componentDidMount() {
    this.initializeSymbols();
    this.interval = setInterval(this.callStockUpdatesAPI, 3000);
  }

  componentWillUnmount() {
    clearInterval(this.interval);
  }

  async initializeSymbols() {
    await axios
      .get("http://localhost:8080/stock-market-ticker/initializeSymbols", {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": "GET",
        },
      })
      .then((res) => {
        console.log("Response received", res.data);
      })
      .catch((error) => {
        console.log("Error occured while", error);
      });
  }

  async callStockUpdatesAPI() {
    await axios
      .get("http://localhost:8080/stock-market-ticker/getStockUpdates", {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": "GET",
        },
      })
      .then((response) => {
        console.log("Response received ", response.data);
        let oldData_tata = { ...this.state.data };
        oldData_tata[0].price = response.data.tataPrice;
        oldData_tata[0].percent_change_1h = response.data.change_1hr_tata;
        oldData_tata[0].percent_change_24h = response.data.change_24hr_tata;
        this.setState({ data: oldData_tata }, () => {});

        let oldData_cipla = { ...this.state.data };
        oldData_cipla[1].price = response.data.ciplaPrice;
        oldData_cipla[1].percent_change_1h = response.data.change_1hr_cipla;
        oldData_cipla[1].percent_change_24h = response.data.change_24hr_cipla;
        this.setState({ data: oldData_cipla }, () => {});

        let oldData_asian = { ...this.state.data };
        oldData_asian[2].price = response.data.asianPrice;
        oldData_asian[2].percent_change_1h = response.data.change_1hr_asian;
        oldData_asian[2].percent_change_24h = response.data.change_24hr_asian;
        this.setState({ data: oldData_asian }, () => {});
      })
      .catch((error) => {
        console.log("Error occured while receiving updates", error);
      });
  }

  render() {
    return (
      <div>
        <ul className="tickers">
          <Ticker data={this.state.data[0]} id="0" />
          <Ticker data={this.state.data[1]} id="1" />
          <Ticker data={this.state.data[2]} id="2" />
        </ul>
        <p className="footer">{INFO_UPDATE}</p>
      </div>
    );
  }
}

export default Tickers;
