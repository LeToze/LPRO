package client;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import list.Track;

public class sequence extends Thread{
	
	String filename;
	//String path="C:\\Users\\PC\\Documents\\";
	String path="C:\\Users\\smcgt\\Desktop\\Server\\";
	//String ip = "192.168.137.3";
	String ip ="192.168.31.120";
	
	Semaphore semaforo;
	Track track;
	ask_file asker;
	savefile saver;
	public sequence(String p , String f,Semaphore in,Track track1){
		path=p;
		filename=f;
		semaforo=in;
		track=track1;
	}
	
	
	public void run(){
		
    	int port=-2;
    	while (true){
	        //ask_file asker = new ask_file("192.168.137.1", 5000,filename,semaforo);
    		if(track.getKaraoke()!=0) {
    			
    	       asker = new ask_file(ip, 5000,filename.replace(".mp3", ".cdg"),semaforo); 
    	        //asker.open();
       
    			port=asker.ask_it();

    	        System.out.println("Porta:" + String.valueOf(port));
    	        
            	if(port > -1){
            
            	//savefile saver = new savefile("192.168.137.1", port, path + filename);
            		
            		
            	saver = new savefile(ip, port, path + filename.replace(".mp3", ".cdg"));
            	saver.save_it();
            	}
    		}
            if(track.getKaraoke()==1)// without vocals
            	asker = new ask_file(ip, 5000,filename.replace(".mp3", "1_.mp3"),semaforo); 
	        //asker.open();
            else
            	asker = new ask_file(ip, 5000,filename,semaforo); 
            
            
			port=asker.ask_it();

	        System.out.println("Porta:" + String.valueOf(port));
	        
        	if(port > -1){
        
        	//savefile saver = new savefile("192.168.137.1", port, path + filename);
        		
        		
        	savefile saver = new savefile(ip, port, path + filename);
        	//saver.open();
        	
        	saver.save_it();
        	track.setDownloaded(3);
        	track.setConverted(1);// its ok to to take the metadata of the file
        	break;
        	}
        	else if(port==-1){
        		try {
        			track.setError(1);
        			track.setDelete(1);
        			track.setDownloaded(0);
					throw new FileException();
				} catch (FileException e) {
					e.printStackTrace();
				}
        		break;
        	}
        	else if(port==-2){
        		System.out.println("There are no available sockets");
        		try {
					TimeUnit.SECONDS.sleep((int)(Math.random()*5));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}// sleeps for 5 seconds and tries again
        		break;
        	}
        }

    } 	
  
}
