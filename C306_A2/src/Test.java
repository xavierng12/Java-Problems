
public class Test {
	public static void main(String[] args) {
		Actions a = new Actions();
		a.addAction("h", 2);
		a.addAction("f", 1);
		a.addAction("d", 3);
		a.addAction("v", 5);
		a.addAction("d", 6);
//		a.displayAll();
//		Helper.out("\n");
		a.displayTally();
		
//		Line b = new Line();
//		b.showLine();
	}

}
