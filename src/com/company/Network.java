package com.company;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Network {
    // instance variables
    Profile root;
    private String[] dates = new String[100];
    private String[] messages = new String[100];
    private int[] postUserID = new int[100];
    int totalProfiles;

    /**
     * Constructor for objects of class Tree
     */
    Network() {
        totalProfiles = 0;
    }

    public void setPostUserID(int pos, int value){
        postUserID[pos] = value;
    }

    public int getPostUserID(int pos){
        return postUserID[pos];
    }

    public void setDates(int pos, String value){
        dates[pos] = value;
    }
    public String getDates(int pos){
        return dates[pos];
    }
    public void setMessages(int pos, String value){
        messages[pos] = value;
    }
    public String getMessages(int pos){
        return messages[pos];
    }

    public void friendsInCommon(int userID1, int userID2) {
        Profile p1 = findNode(userID1);
        Profile p2 = findNode(userID2);

        for (int i = 0; i < p1.getFriends().length; i++)
        {
            for (int x = 0; x < p2.getFriends().length; x++)
            {
                if (p1.getFriends()[i] == p2.getFriends()[x])
                {
                    Profile commonFriend = findNode(p1.getFriends()[i]);
                    System.out.println(commonFriend.getUsername());
                }
            }
        }
    }

    public void writePostToFile(String text, String Date , int userID) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\alexandergordon\\Desktop\\29_03_2023 project\\ac12001-team-project\\src\\com\\company\\postInfo.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            String textToAppend = (text + ",,,;;;,,," + Date) + ",,,;;;,,," + userID ;
            printWriter.println(textToAppend);
            printWriter.close();
        }
        catch (IOException e){
            System.out.println("nothing happened");
            e.printStackTrace();
        }
    }

    public Profile findByUserName(Profile p , String enteredName) {
        Profile user = null;
        Boolean found = false;

        if (p != null && found == false) {
            if(p.getUsername().equals(enteredName)){
                found = true;
                user = p;
            }
            findByUserName(p.left, enteredName);
            findByUserName(p.right, enteredName);
        }
        return user;
    }

    public void displayFriendsOfFriend(int userID)
    {
        Scanner s = new Scanner(System.in);
        Profile p = findNode(userID);
        displayFriends(p.getUserID());

        System.out.println("Enter the username of the profile youd like to view the friends of :");
        String search = s.nextLine();
        int friendID = 0;

        for (int i = 0; i < p.getFriends().length; i++)
        {
            Profile friend = findNode(p.getFriends()[i]);
            if (friend.getUsername().equals(search))
            {
                friendID = friend.getUserID();
            }
        }

        if (friendID == 0)
        {
            System.out.println(p.getUsername() + " is not friends with " + search);
        }

        else {
            displayFriends(friendID);
        }

        System.out.println("would you like to add any of the profiles as friends (Y or N): ");
        String input = s.nextLine();

        while(true) {


            if (input.equals("Y")) {
                p = findNode(friendID);

                friendID = 0;

                System.out.println("Enter the username of the profile youd like to add :");
                search = s.nextLine();

                for (int i = 0; i < p.getFriends().length; i++) {
                    Profile friend = findNode(p.getFriends()[i]);
                    if (friend.getUsername().equals(search)) {
                        friendID = friend.getUserID();
                    }
                }

                if (friendID == 0)
                {
                    System.out.println(p.getUsername() + " is not friends with " + search);
                }
                else
                {
                    addFriends(userID,friendID);
                }

                System.out.println("would you like to add another (Y or N): ");
                input = s.nextLine();
                if (input.equals("Y")){}
                else {break;}
            }
        }
    }
    public void filterFreinds(int userID)
    {
        Profile p = findNode(userID);
        System.out.println("1: Surname, 2: Workplace, 3: Hometown");
        System.out.println("Filter by same : ");
        Scanner s = new Scanner(System.in);
        int searchItem;
        while(true)
        {
            searchItem = s.nextInt();
            if (searchItem > 0 && searchItem < 4)
            {
                break;
            }
            else
            {
                System.out.println("ENTER 1, 2, or 3!");
            }
        }

        switch (searchItem)
        {
            case 1:
                //same surname
                for (int i = 0; i < p.getFriends().length; i++)
                {
                    Profile friend = findNode(p.getFriends()[i]);
                    if(friend.getSurname().equals(p.getSurname()))
                    {
                        System.out.println(friend.getUsername());
                    }
                }
                break;
            case 2:
                //same workplace
                for (int i = 0; i < p.getFriends().length; i++)
                {
                    Profile friend = findNode(p.getFriends()[i]);
                    if(friend.getWorkplace().equals(p.getWorkplace()))
                    {
                        System.out.println(friend.getUsername());
                    }
                }
                break;
            case 3:
                //same hometown
                for (int i = 0; i < p.getFriends().length; i++)
                {
                    Profile friend = findNode(p.getFriends()[i]);
                    if(friend.getHometown().equals(p.getHometown()))
                    {
                        System.out.println(friend.getUsername());
                    }
                }
                break;
        }


    }
    public void displayFriends(int userID) {
        System.out.println("");
        Profile p = findNode(userID);
        Scanner s = new Scanner(System.in);
        String input;
        System.out.println("would you like to filter friends (Y or N): ");
        input = s.nextLine();

        if(input.equals("Y"))
        {
            filterFreinds(userID);
        }
        else {
            for (int i = 0; i < p.getFriends().length; i++) {
                Profile friend = findNode(p.getFriends()[i]);
                System.out.println(friend.getUsername() + ": " + friend.getFirstName() + " " + friend.getSurname());
            }
        }
    }


    public String getUserBio(int userID) {
        Profile p = findNode(userID);
        return p.getBio();
    }

    public int getTotalProfiles() {
        return totalProfiles;
    }
    public void add1toTotal() {
        totalProfiles += 1;
    }

    public Profile findNode(int userID) {
        int nodeToFind = userID;
        Profile currentNode = root;
        boolean found = false;

        while (!found) {
            if (currentNode == null) {
//                System.out.println("USER NOT FOUND");
                return null;

            } else if (currentNode.getUserID() == nodeToFind) {
                //System.out.println("Found user: " + currentNode.getUsername());
                break;

            } else if (currentNode.getUserID() != nodeToFind) {
                if (currentNode.getUserID() < nodeToFind) {
                    currentNode = currentNode.right;
                } else {
                    currentNode = currentNode.left;
                }
            }
        }
        return (currentNode);
    }

    public void updateNode(Profile p) {
        int nodeToFind = p.getUserID();
        Profile currentNode = root;
        boolean found = false;

        while (!found) {
            if (currentNode == null) {
                System.out.println("USER NOT FOUND");
                break;

            } else if (currentNode.getUserID() == nodeToFind) {
                // System.out.println("Found user: " + currentNode.getUsername());
                currentNode = p;
                break;

            } else if (currentNode.getUserID() != nodeToFind) {
                if (currentNode.getUserID() < nodeToFind) {
                    currentNode = currentNode.right;
                } else {
                    currentNode = currentNode.left;
                }
            }
        }
    }
    public void addFriends(int userID1, int userID2)
    {
        Profile p1 = findNode(userID1);
        Profile p2 = findNode(userID2);

        p1.addFriend(userID2);
        p2.addFriend(userID1);

    }

    public void writeToFile() {
        PrintWriter printWriter = null;
        try {
            boolean check = false;
            FileOutputStream outputStream = new FileOutputStream("src/com/company/profiles.txt");
            printWriter = new PrintWriter(outputStream);
            while (true) {
                Scanner myObj = new Scanner(System.in); // Create a Scanner object
                System.out.println("Enter values u want in the file");
                String userIn = myObj.nextLine(); // Read user input
                if (userIn.equals("")) {
                    break;
                }
                printWriter.println(userIn);
            }
        } catch (IOException e) {
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        } finally {
            if (printWriter != null)
                printWriter.close();
        }
    }

    public void compareFriends(int userID1, int userID2)
    {
        Profile p1 = findNode(userID1);
        Profile p2 = findNode(userID2);
        List<Integer> commonFriends = new ArrayList<>();

        if (p1 == null) {
            System.out.println("First ID invalid!");
            return; // exit the function if p1 is null
        }

        if (p2 == null) {
            System.out.println("Second ID invalid!");
            return; // exit the function if p2 is null
        }

        for (int i = 0; i < p1.getFriends().length; i++)
        {
            for (int x = 0; x < p2.getFriends().length; x++)
            {
                if (p1.getFriends()[i] == p2.getFriends()[x])
                {
                    Profile common = findNode(p1.getFriends()[i]);
                    commonFriends.add(common.getUserID());
                }
            }
        }
        System.out.println(commonFriends);
    }

    /**
     * Author : Drew
     *
     * @param p //node is the new profile being added to tree
     */
    public void addNode(Profile p) {
        Profile newNode = p;
        Profile currentNode = root;
        Profile previousNode = null;

        if (root == null) {

            add1toTotal();
            root = newNode;
        } else {

            while (currentNode != null) {

                previousNode = currentNode;
                if (newNode.getUserID() < currentNode.getUserID()) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }

            if (newNode.getUserID() < previousNode.getUserID()) {
                add1toTotal();
                previousNode.left = newNode;
            } else {

                add1toTotal();
                previousNode.right = newNode;

            }
        }
    }

    /**
     * Auther : Drew
     *
     * @param p //node is starting point to traverse from
     */
    public void traverseTree(Profile p) {
        if (p != null) {
            traverseTree(p.left);
            traverseTree(p.right);
        }
    }
    /**
     * this allows me to create the tree without having to enter values every time I load the program
     */
    public void addNodeNoInput() {
        Profile newNode = new Profile();
        newNode.setUserID(getTotalProfiles() + 1);
        Profile currentNode = root;
        Profile previousNode = null;

        if (root == null) {
            root = newNode;
        } else {

            while (currentNode != null) {

                previousNode = currentNode;
                if (newNode.getUserID() < currentNode.getUserID()) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }

            if (newNode.getUserID() < previousNode.getUserID()) {

                add1toTotal();
                previousNode.left = newNode;

            } else {

                add1toTotal();
                previousNode.right = newNode;

            }
        }

    }

    /**
     * adding a node from user input with validation
     */
    public void addNodeWithInput()//, int y, int z)
    {
        //values that will be put into the node when the user finishes input

        String username = "null";
        String firstName = "null";
        String surname = "null";
        String workplace = "null";
        String hometown = "null";
        int userID = 0;


        //getting value for string data
        while (true) {
            System.out.println("Enter your user name");
            Scanner scStr = new Scanner(System.in);
            if (scStr.hasNext("[A-Za-z]*")) {
                username = scStr.next();
                break;

            } else {
                System.out.println("Please Enter a Valid Name");
            }
        }


        //getting value for string data
        while (true) {
            System.out.println("Enter your fisrt name");
            Scanner scStr = new Scanner(System.in);
            if (scStr.hasNext("[A-Za-z]*")) {
                firstName = scStr.next();
                break;

            } else {
                System.out.println("Please Enter a Valid Name");
            }
        }

        //getting value for string data
        while (true) {
            System.out.println("Enter your surname name");
            Scanner scStr = new Scanner(System.in);
            if (scStr.hasNext("[A-Za-z]*")) {
                surname = scStr.next();
                break;

            } else {
                System.out.println("Please Enter a Valid Name");
            }
        }

        //getting value for string data
        while (true) {
            System.out.println("Enter your workplace");
            Scanner scStr = new Scanner(System.in);
            if (scStr.hasNext("[A-Za-z]*")) {
                workplace = scStr.next();
                break;

            } else {
                System.out.println("Please Enter a Valid Name");
            }
        }

        //getting value for string data
        while (true) {
            System.out.println("Enter your hometown");
            Scanner scStr = new Scanner(System.in);
            if (scStr.hasNext("[A-Za-z]*")) {
                hometown = scStr.next();
                break;

            } else {
                System.out.println("Please Enter a Valid Name");
            }
        }

        userID = getTotalProfiles() + 1;

        Profile newNode = new Profile(username, firstName, surname, workplace, hometown, userID);
        Profile currentNode = root;
        Profile previousNode = null;


        if (root == null) {
            root = newNode;
        } else {

            while (currentNode != null) {

                previousNode = currentNode;
                if (newNode.getUserID() < currentNode.getUserID()) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }

            if (newNode.getUserID() < previousNode.getUserID()) {
                add1toTotal();
                previousNode.left = newNode;

            } else {
                add1toTotal();
                previousNode.right = newNode;

            }
        }
    }
}