package com.example.cnpm.main.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.example.cnpm.main.dao.DAO;
import com.example.cnpm.main.util.HoatDong;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

public class LichSuHoatDong extends JFrame
{

  Vector<HoatDong> data;
	
  private JPanel contentPane;
  private JTable table;
  private JTextField textField;
  
  private static final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
  private static final Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
  
  private boolean clickable = false;
  private Vector<String[]> rowVt = new Vector<String[]>();
  private Boolean[] enable = new Boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
  
  private DefaultTableModel tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Tên hoạt động", "Đơn vị/Cá nhân tổ chức", "Thời gian bắt đầu", "Thời gian kết thúc", "Mục đích"
			}
		);
  /**
   * Launch the application.
   */
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable() {
      public void run()
      {
        try
        {
          LichSuHoatDong frame = new LichSuHoatDong();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }

  private void onListener() {
	  table.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				int ay = e.getY();
				
				if (ay%20 == 0 && ay != 0) {
					ay = ay/20 - 1;
				}
				else ay = ay/20;
				
				int ax = e.getX();
				
				if (ax%129 == 0 && ax != 0) {
					ax = ax/129 - 1;
				}
				else ax = ax/129;
				
				if ((ax < 1 || (ax < 3 && ax >= 2)) && enable[ay]) {
					clickable = true;
					if (ax < 1) {
						 textField.setText("Hoạt động này có biên bản bàn giao. Nhấn chuột để xem chi tiết");
					}
					else {
						textField.setText("              Nhấn chuột để xem thông tin khách hàng");
					}
					table.setCursor(handCursor);
				}
				else {
					clickable = false;
					textField.setText("");
					table.setCursor(defaultCursor);
				}
			}
			
		});
	  table.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (clickable) {
				switch(table.getSelectedColumn()) {
			
				case 0: 
					TTBanGiao ttBanGiao = new TTBanGiao(-1, 10);
					ttBanGiao.setVisible(true);
					break;
				case 1: 
					break;
				}
			}	
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			textField.setText("");
			clickable = false;
		}
		  	
	  });
  }
  
  public LichSuHoatDong()
  {
  	setResizable(false);
    setTitle("L\u1ECBch s\u1EED ho\u1EA1t \u0111\u1ED9ng");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 808, 454);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    String column[] = {"STT", "Tên Hoạt Động", "Thá»�i gian báº¯t Ä‘áº§u", "Thá»�i gian káº¿t thÃºc", "Má»¥c Ä‘Ã­ch"};
    Vector<String> col = new Vector<>(Arrays.asList(column));
    data = new Vector<HoatDong>(); 
    
    DAO dao = new DAO();
    
    List<HoatDong> lsHd = dao.getAll("lshoatdong", HoatDong.class);
    for(HoatDong hd : lsHd) {
    	data.add(hd);
    }
    
    dao.SQL("select l.*, tab.hoten\r\n" + 
    		"from lshoatdong l left join (select th.mahoatdong, th.cmnd, tt.hoten\r\n" + 
    		"from thue_nhavanhoa th, tt_canhan tt\r\n" + 
    		"where th.cmnd = tt.cmnd) as tab\r\n" + 
    		"on l.stt = tab.mahoatdong");
    String hoten = null;
    int index = 0;
    while (dao.next()) {
    	try {
    		hoten = dao.getColumn("hoten") + "";
    	} catch (NullPointerException e) {
    	}
    	if (hoten.equals("null")) {
    		enable[index] = false;
    		hoten = "Tổ dân phố";
    	}
    	else {
    		enable[index] = true;
    	}
    	rowVt.add(new String[] {
    			dao.getColumn("stt"),
    			dao.getColumn("tenhd"),
    			hoten,
    			dao.getColumn("tg_batdau"),
    			dao.getColumn("tg_ketthuc"),
    			dao.getColumn("mucdich")
    	});
    	tableModel.addRow(rowVt.lastElement());
    	index++;
    }
    contentPane.setLayout(null);
    
    table = new JTable();
    //table = new JTable(data, col);
    
    table.setBounds(30, 40, 200, 300);
    JScrollPane sp = new JScrollPane(table);
    table.setRowHeight(20);
    table.setModel(tableModel);
    sp.setBounds(10, 90, 784, 327);
    contentPane.add(sp);
    
    JTextField txtQunLLch = new JTextField();
    txtQunLLch.setFont(new Font("Tahoma", Font.PLAIN, 13));
    txtQunLLch.setBorder(null);
    txtQunLLch.setBackground(SystemColor.menu);

    txtQunLLch.setText("QUẢN LÝ LỊCH SỬ HOẠT ĐỘNG");
    txtQunLLch.setBounds(300, 23, 225, 28);

    contentPane.add(txtQunLLch);
    txtQunLLch.setColumns(10);
    
    textField = new JTextField();
    textField.setBorder(null);
    textField.setBackground(SystemColor.menu);
    textField.setForeground(Color.RED);
    textField.setFont(new Font("Tahoma", Font.ITALIC, 10));
    textField.setBounds(249, 61, 335, 19);
    contentPane.add(textField);
    textField.setColumns(10);
    
    contentPane.setVisible(true);
    
    onListener();
  }
}
