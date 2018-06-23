package com.addressbook.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.addressbook.dto.Person;

/**
 * PURPOSE: This class is designed to implements AddressBookSerializer inteface
 * and override the the save and read method.
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 22/06/18
 */
public class JsonSerializer implements AddressBookSerializer {

	AddressBookUtility abUtil = new AddressBookUtility();

	/**
	 * this method is written to insert a person's details into json file
	 * 
	 * @see com.addressbook.dao.AddressBookSerializer#save()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void save() {
		AddressBookUtility.personJsonArray = new JSONArray();
		Iterator<Person> it = AddressBookUtility.personList.iterator();
		while (it.hasNext()) {
			Person prsn = it.next();
			JSONObject obj = new JSONObject();
			obj.put("first_name", prsn.getFirstName());
			obj.put("last_name", prsn.getLastName());
			obj.put("address", prsn.getAddress());
			obj.put("city", prsn.getCity());
			obj.put("state", prsn.getState());
			obj.put("zip", prsn.getZip());
			obj.put("mobile", prsn.getMobile());
			AddressBookUtility.personJsonArray.add(obj);
		}
		System.out.println(AddressBookUtility.personJsonArray);
		AddressBookUtility.writeJsonFile(AddressBookUtility.personJsonArray, AddressBookUtility.personFile);
	}

	/**
	 * this method is written to read data from json file and store it local list
	 * 
	 * @see com.addressbook.dao.AddressBookSerializer#read()
	 */
	@Override
	public void read() {
		JSONParser parser = new JSONParser();
		try {
			if (AddressBookUtility.personFile == null) {
				abUtil.setPersonFile();
			}
			Object obj = parser.parse(new FileReader(AddressBookUtility.getPersonFile()));
			AddressBookUtility.personJsonArray = (JSONArray) obj;
			System.out.println("json array " + AddressBookUtility.personJsonArray);
			for (int i = 0; i < AddressBookUtility.personJsonArray.size(); i++) {
				JSONObject jsobj = (JSONObject) AddressBookUtility.personJsonArray.get(i);
				AddressBookUtility.personList.add(new Person(jsobj.get("first_name").toString(),
						jsobj.get("last_name").toString(), jsobj.get("address").toString(),
						jsobj.get("city").toString(), jsobj.get("state").toString(), jsobj.get("zip").toString(),
						jsobj.get("mobile").toString()));

			}

			Iterator<Person> it = AddressBookUtility.personList.iterator();
			while (it.hasNext()) {
				System.out.println("print: " + it.next().firstName);
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
