package server.ifs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CryptionKeyServiceInterface {
	
	public String setCryptionKey(String key, HttpServletResponse response, HttpServletRequest request);
	
	public String deleteCryptionKey();

}
