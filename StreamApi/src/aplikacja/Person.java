package aplikacja;

public class Person {
	private String nick;
	
	public Person(String nick) {
		this.nick = nick;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
    public String toString() {
        return "Person [" +
                "Nick='" + nick +
                ']';
    }
}
