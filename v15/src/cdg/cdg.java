package cdg;

import java.io.File;

public class cdg {
	private CDGViewer viewer = new CDGViewer();
	private CDGReader in;
//	private static String filepath = "C:\\Users\\smcgt\\Desktop\\Music_Library_mp3\\";
//private static final String filepath = "C:\\Music_Library_mp3\\";
	//private static final String filepath = "C:\\Music_Library_mp3\\";
	String Filename;
	public cdg() {
	}
	public void play_file(int mili_seconds, String Filename){
		 System.out.println(Filename);
		 this.Filename=Filename;
		// in.close();
		 in=null;
		 in = new  CDGReader(new File(Filename),this.viewer);
		 in.set_framecounter(mili_seconds/50);
		 in.process();
		 viewer.getFrame().setVisible(true);;
	}
	public void pause() {
		in.cancel();
		
	}
	
	
	public void resume(int offset_mili) {
		int value=in.get_framecounter();
		 in = new  CDGReader(new File(this.Filename),this.viewer);
		 in.set_framecounter(offset_mili/50+value);
		 in.process();
	}
	public void jump(int offset_mili) {
		int count= in.get_framecounter(); 
		in.cancel();
		 
		 in = new  CDGReader(new File(this.Filename),this.viewer);
		 in.set_framecounter((offset_mili/50)+count);
		 in.process();
	}
	

//	public static void main(String args[]) {
//		cdg player= new cdg();
//		//player.play_file(0,"C:\\Users\\PC\\Desktop\\b.cdg");
//		player.play_file(0,cdg.filepath+ "b.cdg");
//		int pause=0;
//		while(true) {
//		
//		
//		
//			Scanner keyboard = new Scanner(System.in);
//			
//			String myint = keyboard.nextLine();
//			
//			switch(myint) {
//			
//			case "stop":  pause=player.pause(); break;
//			
//			case "resume": player.resume(pause,filepath+"b.cdg"); break;
//			
//			case "jump" : myint = keyboard.nextLine(); player.jump(Integer.parseInt(myint)*1000,filepath+"b.cdg"); break;
//			
//			
//		}
//	
//	
//		}
//	}
	
}
