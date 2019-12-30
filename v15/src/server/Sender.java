package server;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.SocketException;

public class Sender extends Server {
	
	public void run(){
		try
        { 
        	server = new ServerSocket(port); 
        	while(true) {
            
        		
        		
            System.out.println("Sender started"); 
  
            System.out.println("Waiting for a client ..."); 
            try {
            socket = server.accept(); 
            }
            catch (SocketException e) {
            	System.out.println("erro de socket");
            	continue;
            }
            System.out.println("Client accepted in sender");
            talk();
        	list.return_socket(port);//deactivates socket
        	break;
           
        } 
        }
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
	}
	
	public Sender (int porta , String fila, Socketlist lista){
		this.fil=fila;
		port=porta;
		list=lista;
        
    
    } 
  private void talk() {
	  try
      { 
//        System.out.println("C:\\Users\\PC\\Music\\" + fil );
//        File file = new File("C:\\Users\\PC\\Music\\" + fil );
	      System.out.println("E:\\" + fil );
	      File file = new File("E:\\" + fil );
          //long length = file.length();
          
          
        
          byte[] bytes = new byte[16 * 1024];
          //InputStream 
          FileInputStream in = new FileInputStream(file);
          out= new DataOutputStream(socket.getOutputStream());
          int count;
          while ((count = in.read(bytes)) > 0) {
          	out.write(bytes, 0, count);
          }
         
          System.out.flush();
          in.close();
          out.close();
          server.close();
          socket.close();
          
          
          //out.write(new byte[]{0,1,2}, 0, new byte[]{0,1,2}.length);
          //System.out.println("Fim de transmissao");
          
          
          

      } 
      catch(IOException i) 
      { 
          System.out.println(i); 
      } 
  }
	}

