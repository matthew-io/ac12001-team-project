package com.company;

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

        //network.addNodeWithInput();
        //network.addNodeNoInput();

        network.traverseTree(network.root);
    }
}
