package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sql.dao.PDFDao;
import sql.model.PDF;

public class NewJDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewJDialog() {
		JPanel jp = new JPanel();
		JLabel newJl1 = new JLabel("书名:");
		JLabel newJl2 = new JLabel("作者:");
		JTextField newJtf1 = new JTextField();
		JTextField newJtf2 = new JTextField();
		JButton newJb1 = new JButton("确定");
		JButton newJb2 = new JButton("取消");
		
    	setLocation(500, 300);
    	setSize(380, 230);
		
		add(jp);
		jp.setLayout(null);
		
    	newJl1.setBounds(30, 30, 100, 30);
    	newJtf1.setBounds(150, 30, 160, 30);
    	newJl2.setBounds(30, 80, 100, 30);
    	newJtf2.setBounds(150, 80, 160, 30);
    	newJb1.setBounds(30, 130, 87, 30);
    	newJb2.setBounds(200, 130, 87, 30);
    	
    	jp.add(newJl1);
    	jp.add(newJl2);
    	jp.add(newJtf1);
    	jp.add(newJtf2);
    	jp.add(newJb1);
    	jp.add(newJb2);
    	
    	newJb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = newJtf1.getText();
				String author = newJtf2.getText();
				PDF pdf = new PDF(title, author);
				PDFDao pdfDao = new PDFDao();
				int result = pdfDao.Insert(pdf);
				if(result == 1) {
					JOptionPane.showMessageDialog(jp, "添加成功");
					newJtf1.setText(null);
					newJtf2.setText(null);
				}else {
					JOptionPane.showMessageDialog(jp, "添加失败");
				}
			}
		});
    	
    	newJb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
    	
	}
}
