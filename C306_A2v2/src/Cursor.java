
public class Cursor {
	private int[] index = new int[2];
	
	public Cursor() {
		this.index[0] = 1;
		this.index[1] = 0;
	}
	
	public Cursor(int r, int c) {
		this.index[0] = r;
		this.index[1] = c;
	}
	
	public void setRow(int r, boolean add) {
		if (add) {
			this.index[0] += r;
		} else {
			this.index[0] = r;
		}
	}
	
	public void setCol(int c, boolean add) {
		if (add) {
			this.index[1] += c;
		} else {
			this.index[1] = c;
		}
	}

	public int[] getIndex() {
		return index;
	}
	
	public String getCursor() {
		String cursor = "";
		for (int c=0; c<index[1]; c++) {
			cursor += " ";
		}
		return cursor + "_";
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