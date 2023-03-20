package com.company;

public class Profile {
    private String username;
    private String firstName;
    private String surname;
    private int[] friends = {0};
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

        left = right = null;
    }

    public Profile(){
        username = "username";
        firstName = "firstname";
        surname = "surname";
        workplace = "workplace";
        hometown = "hometown";
        userID = 0;

        left = right = null;
    }

    public void display()
    {
        System.out.println(userID);
        System.out.println(username);
        System.out.println(firstName);
        System.out.println(surname);
    }
    public void addFriend(int newFriendID) {

        if (friends[0] == 0)
        {
            friends[0] = newFriendID;
            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if (friends[i] == newFriendID) {
                System.out.println("Already freinds with this guy");
                newFriendID = -1;
                break;
            }
        }
        if (newFriendID <= 0) {
            System.out.println("CANNOT ADD!!!");
        } else {
            int[] tempArray = new int[friends.length + 1];
            for (int i = 0; i < friends.length; i++) {
                tempArray[i] = friends[i];
            }
            tempArray[friends.length] = newFriendID;
            friends = tempArray;
        }
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

    public int[] getFriends() {
        return friends;
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
