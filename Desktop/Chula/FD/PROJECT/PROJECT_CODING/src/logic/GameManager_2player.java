/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package logic;

import javafx.scene.input.KeyCode;
import model_for_two.A_D_alphabet_for_two;
import model_for_two.F_alphabet_for_two;
import model_for_two.IRenderable_for_two;
import model_for_two.Player_for_two;
import model_for_two.RenderableHolder_for_two;
import ui.AudioUtility;
import ui.Configuration;
import logic.CodeUtility;

public class GameManager_2player {

	// ¿ÔÇ´ì
	private int tickCounter = 0;
	private Player_for_two player1;
	private Player_for_two player2;
	public static int time = 30;
	public static int score1 = 0;
	public static int score2 = 0;
	private static final int aScore = 85;
	private static final int bPlusScore = 80;
	private static final int bScore = 75;
	private static final int cPlusScore = 70;
	private static final int cScore = 65;
	private static final int dPlusScore = 60;
	private static final int dScore = 55;
	private static final int fScore = -100;

	// ¤Í¹ÊµÑ¤àµÍÃì
	public GameManager_2player() {
		player1 = new Player_for_two(Configuration.screen_width / 4, 580, 1);
		addEntity(player1);
		player2 = new Player_for_two((Configuration.screen_width / 4) * 3, 580, 2);
		addEntity(player2);
	}

	// àÁ·Í´¨Ñ´¡ÒÃà¡Á·Ñé§ËÁ´
	private void addEntity(IRenderable_for_two entity) {
		RenderableHolder_for_two.getInstance().add(entity);
	}

	public void update() {
		if (tickCounter % 5 == 0) {
			int x1 = (int) (Math.random() * (Configuration.screen_width / 2 - 100));
			int x2 = ((int) (Math.random() * (Configuration.screen_width / 2 - 100)))
					+ (Configuration.screen_width / 2 + 100) - 50;
			A_D_alphabet_for_two atoD1 = new A_D_alphabet_for_two(x1, 0);
			A_D_alphabet_for_two atoD2 = new A_D_alphabet_for_two(x2, 0);
			RenderableHolder_for_two.getInstance().add(atoD1);
			RenderableHolder_for_two.getInstance().add(atoD2);
			tickCounter++;
		} else if (tickCounter == 31) {
			int x1 = (int) (Math.random() * (Configuration.screen_width / 2 - 100));
			int x2 = (int) (Math.random() * (Configuration.screen_width / 2 - 100) + (Configuration.screen_width / 2)
					+ 100);
			F_alphabet_for_two f1 = new F_alphabet_for_two(x1, 0);
			F_alphabet_for_two f2 = new F_alphabet_for_two(x2, 0);
			RenderableHolder_for_two.getInstance().add(f1);
			RenderableHolder_for_two.getInstance().add(f2);
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
		for (int index = RenderableHolder_for_two.getInstance().getEntities().size() - 1; index >= 0; index--) {
			if (RenderableHolder_for_two.getInstance().getEntities().get(index).isDestroy()) {
				RenderableHolder_for_two.getInstance().remove(index);
			}
		}
	}

	private void checkCollision() {
		Player_for_two A = player1;
		IRenderable_for_two checkEntity;
		for (int index = RenderableHolder_for_two.getInstance().getEntities().size() - 1; index >= 0; index--) {
			checkEntity = RenderableHolder_for_two.getInstance().getEntities().get(index);
			if (checkEntity instanceof A_D_alphabet_for_two) {
				A_D_alphabet_for_two B = (A_D_alphabet_for_two) checkEntity;
				if ((A.getX() + 20 < B.getX() && B.getX() < A.getX() + 160 && A.getY() - 50 < B.getY()
						&& B.getY() < A.getY() + 80)) {
					AudioUtility.playSound("keep");
					if (B.getAlphabet() == 0) {
						score1 += aScore;
					} else if (B.getAlphabet() == 1) {
						score1 += bPlusScore;
					} else if (B.getAlphabet() == 2) {
						score1 += bScore;
					} else if (B.getAlphabet() == 3) {
						score1 += cPlusScore;
					} else if (B.getAlphabet() == 4) {
						score1 += cScore;
					} else if (B.getAlphabet() == 5) {
						score1 += dPlusScore;
					} else if (B.getAlphabet() == 6) {
						score1 += dScore;
					}
					RenderableHolder_for_two.getInstance().remove(index);
				}
			} else if (checkEntity instanceof F_alphabet_for_two) {
				F_alphabet_for_two B = (F_alphabet_for_two) checkEntity;
				if ((A.getX() + 20 < B.getX() && B.getX() < A.getX() + 160 && A.getY() - 50 < B.getY()
						&& B.getY() < A.getY() + 80)) {
					if (score1 - 100 >= 0) {
						score1 -= 100;
					} else {
						score1 = 0;
					}
					AudioUtility.playSound("keep");
					RenderableHolder_for_two.getInstance().remove(index);
					;
				}
			}
		}
		A = player2;
		for (int index = RenderableHolder_for_two.getInstance().getEntities().size() - 1; index >= 0; index--) {
			checkEntity = RenderableHolder_for_two.getInstance().getEntities().get(index);
			if (checkEntity instanceof A_D_alphabet_for_two) {
				A_D_alphabet_for_two B = (A_D_alphabet_for_two) checkEntity;
				if ((A.getX() - 20 < B.getX() && B.getX() < A.getX() + 120 && A.getY() - 50 < B.getY()
						&& B.getY() < A.getY() + 80)) {
					if (B.getAlphabet() == 0) {
						score2 += aScore;
					} else if (B.getAlphabet() == 1) {
						score2 += bPlusScore;
					} else if (B.getAlphabet() == 2) {
						score2 += bScore;
					} else if (B.getAlphabet() == 3) {
						score2 += cPlusScore;
					} else if (B.getAlphabet() == 4) {
						score2 += cScore;
					} else if (B.getAlphabet() == 5) {
						score2 += dPlusScore;
					} else if (B.getAlphabet() == 6) {
						score2 += dScore;
					}
					RenderableHolder_for_two.getInstance().remove(index);
					AudioUtility.playSound("keep");
				}
			} else if (checkEntity instanceof F_alphabet_for_two) {
				F_alphabet_for_two B = (F_alphabet_for_two) checkEntity;
				if ((A.getX() - 20 < B.getX() && B.getX() < A.getX() + 120 && A.getY() - 50 < B.getY()
						&& B.getY() < A.getY() + 80)) {
					if (score2 - fScore >= 0) {
						score2 -= fScore;
					} else {
						score2 = 0;
					}
					RenderableHolder_for_two.getInstance().remove(index);
					AudioUtility.playSound("keep");
				}
			}
		}
	}

	private void checkDead() {
		for (IRenderable_for_two i : RenderableHolder_for_two.getInstance().getEntities()) {
			if (i instanceof A_D_alphabet_for_two) {
				if (((A_D_alphabet_for_two) i).getY() >= Configuration.screen_height - 50) {
					((A_D_alphabet_for_two) i).setDestroy();
				}
			}
			if (i instanceof F_alphabet_for_two) {
				if (((F_alphabet_for_two) i).getY() >= Configuration.screen_height - 50) {
					((F_alphabet_for_two) i).setDestroy();
				}
			}
		}
	}

	private void move() {
		for (IRenderable_for_two i : RenderableHolder_for_two.getInstance().getEntities()) {
			if (i instanceof A_D_alphabet_for_two) {
				int moveespeed = ((A_D_alphabet_for_two) i).getMovespeed();
				((A_D_alphabet_for_two) i).setY(((A_D_alphabet_for_two) i).getY() + moveespeed);
			}
			if (i instanceof F_alphabet_for_two) {
				int moveespeed = ((F_alphabet_for_two) i).getMovespeed();
				((F_alphabet_for_two) i).setY(((F_alphabet_for_two) i).getY() + moveespeed);
			}
		}
	}

	public void receiveKeyLeft(KeyCode new_code) {
		CodeUtility.keyPressed.add(new_code);
		CodeUtility.keyTriggered.add(new_code);
		if (new_code == KeyCode.A) {
			if (player1.getX() - player1.getMovespeed() >= -40) {
				player1.setX(player1.getX() - player1.getMovespeed());
			} else {
				player1.setX(-40);
			}
		}
		if (new_code == KeyCode.D) {
			if (player1.getX() + player1.getMovespeed() <= Configuration.screen_width / 2 - 220) {
				player1.setX(player1.getX() + player1.getMovespeed());
			} else {
				player1.setX(Configuration.screen_width / 2 - 220);
			}
		}

	}

	public void receiveKeyRight(KeyCode new_code) {
		CodeUtility.keyPressed2.add(new_code);
		CodeUtility.keyTriggered2.add(new_code);

		if (new_code == KeyCode.LEFT) {
			if (player2.getX() - player2.getMovespeed() >= Configuration.screen_width / 2 + 30) {
				player2.setX(player2.getX() - player2.getMovespeed());
			} else {
				player2.setX(Configuration.screen_width / 2 + 30);
			}
		}
		if (new_code == KeyCode.RIGHT) {
			if (player2.getX() + player2.getMovespeed() <= Configuration.screen_width - 150) {
				player2.setX(player2.getX() + player2.getMovespeed());
			} else {
				player2.setX(Configuration.screen_width - 150);
			}
		}
	}

	public void dropKeyLeft(KeyCode new_code) {
		CodeUtility.keyPressed.remove(new_code);
	}

	public void dropKeyRight(KeyCode new_code) {
		CodeUtility.keyPressed2.remove(new_code);
	}

	// àÁ·Í´ÃÑºà«µÊ¡Í
	public static int getScore1() {
		if (score1 > score2) {
			return score2;
		}
		return score1;
	}

	public static int getScore2() {
		if (score1 > score2) {
			return score1;
		}
		return score2;
	}

	public static void setScore1(int score1) {
		GameManager_2player.score1 = score1;
	}

	public static void setScore2(int score2) {
		GameManager_2player.score2 = score2;
	}
}
