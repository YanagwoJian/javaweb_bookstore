package user;

import java.util.concurrent.ConcurrentHashMap;

import usercar.mybooks;

public class user {
	
	private String id;
	private ConcurrentHashMap<String, mybooks> hmap;
	private float sum;
	
	public user(String id) {
		this.id = id;
	}
	public user(String id, ConcurrentHashMap<String, mybooks> hmap) {
		this.id = id;
		this.hmap = hmap;
	}
	public user(String id, ConcurrentHashMap<String, mybooks> hmap, float sum) {
		this.id = id;
		this.hmap = hmap;
		this.sum = sum;
	}
	
	public ConcurrentHashMap<String, mybooks> getHmap() {
		return hmap;
	}
	public void setHmap(ConcurrentHashMap<String, mybooks> hmap) {
		this.hmap = hmap;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
}
