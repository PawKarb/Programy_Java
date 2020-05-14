package application;

import java.io.Serializable;

public class Answer implements Serializable{
	
	private String nick;
	private String odpowiedz;
	
	public Answer(String nick, String odpowiedz) {
		this.nick = nick;
		this.odpowiedz = odpowiedz;
	}

	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getOdpowiedz() {
		return odpowiedz;
	}
	public void setOdpowiedz(String odpowiedz) {
		this.odpowiedz = odpowiedz;
	}
}
