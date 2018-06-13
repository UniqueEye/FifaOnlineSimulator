package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import card.Player;
import card.Trade;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window.Type;

public class TradeFrame extends JFrame implements ListSelectionListener {

	private JPanel contentPane;
	public ArrayList<Player> playerList;
	public ArrayList<Integer> idxList = new ArrayList<>();
	private JList list_1;
	private JButton btSelect;
	private JButton btnTrade;
	private JLabel result;
	private JLabel lblSelect;

	public TradeFrame(ArrayList<Player> players) {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("TRADE");
		setBounds(100, 100, 462, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 40, 150, 195);
		contentPane.add(scrollPane);
		
		playerList=players;
		String[] showplayer = new String[playerList.size()];
		for (int i=0;i<playerList.size();i++)
		{
			showplayer[i] = playerList.get(i).getName()+" (+"+playerList.get(i).getGrade()+")" ;
		}
		
		list_1 = new JList(showplayer);
		scrollPane.setViewportView(list_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(286, 40, 150, 220);
		contentPane.add(scrollPane_1);
		
		JList selectList = new JList();
		scrollPane_1.setViewportView(selectList);
		
		list_1.addListSelectionListener(this);
		
		btnTrade = new JButton("TRADE!");
		btnTrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = JOptionPane.showConfirmDialog(null, "정말 트레이드하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (ret==0) {
				if (idxList.size()==10) {
					Trade trade1 = new Trade(playerList.get(idxList.get(0)) ,playerList.get(idxList.get(1)),playerList.get(idxList.get(2)),playerList.get(idxList.get(3)),playerList.get(idxList.get(4)),playerList.get(idxList.get(5)),playerList.get(idxList.get(6)),playerList.get(idxList.get(7)),playerList.get(idxList.get(8)),playerList.get(idxList.get(9)));
					playerList.add(trade1.getResult());
					for (int i=9;i>=0;i--)
						playerList.remove(i);
					String[] showplayer = new String[playerList.size()];
					for (int i=0;i<playerList.size();i++)
						showplayer[i] = playerList.get(i).getName()+" (+"+playerList.get(i).getGrade()+")" ;
					
					result.setText("<html><p>YOU GOT</p><p>"+trade1.getResult().getName()+"</p><p>(+"+trade1.getResult().getGrade()+")</p></html>");
					list_1.setListData(showplayer);
					
					String[] emptyArr = {};
					selectList.setListData(emptyArr);
					btSelect.setEnabled(true);
					btnTrade.setEnabled(false);
					String image = "<html><p style=\"text-align: center;\"><img src=\"" + trade1.getResult().getImage() + "\"></p>";
					image += "<p style=\"text-align: center;\"><span style=\"font-size: 16px;\">" + trade1.getResult().getName() + "</span></p></html>";
					JOptionPane.showMessageDialog(null, image, null, JOptionPane.PLAIN_MESSAGE);
				}
				else {
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null,"열 명의 선수를 선택하세요.","오류",JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
					btSelect.setEnabled(true);
					btnTrade.setEnabled(false);
				}
				
			}
				
			}
		});
		btnTrade.setBounds(174, 125, 100, 35);
		contentPane.add(btnTrade);
		btnTrade.setEnabled(false);
		
		JLabel lblList = new JLabel("Player List");
		lblList.setFont(new Font("굴림", Font.BOLD, 14));
		lblList.setBounds(12, 15, 150, 15);
		contentPane.add(lblList);
		
		JLabel labelSelected = new JLabel("Selected List");
		labelSelected.setFont(new Font("굴림", Font.BOLD, 14));
		labelSelected.setBounds(286, 15, 150, 15);
		contentPane.add(labelSelected);
		
		
		result = new JLabel("");
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setBounds(174, 170, 100, 75);
		contentPane.add(result);
		
		btSelect = new JButton("Select");
		btSelect.setFont(new Font("굴림", Font.BOLD, 12));
		btSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int[] indices = list_1.getSelectedIndices();
				boolean iszeroLevel = false;
				for (int i=0;i<indices.length;i++)
				{
					if(playerList.get(indices[i]).getGrade()==0)
					{
						iszeroLevel=true;
						break;
					}
				}
				if (indices.length==10&&!iszeroLevel) {
				String[] showplayer2 = new String[indices.length];
				for (int i=0;i<indices.length;i++)
					showplayer2[i]=playerList.get(indices[i]).getName()+" (+"+playerList.get(indices[i]).getGrade()+")";
				
				
				idxList.clear();
				for (int i=0;i<indices.length;i++)
					idxList.add(indices[i]);
				
				selectList.setListData(showplayer2);
				result.setText("");
				btSelect.setEnabled(false);
				btnTrade.setEnabled(true);
				}
				else if (iszeroLevel) {
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null,"+0 선수는 트레이드 할 수 없습니다.","오류",JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
				}
				else {
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null,"열 명의 선수를 고르세요.","오류",JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
				}
					
			}
		});
		btSelect.setBounds(12, 235, 75, 25);
		contentPane.add(btSelect);
		
		JButton btnReset = new JButton("Clear");
		btnReset.setFont(new Font("굴림", Font.BOLD, 12));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				result.setText("");
				lblSelect.setText("");
				btSelect.setEnabled(true);
				btnTrade.setEnabled(false);
				String[] emptyArr = {};
				selectList.setListData(emptyArr);
				String[] showplayer = new String[playerList.size()];
				for (int i=0;i<playerList.size();i++)
					showplayer[i] = playerList.get(i).getName()+" (+"+playerList.get(i).getGrade()+")" ;
				list_1.setListData(showplayer);
			}
		});
		btnReset.setBounds(87, 235, 75, 25);
		contentPane.add(btnReset);
		
		lblSelect = new JLabel("");
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setBounds(174, 40, 100, 75);
		contentPane.add(lblSelect);
	
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int[] indices = list_1.getSelectedIndices();
		int selectedNum = indices.length;
		if (selectedNum==1)
			lblSelect.setText("<html><p>SELECTED</p><p>1 PLAYER</p></html>");
		else
			lblSelect.setText("<html><p>SELECTED</p><p>"+selectedNum+" PLAYERS</p></html>");
	}
}
