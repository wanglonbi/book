package com.haoqianji.view;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.util.Enumeration;

public class MainFrm extends JFrame {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5307195617146393351L;
	private JPanel contentPane;
	JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 319);
		this.setExtendedState(MAXIMIZED_BOTH);
		// this.setSize(1000,800);

		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("dds");
		setJMenuBar(menuBar);
		menuBar.setBackground(Color.LIGHT_GRAY);

		/*
		 * 基本数据维护
		 */
		JMenu mntmNewMenu1 = new JMenu("基本数据维护");
		mntmNewMenu1.setBackground(Color.LIGHT_GRAY);
		// mntmNewMenu1.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mntmNewMenu1);

		/*
		 * 基本数据维护->图书类别管理
		 */
		JMenu mntmNewMenu11 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		mntmNewMenu1.add(mntmNewMenu11);

		/*
		 * 基本数据维护->图书类别管理->添加图书类别
		 */
		JMenuItem jmiBookTypeAdd = new JMenuItem(
				"\u6DFB\u52A0\u56FE\u4E66\u7C7B\u522B");
		jmiBookTypeAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeAddInterFrm = new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
			}
		});
		mntmNewMenu11.add(jmiBookTypeAdd);

		/*
		 * 基本数据维护->图书类别管理->维护图书类别
		 */
		JMenuItem jmiBookTypeManage = new JMenuItem(
				"\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		jmiBookTypeManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManageInterFrm bookTypeManageInterFrm = new BookTypeManageInterFrm();
				bookTypeManageInterFrm.setVisible(true);
				table.add(bookTypeManageInterFrm);
			}
		});
		mntmNewMenu11.add(jmiBookTypeManage);

		/*
		 * 基本数据维护->图书管理
		 */
		JMenu mntmNewMenu12 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		mntmNewMenu1.add(mntmNewMenu12);
		/*
		 * 基本数据维护->图书管理->添加图书
		 */
		JMenuItem mntmNewMenuItem121 = new JMenuItem("\u6DFB\u52A0\u56FE\u4E66");
		mntmNewMenuItem121.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm = new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
		mntmNewMenu12.add(mntmNewMenuItem121);
		/*
		 * 基本数据维护->图书管理->维护图书
		 */
		JMenuItem mntmNewMenuItem122 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		mntmNewMenuItem122.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInterFrm bookManageInterFrm = new BookManageInterFrm();
				bookManageInterFrm.setVisible(true);
				table.add(bookManageInterFrm);
			}
		});
		
		mntmNewMenu12.add(mntmNewMenuItem122);
		
		JMenu mntmNewMenu13 = new JMenu("会员管理");
		mntmNewMenu1.add(mntmNewMenu13);
		
		JMenuItem mntmNewMenuItem131 = new JMenuItem("添加会员");
		mntmNewMenuItem131.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}	
		});
		mntmNewMenu13.add(mntmNewMenuItem131);
		
		JMenuItem mntmNewMenuItem132 = new JMenuItem("会员信息维护");
		mntmNewMenuItem132.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenu13.add(mntmNewMenuItem132);

		JMenu mntmNewMenu2 = new JMenu("\u9009\u9879");
		mntmNewMenu2.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mntmNewMenu2);
		JMenuItem mntmNewMenuItem21 = new JMenuItem("借书");
		mntmNewMenuItem21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenu2.add(mntmNewMenuItem21);
		JMenuItem mntmNewMenuItem22 = new JMenuItem("还书");
		mntmNewMenuItem22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenu2.add(mntmNewMenuItem22);
		JMenu mntmNewMenu4 = new JMenu("关于");
		mntmNewMenu4.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mntmNewMenu4);
		JMenuItem mntmNewMenuItem41 = new JMenuItem("关于我们");
		mntmNewMenuItem41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenu4.add(mntmNewMenuItem41);
		JMenuItem mntmNewMenuItem42 = new JMenuItem("帮助");
		mntmNewMenuItem42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmNewMenu4.add(mntmNewMenuItem42);

		JMenu mntmNewMenu3 = new JMenu("退出");
		mntmNewMenu3.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mntmNewMenu3);
		JMenuItem mntmNewMenuItem31_exit = new JMenuItem("关闭系统");
		mntmNewMenuItem31_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				/*
				 * 0 yes 1 no 2 cancel
				 */
				// System.out.print(result);
				if (result == 0)
					MainFrm.this.dispose();
				// else
				// System.exit(1);
			}
		});

		mntmNewMenu3.add(mntmNewMenuItem31_exit);
		table = new JDesktopPane();
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(0, 0, 1362, 584);
		contentPane.add(table);

	}
}
