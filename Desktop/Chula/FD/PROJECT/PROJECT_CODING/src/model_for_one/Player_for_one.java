/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package model_for_one;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player_for_one extends Entity_for_one {

	// ��Ǵ�
	public static boolean isDestroy;

	// �͹ʵ�Ѥ����
	public Player_for_one(int x, int y) {
		super(x, y);
		movespeed = 80;
		isDestroy = false;
		z = 2;
	}

	// ����ʹ�Ҵ������
	@Override
	public void draw(GraphicsContext gc) {
		Image player = new Image(ClassLoader.getSystemResource("player1.png").toString());
		gc.drawImage(player, x, y);
	}

	// ����ʹ ������
	@Override
	public boolean isDestroy() {
		return isDestroy;
	}

}