package application;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ClientController {
	@FXML
	private TextField field_answer, field_nick;
	
	private InetAddress address;
	
	@FXML
	public void initialize() {
		try {
			address = InetAddress.getByName("localhost");
		} catch(UnknownHostException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	@FXML
	void SendAnswer(ActionEvent event) {
		try(Socket client = new Socket(address, 6545)){
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			out.writeObject(new Answer(field_nick.getText(), field_answer.getText()));
			this.field_answer.clear();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
