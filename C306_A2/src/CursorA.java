public class CursorA {
	private String cursor = "";
	
	public CursorA(int col) {
		for (int i=0; i<col; i++) {
			this.cursor += " ";
		}
		this.cursor += "_";
	}
	
	public String getCursor() {
		return cursor;
	}
}
