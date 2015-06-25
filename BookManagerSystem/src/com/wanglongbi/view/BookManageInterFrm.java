package com.haoqianji.view;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.haoqianji.model.BookType;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class BookManageInterFrm extends JInternalFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 461968682398782371L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	public BookManageInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 863, 504);
		getContentPane().setLayout(null);
		
		JPanel panelForBookSearch = new JPanel();
		panelForBookSearch.setBorder(new TitledBorder(null, "\u641C\u7D22\u64CD\u4F5C", TitledBorder.LEADING, 
				TitledBorder.TOP, null, null));
		panelForBookSearch.setToolTipText("");
		panelForBookSearch.setBounds(6, 6, 827, 102);
		getContentPane().add(panelForBookSearch);
		panelForBookSearch.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(95, 41, 69, 28);
		panelForBookSearch.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 41, 69, 28);
		panelForBookSearch.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox<BookType> comboBox = new JComboBox<BookType>();
		comboBox.setBounds(562, 43, 116, 27);
		panelForBookSearch.add(comboBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setBounds(382, 43, 45, 23);
		panelForBookSearch.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("女");
		rdbtnNewRadioButton_1.setBounds(439, 43, 51, 23);
		panelForBookSearch.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel = new JLabel("图书名称：");
		lblNewLabel.setBounds(26, 30, 69, 50);
		panelForBookSearch.add(lblNewLabel);
		
		JLabel label = new JLabel("作者：");
		label.setBounds(177, 30, 39, 50);
		panelForBookSearch.add(label);
		
		JLabel label_2 = new JLabel("作者性别：");
		label_2.setBounds(309, 30, 73, 50);
		panelForBookSearch.add(label_2);
		
		JLabel label_3 = new JLabel("图书类别：");
		label_3.setBounds(502, 30, 65, 50);
		panelForBookSearch.add(label_3);
		
		JButton button = new JButton("搜索");
		button.setBounds(719, 42, 85, 29);
		panelForBookSearch.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 114, 827, 152);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setPreferredScrollableViewportSize(new Dimension(550, 30));
		scrollPane.setColumnHeaderView(table);
		
		JPanel panelForBookManage = new JPanel();
		panelForBookManage.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", 
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelForBookManage.setBounds(6, 268, 827, 182);
		getContentPane().add(panelForBookManage);
		panelForBookManage.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(112, 49, 69, 28);
		panelForBookManage.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(232, 49, 69, 28);
		panelForBookManage.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(353, 49, 69, 28);
		panelForBookManage.add(textField_5);
		
		JComboBox<BookType> comboBox_1 = new JComboBox<BookType>();
		comboBox_1.setBounds(313, 113, 109, 27);
		panelForBookManage.add(comboBox_1);
		
		JRadioButton radioButton = new JRadioButton("男");
		radioButton.setBounds(112, 113, 45, 23);
		panelForBookManage.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("女");
		radioButton_1.setBounds(169, 113, 51, 23);
		panelForBookManage.add(radioButton_1);
		
		JLabel label_4 = new JLabel("图书名称：");
		label_4.setBounds(50, 38, 73, 50);
		panelForBookManage.add(label_4);
		
		JLabel label_5 = new JLabel("作者：");
		label_5.setBounds(198, 38, 73, 50);
		panelForBookManage.add(label_5);
		
		JLabel label_6 = new JLabel("价格：");
		label_6.setBounds(313, 38, 73, 50);
		panelForBookManage.add(label_6);
		
		JLabel label_7 = new JLabel("作者性别：");
		label_7.setBounds(50, 100, 73, 50);
		panelForBookManage.add(label_7);
		
		JLabel label_8 = new JLabel("图书类别：");
		label_8.setBounds(242, 100, 73, 50);
		panelForBookManage.add(label_8);
		
		JButton button_1 = new JButton("修改");
		button_1.setBounds(673, 59, 117, 29);
		panelForBookManage.add(button_1);
		
		JButton button_2 = new JButton("删除");
		button_2.setBounds(673, 100, 117, 29);
		panelForBookManage.add(button_2);
		
		JLabel label_9 = new JLabel("描述：");
		label_9.setBounds(443, 55, 39, 16);
		panelForBookManage.add(label_9);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(478, 53, 167, 93);
		panelForBookManage.add(textArea);

	}
}
