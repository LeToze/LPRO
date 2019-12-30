package client;

import java.io.IOException;
import java.util.concurrent.Semaphore;

public class ask_file extends Client{
	private Semaphore semaforo=null;
    public ask_file(String ip, int porti,String n,Semaphore in)  {
	    // string to read message from input 
	        	        // keep reading until "Over" is input 
	        super(ip,porti);
	    	name=n;
	    	semaforo=in;
	    	}
	public int ask_it() {
       
        
        	System.out.println("New File: " + name);
        	try {
				this.semaforo.acquire();
			} catch (InterruptedException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
        		
        	System.out.println("permissao garantida");
            this.open();
         // if(out.)
        	
            try {
				out.writeUTF(name);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} 
            String resposta="";
            
            try {
				resposta=input_s.readUTF();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            int porta=-1;
            try{
            	porta=Integer.parseInt(resposta);
            }
            
            
            catch (NumberFormatException e){
            	System.out.println("Nao é uma porta");
            }
            System.out.println(String.valueOf(porta));
            close();
            semaforo.release();
            
            System.out.println("Porta por onde receber" + String.valueOf(porta));
            
            port=porta;
    		return port;
            		
	           
}
	 
}
