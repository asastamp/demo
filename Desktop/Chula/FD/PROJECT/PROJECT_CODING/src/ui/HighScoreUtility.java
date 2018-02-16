/*
 * By
 * Krittakan Tisantea 5830009821
 * Kittiphan Nilprakobkul 5830032121
 */
package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Alert.AlertType;

public class HighScoreUtility {

	public static class HighScoreRecord implements Comparable<HighScoreRecord> {

		// ฟิวด์ inner
		private String name = "";
		private int score = 0;

		// คอนสตรักเตอร์ inner
		private HighScoreRecord(String name, int score) {
			this.name = name;
			this.score = score;
		}

		// เเมทอดทำงานกับ exception
		public HighScoreRecord(String record) throws ScoreParsingException {
			String[] stringRecord = record.split(":");
			if (stringRecord[1].matches("[0:9]+")) {
				throw new ScoreParsingException(0);
			}
			if (stringRecord.length != 2) {
				throw new ScoreParsingException(1);
			}
			name = stringRecord[0];
			score = Integer.parseInt(stringRecord[1]);
		}

		// เมทอด getrecord
		private String getRecord() {
			return name.trim() + ":" + score;
		}

		// เมทอด defaultRecord
		private static String[] defaultRecord() {
			return new String[] { "A:800", "B:350", "C:300", "D:250", "E:200", "F:100", "G:40", "H:30", "I:20",
					"J:10" };
		}

		// เมทอดเปรียบเทียบ
		@Override
		public int compareTo(HighScoreRecord o) {
			if (score > o.score) {
				return -1;
			} else if (score < o.score) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	// ฟิวด์ outter
	private static HighScoreRecord[] highScoreRecord = null;
	private static String readFileName = "highscore";

	// เมทอดบันทึกคะแนนสูงสุด
	public static void recordHighScore(int score, String name) {
		System.out.println("recordHighScore");
		if (!loadHighScore() || highScoreRecord == null) {
			return;
		}
		int index = highScoreRecord.length;
		for (int i = 0; i < highScoreRecord.length; i++) {
			if (score > highScoreRecord[i].score) {
				index = i;
				break;
			}
		}
		if (index < highScoreRecord.length) {
			for (int i = highScoreRecord.length - 1; i >= index + 1; i--) {
				highScoreRecord[i] = highScoreRecord[i - 1];
			}

			final int final_index = index;
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("highscore"));
				HighScoreRecord newRecord = new HighScoreRecord(name, score);
				highScoreRecord[final_index] = newRecord;
				String a = "";
				for (HighScoreRecord i : highScoreRecord) {
					a += i.getRecord() + "\n";
				}
				String b = getXORed(a);
				out.write(b);
				out.close();
			} catch (IOException e1) {
				highScoreRecord = null;
				return;
			}
			System.out.println("Score is recorded");
		}

	}

	// เมทอดเอาไว้เรียกคะแนน
	public static void displayTop10() {
		if (!loadHighScore() || highScoreRecord == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Error loading highscore record");
			alert.show();
			return;
		}
		String msg = "-------10 ทำเนียบนักเรียนดีเด่น-------" + System.getProperty("line.separator");
		int rank = 1;
		for (HighScoreRecord record : highScoreRecord) {
			msg += rank + " " + record.getRecord() + System.getProperty("line.separator");
			rank++;
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("10 ตัวเทพ");
		alert.setHeaderText(null);
		alert.setContentText(msg.trim());
		alert.showAndWait();
	}

	// เมทอดโหลดคะแนน
	private static boolean loadHighScore() {
		File f = new File(readFileName);
		if (!f.exists()) {
			if (!createDefaultScoreFile())
				return false;
		}
		if (!readAndParseScoreFile(f)) {
			f.delete();
			if (!createDefaultScoreFile())
				return false;
			return readAndParseScoreFile(f);
		}
		return true;

	}

	// เมอทอดอ่านไฟล์
	private static boolean readAndParseScoreFile(File f) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(f));
			highScoreRecord = new HighScoreRecord[10];
			String str = "";
			int c;
			while ((c = in.read()) != -1) {
				str += (char) c;
			}
			in.close();
			String[] records = getXORed(str).split("\n");
			for (int i = 0; i < highScoreRecord.length; i++) {
				try {
					highScoreRecord[i] = new HighScoreRecord(records[i]);
				} catch (ScoreParsingException e) {
					System.err.println("Error parsing line " + (i + 1) + ", " + e.getMessage());
					highScoreRecord[i] = new HighScoreRecord("ERROR_RECORD", 0);
				}
			}
			Arrays.sort(highScoreRecord);
			return true;
		} catch (Exception e) {
			highScoreRecord = null;
		}
		return false;
	}

	// สร้าง default score
	private static boolean createDefaultScoreFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("highscore"));
			String str = "";
			for (String s : HighScoreRecord.defaultRecord()) {
				str += s + "\n";
			}
			str = str.trim();
			out.write(getXORed(str));
			out.close();
			return true;
		} catch (IOException e1) {
			highScoreRecord = null;
			return false;
		}
	}

	private static final byte[] key = "RmAAq2b5d8fjgu9dhher".getBytes();

	// เมทอดเกี่ยวกับการเข้ารหัส
	private static String getXORed(String in) {
		byte[] inData = in.getBytes();
		for (int i = 0; i < inData.length; i++) {
			inData[i] = (byte) (inData[i] ^ key[i % key.length]);
		}
		return new String(inData);
	}

	// เซตเตอร์ readfilename
	public static void setReadFileName(String name) {
		readFileName = name;
	}
}