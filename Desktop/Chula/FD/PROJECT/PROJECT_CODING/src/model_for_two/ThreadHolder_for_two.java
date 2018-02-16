/*
 * By
 * Krittakan Tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package model_for_two;

import java.util.ArrayList;
import java.util.List;

public class ThreadHolder_for_two {
	public static final ThreadHolder_for_two instance = new ThreadHolder_for_two();

	private List<Thread> threads = new ArrayList<Thread>();

	public List<Thread> getThreads() {
		return threads;
	}
}
