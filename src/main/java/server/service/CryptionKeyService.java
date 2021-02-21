package server.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import server.ifs.CryptionKeyServiceInterface;
import server.lib.utils.ShareServerCookies;

@Service
public class CryptionKeyService implements CryptionKeyServiceInterface{

	@Override
	public String setCryptionKey(String key, HttpServletResponse response, HttpServletRequest request) {
		String output = "<script>alert('Set Cryption Key are failed!!!')</script>";
		ShareServerCookies.setKey(key, response);
		if(!ShareServerCookies.findCookie(request, "key"))
			output = "<script>alert('Set Cryption Key are successfully!')<script>";
		return output;
	}

	@Override
	public String deleteCryptionKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
