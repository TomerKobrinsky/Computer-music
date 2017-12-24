import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sun Dec 24 15:30:50 IST 2017
 */



/**
 * @author roei rabany
 */
public class gameForm extends JFrame {
	public gameForm() {
		initComponents();
	}

	private void createUIComponents() {
		// TODO: add custom component creation code here
	}

	private void button1ActionPerformed(ActionEvent e) {
		
		System.out.println(comboBox1.getSelectedItem());
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - roei rabany
		label1 = new JLabel();
		comboBox1 = new JComboBox<>();
		button1 = new JButton();

		//======== this ========
		Container contentPane = getContentPane();

		//---- label1 ----
		label1.setText("Choose your mood");

		//---- comboBox1 ----
		comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
			"Sad",
			"Happy"
		}));

		//---- button1 ----
		button1.setText("text");
		button1.addActionListener(e -> button1ActionPerformed(e));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(224, 224, 224)
					.addComponent(label1)
					.addContainerGap(239, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(152, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
							.addComponent(button1)
							.addGap(214, 214, 214))
						.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
							.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
							.addGap(115, 115, 115))))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(47, 47, 47)
					.addComponent(label1)
					.addGap(31, 31, 31)
					.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
					.addComponent(button1)
					.addGap(72, 72, 72))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - roei rabany
	private JLabel label1;
	private JComboBox<String> comboBox1;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
