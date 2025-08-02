package com.example.a4g_ksd;
/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
public class Organization extends User {

	// Constructor
	/**
	 * Constructs a default Organization object
	 */
	public Organization() {
		super();
	}

	/**
	 * Constructs an Organization object given a specified name, location, and mail
	 * @param name
	 * @param location
	 * @param mail
	 */
	public Organization(String name, String location, String mail) {
		super(name, location, mail);
	}
}