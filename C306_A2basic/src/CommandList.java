import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CommandList {
	private Stack<Command> commands = new Stack<Command>();
	private Queue<Command> recordings = new LinkedList<Command>();
	private HashMap<String, Integer> statistics = new HashMap<String, Integer>(); // HashMap only accepts [Integer] not [int]
	
	public void addCommand(String command, String extra, Pointer p) {
		// TODO: use <toUpperCase()> to change [command] so it's easier to iterate over.
		Command c = new Command(command, extra, p); // set [extra] as [null] if necessary.
		// TODO: <push> [c] to the correct list. FOR UNDO
		
		// TODO: increment the KEY [command] in [statistics] by 1.
	}
	
	public void addRecording(String command, String extra) {
		// TODO: use <toUpperCase()> to change [command] so it's easier to iterate over.
		// TODO: create a new [Command] like in <addCommand> and set fields to [null] if necessary.
		// TODO: <offer> the new Command to the correct list.
		
		// do not increment [statistics]! this will add later when you run the macro.
	}
	
	public boolean isEmpty() {
		// TODO: check if both [commands] & [recordings] are empty.
		return false;
	}
	
	// TODO: create the TWO methods to remove:
		// FIRST item in recordings
		// LAST item in commands
	
	public void display() {
		// TODO: iterate through [statistics] and print each KEY and VALUE.
		// 		 print however you like.
	}
}
