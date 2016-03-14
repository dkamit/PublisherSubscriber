package com.monitor;

import java.util.TimerTask;

import com.memcache.UserCacheManager;
import com.models.User;

public class MonitorTimer extends TimerTask {

	@Override
	public void run() {
		UserCacheManager instance = UserCacheManager.getInstance();
		System.out.println("Total Users received till now : " + instance.size() );
		System.out.println("Last 5 added users : " );
		for (User user : instance.getLastFiveEntries()) {
			System.out.println(user);
		}
	}

}
