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
    private static PDFReader self;
	private static int ID;
	
	public PDFReader(Desktop parent,boolean auto, String first_img,String second_img){
		super(parent);
		toFront();
		setFocusable(true);
		requestFocus();
		setTitle("PDF Reader");
		setName("PDF Reader");
		setSize(1820,1610);
		setLocation(900,40);
		self=this;
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
	        		System.out.println("line 41, PDFReader: "+"x:"+mousePt.x+"y:"+mousePt.y);
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
            	 // System.out.println("Dragged, PDFReader");
            	  background.setIcon(new ImageIcon(second_img));            	  
              }
              if(!parent.getPDFUserDecision()) {
         	      ActionItem action= new ActionItem(parent.SELECT_TITLE,self);
         	      parent.addAction(action);          	  
              }
          }
	    });

	    this.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent e) {
//   	    	 	parent.setRepetitiveCount(parent.getRepetitiveCount()+1);
//   	    	 	int repetitiveCount=parent.getRepetitiveCount();
//	    	     if(repetitiveCount==6) {
//	    	    	 UIManager.put("OptionPane.messageFont", new Font("System", Font.PLAIN, 30));
//	    	    	 UIManager.put("OptionPane.buttonFont", new Font("System", Font.PLAIN, 30));
//	    	    	 if (JOptionPane.showConfirmDialog(null,
//                             "Repetitive task detected, do you want to automate it?",
//                             "Automate Request", 
//                             JOptionPane.YES_NO_OPTION,
//                             JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
//	    	    		 	parent.setPDFUserDecision(true);
//	    	    		 	System.out.println(parent.getPDFUserDecision());
//	    	    		} else {
//	    	    		 	parent.setPDFUserDecision(false);
//	    	    		}
//	    	     }	

	              if(!parent.getPDFUserDecision()) {
	         	      ActionItem action= new ActionItem(parent.CLOSE_PDFFILE,self);
	         	      parent.addAction(action);          	  
	              }
	            e.getWindow().dispose();
	        }
	    });
	    
		setVisible(true);
		
		if(auto) {
 	    	Thread one = new Thread() {
 	    		public void run() {
			    	    	try {
								Thread.sleep(1000);
				 	   		    Robot robot=parent.getRobot();
				 	   	    	robot.mouseMove(0, 0);
				 	   	    	robot.mouseMove(700,80);
				 	       		//System.out.println("line 92, PDFReader: "+MouseInfo.getPointerInfo().getLocation());
				 	   		    robot.mousePress(InputEvent.BUTTON1_MASK);
								Thread.sleep(1000);
				 	   	    	robot.mouseMove(0, 0);
				 	   	    	robot.mouseMove(905,120);
				 	       		//System.out.println("line 96, PDFReader: "+MouseInfo.getPointerInfo().getLocation());
				 	   	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
								Thread.sleep(1000);
				 	   	    	robot.mouseMove(0, 0);
				 	   	    	robot.mouseMove(1350,25);
				 	   	    	robot.mousePress(InputEvent.BUTTON1_MASK);
				 	   	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
								Thread.sleep(500);
				 	   	    	robot.mouseMove(0, 0);
				 	   	    	//System.out.println(MouseInfo.getPointerInfo().getLocation());
				 	   	    	robot.mouseMove(160, 151);
				 	   	    	//System.out.println(MouseInfo.getPointerInfo().getLocation());
				 	   	    	robot.mousePress(InputEvent.BUTTON1_MASK);
				 	   	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
				 	       	    robot.keyPress(KeyEvent.VK_CONTROL);
				 	       	    robot.keyPress(KeyEvent.VK_V);
				 	       	    robot.keyRelease(KeyEvent.VK_V);
				 	       	    robot.keyRelease(KeyEvent.VK_CONTROL);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		    			}		 					    	    		 		
 	    	};
 	    	one.start();
		}
		
	}

}
