package com.example.BootJPAH2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

	String aname;
	@Id
	int aid;
	String tech;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "Alien [aname=" + aname +  ", tech=" + tech +  ", aid=" + aid + "]";
	}
	
}
