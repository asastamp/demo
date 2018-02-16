/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package graphic;

import Main.Main;
import gui_for_one.Main_1player;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.GameManager_1player;
import ui.AudioUtility;
import ui.Configuration;

public class Finalscore1 extends Pane {

	public Finalscore1(GameManager_1player gm, Main_1player main) {
		// TODO Auto-generated method stub
		// เซตเกมและเสียง
		Main.instance.setGamemanager1();
		AudioUtility.playSound("congrat");

		// วาดพื้นหลัง
		Canvas canvas = new Canvas(Configuration.screen_width, Configuration.screen_height);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image result_one = new Image(ClassLoader.getSystemResource("result_one.png").toString());
		gc.drawImage(result_one, 0, 0);

		// สร้างปุ่ม main menu
		Image mainmenu_result = new Image(ClassLoader.getSystemResource("mainmenu_result.png").toString());
		Image mainmenu_result_point = new Image(ClassLoader.getSystemResource("mainmenu_result_point.png").toString());

		Button button_mainmenu_result = new Button("", new ImageView(mainmenu_result));
		button_mainmenu_result.setStyle("-fx-background-color: rgb(256,256,256)");
		button_mainmenu_result.setLayoutX(220);
		button_mainmenu_result.setLayoutY(430);
		button_mainmenu_result.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Button temp = new Button("", new ImageView(mainmenu_result_point));
				temp.setStyle("-fx-background-color: rgb(256,256,256)");
				temp.setLayoutX(220);
				temp.setLayoutY(430);
				Finalscore1.this.getChildren().addAll(temp);
				temp.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						Finalscore1.this.getChildren().remove(temp);
					}
				});
				temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						AudioUtility.stopSound("congrat");
						Main.instance.setToMainMenu();
					}
				});
			}
		});

		// สร้างปุ่ม try again
		Image tryagain = new Image(ClassLoader.getSystemResource("tryagain.png").toString());
		Image tryagain_point = new Image(ClassLoader.getSystemResource("tryagain_point.png").toString());

		Button button_tryagain = new Button("", new ImageView(tryagain));
		button_tryagain.setStyle("-fx-background-color: rgb(256,256,256)");
		button_tryagain.setLayoutX(600);
		button_tryagain.setLayoutY(440);
		gc.drawImage(tryagain, 600, 440);
		button_tryagain.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Button temp = new Button("", new ImageView(tryagain_point));
				temp.setStyle("-fx-background-color: rgb(256,256,256)");
				temp.setLayoutX(600);
				temp.setLayoutY(440);
				Finalscore1.this.getChildren().addAll(temp);

				temp.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						Finalscore1.this.getChildren().remove(temp);
					}
				});
				temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						AudioUtility.stopSound("congrat");
						Main.instance.setToGameScreen1();
					}
				});
			}
		});

		this.getChildren().addAll(canvas, button_mainmenu_result, button_tryagain);

		// จัดการเรื่องผลคะแนน
		String out = "" + gm.getScore();
		Font f = Font.font("Times New  Roman", FontWeight.BOLD, 50);
		gc.setFont(f);
		gc.setFill(Color.BLACK);
		gc.fillText(out, 630, 400);
		gc.fillText(main.getName(), 630, 310);

		gm.setScore(0);

	}

}
