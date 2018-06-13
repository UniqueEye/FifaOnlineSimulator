package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import card.*;
import db.*;
import pack.*;
import user.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Main extends JFrame {

	private JPanel contentPane;
	
	UpgradeFrame upgradeFrame;
	TradeFrame tradeFrame;
	TeamMgmtFrame teamMgmtFrame;
	SearchPlayerFrame searchPlayerFrame;
	ItemFrame itemFrame;
	
	public static final DB db = new DB("C:\\DB.csv");
	public static final Person person = new Person();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {setResizable(false);
		setTitle("FIFA ONLINE SIMULATOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUpgrade = new JButton("Upgrade");
		btnUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				upgradeFrame = new UpgradeFrame(person.players);
				upgradeFrame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/main/logo.png")));
		lblNewLabel.setBounds(188, 53, 280, 22);
		contentPane.add(lblNewLabel);
		btnUpgrade.setFont(new Font("±¼¸²", Font.BOLD, 16));
		btnUpgrade.setBounds(252, 85, 216, 27);
		contentPane.add(btnUpgrade);
		
		JButton btnTrade = new JButton("Trade");
		btnTrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tradeFrame = new TradeFrame(person.players);
				tradeFrame.setVisible(true);
			}
		});
		btnTrade.setFont(new Font("±¼¸²", Font.BOLD, 16));
		btnTrade.setBounds(252, 122, 216, 27);
		contentPane.add(btnTrade);
		
		JButton btnTeamManagement = new JButton("Team Management");
		btnTeamManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				teamMgmtFrame = new TeamMgmtFrame();
				teamMgmtFrame.setVisible(true);
			}
		});
		btnTeamManagement.setFont(new Font("±¼¸²", Font.BOLD, 16));
		btnTeamManagement.setBounds(252, 159, 216, 27);
		contentPane.add(btnTeamManagement);
		
		JButton btnSearchPlayer = new JButton("Search Player");
		btnSearchPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchPlayerFrame = new SearchPlayerFrame();
				searchPlayerFrame.setVisible(true);
			}
		});
		btnSearchPlayer.setFont(new Font("±¼¸²", Font.BOLD, 16));
		btnSearchPlayer.setBounds(252, 196, 216, 27);
		contentPane.add(btnSearchPlayer);
		
		JButton btnItem = new JButton("Item");
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				itemFrame = new ItemFrame();
				itemFrame.setVisible(true);
			}
		});
		btnItem.setFont(new Font("±¼¸²", Font.BOLD, 16));
		btnItem.setBounds(252, 233, 216, 27);
		contentPane.add(btnItem);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/main/background.jpg")));
		label.setBounds(0, 0, 480, 270);
		contentPane.add(label);
	}
}
