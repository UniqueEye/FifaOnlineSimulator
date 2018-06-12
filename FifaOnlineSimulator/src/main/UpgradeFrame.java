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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import card.*;
import java.awt.Font;
import java.awt.Window.Type;
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
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Upgrade");
		setBounds(100, 100, 400, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblUpgrade = new JLabel("Player List");
		lblUpgrade.setBounds(12, 10, 75, 20);
		lblUpgrade.setFont(new Font("굴림", Font.BOLD, 14));
		contentPane.add(lblUpgrade);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 40, 200, 195);
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
		
		JLabel lblPlayer = new JLabel("Player 1");
		lblPlayer.setFont(new Font("굴림", Font.BOLD, 14));
		lblPlayer.setBounds(224, 10, 60, 20);
		contentPane.add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel("Player 2");
		lblPlayer_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblPlayer_1.setBounds(224, 80, 60, 20);
		contentPane.add(lblPlayer_1);
		
		upgradeButton = new JButton("UPGRADE!");
		upgradeButton.setFont(new Font("굴림", Font.BOLD, 14));
		upgradeButton.setBounds(224, 150, 150, 50);
		contentPane.add(upgradeButton);
		
		show_p1 = new JLabel("");
		show_p1.setFont(new Font("굴림", Font.PLAIN, 14));
		show_p1.setBounds(224, 40, 150, 30);
		contentPane.add(show_p1);
		
		show_p2 = new JLabel("");
		show_p2.setFont(new Font("굴림", Font.PLAIN, 14));
		show_p2.setBounds(224, 110, 150, 30);
		contentPane.add(show_p2);
		
		result = new JLabel("");
		result.setBounds(224, 210, 150, 50);
		contentPane.add(result);
		
		btnSelect = new JButton("Select");
		btnSelect.setFont(new Font("굴림", Font.BOLD, 14));
		btnSelect.setBounds(12, 235, 100, 25);
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
		contentPane.add(btnSelect);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("굴림", Font.BOLD, 14));
		btnReset.setBounds(112, 235, 100, 25);
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
		
		if (!p1_choosen||!p2_choosen) {
			 Object[] options = {"OK"};
			 JOptionPane.showOptionDialog(null,"두 선수를 선택하세요.","오류",JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
			}
		else if (p1idx==p2idx||!playerList.get(p1idx).getName().equals(playerList.get(p2idx).getName())) {
			Object[] options = {"OK"};
			JOptionPane.showOptionDialog(null,"같은 선수를 선택하세요.","오류",JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
			}
		else {
		int ret = JOptionPane.showConfirmDialog(null, "정말 강화하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (ret==0) {
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
			if (upgrade1.fail){
			Object[] options = {"OK"};
			JOptionPane.showOptionDialog(null,"강화에 실패했습니다.","위로",JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			}
			else{
				Object[] options = {"OK"};
				JOptionPane.showOptionDialog(null,"강화에 성공했습니다!","축하",JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				}
		}
			else {
				result.setText("CHOOSE SAME PLAYER!");
			}
		}
		}
		p1idx=p2idx=-1;
		show_p1.setText("");
		show_p2.setText("");
		p1_choosen=p2_choosen=false;
		upgradeButton.setEnabled(true);
	}
}
