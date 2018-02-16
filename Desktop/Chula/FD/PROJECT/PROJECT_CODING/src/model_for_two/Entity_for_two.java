/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package model_for_two;

import model_for_two.IRenderable_for_two;

public abstract class Entity_for_two implements IRenderable_for_two {
	protected int x, y, z, movespeed;

	public Entity_for_two(int x, int y) {
		this.x = x;
		this.y = y;
		movespeed = 5;
		z = 1;
	}

	@Override
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMovespeed() {
		return movespeed;
	}

	public void setMovespeed(int movespeed) {
		this.movespeed = movespeed;
	}

}