package playmusic;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class EndCheck extends Thread {
	SimpleAudioPlayer audioPlayer;
	private String nome;
	public EndCheck(String nome,SimpleAudioPlayer audioPlayer) {
		this.setNome(nome);
		this.audioPlayer=audioPlayer;
	}
	
	@Override
	public void run() {
		while(true) {
			if(this.audioPlayer.endcheck() && audioPlayer.getNext() == 0) {
				//skip to next song if the present one is over
				audioPlayer.setNext(1);
				try {
					audioPlayer.nextTrack();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		
			//sleep 100 ms per music endcheck condition check
			try {
				sleep(100);
			} catch (InterruptedException e) {
				break;
			}
	  }
}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
}
