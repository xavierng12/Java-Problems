public class LineEditorB {
	private LineB line;
	private int index;
	
	public void start() {
		// Create a new Line and assign it to <line>
		// Set <index> to 0
	}
	
	private void moveL() {
		// Use <index> to move your cursor 1 space to the left.
		// Remember to make sure it doesn't go beyond 0!
	}
	
	private void moveR() {
		// Use <index> to move your cursor 1 space to the right.
		// Remember to make sure it doesn't go beyond your <line>!
	}
	
	private void insert() {
		String input = "";
		// Get user input for what word they want to add and assign it to <input>.
		line.add(index, input); // adds <input> to <line> at <index>.
		// Remember to adjust your <index> accordingly!
	}
	
	private void remove() {
		int input = 0;
		// Get user input for how many characters to remove and add it to <input>.
		// if <input> is more that <line>, set it to remove ALL characters.
		line.delete(index, input); // removes <input> characters from <line> beginning from <index>.
		// Remember to adjust your <index> accordingly!
	}
	
	private void find(String choice) {
		char input = ' ';
		// Get user input for what character to search for and add it to <input>.
		// Run the correct [search] function from the [Line] class according to <choice>.
		// Set <index> as the result from line.search. 
	}
	
	private String choice() {
		// Create a new instance of [Cursor] according to your current <index>.
		// CursorB ? = new CursorB(?);
		// Print all the welcome message shit + <line> and your cursor from the previous line.
		String input = "";
		// Get user input for what command they want to run and add it to <input>.
		return input;
	}
	
	public void display() {
		String choice = choice();
		while (!choice.equalsIgnoreCase("Z")) {
			// Use a shitload of if-else to run the appropriate method for the command in <choice>.
			// note: no need for the "Z" choice! whatever happens on "Z" will be run out side the while loop.
			choice = choice();
		}
		// what you want "Z" command to do here pls
	}
}
