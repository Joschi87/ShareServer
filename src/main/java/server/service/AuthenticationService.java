package server.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import server.ifs.UserRepository;
import server.lib.utils.JwtTokenService;

@Service
public class AuthenticationService {

	private UserRepository userRepository;
	
	private JwtTokenService jwtTokenService;
	
	private PasswordEncoder passwordEncoder;
	
	public AuthenticationService(UserRepository userRepository, JwtTokenService jwtTokenService, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.jwtTokenService = jwtTokenService;
		this.passwordEncoder = passwordEncoder;
	}
	
	/*public JWTTokenResponse generateJWTToken(String username, String password) {
        return userRepository.findOneByUsername(username)
                .filter(account ->  passwordEncoder.matches(password, account.getPassword()))
                .map(account -> new JWTTokenResponse(jwtTokenService.generateToken(username)))
                .orElseThrow(() ->  new EntityNotFoundException("Account not found"));
    }*/
	
}