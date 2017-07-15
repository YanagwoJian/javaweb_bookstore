package gui;

import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.distinguish.ScreenShotWindow;

public class NorthPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton b1, b2, b3, b4, b5;
	ScreenShotWindow ssw;
	
	public NorthPanel() {
		
		b1 = new JButton("中文识别");
		b2 = new JButton("英文识别");
		b3 = new JButton("新建存储");
		b4 = new JButton("选择存储编号");
		b5 = new JButton("整本导出");
		
		b1.setMnemonic(KeyEvent.VK_C);
		b2.setMnemonic(KeyEvent.VK_E);
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		
		//中文识别
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						try {
							ssw = new ScreenShotWindow(1);
							ssw.setVisible(true);
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		//英文识别
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						try {
							ssw = new ScreenShotWindow(2);
							ssw.setVisible(true);
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		//新建
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NewJDialog njd = new NewJDialog();
				njd.setModalityType(ModalityType.APPLICATION_MODAL);
				njd.setVisible(true);
			}
		});
		
		//选择存储编号
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectJDialog sjd = new SelectJDialog();
				sjd.setModalityType(ModalityType.APPLICATION_MODAL);
				sjd.setVisible(true);
			}
		});
		
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CompleteJFrame cjf = new CompleteJFrame();
				cjf.setVisible(true);
			}
		});
		
	}
	
}
