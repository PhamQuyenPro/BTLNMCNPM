package com.example.cnpm.main.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DateTimePicker;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class BanGiao extends JFrame {
	
	private ChonDoVat chonDoVat;

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton button;
	private JTable table;
	private JTextField txtDanhSch;
	
	private Vector<String[]> rowVt = new Vector<String[]>();
	
	private DefaultTableModel tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên loại", "Số lượng"
			}
		);
	private JTextField txtThiGianTr;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField txtMcch;
	private JTextField txttngTin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanGiao frame = new BanGiao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void onListener() {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chonDoVat.setVisible(true);
				
			}
			
		});
		
		chonDoVat.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				textField_1.setText("= " + chonDoVat.getThanhTien());
				for (int i = 0; i < rowVt.size(); i++) {
					tableModel.removeRow(0);
				}
				rowVt = chonDoVat.getDSDoVat();
				for (String[] s: rowVt) {
					tableModel.addRow(s);
				}
				
			}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public BanGiao() {
		chonDoVat = new ChonDoVat();
		
		setTitle("B\u00E0n giao");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 742, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnNewButton = new JButton("Tu\u1EF3 ch\u1EC9nh");
		btnNewButton.setBounds(191, 62, 97, 21);
		
		button = new JButton("Tu\u1EF3 ch\u1EC9nh");
		button.setBounds(188, 201, 77, 21);
		
		JTextField txtBinBnBn = new JTextField();
		txtBinBnBn.setBounds(197, 5, 275, 38);
		txtBinBnBn.setBorder(null);
		txtBinBnBn.setBackground(SystemColor.menu);
		txtBinBnBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBinBnBn.setText("              BIÊN BẢN BÀN GIAO ĐỒ VẬT");
		txtBinBnBn.setColumns(10);
		
		table = new JTable();
		table.setModel(tableModel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 229, 163, 162);
		scrollPane.setViewportView(table);
		
		txtDanhSch = new JTextField();
		txtDanhSch.setBounds(15, 202, 163, 19);
		txtDanhSch.setText("Danh s\u00E1ch \u0111\u1ED3 b\u00E0n giao");
		txtDanhSch.setBackground(SystemColor.menu);
		txtDanhSch.setColumns(10);
		
		txtThiGianTr = new JTextField();
		txtThiGianTr.setBounds(354, 202, 96, 19);
		txtThiGianTr.setText("Thời gian trả");
		txtThiGianTr.setColumns(10);
		txtThiGianTr.setBackground(SystemColor.menu);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 301, 77, 19);
		textField_1.setText("= 200.000");
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.menu);
		
		textField_2 = new JTextField();
		textField_2.setBounds(384, 301, 88, 19);
		textField_2.setText("= 125.000");
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.menu);
		
		textField_3 = new JTextField();
		textField_3.setBounds(310, 301, 21, 19);
		textField_3.setText(" +");
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.menu);
		
		textField_4 = new JTextField();
		textField_4.setBounds(513, 301, 21, 19);
		textField_4.setText(" =");
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.menu);
		
		JButton btnHonTt = new JButton("Hoàn tất");
		btnHonTt.setBounds(558, 353, 140, 38);
		
		textField_6 = new JTextField();
		textField_6.setBounds(15, 35, 163, 19);
		textField_6.setText("Danh sách đồ bàn giao");
		textField_6.setColumns(10);
		textField_6.setBackground(SystemColor.menu);
		
		txtMcch = new JTextField();
		txtMcch.setBounds(472, 35, 163, 19);
		txtMcch.setText("Mục đích");
		txtMcch.setColumns(10);
		txtMcch.setBackground(SystemColor.menu);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(15, 64, 166, 128);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(472, 64, 163, 128);
		contentPane.setLayout(null);
		contentPane.add(txtDanhSch);
		contentPane.add(scrollPane);
		contentPane.add(button);
		contentPane.add(textField_1);
		contentPane.add(txtThiGianTr);
		contentPane.add(textField_3);
		contentPane.add(editorPane_1);
		contentPane.add(textField_2);
		contentPane.add(textField_4);
		contentPane.add(editorPane);
		contentPane.add(textField_6);
		contentPane.add(txtBinBnBn);
		contentPane.add(txtMcch);
		contentPane.add(btnNewButton);
		contentPane.add(btnHonTt);
		
		DateTimePicker dateTimePicker = new DateTimePicker();
		dateTimePicker.setBounds(300, 228, 294, 30);
		contentPane.add(dateTimePicker);
		
		txttngTin = new JTextField();
		txttngTin.setText("(Tổng tiền) = 325.000");
		txttngTin.setColumns(10);
		txttngTin.setBackground(SystemColor.menu);
		txttngTin.setBounds(558, 301, 140, 19);
		contentPane.add(txttngTin);
		
		onListener();
	}
}
