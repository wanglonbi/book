package com.haoqianji.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class BorrowerManageInterFrm extends JInternalFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4970125727536460013L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowerManageInterFrm frame = new BorrowerManageInterFrm();
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
	public BorrowerManageInterFrm() {
		setBounds(100, 100, 450, 300);

	}

}
