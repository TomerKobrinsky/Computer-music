import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class sessionFrame extends JFrame {

    private JPanel panel1;
    private JButton buttons[];
    private JLabel labels[];
    private bar frameBar;
    private session frameSsession;

    public sessionFrame(session session , bar bar )
    {
        this.frameSsession = session;
        frameBar = bar;
        int barSize = bar.getBarSize();


        panel1 = new JPanel();
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

                if(!bar.getNoteOnIndex(buttonIndex).getIsFakeNote())
                {
                    notesDialog dialog = new notesDialog(frameSsession);
                    dialog.setSize(300, 260);
                    dialog.setVisible(true);

                    sessionFrame f = ((sessionFrame) b.getParent().getParent().getParent().getParent());


                    if (dialog.getChord() != null)
                    {

                        while (dialog.getDuration() != 0 && (dialog.getDuration() * 32 + buttonIndex - 1 >= barSize || !f.isValidDur(buttonIndex, (int) (dialog.getDuration() * 32))))
                        {
                            notesDialog.infoBox("!!!", "!!!");
                            dialog.setVisible(true);
                        }


                        if(dialog.getChord().compareTo("empty") != 0 )
                        {
                            f.setLabel(buttonIndex, dialog.getChord());

                            Random r = new Random();
                            Color randomColor = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());

                            b.setBackground(randomColor);

                            frameBar.changeNote(buttonIndex , dialog.getChord() , dialog.getDuration());

                            for (int i = 1; i < dialog.getDuration() * 32; i++)
                            {

                                buttons[buttonIndex + i].setBackground(randomColor);
                                //           f.setLButtonsEnabled(buttonIndex + i, false);
                                frameBar.ternToFakeNoteInIndex(buttonIndex + i);
                            }
                        }
                        else
                        {
                            f.setLabel(buttonIndex, "");
                            b.setBackground(null);

                            int i = 1;
                            while(i + buttonIndex  < barSize && buttons[i + buttonIndex].getBackground() != null)
                            {
                                buttons[buttonIndex + i].setBackground(null);
                                //           f.setLButtonsEnabled(buttonIndex + i, false);
                              //  frameBar.ternToFakeNoteInIndex(buttonIndex + i);
                                frameBar.ternToEmptyNoteInIndex(buttonIndex + i );
                                i++;
                            }





                        }
                    }

                }
            }
        });

        int counter = 0;
        int sum = 10;

        for(int i = 0; i < barSize; i++)
        {
            if(counter == 4)
            {
                sum += 7;
                counter = 0;
            }
            labels[i] = new JLabel();
            //labels[i].setText("" + i);
            buttons[i] = new JButton("");
            //buttons[i].setFont(new Font("Ariel", Font.PLAIN, 10));
            buttons[i].setName("" + i);
            //buttons[i].setLayout(null);
            //buttons[i].getParent().getParent();
            buttons[i].setBounds(sum + i*20, 200, 20 ,60);
            labels[i].setBounds(sum + 2 + i*20, 180, 20 ,20);
            buttons[i].addActionListener(t);

            panel1.add(labels[i]);
            panel1.add(buttons[i]);

            counter++;
        }
    }

    public void setLabel(int index , String text)
    {
        labels[index].setText(text);
    }

    public void setLButtonsEnabled(int index , boolean enabled) {
        buttons[index].setEnabled(enabled);
    }


    public boolean isValidDur(int index , int len)
    {
        boolean isFree = true;

        for(int i = 1 ; i < len ; i++)
        {
            if(!frameBar.isNoteFree(index + i)) {
                isFree = false;
                break;
            }
        }


        return isFree;
    }

}
