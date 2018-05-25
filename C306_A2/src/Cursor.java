
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
	
	public void setRow(int r) {
		this.index[0] = r;
	}
	
	public void setCol(int c) {
		this.index[1] = c;
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
