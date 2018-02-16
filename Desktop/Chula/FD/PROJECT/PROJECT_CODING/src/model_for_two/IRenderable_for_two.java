/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package model_for_two;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable_for_two {
	public int getZ();

	public void draw(GraphicsContext gc);

	public boolean isDestroy();
}