package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

                Profile p = new Profile(username, firstName, surname, workplace, hometown, network.getTotalProfiles() + 1);
                network.addNode(p);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            File file = new File("src/com/company/postInfo.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String[] lineArr = scan.nextLine().split(",,,;;;,,,");
                int userId = Integer.parseInt(lineArr[2]);
                Profile p = network.findNode(userId);
                p.createPost(lineArr[0]);
            };
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            File file = new File("src/com/company/postInfo.txt");
//            Scanner scanner = new Scanner(file);
//
//            int counter = 0;
//            while (scanner.hasNextLine()) {
//                String[] arrayValue = scanner.nextLine().split(",,,;;;,,,");
//
//                network.setMessages(counter,arrayValue[0]);
//                System.out.println(arrayValue[0]);
//                network.setDates(counter,arrayValue[1]);
//                System.out.println(arrayValue[1]);
//                network.setPostUserID(counter,Integer.parseInt(arrayValue[2]));
//                System.out.println(arrayValue[2]);
//                counter += 1;
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Error: " + e.getMessage());
//        }

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

