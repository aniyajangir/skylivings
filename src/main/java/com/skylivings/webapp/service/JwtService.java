//package com.skylivings.webapp.service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.skylivings.webapp.config.JwtUtil;
//import com.skylivings.webapp.model.JwtRequest;
//import com.skylivings.webapp.model.JwtResponse;
//import com.skylivings.webapp.model.Role;
//import com.skylivings.webapp.model.User;
//import com.skylivings.webapp.repo.UserRepo;
//
//@Service
//public class JwtService implements UserDetailsService {
//
//	@Autowired
//	private UserRepo userRepo;
//
//	@Autowired
//	private JwtUtil jwtUtil;
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
//		String userName = jwtRequest.getUserName();
//		String userPassword = jwtRequest.getUserPassword();
//		authenticate(userName, userPassword);
//
//		final UserDetails userDetails = loadUserByUsername(userName);
//
//		String newGeneratedToken = jwtUtil.generateToken(userDetails);
//
//		User user = userRepo.findByUsername(userName);
//
//		return new JwtResponse(user, newGeneratedToken);
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepo.findByUsername(username);
//
//		if (user != null) {
//			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getUserPassword(),
//					getAuthorities(user));
//		} else {
//			throw new UsernameNotFoundException("Username is not valid");
//		}
//	}
//
//	private Set getAuthorities(User user) {
//		Set authorities = new HashSet<>();
//		Role role = user.getRole();
//		authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
//		return authorities;
//	}
//
//	private void authenticate(String userName, String userPassword) throws Exception {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
//		} catch (DisabledException e) {
//			throw new Exception("User is disabled");
//		} catch (BadCredentialsException e) {
//			throw new Exception("Bad credentials from user");
//		}
//
//	}
//}
