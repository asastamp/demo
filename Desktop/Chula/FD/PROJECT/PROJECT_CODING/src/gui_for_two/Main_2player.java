/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package gui_for_two;

import Main.Main;
import javafx.application.Platform;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import logic.GameManager_2player;
import model_for_two.IRenderable_for_two;
import model_for_two.Player_for_two;
import model_for_two.RenderableHolder_for_two;
import model_for_two.ThreadHolder_for_two;
import ui.AudioUtility;

public class Main_2player extends StackPane {
	// ฟิวด์
	private Boolean isRuning = true;
	private String name1, name2;

	// คอนสตรัคเตอร์
	public Main_2player(GameManager_2player gm, GameScreen_2player gs) {

		// เพิ่มเสียงและรับ เกมสกรีน
		AudioUtility.playSound("theme");
		this.getChildren().add(gs);

		// เริ่ม thread
		Thread thread = new Thread(() -> {
			int timeCounter = 0;
			loop: while (true) {
				try {
					Thread.sleep(100);
					if (isRuning) {
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
						for (IRenderable_for_two i : RenderableHolder_for_two.getInstance().getEntities()) {
							if (i instanceof Player_for_two) {
								checkEnd = false;
							}
						}
						if (checkEnd || gm.time == 0) {
							AudioUtility.playSound("fail");
							Platform.runLater(() -> {
								for (int index = RenderableHolder_for_two.getInstance().getEntities().size()
										- 1; index >= 0; index--) {
									RenderableHolder_for_two.getInstance().remove(index);
								}
							});
							break loop;
						}
					}
				} catch (Exception e) {

				}
			}

			// หลังเกมจบ
			Platform.runLater(() -> {
				AudioUtility.stopSound("theme");
				if (gm.getScore1() != gm.getScore2()) {
					TextInputDialog dialog1 = new TextInputDialog();
					dialog1.setTitle("เกมจบแล้วจ้าา");
					dialog1.setHeaderText(null);
					dialog1.setContentText("เกมจบแล้วจ้าา " + "\nThe Winner Player Please enter your name");
					dialog1.showAndWait();
					name1 = dialog1.getEditor().getText();
					TextInputDialog dialog2 = new TextInputDialog();
					dialog2.setTitle("เกมจบแล้วจ้าา");
					dialog2.setHeaderText(null);
					dialog2.setContentText("เกมจบแล้วจ้าา " + "\nThe Loser Player Please enter your name");
					dialog2.showAndWait();
					name2 = dialog2.getEditor().getText();
				}
				gm.time = 30;
				Main.instance.setToFinalscore2();
			});
		});
		ThreadHolder_for_two.instance.getThreads().add(thread);
		thread.start();
	}

	// เมทอดหยุดเทรด
	public void stop() throws Exception {
		for (Thread thread : ThreadHolder_for_two.instance.getThreads()) {
			thread.interrupt();
		}
	}

	// getter name 1,2
	public String getName1() {
		return name1;
	}

	public String getName2() {
		return name2;
	}

	// เมทอดเกี่ยวกับ pause
	public void toggleRunning() {
		isRuning = !isRuning;
	}

	public boolean isRun() {
		return isRuning;
	}

}
