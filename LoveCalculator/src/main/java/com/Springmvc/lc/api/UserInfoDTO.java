package com.Springmvc.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {
	
	@NotBlank(message="* user Name can not be blank")
	/* @Min(value=3,message="* Your Name should have at least 3 char") */
	@Size(min=3, max=15, message="* Your Name should have char between 3 and 15")
	private String userName ="Sheldon";
	@NotBlank(message="* crush Name can not be blank")
	@Size(min=3, max=15, message="* Crush Name should have char between 3 and 15")
	private String crushName="Penny";
	
	@AssertTrue(message="please check the terms and condition to use our application")
	private boolean termAndCondition;
	
	private String appResult;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	
	public boolean isTermAndCondition() {
		return termAndCondition;
	}
	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}
	
	public String getAppResult() {
		return appResult;
	}
	public void setAppResult(String appResult) {
		this.appResult = appResult;
	}
	@Override
	public String toString() {
		return "UserInfoDTO [userName=" + userName + ", crushName=" + crushName + ", termAndCondition="
				+ termAndCondition + "]";
	}
	
	
	
}
