package com.bd.mybatis.dbservice;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bd.mybatis.bean.UserProfile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mybatis-spring-context-test.xml" })
public class UserProfileDBServiceIT {

	@Autowired
	private UserProfileDBService userProfileDBService;

	@Test
	public void selectAllUserProfileTest() {
		try {
			List<UserProfile> userProfileList = userProfileDBService.selectAllUserProfile();
			System.out.println("userProfileList selected: " + userProfileList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectUserProfileByIDTest() {
		try {
			UserProfile userProfile = userProfileDBService.selectUserProfileByID(101);
			System.out.println("UserProfile selected: " + userProfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createUserProfileTest() {
		try {
			int rows = userProfileDBService.createUserProfile(createMockUserProfile());
			System.out.println("rows created: " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateUserProfileTest() {
		try {
			int rows = userProfileDBService.updateUserProfile(createMockUserProfile2());
			System.out.println("rows updated: " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteUserProfileTest() {
		try {
			int rows = userProfileDBService.deleteUserProfile(111);
			System.out.println("rows deleted: " + rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private UserProfile createMockUserProfile() {
		Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());
		UserProfile userProfile = new UserProfile();
		userProfile.setCreatedTS(ts);
		userProfile.setEmailID("Frida@gmail.com");
		userProfile.setLanguages("Hindi, English");
		userProfile.setLivesIn("Orlando, FL");
		userProfile.setName("Frida Pinto");
		userProfile.setProfileID(111);
		userProfile.setRelationshipStatus("Single");
		userProfile.setSex("female");
		return userProfile;
	}

	private UserProfile createMockUserProfile2() {
		Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());
		UserProfile userProfile = new UserProfile();
		userProfile.setCreatedTS(ts);
		userProfile.setEmailID("Selena@gmail.com");
		userProfile.setLanguages("Spanish, English");
		userProfile.setLivesIn("Los Angeles, CA");
		userProfile.setName("Selena Gomez");
		userProfile.setProfileID(111);
		userProfile.setRelationshipStatus("Single");
		userProfile.setSex("female");
		return userProfile;
	}

}
