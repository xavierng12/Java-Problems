public class Editor {
	Line line = new Line();
	Pointer p = new Pointer();
	CommandList recordList = new CommandList();
	CommandList commandList = new CommandList();
	
	// TODO: create your movement methods. the general idea is to set [p]'s ROW or POSITION
	//		 as required. 
	// DEMO CODE: (for moving 1 space to the right)
		//	int currentPos = p.getIndex()[1];
		//	int currentLineLength = line.getLine(p.getIndex()[0]);
		//	if (currentPos+1 < currentLineLength) {	// to check if the pointer will exceed current line's length
		// 		p.setPosition(currentPos+1);
		//	}
	// switch the variables and methods called around for different kinds of movement.
	
	
	
	private void insertWord(String word, Pointer currentP, boolean undo) {
		String insertedWord = line.insertWord(word, currentP);
		// TODO: set [p]'s POSITION to the [CURRENT POSITION + LENGTH OF INSERTED WORD].
		//		 refer to method above for how to get CURRENT POSITION if you need.
		
		// TODO: if [undo] == false, use <addCommand> to add to [commandList].
		//		 use [currentP] instead of [p]!!
		// if you don't do that, your <undo>'s last Command will always be <insertWord>
	}
	
	private void deleteWord(int charsToDelete, Pointer p, boolean undo) {
		String deletedWord = line.deleteWord(charsToDelete, p);
		// <deleteWord> deletes [charsToDelete] after the current position.
		// TODO: check if the current pointer [p]'s POSITION >= to current ROW's <length()>.
		//		 if true, set [p]'s POSITION to the end of the current ROW.
		
		// TODO: if [undo] == false, use <addCommand> to add to [commandList].
		//		 use [currentP] instead of [p]!!
	}
	
	
	
	private void recordMacro() {
		String choice = "";
		// TODO: use <Helper.readString(x)> to get user's [choice].
		String[] notAllowed = {}; // TODO: fill this list with all commands that aren't allowed.
		
		// TODO: use a WHILE LOOP to check if choice is not <equalsIgnoreCase(x)> where [x] is your
		//		 command for <recordMacro()>.
			// -the following indented code happens inside the while loop.-
			boolean allowed = true;
			// TODO: use a FOR LOOP to check if [choice] is in [notAllowed]. if it is,
			//		 set [allowed] to false and BREAK the FOR LOOP.
			
			// TODO: check if [allowed] == true. if yes, use <addRecording> to add to [recordList].
			
			// TODO use <Helper.readString(x)> to get user's [choice] again.
	}
	
	private void playMacro() {
		// TODO: use if-else to check if [recordList] is NOT empty
		Command c = null; // TODO: set [c] as first Command from [recordList].
						  // 	   use your CommandList method.
		String command = ""; // TODO: use appropriate getter on [c]
		runCommand(command);	
	}
	
	
	
	private void undo() {
		// TODO: use if-else to check if [commandList] is NOT empty
		Command c = null; // TODO: set [c] as last Command from [commandList].
						  //	   use your CommandList method.
		// TODO: use appropriate getters on [c] to get the following 3 variables.
		String command = "";
		String extra = "";
		Pointer oldP = null;
		
		String choice = ""; // TODO: remove this line
		// TODO:
		//		 if command is your <insertWord>'s choice letter:
		//			set [p]'s POSITION to [current POSITION - extra.length()]
		//			<deleteWord(x)> where x=extra.length(), with [p].
		//			NOTE: pointer position may be inaccurate. play around with it.
		//		 if command is your <deleteWord>'s choice letter:
		//			<insertWord(x)> where x=extra.length(), with [p].
		//			set [p]'s POSITION to [current POSITION - extra.length()]
		//		 else:
		//			set [p] to [oldP].
	}
	
	
	
	private void runCommand(String choice) {
		String extra = null; // this is to save data for adding into [comandList] if necessary.
		Pointer now = new Pointer(); // this is to save the current position BEFORE anything is done.
		boolean save = true; // this is a boolean to check if this choice should be saved into the
							 // [commandList].
							 // in the if-else later, this shouldn't be touched except for the commands
							 // calling <recordMacro> and <playMacro>, where it should be set to FALSE.
		
		// TODO: make all your commands in an if-else. get input with <Helper> methods where necessary
		//		 DEMO CODE:
		//			if (choice.equalsIgnoreCase("x") {
		//				int charsToDelete = Helper.readInt("Enter number of characters to delete: ");
		//				deleteWord(charsToDelete, p, false);
		//			} else if (....) {
		//				....
		//			}
		
		if (save) {
			// use <addCommand> to add: [choice], [now], [extra] to [commandList].
		}
	}
	
	private void display() {
		// TODO: COPY [line] to a new ArrayList<String>.
		// <add(x, y)> to the new ArrayList where [x] = [p]'s current ROW + 1
		// 									and [y] = <p.printPointer()>
		
		// TODO: print each String in the NEW ArrayList.
		// 		 preferably use an ENHANCED FOR LOOP.
		
		// TODO: use the correct CommandList's <display> to show statistics.
	}
	
	public void start() {
		// print your welcome text.
		display();
		String choice = ""; // TODO: use <Helper.readString()> to get the choice.
		
		while (!choice.equalsIgnoreCase("q")) {
			runCommand(choice);
			
			display();
			choice = ""; // TODO: use <Helper.readString()> to get the choice.
		}
	}
	
	public static void main(String[] args) {
		Editor e = new Editor();
		e.start();
	}
}
