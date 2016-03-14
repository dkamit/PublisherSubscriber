package com.memcache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.models.User;

public class UserCacheManager {
	private static UserCacheManager instance;
	private static Object monitor = new Object();
	private List<User> userList = new ArrayList<User>();
	private Map<String, User> cache = Collections.synchronizedMap(new LinkedHashMap<String, User>());

	private UserCacheManager() {
	}

	public void put(User value) {
		put(value.getLogin(), value);
	}
	
	public int size() {
		return cache.size();
	}
	
	public void put(String cacheKey, User value) {
		User put = cache.put(cacheKey, value);
		if(userList.size() >= 5 && put == null) {
			userList.remove(0);
		}
		if(put == null) {
			userList.add(value);
		}
		
	}
	
	public List<User> getLastFiveEntries() {
		return userList;
	}

	public Object get(String cacheKey) {
		return cache.get(cacheKey);
	}

	public void clear(String cacheKey) {
		cache.put(cacheKey, null);
	}

	public void clear() {
		cache.clear();
		userList.clear();
	}

	public static UserCacheManager getInstance() {
		if (instance == null) {
			synchronized (monitor) {
				if (instance == null) {
					instance = new UserCacheManager();
				}
			}
		}
		return instance;
	}

}
