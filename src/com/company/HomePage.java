package com.company;

import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HomePage
{
    LinkedList<post> list = new LinkedList<>();
    
    public HomePage()
    {}
    
    public static void main(String[] args){
        
        
        HomePage HP = new HomePage();
        
        HP.list.add(new post("this is the text for this" ,"24/24/24" , "WWWWWW" , 1234));
        HP.list.add(new post("diffrent guy you know" ,"24/24/24" , "WWWWWW" , 12345));
        HP.list.add(new post("wtf is this shit" ,"24/24/24" , "WWWWWW" , 123456));
        HP.list.add(new post("making these is defo boring1" ,"24/24/24" , "WWWWWW" , 4306));
        HP.list.add(new post("making these is defo boring2" ,"24/24/24" , "WWWWWW" , 4306));
        HP.list.add(new post("making these is defo boring3" ,"24/24/24" , "WWWWWW" , 4306));
        HP.list.add(new post("making these is defo boring4" ,"24/24/24" , "WWWWWW" , 4306));
        HP.list.add(new post("gona eat my dinner now" ,"24/24/24" , "WWWWWW" , 12345678));
        HP.list.add(new post("eaten dinner " ,"24/24/24" , "WWWWWW" , 123456789));
        HP.list.add(new post("FOR THE EMPORER" ,"24/24/24" , "WWWWWW" , 1234567891));
        
        
        HP.makePost(4306);
         
        System.out.println(HP.list.size());
        
        System.out.println("this is the posts text of the second object in the linked list " + HP.list.get(1).getMessage());
         
        HP.DisplayUsersPosts(4306);
        //HP.PagePosts();
    }
    
    public void PagePosts(){
        String navigation;
        int endValue = list.size();
        int currentValue = 0;
        
        System.out.println(list.get(currentValue).getUserID());
        while(true){
            
            while(true){
                System.out.println("L to go left R to go right X to quit");
                Scanner myObj = new Scanner(System.in);
                String text = myObj.nextLine(); 
                
                if(text.equals("L") || text.equals("R") || text.equals("X")){navigation = text; break;}
            }
                        
            if(navigation.equals("L")){
                if(currentValue == 0){currentValue = endValue - 1;}
                else{currentValue --;}
            }
            else if(navigation.equals("R")){
                if(currentValue == endValue -1  ){currentValue = 0;}
                else{currentValue ++;}
            }
            else if(navigation.equals("X")){break;}
            
            for(int i = 0; i < list.size() ; i++){
            System.out.println(i + " " + list.get(i).getUserID());
            }
            
            System.out.println(list.get(currentValue).getUserID());
        }
    }
    
    
    public void makePost(int USERID){
        Date thisDate = new Date();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/YY");
        System.out.println("this is the date today " + date.format(thisDate));
        
        String Date = date.format(thisDate);
        String title = "";
        String message = "";
        int userID = 0;

        System.out.println("please enter the title of ur post");
        System.out.println("it has to be less than 15 letters");
        while(true){
             
            Scanner myObj = new Scanner(System.in);
            String text = myObj.nextLine(); 
        
            if(text.length() < 16){
                title = text;
                break;
            }
            else{
                System.out.println("please enter the correct number of letters"); 
            }
        }
        
        
        System.out.println("please enter you're post");
        while(true){
            Scanner myObj = new Scanner(System.in);
            String text = myObj.nextLine(); 
        
            if(text.length() < 250){
                message = text;
                break;
            }
            else{
                System.out.println("please enter the correct number of letters"); 
            }
        }
        
        post newpost = new post(message,Date,title,USERID);
        list.add(newpost);
    }
    
    
    public String DisplayUsersPosts(int LookID){
        
        post[] PostIDS = new post[100];
        
        int arrayval = 0;
        for(int i = 0; i < list.size() ; i++){
            if(list.get(i).getUserID() == LookID){
                PostIDS[arrayval] = list.get(i); 
                System.out.println("one two three" + list.get(i).getUserID());
                arrayval++;}
            }
        
        String navigation;
        int endValue = arrayval;
        int currentValue = 0;
        
        System.out.println(PostIDS[currentValue].getUserID());
        while(true){
            
            while(true){
                System.out.println("L to go left R to go right X to quit D to delete");
                Scanner myObj = new Scanner(System.in);
                String text = myObj.nextLine(); 
                
                if(text.equals("L") || text.equals("R") || text.equals("X") || text.equals("D")) {navigation = text; break;}
            }
                        
            if(navigation.equals("L")){
                if(currentValue == 0){currentValue = endValue - 1;}
                else{currentValue --;}
            }
            else if(navigation.equals("R")){
                if(currentValue == endValue -1  ){currentValue = 0;}
                else{currentValue ++;}
            }
            else if(navigation.equals("D")){
                 list.remove(PostIDS[currentValue]);
                 DisplayUsersPosts(LookID);
            }
            else if(navigation.equals("X")){break;}
            
            for(int i = 0; i < arrayval ; i++){
                System.out.println(i + " " + PostIDS[i].getUserID());
            }
            
            return (PostIDS[currentValue].getUserID() + " " + PostIDS[currentValue].getMessage());
        }

        return null;
    }
}
