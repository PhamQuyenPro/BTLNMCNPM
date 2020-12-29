package com.example.cnpm.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.cnpm.main.dao.DAO;
import com.example.cnpm.main.frame.BanGiao;
import com.example.cnpm.main.frame.Ban_giao;
import com.example.cnpm.main.frame.BaoCaoHoatDong;
import com.example.cnpm.main.frame.DangKy;
import com.example.cnpm.main.frame.GDQuanLiNDK;
import com.example.cnpm.main.frame.LichSuHoatDong;
import com.example.cnpm.main.frame.LoginForm;
import com.example.cnpm.main.frame.TTBanGiao;
import com.example.cnpm.main.util.HoatDong;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnBaoCaoHoatDong;
	private JButton btnBanGiao;
	private JButton btnKhachHang;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JTextField textField;
	private String taiKhoan;
	private JButton btnNewButton;
	
	private boolean clickable = false;
	private JTextField txtPhnMmQun;
	private JButton btnLchSHot;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame("Admin");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void onListener() {
	}

	/**
	 * Create the frame.
	 */
	public MainFrame(String taiKhoan) {
		setTitle("Quản lý nhà văn hóa");
		
		this.taiKhoan = taiKhoan;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		setBounds(100, 100, 769, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBaoCaoHoatDong = new JButton("Báo cáo hoạt động");
		btnBaoCaoHoatDong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBaoCaoHoatDong.setBounds(10, 128, 173, 38);
		contentPane.add(btnBaoCaoHoatDong);
		
		btnBanGiao = new JButton("Bàn giao");
		btnBanGiao.setActionCommand("Bàn giao cơ sở vật chất");
		btnBanGiao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BanGiao bangiao = new BanGiao();
				bangiao.setVisible(true);
			}
		});
		btnBanGiao.setBounds(10, 226, 173, 38);
		contentPane.add(btnBanGiao);
		
		btnKhachHang = new JButton("Danh sách khách hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GDQuanLiNDK quanLyNguoi = new GDQuanLiNDK(0);
				quanLyNguoi.setVisible(true);
			}
		});
		btnKhachHang.setBounds(10, 274, 173, 38);
		contentPane.add(btnKhachHang);
		
		btnNewButton_3 = new JButton("Quản lý cơ sở vật chất");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ban_giao bangiao = new Ban_giao();
				bangiao.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(10, 177, 173, 38);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm dangNhap = new LoginForm();
				dangNhap.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(639, 11, 109, 41);
		contentPane.add(btnNewButton_4);
		
		String column[] = {"STT", "Tên Hoạt Động", "Thời gian bắt đầu", "Thời gian kết thúc", "Mục đích"};
		Vector<String> col = new Vector<>(Arrays.asList(column));
	    Vector<HoatDong> data = new Vector<HoatDong>(); 
		
		DAO dao = new DAO();
	    
	    List<HoatDong> lsHd = dao.getAll("lshoatdong", HoatDong.class);
	    for(HoatDong hd : lsHd)
	    	data.add(hd);
	    contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(456, 12, 173, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField.setText("Tài khoản: " + taiKhoan);
		
		btnNewButton = new JButton("Thêm tài khoản");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DangKy dangKy = new DangKy();
				dangKy.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 323, 173, 38);
		contentPane.add(btnNewButton);
		
		txtPhnMmQun = new JTextField();
		txtPhnMmQun.setEditable(false);
		txtPhnMmQun.setBorder(null);
		txtPhnMmQun.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhnMmQun.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtPhnMmQun.setText("PHẦN MỀM QUẢN LÝ NHÀ VĂN HÓA");
		txtPhnMmQun.setBounds(36, 8, 340, 41);
		contentPane.add(txtPhnMmQun);
		txtPhnMmQun.setColumns(10);
		
		btnLchSHot = new JButton("Lịch sử hoạt động");
		btnLchSHot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LichSuHoatDong lshd = new LichSuHoatDong();
				lshd.setVisible(true);
			}
		});
		btnLchSHot.setBounds(10, 79, 173, 38);
		contentPane.add(btnLchSHot);
		
		JTextPane txtpnBoCo = new JTextPane();
		txtpnBoCo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnBoCo.setText("- Báo cáo hoạt động: báo cáo nội dung hoạt động được tổ chức tại nhà văn hóa, gồm có tên hoạt động, mục đích, thời gian bắt đầu, thời gian kết thúc, bàn giao cơ sở vật chất của hoạt động và người tổ chức.\n -Bàn giao: bàn giao cơ sở vật chất giúp cán bộ quản lý cơ sở vật chất của nhà văn hóa. \n -Danh sách khách hàng: Lưu trữ thông tin khách hàng có nhu cầu sử dụng nhà văn hóa. \n -Quản lỹ cơ sở vật chất: quản lý cơ sở vật chất của nhà văn hóa, xem tình trạng của cơ sở vật chất. \n -Thêm tài khoản: thêm tài khoản quản lý nhà văn hóa.\n -Lịch sử hoạt động: lịch sử các hoạt động đã được tổ chức tại nhà văn hóa.");
		txtpnBoCo.setBounds(193, 79, 550, 282);
		contentPane.add(txtpnBoCo);
		
		setUpButton();
		
		setUpTable();
		
		onListener();
	}
	
	private void setUpButton() {
		
		btnBaoCaoHoatDong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BaoCaoHoatDong baoCaoHoatDong = new BaoCaoHoatDong();
				baoCaoHoatDong.setVisible(true);
			}
		});
	}
	
	private void setUpTable() {
	}
}
