package com.talks.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.talks.entity.*;

@Service
public class CountryService {
	
	static HashMap<Integer,Country> countryMap;
	
	public CountryService()
	{
		 countryMap = new HashMap<Integer,Country>();
		 
		 Country india = new Country(1,"India","NewDelhi");
		 Country usa = new Country(2,"USA","Washington");
		 Country japan = new Country(3,"Japan","Tokyo");
		 
		 countryMap.put(1, india);
		 countryMap.put(2, usa);
		 countryMap.put(3, japan);

	}
	
	public List<Country> getCountries()
	{
		List<Country> countryList = new ArrayList<>(countryMap.values());
		return countryList;
	}
	
	public Country getCountryById(int id)
	{
		return countryMap.get(id);
	}

	public Country getCountryByName(String name)
	{
		Country country = null;
		for(int i : countryMap.keySet())
		{
			if(countryMap.get(i).getCountryName().equals(name))
			{
				country = countryMap.get(i);
			}
		}
		return country;
	}
	
	public Country addCountry(Country country)
	{
		country.setCountryId(maxId());
		countryMap.put(country.getCountryId(), country);
		return country;
	}
	
	public Country updateCountry(Country country)
	{
		if(country.getCountryId() > 0)
		{
			countryMap.put(country.getCountryId(), country);
		}
		return country;
	}
	
	public AddResponse deleteCountry(int id)
	{
		for(int i : countryMap.keySet())
		{
			if(countryMap.get(i).getCountryId() == id)
				countryMap.remove(i);
				
		}
		
		AddResponse res = new AddResponse();
		res.setId(id);
		res.setMsg("record deleted successfully");
		return res;
	}
	
	//utility method to get max id (for automatically generate)
	public int maxId()
	{
		int max = 0;
		
		for(int i : countryMap.keySet())
			if(max <= i)
				max = i;
		
		return max + 1; //next id
				
	}
}
