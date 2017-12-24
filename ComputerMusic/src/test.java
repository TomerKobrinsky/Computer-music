import java.io.File;
import java.io.IOException;

import javax.sound.midi.*;

import org.jfugue.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;
import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;

public class test {
	public enum Mood {
		Happy, Sad
	}

	public enum keyType {
		Major, Minor
	}

	static int tempo;
	static keyType songKey;

	public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException, IOException {
		tempo = 60 + (int) (120 * Math.random());
		System.out.println(tempo);
		Mood Input;

		/*
		 * sets key according to switch (Input) { case Happy: songKey =
		 * test.keyType.Major; break; case Sad: songKey = test.keyType.Minor;
		 * default: System.out.println("error"); break; } /* Pattern pattern =
		 * new Pattern("V0 Cmajw V1 I[Flute] G4q E4q C4q E4q" ); //player.play(
		 * "V0 E5s D#5s | E5s D#5s E5s B4s D5s C5s " + // "V1 Ri | Riii ");
		 * //player.play( "T[Allegro] I[ROCK_Organ] Db4minH C5majW C4maj^^");
		 * Synthesizer synth = MidiSystem.getSynthesizer(); Player player = new
		 * Player(); player.play(
		 * "T[Adagio] V2 I[Piano] C5q F#5q CmajQ V4 I[Flute] C3q+E3q E3q+G3q RiC2majI"
		 * );
		 */
		/*
		 * Rhythm rhythm = new Rhythm(); rhythm.addLayer("O..O....O..O.O..");
		 * rhythm.addLayer("..*...*...*...*.");
		 * rhythm.addLayer("^^^^^^^^^^^^^^^^");
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
		 * Pattern pattern = rhythm.getPattern().setTempo(80); Pattern pattern2
		 * = new Pattern(
		 * "I[ELECTRIC_BASS_PICK] Gq Eq Eh | Fq Dq Dh | Cq Dq Eq Fq | Gq Gq Gh | Gq Eq Eh | Fq Dq Dh"
		 * ); pattern2.setTempo(80); pattern.repeat(4); Player player = new
		 * Player(); //pattern.setLayer(0).add(pattern2);
		 * player.play(pattern.prepend(pattern2));
		 */
		Player player = new Player();
		player.play("T[Allegro] I[Distorted_GUITAR] Db4minH C5majW C4maj^^");

	}
}
