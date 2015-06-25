package com.haoqianji.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.haoqianji.dao.BookDao;
import com.haoqianji.dao.BookTypeDao;
import com.haoqianji.model.BookType;
import com.haoqianji.util.DbUtil;
import com.haoqianji.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EtchedBorder;

import java.awt.Color;

public class BookTypeManageInterFrm extends JInternalFrame {

	/**
	 * define the attributes
	 */
	private static final long serialVersionUID = 1606233235081198318L;
	private JTextField bookTypeNameTxt;
	private JTable bookTypeTable;
	private JPanel panelForTable;
	private JScrollPane scrollPane;
	private DbUtil dbUtil;
	private BookTypeDao bookTypeDao;
	private BookDao bookDao;
	private String bookTypeName;
	private String bookTypeDesc;
	private String id;
	private BookType bookType;
	private ArrayList<BookType> bookTypes;
	private JTextField bookTypeNameEditTxt;
	private JTextArea bookTypeDescEditTxt;
	private JTextField idTxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * fill the Book type bookTypeTable
	 */

	private void resetEditTxt() {
		idTxt.setText("");
		bookTypeNameEditTxt.setText("");
		bookTypeDescEditTxt.setText("");
	}

	private void fillBookTypeTable() {
		bookTypeTable = new JTable();
	
		scrollPane.setViewportView(bookTypeTable);
		bookTypeTable.setPreferredScrollableViewportSize(new Dimension(550, 30));
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("类别名");
		defaultTableModel.addColumn("类别描述");
		bookTypeName = "";
		bookTypeDesc = "";
		bookTypeName = bookTypeNameTxt.getText();
		if (bookTypeName == null)
			bookTypeName = "";
		bookTypes = new ArrayList<BookType>();
		bookType = new BookType(bookTypeName, bookTypeDesc);
		Connection con = null;
		dbUtil = new DbUtil();
		bookTypeDao = new BookTypeDao();
		try {
			con = dbUtil.getCon();
			bookTypes = bookTypeDao.bookTypeSearch(con, bookType);
			java.util.Iterator<BookType> it = bookTypes.iterator();
			while (it.hasNext()) {
				Vector<String> bookTypeVector = new Vector<String>();
				BookType bookType = (BookType) it.next();
				bookTypeVector.add("" + bookType.getId());
				bookTypeVector.add(bookType.getBookTypeName());
				bookTypeVector.add(bookType.getBookTypeDesc());
				defaultTableModel.addRow(bookTypeVector);
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
		bookTypeTable = new JTable(defaultTableModel);
		resetEditTxt();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = bookTypeTable.getSelectedRow();
				idTxt.setText((String) bookTypeTable.getValueAt(row, 0));
				bookTypeNameEditTxt.setText((String) bookTypeTable.getValueAt(
						row, 1));
				bookTypeDescEditTxt.setText((String) bookTypeTable.getValueAt(
						row, 2));
			}
		});
		scrollPane.setViewportView(bookTypeTable);
		bookTypeTable
				.setPreferredScrollableViewportSize(new Dimension(550, 30));
	}

	/**
	 * Create the frame.
	 */
	public BookTypeManageInterFrm() {
		setIconifiable(true);

		setTitle("图书类别维护");
		setClosable(true);
		setBounds(100, 100, 490, 457);
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

		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setBounds(159, 18, 134, 28);
		getContentPane().add(bookTypeNameTxt);
		bookTypeNameTxt.setColumns(10);

		JButton jb_bookTypeSearch = new JButton("搜索");
		jb_bookTypeSearch.setBounds(332, 19, 89, 29);
		getContentPane().add(jb_bookTypeSearch);

		JLabel lblNewLabel = new JLabel("图书类别名称：");
		lblNewLabel.setBounds(51, 24, 96, 16);
		getContentPane().add(lblNewLabel);

		panelForTable = new JPanel();
		panelForTable.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), 
						"\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, 
						TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		panelForTable.setBounds(51, 183, 364, 194);
		getContentPane().add(panelForTable);
		panelForTable.setLayout(null);

		bookTypeDescEditTxt = new JTextArea();
		bookTypeDescEditTxt.setBounds(116, 57, 211, 116);
		panelForTable.add(bookTypeDescEditTxt);

		bookTypeNameEditTxt = new JTextField();
		bookTypeNameEditTxt.setBounds(241, 17, 91, 28);
		panelForTable.add(bookTypeNameEditTxt);
		bookTypeNameEditTxt.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("图书类别名称：");
		lblNewLabel_1.setBounds(150, 23, 91, 16);
		panelForTable.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("图书类别描述：");
		lblNewLabel_2.setBounds(23, 57, 91, 16);
		panelForTable.add(lblNewLabel_2);

		JButton jb_bookTypeDelete = new JButton("删除");
		jb_bookTypeDelete.setBounds(23, 126, 74, 28);
		JButton jb_bookTypeUpdate = new JButton("修改");
		panelForTable.add(jb_bookTypeDelete);
		jb_bookTypeUpdate.setBounds(23, 95, 74, 29);
		panelForTable.add(jb_bookTypeUpdate);

		/**
		 * Delete the Book type
		 */
		jb_bookTypeDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbUtil = new DbUtil();
				bookTypeDao = new BookTypeDao();
				Connection con = null;
				
				int n = JOptionPane.showConfirmDialog(null, "确定删除该书籍类型吗？");
				if(n == 0){
					try {
						con = dbUtil.getCon();
						id = idTxt.getText();
						bookDao = new BookDao();
						boolean flag = bookDao.getBookByBookTypeId(con, Integer.parseInt(id));
						System.out.println(flag);
						if(flag){
							JOptionPane.showMessageDialog(null, "所要删除的书籍类型包含的图书数不为零，如要删除，请先删除相关图书！！",
									null, JOptionPane.WARNING_MESSAGE);
							return;
						} else {
							;
						}
		
						if (StringUtil.isEmpty(id)) {
							JOptionPane.showMessageDialog(null, "未选中要删除的书籍类型",
									null, JOptionPane.WARNING_MESSAGE);
							return;
						} else {
							;
						}
						int flag1 = bookTypeDao.bookTypeDelete(con, id);
						if (flag1 > 0) {
							JOptionPane.showMessageDialog(null, "书籍类型删除成功", null,
									JOptionPane.DEFAULT_OPTION);
							return;
						} else {
							JOptionPane.showMessageDialog(null, "书籍类型删除失败", null,
									JOptionPane.WARNING_MESSAGE);
							return;
						}
	
					} catch (ClassNotFoundException | SQLException e2) {
						JOptionPane.showMessageDialog(null, "书籍类型删除失败", null,
								JOptionPane.WARNING_MESSAGE);
						e2.printStackTrace();
	
					} finally {
						try {
							dbUtil.closeCon(con);
							fillBookTypeTable();
							resetEditTxt();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});

		/**
		 * modify the Book type
		 */
		jb_bookTypeUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dbUtil = new DbUtil();
				bookTypeDao = new BookTypeDao();
				Connection con = null;
				try {
					con = dbUtil.getCon();
					id = "";
					bookTypeName = "";
					bookTypeDesc = "";
					id = idTxt.getText();
					bookTypeName = bookTypeNameEditTxt.getText();
					bookTypeDesc = bookTypeDescEditTxt.getText();

					if (StringUtil.isEmpty(id)) {
						JOptionPane.showMessageDialog(null, "未选中要修改的书籍类型",
								null, JOptionPane.WARNING_MESSAGE);
						return;
					} else if (StringUtil.isEmpty(bookTypeName)) {
						JOptionPane.showMessageDialog(null, "修改后的书籍类型名不能为空",
								null, JOptionPane.WARNING_MESSAGE);
						return;
					} else if (StringUtil.isEmpty(bookTypeDesc)) {
						JOptionPane.showMessageDialog(null, "修改后的书籍类型描述不能为空",
								null, JOptionPane.WARNING_MESSAGE);
						return;
					}

					bookType = new BookType(bookTypeName, bookTypeDesc);
					bookType.setId(Integer.parseInt(id));
					int flag = bookTypeDao.bookTypeModify(con, bookType);

					if (flag > 0) {
						JOptionPane.showMessageDialog(null, "书籍类型修改成功", null,
								JOptionPane.DEFAULT_OPTION);
						return;
					} else {
						JOptionPane.showMessageDialog(null, "书籍类型修改失败", null,
								JOptionPane.WARNING_MESSAGE);
						return;
					}

				} catch (ClassNotFoundException | SQLException e2) {
					JOptionPane.showMessageDialog(null, "书籍类型修改失败", null,
							JOptionPane.WARNING_MESSAGE);
					e2.printStackTrace();

				} finally {
					try {
						dbUtil.closeCon(con);
						fillBookTypeTable();
						resetEditTxt();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				fillBookTypeTable();
			}
		});

		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setBounds(72, 17, 74, 28);
		panelForTable.add(idTxt);
		idTxt.setColumns(10);

		JLabel lblid = new JLabel("ID:");
		lblid.setBounds(38, 23, 24, 16);
		panelForTable.add(lblid);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 58, 364, 113);
		getContentPane().add(scrollPane);

		fillBookTypeTable();

		/**
		 * search for the Book type
		 */
		jb_bookTypeSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillBookTypeTable();
			}
		});

	}
}
