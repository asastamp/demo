/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package gui_for_one;

import javafx.application.Platform;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import logic.GameManager_1player;
import model_for_one.IRenderable_for_one;
import model_for_one.Player_for_one;
import model_for_one.RenderableHolder_for_one;
import model_for_one.ThreadHolder_for_one;
import ui.AudioUtility;
import ui.ScoreParsingException;
import Main.Main;
import graphic.Mainmenu;

public class Main_1player extends StackPane {
	// ฟิวด์
	private Boolean isRuning = true;
	private String name;

	// คอนสตรัคเตอร์
	public Main_1player(GameManager_1player gm, GameScreen_1player gs) {
		// เพิ่มเสียงและรับ เกมสกรีน
		AudioUtility.playSound("theme");
		this.getChildren().add(gs);
		// เริ่ม thread
		Thread thread = new Thread(() -> {
			int timeCounter = 0;
			loop: while (true) {
				try {
					System.out.println("");
					if (isRuning) {
						Thread.sleep(100);
						timeCounter++;
						if (timeCounter == 10) {
							gm.time--;
							timeCounter = 0;
						}
						gm.update();
						Platform.runLater(() -> {
							gs.paintComponents();
						});
						boolean checkEnd = true;
						for (IRenderable_for_one i : RenderableHolder_for_one.getInstance().getEntities()) {
							if (i instanceof Player_for_one) {
								checkEnd = false;
							}
						}
						if (checkEnd || gm.time == 0) {
							AudioUtility.playSound("fail");
							Platform.runLater(() -> {
								for (int index = RenderableHolder_for_one.getInstance().getEntities().size()
										- 1; index >= 0; index--) {
									RenderableHolder_for_one.getInstance().remove(index);
								}
							});
							break loop;
						}
					} else {
					}
				} catch (Exception e) {

				}
			}

			// หลังเกมจบ
			Platform.runLater(() -> {
				AudioUtility.stopSound("theme");
				TextInputDialog dialog = new TextInputDialog();
				dialog.setTitle("เกมจบแล้วจ้าา");
				dialog.setHeaderText(null);
				dialog.setContentText("เกมจบแล้วจ้าา " + "\nPlease enter your name");
				dialog.showAndWait();
				name = dialog.getEditor().getText();
				gm.time = 30;
				Main.instance.setToFinalscore1();
			});
		});
		ThreadHolder_for_one.instance.getThreads().add(thread);
		thread.start();
	}

	// เมทอดหยุดเทรด
	public void stop() throws Exception {
		for (Thread thread : ThreadHolder_for_one.instance.getThreads()) {
			thread.interrupt();
		}
	}

	// getter name
	public String getName() {
		return name;
	}

	// เมทอดเกี่ยวกับ pause
	public void toggleRunning() {
		isRuning = !isRuning;
	}

	public boolean isRun() {
		return isRuning;
	}

}
