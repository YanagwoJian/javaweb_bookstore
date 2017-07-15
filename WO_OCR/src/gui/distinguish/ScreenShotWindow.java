package gui.distinguish;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JWindow;


import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

//Jwindow 地位等同与JFrame，是一个无标题栏的窗口
public class ScreenShotWindow extends JWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int orgx, orgy, endx, endy;
	
	
	/**image的作用:
	     * 1.获取整个屏幕的截图*/
	private BufferedImage image = null;
	private BufferedImage tempImage = null;
	private BufferedImage saveImage = null;
	File imageFile;
	
	private ToolsWindow toolsWindow = null;
	int i;
	
	public ScreenShotWindow(int i) throws AWTException {
		this.i = i;
		
		
		//获取默认屏幕设备
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice screen = environment.getDefaultScreenDevice();
		
		//获取屏幕尺寸
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, d.width, d.height);
		
		//获取屏幕截图
		Robot robot = new Robot(screen);
		image = robot.createScreenCapture(new Rectangle(0, 0, d.width, d.height));
		
		//设置鼠标的敲击的时间监听
		this.addMouseListener(new MouseAdapter() {

			//鼠标抬起的事件监听
			@Override 
			public void mouseReleased(MouseEvent e) {
				if(toolsWindow == null) {
					toolsWindow = new ToolsWindow(ScreenShotWindow.this, e.getX(), e.getY());
				}else {
					toolsWindow.setLocation(e.getX(), e.getY());
				}
				toolsWindow.setVisible(true);
				//如果此窗口是可见的，则将此窗口置于前端，并可以将其设为焦点 Window
				toolsWindow.toFront();
			}
			
			//鼠标按下的事件监听
			@Override
			public void mousePressed(MouseEvent e) {
				orgx = e.getX();
				orgy = e.getY();
				
				if(toolsWindow != null)
					toolsWindow.setVisible(false);
			}
		});
		
		//对于鼠标移动的事件监听
		this.addMouseMotionListener(new MouseMotionAdapter() {
		
			//鼠标滑动的监听
			//在滑动过程中会被反复调用
			@Override
			public void mouseDragged(MouseEvent e) {
				endx = e.getX();
				endy = e.getY();
				
				//临时图像，用于缓冲屏幕区，防止屏幕闪烁
				Image tempImage2 = createImage(ScreenShotWindow.this.getWidth(), ScreenShotWindow.this.getHeight());
				//用于绘图
				Graphics g = tempImage2.getGraphics();
				g.drawImage(tempImage, 0, 0, null);
				
				int x = Math.min(orgx, endx);
				int y = Math.min(orgy, endy);
				
				int width = Math.abs(endx-orgx)+1;
				int height = Math.abs(endy-orgy)+1;
				
				g.setColor(Color.red);
				
				//保证图片矩形不被边框覆盖
				g.drawRect(x-1, y-1, width+1, height+1);
				
				//getSubimage(int x,int y,int w,int h)用于返回规定位置中的矩形图像到BufferedImag对象
				saveImage = image.getSubimage(x, y, width, height);
				//用于画当前图像中的可用图像
				g.drawImage(saveImage, x, y, null);
				
				ScreenShotWindow.this.getGraphics().drawImage(tempImage2, 0, 0, ScreenShotWindow.this);
			}
		});
	}
	
	
	//重写绘画方法
	@Override
	public void paint(Graphics g) {
		//new RescaleOp(float[] scaleFactors, float[] offsets, RenderingHints hints)
		//构造一个具有所希望的缩放因子和偏移量的新 RescaleOp。
		//RescaleOp 是有关图像缩放的类
		//RescaleOp.filter(BufferedImage src,BufferedImage dest)
		//用于对源图像src进行缩放
		RescaleOp ro = new RescaleOp(0.8f, 0, null);
		tempImage = ro.filter(image, null);
		g.drawImage(tempImage, 0, 0, this);
	}
	
	
	//识别图像中文
	public void distinguishCh() throws IOException{

		//字库路径
		String path = ScreenShotWindow.class.getResource("/").getFile().toString();
		char [] stringArr = path.toCharArray();
		for(int j = 0; j < stringArr.length-1; j++) {
			stringArr[j] = stringArr[j+1];
		}      
		path = String.valueOf(stringArr);
		path = path.replaceAll("bin/", "tessdata");
		path = path.substring(0, path.length()-1);
		path = path.replaceAll("/", "\\\\\\\\");
	
       try {
    	   imageFile = new File("e:/1.jpg");
    	   if (!imageFile.exists()) {
    		     imageFile.createNewFile();
    		    }
    	   ImageIO.write(saveImage, "jpg", imageFile);
    	   Tesseract instance = Tesseract.getInstance(); // JNA Interface Mapping
    	   instance.setDatapath(path);//设置训练库的位置
    	   instance.setLanguage("chi_sim");//中文识别
    	   
           String result = instance.doOCR(imageFile); 
           File f = new File("e:/1.txt");
           if(!f.exists()){
    		    f.createNewFile();
           }
           FileWriter fileWriter = new FileWriter(f);
           BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
           bufferWriter.write(result);
           bufferWriter.close(); 
           fileWriter.close();
           
           imageFile.deleteOnExit();
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        //关闭窗体，关释放资源
        dispose();
        toolsWindow.dispose();
	}
	
	//识别图像英文
	public void distinguishEn() throws IOException{
		
		//字库路径
		String path = ScreenShotWindow.class.getResource("/").getFile().toString();
		char [] stringArr = path.toCharArray();
		for(int j = 0; j < stringArr.length-1; j++) {
			stringArr[j] = stringArr[j+1];
		}      
		path = String.valueOf(stringArr);
		path = path.replaceAll("bin/", "tessdata");
		path = path.substring(0, path.length()-1);
		path = path.replaceAll("/", "\\\\\\\\");
	
       try {
    	   imageFile = new File("e:/1.jpg");
    	   if (!imageFile.exists()) {
    		     imageFile.createNewFile();
    		    }
    	   ImageIO.write(saveImage, "jpg", imageFile);
    	   Tesseract instance = Tesseract.getInstance(); // JNA Interface Mapping
    	   instance.setDatapath(path);//设置训练库的位置
    	   instance.setLanguage("eng");//英文识别
    	   
           String result = instance.doOCR(imageFile); 
           File f = new File("e:/1.txt");
           if(!f.exists()){
    		    f.createNewFile();
           }
           FileWriter fileWriter = new FileWriter(f);
           BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
           bufferWriter.write(result);
           bufferWriter.close(); 
           fileWriter.close();
           
           imageFile.deleteOnExit();
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        //关闭窗体，关释放资源
        dispose();
        toolsWindow.dispose();
	}


	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}
	
	
}
