package com.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArgumentsParserTest {

	@Test
	public void testDoNotPassValidArguments() throws Exception {
		String[] args = new String[0];
		String location = ArgumentParser.parseArguments(args);
		assertEquals("Empty string should be passed on no argument", "", location);
	}
	
	@Test
	public void testPassValidArguments() throws Exception {
		String[] args = {"dubai"};
		String location = ArgumentParser.parseArguments(args);
		assertEquals("Empty string should be passed on argument", "dubai", location);
	}
	
	@Test
	public void testPassMoreArguments() throws Exception {
		String[] args = {"dubai", "india"};
		String location = ArgumentParser.parseArguments(args);
		assertEquals("Request for correct location if more arguments are passed", "", location);
	}
}
