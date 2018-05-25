import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;


public class MoveList {
	private Stack<Action> actList = new Stack<Action>();
	private Queue<Action> qList = new LinkedList<Action>();
	private HashMap<String, Integer> tallyList = new HashMap<String, Integer>();
	
	public void pushA(String choice, Cursor cursor, boolean stack) {
		choice = choice.toUpperCase();
		if (stack) {
			actList.push(new Action(choice, cursor));
		} else {
			qList.offer(new Action(choice, cursor));
		}
		pushT(choice);
	}
	
	public void pushA(String choice, Cursor cursor, boolean stack, String var) {
		choice = choice.toUpperCase();
		if (stack) {
			actList.push(new Action(choice, cursor, var));
		} else {
			qList.offer(new Action(choice, cursor, var));
		}
		pushT(choice);
	}
	
	private void pushT(String choice) {
		int c = 0;
		choice = choice.toUpperCase();
		if (tallyList.get(choice) != null) {
			c = tallyList.get(choice);
		}
		tallyList.put(choice, c+1);
	}
	
	public Action peekA() {
		return actList.peek();
	}
	
	public Action popA() {
		return actList.pop();
	}
	
	public Action popQ() {
		return qList.remove();
	}
	
	public boolean isEmptyA() {
		boolean both = false;
		if (actList.isEmpty() && qList.isEmpty()) {
			both = true;
		}
		return both;
	}
	
	public void displayTally() {
		int i = 0;
		String[] list = {"", "", "", "", ""};
		for (Entry<String, Integer> e : tallyList.entrySet()) {
			String out = "| " + e.getKey() + " | " + e.getValue() + " |";
			String pre = "";
			if (((i+1) / 5 != 0) && (i+1 != 5)) {
				pre = "\t";
			}
			
			list[i%5] += pre + out;
			i++;
		}
		
		if (!tallyList.isEmpty()) {
			Helper.out("------------ s t a t i s t i c s ------------");
		}
		
		for (String s : list) {
			if (!s.equals("")) {
				Helper.out(s);
			}
		}
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