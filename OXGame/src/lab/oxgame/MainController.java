package lab.oxgame;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lab.oxgame.dao.RozgrywkaDAO;
import lab.oxgame.dao.RozgrywkaDAOImpl;
import lab.oxgame.engine.OXEnum;
import lab.oxgame.engine.OXGame;
import lab.oxgame.engine.OXGameImpl;
import lab.oxgame.model.rozgrywka;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {
	@FXML
	Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
	private List<Button> oxButtons;
	@FXML
	private Label lbinfo1;
	OXGame oxgame;
	public MainController() {
		oxgame = new OXGameImpl();
	}
public void onActionBtn0(ActionEvent event) {
	ruch((Button)event.getSource(),0);
}
public void onActionBtn1(ActionEvent event) {
	ruch((Button)event.getSource(),1);
}
public void onActionBtn2(ActionEvent event) {
	ruch((Button)event.getSource(),2);
}
public void onActionBtn3(ActionEvent event) {
	ruch((Button)event.getSource(),3);
}
public void onActionBtn4(ActionEvent event) {
	ruch((Button)event.getSource(),4);
}
public void onActionBtn5(ActionEvent event) {
	ruch((Button)event.getSource(),5);
}
public void onActionBtn6(ActionEvent event) {
	ruch((Button)event.getSource(),6);
}
public void onActionBtn7(ActionEvent event) {
	ruch((Button)event.getSource(),7);
}
public void onActionBtn8(ActionEvent event) {
	ruch((Button)event.getSource(),8);
}
public void onActionReset(ActionEvent event) {
	btn0.setText("");
	btn1.setText("");
	btn2.setText("");
	btn3.setText("");
	btn4.setText("");
	btn5.setText("");
	btn6.setText("");
	btn7.setText("");
	btn8.setText("");
	oxgame.inicjalizuj();
}

@FXML
private TableView<rozgrywka> rozgrywkaTable;
@FXML
private TableColumn<rozgrywka, Integer> idColumn;
@FXML
private TableColumn<rozgrywka, String> graczOColumn;
@FXML
private TableColumn<rozgrywka, String> graczXColumn;
@FXML
private TableColumn<rozgrywka, OXEnum> zwyciezcaColumn;
@FXML
private TableColumn<rozgrywka, LocalDateTime> dataczasColumn;
@FXML 
private TextField txtFieldO;
@FXML
private TextField txtFieldX;

private ObservableList<rozgrywka> rozgrywki;

private ExecutorService wykonawca;
private RozgrywkaDAO rozgrywkaDAO;
@FXML
private void initialize() {
	oxButtons = Arrays.asList(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8);
	graczOColumn.setCellValueFactory(new PropertyValueFactory<rozgrywka , String>("graczO"));
	idColumn.setCellValueFactory(new PropertyValueFactory<rozgrywka , Integer>("rozgrywkaId"));
	graczXColumn.setCellValueFactory(new PropertyValueFactory<rozgrywka , String>("graczX"));
	zwyciezcaColumn.setCellValueFactory(new PropertyValueFactory<rozgrywka , OXEnum>("zwyciezca"));
	dataczasColumn.setCellValueFactory(new PropertyValueFactory<rozgrywka , LocalDateTime>("dataczasRozgrywki"));
	rozgrywki = FXCollections.observableArrayList();
	rozgrywkaTable.setItems(rozgrywki);
	rozgrywkaDAO = new RozgrywkaDAOImpl();
	wykonawca = Executors.newFixedThreadPool(1);
	wykonawca.execute(() -> {
		//rozgrywka rozgrywka = new rozgrywka("Jan","Adam", OXEnum.X, LocalDateTime.now());
	List<rozgrywka> rows = rozgrywkaDAO.pobierzRozgrywki(0, 100);
	if(rows !=null) {
		Platform.runLater(() -> {
			rozgrywki.addAll(rows);
	});
	}
});
}
private void ruch (Button btn,int indeks) {
	if(oxgame != null && OXEnum.BRAK.equals(oxgame.getPole(indeks))) {
		OXEnum kolej = oxgame.getKolej();
		btn.setText(kolej.toString());
	if(!OXEnum.BRAK.equals(oxgame.getKolej())) {
		//btn.setText(kolej.toString());
		oxgame.setPole(indeks);
		kolej = oxgame.getKolej();
		lbinfo1.setText("Ruch gracza "+kolej.toString());
	}
	if(OXEnum.BRAK.equals(kolej)) {
		if(!oxgame.getZwyciezca().equals(OXEnum.BRAK)){
			lbinfo1.setText("WYGRANA");
			OXEnum zwyciezca = oxgame.getZwyciezca();
			String graczO = txtFieldO.getText();
			String graczX = txtFieldX.getText();
			wykonawca.execute(() -> {
				rozgrywka rozgrywka = new rozgrywka (graczO,graczX,oxgame.getZwyciezca(), LocalDateTime.now());
				rozgrywkaDAO.zapiszRozgrywke(rozgrywka);
				if(rozgrywka.getRozgrywkaId() !=null) {
					Platform.runLater(() ->{
						rozgrywki.add(0, rozgrywka);
					});
					System.out.println("Id zapisanej rozgrywki: " + rozgrywka.getRozgrywkaId());
		}
		});
		}else{
			lbinfo1.setText("REMIS");
			OXEnum zwyciezca = oxgame.getZwyciezca();
			String graczO = txtFieldO.getText();
			String graczX = txtFieldX.getText();
			wykonawca.execute(() -> {
				rozgrywka rozgrywka = new rozgrywka (graczO,graczX,oxgame.getZwyciezca(), LocalDateTime.now());
				rozgrywkaDAO.zapiszRozgrywke(rozgrywka);
				if(rozgrywka.getRozgrywkaId() !=null) {
					Platform.runLater(() ->{
						rozgrywki.add(0, rozgrywka);
					});
					System.out.println("Id zapisanej rozgrywki: " + rozgrywka.getRozgrywkaId());
		}
		});
	}
	}
}
}
}