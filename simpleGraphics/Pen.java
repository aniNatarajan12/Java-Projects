package jrJava.simpleGraphics;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class Pen implements MouseListener, MouseMotionListener {

	private FancyDrawingBoard board;
	private Graphics2D canvas; // it is actually tCanvas.
	
	private int x, y;
	private int lastX, lastY;
	
	private Color color;
	private float alpha;
	private float thickness;
	
	private PenTool penTool;
	
	public Pen(FancyDrawingBoard _board, Color _color, float _alpha, float _thickness){
		board = _board;
		canvas = board.getTCanvas();
		setColor(_color);
		setAlpha(_alpha);
		setThickness(_thickness);
	}
	
	public void setPenTool(PenTool _penTool){
		penTool = _penTool;
	}
	
	public void setColor(Color _color){
		color = _color;
		canvas.setColor(color);
		canvas.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
	}
	
	public void setAlpha(float _alpha){
		alpha = _alpha;
		canvas.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
	}
	
	public void setThickness(float _thickness){
		thickness = _thickness;
		Stroke s = new BasicStroke(thickness);
		canvas.setStroke(s);
	}
	
	
	public void clearTopLayer(){
		board.clearTCanvas();
	}
	
	
	public void clearBottomLayer(){
		board.clearCanvas();
	}
	
	public void merge(){
		board.merge();
	}
	
	
	public void setEraser(){
		canvas.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_ATOP, 0.0f));
	}
	
	
	public void saveAsFile(){
		board.saveAsFile();
	}
	
	
	public void mousePressed(MouseEvent e) {
		if(penTool.isPressed(e.getX(),e.getY())){
			return;
		}
		
		x = e.getX();
		y = e.getY();
		lastX = x;
		lastY = y;
	}

	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
		canvas.drawLine(lastX, lastY, x, y);
		
		lastX = x;
		lastY = y;
	}

	
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	
}
