package server.ifs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import server.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	@Query(value = "update users u set u.password =:userPassword where u.id =:userID ", nativeQuery = true)
	public void updateAccountPassword(@Param("userID") Integer id, @Param("userPassword") String password);
	
	@Query(value ="update users u set u.username =:userUsername where u.id =:userID", nativeQuery = true)
	public void updateAccountUsername(@Param("userID") Integer id, @Param("userUsername") String username);
	
	@Query(value = "update users u set.groups =:userGroups where u.id =:userID", nativeQuery = true)
	public void updateAccountGroups(@Param("userID") Integer id, @Param("userGroups") ArrayList<String> goups);
	
	@Query(value ="select groups from users u where u.username =:userUsername", nativeQuery = true)
	public List<String> getAccountGroups(@Param("userUsername") String username);
	
	@Query(value="select id,username,groups from users u where u.username =:userUsername", nativeQuery = true)
	public List<UserEntity> getAccount(@Param("userUsername") String username);
	
	@Query(value="select username from users u where u.id =:userID", nativeQuery = true)
	public List<String> getAccountUsername(@Param("userID") Integer id);
	
	@Query(value="select id from users u where u.username=:username", nativeQuery = true)
	public List<String> getUserID (@Param("username") String username);

	@Query(value="selcet id from users u where u.username=:username and u.password=:password", nativeQuery = true)
	public String getIDForUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
