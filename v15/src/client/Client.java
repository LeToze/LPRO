package client;



	// A Java program for a Client 
import java.net.*;
import java.io.*; 
	  
abstract public class Client
	{ 
	    // initialize socket and input output streams 
		
	    protected Socket socket            = null; 
	   // private :))))
	    protected DataOutputStream out     = null; 
	    protected DataInputStream  input_s   = null; 
	   // protected String path = "";
	    protected String name = "";
	    protected FileOutputStream file = null;
	    //protected String address = "192.168.137.1";
	    //protected String address = "127.0.0.1";
	    protected String address = "192.168.31.120";
	    protected int port =5000;
	    
	    // constructor to put ip address and port
	    
	    
	    
	    public Client(String ip, int porti){
	    	address=ip;
	    	port=porti;
	    	
	    }
	    

	    
	    
	     protected void close(){
	    	
	    	try
	        { 
	            input_s.close(); 
	            out.close(); 
	            socket.close(); 
	        } 
	        
	        catch(IOException i) 
	        { 
	            System.out.println(i); 
	        } 
	    }
	    
	    protected void open(){
	    try{	                    
	        // establish a connection 
	        try
	        {
	          
	        	
	        	socket = new Socket(address, port);
	            System.out.println("Connected"); 
	  
	            
	            out    = new DataOutputStream(socket.getOutputStream());
	            
	            input_s= new DataInputStream(socket.getInputStream());
	        } 
	        catch(UnknownHostException u) 
	        { 
	            System.out.println(u); 
	        } 
	    }
	        catch(IOException i) 
	        { 
	            System.out.println(i); 
	        } 
	    }
	               		

	    
	}  
