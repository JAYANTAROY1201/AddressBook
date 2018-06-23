package com.addressbook.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;

import com.addressbook.dto.Person;

/**
 *PURPOSE: This class is designed to use as utility of address book 
 *@author JAYANTA ROY
 *@version 1.0
 *@since 22/08/18
 */
public class AddressBookUtility {
	
	public static List<Person> personList =new LinkedList<>();
	public static File personFile=null;
	public static JSONArray personJsonArray=null;
	
	Scanner sc=new Scanner(System.in);
	
	/**
	 * This method is writtten to take an integer input
	 * @return integer value
	 */
	public  int readInt()
	{
		return sc.nextInt();
	}
	
	/**
	 * This method is writtten to take a String input
	 * @return String value
	 */
	public  String readString()
	{
		return sc.next();
	}
	
	/**
	 * This method is writtten to set the file from where data will be recoverd
	 */
	public void setPersonFile()
	{
		System.out.println("Enter json file name: ");
		String fName=sc.next();
		File personFile=new File("/home/administrator/eclipse-workspace/AddressManagement/src/com/addressbook/otherfile/"+fName+".json");
		try {
			if(personFile.createNewFile())
			{
			 personJsonArray=new JSONArray();
		     writeJsonFile(personJsonArray, personFile);
		     setPersonFile(personFile);
			}
			else
			{
			System.out.println("File set..");
			setPersonFile(personFile);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is writtten to set the file 
	 * @param file
	 */
	public void setPersonFile(File file)
	{
		this.personFile=file;
	}
	
	
	/**
	 * This method is writtten to get the file
	 * @return person file
	 */
	public static File getPersonFile()
	{
		return personFile;
	}
	
	/**
	 *this method is written to write a jsonArray to json file
	 * @param personJsonArray
	 * @param personFile
	 */
	public static void writeJsonFile(JSONArray personJsonArray,File personFile)
	{
	
	 try {
			FileWriter fw = new FileWriter(personFile);
			fw.write(personJsonArray.toString());
			fw.flush();
			fw.close();
	     }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
}
}
