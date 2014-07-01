package com.hashedin;

public class MovieRecomendor {
	private String id;
	private String name;
	private String year;
	private String date;
	private String url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "MovieRecomendor [id=" + id + ", name=" + name + ", year="
				+ year + ", date=" + date + ", url=" + url + "]";
	}
	
	
	
	

}
