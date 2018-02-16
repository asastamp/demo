/*
 * By
 * Krittakan Tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package Main;

import graphic.Credit;
import graphic.Finalscore1;
import graphic.Finalscore2;
import graphic.Mainmenu;
import graphic.Manual;
import gui_for_one.GameScreen_1player;
import gui_for_one.Main_1player;
import gui_for_two.GameScreen_2player;
import gui_for_two.Main_2player;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.GameManager_1player;
import logic.GameManager_2player;
import ui.AudioUtility;
import ui.Configuration;
import ui.HighScoreUtility;

public class Main extends Application {
	public static Main instance;
	private Stage primaryStage;
	private Mainmenu mainmenu;
	private Manual manual;
	private Finalscore1 finalScore1;
	private Finalscore2 finalScore2;
	private Credit credit;
	private Main_1player main1;
	private Main_2player main2;
	private Scene menuScene;
	private Scene manualScene;
	private Scene finalScoreScene1;
	private Scene finalScoreScene2;
	private Scene creditScene;
	private Scene main1scene;
	private Scene main2scene;
	GameScreen_1player gs1 = new GameScreen_1player();
	GameScreen_2player gs2 = new GameScreen_2player();
	GameManager_1player gm1 = new GameManager_1player();
	GameManager_2player gm2 = new GameManager_2player();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
		instance = this;
		mainmenu = new Mainmenu(gs1, gs2);
		manual = new Manual();
		credit = new Credit();
		menuScene = new Scene(mainmenu, Configuration.screen_width, Configuration.screen_height);
		manualScene = new Scene(manual, Configuration.screen_width, Configuration.screen_height);
		creditScene = new Scene(credit, Configuration.screen_width, Configuration.screen_height);
		this.primaryStage.setTitle("FallenGrade");
		this.primaryStage.setScene(menuScene);
		this.primaryStage.getIcons().add(new Image(ClassLoader.getSystemResource("Fbg.png").toString()));
		this.primaryStage.show();

		// ตั้งค่าปุ่มปิด
		this.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Main.this.primaryStage.setScene(creditScene);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Thank you");
				alert.setHeaderText(null);
				alert.setContentText(
						"ขอบคุณผู้เล่นทุกท่าน \nหวังว่าเกมนี้จะให้ความบันเทิงไม่มากก็น้อย \nจากใจผู้สร้าง");
				alert.showAndWait();
				System.exit(0);
			}
		});
	}

	// เซตซีน
	public void setToManual() {
		this.primaryStage.setScene(manualScene);
	}

	public void setToMainMenu() {
		AudioUtility.playSound("play");
		this.primaryStage.setScene(menuScene);
	}

	public void setToMainMenuWithoutsound() {
		this.primaryStage.setScene(menuScene);
	}

	public void setToGameScreen1() {
		main1 = new Main_1player(gm1, gs1);
		main1scene = new Scene(main1, Configuration.screen_width, Configuration.screen_height);
		main1scene.setOnKeyPressed((KeyEvent event) -> {
			KeyCode new_code = event.getCode();
			if (main1.isRun()) {
				gm1.receiveKey(new_code);
			}
			if (new_code.equals(KeyCode.SPACE)) {
				main1.toggleRunning();
			}
			if (new_code.equals(KeyCode.M)) {

			}
		});
		main1scene.setOnKeyReleased((KeyEvent event) -> {
			KeyCode new_code = event.getCode();
			if (main1.isRun()) {
				gm1.dropKey(new_code);
			}
			if (new_code.equals(KeyCode.SPACE)) {
				gs1.getGraphicContext().drawImage(new Image(ClassLoader.getSystemResource("pause.png").toString()), 0,
						0);
			}

		});

		this.primaryStage.setScene(main1scene);
	}

	public void setToGameScreen2() {
		main2 = new Main_2player(gm2, gs2);
		main2scene = new Scene(main2, Configuration.screen_width, Configuration.screen_height);
		main2scene.setOnKeyPressed((KeyEvent event) -> {
			KeyCode new_code = event.getCode();
			if (main2.isRun()) {
				gm2.receiveKeyLeft(new_code);
				gm2.receiveKeyRight(new_code);
			}
			if (new_code.equals(KeyCode.SPACE)) {
				main2.toggleRunning();
			}
		});
		main2scene.setOnKeyReleased((KeyEvent event) -> {
			KeyCode new_code = event.getCode();
			if (main2.isRun()) {
				gm2.dropKeyLeft(new_code);
				gm2.dropKeyRight(new_code);
			}
			if (new_code.equals(KeyCode.SPACE)) {
				gs2.getGraphicContext().drawImage(new Image(ClassLoader.getSystemResource("pause.png").toString()), 0,
						0);
			}
		});
		this.primaryStage.setScene(main2scene);
	}

	public void setToFinalscore1() {
		finalScore1 = new Finalscore1(gm1, main1);
		finalScoreScene1 = new Scene(finalScore1);
		this.primaryStage.setScene(finalScoreScene1);
	}

	public void setToFinalscore2() {
		finalScore2 = new Finalscore2(gm2, main2);
		finalScoreScene2 = new Scene(finalScore2);
		this.primaryStage.setScene(finalScoreScene2);
	}

	// เซตเกมเมเนเจอร์
	public void setGamemanager1() {
		HighScoreUtility.recordHighScore(gm1.getScore(), main1.getName());
		gm1 = new GameManager_1player();
	}

	public void setGamemanager2() {
		gm2 = new GameManager_2player();
	}

}