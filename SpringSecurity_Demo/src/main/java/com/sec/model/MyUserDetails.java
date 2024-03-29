package com.sec.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{
	private int id;
	private String userName;
	private String password;
	private boolean ative;
	private List<GrantedAuthority>authorities;

	public MyUserDetails(User user) {
		this.id=user.getId();
		this.userName=user.getUserName();
		this.password=user.getPassword();
		this.ative=user.isAtive();
		this.authorities=Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
public MyUserDetails() {
		
	
		
	}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	System.out.println(authorities);
	return authorities;
}

@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return password;
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return userName;
}

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return ative;
}

public int getUserId() {
	// TODO Auto-generated method stub
	return id;
}

	
	
	

}
