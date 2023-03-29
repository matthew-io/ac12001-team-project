package com.company;

public class Main {
    //test
    public static void main(String[] args) {
//        // create an object of BinaryTree
//        Network network = new Network();
//        Scanner s = new Scanner(System.in);
//        int input;
//        int userID;
//
//        //add nodes of profiles to tree
//        network.addNode(new Profile("BIGWEB", "Drew", "Webster", "Student", "Dundee", network.getTotalProfiles() + 1));
//        network.addNode(new Profile("Jonny03", "John", "Diggs", "Student", "Dundee", network.getTotalProfiles() + 1));
//        network.addNode(new Profile("Lady_Boy1", "Timmy", "Tam", "Aldi", "Dundee", network.getTotalProfiles() + 1));
//        network.addNode(new Profile("GOAT", "Digsby", "Brown", "Student", "Dundee", network.getTotalProfiles() + 1));
//        network.addNode(new Profile("xXGr1ffXx", "Peter", "Griffin", "Aldi", "Dundee", network.getTotalProfiles() + 1));
//
//
//
//
//
//        System.out.println("Welcome to social media");
//
//        while (true) {
//            System.out.println("Enter the ID of your profile or type 0 to create a new profile :");
//            input = s.nextInt();
//
//            if (input == 0)
//            {
//                userID = network.getTotalProfiles() + 1;
//                network.addNodeWithInput();
//                break;
//            }
//
//            else
//            {
//                if (network.findNode(input) != null)
//                {
//                    userID = input;
//                    System.out.println("Welcome back " + network.findNode(userID).getFirstName());
//                    break;
//                }
//
//                else
//                {
//                    System.out.println("COULD NOT FIND USER TRY AGAIN");
//                }
//            }
//        }
//
//        network.addFriends(1, 2);
//        network.addFriends(1, 3);
//
//        network.addFriends(2, 3);
//        network.addFriends(2, 4);
//        network.addFriends(2, 5);
//
//        network.friendsInCommon(1,2);
        Network network = new Network();
        Profile p, x, y, z;

        network.addNode(p = new Profile("jackC", "Peter", "Griffin", "Aldi", "Dundee", network.getTotalProfiles() + 1));
        network.addNode(x = new Profile("matthewM", "Peter", "Griffin", "Aldi", "Dundee", network.getTotalProfiles() + 1));
        network.addNode(y = new Profile("dannyD", "James", "Griffin", "Aldi", "Dundee", network.getTotalProfiles() + 1));
        network.addNode(z = new Profile("smellyT", "Phil", "Griffin", "Aldi", "Dundee", network.getTotalProfiles() + 1));

        p.addFriend(2);
        p.addFriend(4);
        p.setBio("Praesent auctor congue consectetur. Proin in ex non diam interdum maximus id at lorem. Integer in pretium tortor. Nunc ac hendrerit metus. Fusce risus leo, malesuada id urna vel, tristique viverra diam. Sed maximus turpis at nisl tincidunt, id consequat orci bibendum. Morbi ligula odio, tincidunt nec ante a, sodales venenatis est. Vestibulum tristique metus urna, quis hendrerit quam suscipit eget. Etiam viverra a mi et dignissim. Vestibulum sollicitudin neque quis velit tincidunt, vitae mattis nisl varius.");

//
//        LoginFrame frame = new LoginFrame(network);
//        frame.displayFrame();

        LoginFrame loginFrame = new LoginFrame(network);
        loginFrame.displayFrame();
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
}
