
public class bar {
	private double sumOfLengths;
	private double timeSignature;
	private int barSize;
	private selectedNote[] barNotes;
	int noteToSet;

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
		// sets new bar with empty notes
		for (int i = 0; i < barNotes.length; i++) {
			barNotes[i] = new selectedNote("empty", -1);
		}
	}

	public void changeNote(int noteToSet, String notePitch, double newLength) {
		if ((noteToSet < 0) || (noteToSet >= barNotes.length)) {
			System.out.println("Invalid noteToSet: " + noteToSet);
		} else if ((sumOfLengths - barNotes[noteToSet].getLength() + newLength) > 1) {
			System.out.println("length to large");
		} else {
			this.noteToSet = noteToSet;
			barNotes[noteToSet].turnToTrueNote(notePitch, newLength);
			for (int i = 0; i < barNotes.length; i++) {

			}
		}

	}

}
