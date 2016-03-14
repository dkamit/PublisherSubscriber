package com.service;

import java.io.IOException;

import com.consumer.Subscriber;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.User;

public class SubscriberService {
	
	private Subscriber subscriber;
	private ObjectMapper mapper;
	public SubscriberService(Subscriber subscriber, String topic) {
		this.subscriber = subscriber;
		this.subscriber.subscribe(topic);
		this.mapper = new ObjectMapper();
	}

	public User receiveMessage() throws IOException {
		String address = subscriber.getString();
		String jsonUser = subscriber.getString();
		return mapper.readValue(jsonUser, User.class);
	}

}
