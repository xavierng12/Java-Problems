import java.util.ArrayList;

public class LineA {
	private String base = "The quick brown fox jumped over the lazy dog.";
	private ArrayList<String> aLine = new ArrayList<>();
	private CursorA cursor;
	private int row;
	
	public LineA() {
		for (int i=0;i<3;i++) {
			aLine.add(base);
		}
		this.cursor = new CursorA(0);
		this.row = 2;
		aLine.add(row, cursor.getCursor());
	}
	
	public LineA(int r) {
		for (int i=0;i<3;i++) {
			aLine.add(base);
		}
		this.cursor = new CursorA(0);
		this.row = r;
		aLine.add(row, cursor.getCursor());
	}
	
	public void displayLine() {
		for (String a : aLine) {
			System.out.println(a);
		}
	}
}
