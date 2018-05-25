public class Command {
	private String command; // this stores the command, like "x", "i" etc.
	private String extra; // this stores extras like deleted words for the UNDO function to restore.
	private Pointer position; // this stores the position at the start, for the UNDO function.
	
	public Command (String command, String extra, Pointer position) {
		// TODO: set all the fields
	}
	
	// TODO: generate Getters for all the fields
}
