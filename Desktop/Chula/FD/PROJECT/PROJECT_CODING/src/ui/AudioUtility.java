/*
 * By
 * Krittakan Tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package ui;

import javafx.scene.media.AudioClip;

public class AudioUtility {
	private static final String play = "play.wav";
	private static final String theme = "theme.wav";
	private static final String congrat = "congrat.wav";
	private static final String keep = "keep.wav";
	private static final String fail = "fail.wav";
	private static AudioClip sound_play;
	private static AudioClip sound_theme;
	private static AudioClip sound_congrat;
	private static AudioClip sound_keep;
	private static AudioClip sound_fail;
	static {
		loadResource();
	}

	public static void loadResource() {
		sound_play = new AudioClip(ClassLoader.getSystemResource(play).toString());
		sound_theme = new AudioClip(ClassLoader.getSystemResource(theme).toString());
		sound_congrat = new AudioClip(ClassLoader.getSystemResource(congrat).toString());
		sound_keep = new AudioClip(ClassLoader.getSystemResource(keep).toString());
		sound_fail = new AudioClip(ClassLoader.getSystemResource(fail).toString());

	}

	public static void playSound(String identifier) {
		if (identifier.equals("play")) {
			sound_play.setCycleCount(10);
			sound_play.play();
		} else if (identifier.equals("theme")) {
			sound_theme.setCycleCount(10);
			sound_theme.play();
		} else if (identifier.equals("congrat")) {
			sound_congrat.setCycleCount(10);
			sound_congrat.play();
		} else if (identifier.equals("keep")) {
			sound_keep.play();
		} else if (identifier.equals("fail")) {
			sound_fail.play();
		}
	}

	public static void stopSound(String identifier) {
		if (identifier.equals("play")) {
			sound_play.stop();
		} else if (identifier.equals("theme")) {
			sound_theme.stop();
		} else if (identifier.equals("congrat")) {
			sound_congrat.stop();
		} else if (identifier.equals("keep")) {
			sound_keep.stop();
		} else if (identifier.equals("fail")) {
			sound_fail.stop();
		}
	}
}
