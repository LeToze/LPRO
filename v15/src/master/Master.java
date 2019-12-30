package master;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import list.Track;
import playmusic.EndCheck;
// this Has new new stuff
import playmusic.SimpleAudioPlayer;
//
import sql.mysql;

// Java program to play an Audio 
// file using Clip Object 

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import cdg.cdg;

	// to store current position 
   
  
public class Master extends Thread{
	AtomicInteger currentTrack;
	private ArrayList<Track> tracklist;
	String filename;
	
	
	//////////////////////////////////////////////////////////////////////////////////////
	      
	    // current status of clip 
	   
	      
	    AudioInputStream audioInputStream; 
	    FloatControl gainControl;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	boolean init=false;
	private SimpleAudioPlayer audioPlayer;
	private ArrayList<Integer> buffer;
	private String search;
	//private String seek;
	private int search_mode;
	private cdg cdg1 = new cdg();
	
	
	public Master(ArrayList<Track> tracklist, ArrayList<Integer> buffer, AtomicInteger currentTrack,String seek,int search_mode){
		this.tracklist = tracklist;
		this.buffer= buffer;
		this.currentTrack=currentTrack;
		//this.seek=seek;
		this.search_mode=search_mode;
	}
	
	public void run() {
		while(true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				gotoChoice(buffer,tracklist);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				e1.printStackTrace();
			} 
			if(init==false &&  tracklist.size()>0) {
				
				if(tracklist.get(currentTrack.get()).getPlayable() == 1) // the music is converted and playable
				{	
					if(this.tracklist.get(currentTrack.get()).getKaraoke() !=0) {
						cdg1.play_file(this.tracklist.get(currentTrack.get()).getOffset(),this.tracklist.get(currentTrack.get()).getFilepath()+this.tracklist.get(currentTrack.get()).getFilename().replace("wav", "cdg"));
						
						
					}
					
					
					
					
					//System.out.print("Master chief playable\n");
					init=true;
					try {
						audioPlayer =  new SimpleAudioPlayer(tracklist, currentTrack);
					}catch (IllegalArgumentException | UnsupportedAudioFileException | IOException
							| LineUnavailableException e) {
						e.printStackTrace();
					}
						try {
							audioPlayer.play();
						} catch (LineUnavailableException | IOException e) {
							e.printStackTrace();
						}
	
						EndCheck thread2 = new EndCheck("Thread2",audioPlayer);
					    thread2.start();
				}
			}
			
			if(init == true) {
				//System.out.println(audioPlayer.clip.getMicrosecondPosition()/1000000);
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
						
}
        

//		audioPlayer.gotoChoice(c,tracklist); // applies the choice
//            
//            if ((c == 8 || c == 9) && !last) {
//            	String track1 = App.getLibrary().get(getI()-1).getFilepath();
//            	setFilePath(directory_wav+ track1); 
//            	audioPlayer.resetAudioStream();
//            	audioPlayer.play();
//            }
//            
//            if (c == 4)
//            	break; 
//       }
//        thread2.interrupt();
	}

	private void gotoChoice(ArrayList<Integer> buffer, ArrayList<Track> tracklist) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 if(buffer.size()>0) {
			 Integer c = buffer.remove(0);
			System.out.print("input:" + c);
			 
			//Integer c1 = 0;
			switch (c)  
	        { 
	            case 1: 
	            	if(tracklist.size() > 0) 
	    	  			if(tracklist.get(currentTrack.get()).getPlayable() == 1) { 
			            	audioPlayer.pause();
			            	if(tracklist.get(currentTrack.get()).getKaraoke() == 1 || tracklist.get(currentTrack.get()).getKaraoke() == 2) 
			            		cdg1.pause();
			            	}
	                		break; 
	            case 2: 
				try {
					if(tracklist.size() > 0) 
	    	  			if(tracklist.get(currentTrack.get()).getPlayable() == 1) {
							audioPlayer.resumeAudio(tracklist.get(currentTrack.get()));
							if(tracklist.get(currentTrack.get()).getKaraoke() == 1 || tracklist.get(currentTrack.get()).getKaraoke() == 2)
			            		cdg1.resume(0);
	            	}
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				} 
	                break; 
	            case 3: 
				try {
					if(tracklist.size() > 0) 
	    	  			if(tracklist.get(currentTrack.get()).getPlayable() == 1) { 
							audioPlayer.restart(tracklist.get(currentTrack.get()));
							
							if(tracklist.get(currentTrack.get()).getKaraoke() == 1 || tracklist.get(currentTrack.get()).getKaraoke() == 2) 
								cdg1.pause();
								cdg1.play_file(this.tracklist.get(currentTrack.get()).getOffset(),this.tracklist.get(currentTrack.get()).getFilepath()+this.tracklist.get(currentTrack.get()).getFilename().replace("wav", "cdg"));
	            	}
				} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e1) {
					e1.printStackTrace();
				} 
	                break; 
	            case 4: 
	                //stop(); 
	                break;
	            case 5:
	            	//System.out.print(this.seek);
	            	//c1= Integer.valueOf(this.seek);
	            	//System.out.print("Number:"+ c);
	            	if(tracklist.size() > 0) 
	    	  			if(tracklist.get(currentTrack.get()).getPlayable() == 1){ 
			            	 c = buffer.remove(0);
			            	System.out.println("Enter time in seconds(" + 0 +  ", " + this.tracklist.get(currentTrack.get()).getLength() + ")"); 
			            	if(c >= 0 && c <= this.tracklist.get(currentTrack.get()).getLength())
			            		buffer.add(50000+c);
	    	  		}
	            case 6:
	            	if(tracklist.size() > 0) 
	    	  			if(tracklist.get(currentTrack.get()).getPlayable() == 1) 
	            	audioPlayer.volumeUp();
	            	break;
	            case 7:
	            	if(tracklist.size() > 0) 
	    	  			if(tracklist.get(currentTrack.get()).getPlayable() == 1) 
	            	audioPlayer.volumeDown();
	            	break;
	            case 8:
	            	audioPlayer.nextTrack();
	            	break;
	            case 9:
	            	audioPlayer.prevTrack();
	            	break;
	            case 10:
	            	audioPlayer.pause();
	            	tracklist.clear();
	            	currentTrack.set(0);
	            	break; 
	            case 11: 
	            	System.out.print("Search:"+this.search);
	            	System.out.print("search_mode:"+search_mode);
	            	Thread t1 = new mysql(tracklist,this.search,this.search_mode);
	              	t1.start();
	              	try {
	              		t1.join();
	              	}catch (InterruptedException e) {
	  				e.printStackTrace();
	              	};
	              	break;
	            case 12:
	            	  if(tracklist.get(currentTrack.get()).getKaraoke() == 1 || tracklist.get(currentTrack.get()).getKaraoke() == 2) {
							cdg1.jump(100);
							System.out.println("Saltei");
		            	}
	            case 13:
	            	  if(tracklist.get(currentTrack.get()).getKaraoke() == 1 || tracklist.get(currentTrack.get()).getKaraoke() == 2) {
							cdg1.jump(-100);
							System.out.println("Saltei");
		            	}
	            default:
	            	if(c>=50000 && c<=59999 ) {
		                if(c < audioPlayer.getClip().getMicrosecondLength()){
		                	try {
		                		System.out.print("Valor do salto" + c);
		                		audioPlayer.jump((long)(c-50000)*1000000,tracklist.get(currentTrack.get()));
							} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
								e.printStackTrace();
							}
		                }
//		                if(tracklist.get(currentTrack.get()).getKaraoke() == 1 || tracklist.get(currentTrack.get()).getKaraoke() == 2) {
//							cdg1.jump(100);
//		            	}
		                
		                else {
		                	System.out.print("This time is bigger than the song itself!\n");
		                }
		                
		                break;
	            	}
	            	
	        }
		 }
	}
	
	void setSearch(String search){
		this.search=search;
	}

	public void setSearch_mode(int search_mode2) {
		this.search_mode=search_mode2;
		
	}
	
}	

	
	
	
	