package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import card.Player;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JButton;
import card.*;
public class UpgradeFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JList list_1;
	private JLabel show_p1, show_p2;
	private JLabel result;
	private JButton upgradeButton;
	private boolean p1_choosen=false, p2_choosen=false;
	private int p1idx, p2idx;
	private String p1=null, p2=null;
	public ArrayList<Player> playerList;
	private JButton btnSelect;
	private JButton btnReset;
	/**
	 * Create the frame.
	 * 
	 */
	public UpgradeFrame(ArrayList<Player> players) {
		setTitle("UPGRADE");
		setBounds(100, 100, 534, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUpgrade = new JLabel("\uC120\uC218 \uBAA9\uB85D");
		lblUpgrade.setBounds(12, 38, 88, 35);
		contentPane.add(lblUpgrade);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 83, 237, 276);
		contentPane.add(scrollPane);
		
		playerList=players;
		String[] showplayer = new String[playerList.size()];
		for (int i=0;i<playerList.size();i++)
		{
			showplayer[i] = playerList.get(i).getName()+" (+"+playerList.get(i).getGrade()+")" ;
		}
		
		list_1 = new JList(showplayer);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list_1);
		
		JLabel label_p1 = new JLabel("\uC120\uC218 1");
		label_p1.setBounds(271, 83, 57, 15);
		contentPane.add(label_p1);
		
		JLabel label_p2 = new JLabel("\uC120\uC218 2");
		label_p2.setBounds(271, 138, 57, 15);
		contentPane.add(label_p2);
		
		upgradeButton = new JButton("\uAC15\uD654!");
		upgradeButton.setBounds(279, 204, 97, 23);
		contentPane.add(upgradeButton);
		
		show_p1 = new JLabel("");
		show_p1.setBounds(271, 108, 151, 23);
		contentPane.add(show_p1);
		
		show_p2 = new JLabel("");
		show_p2.setBounds(271, 163, 151, 23);
		contentPane.add(show_p2);
		
		result = new JLabel("");
		result.setBounds(271, 258, 224, 51);
		contentPane.add(result);
		
		btnSelect = new JButton("\uACE0\uB974\uAE30");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!p1_choosen) {
					p1 = (String) list_1.getSelectedValue();
					p1idx=list_1.getSelectedIndex();
					show_p1.setText(p1);
					p1_choosen=true;
				}
				else if (!p2_choosen){
					p2 =(String) list_1.getSelectedValue();
					p2idx=list_1.getSelectedIndex();
					show_p2.setText(p2);
					p2_choosen=true;
				}
			}
		});
		btnSelect.setBounds(141, 50, 97, 23);
		contentPane.add(btnSelect);
		
		btnReset = new JButton("\uCD08\uAE30\uD654");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1idx=p2idx=-1;
				show_p1.setText("");
				show_p2.setText("");
				result.setText("");
				p1_choosen=p2_choosen=false;
				upgradeButton.setEnabled(true);
			}
		});
		btnReset.setBounds(141, 16, 97, 23);
		contentPane.add(btnReset);
		
		upgradeButton.addActionListener(this);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (p1idx>p2idx) {
			int temp = p1idx;
			p1idx=p2idx;
			p2idx=temp;
		}
		
		upgradeButton.setEnabled(false);
		
		if (!p1_choosen||!p2_choosen) {result.setText("Finish to choose");}
		else if (p1idx==p2idx) {result.setText("choose same, different idx player");}
		else {
		Player play1 = playerList.get(p1idx);
		Player play2 = playerList.get(p2idx);
		Upgrade upgrade1 = new Upgrade(play1, play2);
		
		if (upgrade1.complete&&upgrade1.success) {
		if (play1.getGrade()>=play2.getGrade())
			playerList.add(play1);
		else
			playerList.add(play2);
		playerList.remove(p2idx);
		playerList.remove(p1idx);
		}
		if (upgrade1.complete&&upgrade1.fail) {
		if (play1.getGrade()>=play2.getGrade()) { 
			playerList.add(play2);
			}
		else {
			playerList.add(play1);
			}
			playerList.remove(p2idx);
			playerList.remove(p1idx);
		}
		
		
		String[] arr = new String[playerList.size()];
		
		for (int i = 0; i < playerList.size(); i ++)
			arr[i] = playerList.get(i).getName()+" +"+playerList.get(i).getGrade();
		
		list_1.setListData(arr);
		if(upgrade1.complete) {
			if (upgrade1.fail)
				result.setText("FAIL TO UPGRADE");
			else
				result.setText("SUCCESS TO UPGRADE");
		}
			else {
				result.setText("CHOOSE SAME PLAYERS!");
			}
		}
		p1idx=p2idx=-1;
		show_p1.setText("");
		show_p2.setText("");
		p1_choosen=p2_choosen=false;
		upgradeButton.setEnabled(true);
	}
}


