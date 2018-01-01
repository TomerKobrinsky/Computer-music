import javax.swing.*;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class main {
	public static void main(String[] args){
		session a= new session();
		String[] notes = new String[a.getKeyNotes().length + 1];
		for (int i = 0; i < a.getKeyNotes().length; i++) {
			notes[i] = a.getKeyNotes()[i];
		}
		notes[a.getKeyNotes().length] = notes[0];
		bar bar = new bar(4/4);
		for (int i = 0; i < notes.length; i++) {
			bar.setCurrentNote(notes[i], 0.125);
			//bar.setCurrentNote(notes[a.getKeyNotes().length], 0.5);
			//bar.setCurrentNote(notes[0], 0.125);
		}
		//bar.setCurrentNote("empty", 0.125);
		bar.setBarToPlay();
		Player play = new Player();
		Pattern firstPattern = new Pattern(bar.getBarToPlay());
		firstPattern.setTempo(session.songTempo);
		
		play.play(firstPattern.add(" |"));
		System.out.println(bar.getBarToPlay());
		
		
		/*JFrame frame = new JFrame();
		welcomeForm wf = new welcomeForm(a);
		frame.setContentPane(wf.getPanel());
		wf.setFrame(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500, 1000); // << not working!!!
		frame.setVisible(true);
		*/
		
	}
}
