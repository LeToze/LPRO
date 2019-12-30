package master;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import client.sequence;
import converter.Converter;
import list.Extract;
import list.Track;

public class Manager extends Thread{
	private ArrayList<Track> tracklist;
	private AtomicInteger CurrentTrack;
	public Manager(ArrayList<Track> tracklist, AtomicInteger currentTrack) {
		this.tracklist=tracklist;
		this.CurrentTrack=currentTrack;
	}
	
	public void run () { 
		Semaphore semaforo = new Semaphore(1);
		
//		System.out.print("Start\n");
		while(true) {
//			if(tracklist.size() > 0) {
//				System.out.println("manager:" +tracklist.get(0).getFilename());
//				System.out.println(tracklist.get(0).getPlayable());
//			}
//			if(this.CurrentTrack.get() == -1 && tracklist.size() > 0) {
//				if(tracklist.get(0).getPlayable() == 1) {
//					this.CurrentTrack.set(0);
//				}
//			}
			
			for(int a=((CurrentTrack.get()+5)>tracklist.size())?tracklist.size():(CurrentTrack.get()+5),  i=CurrentTrack.get();i < a  ;i++) {
				if(tracklist.get(i).isDownloaded() == 2 )  // download done 
					break;
				if(tracklist.get(i).isDownloaded() == 0){
					tracklist.get(i).setDownloaded(2);// Salta diretamente para o estado 2
					Thread t1= new sequence(tracklist.get(i).getFilepath(),tracklist.get(i).getFilename(),semaforo,tracklist.get(i));
			    	t1.start();	
			    	break;
				}
			}

			for(int a=((CurrentTrack.get()-5)>0)?(CurrentTrack.get()-5):0,  i=CurrentTrack.get();i > a  ;i--) {
				if(tracklist.get(i).isDownloaded() == 2 )  // download done 
					break;
				if(tracklist.get(i).isDownloaded() == 0){
					tracklist.get(i).setDownloaded(2);// Salta diretamente para o estado 2
					Thread t1= new sequence(tracklist.get(i).getFilepath(),tracklist.get(i).getFilename(),semaforo,tracklist.get(i));
			    	t1.start();	
			    	break;
				}
			}
			

			
//			for(int i=0;i < tracklist.size();i++) {
//				if(tracklist.get(i).isDownloaded() == 1) { // message to start
//					tracklist.get(i).setDownloaded(2); //started the download
//					Thread t1= new sequence(tracklist.get(i).getFilepath(),tracklist.get(i).getFilename(),semaforo,tracklist.get(i));
//			    	t1.start();	
//				}
//			}
				
				for(int i=0;i < tracklist.size();i++) {
					if(tracklist.get(i).isConverted() == 1) { // message to start
						tracklist.get(i).setConverted(2); //started the download
						Thread t1= new Extract(tracklist.get(i));
				    	t1.start();	
						System.out.println("Downloading...");
					}
			}
				for(int i=0;i < tracklist.size();i++) {
					if(tracklist.get(i).isConverted() == 3) { // message to start converting effetively
						tracklist.get(i).setConverted(4); //started the conversion
						Thread t1= new Converter(tracklist.get(i));
				    	t1.start();	
						System.out.println("Converting...");
					}
		   }
//				for(int i=0;i < tracklist.size();i++) {
//					if(tracklist.get(i).getDelete() == 1) { // message to delete unused musics
//						tracklist.remove(i);
//						i--;
//					}
//		  }
		//System.out.print("Stop\n");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}
  }
}
