/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package gui_for_one;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.GameManager_1player;
import model_for_one.IRenderable_for_one;
import model_for_one.RenderableHolder_for_one;
import ui.Configuration;

public class GameScreen_1player extends Canvas {

	// ø‘«¥Ï
	private GraphicsContext gc = this.getGraphicsContext2D();
	private Image background = new Image(ClassLoader.getSystemResource("bathroom.png").toString());

	// §Õπ µ√—°‡µÕ√Ï
	public GameScreen_1player() {
		super(Configuration.screen_width, Configuration.screen_height);
	}

	// ‡¡∑Õ¥«“¥ Ë«πª√–°Õ∫
	public synchronized void paintComponents() {
		gc.clearRect(0, 0, Configuration.screen_width, Configuration.screen_height);
		gc.drawImage(background, 0, 0);
		for (IRenderable_for_one e : RenderableHolder_for_one.getInstance().getEntities()) {
			e.draw(gc);
		}
		drawScore(gc);
		drawTime(gc);
	}

	// ‡¡∑Õ¥«“¥§–·ππ
	public synchronized void drawScore(GraphicsContext gc) {
		String out;
		if (GameManager_1player.score < 1000 && GameManager_1player.score >= 100) {
			out = "SCORE : " + "0" + GameManager_1player.score;
		} else if (GameManager_1player.score < 100 && GameManager_1player.score >= 10) {
			out = "SCORE : " + "00" + GameManager_1player.score;
		} else if (GameManager_1player.score < 10) {
			out = "SCORE : " + "000" + GameManager_1player.score;
		} else {
			out = "SCORE : " + "" + GameManager_1player.score;
		}
		Font f = Font.font("Times New  Roman", FontWeight.BOLD, 50);
		gc.setFont(f);
		gc.setFill(Color.PINK);
		gc.fillText(out, 720, 50);
	}

	// ‡¡∑Õ¥«“¥§–·ππ
	public synchronized void drawTime(GraphicsContext gc) {
		String out;
		out = "Time : " + "" + GameManager_1player.time;
		Font f = Font.font("Times New  Roman", FontWeight.BOLD, 50);
		gc.setFont(f);
		gc.setFill(Color.PINK);
		gc.fillText(out, 40, 50);
	}

	// ‡¡∑Õ¥‡√’¬°·∫√°°“«¥Ï
	public void LoadImage(Image image) {
		background = image;
	}

	// ‡¡∑Õ¥‚À≈¥‡√’¬°§–·ππ
	public int getScore() {
		return GameManager_1player.score;
	}

	// ‡¡∑Õ¥‚À≈¥‡√’¬°gc
	public GraphicsContext getGraphicContext() {
		return gc;
	}
}
