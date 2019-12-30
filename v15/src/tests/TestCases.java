package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Test;

import list.Track;
import playmusic.SimpleAudioPlayer;

public class TestCases {
		
		@Test
		public void VolumeTester() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
			//String filePath = "C:\\Users\\smcgt\\Desktop\\Music_Library_mp3\\"; 
			Track track = new Track();
			AtomicInteger currentTrack = new AtomicInteger();
			currentTrack.set(0);
			//final ArrayList <Integer> buffer = new ArrayList <Integer>();
			final ArrayList<Track> tracklist = new ArrayList<Track>();
			track.setFilename("debug.wav");
			tracklist.add(track);
			
			SimpleAudioPlayer audioPlayer =  new SimpleAudioPlayer(tracklist, currentTrack); 
			//audioPlayer.setFilePath(filePath);
	        audioPlayer.play(); 
			assert((int)audioPlayer.getGainControl().getValue() == 0);
			audioPlayer.volumeUp();
			assert((int)audioPlayer.getGainControl().getValue() == 2);
			for(int j=0;j < 16;j++) {
				audioPlayer.volumeDown();
			}
			assert((int)audioPlayer.getGainControl().getValue() == -30);
			audioPlayer.stop(); 
		}
}
