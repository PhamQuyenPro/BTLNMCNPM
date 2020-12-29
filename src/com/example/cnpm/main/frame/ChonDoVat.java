package com.example.cnpm.main.frame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;

import com.example.cnpm.main.dao.DAO;
import com.example.cnpm.main.util.DoVat;
import com.example.cnpm.main.util.HoatDong;
import com.example.cnpm.main.util.ThongTinBanGiaoThue;


public class ChonDoVat extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAO dao = new DAO();
	
	private int thanhTien;
	private Vector<String> loaiVt;
	private Vector<String> maloaiVt;
	
	ArrayList<ThongTinBanGiaoThue> mainData = new ArrayList<ThongTinBanGiaoThue>();
	
	private JPanel contentPane;
	private Vector<String[]> rowVt = new Vector<String[]>();		// Vector luu du lieu bang 
 	private DefaultTableModel tableMode = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", 
				"M\u00E3 lo\u1EA1i", "T\u00EAn lo\u1EA1i", "\u0110\u01A1n v\u1ECB",
				"S\u1ED1 l\u01B0\u1EE3ng", " Hi\u1EC7n tr\u1EA1ng", "ThÃ nh tiá»�n"
			}
		);
	
	int stt = 1;
	private JTextField txtLoi;
	private JTextField txtMLoi;
	private JTextField txtSLngThu;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JButton button;
	private JTable table;
	private JButton button_1;
	private JEditorPane editorPane_3;
	private JLabel newLabel;
	private JButton btnLuVThot;
	
	List<DoVat> listDoVat;

	/**
	 * Launch the application.
	 * 
	 */
	void onActionListener() {
		
		
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String dovat = loaiVt.get(comboBox.getSelectedIndex());
				dao.SQL("SELECT maloai FROM dovat WHERE tenloai LIKE N'" + dovat + "'");
				maloaiVt.clear();
				while(dao.next()) {
					maloaiVt.add(dao.getColumn("maloai"));	
				}
				comboBox_1.setModel(new DefaultComboBoxModel(maloaiVt));
				
				String img_name = comboBox_1.getItemAt(0).toString().substring(0,3) + ".png";
				createImage(img_name);
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String img_name = comboBox_1.getSelectedItem().toString().substring(0,3) + ".png";
				createImage(img_name);
				
			}
		});
		
		button.addActionListener(new ActionListener() {							// NÃºt thÃªm 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String maloai = maloaiVt.get(comboBox_1.getSelectedIndex());
					String soluong = editorPane_3.getText();
					int i = Integer.parseInt(soluong);
					if (i <= 0) throw new NumberFormatException();
					dao.SQL("SELECT tenloai,donvi,soluongtoida,trangthai,dongia FROM dovat WHERE maloai = '" + maloai + "'");	
					dao.next();
					if (!isExist(maloai, i, dao)) {
						
						int index = tableMode.getRowCount();
						rowVt.add(new String[] {
								"" + (index + 1), 
								maloai,
								dao.getColumn("tenloai"),
								dao.getColumn("donvi"),
								soluong,
								dao.getColumn("trangthai"),
								i*Integer.parseInt(dao.getColumn("dongia")) + "",
						});
						tableMode.addRow(rowVt.lastElement());
					}
				}catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "    H\u00E3y ch\u1ECDn \u0111\u1ED3 v\u1EADt tr\u01B0\u1EDBc !");
				}catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "    S\u1ED1 l\u01B0\u1EE3ng kh\u00F4ng h\u1EE3p l\u1EC7 !");
				}catch(NullPointerException e3) {
					JOptionPane.showMessageDialog(null, "Kh\u00F4ng c\u00F2n \u0111\u1EE7 s\u1ED1 l\u01B0\u1EE3ng v\u1EEBa nh\u1EADp !");
				}
			}
		});
		
		button_1.addActionListener(new ActionListener() {						// Delete Button
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					
					int index = table.getSelectedRow();
					tableMode.removeRow(index);
					rowVt.remove(index);
					int size = rowVt.size();
					for (int i = index; i < size; i++) {
						tableMode.removeRow(index);
						String[] tmp = rowVt.get(i);
						tmp[0] = "" + (Integer.parseInt(tmp[0]) - 1);
					}
					for (int i = index; i < size; i++) {
						tableMode.addRow(rowVt.get(i));
					}
				
					
				} catch(ArrayIndexOutOfBoundsException e1) {
					
				}
				catch(NullPointerException e2) {
					
				}
			}
		});
		
		btnLuVThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				thanhTien = 0;
				for (String[] s: rowVt) {
					thanhTien+= Integer.parseInt(s[6]);
				}
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChonDoVat frame = new ChonDoVat();
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
	public ChonDoVat() {
		setResizable(false);
		init();
		onActionListener();
		
	}
	void createImage(String img_name) {
		Image img = new ImageIcon(this.getClass().getResource("/images/"+ img_name)).getImage();
		ImageIcon icon = new ImageIcon(img);
		int width = icon.getIconWidth();
		newLabel.setBounds(10 + (475 - width)/2, 121, 475, 285);
		newLabel.setIcon(icon);
	}
	
	private boolean isExist(String maloai, int number, DAO dao) {
		int soluong = Integer.parseInt(dao.getColumn("soluongtoida"));
		if (number > soluong ) throw new NullPointerException();
		int size = rowVt.size();
		for (int i = 0; i < size; i++) {
			String[] tmp = rowVt.get(i);	
			if (maloai.equals(tmp[1])) {
				int sum = Integer.parseInt(tmp[4]) + number;
				if (sum > soluong) throw new NullPointerException();
				for (int j = i ; j < size; j++) {
					tableMode.removeRow(i);
				}
				tmp[4] = "" + sum;
				tmp[6] = "" + sum*Integer.parseInt(dao.getColumn("dongia"));
				for (int j = i; j < size; j++) {
					tableMode.addRow(rowVt.get(j));
				}
				return true;
			}
			
		}
		return false;
	}	
	
	public void saveData(int maHoatDong) {
		mainData.clear();
		for (String[] s : rowVt) {
			mainData.add(new ThongTinBanGiaoThue(-1, s[1], Integer.parseInt(s[4]), s[5], "", -1, maHoatDong));
		}
		for (ThongTinBanGiaoThue thongtin_bangiao_thue: mainData) {
			dao.create("thongtin_bangiao_thue", thongtin_bangiao_thue, ThongTinBanGiaoThue.class);
		}
	}
	
	public Vector<String[]> getDSDoVat() {
		Vector<String[]> res = new Vector<String[]>();
		for (String[] s : rowVt) {
			res.add(new String[] {s[2], s[4]});
		}
		return res;
	}
	
	public ArrayList<ThongTinBanGiaoThue>getThongTinBanGiaoThue() {
		return mainData;
	}
	
	public int getThanhTien() {
		return thanhTien;
	}
	
	private void init() {
		maloaiVt = new Vector<String>();
		loaiVt = new Vector<String>();
		setTitle("Ch\u1ECDn \u0111\u1ED3 v\u1EADt");
		

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 802, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 466, 768, 186);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(tableMode);
		scrollPane.setViewportView(table);
		
		button = new JButton("Th\u00EAm");
		button.setBounds(94, 427, 134, 29);
		contentPane.add(button);
		
		button_1 = new JButton("Xo\u00E1");
		button_1.setBounds(322, 427, 134, 29);
		contentPane.add(button_1);
		
		
		dao.SQL("SELECT DISTINCT tenloai FROM dovat");
		while(dao.next()) {
			loaiVt.add(dao.getColumn("tenloai"));
			
		}
		comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setName("");
		comboBox.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBox.setBounds(60, 38, 100, 35);
		comboBox.setModel(new DefaultComboBoxModel(loaiVt));
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setName("");
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 13));
		comboBox_1.setBounds(288, 38, 77, 35);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"BAN01"}));
		contentPane.add(comboBox_1);
		
		editorPane_3 = new JEditorPane();
		editorPane_3.setBounds(539, 38, 40, 35);
		contentPane.add(editorPane_3);
		
		txtLoi = new JTextField();
		txtLoi.setEditable(false);
		txtLoi.setText(" Lo\u1EA1i");
		txtLoi.setFont(new Font("Arial", Font.PLAIN, 13));
		txtLoi.setColumns(10);
		txtLoi.setBackground(SystemColor.menu);
		txtLoi.setBounds(10, 38, 40, 35);
		contentPane.add(txtLoi);
		
		txtMLoi = new JTextField();
		txtMLoi.setEditable(false);
		txtMLoi.setText(" M\u00E3 lo\u1EA1i");
		txtMLoi.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMLoi.setColumns(10);
		txtMLoi.setBackground(SystemColor.menu);
		txtMLoi.setBounds(218, 38, 60, 35);
		contentPane.add(txtMLoi);
		
		txtSLngThu = new JTextField();
		txtSLngThu.setEditable(false);
		txtSLngThu.setText(" S\u1ED1 l\u01B0\u1EE3ng thu\u00EA");
		txtSLngThu.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSLngThu.setColumns(10);
		txtSLngThu.setBackground(SystemColor.menu);
		txtSLngThu.setBounds(433, 38, 96, 35);
		contentPane.add(txtSLngThu);
		
		newLabel = new JLabel("");
		newLabel.setBounds(10, 71, 475, 285);
		contentPane.add(newLabel);
		
		btnLuVThot = new JButton("L\u01B0u v\u00E0 Tho\u00E1t");
		
		btnLuVThot.setBounds(555, 427, 174, 29);
		contentPane.add(btnLuVThot);
		String img_name = comboBox_1.getItemAt(0).toString().substring(0,3) + ".png";
		createImage(img_name);
	}
}