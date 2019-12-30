package list;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.datatype.Artwork;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Simple class that will attempt to recusively read all files within a directory, flags
 * errors that occur.
 */
public class Extract extends Thread
{
	private Track track;
	public Extract (Track track){
		this.track=track;
	}
	
    public void run() 
    {
    	
    	AudioFile f = null ;
		try {
			f = AudioFileIO.read(new File(this.track.getFilepath() + this.track.getFilename()));	
		} catch (CannotReadException | IOException | TagException | ReadOnlyFileException
				| InvalidAudioFrameException e) {
			e.printStackTrace();
		}
		Tag tag = f.getTag();

		String trackStr = tag.getFirst(FieldKey.TRACK);
		if (!trackStr.isEmpty()) { 
			//track.setError(2); // empty metadata
			//track.setDelete(1);
			//return ; 
		
		
		track.setArtist_name(tag.getFirst(FieldKey.ARTIST));
		track.setTitle(tag.getFirst(FieldKey.TITLE));
		track.setAlbum_name(tag.getFirst(FieldKey.ALBUM));
		track.setGenre(tag.getFirst(FieldKey.GENRE));
		track.setTracknum(Integer.parseInt(trackStr));
		track.setLength(f.getAudioHeader().getTrackLength() + 1);
		
		Artwork artwork = tag.getFirstArtwork();
		//Album album = new Album (tag.getFirst(FieldKey.ALBUM), artwork);
		
		System.out.println(track.getArtist_name());
		System.out.println(track.getName());
		System.out.println(track.getAlbum_name());
		System.out.println(track.getGenre());
		System.out.println(track.getTracknum());
		System.out.println(track.getLength());
		FileOutputStream out;
		
		if(artwork!=null) {
		 try {
			System.out.print(track.getName());
			track.setImagename(track.getFilename().replaceFirst("mp3", "jpeg"));
			//track.getImagename().replaceFirst("mp3", "jpeg");
			
			System.out.println(track.getImagename() + track.getFilename());
			out = new FileOutputStream(track.getFilepath() +track.getImagename());
			out.write(tag.getFirstArtwork().getBinaryData(), 0,tag.getFirstArtwork().getBinaryData().length);
        	out.flush();
        	out.close();
//        	try {
//				f.delete();
//			} catch (CannotReadException | CannotWriteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        	
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		else {
			track.setImagename("default.jpeg");
		}
		}
		track.setImage(1);
		track.setConverted(3);
    }
}

