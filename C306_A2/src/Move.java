public class Move {
	private String move;
	private int num;
	
	public Move(String action, int num) {
		this.move = action;
		this.num = num;
	}

	public String getMove() {
		return move;
	}

	public void setMove(String action) {
		this.move = action;
	}

	public int getNum() {
		return num;
	}

	public void addNum() {
		this.num += 1;
	}
	
	
}
