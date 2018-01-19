package jrJava.simpleGraphics;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FancyDrawingBoard extends JPanel {

	private int width, height;
	private JFrame frame;
	
	private Image canvasImage;
	private Graphics2D canvas;
	
	private Image transImage;
	private Graphics2D tCanvas;
	
	private Image transImage2;
	private Graphics2D tCanvas2;
	
	
	public FancyDrawingBoard(int _width, int _height){
		width = _width;
		height = _height;
		
		frame = new JFrame();
		frame.setSize(width, height); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
		
		Container contentPane = frame.getContentPane();
		contentPane.add(this);
		
		canvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		canvas = (Graphics2D) canvasImage.getGraphics();
		canvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		transImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		tCanvas = (Graphics2D) transImage.getGraphics();
		tCanvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		transImage2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		tCanvas2 = (Graphics2D) transImage2.getGraphics();
		tCanvas2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	
	public Graphics2D getCanvas(){
		return canvas;
	}
	
	
	public Graphics2D getTCanvas(){
		return tCanvas;
	}
	
	
	public Graphics2D getTCanvas2(){
		return tCanvas2;
	}
	
	
	public void clearCanvas(){
		canvas.setColor(Color.WHITE);
		canvas.fillRect(0, 0, width, height);
	}
	
	
	public void clearTCanvas(){
		Composite original = tCanvas.getComposite();
		tCanvas.setComposite(AlphaComposite.Clear);
		tCanvas.fillRect(0, 0, width, height);
		tCanvas.setComposite(original);
	}
	
	
	public void merge(){
		canvas.drawImage(transImage, 0, 0, this);
		clearTCanvas();
	}
	
	
	public void saveAsFile(){
		
		try {
			ImageIO.write( (BufferedImage) canvasImage, "PNG", new File("jrJava/simpleGraphics/pic.png")); 
		}
		catch(Exception e){
			
		}
	}
	
	
	public void paint(Graphics g){
		g.drawImage(canvasImage, 0, 0, this);
		g.drawImage(transImage, 0, 0, this);
		g.drawImage(transImage2, 0, 0, this);
	}
	 
	
}












