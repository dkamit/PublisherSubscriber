package com.publisher;

import org.zeromq.ZMQ.Socket;

public class Publisher {
	
	private Socket publisher;
	
	public Publisher(Socket publisher) {
		this.publisher = publisher;
	}
	
	public boolean send(String topic, String data) {
		publisher.sendMore(topic.getBytes());
		return publisher.send(data);
	}
}
