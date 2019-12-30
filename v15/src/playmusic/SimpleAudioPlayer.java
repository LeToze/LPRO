package playmusic;
// Java program to play an Audio 
// file using Clip Object 

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import list.Track;

public class SimpleAudioPlayer{
	// to store current position 
    private Long currentFrame; 
    private Clip clip;
    // current status of clip 
    private String status;  
    private AudioInputStream audioInputStream; 
    private static String filePath;
    private FloatControl gainControl;
	private ArrayList<Track> tracklist;
	private AtomicInteger currentTrack;
	private int next;
    private static float gain = 0;
    private static int volumeBar = 0; // 0 a 100 %
    private static float max=0;
    private static float min=0;
    //private static int i=1; // number of the track
    //private static boolean last;
//    private final static String directory_mp3 = "C:\\Users\\smcgt\\Desktop\\Music_Library_mp3\\";
//    private final static String directory_wav = "C:\\Users\\smcgt\\Desktop\\Music_Library_wav\\";
  
        // constructor to initialize streams and clip 
    	public SimpleAudioPlayer(ArrayList<Track> tracklist,AtomicInteger currentTrack) 
        throws UnsupportedAudioFileException, 
        IOException, LineUnavailableException, IllegalArgumentException  
    { 	
    	   this.tracklist=tracklist;
    	   this.setCurrentTrack(currentTrack);
////    	App app = new App();
//    	// create AudioInputStream object 
//        audioInputStream =  AudioSystem.getAudioInputStream(new File(tracklist.get(0).getFilepath()+tracklist.get(0).getFilename()).getAbsoluteFile());
//        System.out.print("Audio \n");
//        // create clip reference 
//        clip = AudioSystem.getClip();
//        
//        // open audioInputStream to the clip 
//        clip.open(audioInputStream);
//        
//        gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//        max=gainControl.getMaximum();
//        min=gainControl.getMinimum();
//        
//        for(int i=0; i < 3;i++) {
//        	volumeDown();
//        }
    }

//	public static void main(String[] args)  
//    { 
//		//Integer currentTrack= new Integer(0);
//		AtomicInteger currentTrack = new AtomicInteger();
//		currentTrack.set(0);
//		
//		final ArrayList <Integer> buffer = new ArrayList <Integer>();
//		final ArrayList<Track> tracklist = new ArrayList<Track>();
//		Thread manage = new Manager(tracklist,currentTrack);
//		manage.start();
//		Thread masterchef = new MasterChief(tracklist,buffer,currentTrack);
//		masterchef.start();
//		Thread ui = new Ui(tracklist, buffer);
//		ui.start();
//		
////		try {
////			masterchef.join();
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}
//		while(true);
//		
////        try
////        { 
////        	
////            
////            Scanner sc = new Scanner(System.in); 
////            MyThread thread2 = new MyThread("Thread2",audioPlayer);
////            thread2.start();
////              
////            while (true) 
////            { 
////                System.out.println("1. Pause"); 
////                System.out.println("2. Resume"); 
////                System.out.println("3. Restart"); 
////                System.out.println("4. Stop"); 
////                System.out.println("5. Jump to specific time");
////                System.out.println("6. Increase Volume");
////                System.out.println("7. Decrease Volume");
////                System.out.println("8. Next Song");
////                System.out.println("9. Previous Song");
////                System.out.println("10. Like");
////                System.out.println("11. Search");
////                
////                ArrayList<Integer> buffer = new ArrayList<Integer>();
////                buffer.add(sc.nextInt()); 
////                audioPlayer.gotoChoice(c,tracklist); // applies the choice
////                
////                if ((c == 8 || c == 9) && !last) {
////                	String track1 = App.getLibrary().get(getI()-1).getFilepath();
////                	setFilePath(directory_wav+ track1); 
////                	audioPlayer.resetAudioStream();
////                	audioPlayer.play();
////                }
////                
////                if (c == 4)
////                	break; 
////           }
////            thread2.interrupt();
////            assert(thread2.isInterrupted());
////            System.out.print("Liked Songs\n");
////            App.getLiked().show();
////            sc.close();
////        }  
////          
////        catch (Exception ex)  //if try fails
////        { 
////            System.out.println("Error with playing sound."); 
////            ex.printStackTrace(); 
////          
////          } 
//    }
//	

	//check if the position of the clip is the same as the length of the track
    boolean endcheck() {
    	if(getClip().getMicrosecondPosition() == getClip().getMicrosecondLength()) {
    		return true;
    	}
    	return false;
    }   
    
//    // Work as the user enters his choice   
//    private void gotoChoice(int c,ArrayList<Track> tracklist) 
//            throws IOException, LineUnavailableException, UnsupportedAudioFileException  
//    {	
//        switch (c)  
//        { 
//            case 1: 
//                pause(); 
//                break; 
//            case 2: 
//                resumeAudio(); 
//                break; 
//            case 3: 
//                restart(); 
//                break; 
//            case 4: 
//                stop(); 
//                break; 
//            case 5: 
//                System.out.println("Enter time in seconds(" + 0 +  
//                ", " + clip.getMicrosecondLength()/1000000 + ")"); 
//                Scanner sc = new Scanner(System.in); 
//                long c1 = sc.nextLong();
//                c1 *= 1000000;
//                if(c1 < clip.getMicrosecondLength()){
//                	jump(c1);
//                }
//                else {
//                	System.out.print("This time is bigger than the song itself!\n");
//                }
//                break;
//            case 6:
//            	volumeUp();
//            	break;
//            case 7:
//            	volumeDown();
//            	break;
//            case 8:
//            	if(getI() < 3) {
//            		setI(getI() + 1);
//            		stop();
//            		last=false;
//            	}
//            	else {
//            		last=true;
//            	}
//                break;
//            case 9:
//            	if(getI() > 1) {
//            		setI(getI() - 1);
//            		stop();
//            		last=false;
//            	   }
//            	else {
//            		last=true;
//            	}
//                break;
//            case 10:
//            	
//            	break;
//            case 11: 
//            	Thread t1 = new mysql(tracklist);
//            	t1.start();
//            	try {
//            		t1.join();
//            	} catch (InterruptedException e) {
//				e.printStackTrace();
//            	}
//        }
//    } 
    
    
    // Method to play the audio 
    public void play() throws LineUnavailableException, IOException  
    { 
 //   	 if(this.tracklist)
    	 try {
			audioInputStream =  AudioSystem.getAudioInputStream(new File(tracklist.get(getCurrentTrack().get()).getFilepath()+tracklist.get(getCurrentTrack().get()).getFilename()).getAbsoluteFile());
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		}
         System.out.print("Audio \n");
         // create clip reference 
         setClip(AudioSystem.getClip());
         
         // open audioInputStream to the clip 
         getClip().open(audioInputStream);
         
         setGainControl((FloatControl) getClip().getControl(FloatControl.Type.MASTER_GAIN));
         max=getGainControl().getMaximum()-2;
         min=((getGainControl().getMinimum()+2))/2;
         
//         for(int i=0; i < 3;i++) {
//         	volumeDown();
//         }
    	
        //start the clip 
        getClip().start(); 
        status = "play"; 
    }
      
    
    // Method to pause the audio 
    public void pause()  
    { 
        if (this.status.equals("paused"))  
        { 
            System.out.println("audio is already paused"); 
            return; 
        } 
        this.currentFrame =  this.getClip().getMicrosecondPosition(); 
        getClip().stop(); 
        this.status = "paused"; 
    } 
      
    
    // Method to resume the audio 
    public void resumeAudio(Track track) throws UnsupportedAudioFileException, 
                                IOException, LineUnavailableException  
    { 
        if (status.equals("play"))  
        { 
            System.out.println("Audio is already "+ 
            "being played"); 
            return; 
        } 
        getClip().close(); 
        resetAudioStream(track); 
        getClip().setMicrosecondPosition(currentFrame); 
        getClip().start(); 
        status = "play"; 
    } 
      
    
    // Method to restart the audio 
    public void restart(Track track) throws IOException, LineUnavailableException, 
                                            UnsupportedAudioFileException  
    { 
        getClip().stop(); 
        getClip().close(); 
        resetAudioStream(track); 
        currentFrame = 0L; 
        getClip().setMicrosecondPosition(0); 
        getClip().start(); 
        status = "play";  
    } 
      
    
    // Method to stop the audio 
    public void stop() throws UnsupportedAudioFileException, 
    IOException, LineUnavailableException  
    { 
        currentFrame = 0L; 
        getClip().stop(); 
        getClip().close();
        audioInputStream.close();
        
    } 
     
    
    // Method to jump over a specific part 
    public void jump(long c,Track track) throws UnsupportedAudioFileException, IOException, 
                                                        LineUnavailableException  
    { 
        if (c > 0 && c < getClip().getMicrosecondLength()*1000000)  // check if the specific time is lower than the track's total time
        { 
        	getClip().stop(); 
            getClip().close(); 
            resetAudioStream(track); 
            currentFrame = c; 
            getClip().setMicrosecondPosition(c); // this position has to be given in microseconds
            getClip().start(); 
            status = "play"; 
        } 
    } 
      
    // Method to reset audio stream 
    public void resetAudioStream(Track track) throws UnsupportedAudioFileException, IOException, 
                                            LineUnavailableException  
    { 
//    	String track= App.getLibrary().get(i-1).getFilepath();
//    	filePath = directory_wav+ track; 
    	audioInputStream = AudioSystem.getAudioInputStream(new File(track.getFilepath() + track.getFilename()).getAbsoluteFile());
        getClip().open(audioInputStream); 
        //clip.loop(Clip.LOOP_CONTINUOUSLY); 
        
    }

 // Increase volume by 2 decibels
	public float volumeUp() {
		if(gain < min)
			gain=min;
    	if(gain < max) {
    		gain+=2.0f;
    		volumeBar= (int) ((gain-min)*100 /Math.abs(max-min));
    		if(volumeBar > 100) {
    			volumeBar = 100;
    			gain = max;
    		}
    		getGainControl().setValue(gain); 
    		System.out.print("Volume:"+ volumeBar+"%\n");
    	}
    	else {
    		System.out.print("Volume already max\n");
    	}
    	return gain;
	}

	// Reduce volume by 2 decibels.
	public void volumeDown() {
    	if(gain > min) {
    		gain-=2.0f;
    		if (gain <= min)
        		gain=-80.0f;
    		volumeBar= (int) ((gain-min)*100 /Math.abs(max-min));
    		if(volumeBar < 0)
				volumeBar=0;
    		getGainControl().setValue(gain); 
    		System.out.print("Volume:"+ volumeBar+"%\n");
    	
    	
    		getGainControl().setValue(gain); 
    	
    	}
    	else {
    		System.out.print("Volume already min\n");
    	}
	}

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		SimpleAudioPlayer.filePath = filePath;
	}

	public int nextTrack() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if(this.getCurrentTrack().get()+1 < tracklist.size()){
			stop();
			if(tracklist.get(this.getCurrentTrack().get()+1).getPlayable() == 1 ) {
				getCurrentTrack().incrementAndGet();
				resetAudioStream(tracklist.get(getCurrentTrack().get()));
				getClip().start(); 
		        status = "play"; 
		        System.out.println("Nova faixa:" +this.getCurrentTrack());
		        this.setNext(0);
				return 1;
			}
		}
		else {
			System.out.print("Não há musica seguinte\n");
		}
		return 0;	
	}
	
	public int prevTrack() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if(this.getCurrentTrack().get()-1 > -1){
			stop();
			if(tracklist.get(this.getCurrentTrack().get()-1).getPlayable() == 1 ) {
				getCurrentTrack().decrementAndGet();
				resetAudioStream(tracklist.get(getCurrentTrack().get()));
				getClip().start(); 
		        status = "play"; 
		        System.out.println("Nova faixa");
				return 1;
			}
		}
		else {
			System.out.print("Não há musica anterior\n");
		}
		return 0;	
	}

	public AtomicInteger getCurrentTrack() {
		return currentTrack;
	}

	public void setCurrentTrack(AtomicInteger currentTrack) {
		this.currentTrack = currentTrack;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public FloatControl getGainControl() {
		return gainControl;
	}

	public void setGainControl(FloatControl gainControl) {
		this.gainControl = gainControl;
	}

	public Clip getClip() {
		return clip;
	}

	public void setClip(Clip clip) {
		this.clip = clip;
	} 
}
