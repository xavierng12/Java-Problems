import java.util.ArrayList;

public class Line {
	private ArrayList<String> stringy = new ArrayList<>();
	
	public Line() {
		String def = "The quick brown fox jumped over the lazy dog.";
		for (int i=0; i<3; i++) {
			this.stringy.add(def);
		}
	}
	
	public ArrayList<String> getLine() {
		return stringy;
	}
	
	public void showLine() {
		for (String a : stringy) {
			Helper.out(a);
		}
	}
	
	
	
	public int insertText(String word, int[] pos) {
		int r = pos[0];
		int c = pos[1];
		String cur = stringy.get(pos[0]);
		boolean ok = true;
		if (cur.length() + word.length() > 80) {
			int space = (cur.length() + word.length()) - 80;
			word = word.substring(0, space);
			ok = Helper.readBoolean("Text entered is too long and will be reduced to [" + word + "]. Proceed? > ");
		}
		
		if (ok) {
			String bfr = cur.substring(0, c);
			String aft = cur.substring(c);
			String n = bfr + word + aft;
			stringy.set(pos[0], n);
			return word.length();
		}
		return -2;
	}
	
}
