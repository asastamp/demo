/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package logic;

import javafx.scene.input.KeyCode;
import logic.CodeUtility;
import model_for_one.*;
import ui.AudioUtility;
import ui.Configuration;

public class GameManager_1player {

	// ¿ÔÇ´ì
	private int tickCounter = 0;
	private Player_for_one player;
	public static int score = 0;
	public static int time = 30;
	private static final int aScore = 85;
	private static final int bPlusScore = 80;
	private static final int bScore = 75;
	private static final int cPlusScore = 70;
	private static final int cScore = 65;
	private static final int dPlusScore = 60;
	private static final int dScore = 50;

	// ¤Í¹ÊµÑ¤àµÍÃì
	public GameManager_1player() {
		player = new Player_for_one(500, 580);
		addEntity(player);
	}

	// àÁ·Í´¨Ñ´¡ÒÃà¡Á·Ñé§ËÁ´
	private void addEntity(IRenderable_for_one entity) {
		RenderableHolder_for_one.getInstance().add(entity);
	}

	public void update() {
		if (tickCounter % 3 == 0 && tickCounter > 5) {
			int x = (int) (Math.random() * (Configuration.screen_width - 50));
			A_D_alphabet_for_one atoD = new A_D_alphabet_for_one(x, 0);
			RenderableHolder_for_one.getInstance().add(atoD);
			tickCounter++;
		} else if (tickCounter == 22 && tickCounter > 5) {
			int x = (int) (Math.random() * (Configuration.screen_width - 50));
			F_alphabet_for_one f = new F_alphabet_for_one(x, 0);
			RenderableHolder_for_one.getInstance().add(f);
			tickCounter = 0;
		} else {
			tickCounter++;
		}
		checkDead();
		removeDestroyEntity();
		checkCollision();
		move();
	}

	private void removeDestroyEntity() {
		for (int index = RenderableHolder_for_one.getInstance().getEntities().size() - 1; index >= 0; index--) {
			if (RenderableHolder_for_one.getInstance().getEntities().get(index).isDestroy()) {
				RenderableHolder_for_one.getInstance().remove(index);
			}
		}
	}

	private void checkCollision() {
		Player_for_one A = player;
		IRenderable_for_one checkEntity;
		for (int index = RenderableHolder_for_one.getInstance().getEntities().size() - 1; index >= 0; index--) {
			checkEntity = RenderableHolder_for_one.getInstance().getEntities().get(index);
			if (checkEntity instanceof A_D_alphabet_for_one) {
				A_D_alphabet_for_one B = (A_D_alphabet_for_one) checkEntity;
				if ((A.getX() + 20 < B.getX() && B.getX() < A.getX() + 160 && A.getY() - 50 < B.getY()
						&& B.getY() < A.getY() + 80)) {
					AudioUtility.playSound("keep");
					if (B.getAlphabet() == 0) {
						score += aScore;
					} else if (B.getAlphabet() == 1) {
						score += bPlusScore;
					} else if (B.getAlphabet() == 2) {
						score += bScore;
					} else if (B.getAlphabet() == 3) {
						score += cPlusScore;
					} else if (B.getAlphabet() == 4) {
						score += cScore;
					} else if (B.getAlphabet() == 5) {
						score += dPlusScore;
					} else if (B.getAlphabet() == 6) {
						score += dScore;
					}
					RenderableHolder_for_one.getInstance().remove(index);
				}
			} else if (checkEntity instanceof F_alphabet_for_one) {
				F_alphabet_for_one B = (F_alphabet_for_one) checkEntity;
				if ((A.getX() + 20 < B.getX() && B.getX() < A.getX() + 160 && A.getY() - 50 < B.getY()
						&& B.getY() < A.getY() + 80)) {
					player.isDestroy = true;
					RenderableHolder_for_one.getInstance().remove(index);
					for (IRenderable_for_one e : RenderableHolder_for_one.getInstance().getEntities()) {
						if (e instanceof A_D_alphabet_for_one) {
							((A_D_alphabet_for_one) e).setDestroy();
						}
					}
				}
			}
		}
	}

	private void checkDead() {
		for (IRenderable_for_one i : RenderableHolder_for_one.getInstance().getEntities()) {
			if (i instanceof A_D_alphabet_for_one) {
				if (((A_D_alphabet_for_one) i).getY() >= Configuration.screen_height - 50) {
					((A_D_alphabet_for_one) i).setDestroy();
				}
			}
			if (i instanceof F_alphabet_for_one) {
				if (((F_alphabet_for_one) i).getY() >= Configuration.screen_height - 50) {
					((F_alphabet_for_one) i).setDestroy();

				}
			}
		}
	}

	private void move() {
		for (IRenderable_for_one i : RenderableHolder_for_one.getInstance().getEntities()) {
			if (i instanceof A_D_alphabet_for_one) {
				int moveespeed = ((A_D_alphabet_for_one) i).getMovespeed();
				((A_D_alphabet_for_one) i).setY(((A_D_alphabet_for_one) i).getY() + moveespeed);
			}
			if (i instanceof F_alphabet_for_one) {
				int moveespeed = ((F_alphabet_for_one) i).getMovespeed();
				((F_alphabet_for_one) i).setY(((F_alphabet_for_one) i).getY() + moveespeed);
			}
		}
	}

	public void receiveKey(KeyCode new_code) {
		CodeUtility.keyPressed.add(new_code);
		CodeUtility.keyTriggered.add(new_code);
		if (new_code == KeyCode.LEFT) {
			if (player.getX() - player.getMovespeed() >= -40) {
				player.setX(player.getX() - player.getMovespeed());
			} else {
				player.setX(-40);
			}
		}
		if (new_code == KeyCode.RIGHT) {
			if (player.getX() + player.getMovespeed() <= Configuration.screen_width - 190) {
				player.setX(player.getX() + player.getMovespeed());
			} else {
				player.setX(Configuration.screen_width - 190);
			}
		}
	}

	public void dropKey(KeyCode new_code) {
		CodeUtility.keyPressed.remove(new_code);
		CodeUtility.keyTriggered.remove(new_code);
	}

	// àÁ·Í´ÃÑºà«µÊ¡Í
	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		GameManager_1player.score = score;
	}
}
