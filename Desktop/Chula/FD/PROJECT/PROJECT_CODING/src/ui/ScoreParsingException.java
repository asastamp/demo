/*
 * By
 * Krittakan Tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package ui;

public class ScoreParsingException extends Exception {

	private int errorType;

	public ScoreParsingException(int errorType) {
		this.errorType = errorType;
	}

	@Override
	public String getMessage() {

		if (errorType == 0) {
			return "No record score";
		} else if (errorType == 1) {
			return "Wrong record format";
		}
		return null;
	}
}
