package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //test
    public static void main(String[] args) {
        // create an object of BinaryTree
        Network network = new Network();
        Scanner s = new Scanner(System.in);
        int input;
        int userID;

        //add nodes of profiles to tree
        network.addNode(new Profile("BIGWEB", "Drew", "Webster", "Student", "Dundee", network.getTotalProfiles() + 1));
        network.addNode(new Profile("Jonny03", "John", "Diggs", "Student", "Dundee", network.getTotalProfiles() + 1));
        network.addNode(new Profile("Lady_Boy1", "Timmy", "Tam", "Aldi", "Dundee", network.getTotalProfiles() + 1));
        network.addNode(new Profile("GOAT", "Digsby", "Brown", "Student", "Dundee", network.getTotalProfiles() + 1));
        network.addNode(new Profile("xXGr1ffXx", "Peter", "Griffin", "Aldi", "Dundee", network.getTotalProfiles() + 1));

        System.out.println("Welcome to social media");

        while (true) {
            System.out.println("Enter the ID of your profile or type 0 to create a new profile :");
            input = s.nextInt();

            if (input == 0)
            {
                userID = network.getTotalProfiles() + 1;
                network.addNodeWithInput();
                break;
            }

            else
            {
                if (network.findNode(input) != null)
                {
                    userID = input;
                    System.out.println("Welcome back " + network.findNode(userID).getFirstName());
                    break;
                }

                else
                {
                    System.out.println("COULD NOT FIND USER TRY AGAIN");
                }
            }
        }

        network.addFriends(userID, 3);
        network.addFriends(userID, 3);
        network.addFriends(userID, 4);
        network.addFriends(userID, 5);

        network.displayFriends(userID);
    }
}
