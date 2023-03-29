package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    //test
    public static void main(String[] args) {

        Network network = new Network();

        //get profile data from files and add to network
        try {
            //here you need to change the absoloute path to whateer it is on your computer i think
            File file = new File("src/com/company/profiles.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] fields = scanner.nextLine().split(",");

                String username = fields[0];
                String firstName = fields[1];
                String surname = fields[2];
                String workplace = fields[3];
                String hometown = fields[4];

                network.addNode(new Profile(username, firstName, surname, workplace, hometown, network.getTotalProfiles() + 1));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Profile p = network.findNode(1);
        network.traverseTree(p);
        network.addFriends(1, 2);
        network.addFriends(1, 4);
        network.findNode(1).setBio("Praesent auctor congue consectetur. Proin in ex non diam interdum maximus id at lorem. Integer in pretium tortor. Nunc ac hendrerit metus. Fusce risus leo, malesuada id urna vel, tristique viverra diam. Sed maximus turpis at nisl tincidunt, id consequat orci bibendum. Morbi ligula odio, tincidunt nec ante a, sodales venenatis est. Vestibulum tristique metus urna, quis hendrerit quam suscipit eget. Etiam viverra a mi et dignissim. Vestibulum sollicitudin neque quis velit tincidunt, vitae mattis nisl varius.");


        LoginFrame loginFrame = new LoginFrame(network);
        loginFrame.displayFrame();
    }
}

//    public static void menu() {
//        Scanner scan = new Scanner(System.in);
//        Boolean exit, validUser;
//        exit = validUser = false;
//        int userId, choice;
//
//        // LOGIN / ACCOUNT CREATION MENU
//
//        while (!exit) {
//
//            System.out.println("Welcome to the Social Network\nPlease choose an option from below: " +
//                    "\n1. Log in" +
//                    "\n2. Create an account" +
//                    "\n3. Exit");
//            choice = scan.nextInt();
//
//            switch(choice) {
//                case 1:
//                    while (!validUser) {
//                        try {
//                            System.out.println("Please enter your user ID: ");
//                            userId = scan.nextInt();
//                            if (network.findNode(userId) == null) {
//                                System.out.println("Could not find user");
//                            } else {
//                                p = network.findNode(userId);
//                                validUser = true;
//                                exit = true;
//                            }
//                        } catch (InputMismatchException e) {
//                            System.out.println("Invalid character. Please enter again.");
//                            scan.next();
//                        }
//                    }
//                    break;
//                case 2:
//                    network.addNodeWithInput();
//                    break;
//                case 3:
//                    exit = true;
//                    break;
//            }
//
//            // MAIN MENU - DISPLAYS WHEN USER LOGS IN SUCCESSFULLY
//
//            if (validUser) {
//                System.out.println("Logged in successfully. Welcome " + p.getFirstName() + ".");
//                exit = false;
//                int friendId;
//
//                while(!exit && validUser) {
//                    Boolean friendAdded = false;
//
//                    System.out.println("Please choose an option from below: " +
//                            "\n1. Add friend" +
//                            "\n2. View friends" +
//                            "\n3. View friends of friend" +
//                            "\n4. View friends in common" +
//                            "\n5. Logout" +
//                            "\n6. Exit");
//                    choice = scan.nextInt();
//
//                    switch(choice) {
//                        case 1:
//                            while (!friendAdded) {
//                                try {
//                                    System.out.println("Enter the ID of the friend you would like to add: ");
//                                    friendId = scan.nextInt();
//                                    p.addFriend(friendId);
//                                    friendAdded = true;
//                                } catch(InputMismatchException e) {
//                                    System.out.println("Invalid character");
//                                    scan.next();
//                                }
//                            }
//                            break;
//                        case 2:
//                            network.displayFriends(p.getUserID());
//                            break;
//                        case 3:
//                            network.displayFriendsOfFriend(p.getUserID());
//                            break;
//                        case 4:
//                            Boolean foundFriend = false;
//                            while (!foundFriend)
//                                try {
//                                    System.out.println("Enter the ID of the friend you would like to find friends in common with: ");
//                                    friendId = scan.nextInt();
//                                    network.compareFriends(p.getUserID(), friendId);
//                                    foundFriend = true;
//                                } catch (InputMismatchException e) {
//                                    System.out.println("Invalid character");
//                                    scan.next();
//                                }
//                            break;
//                        case 5:
//                            validUser = false;
//                            break;
//                        case 6:
//                            exit = true;
//                            break;
//                    }
//                }
//            }
//        }
//    }

