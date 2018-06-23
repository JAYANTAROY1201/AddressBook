package com.addressbook.dao;

import com.addressbook.dto.Person;

/**
 *PURPOSE: This class is designed to design all functionality of address book
 *@author JAYANTA ROY
 *@version 1.0
 *@since 22/08/18
 */
public class AddressbookImpl implements GeneralAddressBook {
	AddressBookUtility au = new AddressBookUtility();

	/** 
	 * this method is written to add a person
	 * @see com.addressbook.dao.GeneralAddressBook#addPerson()
	 */
	@Override
	public void addPerson() {
		Person per = new Person();
		AddressBookUtility.personList.add(per);
	}

	/**
	 * this method is written to see persons
	 */
	public void showPerson() {
		int count = 0;
		for (int i = 0; i < AddressBookUtility.personList.size(); i++) {
			Person temp = AddressBookUtility.personList.get(i);
			System.out.println(count++ + " " + temp.getFirstName());

		}
	}

	/** 
	 * this method is written to update 
	 * @see com.addressbook.dao.GeneralAddressBook#updatePerson()
	 */
	@Override
	public void updatePerson() {
		showPerson();
		System.out.println("Choose person from index no.");
		int index = au.readInt();
		Person person = AddressBookUtility.personList.get(index);
		System.out.println("Choose 1 to update address \n2 to update city +n3 to update state"
				+ " \n4 to update zip \n5 to update mobile");
		int choice = au.readInt();
		switch (choice) {
		case 1:
			person.setAddress();
			AddressBookUtility.personList.set(index, person);
			break;
		case 2:
			person.setCity();
			AddressBookUtility.personList.set(index, person);
			break;
		case 3:
			person.setState();
			AddressBookUtility.personList.set(index, person);
			break;
		case 4:
			person.setZip();
			AddressBookUtility.personList.set(index, person);
			break;
		case 5:
			person.setMobile();
			AddressBookUtility.personList.set(index, person);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}

	}

	
	/**
	 * this method is written to remove a person
	 * @see com.addressbook.dao.GeneralAddressBook#removePerson()
	 */
	@Override
	public void removePerson() {
		showPerson();
		System.out.println("Choose person from index no.");
		int index = au.readInt();
		AddressBookUtility.personList.remove(index);

	}

	/** 
	 * this method is written to sort the person by name
	 * @see com.addressbook.dao.GeneralAddressBook#sortByName()
	 */
	@Override
	public void sortByName() {
		for (int i = 0; i < AddressBookUtility.personList.size() - 1; i++) {
			for (int j = 0; j < AddressBookUtility.personList.size() - i - 1; j++) {
				Person p1 = AddressBookUtility.personList.get(j);
				Person p2 = AddressBookUtility.personList.get(j + 1);
				if (p1.getFirstName().compareToIgnoreCase(p2.getFirstName()) > 0) {
					Person temp = p1;
					AddressBookUtility.personList.set(j, p2);
					AddressBookUtility.personList.set(j + 1, temp);
				}
			}
		}
	}

	/** 
	 * this method is written to sort the person by zip
	 * @see com.addressbook.dao.GeneralAddressBook#sortByZip()
	 */
	@Override
	public void sortByZip() {
		for (int i = 0; i < AddressBookUtility.personList.size() - 1; i++) {
			for (int j = 0; j < AddressBookUtility.personList.size() - i - 1; j++) {
				Person p1 = AddressBookUtility.personList.get(j);
				Person p2 = AddressBookUtility.personList.get(j + 1);
				if (p1.getZip().compareToIgnoreCase(p2.getZip()) > 0) {
					Person temp = p1;
					AddressBookUtility.personList.set(j, p2);
					AddressBookUtility.personList.set(j + 1, temp);
				}
			}
		}
	}
}
