# PublisherSubscriber

- ZeroMQ based publisher and consumer distrbuted system.

- Uses maven to build the project.
>>`mvn clean package`

- publisher can be started as

>>`java -jar target/publisher-jar-with-dependencies.jar dubai`

- subscriber can be started as 

>>`java -jar target/consumer-jar-with-dependencies.jar`

##Notes:
  Since we use anonymous user there is a limit in number of users in the response is only 1000.
  So I am publishing the one user ever second so we can check the working of the subscriber end.

