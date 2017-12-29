import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sun Dec 24 15:14:14 IST 2017
 */



/**
 * @author roei rabany
 */
public class myForm extends JFrame {
	public myForm() {
		initComponents();
	}

	private void nextButtonActionPerformed(ActionEvent e) {	
		if(textField1.getText().compareTo("") != 0)
		{
			gameForm gm = new gameForm();
			gm.setVisible(true);		
			this.setVisible(false);
		}
	}
		
	


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - roei rabany
		textField1 = new JTextField();
		nextButton = new JButton();
		label1 = new JLabel();
		label2 = new JLabel();

		//======== this ========
		Container contentPane = getContentPane();

		//---- nextButton ----
		nextButton.setText("next");
		nextButton.addActionListener(e -> {
			nextButtonActionPerformed(e);
		});

		//---- label1 ----
		label1.setText("Wellcome to our app");
		label1.setFont(label1.getFont().deriveFont(Font.BOLD|Font.ITALIC, label1.getFont().getSize() + 20f));

		//---- label2 ----
		label2.setText("Enter your name:");
		label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() & ~Font.BOLD));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(504, Short.MAX_VALUE)
					.addComponent(nextButton)
					.addGap(31, 31, 31))
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(236, 236, 236)
							.addComponent(label2))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(150, 150, 150)
							.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(100, 100, 100)
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label1)
					.addGap(35, 35, 35)
					.addComponent(label2)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
					.addComponent(nextButton)
					.addGap(30, 30, 30))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - roei rabany
	private JTextField textField1;
	private JButton nextButton;
	private JLabel label1;
	private JLabel label2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
