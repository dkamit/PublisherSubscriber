package com.consumer;

import org.zeromq.ZMQ.Socket;

public class Subscriber {

	private Socket subscriber;
	public Subscriber(Socket subscriber) {
		this.subscriber = subscriber;
	}
	
	public void subscribe(String topic) {
		subscriber.subscribe(topic.getBytes());
	}
	
	public String getString() {
		return subscriber.recvStr();
	}
}
