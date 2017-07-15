package gui.distinguish;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JWindow;

import gui.SouthPanel;

public class ToolsWindow extends JWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScreenShotWindow screenShotWindow;

	public ToolsWindow(ScreenShotWindow screenShotWindow, int x, int y) {
		this.screenShotWindow = screenShotWindow;
		this.init();
		//将组件移到（x，y）的位置
		this.setLocation(x, y);
		//调整窗口的大小来适应控件
		this.pack();
		this.setVisible(true);
	}
	
	private void init() {
		this.setLayout(new BorderLayout());
		JToolBar toolBar = new JToolBar();
		
		//确定按钮
		ImageIcon saveIcon = new ImageIcon("images/Save.jpg");
		//设置图片按钮大小
		saveIcon.setImage(saveIcon.getImage().getScaledInstance(50, 50,  
                Image.SCALE_DEFAULT));
		JButton sureButton = new JButton(saveIcon);
		sureButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(screenShotWindow.getI() == 1) {
					try {
						screenShotWindow.distinguishCh();
						SouthPanel.b = true;
					}catch(IOException ioe) {
						ioe.printStackTrace();
					}
				}
				if(screenShotWindow.getI() == 2) {
					try {
						screenShotWindow.distinguishEn();
						SouthPanel.b = true;
					}catch(IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		});
		toolBar.add(sureButton);
		
		//取消按钮
		ImageIcon closeIcon = new ImageIcon("images/close.png");
		closeIcon.setImage(closeIcon.getImage().getScaledInstance(50, 50,  
                Image.SCALE_DEFAULT));
		JButton closedButton = new JButton(closeIcon);
		closedButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				screenShotWindow.dispose();
				dispose();
			}
		});
		toolBar.add(closedButton);
		
		this.add(toolBar, BorderLayout.NORTH);
	}

}
