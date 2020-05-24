import React from "react";
import "./App.css";
import { PAGE_HEADING } from "./constants";
import Tickers from "../src/components/Tickers/Tickers";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <p>{PAGE_HEADING}</p>
      </header>
      <Tickers />
    </div>
  );
}

export default App;
