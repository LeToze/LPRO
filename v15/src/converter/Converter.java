package converter;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import list.Track;

public class Converter extends Thread{
	private Track track;

	public Converter(Track track){
		this.track=track;
	}
	
	public void run() {
	    // open stream
	    AudioInputStream mp3Stream = null;
		try {
			System.out.println(track.getFilepath() + track.getFilename());
			mp3Stream = AudioSystem.getAudioInputStream(new File(track.getFilepath() + track.getFilename()));
		} catch (UnsupportedAudioFileException | IOException e) {
			//System.out.println(mp3Stream.
			e.printStackTrace();
			
		}
	    AudioFormat sourceFormat = mp3Stream.getFormat();
	    // create audio format object for the desired stream/audio format
	    
	    // this is *not* the same as the file format (wav)
	    AudioFormat convertFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
	        sourceFormat.getSampleRate(), 16, 
	        sourceFormat.getChannels(), 
	        sourceFormat.getChannels() * 2,
	        sourceFormat.getSampleRate(),
	        false);
	    // create stream that delivers the desired format
	    AudioInputStream converted = AudioSystem.getAudioInputStream(convertFormat, mp3Stream);
	    
	    // write stream into a file with file format wav
	    try {
			AudioSystem.write(converted, Type.WAVE, new File(track.getFilepath()+ track.getFilename().replaceFirst("mp3", "wav")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
//	  //Delete do ficheiro mp3
//		System.out.println(track.getFilepath()+ track.getFilename());
//	    File fd = new File(track.getFilepath()+ track.getFilename());
//	    if(fd.delete()){
//	    	System.out.println("File deleted");
//	    }
//	    else {
//	    	System.out.println("Not deleted");
//	    }
//	    System.out.print(fd.canWrite());
//	    try {
//			Files.delete(fd.toPath());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		/////////////////////////////////
	    track.setFilename(track.getFilename().replaceFirst("mp3", "wav"));
	    track.setConverted(5);
	    track.setPlayable(1);
	}
}
