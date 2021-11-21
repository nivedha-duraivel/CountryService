package com.talks.entity;

public class Country {
	
	private int countryId;
	private String countryName;
	private String countryCapital;
	
	
	public Country(int countryId, String countryName, String countryCapital) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryCapital = countryCapital;
	}
	
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	
	
	

}
