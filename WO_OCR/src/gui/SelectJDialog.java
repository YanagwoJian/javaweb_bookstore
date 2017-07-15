package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


import sql.dao.PDFDao;

public class SelectJDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PDFDao pdfDao;
	ResultSet rs;
	
	
	public SelectJDialog() {
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
		setTitle("选择存储编号");
		setLocation(360, 200);
		setSize(new Dimension(500, 520));
		setResizable(false);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(jtf.getText());
				pdfDao = new PDFDao();
				rs = pdfDao.hasID(id);
				try {
					if(rs.next()) {
						MyJFrame.pdfID = rs.getInt("id");
						MyJFrame.title = rs.getString("title");
						MyJFrame.author = rs.getString("author");
						CenterPanel.b = true;
						JOptionPane.showMessageDialog(null, "设置成功");
						jtf.setText(null);
					}else {
						JOptionPane.showMessageDialog(null, "设置失败");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}

}
