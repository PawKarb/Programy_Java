package lab6;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class ValidatorController{
	@FXML
	private TextField validatorfield;
	@FXML
	private Button btnConfirm;
	@FXML 
	private Label imagefield;
	
	private Image image0 = new Image("lab6/obrazki/0.png");
	private Image image1 = new Image("lab6/obrazki/1.png");
	
	
	public void initialize() {
		MyPatternValidator validator = new MyPatternValidator();
		btnConfirm.setDisable(true);
		imagefield.setGraphic(new ImageView(image0));
		imagefield.setTooltip(new Tooltip(validator.getMessage()));
		validatorfield.setText("");
		validatorfield.setOnKeyReleased(new EventHandler<KeyEvent>(){
				@Override
				public void handle(KeyEvent event) {
					validator.validate(validatorfield.getText());
					if(validator.isValid()) {
						btnConfirm.setDisable(false);
						imagefield.setGraphic(new ImageView(image1));
						imagefield.setTooltip(null);
					}else {
						btnConfirm.setDisable(true);
						imagefield.setGraphic(new ImageView(image0));
						imagefield.setTooltip(new Tooltip(validator.getMessage()));
					}
				}
			});
	}
	
}