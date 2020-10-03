package com.ramkarlapudi.exceptionhandling.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.ramkarlapudi.exceptionhandling.entity.UserProfileEntity;

public interface UserService {
	
	public  ArrayList<UserProfileEntity> getAllUsers();
	
    public Optional<UserProfileEntity>  getUserById(int id );	

}
