package com.jwt.model;

public class JwtRequest {

	private String mobileNo;

	private String password;

//	private String userId;

	public String getPassword() {
		return password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JwtRequest() {
	}

//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	public JwtRequest(String mobileNo, String password) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
//		this.userId = userId;
	}

	@Override
	public String toString() {
		return "JwtRequest [email=" + mobileNo + ", password=" + password + "]";
	}
}
