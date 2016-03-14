package com.github;

import java.io.IOException;

import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.PagedSearchIterable;

public class GitHubClient {
	
	private GitHub github;
	
	public GitHubClient() throws IOException {
		github = GitHub.connectAnonymously();
	}
	
	public PagedSearchIterable<GHUser> getUserByLocation(String location) throws IOException {
		return github.searchUsers().location(location).list().withPageSize(5000);
	}
}
