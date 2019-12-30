package server;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public class Verifier extends Server  {
	private int portinha;
	private Socketlist list;
	private String ficheiro;
	private Sender[] t1=new Sender[10000];
	private int thread_countera=0;
	
	private void set_ficheiro(String in){
		ficheiro=in;
	}
	private String get_ficheiro(){
		return ficheiro;
	}
	public void run(){
		// starts server and waits for a connection 
        try
        { 
        	
        	while(true) {
        	server = new ServerSocket(port); 
            System.out.println("Verifier started"); 
  
            System.out.println("Waiting for a client ..."); 
  
            socket = server.accept(); 
            System.out.println("Client accepted in verifier");
            portinha=talk();
            if(portinha>-1) { //there is a file and a vailable socket
            	System.out.println("Ficheiro a enviar :" + get_ficheiro());
            	//new String input
            	t1[thread_countera] = new Sender (portinha,new String( get_ficheiro()),list);
                t1[thread_countera].start();
                thread_countera++;
            }
            server.close();
            
  
            
           // System.out.println("Closing connection"); 
  
            // close connection 
           // socket.close(); 
            //in.close(); 
        } 
        }
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
   } 
	public Verifier(int porta, int num_of_sockets) 
    { 
        port=porta;
        list= new Socketlist(num_of_sockets);
    
    } 
  
     protected int talk()  {
    	 long length = 0;
    	 try
         { 
    		 DataInputStream in = new DataInputStream( new BufferedInputStream(socket.getInputStream())); 
   
             String line = ""; 
   
             
             DataOutputStream out    = new DataOutputStream(socket.getOutputStream()); 
            
             //	out.writeUTF("5050");
                     line = in.readUTF(); //reicives file name to search
                     System.out.println(line);
                     set_ficheiro(line);
//                     System.out.println("C:\\Users\\PC\\Music\\" + get_ficheiro());
//                     File file = new File("C:\\Users\\PC\\Music\\" + get_ficheiro() );
                     System.out.println("E:\\" + get_ficheiro());
                     File file = new File("E:\\" + get_ficheiro() );
                     length  = file.length();
                  
                     System.out.println(String.valueOf(length) + get_ficheiro());
                    // System.out.println();
                     //System.out.flush();
                     
                     if(length==0) {
                    	 out.writeUTF(String.valueOf(-1));
                      	return -1;
                	 }
                      else {
                    	  int n=list.give_socket(); //see if there are available sockets and returns the number if not -2
		        		  out.writeUTF(String.valueOf(n));
		            	  out.close();
		            	  in.close();
		            	  socket.close();
		            	  return n;                        	    
                      }
    
                 } 
                 catch(IOException i) 
                 { 
                     System.out.println(i); 
                 }
		return -1;
    	 
          	
    }
    
    
	
	
}
