package com.company;

public class Main {
    //test
    public static void main(String[] args) {
        // create an object of BinaryTree
        Network network = new Network();

        //add nodes of students to tree
        network.addNode(new Node(new Profile("BIGWEB", "Drew", "Webster", "Student", "Dundee", network.countTotalProfiles(network.root)+1)));
        network.addNode(new Node(new Profile("Jonny03", "John", "Diggs", "Student", "Dundee", network.countTotalProfiles(network.root)+1)));
        network.addNode(new Node(new Profile("Lady_Boy1", "Timmy", "Tam", "Student", "Dundee", network.countTotalProfiles(network.root)+1)));
        network.addNode(new Node(new Profile("GOAT", "Digsby", "Brown", "Student", "Dundee", network.countTotalProfiles(network.root)+1)));

        network.addNodeWithInput();
        network.addNodeNoInput();

        network.traverseTree(network.root);
    }
}
