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
		setTitle("TRADE");
		setBounds(100, 100, 532, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 40, 157, 234);
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
		scrollPane_1.setBounds(347, 40, 157, 234);
		contentPane.add(scrollPane_1);
		
		JList selectList = new JList();
		scrollPane_1.setViewportView(selectList);
		
		list_1.addListSelectionListener(this);
		
		btnTrade = new JButton("\uD2B8\uB808\uC774\uB4DC!");
		btnTrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = JOptionPane.showConfirmDialog(null, "정말 트레이드하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (ret==0) {
				if (idxList.size()==10) {
					Trade trade1 = new Trade(playerList.get(idxList.get(0)) ,playerList.get(idxList.get(1)),playerList.get(idxList.get(2)),playerList.get(idxList.get(3)),playerList.get(idxList.get(4)),playerList.get(idxList.get(5)),playerList.get(idxList.get(6)),playerList.get(idxList.get(7)),playerList.get(idxList.get(8)),playerList.get(idxList.get(9)));
					for (int i=9;i>=0;i--)
						playerList.remove(i);
					playerList.add(trade1.getResult());
					String[] showplayer = new String[playerList.size()];
					for (int i=0;i<playerList.size();i++)
						showplayer[i] = playerList.get(i).getName()+" (+"+playerList.get(i).getGrade()+")" ;
					
					result.setText("YOU GET "+trade1.getResult().getName()+" (+"+trade1.getResult().getGrade()+")");
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
					JOptionPane.showOptionDialog(null,"열 명을 고르세요","오류",JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
					btSelect.setEnabled(true);
					btnTrade.setEnabled(false);
				}
				
			}
				
			}
		});
		btnTrade.setBounds(60, 284, 97, 37);
		contentPane.add(btnTrade);
		btnTrade.setEnabled(false);
		
		JLabel lblList = new JLabel("\uC120\uC218 \uBAA9\uB85D");
		lblList.setBounds(12, 15, 57, 15);
		contentPane.add(lblList);
		
		JLabel labelSelected = new JLabel("\uACE0\uB978 \uC120\uC218 \uBAA9\uB85D");
		labelSelected.setBounds(350, 15, 115, 15);
		contentPane.add(labelSelected);
		
		
		result = new JLabel("");
		result.setBounds(207, 284, 258, 37);
		contentPane.add(result);
		
		btSelect = new JButton("\uC120\uC218 \uACE0\uB974\uAE30");
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
					JOptionPane.showOptionDialog(null,"강화 등급이 0인 선수는 트레이드 할 수 없습니다","오류",JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
				}
				else {
					Object[] options = {"OK"};
					JOptionPane.showOptionDialog(null,"열 명을 고르세요","오류",JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
				}
					
			}
		});
		btSelect.setBounds(207, 151, 103, 40);
		contentPane.add(btSelect);
		
		JButton btnReset = new JButton("\uCD08\uAE30\uD654");
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
		btnReset.setBounds(207, 215, 103, 23);
		contentPane.add(btnReset);
		
		lblSelect = new JLabel("");
		lblSelect.setBounds(196, 103, 154, 27);
		contentPane.add(lblSelect);
	
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int[] indices = list_1.getSelectedIndices();
		int selectedNum = indices.length;
		if (selectedNum==1)
			lblSelect.setText("SELECTED A PLAYER");
		else
			lblSelect.setText("SELECTED "+selectedNum+" PLAYERS");
	}
}
