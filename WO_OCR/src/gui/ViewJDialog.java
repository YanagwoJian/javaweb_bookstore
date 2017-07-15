package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sql.dao.ContentDao;
import sql.dao.PDFDao;
import sql.model.PDF;
import sql.model.PDFContent;

public class ViewJDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PDFDao pdfDao;
	ResultSet rs;
	
	
	public ViewJDialog() {
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JButton jb1 = new JButton("确定");
		JTextField jtf = new JTextField();
		jtf.setPreferredSize(new Dimension(80, 28));
		DefaultTableModel dtm = new DefaultTableModel(new String[]{"编号","书名","作者"}, 0);
		JTable jt = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(jt);
		
		pdfDao = new PDFDao();
		rs = pdfDao.ShowPDF();
		try {
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("id"));
				v.add(rs.getString("title"));
				v.add(rs.getString("author"));
				dtm.addRow(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		jp1.add(jsp);
		jp2.add(jtf);
		jp2.add(jb1);
		add(jp1, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		setTitle("选择查看编号");
		setLocation(360, 200);
		setSize(new Dimension(500, 520));
		setResizable(false);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(jtf.getText());
				try {
		            File f = new File("e:/1.txt");
		            if(!f.exists()){
						f.createNewFile();
		            }
		            FileWriter fw = new FileWriter(f, true);
		            BufferedWriter bw = new BufferedWriter(fw);
		            
		    		PDFDao pdfDao = new PDFDao();
		    		rs = pdfDao.pdfMess(id);
		    		while(rs.next()) {
		    			bw.append("编号：" + rs.getInt("id") + "\r\n");
		    			bw.append("书名：" + rs.getString("title") + "\r\n");
		    			bw.append("作者：" + rs.getString("author") + "\r\n");
		    		}
		    		ContentDao contentDao = new ContentDao();
		    		PDFContent pdfContent = new PDFContent(id);
		    		rs = contentDao.pdfidExist(pdfContent);
		    		while(rs.next()) {
		    			bw.append("摘要：" + rs.getString("summary") + "\r\n");
		    			bw.append("引言：" + rs.getString("introduction") + "\r\n");
		    			bw.append("内容：" + rs.getString("content") + "\r\n");
		    			bw.append("参考文献：" + rs.getString("reference") + "\r\n");
		    		}
		    		bw.close();
		    		fw.close();
		    		SouthPanel.b = true;
		    		dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}

	
	
}
