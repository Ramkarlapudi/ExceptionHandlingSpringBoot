package com.ramkarlapudi.exceptionhandling.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ramkarlapudi.exceptionhandling.entity.UserProfileEntity;
import com.ramkarlapudi.exceptionhandling.exceptions.UploadProfileException;
import com.ramkarlapudi.exceptionhandling.exceptions.UserExceptions;
import com.ramkarlapudi.exceptionhandling.repository.UserProfileRepo;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserProfileRepo userProfileRepo;

	@Override
	public ArrayList<UserProfileEntity> getAllUsers() {
		ArrayList<UserProfileEntity> usersList = (ArrayList<UserProfileEntity>) userProfileRepo.findAll();
		return usersList;
	}

	@Override
	public Optional<UserProfileEntity> getUserById(int id) {
		Optional<UserProfileEntity> user = userProfileRepo.findById(id);
		try {
			if (!user.isPresent())
				throw new UserExceptions("User id" + id);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;

	}

	public Optional<UserProfileEntity> getUserBYname(String userName) {
		Optional<UserProfileEntity> username = Optional.of(userProfileRepo.findByUserName(userName));
		return username;

	}

	public UserProfileEntity uploadUser(UserProfileEntity userProfileEntity) {

		if (userProfileEntity == null || userProfileEntity.getUsername() == null
				|| userProfileEntity.getUsername() == "" || userProfileEntity.getPasscode() == null
				|| userProfileEntity.getPasscode() == "")
			throw new UploadProfileException("Fill all the mandatory fields like username ,passcode ");
		UserProfileEntity byuser = userProfileRepo.findByUserName(userProfileEntity.getUsername());
		if (byuser != null) {
			byuser.setFirstname(userProfileEntity.getFirstname());
			byuser.setLastname(userProfileEntity.getLastname());
			byuser.setPasscode(userProfileEntity.getPasscode());
			byuser.setPhone(userProfileEntity.getPhone());
			byuser.setEmail(userProfileEntity.getEmail());

			return byuser = userProfileRepo.save(byuser);
		}
		UserProfileEntity entity = userProfileRepo.save(userProfileEntity);
		return entity;

	}

}
