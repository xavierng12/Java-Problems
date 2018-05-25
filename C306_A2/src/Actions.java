import java.util.ArrayList;

public class Actions {
	private ArrayList<Move> actList = new ArrayList<>();

	public ArrayList<Move> getList() {
		return actList;
	}

	public void addAction(String action, int num) {
		Move me = new Move(action, num);
		actList.add(me);
	}
	
	public void addAction(Move action) {
		actList.add(action);
	}
	
	public ArrayList<Move> tally() {
		ArrayList<Move> totals = new ArrayList<>();
		for (Move m : actList) {
			int index = -1;
			for (int i=0; i<totals.size(); i++) {
				if (m.getMove().equals(totals.get(i).getMove())) {
					index = i;
					break;
				}
			}
			if (index > -1) {
				Move cur = totals.get(index);
				cur.addNum();
				totals.set(index, cur);
			} else {
				Move cur = m;
				Move toSet = new Move(m.getMove(), 1);
				totals.add(toSet);
			}
		}
		return totals;
	}
	
	public void displayAll() {
		for (Move m : actList) {
			Helper.out(m.getMove() + " => " + m.getNum());
		}
	}
	
	public void displayTally() {
		if (!tally().isEmpty()) {
			Helper.out("------------ s t a t i s t i c s ------------");
		}
		String[] list = {"", "", "", "", ""};
		for (int i=0; i< tally().size(); i++) {
			Move m = tally().get(i);
			String out = "| " + m.getMove() + " | " + m.getNum() + " |";
			
			String pre = "";
			if ((i+1) / 5 > 0 && (i + 1 != 5)) {
				pre = "\t";
			}
			
			list[i%5] += pre + out;
		}
		
		for (String s : list) {
			if (!s.equals("")) {
				Helper.out(s);
			}
		}
	}
}
