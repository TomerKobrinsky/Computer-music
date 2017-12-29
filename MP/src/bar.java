
public class bar {
	private double sumOfLengths;
	private double timeSignature;
	private int barSize;
	private selectedNote[] barNotes;
	int noteToSet;
	private String barToPlay;

	/**
	 * constructor for bar
	 * 
	 * @param timeSignature-
	 *            the time signature of the bar
	 */
	public bar(double timeSignature) {
		sumOfLengths = 0;
		noteToSet = 0;
		this.timeSignature = timeSignature;
		barSize = (int) (timeSignature * 32);
		barNotes = new selectedNote[barSize];
		barToPlay = "";
		// sets new bar with empty notes
		for (int i = 0; i < barNotes.length; i++) {
			barNotes[i] = new selectedNote("empty", -1);
		}
	}

	public void setCurrentNote(String newNotePitch, double newLength) {
		if (sumOfLengths < 1) {
			changeNote(noteToSet, newNotePitch, newLength);
		}
	}

	/**
	 * change a specific note
	 * 
	 * @param noteToSetIndex
	 *            - the index of the note to set
	 * @param newNotePitch
	 *            - the pitch of the note
	 * @param newLength
	 *            - the length of the note
	 */
	public void changeNote(int noteToSetIndex, String newNotePitch, double newLength) {
		if ((noteToSetIndex < 0) || (noteToSetIndex >= barNotes.length)) {
			System.out.println("Invalid noteToSet: " + noteToSetIndex);
		} else if ((sumOfLengths - barNotes[noteToSetIndex].getLength() + newLength) > 1) {
			System.out.println("length to large");
		} else if (newLength < 0) {
			System.out.println("length is negative");
		} else {
			sumOfLengths += newLength - barNotes[noteToSetIndex].getLength();
			this.noteToSet = noteToSetIndex;
			barNotes[noteToSetIndex].turnToTrueNote(newNotePitch, newLength);
			int notesToChange = (int) (32 * newLength);
			for (int i = 1; i < notesToChange; i++) {
				barNotes[noteToSetIndex + i].turnToFakeNote();
			}
		}
	}

	/**
	 * sets a The Bar to play
	 */
	private void setBarToPlay() {
		barToPlay = "";
		for (int i = 0; i < barNotes.length;) {
			barToPlay += barNotes[i].getNoteToPlay() + " ";
			i += (barNotes[i].getLength() * 32);
		}

	}

	/**
	 * 
	 * @return - the string to play
	 */
	public String getBarToPlay() {
		return barToPlay;
	}

}
