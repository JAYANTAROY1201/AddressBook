package com.addressbook.dao;

/**
 *PURPOSE: this interface is written to generalize address book methods
 *@author JAYANTA ROY
 *@version 1.0
 *@since 22/06/17
 */
public interface GeneralAddressBook {
	 public void addPerson() ;
	 public void updatePerson();
	 public void removePerson();
	 public void sortByName();
	 public void sortByZip();
	}
