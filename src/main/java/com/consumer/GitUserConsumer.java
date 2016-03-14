package com.consumer;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

import com.memcache.UserCacheManager;
import com.models.User;
import com.monitor.MonitorTimer;
import com.service.SubscriberService;

public class GitUserConsumer {
	private static final int FIVE_SECONDS = 5 * 1000;
	private static final String PORT = "5563";
	private static final String TOPIC = "a";

	public static void main(String[] args) throws IOException {
		Context context = ZMQ.context(1);
        Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://*:" + PORT);
        TimerTask task = new MonitorTimer();
        Timer timer = new Timer();
        timer.schedule(task, FIVE_SECONDS, FIVE_SECONDS);
        process(subscriber);
        
	}

	private static void process(Socket subscriber) throws IOException {
		SubscriberService se = new SubscriberService(new Subscriber(subscriber), TOPIC);
        UserCacheManager instance = UserCacheManager.getInstance();
        while(true) {
        	User user = se.receiveMessage();
        	instance.put(user);
        }
	}
}
