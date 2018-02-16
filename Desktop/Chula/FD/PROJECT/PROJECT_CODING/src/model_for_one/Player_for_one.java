/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package model_for_one;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player_for_one extends Entity_for_one {

	// ฟิวด์
	public static boolean isDestroy;

	// คอนสตรัคเตอร์
	public Player_for_one(int x, int y) {
		super(x, y);
		movespeed = 80;
		isDestroy = false;
		z = 2;
	}

	// เมดทอดวาดผู้เล่น
	@Override
	public void draw(GraphicsContext gc) {
		Image player = new Image(ClassLoader.getSystemResource("player1.png").toString());
		gc.drawImage(player, x, y);
	}

	// เมดทอด เก็ดเตอร์
	@Override
	public boolean isDestroy() {
		return isDestroy;
	}

}