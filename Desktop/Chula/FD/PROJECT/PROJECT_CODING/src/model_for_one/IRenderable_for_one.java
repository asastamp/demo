
package model_for_one;

import javafx.scene.canvas.GraphicsContext;

public interface IRenderable_for_one {
	public int getZ();

	public void draw(GraphicsContext gc);

	public boolean isDestroy();
}