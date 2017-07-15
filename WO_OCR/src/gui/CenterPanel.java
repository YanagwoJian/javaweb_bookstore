package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CenterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean b = true;
	
	String title;
	String author;
	JLabel jlb1;
	JLabel jlb2;
	
	public CenterPanel(String title, String author) {
		this.title = title;
		this.author = author;
		jlb1 = new JLabel("书名：" + title);
		jlb2 = new JLabel("作者：" + author);
		add(jlb1);
		add(jlb2);
	}
	
}
