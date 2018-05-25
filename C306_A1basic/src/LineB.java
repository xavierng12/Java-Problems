public class LineB {
	private String line;

	public LineB() {
		this.line = " "; // TODO: Set the default text here
	}

	public String getLine() {
		return line;
	}

	public void add(int index, String input) {
		String nString = "";
		// Use a for loop to collect all the characters from <line> before <index> and set them into the new string, <nString>.
		// Add <input> to the end of your new <nString>.
		// Use a for loop to collect all the characters from <line> after <index> and set them into the concatenated <nString>.
		this.line = nString;
	}

	public void delete(int index, int length) {
		String nString = "";
		// Use a for loop to collect all the characters from <line> before <index> and set them into the new string, <nString>.
		int remainder = index + length;
		// Use a for loop to collect all the characters from <line> after <remainder> and set them into the concatenated <nString>.
		this.line = nString;
	}

	
	
	// FOR THE SEARCH FUNCTIONS
		// Use a for loop through each character in <line> with [line.getCharAt(i)].
		// If the character at the current point matches <input>, assign the current
		// point to <number> and break the loop.
		// Return <number>.
	// HINT: one for loop goes backward instead of forward!
	public int searchFront(char input, int index) {
		int number = 0;
		// Loop between given <index> and LENGTH of <line>.
		return number;
	}
	public int searchBack(char input, int index) {
		int number = 0;
		// Loop between given <index> and -1.
		return number;
	}

}
