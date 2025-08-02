package com.example.a4g_ksd;

import java.util.ArrayList;
/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
public class User {

	// Data
	private String userName;
	private String address;
	private String email;
	private ArrayList<Item> items;
	//private String specInstr;

	// Constructors

	/**
	 * Constructs a default constructor for a User object
	 */
	public User() {
		userName = "username";
		address = "address";
		email = "email";
		items = new ArrayList<Item>();
	}

	/**
	 * Constructs an User object with a specified name, location, and mail
	 * @param name
	 * @param location
	 * @param mail
	 */
	public User(String name, String location, String mail) {
		userName = name;
		address = location;
		email = mail;
		items = new ArrayList<Item>();
	}

	// Methods
	// Getters

	/**
	 * Returns the user name of the user
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Returns the address of the user
	 * @return userAddress
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Returns the email of the user
	 * @return userEmail
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Returns the list of User Items
	 * @return
	 */
	public ArrayList<Item> getMyItems() {
		return items;
	}

	/**
	 * Returns the list of User Items in a string format
	 * @return
	 */
	public String getMyItemsList() {
		String userItems = "Your Items: \n";
		for (int i = 0; i < items.size(); i++) {
			userItems += items.get(i).toString() + "\n";
		}
		return userItems;
	}

	// Setters

	/**
	 * Sets the user name of the user
	 * @param name
	 */
	public void setUserName(String name) {
		userName = name;
	}

	/**
	 * Sets the user address from a given zipcode
	 * @param zip
	 */
	public void setAddress(String zip) {
		address = zip;
	}

	/**
	 * Sets the email of the user
	 * @param mail
	 */
	public void setEmail(String mail) {
		email = mail;
	}

	/**
	 * Adds an item to the user item list
	 * @param item
	 */
	public void addItem(Item item) {
		items.add(item);
	}

}