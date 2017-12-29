import javax.swing.*;

public class main {
	public static void main(String[] args){
		session a= new session();

		JFrame frame = new JFrame();
		welcomeForm wf = new welcomeForm(a);
		frame.setContentPane(wf.getPanel());
		wf.setFrame(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500, 1000); // << not working!!!
		frame.setVisible(true);
		
	}
}
