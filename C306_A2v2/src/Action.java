public class Action {
	private String actionCode;
	private String var; 
	private Cursor startPos;
	
	public Action(String choice, Cursor cursor) {
		this.actionCode = choice;
		this.startPos = cursor;
		this.var = null;
	}
	
	public Action(String choice, Cursor cursor, String var) {
		this.actionCode = choice;
		this.startPos = cursor;
		this.var = var;
	}
	
	public String getChoice() {
		return actionCode;
	}
	
	public String getVar() {
		return var;
	}
	
	public Cursor startPos() {
		return startPos;
	}
}

/*
 * I declare that I have read, accepted and followed the SOI guidelines on academic
 * dishonesty and plagiarism for my assignment.
 * http://yoda.soi.rp.edu.sg/wiki/index.php/Academic_Dishonesty_and_Plagiarism
 *
 * Student ID : 127900
 *      Class : C306-5-W65H-C
 *       Name : Kon / Elizabeth Kwek Jin Li
 *
 * My grade will be penalised if I have violated the above guidelines.
 */

