package sql;
import java.sql.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger; 


public class loginn extends Thread{
	
	 private String password;
	 private String username;
	 private boolean ack=false;

	 
	public loginn(String username, String password) {
		
	  		this.password = password;
	  		this.username = username;
	  		
	  		
	  	}
	
	
    static boolean tell_me = false;
	
	public void run() { 
		
		
		  String user = "groovy" ; 
		  String pass = "groovy"; 
		  String url = "jdbc:mysql://192.168.31.120:3306/groovy?useTimezone=true&serverTimezone=UTC"; 
		 
	      
	      //Scanner user_scanner = new Scanner(System.in);   
	    //  Scanner pass_scanner = new Scanner(System.in); 
	      PreparedStatement myStmt = null;
	      ResultSet myRs = null;
	     
//	      String username = null;
//	      String password = null;
//	      
	     
	      
	      try
		    {      
	    	  System.out.println("username "+ this.username + "password " +this.password);
		      Connection conn = DriverManager.getConnection(url, user, pass);  
		      System.out.println("connecting done done");
		      System.out.println("Creating acc mode!");
		      System.out.println();
		      System.out.println("------------------------------------------------------------");
		      
		     
		      
		   //   System.out.println("Insert Username");
		   //   String username = user_scanner.nextLine();
		      if(this.username.equals("")) {
		    	  System.out.println("username is invalid");
		      }
		      
		      
		      System.out.println("Insert Password");
		    //  String password = pass_scanner.nextLine();
		      if(this.password.equals("")) {
		    	  System.out.println("password is invalid");
		      }
		      
		      String hasshed=encryptThisString(this.password);
		    //  System.out.println("encriptei esta merda direito?" + hasshed);
		      
		      
		      myStmt = conn.prepareStatement( "SELECT * FROM login WHERE username = ? AND password= ?");
		      
		      myStmt.setString(1, this.username);
		      myStmt.setString(2, hasshed);
		      
		   
		      myRs = myStmt.executeQuery();
		      String finaluser = display(myRs) ;
		      //user_scanner.close();
		     // pass_scanner.close();
		      this.setAck(true);
		      if(finaluser == null) {
		    	  tell_me=false;
		    	  this.setAck(false);
		    	  System.out.println("user or password wrong! ");
		      }
		      
		      System.out.printf("My name is -> %s \n" , finaluser);
		      
		      System.out.println("fim ");
		      
		      
	      
	      }
	     catch (Exception e)
		    {
		      System.err.println("SHiiet i failed"); 
		      System.err.println(e.getMessage()); 
		    } 
	      }
	
	
	private static String display(ResultSet myRs) throws SQLException {
		String username = null;
		
		while (myRs.next()) {		
			username = myRs.getString("username");				
		}
		
		return username;
	}

	
	public boolean logger(){
		
		if(tell_me == true) {
			
			System.out.print("logguei");
//			this.setAck(true);
			return true;
		}
		else {

			System.out.print("nao logguei");
//			this.setAck(false);
			return false;
			
			}
	}

	
	
	 
	
	
	
	
	public static String encryptThisString(String input) 
    { 
        try { 
            // getInstance() method is called with algorithm SHA-1 
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            // return the HashText 
            return hashtext; 
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }


	public boolean isAck() {
		return ack;
	}


	public void setAck(boolean ack) {
		this.ack = ack;
	} 
  
   
  
    
	
}