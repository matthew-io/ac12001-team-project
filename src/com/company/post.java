package com.company;

import java.util.Date;

public class post
{

    private String message;
    private String date;
    private String title;
    private String userName;
    private int PostID;



    public post(String x, String z, String w, String y)
    {

        message = x;
        date = z;
        title = w;
        userName = y;
    }


    public void setMessage(String y)
    {
        message = y;
    }

    public String getMessage(){
        return message;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String x){
        userName = x;
    }

    public String getdate(){
        return date;
    }

    public void setdate(String x){
        date = x;
    }

    public int getPostID(){
        return PostID;
    }

    public void setPostID(int x){
        PostID = x;
    }
}
