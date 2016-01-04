package com.github.hualuomoli.demo.entity;

import java.util.Date;

import com.github.hualuomoli.base.entity.BaseEntity;

// 用户
public class User extends BaseEntity {

	private String userCode;
	private String nickName;
	private Integer age;
	private String address;
	private Date birthDay;
	private Double salary;

	public User() {
	}

	public User(String userCode, String nickName) {
		this.userCode = userCode;
		this.nickName = nickName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
