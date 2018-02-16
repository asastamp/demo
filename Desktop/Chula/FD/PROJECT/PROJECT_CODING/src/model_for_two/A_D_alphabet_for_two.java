/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package model_for_two;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class A_D_alphabet_for_two extends Entity_for_two {

	// ø‘«¥Ï
	private boolean isDestroy;
	private int alphabetNumber;
	private int randomPic;

	// µÕπ µ√—§‡µÕ√Ï
	public A_D_alphabet_for_two(int x, int y) {
		super(x, y);
		isDestroy = false;
		alphabetNumber = new Random().nextInt(7);
		movespeed = (7 - alphabetNumber) * 5;
		randomPic = new Random().nextInt(2);
	}

	// ‡¡¥∑Õ¥«“¥µ—«Õ—°…√
	@Override
	public void draw(GraphicsContext gc) {
		if (randomPic == 0) {
			if (alphabetNumber == 0) {
				Image a = new Image(ClassLoader.getSystemResource("a1.png").toString());
				gc.drawImage(a, x, y);
			} else if (alphabetNumber == 1) {
				Image bPlus = new Image(ClassLoader.getSystemResource("bPlus1.png").toString());
				gc.drawImage(bPlus, x, y);
			} else if (alphabetNumber == 2) {
				Image b = new Image(ClassLoader.getSystemResource("b1.png").toString());
				gc.drawImage(b, x, y);
			} else if (alphabetNumber == 3) {
				Image cPlus = new Image(ClassLoader.getSystemResource("cPlus1.png").toString());
				gc.drawImage(cPlus, x, y);
			} else if (alphabetNumber == 4) {
				Image c = new Image(ClassLoader.getSystemResource("c1.png").toString());
				gc.drawImage(c, x, y);
			} else if (alphabetNumber == 5) {
				Image dPlus = new Image(ClassLoader.getSystemResource("dPlus1.png").toString());
				gc.drawImage(dPlus, x, y);
			} else if (alphabetNumber == 6) {
				Image d = new Image(ClassLoader.getSystemResource("d1.png").toString());
				gc.drawImage(d, x, y);
			}
		} else {
			if (alphabetNumber == 0) {
				Image a = new Image(ClassLoader.getSystemResource("a2.png").toString());
				gc.drawImage(a, x, y);
			} else if (alphabetNumber == 1) {
				Image bPlus = new Image(ClassLoader.getSystemResource("bPlus2.png").toString());
				gc.drawImage(bPlus, x, y);
			} else if (alphabetNumber == 2) {
				Image b = new Image(ClassLoader.getSystemResource("b2.png").toString());
				gc.drawImage(b, x, y);
			} else if (alphabetNumber == 3) {
				Image cPlus = new Image(ClassLoader.getSystemResource("cPlus2.png").toString());
				gc.drawImage(cPlus, x, y);
			} else if (alphabetNumber == 4) {
				Image c = new Image(ClassLoader.getSystemResource("c2.png").toString());
				gc.drawImage(c, x, y);
			} else if (alphabetNumber == 5) {
				Image dPlus = new Image(ClassLoader.getSystemResource("dPlus2.png").toString());
				gc.drawImage(dPlus, x, y);
			} else if (alphabetNumber == 6) {
				Image d = new Image(ClassLoader.getSystemResource("d2.png").toString());
				gc.drawImage(d, x, y);
			}
		}
	}

	// ‡¡¥∑Õ¥ ‡°Á¥‡µÕ√Ï ‡´µ‡µÕ√Ï
	@Override
	public boolean isDestroy() {
		return isDestroy;
	}

	public void setDestroy() {
		isDestroy = true;
	}

	public int getAlphabet() {
		return alphabetNumber;
	}
}
