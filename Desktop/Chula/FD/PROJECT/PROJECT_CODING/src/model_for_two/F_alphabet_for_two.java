/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package model_for_two;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class F_alphabet_for_two extends Entity_for_two {

	// ฟิวด์
	private boolean isDestroy;

	// ตอนสตรัคเตอร์
	public F_alphabet_for_two(int x, int y) {
		super(x, y);
		movespeed = 50;
	}

	// เมดทอดวาดตัวอักษร
	@Override
	public void draw(GraphicsContext gc) {
		int randomPic = new Random().nextInt(2);
		if (randomPic == 0) {
			Image f = new Image(ClassLoader.getSystemResource("f1.png").toString());
			gc.drawImage(f, x, y);
		} else {
			Image f = new Image(ClassLoader.getSystemResource("f2.png").toString());
			gc.drawImage(f, x, y);
		}
	}

	// เมดทอด เก็ดเตอร์ เซตเตอร์
	@Override
	public boolean isDestroy() {
		return isDestroy;
	}

	public void setDestroy() {
		isDestroy = true;
	}
}