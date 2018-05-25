@SuppressWarnings("resource")
public class Helper {
	public static void out(String a) {
		System.out.println(a);
	}
	
	public static String readString(String prompt) {
		System.out.print(prompt);
		return new java.util.Scanner(System.in).nextLine();
	}
	
	public static int readInt(String prompt) {
		int input = 0;
		boolean valid = false;
		while (!valid) {
			try {
				input = Integer.parseInt(readString(prompt));
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("*** Please enter an integer ***");
			}
		}
		return input;
	}
	
	public static boolean readBoolean(String prompt) {
		boolean valid = false;
		while (!valid) {
			String input = readString(prompt);
			if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")
					|| input.equalsIgnoreCase("true")
					|| input.equalsIgnoreCase("t") 
					|| input.equalsIgnoreCase("ok")){
				return true;
			} else if (input.equalsIgnoreCase("no")
					|| input.equalsIgnoreCase("n")
					|| input.equalsIgnoreCase("false")
					|| input.equalsIgnoreCase("f")) {
				return false;
			} else {
				System.out.println("*** Please enter Yes/No or True/False ***");
			}
		}
		return false;
	}
	
	public static void line(int num, String c) {
		String a = "";
		for (int i=0; i<num; i++) {
			a += c;
		}
		out(a);
	}
	

	
	
	public static void help(boolean rec) {
		out("[W] Move up");
		out("[A] Move left");
		out("[S] Move down");
		out("[D] Move right");
		out("[Z] Undo last action");
		out("[X] Delete characters");
		if (!rec) {
			out("[C] Insert word");
			out("[F] Find word");
			out("[E] Play recorded actions");
			out("[R] Record actions");
			out("[Q] Quit");
		}
		out("[H] Help");
		out("[WA] Jump to first character of first line");
		out("[AA] Jump to first character of current line");
		out("[WW] Jump to current character of first line");
		out("[SD] Jump to last character of last line");
		out("[DD] Jump to last character of current line");
		out("[SS] Jump to current character of last line");
	}
	
	public static void welcome() {
		Helper.line(70, "=");
		Helper.out("\t\t\tL I N E  E D I T O R");
		Helper.line(70, "=");
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