package com.majjel.majjel.user;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "Users")
public class User {
	
	private @Id @GeneratedValue Long id;
	private String username;
	private String email;
	private String password;
	
	
	public User() {}
	
	public User(String userusername, String email, String password) {
		this.username = userusername;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
		      return true;
		    if (!(o instanceof User))
		      return false;
		    User user = (User) o;
		    return Objects.equals(this.id, user.id) && Objects.equals(this.username, user.username)
		        && Objects.equals(this.email, user.email) && Objects.equals(this.password, user.password);
	}
	
	@Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.username, this.email, this.password);
	  }

	  @Override
	  public String toString() {
	    return "User{" + "id=" + this.id + ", username='" + this.username + '\'' + ", email='" + this.email + '\'' + ", password='" + this.password + '}';
	  }

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(this.username));
	}
	

}
