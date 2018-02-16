/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package model_for_two;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player_for_two extends Entity_for_two {

	// ฟิวด์
	public static boolean isDestroy;
	public int playerNumber;

	// คอนสตรัคเตอร์
	public Player_for_two(int x, int y, int playerNumber) {
		super(x, y);
		movespeed = 40;
		isDestroy = false;
		z = 2;
		this.playerNumber = playerNumber;
	}

	// เมดทอดวาดผู้เล่น
	@Override
	public void draw(GraphicsContext gc) {
		if (playerNumber == 1) {
			Image player = new Image(ClassLoader.getSystemResource("player1.png").toString());
			gc.drawImage(player, x, y);
		}
		if (playerNumber == 2) {
			Image player = new Image(ClassLoader.getSystemResource("player2.png").toString());
			gc.drawImage(player, x, y);
		}
	}

	// เมดทอด เก็ดเตอร์
	@Override
	public boolean isDestroy() {
		return isDestroy;
	}

}