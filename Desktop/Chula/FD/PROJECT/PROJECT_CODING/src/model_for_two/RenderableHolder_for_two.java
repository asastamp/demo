/*
 * By
 * Krittakan tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package model_for_two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RenderableHolder_for_two {

	// ฟิวด์
	private List<IRenderable_for_two> entities;
	private Comparator<IRenderable_for_two> comparator;
	private static final RenderableHolder_for_two instance = new RenderableHolder_for_two();

	// คอนสตรัคเตอร์
	public RenderableHolder_for_two() {
		entities = new ArrayList<IRenderable_for_two>();
		comparator = (IRenderable_for_two o1, IRenderable_for_two o2) -> {
			if (o1.getZ() > o2.getZ()) {
				return 1;
			}
			return -1;
		};
	}

	// เมทอดทั้งหมด
	public synchronized void add(IRenderable_for_two entity) {
		instance.getEntities().add(entity);
		Collections.sort(entities, comparator);
	}

	public synchronized void remove(int index) {
		instance.getEntities().remove(index);
	}

	public synchronized static RenderableHolder_for_two getInstance() {
		return instance;
	}

	public synchronized List<IRenderable_for_two> getEntities() {
		return entities;
	}
}
