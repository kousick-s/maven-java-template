package com.hashedin;

public class MovieRatings {
	private int uid;
	private int mid;
	private int rating;
	private int timestamp;
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "[uid=" + uid + ", mid=" + mid + ", rating="
				+ rating + ", timestamp=" + timestamp + "]";
	}
	
	
	
	

}
