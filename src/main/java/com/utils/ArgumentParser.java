package com.utils;

public class ArgumentParser {
	public static String parseArguments(String[] args) {
		if (args.length == 1 && args[0] != null) {
			System.out.println("Location passed is " + args[0]);
			return args[0];
		} else {
			System.out.println("Please pass on the location !!!");
			return "";
		}
	}
}
