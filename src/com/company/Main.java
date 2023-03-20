package com.company;

import java.util.Arrays;

public class Main {
    //test
    public static void main(String[] args) {
        // create an object of BinaryTree
        Network network = new Network();

        //add nodes of students to tree
        network.addNode(new Profile("BIGWEB", "Drew", "Webster", "Student", "Dundee", network.getTotalProfiles()+1));
        network.addNode(new Profile("Jonny03", "John", "Diggs", "Student", "Dundee", network.getTotalProfiles()+1));
        network.addNode(new Profile("Lady_Boy1", "Timmy", "Tam", "Student", "Dundee", network.getTotalProfiles()+1));
        network.addNode(new Profile("GOAT", "Digsby", "Brown", "Student", "Dundee", network.getTotalProfiles()+1));
        network.addNode(new Profile("xXGr1ffXx", "Peter", "Griffin", "Aldi", "Dundee", network.getTotalProfiles()+1));

        network.traverseTree(network.root);

        network.addFriends(1,2);
        network.addFriends(1,3);
        network.addFriends(1,4);
        network.addFriends(1,5);

        network.addFriends(2,3);
        network.addFriends(2,4);

        network.displayFriendsOfFriend(1);
    }
}
