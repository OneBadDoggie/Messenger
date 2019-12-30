package io.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import io.javabrains.messenger.models.Message;
import io.javabrains.messenger.models.Profile;

public class MyDatabase {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	
}
