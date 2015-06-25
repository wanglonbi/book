package com.haoqianji.view;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import com.haoqianji.dao.UserDao;
import com.haoqianji.model.User;
import com.haoqianji.util.DbUtil;
import com.haoqianji.util.StringUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;

public class LogOnFrm extends JFrame {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1328295591356900559L;
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u9646");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

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

		
//		/Users/haoqianji/Workspaces/MyEclipse Professional 2014/BookManager/
		// 设置Frame居中显示
		this.setLocationRelativeTo(null);

		contentPane.setLayout(null);

		
		
//		new ImageIcon(getClass().getResource("resources/logon_book.png"))
		
		
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon("resources/logon_book.png"));
		lblNewLabel.setFont(new Font("Apple Braille", Font.PLAIN, 20));
		lblNewLabel.setBounds(85, 6, 265, 64);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("   用户名:");
		label.setIcon(new ImageIcon("resources/username.png"));
		
		label.setBounds(37, 89, 103, 28);
		contentPane.add(label);

		JLabel label_1 = new JLabel("   密   码:");
		label_1.setIcon(new ImageIcon("resources/password.png"));
		
		
		
		
		label_1.setBounds(37, 143, 120, 32);
		contentPane.add(label_1);

		userNameTxt = new JTextField();
		userNameTxt.setBounds(132, 89, 134, 28);
		contentPane.add(userNameTxt);
		userNameTxt.setColumns(10);

		JButton jb_logon = new JButton("\u767B\u9646");
		jb_logon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameTxt.getText();

				// System.out.println(userName);

				char[] passWord = passwordTxt.getPassword();

				// for (int i=0;i<passWord.length;i++)
				// System.out.println(passWord[i]);

				String password = StringUtil.chartoString(passWord);

				// String a = passWord.toString();
				// System.out.print(a);
				// System.out.println(password);

				if (StringUtil.isEmpty(userName)) {
					JOptionPane.showMessageDialog(null, "用户名不能为空", null,
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (StringUtil.isEmpty(password)) {
					JOptionPane.showMessageDialog(null, "密码不能为空", null,
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				User user = new User(userName, password);
				Connection con = null;
				try {
					con = dbUtil.getCon();
					User currentUser = userDao.login(con, user);
					if (currentUser != null) {
						JOptionPane.showMessageDialog(null, "登陆成功", null,
								JOptionPane.DEFAULT_OPTION);
						// new Frm().setVisible(true);
						new MainFrm().setVisible(true);
						LogOnFrm.this.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "登陆失败", null,
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "登陆失败", null,
							JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "登陆失败", null,
							JOptionPane.ERROR_MESSAGE);
				} finally {
					try {
						dbUtil.closeCon(con);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		jb_logon.setBounds(90, 217, 83, 29);
		contentPane.add(jb_logon);

		JButton jb_reset = new JButton("\u91CD\u7F6E");
		jb_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userNameTxt.setText("");
				passwordTxt.setText("");
			}
		});
		jb_reset.setBounds(216, 217, 83, 29);
		contentPane.add(jb_reset);
		passwordTxt = new JPasswordField();
		passwordTxt.setBounds(132, 146, 134, 28);
		contentPane.add(passwordTxt);
	}
}
