package gui;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import sql.dao.ContentDao;
import sql.model.PDFContent;

public class MyJTextArea extends JTextArea implements MouseListener {

	private static final long serialVersionUID = 1L;
	//弹出菜单
	private JPopupMenu jpm;
	private JMenu save;
	private JMenuItem summary, introduction, content, reference;
	private JMenuItem copy, paste, cut;

	public MyJTextArea(int i, int j) {
		super(i, j);
		init();
	}

	private void init() {
		this.addMouseListener(this);
		jpm = new JPopupMenu();
		save = new JMenu("保存");
		summary = new JMenuItem("摘要");
		introduction = new JMenuItem("引言");
		content = new JMenuItem("内容");
		reference = new JMenuItem("参考文献");
		copy = new JMenuItem("复制");
		paste = new JMenuItem("粘贴");
		cut = new JMenuItem("剪切");

		jpm.add(save);
		save.add(summary);
		save.add(introduction);
		save.add(content);
		save.add(reference);
		jpm.add(copy);
		jpm.add(paste);
		jpm.add(cut);
		this.add(jpm);

		summary.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				action(e);
			}
		});
		introduction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				action(e);
			}
		});
		content.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				action(e);
			}
		});
		reference.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				action(e);
			}
		});
		copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				action(e);
			}
		});
		paste.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				action(e);
			}
		});
		cut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				action(e);
			}
		});

	}

	//菜单动作
	public void action(ActionEvent e) {
		String s = e.getActionCommand();
		ContentDao contentDao = new ContentDao();
		ResultSet rs;
		PDFContent pdfContent;
		String text = null;
		int result, i;
		if (s.equals(summary.getText())) {
			text = this.getSelectedText();
			pdfContent = new PDFContent(MyJFrame.pdfID);
			rs = contentDao.pdfidExist(pdfContent);
			try {
				if (rs.next()) {
				} else {
					contentDao.InsertPDFID(MyJFrame.pdfID);
				}
				pdfContent.setSummary(text);
				// i = 0/1
				i = JOptionPane.showConfirmDialog(this, "是否覆盖已有内容？", "pdf内容", JOptionPane.YES_NO_OPTION);
				result = contentDao.UpdateSummary(pdfContent, i);
				if (result == 1) {
					JOptionPane.showMessageDialog(this, "保存成功");
				} else {
					JOptionPane.showMessageDialog(this, "保存失败");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (s.equals(introduction.getText())) {
			text = this.getSelectedText();
			pdfContent = new PDFContent(MyJFrame.pdfID);
			System.out.println(MyJFrame.pdfID);
			rs = contentDao.pdfidExist(pdfContent);
			try {
				if (rs.next()) {
				} else {
					contentDao.InsertPDFID(MyJFrame.pdfID);
				}
				pdfContent.setIntroduction(text);
				// i = 0/1
				i = JOptionPane.showConfirmDialog(this, "是否覆盖已有内容？", "pdf内容", JOptionPane.YES_NO_OPTION);
				result = contentDao.UpdateIntroduction(pdfContent, i);
				if (result == 1) {
					JOptionPane.showMessageDialog(this, "保存成功");
				} else {
					JOptionPane.showMessageDialog(this, "保存失败");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (s.equals(content.getText())) {
			text = this.getSelectedText();
			pdfContent = new PDFContent(MyJFrame.pdfID);
			rs = contentDao.pdfidExist(pdfContent);
			try {
				if (rs.next()) {
				} else {
					contentDao.InsertPDFID(MyJFrame.pdfID);
				}
				pdfContent.setContent(text);
				// i = 0/1
				i = JOptionPane.showConfirmDialog(this, "是否覆盖已有内容？", "pdf内容", JOptionPane.YES_NO_OPTION);
				result = contentDao.UpdateContent(pdfContent, i);
				if (result == 1) {
					JOptionPane.showMessageDialog(this, "保存成功");
				} else {
					JOptionPane.showMessageDialog(this, "保存失败");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (s.equals(reference.getText())) {
			text = this.getSelectedText();
			pdfContent = new PDFContent(MyJFrame.pdfID);
			rs = contentDao.pdfidExist(pdfContent);
			try {
				if (rs.next()) {
				} else {
					contentDao.InsertPDFID(MyJFrame.pdfID);
				}
				pdfContent.setReference(text);
				// i = 0/1
				i = JOptionPane.showConfirmDialog(this, "是否覆盖已有内容？", "pdf内容", JOptionPane.YES_NO_OPTION);
				result = contentDao.UpdateReference(pdfContent, i);
				if (result == 1) {
					JOptionPane.showMessageDialog(this, "保存成功");
				} else {
					JOptionPane.showMessageDialog(this, "保存失败");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (s.equals(copy.getText())) {
			this.copy();
			System.out.println(s);
		} else if (s.equals(paste.getText())) {
			this.paste();
		} else if (s.equals(cut.getText())) {
			this.cut();
		}
	}

	//剪切板是否有文本数据可供粘贴
	public boolean isClipboardString() {
		boolean b = false;
		Clipboard clipboard = this.getToolkit().getSystemClipboard();
		Transferable tf = clipboard.getContents(this);
		try {
			if (tf.getTransferData(DataFlavor.stringFlavor) instanceof String) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	//文本组件中是否具备复制或者保存的条件
	public boolean isCanCopyOrSave() {
		boolean b = false;
		int start = this.getSelectionStart();
		int end = this.getSelectionEnd();
		if (start != end)
			b = true;
		return b;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		//1：左键  2：中间键  3：右键
		if (e.getButton() == MouseEvent.BUTTON3) {
			save.setEnabled(isCanCopyOrSave());
			copy.setEnabled(isCanCopyOrSave());
			paste.setEnabled(isClipboardString());
			cut.setEnabled(isCanCopyOrSave());
			jpm.show(this, this.getX(), this.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
