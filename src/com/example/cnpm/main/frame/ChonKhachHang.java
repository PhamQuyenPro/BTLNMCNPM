package com.example.cnpm.main.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.example.cnpm.main.dao.DAO;
import com.example.cnpm.main.util.TtCaNhan;

import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ChonKhachHang extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtTn;
	
	private int cmnd;
	
	private List<TtCaNhan> listNguoiDangKi;
	private JButton btnNewButton_1;
	private JEditorPane editorPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChonKhachHang frame = new ChonKhachHang();
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
	public ChonKhachHang() {
	  
		listNguoiDangKi = new ArrayList<>();
	  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(69, 11, 263, 19);
		contentPane.add(editorPane);
		
		txtTn = new JTextField();
		txtTn.setEditable(false);
		txtTn.setText("Họ tên");
		txtTn.setBounds(10, 11, 49, 19);
		contentPane.add(txtTn);
		txtTn.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowId = table.getSelectedRow();
				setCmnd(listNguoiDangKi.get(rowId).getCmnd());
				setVisible(false);
			}
		});
		btnNewButton.setBounds(339, 229, 85, 21);
		contentPane.add(btnNewButton);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		DAO dao = new DAO();
		listNguoiDangKi = dao.getAll("tt_canhan", TtCaNhan.class);
		
		initTable();
		
	}

	public int getCmnd() {
		return cmnd;
	}

	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}
	
	void initTable() {
		
		initTable(listNguoiDangKi);
		
		btnNewButton_1 = new JButton("Tìm kiếm");
		btnNewButton_1.setBounds(342, 11, 82, 23);
		contentPane.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 414, 191);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tenTimKiem = editorPane.getText();
				List<TtCaNhan> list = new ArrayList<TtCaNhan>();
				
				for(TtCaNhan tt : listNguoiDangKi) {
					String ten = tt.getHoTen();
					if(ten.toLowerCase().contains(tenTimKiem.toLowerCase().trim())) list.add(tt);
				}
				
				initTable(list);
			}
		});
	}
	
	void initTable(List<TtCaNhan> listCaNhan) {
		String column[] = {"Số CMND", "Họ tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ"};
	    Vector<String> col = new Vector<>(Arrays.asList(column));
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		for(TtCaNhan tt : listCaNhan) {
			Vector<String> vt = new Vector<String>();
			vt.add(String.valueOf(tt.getCmnd()));
			vt.add(tt.getHoTen());
			vt.add(tt.getNgaySinh());
			vt.add(tt.getGioiTinh());
			vt.add(tt.getSdt());
			vt.add(tt.getDiaChi());
			data.add(vt);
		}
		
		table = new JTable(data, col);
	}
	
}
