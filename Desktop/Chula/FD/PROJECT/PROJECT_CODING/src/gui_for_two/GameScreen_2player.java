/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package gui_for_two;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.GameManager_2player;
import model_for_two.RenderableHolder_for_two;
import ui.Configuration;

public class GameScreen_2player extends Canvas {

	// ø‘«¥Ï
	private GraphicsContext gc = this.getGraphicsContext2D();
	private Image background = new Image(ClassLoader.getSystemResource("engineer.png").toString());

	// §Õπ µ√—°‡µÕ√Ï
	public GameScreen_2player() {
		super(Configuration.screen_width, Configuration.screen_height);
	}

	// ‡¡∑Õ¥«“¥ Ë«πª√–°Õ∫
	public synchronized void paintComponents() {
		gc.clearRect(0, 0, Configuration.screen_width, Configuration.screen_height);
		gc.drawImage(background, 0, 0);
		Image line = new Image(ClassLoader.getSystemResource("line.png").toString());
		gc.drawImage(line, 0, 0);
		for (int index = RenderableHolder_for_two.getInstance().getEntities().size() - 1; index >= 0; index--) {
			RenderableHolder_for_two.getInstance().getEntities().get(index).draw(gc);
		}
		drawTime(gc);
		drawScore(gc);
	}

	// ‡¡∑Õ¥«“¥§–·ππ
	public synchronized void drawScore(GraphicsContext gc) {
		String out1;
		if (GameManager_2player.score1 < 1000 && GameManager_2player.score1 >= 100) {
			out1 = "SCORE : " + "0" + GameManager_2player.score1;
		} else if (GameManager_2player.score1 < 100 && GameManager_2player.score1 >= 10) {
			out1 = "SCORE : " + "00" + GameManager_2player.score1;
		} else if (GameManager_2player.score1 < 10) {
			out1 = "SCORE : " + "000" + GameManager_2player.score1;
		} else {
			out1 = "SCORE : " + "" + GameManager_2player.score1;
		}
		Font f = Font.font("Times New  Roman", FontWeight.BOLD, 50);
		gc.setFont(f);
		gc.setFill(Color.PINK);
		gc.fillText(out1, 40, 50);
		String out2;
		if (GameManager_2player.score2 < 1000 && GameManager_2player.score2 >= 100) {
			out2 = "SCORE : " + "0" + GameManager_2player.score2;
		} else if (GameManager_2player.score2 < 100 && GameManager_2player.score2 >= 10) {
			out2 = "SCORE : " + "00" + GameManager_2player.score2;
		} else if (GameManager_2player.score2 < 10) {
			out2 = "SCORE : " + "000" + GameManager_2player.score2;
		} else {
			out2 = "SCORE : " + "" + GameManager_2player.score2;
		}
		gc.setFont(f);
		gc.setFill(Color.PINK);
		gc.fillText(out2, 720, 50);
	}

	// ‡¡∑Õ¥«“¥§–·ππ
	public synchronized void drawTime(GraphicsContext gc) {
		String out;
		out = "Time : " + "" + GameManager_2player.time;
		Font f = Font.font("Times New  Roman", FontWeight.BOLD, 50);
		gc.setFont(f);
		gc.setFill(Color.YELLOW);
		gc.fillText(out, 440, 50);
	}

	// ‡¡∑Õ¥‡√’¬°·∫√°°“«¥Ï
	public void LoadImage(Image image) {
		background = image;
	}

	// ‡¡∑Õ¥‚À≈¥‡√’¬°§–·ππ1·≈–2
	public int getScore1() {
		return GameManager_2player.score1;
	}

	public int getScore2() {
		return GameManager_2player.score1;
	}

	// ‡¡∑Õ¥‚À≈¥‡√’¬°gc
	public GraphicsContext getGraphicContext() {
		return gc;
	}
}
