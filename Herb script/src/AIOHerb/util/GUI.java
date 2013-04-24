package AIOHerb.util;

import java.awt.Container;
import java.awt.EventQueue;
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

import AIOHerb.AIOHerb;

public class GUI extends JFrame {
	 public static void main(String[] args) {
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
	    }
	
	public GUI() {
		initComponents();
	}

	public void destroy() {
		this.dispose();
	}
	
	private void button1ActionPerformed(ActionEvent e) {
		if(unfRAD.isSelected()) {
			Const.whatToDo = 2;
			if(unfBox.getSelectedItem().toString().equals("Ranarr Potion"));
			AIOHerb.unfPot = UnfPotion.RANARR;
		}
		else if(potionRAD.isSelected()) {
			Const.whatToDo = 1;
			if(comboBox1.getSelectedItem().toString().equals("Guam Potion")) {
				AIOHerb.pot = Potion.ATTACKPOTION;
			}

		}
		AIOHerb.guiWait = false;
		destroy();
		
		
		
		/*if(unfRAD.isSelected()) {
			Const.whatToDo = 2;
			String chosen = unfBox.getSelectedItem().toString();
			
			if(chosen.equals("Ranarr Unf")){
				Const.herbToUse = Const.ranarrID;
			}
			else if(chosen.equals("Toadflax Unf")) {
				Const.herbToUse = Const.toadflaxID;
			}
			else if(chosen.equals("Spiritweed Unf")) {
				Const.herbToUse = Const.spiritweedID;
			}
			else if(chosen.equals("Cadantine Unf")) {
				Const.herbToUse = Const.cadantineID;
			}
			
		}
		else if(potionRAD.isSelected()) {
			Const.whatToDo = 1;
			String chosen = comboBox1.getSelectedItem().toString();
			
			if(chosen.equals("Attack Potion")) {
				Const.unfToMake = Const.guamPotionID;
				Const.herbToUse = Const.guamID;
				Const.ingreToUse = Const.eyeOfNewtID;
			}
			else if(chosen.equals("Ranging Potion")) {
				Const.unfToMake = Const.uamPotionID;
				Const.herbToUse = Const.guamID;
				Const.ingreToUse = Const.redberriesID;
			}
			else if(chosen.equals("Magic Potion")) {
				Const.unfToMake = Const.tarrominPotionID;
				Const.herbToUse = Const.tarrominID;
				Const.ingreToUse = Const.beadID;
			}
			else if(chosen.equals("Strength Potion")) {
				Const.unfToMake = Const.tarrominPotionID;
				Const.herbToUse = Const.tarrominID;
				Const.ingreToUse = Const.limpID;
			}
			else if(chosen.equals("Defence Potion")) {
				Const.unfToMake = Const.marrentillPotionID;
				Const.herbToUse = Const.marrentillID;
				Const.ingreToUse = Const.bearfurID;
			}
			else if(chosen.equals("Anti-poison Potion")) {
				Const.unfToMake = Const.marrentillPotionID;
				Const.herbToUse = Const.marrentillID;
				Const.ingreToUse = Const.groundunicornID;
			}
			else if(chosen.equals("Prayer Potion")) {
				Const.unfToMake = Const.ranarrPotionID;
				Const.herbToUse = Const.ranarrID;
				Const.ingreToUse = Const.snapeGrassID;
			}
			else if(chosen.equals("Super Attack Potion")){
				unfToMake = iritPotionID;
				herbToUse = iritID;
				ingreToUse = eyeOfNewtID;
			}
			else if(chosen.equals("Super Strength Potion")) {
				unfToMake = kwuarmPotionID;
				herbToUse = kwuarmID;
				ingreToUse = limpID;
			}
			else if(chosen.equals("Super Restore Potion")) {
				unfToMake = snapdragonPotionID;
				herbToUse = snapdragonID;
				ingreToUse = redspidereggsID;
			}
			else if(chosen.equals("Super Defence Potion")) {
				unfToMake = cadantinePotionID;
				herbToUse = cadantineID;
				ingreToUse = whiteberriesID;
			}
			else if(chosen.equals("Super Ranging Potion")) {
				unfToMake = dwarfweedPotionID;
				herbToUse = dwarfweedID;
				ingreToUse = wineOfZamorakID;
			}
			else if(chosen.equals("Super Magic Potion")) {
				unfToMake = lantadymePotionID;
				herbToUse = lantadymeID;
				ingreToUse = potatocactusID;
			}
			else if(chosen.equals("Zamorak Brew Potion")) {
				unfToMake = torstolPotionID;
				herbToUse = torstolID;
				ingreToUse = jangerberriesID;
			}
			else if(chosen.equals("Saradomin Brew Potion")) {
				unfToMake = toadflaxPotionID;
				herbToUse = toadflaxID;
				ingreToUse = crushednestID;
			}
		}
		else if(grimyRAD.isSelected()){
			whatToDo = 3;
			String chosen = comboBox2.getSelectedItem().toString();
			
			if(chosen.equals("Guam")) {
				grimyHerbToUse = grimyGuam;
			}
			else if(chosen.equals("Marrentill")) {
				grimyHerbToUse = grimyMarrentill;
			}
			else if(chosen.equals("Tarromin")) {
				grimyHerbToUse = grimyTarromin;
			}
			else if(chosen.equals("Harralander")) {
				grimyHerbToUse = grimyHarralander;
			}
			else if(chosen.equals("Ranarr")) {
				grimyHerbToUse = grimyRanarr;
			}
			else if(chosen.equals("Toadflax")) {
				grimyHerbToUse = grimyToadflax;
			}
			else if(chosen.equals("Spiritweed")) {
				grimyHerbToUse = grimySpiritweed;
			}
			else if(chosen.equals("Irit")) {
				grimyHerbToUse = grimyIrit;
			}
			else if(chosen.equals("Avantoe")) {
				grimyHerbToUse = grimyAvantoe;
			}
			else if(chosen.equals("Kwuarm")) {
				grimyHerbToUse = grimyKwuarm;
			}
			else if(chosen.equals("Snapdragon")) {
				grimyHerbToUse = grimySnapdragon;
			}
			else if(chosen.equals("Cadantine")) {
				grimyHerbToUse = grimyCadantine;
			}
			else if(chosen.equals("Lantadyme")) {
				grimyHerbToUse = grimyLantadyme;
			}
			else if(chosen.equals("Dwarfweed")) {
				grimyHerbToUse = grimyDwarfweed;
			}
			else if(chosen.equals("Torstol")) {
				grimyHerbToUse = grimyTorstol;
			}
			else if(chosen.equals("Fellstalk")) {
				grimyHerbToUse = grimyFellstalk;
			}
			
		}
			
			guiWait = false;
			g.dispose(); */
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

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Caleb 
	private JComboBox<String> comboBox1;
	private JTextField textField2;
	private JButton button1;
	private JRadioButton unfRAD;
	private JComboBox<String> unfBox;
	private JRadioButton potionRAD;
	private JRadioButton grimyRAD;
	private JComboBox<String> comboBox2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}

