package com.publisher;

import java.io.IOException;

import org.kohsuke.github.GHUser;
import org.kohsuke.github.PagedSearchIterable;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

import com.github.GitHubClient;
import com.models.User;
import com.models.UserMapper;
import com.service.PublisherService;
import com.utils.ArgumentParser;

public class GitUserPublisher {
	
	private static final String PORT = "5563";
	private static final String TOPIC = "a";

	public static void main(String[] args) throws  Exception {
		String location = ArgumentParser.parseArguments(args);
		if(location == "") {
			System.exit(1);
		}
		GitUserPublisher userPub = new GitUserPublisher();
		
		Context context = ZMQ.context(1);
        Socket publisher = context.socket(ZMQ.PUB);
        publisher.bind("tcp://localhost:" + PORT);
        PublisherService ps = new PublisherService(new Publisher(publisher));
        userPub.process(location, new GitHubClient(), ps);
	}

	private void process(String location, GitHubClient gitHubClient, PublisherService ps) throws IOException, InterruptedException {
		PagedSearchIterable<GHUser> userByLocation = gitHubClient.getUserByLocation(location);
		for (GHUser ghUser : userByLocation) {
			User user = UserMapper.map(ghUser);
			ps.sendMessage(user, TOPIC);
			Thread.sleep(1000);
		}
	}
}
