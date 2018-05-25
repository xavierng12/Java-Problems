import java.util.ArrayList;

public class Line {
	private ArrayList<String> list = new ArrayList<String>();
	
	public Line() {
		String first = "The quick brown fox jumped over the lazy dog.";
		// TODO: use a FOR LOOP to add [first] to [list] 3 times. (use <this.list.add>)
	}
	
	public String getRow(int rowNum) {
		return ""; // TODO: use <get> to return the line in [list] at row[rowNum].
	}
	
	public String insertWord(String word, Pointer p) {
		String thisRow = ""; // TODO: <get> list's String at the current row - get current row from [p]'s index.
		String start = ""; // TODO: use <substring(0, x)> to get the String from [thisRow]'s [0] to
						   //		the current position - get current pos from [p]'s index.
		String end = ""; // TODO: use <substring(x)> to get the String from [thisRow]'s current
						 // 	  position - get current pos from [p]'s index. <substring(x)> gets the String
						 // 	  from position[x] to the end.
		
		// TODO: use an if-else statement to check if the total length of the new String is
		// 		 more than 80. If true, cut [word] to the maximum length allowed - use <substring(0, x)>
		
		// TODO: use <set(index, item)> to set [item] - ([start] + [word] + [end]) - at position [index]
		// 		 in the [list]. This replaces the line at [index] with the new [item].
		
		return word; // this is for the UNDO function.
	}
	
	public String deleteWord(int charsToDelete, Pointer p) {
		String thisRow = ""; // TODO: <get> list's String at the current row - get current row from [p]'s index.
		// TODO: use an if-else statement to check if [charsToDelete] is more than the length of [thisRow],
		// 		 from the current position. if true, set [charsToDelete] to the length of [thisRow]
		//		 from current position.
		String start = ""; // TODO: use <substring(0, x)> to get the String from [thisRow]'s [0] to
		   				   // 		the current position - get current pos from [p]'s index.
		String deleted = ""; // TODO: use <substring(x, y)> to get the deleted text. This is for the UNDO function.
		String end = ""; // TODO: use <substring(x)> to get the String from [thisRow]'s current
						 // 	  position PLUS [charsToDelete] - get current pos from [p]'s index.
						 // 	  <substring(x)> gets the String from position[x] to the end.
		
		// TODO: use <set(index, item)> to set [item] - ([start] + [end]) - at position [index] in the [list].
		// this replaces the line at [index] with the new [item].
		
		return deleted; // this is for storing for UNDO.
	}
	
	public Pointer searchFront(String word, Pointer p) {
		String thisRow = ""; // TODO: <get> list's String at the current row - get current row from [p]'s index.
		int foundRow = 0; // TODO: set this to the current row number (from [p]'s index).
		int foundPosition = 0; // TODO: use <indexOf(x, y)> to search [thisRow] for String[y], starting
							   // 		from index[x]. if no results are found, the function returns [-1].
		// TODO: use an if-else to check if [foundPosition] == -1 - meaning no results found.
		// if TRUE:
			// TODO: use a FOR LOOP to check from the row AFTER the current row, together with
			// 		 <indexOf> to search.
			// TODO: check [foundPosition]. if != -1, set [foundRow] to the current row index in the 
			// 		 for loop, then BREAK.
		
		Pointer newP = null;
		// TODO: use an if-else to check if [foundPosition] != -1.
		// if TRUE:
			// TODO: use <changeRow> & <changePosition> to set [newP].
		
		return newP; // will return NULL if no results found.
	}
	
	public Pointer searchBack(String word, Pointer p) {
		String thisRow = ""; // TODO: <get> list's String at the current row - get current row from [p]'s index.
		int foundRow = 0; // TODO: set this to the current row number (from [p]'s index).
		int foundPosition = 0; // TODO: use <lastIndexOf(x, y)> to search [thisRow] for String[y], starting
							   // 		from index[x] and working backwards. if no results are found, the
							   // 		function returns [-1].
		
		// TODO: do the same as <searchFront> but your FOR LOOP should work backwards.
		
		Pointer newP = null;
		// TODO: use an if-else to check if [foundPosition] != -1.
		// if TRUE:
			// TODO: use <changeRow> & <changePosition> to set [newP].
		
		return newP; // will return NULL if no results found.
	}

}
