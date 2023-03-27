
import java.util.Date;

public class post
{
     
    private String message;
    private String date;
    private String title;
    private int userID;
    private int PostID;
    

     
    public post(String x, String z, String w, int y)
    {
         
        message = x;
        date = z;
        title = w;
        userID = y;
    }

    
    public void setMessage(String y)
    {
        message = y;
    }
    
    public String getMessage(){
        return message;
    }
    
    public int getUserID(){
        return userID;
    }
    
    public void setUserID(int x){
        userID = x;
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
