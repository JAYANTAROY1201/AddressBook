package com.addressbook.dto;

import com.addressbook.dao.AddressBookSerializer;
import com.addressbook.dao.JDBCSerializer;
import com.addressbook.dao.JsonSerializer;

/**
 * PURPOSE: This Facrory class is written to return the object of either json or
 * jdbc
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 22/06/18
 */
public class AddressbookParseObject {

	/**
	 * This method is written to pass the object based on choice
	 * 
	 * @param choice
	 * based on what object creation get decided
	 * @return AddressBookSerializer object i.e either json type or jdbc type
	 */
	public static AddressBookSerializer chooseObject(String choice) {
		if (choice.equalsIgnoreCase("json")) {
			return new JsonSerializer();
		} else {
			return new JDBCSerializer();
		}
	}
}
