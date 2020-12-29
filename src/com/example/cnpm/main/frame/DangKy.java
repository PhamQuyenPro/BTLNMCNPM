package com.example.cnpm.main.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.cnpm.main.dao.DAO;
import com.example.cnpm.main.util.TaiKhoan;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DangKy extends JFrame {

	private JPanel contentPane;
	private JTextField txtTnngNhp;
	private JTextField txtMtKhu;
	private JTextField txtNhpLiMt;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private DAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKy frame = new DangKy();
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
	public DangKy() {
		
		dao = new DAO();
		List<TaiKhoan> listTaiKhoan = dao.getAll("taikhoan", TaiKhoan.class);
		
		setTitle("Th\u00EAm t\u00E0i kho\u1EA3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTnngNhp = new JTextField();
		txtTnngNhp.setEditable(false);
		txtTnngNhp.setText("T\u00EAn \u0111\u0103ng nh\u1EADp");
		txtTnngNhp.setBounds(10, 11, 97, 20);
		contentPane.add(txtTnngNhp);
		txtTnngNhp.setColumns(10);
		
		txtMtKhu = new JTextField();
		txtMtKhu.setEditable(false);
		txtMtKhu.setText("M\u1EADt kh\u1EA9u");
		txtMtKhu.setBounds(10, 42, 97, 20);
		contentPane.add(txtMtKhu);
		txtMtKhu.setColumns(10);
		
		txtNhpLiMt = new JTextField();
		txtNhpLiMt.setEditable(false);
		txtNhpLiMt.setText("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		txtNhpLiMt.setBounds(10, 73, 97, 20);
		contentPane.add(txtNhpLiMt);
		txtNhpLiMt.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(117, 11, 307, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 42, 307, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(117, 73, 307, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Ho\u00E0n t\u1EA5t \u0111\u0103ng k\u00FD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenDangNhap = textField.getText();
				String mk = textField_1.getText();
				String rmk = textField_2.getText();
				

				
				if(!mk.equals(rmk)) {
					JOptionPane.showMessageDialog(rootPane,"Mật khẩu và xác nhận mật khẩu không giống nhau!");
					return;
				} else {
					for(TaiKhoan tk : listTaiKhoan)
						if(tk.getTentk().equals(tenDangNhap)) {
							JOptionPane.showMessageDialog(rootPane,"Tài khoản đã tồn tại!");
							return;
						}
					dao.create("taikhoan", new TaiKhoan(tenDangNhap, mk, listTaiKhoan.get(0).getCmnd()), TaiKhoan.class);
				}
				dispose();
			}
		});
		btnNewButton.setBounds(200, 227, 125, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("H\u1EE7y b\u1ECF");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancel);
	}
}
