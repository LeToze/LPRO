package master;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import interfac.FrameGeral;
import interfac.Login;
import interfac.Ui;
import list.Track;
import sql.loginn;

public class Main{
	public static void main(String[] args) throws InterruptedException  
		{ 
			
		AtomicInteger currentTrack = new AtomicInteger();
		currentTrack.set(0);
		final ArrayList <Integer> buffer = new ArrayList <Integer>();
		final ArrayList<Track> tracklist = new ArrayList<Track>();
		String username = null;
		String password ;
		
		Login frameUm = new Login();
		frameUm.setVisible(true);
		
		while(true) {
			if( frameUm.getAuto() == true) {
				System.out.println("qualquer coisa");
				username=frameUm.getValidate_username().getText();
				password=frameUm.getValidate_password().getText();
				break;
			}
			TimeUnit.MILLISECONDS.sleep(100);
		}
		System.out.println("user"+ username);
		System.out.println("pass" +password);
		loginn login = new loginn(username,password);
		login.start();
		login.join();
		
		if(login.isAck() == true) {
			frameUm.setVisible(false);	
			System.out.println("Acesso Concedido");
			FrameGeral frame = new FrameGeral(buffer,tracklist,currentTrack,username);
			frame.setVisible(true);
			
			String seek= (frame.getTextBar().getText());
			int search_mode =(frame.getSearch_mode());
			
			Thread manage = new Manager(tracklist,currentTrack);
			manage.start();
			Thread masterchef = new Master(tracklist,buffer,currentTrack, seek,search_mode);
			masterchef.start();
			Thread ui = new Ui(tracklist, buffer,currentTrack,frame);
			ui.start();
			
			while(true) {
				if(frame.getSetSearched() == 1)
					((Master) masterchef).setSearch(frame.getTextField().getText());
					((Master) masterchef).setSearch_mode(frame.getSearch_mode());
			}
		}
		}
}