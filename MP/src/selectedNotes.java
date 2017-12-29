
public class selectedNotes {
	// will hold the pitch of the note
	private String notePitch;
	// will hold the length of the note
	private double length;
	// will hold the valid note to play woth length
	private String noteToPlay;

	/**
	 * constructor
	 * 
	 * @param notePitch
	 *            - the pitch of the note
	 * @param length
	 *            - the length of the note
	 */
	public selectedNotes(String notePitch, double length) {
		setNotePitch(notePitch);
		setLength(length);
		setNoteToPlay();
	}

	/**
	 * setter for the length of the note
	 * 
	 * @param length
	 */
	public void setLength(double length) {
		if ((length < 1) && (length > 0)) {
			this.length = length;
		} else {
			System.out.println("constructed a note with invalid length");
		}
	}
	/**
	 * setter for noteToPlay
	 */
	public void setNoteToPlay() {
		parsingWithLength();
	}

	/**
	 * setter for the pitch of the note
	 * 
	 * @param pitch
	 */
	public void setNotePitch(String notePitch) {
		this.notePitch = notePitch;
	}

	/**
	 * getter for the length of the note
	 * 
	 * @param length
	 */
	public double getLength() {
		return length;
	}
	

	/**
	 * getter for the pitch of the note
	 * 
	 * @param pitch
	 */
	public String getNotePitch() {
		return notePitch;
	}
	public String getNoteToPlay() {
		return noteToPlay;
	}
/**
 * parsing to noteToPlay according to jfugue  
 * @return noteToPLAY - Valid jfugue note
 */
	private String parsingWithLength() {
		String noteWithLength = getNotePitch();
		double thislength = getLength();
		// length is 1
		if (thislength == 1) {
			this.noteToPlay = noteWithLength + "w";
		} else
		// length is 1/2
		if (thislength == 0.5) {
			this.noteToPlay = noteWithLength + "h";
		} else
			// length is 1/4
			if (thislength == 0.25) {
			this.noteToPlay = noteWithLength + "q";
		} else
			// length is 1/8
			if (thislength == 0.125) {
			this.noteToPlay = noteWithLength + "i";
		} else 
			// length is 1/16
			if (thislength == 0.0625) {
			this.noteToPlay = noteWithLength + "s";
		} else
			// length is 1/32
			if (thislength == 0.5) {
			this.noteToPlay = noteWithLength + "t";
		}
		return this.noteToPlay;
	}
}
