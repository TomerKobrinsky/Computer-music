import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sessionFrame extends JFrame {

    private JPanel panel1;
    private JButton buttons[];
    private JLabel labels[];
    private bar frameBar;
    private session a;

    public sessionFrame(session a)
    {
        this.a = this.a;
        //frameBar = bar;
        int barSize = 32; //bar.getBarSize();


        panel1 = new JPanel() ;
        panel1.setLayout(null);

        panel1.setSize(750 , 500);
        this.setContentPane(panel1);
        this.setSize(750, 500);


        buttons = new JButton[barSize];
        labels = new JLabel[barSize];


        ActionListener t  = (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JButton b = (JButton)e.getSource();
                int buttonIndex = Integer.parseInt(b.getName());

                notesDialog dialog = new notesDialog(a);
                dialog.setSize(300, 200);
                dialog.setVisible(true);

                ((sessionFrame)b.getParent().getParent().getParent().getParent()).setLabel(buttonIndex, "");
            }
        });

        for(int i = 0; i < barSize; i++)
        {
            labels[i] = new JLabel();
            //labels[i].setText("" + i);
            buttons[i] = new JButton("");
            //buttons[i].setFont(new Font("Ariel", Font.PLAIN, 10));
            buttons[i].setName("" + i);
            //buttons[i].setLayout(null);
            //buttons[i].getParent().getParent();
            buttons[i].setBounds(10 + i*20, 200, 20 ,60);
            labels[i].setBounds(12 + i*20, 180, 20 ,20);
            buttons[i].addActionListener(t);

            panel1.add(labels[i]);
            panel1.add(buttons[i]);
        }
    }

    public void setLabel(int index , String text)
    {
        labels[index].setText(text);
    }

}
