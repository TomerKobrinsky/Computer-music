import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class notesDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox durationBox;
    private JButton[] buttons;
    private session a;
    private JLabel label1;
    private JLabel label2;


    public notesDialog(session a) {
        this.a = a;
        setLayout(null);

        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.setBounds(300,200,20,20);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        Container pane = getContentPane();
        pane.setLayout(null);
        createButtons(pane);

    }

    private void createButtons(Container pane) {
        String[] notes = this.a.getKeyNotes();
        buttons = new JButton[notes.length+1];
        int x = 0;
        for (int i = 0; i < notes.length; i++){
            buttons[i] = new JButton(notes[i]);
            buttons[i].setBounds(10 + x,30,40,40);
            pane.add(buttons[i]);
            x += 40;
        }
        buttons[buttons.length-1] = new JButton("Break");
        pane.add(buttons[buttons.length-1]);
        this.buttonOK.setBounds(230,140,70,30);
        this.buttonCancel.setBounds(0,140,70,30);
        String[] list = { "1", "1/2", "1/8", "1/16", "1/32" };
        this.durationBox = new JComboBox(list);
        this.durationBox.setBounds(100, 70,100,100);
        this.label1 = new JLabel("Choose Chord");
        this.label2 = new JLabel("Choose Duration");
        this.label1.setBounds(100,5,100,20);
        this.label2.setBounds(100,80,200,20);

        pane.add(this.label1);
        pane.add(this.label2);
        pane.add(this.buttonOK);
        pane.add(this.buttonCancel);
        pane.add(this.durationBox);


    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        session a = new session();
        notesDialog dialog = new notesDialog(a);
        dialog.setSize(300, 200); // << not working!!!
        dialog.setVisible(true);
        System.exit(0);
    }
}