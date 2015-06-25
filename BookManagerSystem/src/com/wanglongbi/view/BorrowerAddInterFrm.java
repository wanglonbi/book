package com.haoqianji.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class BorrowerAddInterFrm extends JInternalFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3621816500520355580L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowerAddInterFrm frame = new BorrowerAddInterFrm();
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
	public BorrowerAddInterFrm() {
		setBounds(100, 100, 450, 300);

	}

}
