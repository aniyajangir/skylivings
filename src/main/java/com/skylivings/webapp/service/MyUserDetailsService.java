//package com.skylivings.webapp.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.skylivings.webapp.config.CustomUserDetail;
//import com.skylivings.webapp.model.User;
//import com.skylivings.webapp.repo.UserRepo;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private UserRepo userRepo;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		User user = userRepo.findByUsername(username);
//		if(user == null) {
//			throw new UsernameNotFoundException("User Not Found");
//		}
//		return new CustomUserDetail(user);
//	}
//
//}
