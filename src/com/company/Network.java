import java.util.Scanner;
/**
 * @author (Alexander Gordon)
 * 
 */
public class Network
{
    // instance variables
    public Profile Root;
    public int total;
    public Profile lowestNode;
    public Profile parentLowestNode;
    
    /**
     * Constructor for objects of class Tree
     */
    public Network()
    {
        // initialise instance variables
        Profile Root;
        total = 0;
        
    }

    
    /** this allows me to create the tree without having to enter values every time I load the program */   
    public void addNodeNoInput(int x , String y , double z)
    {
        Profile NewNode = new Profile(); //makes the Node and populates it
        
        if(Root == null){Root = NewNode;}
        
        else{
            
            Profile currentNode = Root;
            
            Profile ParentNode;
            
            
            
            while(true)
            {   
                ParentNode = currentNode;
                //incert into tree left
                if(NewNode.getUserID() < currentNode.getUserID())
                {
                    currentNode = currentNode.LeftNode;
                    if(currentNode == null)
                    {
                        ParentNode.LeftNode = NewNode;
                        return;
                    }
                }
                //incert into tree right
                else
                {
                    currentNode = currentNode.RightNode;
                
                    if(currentNode == null)
                    {
                        ParentNode.RightNode = NewNode;
                        return;
                    
                    }
                
                
                }
            
            
            }
        }
        
        
        
    }
    
    
    
    /** adding a node from user input with validation */
    public void addNode()//, int y, int z)
    {
        Profile newOne;
        
        
        //values that will be put into the node when the user finishes input
        
        String username = "null";
        String firstName = "null";
        String surname = "null";
        String workplace = "null";
        String hometown = "null";
        int userID = 0;
        
        
        
        
        //getting value for string data
        while(true)
        {
            System.out.println("Enter your user name");
            Scanner scStr = new Scanner(System.in);
            if(scStr.hasNext("[A-Za-z]*")) {
                username = scStr.next();
                break;
                 
            }else {
                System.out.println("Please Enter a Valid Name");
            }
        }
        
        
        //getting value for string data
        while(true)
        {
            System.out.println("Enter your fisrt name");
            Scanner scStr = new Scanner(System.in);
            if(scStr.hasNext("[A-Za-z]*")) {
                firstName = scStr.next();
                break;
                 
            }else {
                System.out.println("Please Enter a Valid Name");
            }
        }
        
        //getting value for string data
        while(true)
        {
            System.out.println("Enter your surname name");
            Scanner scStr = new Scanner(System.in);
            if(scStr.hasNext("[A-Za-z]*")) {
                surname = scStr.next();
                break;
                 
            }else {
                System.out.println("Please Enter a Valid Name");
            }
        }
        
        //getting value for string data
        while(true)
        {
            System.out.println("Enter your workplace");
            Scanner scStr = new Scanner(System.in);
            if(scStr.hasNext("[A-Za-z]*")) {
                workplace = scStr.next();
                break;
                 
            }else {
                System.out.println("Please Enter a Valid Name");
            }
        }
        
        //getting value for string data
        while(true)
        {
            System.out.println("Enter your hometown");
            Scanner scStr = new Scanner(System.in);
            if(scStr.hasNext("[A-Za-z]*")) {
                hometown = scStr.next();
                break;
                 
            }else {
                System.out.println("Please Enter a Valid Name");
            }
        }
        
        
        
        //getting value for integer data 
        while(true)
        {
            System.out.println("Enter Product userID");
            Scanner scStr = new Scanner(System.in);
            if(scStr.hasNextInt()) {
                userID = scStr.nextInt(); 
                break;
                 
            }else {
                System.out.println("Please Enter a Valid ID");
            }
        }
        
        
    
        /** instead of the user entering the id just add one to the number of users*/
        
        
        
        
        
        if(doesItemExist(ID) == false){
            TreeNode NewNode = new TreeNode(ID , Name , Cost);
            
            if(Root == null){Root = NewNode;}
            
            else{
                
                TreeNode currentNode = Root;
                
                TreeNode ParentNode;
                
                
                
                while(true)
                {   
                    ParentNode = currentNode;
                    //incert into tree left
                    if(NewNode.GetID() < currentNode.GetID())
                    {
                        currentNode = currentNode.LeftNode;
                        if(currentNode == null)
                        {//right
                            ParentNode.LeftNode = NewNode;
                            return;
                        }
                    }
                    //incert into tree right
                    else
                    {
                    currentNode = currentNode.RightNode;
                    
                    if(currentNode == null)
                    {
                        ParentNode.RightNode = NewNode;
                        return;
                    
                    }
                    
                    
                    }
                
                
                }
            }
        }
        
        else{System.out.println("item already exists");}
        
        
        
        
    }
    
    
    /** traverses the tree and prints it out in order */
    public void printInOrderTree(Profile currentNode)
    {
        
        
        if(currentNode != null)
        {
            printInOrderTree(currentNode.LeftNode);
            
            System.out.println("ID = " + currentNode.getUserID() + "   Item name = " + currentNode.getUsername() + "  Full name = " + currentNode.getFirstName() + " " + currentNode.getSurname());
            
            printInOrderTree(currentNode.RightNode);
        }
        
        
    }
    
    /** calculates total cost by going through the tree and totaling the data each time */
    /**
    public int totalCost(Profile currentNode)
    {
        
        if(currentNode != null)
        {
            totalCost(currentNode.LeftNode);
            
            
            total += currentNode.getSurname();
            
            
            totalCost(currentNode.RightNode);
            
            
        }
        
        return total;
    }
    */
    
    
    
    /** finds the lowest value of the rightNode to replace the node with 2 branches */
    public void findLowestNode(Profile currentNode)
    {
        
        
        if(currentNode != null)
        {
            lowestNode = currentNode;
            findLowestNode(currentNode.LeftNode);
            
        
        }
        
          
        
        
    }
    
    
    
    /** finds the lowest values parentNode of the rightNode to replace the node with 2 branches */
    public void findParentLowestNode(Profile currentNode)
    {   Profile node = currentNode;
        
         while(true){
             
             
             
             
             if(node.LeftNode.LeftNode == null){ parentLowestNode = node; break;}
             else{System.out.println("this is the node for lowest parent node " + node.LeftNode.getUserID()); node = node.LeftNode;}
            
            
        }
    }
    
    
    /** this is a binary search for the tree */
    public void findItem(int FindID)
    {
        
        Profile currentNode = Root;
        while(true)
        { 
            
            if(currentNode == null){System.out.println("user does not exsit"); break;}
            
            if(currentNode.getUserID() == FindID)
            {
                System.out.println("Name of user: " + FindID + " is " + currentNode.GetName() );
                System.out.println("the cost of this item is " + currentNode.GetName() + " :" + currentNode.GetCost());
                break;
            }
            
            else if(currentNode != null)
            {
                if(currentNode.GetID() < FindID){currentNode = currentNode.RightNode;}//if the the goal is greater than the node go right 
                else{currentNode = currentNode.LeftNode;}//if the goal is less than the node go left
            }
            
        
        }         
     
        
    
    }
    
    
    /** a binary seach but if it cant find the item then it returns false 
    * this was created for the delete method
    */
    public boolean doesItemExist(int FindID)
    {
        boolean doesIt = false;
        TreeNode currentNode = Root;
        while(true)
        {
            
            if(currentNode == null){System.out.println("item does not exsit"); doesIt = false; break;}
            
            if(currentNode.GetID() == FindID)
            {
                doesIt = true; 
                break;
            }
            
            else if(currentNode != null)
            {
                if(currentNode.GetID() < FindID){currentNode = currentNode.RightNode;}
                else{currentNode = currentNode.LeftNode;}
            }
            
        
        }         
     
        
        return doesIt;
    }

  
    
    
    
    
    
    public void deleteItem(int FindID)
    {   
        
        TreeNode currentNode = Root; 
        TreeNode parentNode = Root;
        
        
        
        while(true)
        {
            
        if(currentNode == null){System.out.println("item does not exsit"); break;}
            
            if(currentNode.GetID() == FindID)
            {
                System.out.println("the data of the item you are deleting");
                System.out.println("Name of item is: " + currentNode.GetName() );
                System.out.println("the cost of this item is " + currentNode.GetName() + " :" + currentNode.GetCost());
                System.out.println("ID of the item is : " + currentNode.GetID());
                
                
                
                // 2 branches
                if(currentNode.LeftNode != null && currentNode.RightNode != null)
                {
                    
                    
                    //finds the lowest and the parent of the lowest so that the tree doesnt have duplicate data
                    findLowestNode(currentNode.RightNode);
                    findParentLowestNode(currentNode.RightNode);
                    
                     
                    //to make sure that the right if statment was entered
                    if(lowestNode.LeftNode == null && lowestNode.RightNode == null)
                    {
                        // deleting a node with 2 branches that is on the left side of the parent and the lowest value of that branch has two null values
                        if(parentNode.LeftNode.GetID() == currentNode.GetID()){ //55 is true  
                            //System.out.println("in side of the left side deletion LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
                            
                            
                            
                            if(currentNode.RightNode.GetID() == lowestNode.GetID() ){
                                //System.out.println("in single right node deletion");
                                if(parentNode.GetID() > currentNode.GetID()){
                                    
                                    
                                    
                                    lowestNode.RightNode = null;
                                    lowestNode.LeftNode = currentNode.LeftNode;
                                    
                                    
                                    currentNode = lowestNode;
                                    
                                    parentNode.LeftNode = currentNode;
                                    
                                    
                                }
                            }    
                            
                            
                            
                            
                                
                            else{
                                 
                                lowestNode.RightNode = currentNode.RightNode;
                                lowestNode.LeftNode = currentNode.LeftNode;
                                currentNode = lowestNode;
                                      
                                parentNode.LeftNode = currentNode;
                                                              
                                parentLowestNode.LeftNode = null;                            
                                }
                            }
                        // if the root is being deleted then this catches it and uses diffrent logic    
                        else if(currentNode.GetID() == Root.GetID()){ 
                            System.out.println("in root deletion");
                            findParentLowestNode(Root.RightNode);
                                
                            lowestNode.RightNode = Root.RightNode;
                            lowestNode.LeftNode = Root.LeftNode;
                                
                            Root = lowestNode;        
                                
                            parentLowestNode.LeftNode = null;
                            }
                            
                        //handles right side of root 
                        else if(parentNode.RightNode.GetID() == currentNode.GetID() && currentNode.RightNode.LeftNode != null){
                            
                            
                            lowestNode.RightNode = currentNode.RightNode;
                            lowestNode.LeftNode = currentNode.LeftNode;
                            
                            parentNode.RightNode = lowestNode;
                            
                            parentLowestNode.LeftNode = null;
                            
                            
                        }  
                        
                        else if(currentNode.RightNode.RightNode == null && currentNode.RightNode.LeftNode == null && 
                            currentNode.LeftNode.RightNode == null && currentNode.LeftNode.LeftNode == null ){
                                
                            lowestNode.RightNode = null;
                            lowestNode.LeftNode = currentNode.LeftNode;
                            
                            parentNode.RightNode = lowestNode;
                            
                            lowestNode = null;
                        
                        }
                            
                            
                            
                            
                    }
                    }
                
                
                
                
                //leaf Node Delete
                else if(currentNode.LeftNode == null && currentNode.RightNode == null)
                {
                    System.out.println("in 0");
                    if(parentNode.LeftNode == currentNode){parentNode.LeftNode = null;}
                    else if(parentNode.RightNode == currentNode){parentNode.RightNode = null;}
                }
 
                
                //delete while right node ocupied
                else if(currentNode.RightNode != null && currentNode.LeftNode == null)
                {
                    System.out.println("in 1");
                    
                    parentNode.RightNode = currentNode.RightNode;
                    //currentNode.RightNode = null;
                }
                
                
                //delete while left node ocupied
                else if(currentNode.LeftNode != null && currentNode.RightNode == null)
                {
                    System.out.println("in 1.1");
                    parentNode.LeftNode = currentNode.LeftNode;
                    currentNode.LeftNode = null;
                }
                
                break;
            }
            
            else if(currentNode != null)
            {
                if(currentNode.GetID() < FindID){parentNode = currentNode; currentNode = currentNode.RightNode; }
                
                
                else{parentNode = currentNode; currentNode = currentNode.LeftNode;}
        }         
         
        
        
    
    
    
    
    
    
    }
}

}
