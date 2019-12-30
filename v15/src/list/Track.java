package list;

public final class Track {
private String filename;
//private static final String filepath = "C:\\Users\\smcgt\\Desktop\\Music_Library_mp3\\";
private static final String filepath = "C:\\Music_Library_mp3\\";
//private static final String filepath = "Macintosh HD:\\Music_Library_mp3\\";
private String trackname;
private String imagename;
private int track_id;
private int tracknum;
protected Album album;
protected Artist artist;
protected Genre genre;
private String tracksearch;
private int downloaded = 0;
private int converted = 0;
private int playable=0;
private int image = 0;
private int error = 0;
private int delete = 0;
private int length;
private int karaoke=0;
private int offset=0; //miliseconds


public String getName() {
	return trackname;
}

public int getTrack() {
	return track_id;
}

public Track() {
	Artist artist = new Artist();
	Album album = new Album();
	Genre genre = new Genre();
	this.album=album;
	this.artist=artist;
	this.genre=genre;
}

public void setName(String name2) {
		String desc[];
		desc = name2.split("_");;
		this.setFilename(name2);
		this.artist.setArtist_id(Integer.parseInt(desc[0]));
		this.album.setAlbum_id(Integer.parseInt(desc[1])); 
		this.track_id = Integer.parseInt(desc[2]);
}

//public Album getAlbum() {
//	return this.album;
//}

//public Artist getArtist() {
//	return this.artist;
//}

public int getTracknum() {
	return this.tracknum;
}

public String getAlbum_name() {
	return album.album_name;
}

public String getArtist_name() {
	return artist.getArtist_name();
}

public void setArtist_name(String artist_name) {
	this.artist.artist_name = artist_name;
}

public String getGenre() {
	return genre.genre;
}

public void setGenre(String genre) {
	this.genre.genre = genre;
}

public String getTracksearch() {
	return tracksearch;
}

public void setTracksearch(String tracksearch) {
	this.tracksearch = tracksearch;
}

public int getTrack_id() {
	return track_id;
}

public void setTrack_id(int track_id) {
	this.track_id = track_id;
}

public String getFilepath() {
	return filepath;
}

public void setFilename(String filename) {
	this.filename = filename;
}

public String getFilename() {
	return this.filename;
}

public void setTitle(String first) {
	this.trackname= first;
	
}

public void setAlbum_name(String first) {
	this.album.album_name= first;
}

public void setLength(int parseInt) {
	this.length= parseInt;
	
}

public void setTracknum(int parseInt) {
	this.tracknum=parseInt;
	
}

public int getLength() {
	return length;
}

public int isError() {
	return this.error;
}

public int isConverted() {
	return this.converted;
}

public int isImage() {
	return this.image;
}

public int isDownloaded() {
	return downloaded;
}

public void setError(int error) {
	this.error = error;
}

public void setConverted(int converted) {
	this.converted = converted;
}

public void setImage(int image) {
	this.image = image;
}

public void setDownloaded(int downloaded) {
	this.downloaded = downloaded;
}

public int getDelete() {
	return delete;
}

public void setDelete(int delete) {
	this.delete = delete;
}

public String getImagename() {
	return imagename;
}

public void setImagename(String imagename) {
	this.imagename = imagename;
}

public int getPlayable() {
	return playable;
}

public void setPlayable(int playable) {
	this.playable = playable;
}

public int getKaraoke() {
	return karaoke;
}

public void setKaraoke(int karaoke) {
	this.karaoke = karaoke;
}

public int getOffset() {
	return offset;
}

public void setOffset(int offset) {
	this.offset = offset;
}
}
