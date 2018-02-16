/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */

package graphic;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import ui.Configuration;

public class Credit extends Pane {
	public Credit() {
		// TODO Auto-generated method stub

		// ตั้งค่าพื้นหลังสำหรับฉากจบ
		Canvas canvas = new Canvas(Configuration.screen_width, Configuration.screen_height);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image credit = new Image(ClassLoader.getSystemResource("credit.png").toString());
		gc.drawImage(credit, 0, 0);
		this.getChildren().add(canvas);
	}

}
