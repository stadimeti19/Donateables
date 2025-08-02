package com.example.a4g_ksd;

import java.util.ArrayList;

/**
 * Models the matching algorithm for the donation app
 * 
 * @author Donateables Team
 *
 */
public class MatchingAlgorithm {

	// Data
	ArrayList<Item> UserList;
	ArrayList<Item> OrgList;
	ArrayList<String> matchItems;
	ArrayList<String> UserItemHistory;
	private boolean match;
	private int numMatches;

	// Constructor(s)
	/**
	 * Constructs a matching algorithm with given ArrayList parameters
	 * 
	 * @param UserItems         ArrayList
	 * @param OrganizationItems ArrayList
	 */
	public MatchingAlgorithm(ArrayList<Item> UserItems, ArrayList<Item> OrganizationItems) {
		UserList = UserItems;
		OrgList = OrganizationItems;
		matchItems = new ArrayList<String>();
		UserItemHistory = new ArrayList<String>();
		match = false;
		numMatches = 0;
	}

	/**
	 * Constructs a default matching algorithm which initializes the ArrayLists
	 */
	public MatchingAlgorithm() {
		UserList = new ArrayList<Item>();
		OrgList = new ArrayList<Item>();
		matchItems = new ArrayList<String>();
		UserItemHistory = new ArrayList<String>();
		match = false;
		numMatches = 0;
	}

	// Method(s)
	/**
	 * Matches the items from the user list to the organization list to scan for
	 * similarities
	 * 
	 * @return list of matched items
	 */
	public String matchItems() {

		for (int x = 0; x < UserList.size(); x++) {
			for (int y = 0; y < OrgList.size(); y++) {
				if (UserList.get(x).getName().toLowerCase().equals(OrgList.get(y).getName().toLowerCase())) {
					match = true; // what does this do
					numMatches++;
					int orgCount = OrgList.get(y).getCount();
					int userCount = UserList.get(x).getCount();
					if (userCount <= orgCount) {
						orgCount -= userCount;
						userCount -= userCount;
						OrgList.get(y).setCount(orgCount);
						UserList.get(x).setCount(userCount);
						UserItemHistory.add(UserList.get(x).getName());
						UserList.remove(x);
					} else {
						System.out.println("You can donate " + orgCount + " of your items to the organization");
						userCount -= orgCount;
						orgCount -= orgCount;
						OrgList.get(y).setCount(orgCount);
						UserList.get(x).setCount(userCount);
					}
					matchItems.add("Item: " + UserList.get(x).getName()+"\n"+"Amount Donated: " +userCount);
				}
			}
		}

		return "MatchPage Found: " + matchItems;
	}
	//Setters
	public void setUserList(ArrayList<Item> userList) {
		UserList = userList;
	}

	public void setOrgList(ArrayList<Item> orgList) {
		OrgList = orgList;
	}

	public void setMatchItems(ArrayList<String> matchItems) {
		this.matchItems = matchItems;
	}

	public void setUserItemHistory(ArrayList<String> userItemHistory) {
		UserItemHistory = userItemHistory;
	}

	public void setMatch(boolean match) {
		this.match = match;
	}

	public void setNumMatches(int numMatches) {
		this.numMatches = numMatches;
	}
	//Getters
	public ArrayList<Item> getUserList() {
		return UserList;
	}

	public ArrayList<Item> getOrgList() {
		return OrgList;
	}

	public ArrayList<String> getMatchItems() {
		return matchItems;
	}

	public ArrayList<String> getUserItemHistory() {
		return UserItemHistory;
	}
}