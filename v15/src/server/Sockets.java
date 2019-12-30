package server;


public class Sockets {
	private int ID;
	private boolean in_use=false;
	public Sockets(int number) {
		ID=number;
	}
	
	public void set_use() {
			in_use=true;
	}
	public void disable_use() {
		in_use=false;
	}
	public int get_id() {
		return ID;
	}
	public boolean is_it_in_use() {
		return in_use;
	}
}