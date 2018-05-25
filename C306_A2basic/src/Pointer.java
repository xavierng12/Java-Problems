
public class Pointer {
	private int[] index = new int[2]; 	// index[0] = row/line number
										// index[1] = column/position in single line
										// both indices start from 0.
	public Pointer() {
		this.index[0] = 0;
		this.index[1] = 0;
		// or just set to wherever you want it as default. see comment above.
	}
	
	public void changeRow(int r) {
		// TODO: set ROW to [r]
	}
	
	public void changePosition(int p) {
		// TODO: set COLUMN to [p]
	}
	
	public int[] getIndex() {
		return index;
	}
	
	public String printPointer() {
		String p = "";
		// TODO: use a FOR LOOP to add SPACES according to COLUMN POSITION
		p += "_";
		return p;
	}
	
}
