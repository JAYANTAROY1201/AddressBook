package com.addressbook.dto;

import com.addressbook.dao.AddressBookUtility;


/**
 * Purpose: This class is designed to maintain information about a single individual.
 * @author Jayanta Roy
 * @version 1.0
 * @since 22/06/18
 */
public class Person {
   
    AddressBookUtility au= new AddressBookUtility();
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String mobile;

	
	/**
	 * This constructor is designed to set person details in runtime
	 */
	public Person() {
		setFirstName();
		setLastName();
		setAddress();
		setCity();
		setState();
		setZip();
		setMobile();
	}

	/**
	 * This constructor is designed to set person details in compile time
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param mobile
	 */
	public Person(String firstNam, String lastNam, String addres, String cit, String stat, String zi, String mobil) {
		firstName = firstNam;
		lastName = lastNam;
		address = addres;
		city = cit;
		state = stat;
		zip = zi;
		mobile = mobil;
	}

	/**
	 * this method is written to set first name 
	 */
	public void setFirstName() {
		System.out.println("Enter first name:");
		firstName = au.readString();
	}

	/**
	 * this method is written to set last name 
	 */
	public void setLastName() {
		System.out.println("Enter last name:");
		lastName =au.readString();
	}

	/**
	 * this method is written to set address
	 */
	public void setAddress() {
		System.out.println("Enter address:");
		address = au.readString();
	}
	
	/**
	 * this method is written to set city 
	 */
	public void setCity() {
		System.out.println("Enter city:");
		city = au.readString();
	}
	
	/**
	 * this method is written to set state
	 */
	public void setState() {
		System.out.println("Enter state:");
		state =au.readString();
	}


	/**
	 * this method is written to set zip 
	 */
	public void setZip() {
		System.out.println("Enter zip:");
		zip =au.readString();
	}


	/**
	 * this method is written to set mobile 
	 */
	public void setMobile() {
		System.out.println("Enter mobile:");
		mobile = au.readString();
	}
	
	/**
	 * this method is written to get first name
	 * @return first name odf a person
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * this method is written to get last name
	 * @return last name of a person
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * this method is written to get mobile 
	 * @return address of a person
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * this method is written to get city
	 * @return city of a person
	 */
	public String getCity() {
		return city;
	}

	/**
	 * this method is written to get state
	 * @return state of a person
	 */
	public String getState() {
		return state;
	}

	/**
	 * this method is written to get zip
	 * @return zip code of a person
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * this method is written to get mobile 
	 * @return mobile no of a person
	 */
	public String getMobile() {
		return mobile;
	}		
}
