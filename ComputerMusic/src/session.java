import java.io.File;
import java.io.IOException;

import javax.sound.midi.*;

import org.jfugue.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;
import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;

public class session {
	public enum Mood {
		Happy, Sad
	}

	public enum keyType {
		Major, Minor
	}

	public enum note {
		C, C_SHARP, D, D_SHARP, E, F, F_SHARP, G, G_SHARP, A, A_SHARP, B
	}

	private String keyNotes[] = new String[7];

	static int songTempo;
	static keyType songKeyType;
	static String songKey;
	static int songKeyNum;

	/**
	 * sets the tempo of the song
	 */
	private void setTempo() {
		songTempo = 60 + (int) (120 * Math.random());
	}

	
	private String intToStringNote(int input) {
		switch (input) {
		case 0:
			return "C";
		case 1:
			return "C#";

		case 2:
			return "D";

		case 3:
			return "D#";

		case 4:
			return "E";

		case 5:
			return "F";

		case 6:
			return "F#";

		case 7:
			return "G";

		case 8:
			return "G#";

		case 9:
			return "A";

		case 10:
			return "A#";

		case 11:
			return "B";

		default:
			System.err.println("error with note");
			return null;
		}
	}

	/**
	 * sets the key of the song
	 */
	private void setKeyRoot() {
		songKeyNum = (int) (12 * Math.random());
		songKey = intToStringNote(songKeyNum);
	}

	/**
	 * sets keyType according to The Mood Input
	 * 
	 * @param Input
	 */
	private void setKeyType(Mood Input) {
		switch (Input) {
		case Happy:
			songKeyType = session.keyType.Major;
			break;
		case Sad:
			songKeyType = session.keyType.Minor;
			break;
		default:
			System.err.println("error with keyType");
			break;
		}
	}

	/**
	 * sets the key of the song and the relevant notes to use
	 * 
	 * @param Input
	 *            - the mood the user is interested in
	 */
	private void setKey(Mood Input) {
		setKeyRoot();
		setKeyType(Input);

		switch (songKeyType) {
		case Major:
			for (int i = 0, currentNote = songKeyNum; i < keyNotes.length; i++) {
				keyNotes[i] = intToStringNote(currentNote);
				currentNote += 2;
				if (i == 2) {
					currentNote--;
				}
				if (currentNote > 11) {
					currentNote -= 12;
				}
			}
			break;
		case Minor:
			for (int i = 0, currentNote = songKeyNum; i < keyNotes.length; i++) {
				keyNotes[i] = intToStringNote(currentNote);
				currentNote += 2;
				if ((i == 1) || (i == 4)) {
					currentNote--;
				}
				if (currentNote > 11) {
					currentNote -= 12;
				}
			}		
			break;

		}

	}

	/**
	 * initialize the current session
	 */
	public session() {
		Mood Input = Mood.Sad;
		setKey(Input);
		setTempo();

		System.out.println("the tempo is: " + songTempo);
		System.out.println("the key is: " + songKey + songKeyType);
		Player play = new Player();
		for (int i = 0; i < keyNotes.length; i++) {
			play.play(keyNotes[i] + "q ");
			System.out.println(keyNotes[i] + " ");
		}
	}

	/*
	 * public static void main(String[] args) throws MidiUnavailableException,
	 * InvalidMidiDataException, IOException {
	 * 
	 * 
	 * 
	 * /* Pattern pattern = new Pattern("V0 Cmajw V1 I[Flute] G4q E4q C4q E4q"
	 * ); //player.play( "V0 E5s D#5s | E5s D#5s E5s B4s D5s C5s " + //
	 * "V1 Ri | Riii "); //player.play(
	 * "T[Allegro] I[ROCK_Organ] Db4minH C5majW C4maj^^"); Synthesizer synth =
	 * MidiSystem.getSynthesizer(); Player player = new Player(); player.play(
	 * "T[Adagio] V2 I[Piano] C5q F#5q CmajQ V4 I[Flute] C3q+E3q E3q+G3q RiC2majI"
	 * );
	 */
	/*
	 * Rhythm rhythm = new Rhythm(); rhythm.addLayer("O..O....O..O.O..");
	 * rhythm.addLayer("..*...*...*...*."); rhythm.addLayer("^^^^^^^^^^^^^^^^");
	 * rhythm.DEFAULT_RHYTHM_KIT.replace('O', "[BASS_DRUM]i");
	 * rhythm.DEFAULT_RHYTHM_KIT.replace('^', "[PEDAL_HI_HAT]s Rs");
	 * rhythm.DEFAULT_RHYTHM_KIT.replace('*', "[ACOUSTIC_SNARE]i");
	 * rhythm.DEFAULT_RHYTHM_KIT.replace('o', "[CRASH_CYMBAL_1]s Rs");
	 * rhythm.DEFAULT_RHYTHM_KIT.replace('.', "Ri");
	 * rhythm.addLayer("...............o"); // Soundbank soundbank =
	 * MidiSystem.getSoundbank(new // File("soundbank-deluxe.gm")); //
	 * Synthesizer synth = MidiSystem.getSynthesizer(); //
	 * synth.loadAllInstruments(soundbank);
	 * 
	 * Pattern pattern = rhythm.getPattern().setTempo(80); Pattern pattern2 =
	 * new Pattern(
	 * "I[ELECTRIC_BASS_PICK] Gq Eq Eh | Fq Dq Dh | Cq Dq Eq Fq | Gq Gq Gh | Gq Eq Eh | Fq Dq Dh"
	 * ); pattern2.setTempo(80); pattern.repeat(4);
	 */ // pattern.setLayer(0).add(pattern2);

	// }
	/*
	 * private note intToNote(int input) { switch (input) { case 0: return
	 * test.note.C;
	 * 
	 * case 1: return test.note.C_SHARP;
	 * 
	 * case 2: return test.note.D;
	 * 
	 * case 3: return test.note.D_SHARP;
	 * 
	 * case 4: return test.note.E;
	 * 
	 * case 5: return test.note.F;
	 * 
	 * case 6: return test.note.F_SHARP;
	 * 
	 * case 7: return test.note.G;
	 * 
	 * case 8: return test.note.G_SHARP;
	 * 
	 * case 9: return test.note.A;
	 * 
	 * case 10: return test.note.A_SHARP;
	 * 
	 * case 11: return test.note.B;
	 * 
	 * default: System.err.println("error with note"); return null; } }
	 */
}
