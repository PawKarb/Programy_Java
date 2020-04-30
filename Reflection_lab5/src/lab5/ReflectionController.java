package lab5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class ReflectionController {
	@FXML
	Button btn_createOB,btn_save;
	@FXML
	private TextField field_Name,test;
	@FXML
	private TextArea area_console;
	@FXML
	private VBox vbox;
	@FXML
	private TextInputControl objectfield;
	
	private Map<String, TextInputControl> map = new HashMap<>();
	
	Class<?> MyClass = null;
	
	public void onActionCreateOB(ActionEvent event) {
		if(MyClass == null || !MyClass.getName().equals(field_Name.getText())) {
			CreateObject_Field();
		}else {
			area_console.setText("Objekt ju¿ istnieje");
		}
	}
	public void onActionSave(ActionEvent event) {
		if(MyClass != null) {
			SaveChanges();
		}else {
			area_console.setText("Objekt nie istnieje");
		}
	}
	private void CreateObject_Field() {
		vbox.getChildren().clear();
				try {
					MyClass = Class.forName(field_Name.getText());
					Field pola[] = MyClass.getDeclaredFields();
					for(Field field: pola) {
						field.setAccessible(true);
						HBox hbox = new HBox();
						if(field.getName().equalsIgnoreCase("text")) {
							objectfield = new TextArea();
							objectfield.setPrefWidth(350);
						}else {
							objectfield = new TextField();
							objectfield.setPrefWidth(300);
						}
						map.put(field.getName(), objectfield);
						hbox.getChildren().add(objectfield);
						Label label = new Label(" <- "+field.getName());
						label.setWrapText(true);
						hbox.getChildren().add(label); 
						vbox.getChildren().add(hbox);
					}
					area_console.setText("Obiekt o nazwie "+MyClass.getSimpleName()+" zosta³ utworzony");
				} catch (ClassNotFoundException e) {
					area_console.setText("B³¹d utworzenia obiektu!!!");
					MyClass = null;
				}

	}
	private void SaveChanges() {
		area_console.setText("");
		Field pola[] = MyClass.getDeclaredFields();
		area_console.appendText("Obiekt "+MyClass.getSimpleName()+"\n");
		for(Field field: pola) {
			field.setAccessible(true);
			String name = field.getName();
			String type = field.getType().getSimpleName();
			TextInputControl name_field = map.get(name);
				switch (type) {
				default:
					try {
						field.set(MyClass, name_field.getText());
					} catch (IllegalArgumentException | IllegalAccessException e) {
						area_console.appendText("Nie mo¿na zmieniæ wartoœci pola "+ name+"\n");
					}
				break;
				case "Character":
					try {
						field.set(MyClass, name_field.getText().charAt(0));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						area_console.appendText("Nie mo¿na zmieniæ wartoœci pola "+ name+"\n");
					}
				break;
				case "String":
					try {
						field.set(MyClass, name_field.getText());
					} catch (IllegalArgumentException | IllegalAccessException e) {
						area_console.appendText("Nie mo¿na zmieniæ wartoœci pola "+ name+"\n");
					}
				break;
				case "Integer":
					try {
						field.set(MyClass, Integer.parseInt(name_field.getText()));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						area_console.appendText("Nie mo¿na zmieniæ wartoœci pola "+ name+"\n");
					}
				break;
				case "Double":
					try {
						field.set(MyClass, Double.parseDouble(name_field.getText()));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						area_console.appendText("Nie mo¿na zmieniæ wartoœci pola "+ name+"\n");
					}
				break;
				case "Byte":
					try {
						field.set(MyClass, Byte.parseByte(name_field.getText()));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						area_console.appendText("Nie mo¿na zmieniæ wartoœci pola "+ name+"\n");
					}
				break;
				case "Short":
					try {
						field.set(MyClass, Short.parseShort(name_field.getText()));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						area_console.appendText("Nie mo¿na zmieniæ wartoœci pola "+ name+"\n");
					}
				break;
				case "Long":
					try {
						field.set(MyClass, Long.parseLong(name_field.getText()));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						area_console.appendText("Nie mo¿na zmieniæ wartoœci pola "+ name+"\n");
					}
				break;	
				case "Float":
					try {
						field.set(MyClass, Float.parseFloat(name_field.getText()));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						area_console.appendText("Nie mo¿na zmieniæ wartoœci pola "+ name+"\n");
					}
				break;	
				case "Boolean":
					try {
						field.set(MyClass, Boolean.parseBoolean(name_field.getText()));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						area_console.appendText("Nie mo¿na zmieniæ wartoœci pola "+ name+"\n");
					}
				break;	
				}
				try {
					area_console.appendText(name+"="+field.get(MyClass)+"\n");
				} catch (IllegalArgumentException | IllegalAccessException e) {
					area_console.appendText("Nie mo¿na wyœwietliæ zawartoœci pól");
				}
		}

	}
}


