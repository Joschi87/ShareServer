package server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.entity.UserEntity;
import server.ifs.UserRepository;
import server.ifs.UserServiceInterface;

@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void createAccount(String username, String password, ArrayList<String> groups) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePassword(Integer id, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUsername(Integer id, String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroups(String username, ArrayList<String> groups) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> getGroups(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> getAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
