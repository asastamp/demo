/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package graphic;

import Main.Main;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import ui.Configuration;

public class Manual extends Pane {
	public Manual() {

		// สร้างหน้า manual
		Canvas canvas_manual = new Canvas(Configuration.screen_width, Configuration.screen_height);
		GraphicsContext gc = canvas_manual.getGraphicsContext2D();

		// ตั้งค่า background_manual
		Image background_manual = new Image(ClassLoader.getSystemResource("background_manual.png").toString());
		gc.drawImage(background_manual, 0, 0);

		// สร้าง button_mainmenu
		Image mainmenu = new Image(ClassLoader.getSystemResource("mainmenu.png").toString());
		Image mainmenu_point = new Image(ClassLoader.getSystemResource("mainmenu_point.png").toString());

		Button button_mainmenu = new Button("", new ImageView(mainmenu));
		button_mainmenu.setStyle("-fx-background-color: rgb(88,122,100)");
		button_mainmenu.setLayoutX(620);
		button_mainmenu.setLayoutY(530);
		button_mainmenu.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Button temp = new Button("", new ImageView(mainmenu_point));
				temp.setStyle("-fx-background-color: rgb(88,122,100)");
				temp.setLayoutX(620);
				temp.setLayoutY(530);
				Manual.this.getChildren().addAll(temp);
				temp.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						Manual.this.getChildren().remove(temp);
					}
				});

				temp.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						Main.instance.setToMainMenuWithoutsound();
					}
				});
			}
		});
		this.getChildren().addAll(canvas_manual, button_mainmenu);
	}

}
