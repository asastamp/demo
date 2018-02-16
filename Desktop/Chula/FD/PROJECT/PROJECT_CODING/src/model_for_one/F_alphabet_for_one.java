/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package model_for_one;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class F_alphabet_for_one extends Entity_for_one {

	// ��Ǵ�
	private boolean isDestroy;

	// �͹ʵ�Ѥ����
	public F_alphabet_for_one(int x, int y) {
		super(x, y);
		movespeed = 50;
	}

	// ����ʹ�Ҵ����ѡ��
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

	// ����ʹ ������ ૵����
	@Override
	public boolean isDestroy() {
		return isDestroy;
	}

	public void setDestroy() {
		isDestroy = true;
	}
}