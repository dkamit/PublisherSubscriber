package com.models;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URL;

import org.junit.Test;
import org.kohsuke.github.GHUser;

public class UserMapperTest {
	@Test
	public void testIfEmptyGHUserIsPassed() throws Exception {
		GHUser user = new GHUser();
		User mappedUser = UserMapper.map(user);
		assertEquals("No Login should be provided", null, mappedUser.getLogin());
		assertEquals("No URL should be provided", null, mappedUser.getUrl());
		assertEquals("Id should be 0", 0, mappedUser.getId());
	}
	
	@Test
	public void testValidGHUserIsPassed() throws Exception {
		GHUser user = mock(GHUser.class);
		when(user.getId()).thenReturn(1);
		when(user.getUrl()).thenReturn(new URL("http", "abcd", "def"));
		when(user.getLogin()).thenReturn("xyz");
		User mappedUser = UserMapper.map(user);
		assertEquals("Login should be provided", "xyz", mappedUser.getLogin());
		assertEquals("Id should be 1", 1, mappedUser.getId());
		assertEquals("URL should be provided", new URL("http", "abcd", "def"), mappedUser.getUrl());
		
	}
}
