package gui;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class SouthPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static boolean b = true;

	MyJTextArea mjta;
	JScrollPane jsp;
	Font font;
	
	public SouthPanel() {
		
		font = new Font("宋体",Font.PLAIN,21);
		//行，列
		mjta = new MyJTextArea(35,60);
		mjta.setFont(font);
		mjta.setBorder(new LineBorder(Color.blue));
		//设置自动换行
		mjta.setLineWrap(true);
		jsp = new JScrollPane(mjta);
		
		display();
		
		this.add(jsp);
		
	}
	
	public void display() {
		BufferedReader br=null; 
		try { 
			File f = new File("e:/1.txt");
			if(!f.exists()) {
				f.createNewFile();
			}
			br=new BufferedReader(new FileReader(f)); 
			String str; 
			while((str=br.readLine())!=null){ 
				mjta.append(str);
				mjta.append("\r\n");
			}
			f.deleteOnExit();
		} catch (FileNotFoundException e) { 
			e.printStackTrace(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		}finally{ 
			try { 
				if(br!=null) 
				br.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
		}
	}	

	
}
