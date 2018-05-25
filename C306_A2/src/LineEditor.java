import java.util.ArrayList;


public class LineEditor {
	Line liner = new Line();
	Cursor cursor = new Cursor();
	Actions act = new Actions();
	Actions rec = new Actions();
	
	// *** MOVEMENT START *** //
	// can't be in cursor cos referencing Line. :\
	private boolean moveL() {
		int[] index = cursor.getIndex();
		if (index[1] > 0) {
			cursor.setCol(cursor.getIndex()[1] - 1);
			return true;
		}
		return false;
	}
	
	private boolean moveR() {
		int[] index = cursor.getIndex();
		if (index[1] < liner.getLine().get(index[0]).length()-1) {
			cursor.setCol(cursor.getIndex()[1] + 1);
			return true;
		}
		return false;
	}
	
	private boolean moveU() {
		int[] index = cursor.getIndex();
		if (index[0] > 0) {
			cursor.setRow(cursor.getIndex()[0] - 1);
			return true;
		}
		return false;
		
	}
	
	private boolean moveD() {
		int[] index = cursor.getIndex();
		if (index[0] < liner.getLine().size()-1) {
			cursor.setRow(cursor.getIndex()[0] + 1);
			return true;
		}
		return false;
	}
	
	private boolean moveWA() {
		cursor = new Cursor(0,0);
		return true;
	}
	
	private boolean moveAA() {
		cursor.setCol(0);
		return true;
	}
	
	private boolean moveWW() {
		cursor.setRow(0);
		return true;
	}
	
	private boolean moveSD() {
		int rowN = liner.getLine().size()-1;
		cursor = new Cursor(rowN, liner.getLine().get(rowN).length()-1);
		return true;
	}
	
	private boolean moveDD() {
		int rowC = cursor.getIndex()[0];
		int colN = liner.getLine().get(rowC).length() - 1;
		cursor = new Cursor(rowC, colN);
		return true;
	}
	
	private boolean moveSS() {
		int rowN = liner.getLine().size()-1;
		cursor = new Cursor(rowN, cursor.getIndex()[1]);
		return true;
	}
	// *** MOVEMENT END *** //
	
	
	// *** MACRO *** //
	private void record() {
		// add to rec list.
		Helper.out("Recording commands. Enter 1 command per line.");
		
		String choice = Helper.readString("Command? ('H' for help, 'R' to end) > ");
		while (!choice.equalsIgnoreCase("R")) {
			String[] avail = {"w", "a", "s", "d", "z", "x",
								"wa", "aa", "ww", "sd", "dd", "ss"};
			boolean ok = false;
			for (String a : avail) {
				if (a.equalsIgnoreCase(choice)) {
					ok = true;
					break;
				}
			}

			if (ok) {
				int res = -1;
				if (choice.equalsIgnoreCase("x")) {
					res = Helper.readInt("How many characters to delete?");
				}
	
				rec.addAction(choice, res);
			} else {
				Helper.out("Invalid command not recorded.");
			}
			choice = Helper.readString("Command? ('H' for help, 'R' to end) > ");
		}
		Helper.welcome();
	}
	
	private boolean play() {
		if (rec.getList().isEmpty()) {
			Helper.out("No commands recorded.");
			Helper.welcome();
			return false;
		}
		Move play = rec.getList().get(0);
		String choice = play.getMove();
		int del = 0;
		if (play.getMove().equalsIgnoreCase("x")) {
			del = play.getNum();
		}
		makeChoice(choice, del);
		rec.getList().remove(play);
		return true;
		// return false if rec list empty.
	}
	// *** MACRO END *** //
	
	
	
	
	// *** INSERT AND DELETE *** //
	private void insert(String ins) {
		// max 80 char per line.
		int ok = liner.insertText(ins, cursor.getIndex());
		act.addAction("C", ok);
		
		if (ok == -2) {
			ok = 0;
		}
		cursor.setCol(cursor.getIndex()[1] + ok);	
	}
	
	private boolean delete(int num) {
		
		return false;
	}
	// *** INSERT AND DELETE END *** //
	
	
	// *** UNDO *** //
	public void undo() {
		if (act.getList().get() == 
	}
	// *** UNDO END *** //
	
	
	
	public void display() {
		ArrayList<String> stringy = copy();
		int[] index = cursor.getIndex();
		stringy.add(index[0]+1, cursor.getCursor());
		for (String s : stringy) {
			Helper.out(s);
		}
		act.displayTally();		
	}
	
	private ArrayList<String> copy() {
		ArrayList<String> stringy = new ArrayList<>();
		stringy.addAll(liner.getLine());
		return stringy;
	}
	
	public void start() {
		Helper.welcome();
		display();
		String choice = askChoice();
		while (!choice.equalsIgnoreCase("q")) {
			makeChoice(choice, 0);
			display();
			choice = askChoice();
		}
		Helper.out("Goodbye.");
	}
	private String askChoice() {
		Helper.line(70, "-");
		return Helper.readString("Command? ('H' for help) > ");
	}
	public void makeChoice(String choice, int del) {
		if (choice.equalsIgnoreCase("h")) {
			Helper.help();
		} else if (choice.equalsIgnoreCase("w")) {
			act.addAction(choice.toUpperCase(), ok(moveU()));
		} else if (choice.equalsIgnoreCase("a")) {
			act.addAction(choice.toUpperCase(), ok(moveL()));
		} else if (choice.equalsIgnoreCase("s")) {
			act.addAction(choice.toUpperCase(), ok(moveD()));
		} else if (choice.equalsIgnoreCase("d")) {
			act.addAction(choice.toUpperCase(), ok(moveR()));
		} else if (choice.equalsIgnoreCase("z")) {
			undo();
//		} else if (choice.equalsIgnoreCase("x")) {
//			while (del == 0) {
//				del = Helper.readInt("how many? > ");
//			}
//			act.addAction(choice.toUpperCase(), ok(delete(del)));
		} else if (choice.equalsIgnoreCase("c")) {
			String word = Helper.readString("Enter a word > ");
			insert(word);
//		} else if (choice.equalsIgnoreCase("f")) {
//			find();
		} else if (choice.equalsIgnoreCase("e")) {
			play();
		} else if (choice.equalsIgnoreCase("r")) {
			record();
		} else if (choice.equalsIgnoreCase("wa")) {
			act.addAction(choice.toUpperCase(), ok(moveWA()));
		} else if (choice.equalsIgnoreCase("ww")) {
			act.addAction(choice.toUpperCase(), ok(moveWW()));
		} else if (choice.equalsIgnoreCase("aa")) {
			act.addAction(choice.toUpperCase(), ok(moveAA()));
		} else if (choice.equalsIgnoreCase("ss")) {
			act.addAction(choice.toUpperCase(), ok(moveSS()));
		} else if (choice.equalsIgnoreCase("sd")) {
			act.addAction(choice.toUpperCase(), ok(moveSD()));
		} else if (choice.equalsIgnoreCase("dd")) {
			act.addAction(choice.toUpperCase(), ok(moveDD()));
		} else {
			Helper.welcome();
		}
	}	
	private int ok(boolean a) {
		if (a) {
			return -1;
		}
		return -2;
	}
	
	
	public static void main(String[] args) {
		LineEditor a = new LineEditor();
		a.start();
	}

}
