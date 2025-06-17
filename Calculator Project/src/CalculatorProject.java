import java.util.Scanner; // import the Scanner class 

class Main {
  public static void main(String[] args) {
	  
	//declare scanner 
    
	Scanner input = new Scanner(System.in);
    
    String userName;
    
    // Enter username and press Enter
    System.out.println("Enter your integer "); 
    userName = input.nextLine();   
       
    System.out.println("Username is: " + userName);        
  }
}
