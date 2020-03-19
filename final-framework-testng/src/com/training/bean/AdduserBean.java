package com.training.bean;

public class AdduserBean {
	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;
	private String loginname;
	private String Password;

	public AdduserBean() {
	}

	public AdduserBean(String fieldsname,String firstname, String lastname, String email,String phonenumber,String loginname,String Password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email=email;
		this.phonenumber=phonenumber;
		this.loginname=loginname;
		this.Password=Password;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setlastName(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumberl() {
		return phonenumber;
	}

	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getLoginNamel() {
		return loginname;
	}

	public void setLoginName(String loginname) {
		this.loginname = loginname;
	}
	public String getPasswordl() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
	@Override
	public String toString() {
		return "AdduserBean [firstname=" + firstname + ", lastname=" + lastname + ",email=" + email +",phonenumber=" + phonenumber +",loginname=" + loginname +",Password=" + Password +",]";
	}

}
