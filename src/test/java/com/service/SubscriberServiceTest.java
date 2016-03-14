package com.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URL;

import org.junit.Test;

import com.consumer.Subscriber;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.User;

public class SubscriberServiceTest {
	@Test
	public void testSubscriberService() throws Exception {
		Subscriber subscriber = mock(Subscriber.class);
		User user = new User();
		user.setId(1);
		user.setLogin("xyz");
		user.setUrl(new URL("http://abc.com"));
		ObjectMapper mapper = new ObjectMapper();
		when(subscriber.getString()).thenReturn("a", mapper.writeValueAsString(user));
		SubscriberService service = new SubscriberService(subscriber, "a");
		User receiveMessage = service.receiveMessage();
		assertEquals("Proper user is not got", receiveMessage.getId(), 1);
	}
}
