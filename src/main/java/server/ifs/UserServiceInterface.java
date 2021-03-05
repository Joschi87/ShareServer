package server.ifs;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import server.entity.UserEntity;

public interface UserServiceInterface {
	
	public ResponseEntity<String> createAccount(String username, String password, HttpServletRequest request);
	
	public void updatePassword(String username, String password);
	
	public void updateUsername(String usernameNew, String usernameOld);
	
	public void updateGroups(String username, String groups);
	
	public void deleteAccount(String username, String adminUsername);
	
	public ArrayList<String> getGroups(String username);
	
	public List<UserEntity> getAccounts();
	
	public boolean checkUsernameAsEmpty(String username);
	
	public ResponseEntity<String> login(String username, String password, HttpServletRequest request, HttpServletResponse response);
}
