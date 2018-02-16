/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package graphic;

import Main.Main;
import gui_for_one.GameScreen_1player;
import gui_for_two.GameScreen_2player;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import ui.AudioUtility;
import ui.Configuration;
import ui.HighScoreUtility;

public class Mainmenu extends Pane {
	private Image sound_on = new Image(ClassLoader.getSystemResource("sound_on.png").toString());
	private Image sound_off = new Image(ClassLoader.getSystemResource("sound_off.png").toString());
	private Button button_sound_on = new Button("", new ImageView(sound_on));
	private Button button_sound_off = new Button("", new ImageView(sound_off));

	public Mainmenu(GameScreen_1player gs1, GameScreen_2player gs2) {

		// เปิดเสียง
		AudioUtility.playSound("play");

		// สร้างหน้า main
		Canvas canvas = new Canvas(Configuration.screen_width, Configuration.screen_height);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		// ตั้งค่าพื้นหลัง
		Image background = new Image(ClassLoader.getSystemResource("main.png").toString());
		gc.drawImage(background, 0, 0);

		// โหลดภาพ background
		Image classroom = new Image(ClassLoader.getSystemResource("classroom.png").toString());
		Image classroom_point = new Image(ClassLoader.getSystemResource("classroom_point.png").toString());
		Image kitchen = new Image(ClassLoader.getSystemResource("kitchen.png").toString());
		Image kitchen_point = new Image(ClassLoader.getSystemResource("kitchen_point.png").toString());
		Image bathroom = new Image(ClassLoader.getSystemResource("bathroom.png").toString());
		Image bathroom_point = new Image(ClassLoader.getSystemResource("bathroom_point.jpg").toString());
		Image bedroom = new Image(ClassLoader.getSystemResource("bedroom.png").toString());
		Image bedroom_point = new Image(ClassLoader.getSystemResource("bedroom_point.jpg").toString());
		Image engineer = new Image(ClassLoader.getSystemResource("engineer.png").toString());
		Image engineer_point = new Image(ClassLoader.getSystemResource("engineer_point.png").toString());

		// สร้างปุ่มสำหรับเลือกภาพ
		Button button_classroom = new Button("", new ImageView(classroom));
		button_classroom.setStyle("-fx-background-color: rgb(162,151,133)");
		button_classroom.setLayoutX(274);
		button_classroom.setLayoutY(373);

		Button button_classroom_point = new Button("", new ImageView(classroom_point));
		button_classroom_point.setStyle("-fx-background-color: rgb(162,151,133)");
		button_classroom_point.setLayoutX(274);
		button_classroom_point.setLayoutY(373);

		Button button_kitchen = new Button("", new ImageView(kitchen));
		button_kitchen.setStyle("-fx-background-color: rgb(162,151,133)");
		button_kitchen.setLayoutX(450);
		button_kitchen.setLayoutY(373);

		Button button_kitchen_point = new Button("", new ImageView(kitchen_point));
		button_kitchen_point.setStyle("-fx-background-color: rgb(162,151,133)");
		button_kitchen_point.setLayoutX(450);
		button_kitchen_point.setLayoutY(373);

		Button button_bathroom = new Button("", new ImageView(bathroom));
		button_bathroom.setStyle("-fx-background-color: rgb(162,151,133)");
		button_bathroom.setLayoutX(606);
		button_bathroom.setLayoutY(373);

		Button button_bathroom_point = new Button("", new ImageView(bathroom_point));
		button_bathroom_point.setStyle("-fx-background-color: rgb(162,151,133)");
		button_bathroom_point.setLayoutX(606);
		button_bathroom_point.setLayoutY(373);

		Button button_bedroom = new Button("", new ImageView(bedroom));
		button_bedroom.setStyle("-fx-background-color: rgb(162,151,133)");
		button_bedroom.setLayoutX(762);
		button_bedroom.setLayoutY(373);

		Button button_bedroom_point = new Button("", new ImageView(bedroom_point));
		button_bedroom_point.setStyle("-fx-background-color: rgb(162,151,133)");
		button_bedroom_point.setLayoutX(762);
		button_bedroom_point.setLayoutY(373);

		Button button_engineer = new Button("", new ImageView(engineer));
		button_engineer.setStyle("-fx-background-color: rgb(162,151,133)");
		button_engineer.setLayoutX(918);
		button_engineer.setLayoutY(373);

		Button button_engineer_point = new Button("", new ImageView(engineer_point));
		button_engineer_point.setStyle("-fx-background-color: rgb(162,151,133)");
		button_engineer_point.setLayoutX(918);
		button_engineer_point.setLayoutY(373);

		// เซต event ปุ่มเลือก background
		button_classroom.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Mainmenu.this.getChildren().addAll(button_classroom_point);
				Mainmenu.this.getChildren().removeAll(button_kitchen_point, button_bathroom_point, button_bedroom_point,
						button_engineer_point);
				Image classroom_game = new Image(ClassLoader.getSystemResource("classroom_game.png").toString());
				gs1.LoadImage(classroom_game);
				gs2.LoadImage(classroom_game);
			}
		});

		button_kitchen.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Mainmenu.this.getChildren().addAll(button_kitchen_point);
				Mainmenu.this.getChildren().removeAll(button_classroom_point, button_bathroom_point,
						button_bedroom_point, button_engineer_point);
				Image kitchen_game = new Image(ClassLoader.getSystemResource("kitchen_game.png").toString());
				gs1.LoadImage(kitchen_game);
				gs2.LoadImage(kitchen_game);
			}
		});

		button_bathroom.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Mainmenu.this.getChildren().addAll(button_bathroom_point);
				Mainmenu.this.getChildren().removeAll(button_classroom_point, button_kitchen_point,
						button_bedroom_point, button_engineer_point);
				Image bathroom_game = new Image(ClassLoader.getSystemResource("bathroom_game.png").toString());
				gs1.LoadImage(bathroom_game);
				gs2.LoadImage(bathroom_game);
			}
		});

		button_bedroom.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Mainmenu.this.getChildren().addAll(button_bedroom_point);
				Mainmenu.this.getChildren().removeAll(button_classroom_point, button_kitchen_point,
						button_bathroom_point, button_engineer_point);
				Image bedroom_game = new Image(ClassLoader.getSystemResource("bedroom_game.png").toString());
				gs1.LoadImage(bedroom_game);
				gs2.LoadImage(bedroom_game);
			}
		});

		button_engineer.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Mainmenu.this.getChildren().addAll(button_engineer_point);
				Mainmenu.this.getChildren().removeAll(button_classroom_point, button_kitchen_point,
						button_bedroom_point, button_bathroom_point);
				Image engineer_game = new Image(ClassLoader.getSystemResource("engineer_game.png").toString());
				gs1.LoadImage(engineer_game);
				gs2.LoadImage(engineer_game);
			}
		});

		// เซคค่า button_one_player
		Image one_player = new Image(ClassLoader.getSystemResource("one_player.png").toString());
		Image one_player_point = new Image(ClassLoader.getSystemResource("one_player_point.png").toString());

		Button button_one_player = new Button("", new ImageView(one_player));
		button_one_player.setStyle("-fx-background-color: rgb(60,68,62)");
		button_one_player.setLayoutX(10);
		button_one_player.setLayoutY(169);
		button_one_player.setPrefSize(200, 100);
		button_one_player.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Button temp = new Button("", new ImageView(one_player_point));
				temp.setStyle("-fx-background-color: rgb(60,68,62)");
				temp.setLayoutX(10);
				temp.setLayoutY(169);
				temp.setPrefSize(200, 100);
				Mainmenu.this.getChildren().addAll(temp);
				temp.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						Mainmenu.this.getChildren().remove(temp);

					}
				});
				temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						if (Mainmenu.this.getChildren().contains(button_bathroom_point)
								|| Mainmenu.this.getChildren().contains(button_classroom_point)
								|| Mainmenu.this.getChildren().contains(button_kitchen_point)
								|| Mainmenu.this.getChildren().contains(button_bedroom_point)
								|| Mainmenu.this.getChildren().contains(button_engineer_point)) {
							if (Mainmenu.this.getChildren().contains(button_sound_off)) {
								Mainmenu.this.getChildren().remove(button_sound_off);
							}
							if (!Mainmenu.this.getChildren().contains(button_sound_on)) {
								Mainmenu.this.getChildren().add(button_sound_on);
							}

							Main.instance.setToGameScreen1();
							AudioUtility.stopSound("play");
						} else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Please Select Background");
							alert.setHeaderText(null);
							alert.setContentText("ไปเลือกที่ที่จะไปเก็บเกรดก่อนสิ");
							alert.showAndWait();
						}

					}
				});
			}
		});

		// เซคค่า button_two_player
		Image two_player = new Image(ClassLoader.getSystemResource("two_player.png").toString());
		Image two_player_point = new Image(ClassLoader.getSystemResource("two_player_point.png").toString());

		Button button_two_player = new Button("", new ImageView(two_player));
		button_two_player.setStyle("-fx-background-color: rgb(60,68,62)");
		button_two_player.setLayoutX(300);
		button_two_player.setLayoutY(169);
		button_two_player.setPrefSize(200, 100);
		button_two_player.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Button temp = new Button("", new ImageView(two_player_point));
				temp.setStyle("-fx-background-color: rgb(60,68,62)");
				temp.setLayoutX(300);
				temp.setLayoutY(169);
				temp.setPrefSize(200, 100);
				Mainmenu.this.getChildren().addAll(temp);
				temp.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						Mainmenu.this.getChildren().remove(temp);
					}
				});
				temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						if (Mainmenu.this.getChildren().contains(button_bathroom_point)
								|| Mainmenu.this.getChildren().contains(button_classroom_point)
								|| Mainmenu.this.getChildren().contains(button_kitchen_point)
								|| Mainmenu.this.getChildren().contains(button_bedroom_point)
								|| Mainmenu.this.getChildren().contains(button_engineer_point)) {
							Main.instance.setToGameScreen2();
							AudioUtility.stopSound("play");
						} else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Please Select Background");
							alert.setHeaderText(null);
							alert.setContentText("ไปเลือกที่ที่จะไปเก็บเกรดก่อนสิ");
							alert.showAndWait();
						}
					}
				});
			}
		});

		// เซตค่า button_manual
		Image manual = new Image(ClassLoader.getSystemResource("manual.png").toString());
		Image manual_point = new Image(ClassLoader.getSystemResource("manual_point.png").toString());

		Button button_manual = new Button("", new ImageView(manual));
		button_manual.setStyle("-fx-background-color: rgb(197,172,83)");
		button_manual.setLayoutX(643);
		button_manual.setLayoutY(508);
		button_manual.setPrefSize(200, 100);
		button_manual.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Button temp = new Button("", new ImageView(manual_point));
				temp.setStyle("-fx-background-color: rgb(197,172,83)");
				temp.setLayoutX(643);
				temp.setLayoutY(508);
				temp.setPrefSize(200, 100);
				Mainmenu.this.getChildren().add(temp);
				temp.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						Mainmenu.this.getChildren().remove(temp);
					}
				});
				temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						Main.instance.setToManual();
					}
				});
			}
		});

		// เซตค่า button_highscore
		Image highscore = new Image(ClassLoader.getSystemResource("highscore.png").toString());
		Image highscore_point = new Image(ClassLoader.getSystemResource("highscore_point.png").toString());

		Button button_highscore = new Button("", new ImageView(highscore));
		button_highscore.setStyle("-fx-background-color: rgb(197,172,83)");
		button_highscore.setLayoutX(180);
		button_highscore.setLayoutY(508);
		button_highscore.setPrefSize(200, 100);
		button_highscore.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Button temp = new Button("", new ImageView(highscore_point));
				temp.setStyle("-fx-background-color: rgb(197,172,83)");
				temp.setLayoutX(180);
				temp.setLayoutY(508);
				temp.setPrefSize(200, 100);
				Mainmenu.this.getChildren().addAll(temp);
				temp.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						Mainmenu.this.getChildren().remove(temp);
					}
				});
				temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						HighScoreUtility.displayTop10();
					}
				});
			}
		});

		// เซตปุ่มเปิดปิดเสียง
		button_sound_on.setStyle("-fx-background-color: rgb(141,107,62)");
		button_sound_on.setLayoutX(2);
		button_sound_on.setLayoutY(540);
		button_sound_off.setStyle("-fx-background-color: rgb(141,107,62)");
		button_sound_off.setLayoutX(2);
		button_sound_off.setLayoutY(540);

		button_sound_on.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Mainmenu.this.getChildren().add(button_sound_off);
				Mainmenu.this.getChildren().remove(button_sound_on);
				AudioUtility.stopSound("play");
			}
		});

		button_sound_off.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Mainmenu.this.getChildren().add(button_sound_on);
				Mainmenu.this.getChildren().remove(button_sound_off);
				AudioUtility.playSound("play");
			}
		});

		// เก็บปุ่มและภาพทั้งหมด
		this.getChildren().addAll(canvas, button_one_player, button_two_player, button_manual, button_highscore,
				button_classroom, button_kitchen, button_bathroom, button_bedroom, button_engineer, button_sound_on);

	}
}
