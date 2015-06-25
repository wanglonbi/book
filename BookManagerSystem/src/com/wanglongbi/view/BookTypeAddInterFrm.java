package com.haoqianji.view;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.UIManager;
import com.haoqianji.dao.BookTypeDao;
import com.haoqianji.model.BookType;
import com.haoqianji.util.DbUtil;
import com.haoqianji.util.StringUtil;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;

public class BookTypeAddInterFrm extends JInternalFrame {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3697835970923300532L;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	DbUtil dbUtil = new DbUtil();
	BookTypeDao bookTypeDao = new BookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void resetValues(){
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
		
	
	/**
	 * Create the frame.
	 */
	public BookTypeAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		// 改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}

		JLabel lblNewLabel = new JLabel(
				"\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(43, 26, 92, 16);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(
				"\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		lblNewLabel_1.setBounds(43, 70, 92, 16);
		getContentPane().add(lblNewLabel_1);

		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setBackground(SystemColor.window);
		bookTypeNameTxt.setBounds(149, 20, 253, 28);
		getContentPane().add(bookTypeNameTxt);
		bookTypeNameTxt.setColumns(10);

		bookTypeDescTxt = new JTextArea();
		bookTypeDescTxt.setBackground(SystemColor.window);
		bookTypeDescTxt.setBounds(149, 70, 253, 109);
		getContentPane().add(bookTypeDescTxt);

		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 定义表单变量
				 */
				String bookTypeName = bookTypeNameTxt.getText();
				String bookTypeDesc = bookTypeDescTxt.getText();

				if (StringUtil.isEmpty(bookTypeName)) {
					JOptionPane.showMessageDialog(null, "书籍类型名不能为空", null,
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (StringUtil.isEmpty(bookTypeDesc)) {
					JOptionPane.showMessageDialog(null, "书籍类型描述不能为空", null,
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				BookType bookType = new BookType(bookTypeName, bookTypeDesc);
				Connection con = null;
				try {
					con = dbUtil.getCon();
					int flag = bookTypeDao.bookTypeAdd(con, bookType);
					resetValues();
					if (flag == 1){
						JOptionPane.showMessageDialog(null, "书籍类型添加成功", null,
								JOptionPane.DEFAULT_OPTION);
						
					}else{
						JOptionPane.showMessageDialog(null, "书籍类型添加失败", null,
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "书籍类型添加失败", null,
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				finally {
					try {
						dbUtil.closeCon(con);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnNewButton.setBounds(243, 206, 65, 29);
		getContentPane().add(btnNewButton);
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValues();
			}
		});
		
		btnNewButton_1.setBounds(326, 206, 65, 29);
		getContentPane().add(btnNewButton_1);
		
	}
}
