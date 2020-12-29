package com.example.cnpm.main.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.example.cnpm.main.dao.DAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class TTBanGiao extends JFrame {
	
	private int maBanGiao;
	private int maHoatDong;
	private DAO dao = new DAO();
	private JPanel contentPane;
	private JTable table;
	private Vector<String[]> rowVt = new Vector<String[]>();
	private DefaultTableModel tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			 "Tên đồ vật", "Mã loại", "Số lượng", "Trạng thái lúc thuê", "Trạng thái khi trả"
			}
		);

	private void onListener() {
	}
	
	private void onCreate() {
		if (maBanGiao > 0) dao.SQL("select d.tenloai, t.* from dovat d, thongtin_bangiao_thue t where d.maloai = t.maloai and t.mabangiao = " + maBanGiao);
		else if (maHoatDong > 0) dao.SQL("select d.tenloai, t.* from dovat d, thongtin_bangiao_thue t where d.maloai = t.maloai and t.mahoatdong = " + maHoatDong);
		while (dao.next()) {
			rowVt.add(new String[] {
				dao.getColumn("tenloai"),
				dao.getColumn("maloai"),
				dao.getColumn("soluong"),
				dao.getColumn("trangthai_truoc"),
				dao.getColumn("trangthai_sau"),
				
			});
			tableModel.addRow(rowVt.lastElement());
		}
	}
	
	public TTBanGiao(int maBanGiao, int maHoatDong) {
		this.maBanGiao = maBanGiao;
		this.maHoatDong = maHoatDong;
		setTitle("Danh sách thuê");
		init();
		onCreate();
		onListener();
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 469, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusable(false);
		scrollPane.setEnabled(false);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
	}

	public int getMaBanGiao() {
		return maBanGiao;
	}

	public void setMaBanGiao(int maBanGiao) {
		this.maBanGiao = maBanGiao;
	}

	public int getMaHoatDong() {
		return maHoatDong;
	}

	public void setMaHoatDong(int maHoatDong) {
		this.maHoatDong = maHoatDong;
	}
}
