package server.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	@NotNull(message = "No Username")
	private String username;
	@NotNull(message = "No password")
	private String password;
	private ArrayList<String> groups;
	
	public UserEntity(String username, String password, ArrayList<String> groups) {
		this.username = username;
		this.password = password;
		this.setGroups(groups);
	}

	public ArrayList<String> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<String> groups) {
		this.groups = groups;
	}
}
