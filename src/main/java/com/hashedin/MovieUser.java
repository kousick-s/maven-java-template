package com.hashedin;

public class MovieUser {
	private int uid;
	private int age;
	private String gender;
	private String occupation;
	private String zip;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "[uid=" + uid + ", age=" + age + ", gender=" + gender
				+ ", occupation=" + occupation + ", zip=" + zip + "]";
	}
	
	
}
