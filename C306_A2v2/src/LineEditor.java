import java.util.ArrayList;

public class LineEditor {
	Line liner = new Line();
	Cursor cursor = new Cursor();
	MoveList moves = new MoveList();
	MoveList rec = new MoveList();
	

	// movement
	private void moveH(int dir) {
		int iRow = cursor.getIndex()[0];
		int iCol = cursor.getIndex()[1];
		if (dir == -1) {
			if (iCol != 0) {
				cursor.setCol(-1, true);
			} else {
				if (iRow != 0) {
					moveV(-1);
					moveH(2);
				}
			}
		} else if (dir == 1) {
			if (iCol < liner.getLine(iRow).length() - 1) {
				cursor.setCol(1, true);
			} else {
				if (iRow != liner.getLine().size() - 1) {
					moveV(1);
					moveH(0);
				}
			}
		} else if (dir == 0) {
			cursor.setCol(0, false);
		} else if (dir == 2) {
			cursor.setCol(liner.getLine(iRow).length() - 1, false);
		}
	}

	private void moveV(int dir) {
		int iRow = cursor.getIndex()[0];
		int iCol = cursor.getIndex()[1];
		
		if (dir == -1) {
			if (iRow != 0) {
				cursor.setRow(-1, true);
			}
		} else if (dir == 1) {
			if (iRow < liner.getLine().size() - 1) {
				cursor.setRow(1, true);
			}
		} else if (dir == 0) {
			cursor.setRow(0, false);
		} else if (dir == 2) {
			cursor.setRow(liner.getLine().size() - 1, false);
		}
		
		if (iCol >= liner.getLine(cursor.getIndex()[0]).length()) {
			moveH(2);
		}
	}

	// movement end

	// record
	private void record() {
		Helper.out("Recording commands. Enter 1 command per line.");
		String choice = Helper
				.readString("Command? ('H' for help, 'R' to end) > ");
		String[] notAllowed = { "r", "e", "c", "f", "q" };
		while (!choice.equalsIgnoreCase("r")) {
			boolean ok = true;
			for (String i : notAllowed) {
				if (choice.equalsIgnoreCase(i)) {
					ok = false;
					break;
				}
			}

			if (ok) {
				if (choice.equalsIgnoreCase("x")) {
					int del = Helper.readInt("Delete how many characters? > ");
					rec.pushA(choice, cursor, false, Integer.toString(del));
				} else {
					rec.pushA(choice, cursor, false);
				}
			} else if (choice.equalsIgnoreCase("h")) {
				Helper.help(true);
			} else {
				Helper.out("Invalid command not recorded.");
			}
			choice = Helper
					.readString("Command? ('H' for help, 'R' to end) > ");
		}
	}

	private void playback() {
		if (!rec.isEmptyA()) {
			Action lastAct = rec.popQ();
			String choice = lastAct.getChoice();
			String var = lastAct.getVar();
			makeChoice(choice, false, var);
		} else {
			Helper.out("No commands to play.");
		}
	}
	// record end

	
	
	// insert delete
	private void delete(int num, Cursor current, boolean undo) {
		int delMax = liner.getLine(cursor.getIndex()[0]).length()
				- cursor.getIndex()[1];
		if (num > delMax) {
			num = delMax;
		}
		String del = liner.deleteInt(num, cursor);
		if (!undo) {
			moves.pushA("x", current, true, del);
		}
		if (cursor.getIndex()[1] >= liner.getLine(cursor.getIndex()[0])
				.length()) {
			moveH(2);

		}
	}

	private void insert(String word, Cursor current, boolean undo) {
		int maxNew = 80 - liner.getLine(cursor.getIndex()[0]).length();
		boolean ok = true;
		if (word.length() > maxNew) {
			String cut = word.substring(0, maxNew);
			Helper.out("The string will be cut down to [" + cut + "]");
			ok = Helper.readBoolean("Proceed? > ");
		}
		if (ok) {
			liner.insertStr(word, cursor);
			cursor.setCol(word.length(), true);
			if (!undo) {
				moves.pushA("c", current, true, word);
			}
		} else {
			Helper.welcome();
		}
	}
	// insert delete end

	
	
	// undo
	private void undo() {
		if (!moves.isEmptyA()) {
			Action lastAct = moves.popA();
			if (lastAct.getVar() == null) {
				this.cursor = lastAct.startPos();
			} else {
				String stringy = lastAct.getVar();
				if (lastAct.getChoice().equalsIgnoreCase("x")) {
					insert(stringy, cursor, true);
					this.cursor = lastAct.startPos();
				} else if (lastAct.getChoice().equalsIgnoreCase("c")) {
					this.cursor = lastAct.startPos();
					delete(stringy.length(), cursor, true);
				}
			}
		} else {
			Helper.out("!!!! No actions to undo.");
		}
	}
	// undo end

	
	
	// find
	private void find(int dir, boolean sens, String text) {
		Line copy = new Line(liner.getLine());
		if (!sens) {
			ArrayList<String> copyS = copy.getLine();
			int i = 0;
			for (String a : copyS) {
				copyS.set(i, a.toUpperCase());
				i++;
			}
			copy = new Line(copyS);
			text = text.toUpperCase();
		}
		Cursor res = copy.search(dir, text, cursor);
		if (res != null) {
			cursor = res;
		} else {
			Helper.out("No results.");
		}
	}
	// find end

	private void makeChoice(String c, boolean recording, String var) {
		boolean ok = true;
		Cursor current = new Cursor(cursor.getIndex()[0], cursor.getIndex()[1]);
		// movement main
		if (c.equalsIgnoreCase("w")) {
			moveV(-1);
		} else if (c.equalsIgnoreCase("a")) {
			moveH(-1);
		} else if (c.equalsIgnoreCase("s")) {
			moveV(1);
		} else if (c.equalsIgnoreCase("d")) {
			moveH(1);
		}
		// movement jumps //
		else if (c.equalsIgnoreCase("ww")) {
			moveV(0);
		} else if (c.equalsIgnoreCase("wa")) {
			moveV(0);
			moveH(0);
		} else if (c.equalsIgnoreCase("aa")) {
			moveH(0);
		} else if (c.equalsIgnoreCase("sd")) {
			moveV(2);
			moveH(2);
		} else if (c.equalsIgnoreCase("dd")) {
			moveH(2);
		} else if (c.equalsIgnoreCase("ss")) {
			moveV(2);
		} else if (c.equalsIgnoreCase("h")) {
			Helper.help(recording);
			ok = false;
		} else if (c.equalsIgnoreCase("e")) {
			playback();
			ok = false;
		} else if (c.equalsIgnoreCase("r")) {
			record();
			ok = false;
		} else if (c.equalsIgnoreCase("z")) {
			undo();
			ok = false;
		} else if (c.equalsIgnoreCase("x")) {
			int del = 0;
			if (var == null) {
				del = Helper.readInt("Delete how many characters? > ");
			} else {
				del = Integer.parseInt(var);
			}
			delete(del, current, false);
			ok = false;
		} else if (c.equalsIgnoreCase("c")) {
			if (var == null) {
				var = Helper.readString("Word to insert > ");
			}
			insert(var, current, false);
			ok = false;
		} else if (c.equalsIgnoreCase("f")) {
			int dir = Helper
					.readInt("Enter 1 to search forward, -1 for backwards and 0 to end. > ");
			while (dir < -1 && dir > 1) {
				Helper.out("Invalid input.");
				dir = Helper
						.readInt("Enter 1 to search forward, -1 for backwards and 0 to end. > ");
			}
			if (dir == 0) {
				ok = false;
			} else {
				String searcher = Helper.readString("Search for > ");
				boolean sens = Helper.readBoolean("Case-sensitive? > ");
				find(dir, sens, searcher);
			}
		} else {
			ok = false;
		}

		if (ok) {
			moves.pushA(c, current, true);
		} else {
			Helper.welcome();
		}
	}

	public void display() {
		ArrayList<String> stringy = copy();
		int[] index = cursor.getIndex();
		stringy.add(index[0] + 1, cursor.getCursor());
		for (String s : stringy) {
			Helper.out(s);
		}
		moves.displayTally();
	}

	private ArrayList<String> copy() {
		ArrayList<String> stringy = new ArrayList<>();
		stringy.addAll(liner.getLine());
		return stringy;
	}

	private String askChoice() {
		Helper.line(70, "-");
		return Helper.readString("Command? ('H' for help) > ");
	}

	public void start() {
		Helper.welcome();
		display();
		String choice = askChoice();
		while (!choice.equalsIgnoreCase("q")) {
			makeChoice(choice, false, null);
			display();
			choice = askChoice();
		}
		Helper.out("Goodbye.");
	}

	public static void main(String[] args) {
		LineEditor a = new LineEditor();
		a.start();
	}

}


/*
 * I declare that I have read, accepted and followed the SOI guidelines on academic
 * dishonesty and plagiarism for my assignment.
 * http://yoda.soi.rp.edu.sg/wiki/index.php/Academic_Dishonesty_and_Plagiarism
 *
 * Student ID : 127900
 *      Class : C306-5-W65H-C
 *       Name : Kon / Elizabeth Kwek Jin Li
 *
 * My grade will be penalised if I have violated the above guidelines.
 */