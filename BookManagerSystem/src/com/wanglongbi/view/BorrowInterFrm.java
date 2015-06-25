package com.haoqianji.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class BorrowInterFrm extends JInternalFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 255065831639282439L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowInterFrm frame = new BorrowInterFrm();
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
	public BorrowInterFrm() {
		setBounds(100, 100, 450, 300);

	}

}
