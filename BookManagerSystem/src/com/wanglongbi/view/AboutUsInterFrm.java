package com.haoqianji.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AboutUsInterFrm extends JInternalFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2461902378900423932L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUsInterFrm frame = new AboutUsInterFrm();
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
	public AboutUsInterFrm() {
		setBounds(100, 100, 450, 300);

	}

}
