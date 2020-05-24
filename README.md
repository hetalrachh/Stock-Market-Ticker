# Stock-Market-Ticker
Stock market ticker which generates data after every 3 secs on an ActiveMQ queue and is consumed and shown on the UI.

The code consists of two applications,

**stock-market-ticker:** This is a maven based spring application which consists of the ActiveMQ configuration. It has a REST API which calls a Producer which produces messages to a persistent queue and a Consumer which consumes messages from this queue and returns it to the REST API. The REST API finally returns the data to the UI application in JSON format. 

**stock-price-ticker:** This is a ReactJS application which calls the REST API after every 3 seconds and displays the data returned by the REST API on the UI.

**Steps to run the applications locally:**

1. Start the ActiveMQ from the installation path e.g. C:\Software\apache-activemq-5.15.12-bin\apache-activemq-5.15.12\bin using the command "activemq start".

2. Build the spring application "stock-market-ticker" locally and run using commands "mvn clean install" and "mvn tomcat7:run" in the project directory.

3. Start the ReactJS UI application using command "npm start" in the project directory.

Some important notes-

1. The ActiveMQ web console can be accessed on localhost:8161/admin.
2. Run the ReactJS application locally on localhost:3000.


**Demo image:**

![](/stock-price-ticker/demo/stick-price-ticker.PNG)
