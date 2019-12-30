package server;
// A Java program for a Server 
import java.net.*; 
import java.io.*; 
  
abstract public class Server extends Thread 
{ 
    //initialize socket and input stream 
    protected Socket          socket   = null; 
    protected ServerSocket    server   = null; 
    protected DataOutputStream out =  null;
    protected int port;
    protected String fil;
    protected Socketlist list;
    
} 
