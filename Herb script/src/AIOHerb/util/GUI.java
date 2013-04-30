package AIOHerb.util;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class GUI extends JFrame {
	
	/*public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    GUI frame = new GUI();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    } */
	
	public GUI() {
		initComponents();
	}
	
	private void button1ActionPerformed(ActionEvent e) {
		if(unfRAD.isSelected()) {
			Variables.whatToDo = 2;
			Variables.chosen = unfBox.getSelectedItem().toString();
			
			switch(Variables.chosen) {
			case "Ranarr Unf":
				Variables.unfPot = UnfPotion.RANARR;
				break;
			case "Toadflax Unf":
				Variables.unfPot = UnfPotion.TOADFLAX;
				break;
			case "Spiritweed Unf":
				Variables.unfPot = UnfPotion.SPIRITWEED;
				break;
			case "Cadantine Unf":
				Variables.unfPot = UnfPotion.CADANTINE;
				break;
			default: //default is ranarr
				Variables.unfPot = UnfPotion.RANARR;
			}
		}
		else if(potionRAD.isSelected()) {
			Variables.whatToDo = 1;
			Variables.chosen = comboBox1.getSelectedItem().toString();
			
			switch(Variables.chosen) {
			case "Attack Potion":
				Variables.pot = Potion.ATTACKPOTION;
				break;
			case "Ranging Potion":
				Variables.pot = Potion.RANGINGPOTION;
				break;
			case "Strength Potion" :
				Variables.pot = Potion.STREGNTHPOTION;
				break;
			case "Magic Potion":
				Variables.pot = Potion.MAGICPOTION;
				break;
			case "Defence Potion":
				Variables.pot = Potion.DEFENCEPOTION;
				break;
			case "Anti-poison Potion":
				Variables.pot = Potion.ANTIPOISONPOTION;
				break;
			case "Prayer Potion":
				Variables.pot = Potion.PRAYERPOTION;
				break;
			case "Super Attack Potion":
				Variables.pot = Potion.SUPERATTACKPOTION;
				break;
			case "Super Strength Potion":
				Variables.pot = Potion.SUPERSTRENGTHPOTION;
				break;
			case "Super Restore Potion":
				Variables.pot = Potion.SUPERRESTOREPOTION;
				break;
			case "Super Defence Potion":
				Variables.pot = Potion.SUPERDEFENCEPOTION;
				break;
			case "Super Ranging Potion":
				Variables.pot = Potion.SUPERRANGINGPOTION;
				break;
			case "Super Magic Potion":
				Variables.pot = Potion.SUPERMAGICPOTION;
				break;
			case "Zamorak Brew Potion":
				Variables.pot = Potion.ZAMORAKBREWPOTION;
				break;
			case "Saradomin Brew Potion":
				Variables.pot = Potion.SARADOMINBREWPOTION;
				break;
			}
		}
		
		else if(grimyRAD.isSelected()){
			Variables.whatToDo = 3;
			Variables.chosen = comboBox2.getSelectedItem().toString();
			
			switch (Variables.chosen) {
			
			case "Guam":
				Variables.grimy = Grimy.GUAM;
				break;
			case "Marrentill":
				Variables.grimy = Grimy.MARRENTILL;
				break;
			case "Tarromin":
				Variables.grimy = Grimy.TARROMIN;
				break;
			case "Harralander":
				Variables.grimy = Grimy.HARRALANDER;
				break;
			case "Ranarr":
				Variables.grimy = Grimy.RANARR;
				break;
			case "Toadflax":
				Variables.grimy = Grimy.TOADFLAX;
				break;
			case "Spiritweed":
				Variables.grimy = Grimy.SPIRITWEED;
				break;
			case "Irit":
				Variables.grimy = Grimy.IRIT;
				break;	
			case "Avantoe":
				Variables.grimy = Grimy.AVANTOE;
				break;
			case "Kwuarm":
				Variables.grimy = Grimy.KWUARM;
				break;
			case "Snapdragon":
				Variables.grimy = Grimy.SNAPDRAGON;
				break;
			case "Cadantine":
				Variables.grimy = Grimy.CADANTINE;
				break;
			case "Lantadyme":
				Variables.grimy = Grimy.LANTADYME;
				break;
			case "Dwarfweed":
				Variables.grimy = Grimy.DWARFWEED;
				break;
			case "Torstol":
				Variables.grimy = Grimy.TORSTOL;
				break;
			case "Fellstalk":
				Variables.grimy = Grimy.FELLSTALK;
				break;
			}			
		}	
			

		
		Variables.guiWait = false;
		dispose();

	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Caleb 
		comboBox1 = new JComboBox<>();
		textField2 = new JTextField();
		button1 = new JButton();
		unfRAD = new JRadioButton();
		unfBox = new JComboBox<>();
		potionRAD = new JRadioButton();
		grimyRAD = new JRadioButton();
		comboBox2 = new JComboBox<>();

		//======== this ========
		Container contentPane = getContentPane();

		//---- comboBox1 ----
		comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
			"Attack Potion",
			"Ranging Potion",
			"Magic Potion",
			"Strength Potion",
			"Defence Potion",
			"Anti-poison Potion",
			"Prayer Potion",
			"Super Atttack Potion",
			"Super Strength Potion",
			"Super Restore Potion",
			"Super Defence Potion",
			"Super Ranging Potion",
			"Super Magic Potion",
			"Zamorak Brew Potion",
			"Saradomin Brew Potion"
		}));

		//---- textField2 ----
		textField2.setText("Golden Potion Maker - by Goldenglove605");
		textField2.setFont(new Font("Tahoma", Font.BOLD, 12));

		//---- button1 ----
		button1.setText("Start");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button1ActionPerformed(e);
			}
		});

		//---- unfRAD ----
		unfRAD.setText("Make Unf?");

		//---- unfBox ----
		unfBox.setModel(new DefaultComboBoxModel<>(new String[] {
			"Ranarr Unf",
			"Toadflax Unf",
			"Spiritweed Unf",
			"Cadantine Unf"
		}));

		//---- potionRAD ----
		potionRAD.setText("Make potions?");

		//---- grimyRAD ----
		grimyRAD.setText("Clean Herbs?");

		//---- comboBox2 ----
		comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
			"Guam",
			"Marrentill",
			"Tarromin",
			"Harralander",
			"Ranarr",
			"Toadflax",
			"Spiritweed",
			"Irit",
			"Avantoe",
			"Kwuarm",
			"Snapdragon",
			"Cadantine",
			"Lantadyme",
			"Dwarfweed",
			"Torstol",
			"Fellstalk"
		}));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField2, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(30, 30, 30)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(potionRAD)
								.addComponent(grimyRAD)
								.addComponent(unfRAD))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(unfBox)
								.addComponent(comboBox2))
							.addGap(32, 32, 32)))
					.addContainerGap())
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addGap(0, 178, Short.MAX_VALUE)
					.addComponent(button1)
					.addGap(84, 84, 84))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(22, 22, 22)
					.addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(potionRAD))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(unfRAD)
						.addComponent(unfBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(grimyRAD)
						.addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26, 26, 26)
					.addComponent(button1)
					.addGap(38, 38, 38))
		);
		pack();
		setLocationRelativeTo(getOwner());

		//---- buttonGroup1 ----
		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(unfRAD);
		buttonGroup1.add(potionRAD);
		buttonGroup1.add(grimyRAD);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:Variables
	// Generated using JFormDesigner Evaluation license - Caleb 
	private JComboBox<String> comboBox1;
	private JTextField textField2;
	private JButton button1;
	private JRadioButton unfRAD;
	private JComboBox<String> unfBox;
	private JRadioButton potionRAD;
	private JRadioButton grimyRAD;
	private JComboBox<String> comboBox2;
	// JFormDesigner - End of Variables declaration  //GEN-END:Variables
}

