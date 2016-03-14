package com.service;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.User;
import com.publisher.Publisher;

public class PublisherService {

	private Publisher publisher;
	private ObjectMapper mapper;
	public PublisherService(Publisher publisher) {
		this.publisher = publisher;
		mapper = new ObjectMapper();
	}

	public boolean sendMessage(User user, String topic) throws IOException {
        return  publisher.send(topic, mapper.writeValueAsString(user));
	}

}
