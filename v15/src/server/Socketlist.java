package server;


import java.util.ArrayList;

public class Socketlist {
	private ArrayList<Sockets> sockets;
	private int num=0;
	
	public Socketlist(int number) {
		num=number;
		this.sockets= new ArrayList<Sockets>();
		for(int i=5001;i<=number+5001;i++)
			this.sockets.add(new Sockets(i));
	}

	public int give_socket() {
		for(int i=0;i<num;i++) {
			if(! (this.sockets.get(i).is_it_in_use() )) {
				sockets.get(i).set_use();
				return sockets.get(i).get_id();
			}
				
		}
		return -2;// Não há sockets disponiveis
	}
	
	public void return_socket(int number) {
		for(int i=0;i<num;i++) {
			if(sockets.get(i).get_id()==number) {
				sockets.get(i).disable_use();
				//return sockets.get(i).get_id();
			}
		}
	}
	
	
	
}
