package com.addressbook.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

import com.addressbook.dao.AddressBookUtility;

/**
 *PURPOSE: This  main class is designed to use functionality of a address book
 *@author JAYANTA ROY
 *@version 1.0
 *@since 22/06/18
 */
public class AddressbookMain {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		AddressbookController ac = new AddressbookController();
		AddressBookUtility au = new AddressBookUtility();

		System.out.println("**********************SIMPLE ADDRESSBOOK**********************");
		boolean quit = false;
		while (quit == false) {
			System.out.println("Opening File Menu:");
			System.out.println("1.OPEN \n3.QUIT");
			System.out.println("Enter your choice:");
			int choice = au.readInt();
			switch (choice) {

			case 1:
				ac.doOpen();
				boolean closed = false;
				while (closed == false) {
					System.out.println(
							"1.Add person \n2.Edit person \n3.Delete person \n4.Sort by name \n5.Sort by ZIP \n6.Save \n7.Close");
					int ch = au.readInt();
					switch (ch) {
					case 1:
						ac.doAdd();
						break;
					case 2:
						ac.doEdit();
						System.out.println("Address book edited");
						closed = false;
						break;
					case 3:
						ac.doDelete();
						System.out.println("Address book deleted");
						closed = false;
						break;
					case 4:
						ac.doSortByName();
						System.out.println("Sorted by name");
						closed = false;
						break;
					case 5:
						ac.doSortByZip();
						System.out.println("Sorted by zip");
						closed = false;
						break;
					case 6:
						ac.doSave();
						System.out.println("Address book saved");
						closed = false;
						quit = false;
						break;
					case 7:
						ac.doExit();
						System.out.println("Address book closed");
						closed = true;
					}
				}
				break;
			case 3:
				quit = true;
				break;
			default:
				quit = true;
				System.out.println("Invalid choice.......\n Program terminated");
				break;
			}
		}
	}
}
