package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class TeamMgmtFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public TeamMgmtFrame() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Team Management");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblName.setBounds(266, 132, 110, 15);
		contentPane.add(lblName);
		
		JLabel lblPicture = new JLabel("");
		lblPicture.setBounds(266, 20, 110, 110);
		contentPane.add(lblPicture);
		
		JLabel lblOvr = new JLabel("");
		lblOvr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOvr.setFont(new Font("±º∏≤", Font.BOLD, 20));
		lblOvr.setBounds(232, 50, 30, 20);
		contentPane.add(lblOvr);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(232, 74, 30, 30);
		contentPane.add(lblLogo);
		
		JLabel lblFlag = new JLabel("");
		lblFlag.setBounds(232, 108, 30, 22);
		contentPane.add(lblFlag);
		
		JLabel lblPac = new JLabel("");
		lblPac.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPac.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblPac.setBounds(266, 156, 54, 14);
		contentPane.add(lblPac);
		
		JLabel lblSho = new JLabel("");
		lblSho.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSho.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblSho.setBounds(266, 180, 54, 14);
		contentPane.add(lblSho);
		
		JLabel lblPas = new JLabel("");
		lblPas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPas.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblPas.setBounds(266, 204, 54, 14);
		contentPane.add(lblPas);
		
		JLabel lblDri = new JLabel("");
		lblDri.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDri.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblDri.setBounds(322, 156, 54, 14);
		contentPane.add(lblDri);
		
		JLabel lblDef = new JLabel("");
		lblDef.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDef.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblDef.setBounds(322, 180, 54, 14);
		contentPane.add(lblDef);
		
		JLabel lblPhy = new JLabel("");
		lblPhy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhy.setFont(new Font("±º∏≤", Font.BOLD, 14));
		lblPhy.setBounds(322, 204, 54, 14);
		contentPane.add(lblPhy);
		
		JLabel lblTemplate = new JLabel("");
		lblTemplate.setIcon(new ImageIcon("C:\\template.png"));
		lblTemplate.setBounds(224, 10, 164, 250);
		contentPane.add(lblTemplate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 200, 215);
		contentPane.add(scrollPane);
		
		String[] players = new String[Main.person.players.size()];
		for (int i = 0; i < Main.person.players.size(); i++)
			players[i] = Main.person.players.get(i).getName() + " (+" + Main.person.players.get(i).getGrade() + ")";
		
		JList list = new JList(players);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (list.getSelectedIndex() == -1) {
					lblName.setText("");
					lblPicture.setText("");
					lblOvr.setText("");
					lblLogo.setText("");
					lblFlag.setText("");
					lblPac.setText("");
					lblSho.setText("");
					lblPas.setText("");
					lblDri.setText("");
					lblDef.setText("");
					lblPhy.setText("");
				}
				else {
					lblName.setText(Main.db.getElement(Main.person.players.get(list.getSelectedIndex()).getId(), 0));
					lblPicture.setText("<html><img src=\"" + Main.db.getElement(Main.person.players.get(list.getSelectedIndex()).getId(), 10) + "\" width=\"110\" height=\"110\"></html>");
					lblOvr.setText(Main.db.getElement(Main.person.players.get(list.getSelectedIndex()).getId(), 12));
					lblLogo.setText("<html><img src=\"" + Main.db.getElement(Main.person.players.get(list.getSelectedIndex()).getId(), 2) + "\" width=\"30\" height=\"30\"></html>");
					lblFlag.setText("<html><img src=\"" + Main.db.getElement(Main.person.players.get(list.getSelectedIndex()).getId(), 8) + "\" width=\"30\" height=\"22\"></html>");
					lblPac.setText(Main.db.getElement(Main.person.players.get(list.getSelectedIndex()).getId(), 13) + " PAC");
					lblSho.setText(Main.db.getElement(Main.person.players.get(list.getSelectedIndex()).getId(), 14) + " SHO");
					lblPas.setText(Main.db.getElement(Main.person.players.get(list.getSelectedIndex()).getId(), 15) + " PAS");
					lblDri.setText(Main.db.getElement(Main.person.players.get(list.getSelectedIndex()).getId(), 16) + " DRI");
					lblDef.setText(Main.db.getElement(Main.person.players.get(list.getSelectedIndex()).getId(), 17) + " DEF");
					lblPhy.setText(Main.db.getElement(Main.person.players.get(list.getSelectedIndex()).getId(), 18) + " PHY");
				}
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		JLabel lblList = new JLabel("Name (+Grade)");
		lblList.setFont(new Font("±º∏≤", Font.BOLD, 14));
		scrollPane.setColumnHeaderView(lblList);
		
		JButton btnRelease = new JButton("Release");
		btnRelease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Select a player to release.", null, JOptionPane.PLAIN_MESSAGE);
				}
				else {
					int ret = JOptionPane.showConfirmDialog(null, "¡§∏ª πÊ√‚«œΩ√∞⁄Ω¿¥œ±Ó?", "»Æ¿Œ", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (ret==0) {
						Main.person.players.remove(list.getSelectedIndex());
						String[] players = new String[Main.person.players.size()];
						for (int i = 0; i < Main.person.players.size(); i++)
							players[i] = Main.person.players.get(i).getName() + " (+" + Main.person.players.get(i).getGrade() + ")";
					
						list.setListData(players);
					}
				}
			}
		});
		btnRelease.setFont(new Font("±º∏≤", Font.BOLD, 14));
		btnRelease.setBounds(12, 235, 200, 25);
		contentPane.add(btnRelease);
	}
}
