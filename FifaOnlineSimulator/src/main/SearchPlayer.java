package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import db.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class SearchPlayer extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textOvrMin;
	private JTextField textOvrMax;
	private JTable result;
	
	/**
	 * Create the frame.
	 */
	public SearchPlayer() {
		setResizable(false);
		setTitle("Search Player");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 312, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblName.setBounds(12, 10, 64, 20);
		contentPane.add(lblName);
		
		textName = new JTextField();
		textName.setBounds(88, 10, 198, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblPosition.setBounds(12, 40, 64, 20);
		contentPane.add(lblPosition);
		
		JCheckBox chckbxFW = new JCheckBox("FW");
		chckbxFW.setFont(new Font("Gulim", Font.PLAIN, 12));
		chckbxFW.setBounds(88, 40, 48, 20);
		contentPane.add(chckbxFW);
		
		JCheckBox chckbxMF = new JCheckBox("MF");
		chckbxMF.setFont(new Font("Gulim", Font.PLAIN, 12));
		chckbxMF.setBounds(138, 40, 48, 20);
		contentPane.add(chckbxMF);
		
		JCheckBox chckbxDF = new JCheckBox("DF");
		chckbxDF.setFont(new Font("Gulim", Font.PLAIN, 12));
		chckbxDF.setBounds(188, 40, 48, 20);
		contentPane.add(chckbxDF);
		
		JCheckBox chckbxGK = new JCheckBox("GK");
		chckbxGK.setFont(new Font("Gulim", Font.PLAIN, 12));
		chckbxGK.setBounds(238, 40, 48, 20);
		contentPane.add(chckbxGK);
		
		JLabel lblOverall = new JLabel("Overall");
		lblOverall.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblOverall.setBounds(12, 70, 50, 20);
		contentPane.add(lblOverall);
		
		textOvrMin = new JTextField();
		textOvrMin.setText("0");
		textOvrMin.setBounds(88, 70, 48, 20);
		contentPane.add(textOvrMin);
		textOvrMin.setColumns(10);
		
		JLabel lblTo = new JLabel("~");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblTo.setBounds(148, 70, 20, 20);
		contentPane.add(lblTo);
		
		textOvrMax = new JTextField();
		textOvrMax.setText("100");
		textOvrMax.setBounds(180, 70, 48, 20);
		contentPane.add(textOvrMax);
		textOvrMax.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 135, 274, 118);
		contentPane.add(scrollPane);
		
		result = new JTable();
		scrollPane.setViewportView(result);
		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "Name", "OVR", "League", "Team" }) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		result.setModel(model);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				
				Search search = new Search(textName.getText(), chckbxFW.isSelected(), chckbxMF.isSelected(), chckbxDF.isSelected(), chckbxGK.isSelected(), Integer.parseInt(textOvrMin.getText()), Integer.parseInt(textOvrMax.getText()));
				
				for (int i = 0; i < search.getList().size(); i++)
					model.addRow(new Object[] { Main.db.getElement(search.getList().get(i), 0),
												Main.db.getElement(search.getList().get(i), 12),
												Main.db.getElement(search.getList().get(i), 4),
												Main.db.getElement(search.getList().get(i), 1) });
			}
		});
		btnSearch.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnSearch.setBounds(12, 100, 131, 25);
		contentPane.add(btnSearch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textName.setText("");
				textOvrMin.setText("0");
				textOvrMax.setText("100");
				
				model.setRowCount(0);
			}
		});
		btnReset.setFont(new Font("±¼¸²", Font.BOLD, 14));
		btnReset.setBounds(155, 100, 131, 25);
		contentPane.add(btnReset);
	}
}
