
package model_for_one;

import java.util.ArrayList;
import java.util.List;

public class ThreadHolder_for_one {
	public static final ThreadHolder_for_one instance = new ThreadHolder_for_one();

	private List<Thread> threads = new ArrayList<Thread>();

	public List<Thread> getThreads() {
		return threads;
	}
}
