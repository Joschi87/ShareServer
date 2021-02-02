package server.ifs;

import java.util.ArrayList;
import java.util.List;

import server.entity.UserEntity;

public interface UserServiceInterface{
	
	public void createAccount(String username, String password, ArrayList<String> groups);
	
	public void updatePassword(Integer id, String password);
	
	public void updateUsername(Integer id, String username);
	
	public void updateGroups(String username, ArrayList<String> groups);
	
	public void deleteAccount(Integer id);
	
	public ArrayList<String> getGroups(String username);
	
	public List<UserEntity> getAccount();
	
	public String getUsername(Integer id);

}
