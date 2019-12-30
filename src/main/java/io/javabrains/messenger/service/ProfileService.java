package io.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.javabrains.messenger.database.MyDatabase;
import io.javabrains.messenger.models.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = MyDatabase.getProfiles();
	
	public ProfileService() {
		profiles.put("obd", new Profile(1L, "obd", "Bill", "B"));
		profiles.put("doggo", new Profile(2L, "doggo", "Charlie", "Dog"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());	
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profile.setCreated(new Date());
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public void deleteProfile(String profileName) {
		profiles.remove(profileName);
	}
}
