package com.addressbook.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.addressbook.dao.AddressBookSerializer;
import com.addressbook.dao.AddressBookUtility;
import com.addressbook.dao.AddressbookImpl;
import com.addressbook.dto.AddressbookParseObject;
/**
 * @author Jayanta Roy
 * @version 1.0
 * @since 06/06/18
 */
public class AddressbookController {
	static AddressbookImpl a1=new AddressbookImpl();
	AddressBookUtility au=new AddressBookUtility();
    AddressBookSerializer abSerObject=null;
    
    
    
	public void doAdd(){
		a1.addPerson();
	}
		
	
	public void doDelete() throws FileNotFoundException, IOException, ParseException {
		a1.removePerson();
	}

	
	public void doEdit() throws FileNotFoundException, IOException, ParseException {
		a1.updatePerson();
	}

	
    public void doOpen() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
    	System.out.println("Type and choose:\n1 JSON \n2 mySql DATABASE");
		int choice = au.readInt();
		if (choice == 1) {
			abSerObject = AddressbookParseObject.objectManager("json");
		} else {
			abSerObject = AddressbookParseObject.objectManager("jdbc");
		}
		abSerObject.read();
    }

    
	public void doSave() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		System.out.println("Type and choose:\n1 JSON \n2 mySql DATABASE");
		int choice = au.readInt();
		if (choice == 1) {
			abSerObject = AddressbookParseObject.objectManager("json");
		} else {
			abSerObject = AddressbookParseObject.objectManager("jdbc");
		}
		abSerObject.save();
	}

	
	public void doExit()
	{
	 System.exit(0);
	}
	

	
	public void doSortByName() throws FileNotFoundException, IOException, ParseException {
		a1.sortByName();
		
	}

	
	public void doSortByZip() throws FileNotFoundException, IOException, ParseException {
		a1.sortByZip();

	}
}
