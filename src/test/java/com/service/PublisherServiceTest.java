package com.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URL;

import org.junit.Test;

import com.models.User;
import com.publisher.Publisher;

public class PublisherServiceTest {
	@Test
	public void testPublishMessage() throws Exception {
		User user = new User();
		user.setId(1);
		user.setLogin("xyz");
		user.setUrl(new URL("http://abc.com"));
		Publisher publisher = mock(Publisher.class);
		when(publisher.send("a", "{\"login\":\"xyz\",\"url\":\"http://abc.com\",\"id\":1}")).thenReturn(true);
		PublisherService ps = new PublisherService(publisher);
		boolean sendMessage = ps.sendMessage(user, "a");
		assertTrue("Message should be sent successfully", sendMessage);
	}
}
