package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class CompleteJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton jb1, jb2, jb3, jb4;
	JTextField jtf1, jtf2;
	JFileChooser jfc;
	JPanel jp;
	File f;
	String path1, path2;
	
	public CompleteJFrame() {
		jb1 = new JButton("选择文件");
		jb2 = new JButton("确定");
		jb3 = new JButton("取消");
		jb4 = new JButton("保存路径");
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jfc = new JFileChooser();
		jp = new JPanel();
		
	   	this.setLocation(500, 300);
    	this.setSize(380, 220);
    	this.add(jp);
		jp.setLayout(null);
		
    	jtf1.setBounds(30, 30, 160, 30);
    	jb1.setBounds(210, 30, 80, 30);
    	jb2.setBounds(30, 130, 80, 30);
    	jb3.setBounds(170, 130, 80, 30);
    	jtf2.setBounds(30, 80, 160, 30);
    	jb4.setBounds(210, 80, 80, 30);
		
		jp.add(jtf1);
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jtf2);
		jp.add(jb4);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent e) {
				jfc = new JFileChooser();
				//文件过滤器
				PdfFileFilter pff = new PdfFileFilter();
				jfc.setAcceptAllFileFilterUsed(false);
				jfc.addChoosableFileFilter(pff);
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int flag = jfc.showDialog(null, "选择");
				//获取文件路径
				if(flag == JFileChooser.APPROVE_OPTION) {
					f = jfc.getSelectedFile();
					path1 = f.getPath();
				}
				jtf1.setText(path1);
			}
		});
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(path1 != null) {
					File pdfFile = new File(path1);
					PDDocument document = null;
			        try
			        {
			            document = PDDocument.load(pdfFile);
			            // 获取页码
			            int pages = document.getNumberOfPages();
			            // 读文本内容
			            PDFTextStripper stripper = new PDFTextStripper();
			            // 设置按顺序输出
			            stripper.setSortByPosition(true);
			            stripper.setStartPage(1);
			            stripper.setEndPage(pages);
			            String content = stripper.getText(document);
			            File f = new File("e:/1.txt");
			            if(!f.exists()){
			     		    f.createNewFile();
			            }
			            FileWriter fileWriter = new FileWriter(f);
			            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			            bufferWriter.write(content);
			            bufferWriter.close(); 
			            fileWriter.close();
			            
			            if(path2 != null) {
				            File saveFile = new File(path2 + "/wo.txt");
				            if(!saveFile.exists()){
				     		    saveFile.createNewFile();
				            }
				            FileWriter fileWriter2 = new FileWriter(saveFile);
				            BufferedWriter bufferWriter2 = new BufferedWriter(fileWriter2);
				            bufferWriter2.write(content);
				            bufferWriter2.close(); 
				            fileWriter2.close();
			            }
			            
			            SouthPanel.b = true;
			        }
			        catch(Exception ee)
			        {
			            ee.printStackTrace();
			        }
				}
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		jb4.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent e) {
				jfc = new JFileChooser();
				//文件过滤器
				PdfFileFilter pff = new PdfFileFilter();
				jfc.setAcceptAllFileFilterUsed(false);
				jfc.addChoosableFileFilter(pff);
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int flag = jfc.showDialog(null, "选择");
				//获取文件路径
				if(flag == JFileChooser.APPROVE_OPTION) {
					f = jfc.getSelectedFile();
					path2 = f.getPath();
				}
				jtf2.setText(path2);
			}
		});
		
	}
	
}


class PdfFileFilter extends FileFilter {

	@Override
	public boolean accept(File f) {
		String name = f.getName();
		if(name.toLowerCase().endsWith(".pdf"))
			return true;
		return f.isDirectory();
	}

	@Override
	public String getDescription() {
		return ".pdf";
	}
	
}




