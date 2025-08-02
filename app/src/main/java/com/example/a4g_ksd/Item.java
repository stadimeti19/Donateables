package com.example.a4g_ksd;

/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
public class Item {

	// Data
	private String name;
	private int count;
	// private String destination;
	private String origin;
	private String acceptedByOrg;
	private boolean acceptedByDriver;
	private User associatedUser;

	// Constructor(s)
	/**
	 * Constructs an Item with a given name, count, destination, and origin
	 *
	 * @param iName
	 * @param iCount
	 */
	public Item(String iName, int iCount, User user) {
		name = iName;
		count = iCount;
		acceptedByOrg = "pending";
		acceptedByDriver = false;
		associatedUser = user;
		origin = user.getAddress();
	}

	/**
	 * Constructs an Item without set parameters
	 */
	public Item() {
		name = "Sample Item";
		count = 1;
		// destination = "Sample Destination Address";
		// origin = "Sample Origin Address";
		acceptedByOrg = "pending";
		acceptedByDriver = false;
	}

	/*public User getAssociatedUser() {
		return associatedUser;
	}*/

	/**
	 * Returns the name of the item
	 *
	 * @return item name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the count of the item
	 *
	 * @return item count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Sets the count of the item to the parameter count value
	 *
	 * @param newCount value
	 */
	public void setCount(int newCount) {
		count = newCount;
	}

	/**
	 * Returns the destination of the item
	 *
	 * @return item destination
	 */
	/*
	 * public String getDestination() { return destination; }
	 */

	/**
	 * Returns the origin of the item
	 *
	 * @return item origin
	 */

	public String getOrigin() { return origin; }


	/**
	 * Returns the organization status boolean variable
	 *
	 * @return organization status
	 */
	public String toString() {
		return name + ", " + count;
	}

	/**
	 * Returns the organization status boolean variable
	 *
	 * @return org status
	 */
	public String getOrgStatus() {
		return acceptedByOrg;
	}

	public void setOrgStatus(String acceptedByOrg) {
		this.acceptedByOrg = acceptedByOrg;
	}

	/**
	 * Returns the driver status boolean variable
	 *
	 * @return driver status
	 */
	public Boolean getDriverStatus() {
		return acceptedByDriver;
	}

}