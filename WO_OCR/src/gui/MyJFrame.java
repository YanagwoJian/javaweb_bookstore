package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import sql.dao.PDFDao;

public class MyJFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	static int pdfID; 
	static String title;
	static String author;
	SouthPanel southPanel;
	NorthPanel northPanel;
	CenterPanel centerPanel;
	
	
	public static void main(String[] args) {
		//java的GUI都是的单线程，应该使用事件调度线程去执行，
		//如果没意识使用事件调度线程的话，可能造成死锁。但是在小的程序中，
		//这种现象（死锁）不会发生的；大的应用程序中才会出现这种现象!
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MyJFrame frame = new MyJFrame();
					frame.setVisible(true);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MyJFrame() {
		
		pdfID = getPDFID();
		titleAndAuthor();
		this.setTitle("pdf2txt");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					if(SouthPanel.b == true) {
						if(southPanel == null) {							
							southPanel = new SouthPanel();
						}
						else {
							remove(southPanel);
							southPanel = new SouthPanel();
						}
						add(BorderLayout.SOUTH, southPanel);
						SouthPanel.b = false;
						//重新刷新组件
						validate();
					}
					if(CenterPanel.b == true) {
						if(centerPanel == null) {							
							centerPanel = new CenterPanel(title, author);
						}
						else {
							remove(centerPanel);
							centerPanel = new CenterPanel(title, author);
						}
						add(BorderLayout.CENTER, centerPanel);
						CenterPanel.b = false;
						//重新刷新组件
						validate();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		northPanel = new NorthPanel();
		
        createMenuBar();
		
		add(BorderLayout.NORTH, northPanel);
		
		//退出程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(new Dimension(700, 1000));
        setLocation(300, 30);
        
        //禁止窗口放大缩小
        setResizable(false);
				
		//显示
		setVisible(true);
	}	
	
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu jm1 = new JMenu("文件");
        JMenu jm2 = new JMenu("帮助");
        JMenuItem jmi1 = new JMenuItem("打开");
        JMenuItem jmi2 = new JMenuItem("退出");
        JMenuItem jmi3 = new JMenuItem("主题");
        JMenuItem jmi4 = new JMenuItem("关于");
        
        jm1.add(jmi1);
        jm1.addSeparator();
        jm1.add(jmi2);
        
        jm2.add(jmi3);
        jm2.addSeparator();
        jm2.add(jmi4);
        
        menuBar.add(jm1);
        menuBar.add(jm2);
        
        jmi1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewJDialog vjd = new ViewJDialog();
				vjd.setModalityType(ModalityType.APPLICATION_MODAL);
				vjd.setVisible(true);
			}
		});
        
        this.setJMenuBar(menuBar);
    }	
	
    //获取最后一本pdf书籍的id
    private int getPDFID() {
    	int id = 1;
		try {
			PDFDao pdfDao = new PDFDao();
			ResultSet rs = pdfDao.lastPDF();
			while(rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return id;
    }
    
    private void titleAndAuthor() {
		try {
			PDFDao pdfDao = new PDFDao();
			ResultSet rs = pdfDao.pdfMess(pdfID);
			while(rs.next()) {
				title = rs.getString("title");
				author = rs.getString("author");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
}
