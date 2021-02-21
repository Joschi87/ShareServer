package server.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.entity.UserEntity;
import server.ifs.UserRepository;
import server.ifs.UserServiceInterface;
import server.lib.utils.Cryption;
import server.lib.utils.ShareServerCookies;

@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public String createAccount(String username, String password, HttpServletRequest request) {
		ArrayList<String> groupArray = new ArrayList<String>();
		String output = "";
		String key = ShareServerCookies.getKey(request);
		
		groupArray.add("No Groups");
		
		UserEntity userEntity = new UserEntity(Cryption.encrypt(username, key), Cryption.encrypt(password, key), groupArray);
		List<UserEntity> list = new ArrayList<>();
		list.add(userEntity);
		userRepository.saveAll(list);
		
		if(checkUsernameAsEmpty(username) == true) {
			output = "<script>alert('Register successful!');window.close();</script>";
		}else {
			output = "<script>alert('Register failed!');window.close();</script>";
		}
		return output;
	}

	@Override
	public void updatePassword(String username, String password) {
		userRepository.updateAccountPassword(Integer.parseInt(userRepository.getUserID(username).toString()), password);
	}

	@Override
	public void updateUsername(String usernameNew, String usernameOld) {
		userRepository.updateAccountUsername(Integer.parseInt(userRepository.getUserID(usernameOld).toString()), usernameNew);
	}

	@Override
	public void updateGroups(String username, String groups) {
		ArrayList<String> groupsArray = (ArrayList<String>) userRepository.getAccountGroups(username);
		groupsArray.add(groups);
		userRepository.updateAccountGroups(Integer.parseInt(userRepository.getUserID(username).toString()), groupsArray);
	}

	@Override
	public void deleteAccount(String username, String adminUsername) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> getGroups(String username) {
		return (ArrayList<String>) userRepository.getAccountGroups(username);
	}

	@Override
	public List<UserEntity> getAccounts() {
		List<UserEntity> allAccounts = new ArrayList<>();
		userRepository.findAll().forEach(UserEntity -> allAccounts.add(UserEntity));
		return allAccounts;
	}
	
	@Override
	public boolean checkUsernameAsEmpty(String username) {
		boolean output = false;
		if(userRepository.getUserID(username).isEmpty())
			output = true;
		return output;
	}
	
	public String login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
		String output ="";
		if(!userRepository.getIDForUsernameAndPassword(username, password).isEmpty()) {
			output = "<script>alert('Login successful!');window.close();</script>";
		}else {
			output = "<script>alert('Login failed!');window.close();</script>";
		}
		return output;
	}
}
