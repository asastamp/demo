/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package graphic;

import Main.Main;
import gui_for_two.Main_2player;
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
import logic.GameManager_2player;
import ui.AudioUtility;
import ui.Configuration;

public class Finalscore2 extends Pane {

	public Finalscore2(GameManager_2player gm, Main_2player main) {
		// TODO Auto-generated method stub

		// เซตเกมและเสียง
		Main.instance.setGamemanager2();
		AudioUtility.playSound("congrat");

		// รับคะแนนมาเก็บ
		String out1 = "" + gm.getScore1();
		String out2 = "" + gm.getScore2();

		// สร้างcanvas
		Canvas canvas = new Canvas(Configuration.screen_width, Configuration.screen_height);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		// กรณีคะแนนไม่เท่ากัน
		if (gm.getScore1() != gm.getScore2()) {
			Image result_one = new Image(ClassLoader.getSystemResource("result_two.png").toString());
			gc.drawImage(result_one, 0, 0);
			// สร้างปุ่ม main menu
			Image mainmenu_result = new Image(ClassLoader.getSystemResource("mainmenu_result.png").toString());
			Image mainmenu_result_point = new Image(
					ClassLoader.getSystemResource("mainmenu_result_point.png").toString());

			Button button_mainmenu_result = new Button("", new ImageView(mainmenu_result));
			button_mainmenu_result.setStyle("-fx-background-color: rgb(256,256,256)");
			button_mainmenu_result.setLayoutX(225);
			button_mainmenu_result.setLayoutY(455);
			button_mainmenu_result.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					Button temp = new Button("", new ImageView(mainmenu_result_point));
					temp.setStyle("-fx-background-color: rgb(256,256,256)");
					temp.setLayoutX(225);
					temp.setLayoutY(455);
					Finalscore2.this.getChildren().addAll(temp);
					temp.setOnMouseExited(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							Finalscore2.this.getChildren().remove(temp);
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
			button_tryagain.setLayoutY(464);
			button_tryagain.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					Button temp = new Button("", new ImageView(tryagain_point));
					temp.setStyle("-fx-background-color: rgb(256,256,256)");
					temp.setLayoutX(600);
					temp.setLayoutY(463);
					Finalscore2.this.getChildren().addAll(temp);

					temp.setOnMouseExited(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							// TODO Auto-generated method stub
							Finalscore2.this.getChildren().remove(temp);
						}
					});
					temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							// TODO Auto-generated method stub
							AudioUtility.stopSound("congrat");
							Main.instance.setToGameScreen2();
						}
					});
				}
			});
			this.getChildren().addAll(canvas, button_mainmenu_result, button_tryagain);

			// จัดการเรื่องผลคะแนน
			Font f = Font.font("Times New  Roman", FontWeight.BOLD, 50);
			gc.setFont(f);
			gc.setFill(Color.BLACK);
			gc.fillText(out1, 680, 430);
			gc.fillText(out2, 440, 430);
			gc.fillText(main.getName1(), 620, 280);
			gc.fillText(main.getName2(), 400, 350);
			gm.setScore1(0);
			gm.setScore2(0);

		}
		// กรณีคะแนนเท่ากัน
		else {
			Image result_one = new Image(ClassLoader.getSystemResource("result_two_same.png").toString());
			gc.drawImage(result_one, 0, 0);
			// สร้างปุ่ม main menu
			Image mainmenu_result = new Image(ClassLoader.getSystemResource("mainmenu_result.png").toString());
			Image mainmenu_result_point = new Image(
					ClassLoader.getSystemResource("mainmenu_result_point.png").toString());

			Button button_mainmenu_result = new Button("", new ImageView(mainmenu_result));
			button_mainmenu_result.setStyle("-fx-background-color: rgb(256,256,256)");
			button_mainmenu_result.setLayoutX(225);
			button_mainmenu_result.setLayoutY(455);
			button_mainmenu_result.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					Button temp = new Button("", new ImageView(mainmenu_result_point));
					temp.setStyle("-fx-background-color: rgb(256,256,256)");
					temp.setLayoutX(225);
					temp.setLayoutY(455);
					Finalscore2.this.getChildren().addAll(temp);
					temp.setOnMouseExited(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							Finalscore2.this.getChildren().remove(temp);
						}
					});
					temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							// TODO Auto-generated method stub
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
			button_tryagain.setLayoutY(464);
			button_tryagain.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// TODO Auto-generated method stub
					Button temp = new Button("", new ImageView(tryagain_point));
					temp.setStyle("-fx-background-color: rgb(256,256,256)");
					temp.setLayoutX(600);
					temp.setLayoutY(463);
					Finalscore2.this.getChildren().addAll(temp);

					temp.setOnMouseExited(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							// TODO Auto-generated method stub
							Finalscore2.this.getChildren().remove(temp);
						}
					});
					temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							// TODO Auto-generated method stub
							Main.instance.setToGameScreen2();
						}
					});
				}
			});
			this.getChildren().addAll(canvas, button_mainmenu_result, button_tryagain);

			// จัดการเรื่องผลคะแนน
			Font f = Font.font("Times New  Roman", FontWeight.BOLD, 50);
			gc.setFont(f);
			gc.setFill(Color.BLACK);
			gc.fillText(out1, 545, 430);
			gm.setScore1(0);
			gm.setScore2(0);
		}
	}
}
