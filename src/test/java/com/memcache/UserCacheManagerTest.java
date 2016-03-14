package com.memcache;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.models.User;

public class UserCacheManagerTest {
	
	static UserCacheManager instance;
	static User user1, user2, user3, user4, user5, user6;
	@BeforeClass
	public static void before() throws MalformedURLException {
		instance = UserCacheManager.getInstance();
		
		user1 = new User();
		user1.setId(1);
		user1.setLogin("abc");
		user1.setUrl(new URL("http://abc.com"));
		
		user2 = new User();
		user2.setId(2);
		user2.setLogin("def");
		user2.setUrl(new URL("http://abc.com"));
		
		user3 = new User();
		user3.setId(3);
		user3.setLogin("ghi");
		user3.setUrl(new URL("http://abc.com"));
		
		user4 = new User();
		user4.setId(4);
		user4.setLogin("jkl");
		user4.setUrl(new URL("http://abc.com"));
		
		user5 = new User();
		user5.setId(5);
		user5.setLogin("mno");
		user5.setUrl(new URL("http://abc.com"));
		
		user6 = new User();
		user6.setId(6);
		user6.setLogin("pqr");
		user6.setUrl(new URL("http://abc.com"));
		
		instance.clear();
	}
	
	@After
	public void after( ) {
		instance.clear();
	}
	
	@Test
	public void testGetCacheInstance() throws Exception {
		assertNotNull("cache instance should not be null", instance);
		assertEquals("Empty list should be returned", 0, instance.getLastFiveEntries().size());
	}
	
	@Test
	public void testInsertOneElementToCacheLastFive() throws Exception {
		instance.put(user1);
		List<User> lastFiveEntries = instance.getLastFiveEntries();
		assertEquals(1, lastFiveEntries.size());
	}
	
	@Test
	public void testInsertSixElementToCacheCheckLastFive() throws Exception {
		instance.put(user1);
		instance.put(user2);
		instance.put(user3);
		instance.put(user4);
		instance.put(user5);
		instance.put(user6);
		List<User> lastFiveEntries = instance.getLastFiveEntries();
		assertEquals(5, lastFiveEntries.size());
	}
	
	@Test
	public void testInsert100ElementToCacheCheckLastFive() throws Exception {
		
		for(int i=0;i<100;i++) {
			User u = new User();
			u.setId(i);
			u.setLogin("abc" + i);
			instance.put(u);
		}
		List<User> lastFiveEntries = instance.getLastFiveEntries();
		System.out.println(lastFiveEntries);
		assertEquals(5, lastFiveEntries.size());
	}

}
