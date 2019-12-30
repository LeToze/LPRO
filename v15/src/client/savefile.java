package client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class savefile extends Client {
	
	
    public savefile(String ip, int porti, String path){
    	super(ip,porti);
    	name=path;
    }
    public void save_it(){
 	   this.open();
     	              	   
         try {
             file = new FileOutputStream(name);
             
         } 
         catch (FileNotFoundException ex) {
             System.out.println("File not found. ");
         }

         byte[] bytes = new byte[16*1024];
         try{
         	
         
             int count;
             while ((count = input_s.read(bytes)) > 0) {
             	//System.out.println(count);
             	file.write(bytes, 0, count);
                 //System.out.println("a receber");
             }
             file.flush();
             file.close();
             close();

         }
         catch(IOException i) { 
             System.out.println(i); 
         } 
         
        
         
     } 
	
}
