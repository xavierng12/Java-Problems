import java.util.ArrayList;

public class Line {
	private ArrayList<String> stringy = new ArrayList<>();

	public Line() {
		String def = "The quick brown fox jumped over the lazy dog.";
		for (int i = 0; i < 3; i++) {
			this.stringy.add(def);
		}
	}
	
	public Line(ArrayList<String> copy) {
		for (String a : copy) {
			this.stringy.add(a);
		}
	}

	public ArrayList<String> getLine() {
		return stringy;
	}

	public String getLine(int rowNum) {
		return stringy.get(rowNum);
	}

	public void insertStr(String word, Cursor cursor) {
		int r = cursor.getIndex()[0];
		int c = cursor.getIndex()[1];
		String cur = stringy.get(r);
		String bfr = cur.substring(0, c);
		String aft = cur.substring(c);
		String n = bfr + word + aft;
		stringy.set(r, n);
	}
	
	public String deleteInt(int num, Cursor cursor) {
		int r = cursor.getIndex()[0];
		int c = cursor.getIndex()[1];
		String cur = stringy.get(r);
		String bfr = cur.substring(0, c);
		String del = cur.substring(c, num+c);
		String aft = cur.substring(num + c);
		stringy.set(r, bfr+aft);
		return del;
	}
	
	public Cursor search(int dir, String text, Cursor start) {
		int[] index = start.getIndex();
		int retC = -1;
		int retR = index[0];
		if (dir == 1) {
			String curLine = stringy.get(index[0]);
			retC = curLine.indexOf(text, index[1]+1);
			if (retC == -1 && index[0] != stringy.size()-1) {
				for (int r=index[0]+1; r<stringy.size(); r++) {
					curLine = stringy.get(r);
					retC = curLine.indexOf(text);
					if (retC != -1) {
						retR = r;
						break;
					}
				}
			}
		} else {
			String curLine = stringy.get(index[0]);
			retC = curLine.lastIndexOf(text, index[1]-1);
			if (retC == -1 && index[0] != 0) {
				for (int r=index[0]-1; r>-1; r--) {
					curLine = stringy.get(r);
					retC = curLine.lastIndexOf(text);
					if (retC != -1) {
						retR = r;
						break;
					}
				}
			}
		}
		

		Cursor mid = null;
		if (retC != -1) {
			mid = new Cursor(retR, retC);
		}
		return mid;
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