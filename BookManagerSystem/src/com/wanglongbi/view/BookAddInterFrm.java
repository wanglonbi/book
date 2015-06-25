package com.haoqianji.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import com.haoqianji.dao.BookDao;
import com.haoqianji.dao.BookTypeDao;
import com.haoqianji.model.Book;
import com.haoqianji.model.BookType;
import com.haoqianji.util.DbUtil;
import com.haoqianji.util.StringUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddInterFrm extends JInternalFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4675551731914134050L;


	private JTextField authorTxt;
	private JTextField bookNameTxt;
	private JTextField priceTxt;
	private JTextArea bookDescTxt;
	private JRadioButton maleOption;
	private JRadioButton femaleOption;
	private JComboBox<BookType> comboBoxOfBookType;
	private DbUtil dbUtil;
	private BookDao bookDao;
	private BookTypeDao bookTypeDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void resetEditTxt() {
		bookDescTxt.setText("");
		authorTxt.setText("");
		bookNameTxt.setText("");
		priceTxt.setText("");
		maleOption.setSelected(true);
		femaleOption.setSelected(false);
		comboBoxOfBookType.setSelectedIndex(0);
	}
	
	private void fillJcomboBoxOFBookType() {
		comboBoxOfBookType = new JComboBox<BookType>();
		comboBoxOfBookType.setBackground(Color.LIGHT_GRAY);
		ArrayList<BookType> bookTypes;
		bookTypes = new ArrayList<BookType>();
		Connection con = null;
		dbUtil = new DbUtil();
		bookTypeDao = new BookTypeDao();		
		try {
			con = dbUtil.getCon();		
			bookTypes = bookTypeDao.bookTypeSearch(con,new BookType("","") );
			java.util.Iterator<BookType> it = bookTypes.iterator();

			while (it.hasNext()) {
				BookType bookType = (BookType) it.next();
				comboBoxOfBookType.addItem(bookType);
			}

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
	}

	
	
	
	/**
	 * Create the frame.
	 */
	public BookAddInterFrm() {
		getContentPane().setBackground(Color.GRAY);
		setIconifiable(true);
		setTitle("图书添加");
		setClosable(true);
		setBounds(100, 100, 638, 488);
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
		
		JPanel panelForBookAdd = new JPanel();
		panelForBookAdd.setBackground(Color.GRAY);
		panelForBookAdd.setLayout(null);
		panelForBookAdd.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), 
				"\u56FE\u4E66\u4FE1\u606F\u586B\u5199\u680F", 
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelForBookAdd.setBounds(41, 34, 532, 335);
		getContentPane().add(panelForBookAdd);
		
		authorTxt = new JTextField();
		authorTxt.setBackground(Color.LIGHT_GRAY);
		authorTxt.setText("");
		authorTxt.setColumns(10);
		authorTxt.setBounds(257, 23, 91, 28);
		panelForBookAdd.add(authorTxt);
		
		JLabel label = new JLabel("图书作者：");
		label.setBounds(198, 29, 65, 16);
		panelForBookAdd.add(label);
		
		bookNameTxt = new JTextField();
		bookNameTxt.setBackground(Color.LIGHT_GRAY);
		bookNameTxt.setText("");
		bookNameTxt.setColumns(10);
		bookNameTxt.setBounds(95, 23, 91, 28);
		panelForBookAdd.add(bookNameTxt);
		
		JLabel label_2 = new JLabel("图书名称：");
		label_2.setBounds(35, 29, 65, 16);
		panelForBookAdd.add(label_2);
		
		JLabel label_1 = new JLabel("作者性别：");
		label_1.setBounds(35, 81, 72, 16);
		panelForBookAdd.add(label_1);
		
		maleOption = new JRadioButton("男");
		maleOption.setBounds(111, 77, 57, 23);
		panelForBookAdd.add(maleOption);
		
		femaleOption = new JRadioButton("女");
		femaleOption.setBounds(180, 77, 46, 23);
		panelForBookAdd.add(femaleOption);
		
		maleOption.setSelected(true);
		maleOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				femaleOption.setSelected(false);		
			}
		});
		femaleOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maleOption.setSelected(false);		
			}
		});
		
		
		comboBoxOfBookType = new JComboBox<BookType>();
		fillJcomboBoxOFBookType();
		comboBoxOfBookType.setBounds(343, 77, 138, 27);
		panelForBookAdd.add(comboBoxOfBookType);
		
		JLabel label_3 = new JLabel("图书描述：");
		label_3.setBounds(35, 133, 65, 16);
		panelForBookAdd.add(label_3);
		
		JLabel label_4 = new JLabel("图书价格：");
		label_4.setBounds(360, 29, 65, 16);
		panelForBookAdd.add(label_4);
		
		priceTxt = new JTextField();
		priceTxt.setBackground(Color.LIGHT_GRAY);
		priceTxt.setText("");
		priceTxt.setColumns(10);
		priceTxt.setBounds(419, 23, 91, 28);
		panelForBookAdd.add(priceTxt);
		
		JLabel label_5 = new JLabel("图书类别：");
		label_5.setBounds(268, 81, 72, 16);
		panelForBookAdd.add(label_5);
		
		bookDescTxt = new JTextArea();
		bookDescTxt.setBackground(Color.LIGHT_GRAY);
		bookDescTxt.setBounds(95, 133, 408, 169);
		panelForBookAdd.add(bookDescTxt);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetEditTxt();	
			}
		});
		
		btnNewButton_1.setBounds(378, 393, 100, 29);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dbUtil = new DbUtil();
				bookDao = new BookDao();
				Connection con = null;
				try {
					String name = bookNameTxt.getText();
					String desc = bookDescTxt.getText();
					String author = authorTxt.getText();
					float price;
					String gender = "男";
					if (!femaleOption.getFocusTraversalKeysEnabled())
						gender = "女";
					
					BookType bookType=(BookType)comboBoxOfBookType.getSelectedItem();
					int bookTypeId = bookType.getId();	
					
					String stringOfPrice = priceTxt.getText();
					if(StringUtil.isEmpty(stringOfPrice)){
						JOptionPane.showMessageDialog(null, "图书价格不能为空", null,
								JOptionPane.WARNING_MESSAGE);
						return;
					}else if(StringUtil.isNumeric(stringOfPrice)){
								price = Float.parseFloat(stringOfPrice);
						}else {
							JOptionPane.showMessageDialog(null, "图书价格必须为数字", null,
									JOptionPane.WARNING_MESSAGE);
							return;
						}
					
					
					if(StringUtil.isEmpty(name)){
						JOptionPane.showMessageDialog(null, "图书名不能为空", null,
								JOptionPane.WARNING_MESSAGE);
						return;
					}
					if(StringUtil.isEmpty(desc)){
						JOptionPane.showMessageDialog(null, "图书描述不能为空", null,
								JOptionPane.WARNING_MESSAGE);
						return;
					}
					if(StringUtil.isEmpty(author)){
						JOptionPane.showMessageDialog(null, "作者不能为空", null,
								JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					con = dbUtil.getCon();
					Book book = new Book(name, desc, author, gender,
							price, bookTypeId);
					
					int flag = bookDao.bookAdd(con, book);
					
					
					if (flag > 0) {
						JOptionPane.showMessageDialog(null, "图书添加成功", null,
								JOptionPane.DEFAULT_OPTION);
						return;
					} else {
						JOptionPane.showMessageDialog(null, "书添加删除失败", null,
								JOptionPane.WARNING_MESSAGE);
						return;
					}

				} catch (ClassNotFoundException | SQLException e2) {
					JOptionPane.showMessageDialog(null, "图书添加删除失败", null,
							JOptionPane.WARNING_MESSAGE);
					e2.printStackTrace();

				} finally {
					try {
						dbUtil.closeCon(con);
						resetEditTxt();	
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
	
			}
		});
		btnNewButton.setBounds(235, 393, 100, 29);
		getContentPane().add(btnNewButton);

	}
}
