import React, { Component } from "react";
import { Card, CardContent, Divider } from "@material-ui/core";
import "./Ticker.css";

class Ticker extends Component {
  render() {
    let {
      id,
      name,
      symbol,
      price,
      percent_change_1h,
      percent_change_24h,
    } = this.props.data;

    return (
      <li className="stock">
        <Card elevation={4}>
          <CardContent className={id}>
            <p className="stock-name">{name}</p>
            <p className="stock-symbol">({symbol})</p>
            <Divider />
            {/* + converts string to number */}
            <h1>{(+price).toFixed(2)}</h1>
            <p>{(+percent_change_1h).toFixed(2)}% 1hr</p>
            <p>{(+percent_change_24h).toFixed(2)}% 24hrs</p>
          </CardContent>
        </Card>
      </li>
    );
  }
}

export default Ticker;
