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
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	
	SearchPlayer searchPlayer;
	
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
	public Main() {
		setResizable(false);
		setTitle("FIFA ONLINE SIMULATOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance: " + person.getBalance());
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setFont(new Font("����", Font.BOLD, 16));
		lblBalance.setBounds(252, 10, 216, 19);
		contentPane.add(lblBalance);
		
		JButton btnUpgrade = new JButton("Upgrade");
		btnUpgrade.setFont(new Font("����", Font.BOLD, 16));
		btnUpgrade.setBounds(252, 85, 216, 27);
		contentPane.add(btnUpgrade);
		
		JButton btnTrade = new JButton("Trade");
		btnTrade.setFont(new Font("����", Font.BOLD, 16));
		btnTrade.setBounds(252, 122, 216, 27);
		contentPane.add(btnTrade);
		
		JButton btnTeamManagement = new JButton("Team Management");
		btnTeamManagement.setFont(new Font("����", Font.BOLD, 16));
		btnTeamManagement.setBounds(252, 159, 216, 27);
		contentPane.add(btnTeamManagement);
		
		JButton btnSearchPlayer = new JButton("Search Player");
		btnSearchPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchPlayer = new SearchPlayer();
				searchPlayer.setVisible(true);
			}
		});
		btnSearchPlayer.setFont(new Font("����", Font.BOLD, 16));
		btnSearchPlayer.setBounds(252, 196, 216, 27);
		contentPane.add(btnSearchPlayer);
		
		JButton btnItem = new JButton("Item");
		btnItem.setFont(new Font("����", Font.BOLD, 16));
		btnItem.setBounds(252, 233, 216, 27);
		contentPane.add(btnItem);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\1.jpg"));
		label.setBounds(0, 0, 480, 270);
		contentPane.add(label);
	}
}
