package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import pack.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class ItemFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public ItemFrame() {
		setType(Type.UTILITY);
		setTitle("Item");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 370, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOvr = new JLabel("Open OVR Pack");
		lblOvr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOvr.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lblOvr.setBounds(12, 10, 332, 24);
		contentPane.add(lblOvr);
		
		JButton btnAvrAll = new JButton("OVR ALL Pack");
		btnAvrAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Opening OVR ALL Pack", null, JOptionPane.PLAIN_MESSAGE);
				new OVR(0);
			}
		});
		btnAvrAll.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnAvrAll.setBounds(12, 40, 160, 30);
		contentPane.add(btnAvrAll);
		
		JButton btnOvr60 = new JButton("<html>OVR <span style=\"text-decoration: underline;\">60</span> Pack</html>");
		btnOvr60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "<html>Opening OVR <span style=\"text-decoration: underline;\">60</span> Pack</html>", null, JOptionPane.PLAIN_MESSAGE);
				new OVR(60);
			}
		});
		btnOvr60.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnOvr60.setBounds(184, 40, 160, 30);
		contentPane.add(btnOvr60);
		
		JButton btnOvr65 = new JButton("<html>OVR <span style=\"text-decoration: underline;\">65</span> Pack</html>");
		btnOvr65.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "<html>Opening OVR <span style=\"text-decoration: underline;\">65</span> Pack</html>", null, JOptionPane.PLAIN_MESSAGE);
				new OVR(65);
			}
		});
		btnOvr65.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnOvr65.setBounds(12, 80, 160, 30);
		contentPane.add(btnOvr65);
		
		JButton btnOvr70 = new JButton("<html>OVR <span style=\"text-decoration: underline;\">70</span> Pack</html>");
		btnOvr70.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "<html>Opening OVR <span style=\"text-decoration: underline;\">70</span> Pack</html>", null, JOptionPane.PLAIN_MESSAGE);
				new OVR(70);
			}
		});
		btnOvr70.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnOvr70.setBounds(184, 80, 160, 30);
		contentPane.add(btnOvr70);
		
		JButton btnOvr75 = new JButton("<html>OVR <span style=\"text-decoration: underline;\">75</span> Pack</html>");
		btnOvr75.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "<html>Opening OVR <span style=\"text-decoration: underline;\">75</span> Pack</html>", null, JOptionPane.PLAIN_MESSAGE);
				new OVR(75);
			}
		});
		btnOvr75.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnOvr75.setBounds(12, 120, 160, 30);
		contentPane.add(btnOvr75);
		
		JButton btnOvr80 = new JButton("<html>OVR <span style=\"text-decoration: underline;\">80</span> Pack</html>");
		btnOvr80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "<html>Opening OVR <span style=\"text-decoration: underline;\">80</span> Pack</html>", null, JOptionPane.PLAIN_MESSAGE);
				new OVR(80);
			}
		});
		btnOvr80.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnOvr80.setBounds(184, 120, 160, 30);
		contentPane.add(btnOvr80);
		
		JLabel lblLeague = new JLabel("Open League Pack");
		lblLeague.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeague.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lblLeague.setBounds(12, 160, 332, 24);
		contentPane.add(lblLeague);
		
		JButton btnEnglish = new JButton("English PL Pack");
		btnEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Opening English PL Pack", null, JOptionPane.PLAIN_MESSAGE);
				new League("English Premier League");
			}
		});
		btnEnglish.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnEnglish.setBounds(12, 190, 160, 30);
		contentPane.add(btnEnglish);
		
		JButton btnLaLiga = new JButton("La Liga Pack");
		btnLaLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Opening La Liga Pack", null, JOptionPane.PLAIN_MESSAGE);
				new League("Spanish Primera Division");
			}
		});
		btnLaLiga.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnLaLiga.setBounds(184, 190, 160, 30);
		contentPane.add(btnLaLiga);
		
		JButton btnBundesliga = new JButton("Bundesliga Pack");
		btnBundesliga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Opening Bundesliga Pack", null, JOptionPane.PLAIN_MESSAGE);
				new League("German Bundesliga");
			}
		});
		btnBundesliga.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnBundesliga.setBounds(12, 230, 160, 30);
		contentPane.add(btnBundesliga);
		
		JButton btnSerieA = new JButton("Serie A Pack");
		btnSerieA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Opening Serie A Pack", null, JOptionPane.PLAIN_MESSAGE);
				new League("Italian Serie A");
			}
		});
		btnSerieA.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnSerieA.setBounds(184, 230, 160, 30);
		contentPane.add(btnSerieA);
	}
}
