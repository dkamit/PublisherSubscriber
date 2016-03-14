package com.models;

import org.kohsuke.github.GHUser;

public class UserMapper {
	public static User map(GHUser ghuser) {
		User user = new User();
		user.setId(ghuser.getId());
		user.setLogin(ghuser.getLogin());
		user.setUrl(ghuser.getUrl());
		return user;
	}
}
