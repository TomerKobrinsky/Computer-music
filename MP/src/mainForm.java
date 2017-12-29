import javax.swing.*;

public class mainForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        welcomeForm wf = new welcomeForm();
        frame.setContentPane(wf.getPanel());
        wf.setFrame(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 1000); // << not working!!!
        frame.setVisible(true);

    }
}
