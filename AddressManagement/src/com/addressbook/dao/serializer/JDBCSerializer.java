package com.addressbook.dao.serializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Iterator;

import com.addressbook.dao.AddressBookSerializer;
import com.addressbook.dao.AddressBookUtility;
import com.addressbook.dao.CustAnnotation;
import com.addressbook.dto.Person;

/**
 * PURPOSE: This class is designed to implements AddressBookSerializer inteface
 * and override the the save and read method.
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 22/06/18
 */
@CustAnnotation(value="jdbc")
public class JDBCSerializer implements AddressBookSerializer {

	/**
	 * this method is written to insert a person's details into addressbook table
	 * 
	 * @see com.addressbook.dao.AddressBookSerializer#save()
	 */
	public void save() {
		deleteAll();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbUrl = "jdbc:mysql://localhost:3306/bridgelabz?useSSL=false";
		String userNM = "root";
		String pass = "root";
		Iterator<Person> it = AddressBookUtility.personList.iterator();
		while (it.hasNext()) {
			Person prsn = it.next();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(dbUrl, userNM, pass);

				String query = "insert into addressbook values(?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, prsn.getFirstName());
				pstmt.setString(2, prsn.getLastName());
				pstmt.setString(3, prsn.getAddress());
				pstmt.setString(4, prsn.getCity());
				pstmt.setString(5, prsn.getState());
				pstmt.setString(6, prsn.getZip());
				pstmt.setString(7, prsn.getMobile());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * this method is written to read a person's details from addressbook table and
	 * load it into local List
	 * 
	 * @see com.addressbook.dao.AddressBookSerializer#read()
	 */
	public void read() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String dbUrl = "jdbc:mysql://localhost:3306/bridgelabz?useSSL=false";
		String userNM = "root";
		String pass = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, userNM, pass);

			String query = "select * from addressbook";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			// 4. Process the Results returned by SQL Queries
			while (rs.next()) {
				AddressBookUtility.personList.add(new Person(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("address"), rs.getString("city"), rs.getString("state"), rs.getString("zip"),
						rs.getString("mobile")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. Close ALL JDBC Objects
			try {
				if (rs != null) {
					rs.close();
				}

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * this method is written to delete all the data from addressbook table
	 */
	public static void deleteAll() {
		Connection con = null;
		PreparedStatement stmt = null;
		String dbUrl = "jdbc:mysql://localhost:3306/bridgelabz?useSSL=false";
		String userNM = "root";
		String pass = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, userNM, pass);

			String query = "delete from addressbook";
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. Close ALL JDBC Objects
			try {

				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
