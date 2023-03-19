package com.company;

public class Profile {
    private String username;
    private String firstName;
    private String surname;
    private Profile[] friends;
    private String workplace;
    private String hometown;
    private Profile rightNode;
    private Profile leftNode;
    private int userID;

    Profile left, right;


    public Profile(String UserName , String NameOne , String NameTwo, String WorkPlace , String HomeTown , int ID)
    {
        username = UserName;
        firstName = NameOne;
        surname = NameTwo;
        workplace = WorkPlace;
        hometown = HomeTown;
        userID = ID;
        int[] freinds; //array of user IDs
        left = right = null;
    }

    public Profile(){
        username = "username";
        firstName = "firstname";
        surname = "surname";
        workplace = "workplace";
        hometown = "hometown";
        userID = 0;
        int[] freinds;; //array of userIDs
        left = right = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Profile[] getFriends() {
        return friends;
    }

    public void setFriends(Profile[] friends) {
        this.friends = friends;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
