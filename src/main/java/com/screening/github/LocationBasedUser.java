package com.screening.github;

import java.io.IOException;

import org.kohsuke.github.GitHub;

public class LocationBasedUser {
	
	private GitHub git;
	
	public LocationBasedUser() throws IOException {
		git = GitHub.connectAnonymously(); 
		
	}
}
