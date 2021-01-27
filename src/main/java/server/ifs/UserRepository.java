package server.ifs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import server.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	@Query("update Users u set u.password = :userPassword WHERE u.id =:userID ")
	public void updateAccountPassword(@Param("userID") Integer id, @Param("userPassword") String password);
	
	@Query("update Users u set u.username =:userUsername WHERE u.id =:userID")
	public void updateAccountUsername(@Param("userID") Integer id, @Param("userUsername") String username);
	
	@Query("update Users u set.groups =:userGroups WHERE u.id =:userID")
	public void updateAccountGroups(@Param("userID") Integer id, @Param("userGroups") ArrayList<String> goups);
	
	@Query("select groups from #{#entityName} u WHERE u.username =:userUsername")
	public ArrayList<String> getAccountGroups(@Param("userUsername") String username);
	
	@Query("select id,username,groups from #{#entiyName} u WHERE u.username =:userUsername")
	public List<UserEntity> getAccount(@Param("userUsername") String username);
	
	@Query("select username from #{#entityName} u WHERE u.id =:userID")
	public String getAccountUsername(@Param("userID") Integer id);

}
