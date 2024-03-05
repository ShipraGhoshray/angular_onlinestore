package com.onlinestore.onlinestore.repository;

import java.util.Objects;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="STORE_USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private long userId;
	    
	@Column(name = "USER_TYPE")
	private String userType;

	@Column(name = "FIRST_NAME") 
	private String firstName;

	@Column(name = "LAST_NAME") 
	private String lastName;
	
	@Column(name = "userPassword")
	private String userPassword;
	
	@Column(name = "EMAIL_ADDRESS")
	private String emailId;
	
	@Column(name = "PHONE_NUMBER")
	private long phoneNumber;
	
	public User() {
	}

	public User(long userId, String userType, String firstName, String lastName, String emailId, long phoneNumber) {
		this.userId = userId;
	    this.userType = userType;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.emailId = emailId;
	    this.phoneNumber = phoneNumber;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String userFirstName) {
		this.firstName = userFirstName;
	}

	public String getUserLastName() {
		return lastName;
	}

	public void setUserLastName(String userLastName) {
		this.lastName = userLastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/*@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", userType='" + userType + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", emailId='" + emailId + '\'' +
				", phoneNumber'" + phoneNumber + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) 
			return true;
		if (o == null || getClass() != o.getClass()) 
			return false;
		User that = (User) o;
		return Objects.equals(userId, that.userId) && 
				Objects.equals(userType, that.userType)&&
				Objects.equals(firstName, that.firstName)&&
				Objects.equals(lastName, that.lastName)&&
				Objects.equals(emailId, that.emailId)&&
				Objects.equals(phoneNumber, that.phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, userType, firstName, lastName, emailId, phoneNumber);
	}*/

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}