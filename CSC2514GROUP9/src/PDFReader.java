import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class PDFReader 
extends JDialog {

	public static final Rectangle TITLE=new Rectangle(420,100,980,150);
    private static Point mousePt;
    private static int startX=-1;
    private static int startY=-1;
    private static int endX=-1;
    private static int endY=-1;
	public PDFReader(Desktop parent,boolean auto, String first_img,String second_img){
		super(parent);
		toFront();
		setFocusable(true);
		requestFocus();
		setTitle("PDF Reader");
		setSize(1820,1610);
		setLocation(900,40);
		setLayout(new BorderLayout());
	    JLabel background=new JLabel(new ImageIcon(first_img));
	    add(background);
	    background.setLayout(new FlowLayout());
	    this.addMouseListener(new MouseAdapter() {
	    	public void mousePressed(MouseEvent e) {
	        	if (e.getClickCount() == 2 && !e.isConsumed()) {
	        	     e.consume();
	        	     if(TITLE.contains(e.getPoint())) {
		        	     //handle double click event.
	        	    	 background.setIcon(new ImageIcon(second_img)); 
	        	     }
	        	}
	        	else {
	        		mousePt = e.getPoint();
	        		System.out.println("line 40, PDFReader: "+"x:"+mousePt.x+"y:"+mousePt.y);
	        	}
	        }	    	
	    });
	    this.addMouseMotionListener(new MouseAdapter() {
	    	public void mouseDragged(MouseEvent e) {
	    		startX=(int)mousePt.getX();
	    		startY=(int)mousePt.getY();
	    		endX=(int)e.getX();
	    		endY=(int)e.getY();
	    		int dx=(int) (endX-startX);
	    		int dy=(int) (endY-startY);
	    		float distance = (float) Math.sqrt(dx*dx+dy*dy);
              if(TITLE.contains(e.getPoint())&&TITLE.contains(mousePt)&&distance>100) {  
            	  System.out.println("Dragged, PDFReader");
            	  background.setIcon(new ImageIcon(second_img));            	  
              }
          }
	    });

		setVisible(true);
		if(auto) {
		    Robot robot=parent.getRobot();
	    	robot.mouseMove(0, 0);
	    	robot.mouseMove(660,70);
    		System.out.println("line 64, PDFReader: "+MouseInfo.getPointerInfo().getLocation());
		    robot.mousePress(InputEvent.BUTTON1_MASK);
	    	robot.mouseMove(0, 0);
	    	robot.mouseMove(905,145);
    		System.out.println("line 67, PDFReader: "+MouseInfo.getPointerInfo().getLocation());
	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	    	robot.mouseMove(0, 0);
	    	System.out.println(MouseInfo.getPointerInfo().getLocation());
	    	robot.mouseMove(200, 200);
	    	System.out.println(MouseInfo.getPointerInfo().getLocation());
	    	robot.mousePress(InputEvent.BUTTON1_MASK);
	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
    	    robot.keyPress(KeyEvent.VK_CONTROL);
    	    robot.keyPress(KeyEvent.VK_V);
    	    robot.keyRelease(KeyEvent.VK_V);
    	    robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		
	}

}
