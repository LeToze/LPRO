package sql;
//Artistid_albumid_trackid_

import java.sql.*;
import java.util.ArrayList;
import list.Track; 

public class mysql extends Thread{
	ArrayList<Track> tracklist;
	private String search;
	private int search_mode;
//	private int j;
	private boolean vocals=true;
	public mysql(ArrayList<Track> tracklist,String search,int search_mode) {
		this.tracklist= tracklist;
		this.search= search;
		this.search_mode=search_mode;
	}
	
	public void run () { 
		
		  String user = "groovy" ; 
		  String pass = "groovy"; 
		  String url = "jdbc:mysql://192.168.31.120:3306/groovy?useTimezone=true&serverTimezone=UTC"; 
		 
		  
		  //useTimezone=true&serverTimezone=UTC", root, root
		  
//		  music_scanner = new Scanner(System.in);   
//		  mode_scanner = new Scanner(System.in); 
		 // String sql_insert;
		  PreparedStatement myStmt = null;
		  ResultSet myRs = null;
		  String filename = null;
		
		try
		{        
			Connection conn = DriverManager.getConnection(url, user, pass);  
		      System.out.println("connecting done done");
		      System.out.println("Creating acc mode!");
		      System.out.println("");
		      System.out.println("------------------------------------------------------------");
		      System.out.println("1 for insert 0 for lookup");
		      
		    //  int mode = mode_scanner.nextInt(); FORCEI O MODE
		      
		      int mode = 0;
		      //this.search_mode = 4;
		      //this.vocals = false; 
		     // int search_mode = 3;
//		      System.out.print(search_mode);
//		      System.out.print(vocals);
		      
		    switch(mode) {
		      
		      	case 0:  //lookup
		      		
		      	  System.out.println("please insert a music/album/artist to search");
		   	      //String music_name = music_scanner.nextLine();  
		   	      String music_name = this.search;
		   	    		  
		   	      switch(this.search_mode) {
		   	      	case 1: //TRACK SEARCHER
			   	      	 myStmt = conn.prepareStatement("select * from track where track_name =?");   	      
				   	     myStmt.setString(1, music_name);	   	      
				   	     myRs = myStmt.executeQuery(); 
				   	     filename = display1(myRs);
				   	     if(filename != null) {
						   	 //filename = display1(myRs);
							 Track t=new Track();
							 t.setFilename(filename);
							 System.out.println(filename);
							 System.out.println(tracklist.add(t));
							 System.out.println(this.tracklist.get(0).getFilename());
							 break;
				   	     }
				   	     else {
				   	    	 System.out.print("Nome não encontrado na base de dados\n");
				   	    	 break;
				   	     }
		   	      	   	      
		   	      	case 2: //ALBUM SEARCH
		 
			     		 myStmt = conn.prepareStatement("select * from album where album_name = ?");   	      
				  	     myStmt.setString(1, music_name);	  	   
				  	     myRs = myStmt.executeQuery();  	  	     
				  	     int album_id = displayAlbumID(myRs);
				   	
				   	     System.out.println("MY ALBUM ID IS "+album_id);
				   	     
				   	     myStmt = conn.prepareStatement("select * from track where album_id = ?");   	      
				   	     myStmt.setLong(1, album_id);	   	      
				   	     myRs = myStmt.executeQuery();
				   	     ArrayList<String> album = (display(myRs));
				   	     if(album != null) {
					   	     addTo(album,this.tracklist,0);
					   	     System.out.print(this.tracklist.get(0).getName());
					   	     break;
				   	     }
				   	     else {
				   	    	System.out.print("Nome não encontrado na base de dados\n");
				   	    	 break;
				   	     }
		   	     
		    	  	   
		   	      	case 3: //ARTIST SEARCH 
		      		
			      		 myStmt = conn.prepareStatement("select * from artists where artist_name = ?");   	      
				  	     myStmt.setString(1, music_name);	  	   
				  	     myRs = myStmt.executeQuery();  
				  	     int artist_id = displayArtistID(myRs);
			      		
				  	     System.out.println("MY ARTIST ID IS "+artist_id);  	     
				  	     myStmt = conn.prepareStatement("select * from track where artist_id = ?");
				  	     myStmt.setLong(1, artist_id);
				  	     myRs = myStmt.executeQuery(); 
				  	     ArrayList<String> artist = (display(myRs));
				  	     if(artist != null) {
				  	    	 addTo(artist,this.tracklist,0);
				  	    	 System.out.print(this.tracklist.get(0).getName());    
				  	    	 break;
				  	     }
				  	     else {
				  	    	System.out.print("Nome não encontrado na base de dados\n");
				   	    	 break;
				  	     }
				  	     
		   	     case 4:
		   	    	 	this.vocals=false;
			      		int b = 1;
			      		int offset=0;
			   	    	 myStmt = conn.prepareStatement("SELECT * from track WHERE track_name =? AND karaoke =?");   	      
				   	     myStmt.setString(1, music_name);
				   	     myStmt.setInt(2, b);
				   	     myRs = myStmt.executeQuery();   	           
				   	     ArrayList<String> karaoke = (display(myRs));
				   	     //music_scanner.close();
				   	     if(karaoke != null) {
					   	     if(!this.vocals) {
					   	    	myRs = myStmt.executeQuery();
					   	    	offset = off_set1(myRs);
					   	     }
	//				   	     if(this.vocals) {
	//				   	    	 myRs = myStmt.executeQuery();
	//				   	    	 offset = off_set2(myRs); 
	//				   	     }
					  	     addTo(karaoke,this.tracklist,offset);
					  	     
					  	     System.out.println("--------------------------------------------------------");
					  	     System.out.println("FIM");
					  	     break;
				   	     }
				   	     else {
				   	    	System.out.print("Nome não encontrado na base de dados\n");
				   	    	break;
				   	     }
		   	     case 5:
		   	    	 this.vocals=true;
		   	    	 int b1 = 1;
		   	    	 int offset1=0;
		   	    	 myStmt = conn.prepareStatement("SELECT * from track WHERE track_name =? AND karaoke =?");   	      
			   	     myStmt.setString(1, music_name);
			   	     myStmt.setInt(2, b1);
			   	     myRs = myStmt.executeQuery();   	           
			   	     ArrayList<String> karaoke1 = (display(myRs));
			   	     //music_scanner.close();
			   	     
//			   	     if(!this.vocals) {
//			   	    	myRs = myStmt.executeQuery();
//			   	    	offset = off_set1(myRs);
//			   	    	
//			   	     }
			   	     if(karaoke1 != null) {
				   	     if(this.vocals) {
				   	    	 myRs = myStmt.executeQuery();
				   	    	 offset1 = off_set2(myRs); 
				   	     }
				  	     addTo(karaoke1,this.tracklist,offset1);
				  	     
				  	     System.out.println("--------------------------------------------------------");
				  	     System.out.println("FIMMMMMMM");
			      		
				  	     break;
			   	     }
			   	     else {
			   	    	System.out.print("Nome não encontrado na base de dados\n");
			   	    	break;
			   	     }
		   	      }
		      	case 1:	//insert still to do
		     /* 		
	      		  System.out.println("please insert a music to insert");
		   	      String music_name = music_scanner.nextLine();   	     
		   	      myStmt = conn.prepareStatement("select * from track where track_name = ?");   	      
		   	      myStmt.setString(1, "Mockingbird");	   	      
		   	      myRs = myStmt.executeQuery();   	           
		   	      display(myRs);
		   	      music_scanner.close();
		      		*/
		      		break;
		   }

		}   
		    catch (Exception e)
		    {
		      System.err.println(e.getMessage()); 
		    } 
	}

	public static ArrayList<String> display(ResultSet myRs) throws SQLException {
		ArrayList<String> album = new ArrayList<String>();
		String full_names;
		String names;
		int track_id;
		int i=0;
		while (myRs.next()) {
			names = myRs.getString("track_name");
			int artist_id = myRs.getInt("artist_id");
			int album_id = myRs.getInt("album_id");
			track_id = myRs.getInt("track_id");
			full_names = artist_id+"_"+album_id+"_"+track_id+"_.mp3";
			System.out.printf("%s_%s_%s_.mp3\n" , artist_id, album_id, track_id);
			System.out.printf("%s\n" ,full_names);
			album.add(full_names);
			++i;
		}
		return (album);
		//return full_name;
	}
	
	public static String display1(ResultSet myRs) throws SQLException {
		String full_name = null ;
		String name=null;
		while (myRs.next()) {
			name = myRs.getString("track_name");
			int artist_id = myRs.getInt("artist_id");
			int album_id = myRs.getInt("album_id");
			int track_id = myRs.getInt("track_id");
			full_name = artist_id+"_"+album_id+"_"+track_id+"_.mp3";
			System.out.printf("%s_%s_%s_.mp3\n" , artist_id, album_id, track_id);
			System.out.printf("%s\n" , full_name);
		}
		//return names;
		return full_name;
	}
	
	public void addTo(ArrayList<String> names,ArrayList<Track> tracklist,int offset) {
		for(int i=0;i < names.size() ;i++) {
 	    	 Track t1 = new Track();
 	    	 t1.setFilename(names.get(i));
 	    	 if(search_mode >3) {
 	    		 t1.setKaraoke((this.vocals?2:1));
 	    		 t1.setOffset(offset);
 	    	 }
 	    	 else {
 	    		 t1.setKaraoke(0);
 	    	 }
 	    	 tracklist.add(t1);
 	     }
  	     System.out.println("Album added to the queue");
	}
	
	
	
	private static int displayAlbumID(ResultSet myRs) throws SQLException {
	int album_id=0;
	while (myRs.next()) {
		
		 album_id = myRs.getInt("album_id");			
		
		 System.out.printf("%d\n" , album_id);
	}
	
	return album_id;
}

private static int displayArtistID(ResultSet myRs) throws SQLException {
	int artist_id=0;
	while (myRs.next()) {
		
		artist_id = myRs.getInt("artist_id");			
		
		System.out.printf("%d\n" , artist_id);
	}
	
	return artist_id;
}

private static int off_set1(ResultSet myRs) throws SQLException {
	int off_set1 = 0;
	
		while (myRs.next()) {
			
		off_set1 = myRs.getInt("off_Set01");			
		
		System.out.printf("%d\n" , off_set1);
	}

	return off_set1;
	
}

private static int off_set2(ResultSet myRs) throws SQLException {
	int off_set2 = 0;
		while (myRs.next()) {
		off_set2 = myRs.getInt("off_Set02");			
		
		System.out.printf("%d\n" , off_set2);
	}

	return off_set2;
	
}
	
	
}
 
    
 