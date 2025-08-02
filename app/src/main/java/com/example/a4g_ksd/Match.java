package com.example.a4g_ksd;

import android.util.Log;

import com.example.a4g_ksd.Item;

import java.util.ArrayList;
/**
 * Models a Donation Item for the app
 *
 * @author Donateables Team
 *
 */
public class Match {
    // Data
    private Item user;
    private Item org;
    private boolean match;

    //Constructors

    /**
     * Constructs a Match object to match the user to the organization
     * @param user
     * @param org
     */
    public Match(Item user, Item org){
        Log.d("Match","In Match" + user.getName()+(org.getName()) + user.getOrigin() + org.getOrigin());
        this.user = user;
        this.org = org;
        checkMatch();
    }

    //Methods

    /**
     * Checks to see whether the User has an item in common with the Organization
     */
    private void checkMatch(){
        if (user.getName().equals(org.getName()) && user.getOrigin().equals(org.getOrigin())){
            match = true;
            if(user.getCount()<org.getCount()){
                user.setOrgStatus("fulfilled");
                org.setCount(org.getCount()-user.getCount());
                user.setCount(0);
            }
            else if(user.getCount()>org.getCount()){
                org.setOrgStatus("fulfilled");
                user.setCount(org.getCount()-user.getCount());
                org.setCount(0);
            }
            else{
                user.setOrgStatus("fulfilled");
                org.setOrgStatus("fulfilled");
                user.setCount(0);
                org.setCount(0);
            }
        }
        else {
            match = false;
        }
    }

    /**
     * Prints out the Match object as a string with the user and matching item
     * @return
     */
    public String toString(){
        return user.getName() +" " + getMatch();
    }

    /**
     * Returns the user object
     * @return
     */
    public Item getUser() {
        return user;
    }

    /**
     * Sets the user to the specified user
     * @param user
     */
    public void setUser(Item user) {
        this.user = user;
    }

    /**
     * Returns the Organization object
     * @return
     */
    public Item getOrg() {
        return org;
    }

    public void setOrg(Item org) {
        this.org = org;
    }

    public boolean getMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public static ArrayList<Match> getMatchList(ArrayList<Item> userList, ArrayList<Item> orgList){
        ArrayList<Match> matches = new ArrayList<Match>();
        for(Item userItem : userList){
            for(Item orgItem: orgList){
                Match match = new Match(userItem, orgItem);
                if (match.getMatch()) {
                    matches.add(match);
                }
            }

        }
        return matches;
    }
}

