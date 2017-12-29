import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class moodForm {
    private JFrame frame;
    private JPanel panel1;
    private JComboBox textComboBox;
    private JLabel header;
    private JButton nextButton;

    public moodForm(String name) {
        header.setText("Hello "+ name);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public Container getPanel() {
        return this.panel1;

    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}
