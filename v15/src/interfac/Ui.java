package interfac;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import list.Track;

public class Ui extends Thread{
	private FrameGeral frame;
	public Ui(ArrayList<Track> tracklist,ArrayList <Integer> buffer,AtomicInteger currentTrack,FrameGeral frame){
		this.frame=frame;
	}
	
	public void run() {
	      while (true) 
          { 
	    	frame.update();
	    	
	    	try {
	    		TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
          }     
	}
	
}
