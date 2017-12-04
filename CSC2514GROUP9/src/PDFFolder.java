import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.*;

public class PDFFolder
extends JDialog {
	public static final String PDFFOLDER_IMG="./imgs/pdf_folder.png";
	public static final Rectangle PDF1_ICON=new Rectangle(383,430,317,42);
	public static final Rectangle PDF2_ICON=new Rectangle(383,472,317,42);
	public static final Rectangle PDF3_ICON=new Rectangle(383,514,317,42);
	public static final Rectangle PDF4_ICON=new Rectangle(383,556,317,42);
	public static final Rectangle PDF5_ICON=new Rectangle(383,598,317,42);
	public static final Rectangle PDF6_ICON=new Rectangle(383,640,317,42);
	public static final Rectangle PDF7_ICON=new Rectangle(383,682,317,42);
	public static final String PDF1_PATH="./imgs/pdf1.png";
	public static final String PDF1_1_PATH="./imgs/pdf1-1.png";
	public static final String PDF2_PATH="./imgs/pdf2.png";
	public static final String PDF2_1_PATH="./imgs/pdf2-1.png";
	public static final String PDF3_PATH="./imgs/pdf3.png";
	public static final String PDF3_1_PATH="./imgs/pdf3-1.png";
	public static final String PDF4_PATH="./imgs/pdf4.png";
	public static final String PDF4_1_PATH="./imgs/pdf4-1.png";
	public static final String PDF5_PATH="./imgs/pdf5.png";
	public static final String PDF5_1_PATH="./imgs/pdf5-1.png";
	public static final String PDF6_PATH="./imgs/pdf6.png";
	public static final String PDF6_1_PATH="./imgs/pdf6-1.png";
	public static final String PDF7_PATH="./imgs/pdf7.png";
	public static final String PDF7_1_PATH="./imgs/pdf7-1.png";
	public static final Point PDF1_ABS=new Point(268,525);
	public static final Point PDF2_ABS=new Point(268,546);
	public static final Point PDF3_ABS=new Point(268,567);
	public static final Point PDF4_ABS=new Point(268,588);
	public static final Point PDF5_ABS=new Point(268,609);
	public static final Point PDF6_ABS=new Point(268,630);
	public static final Point PDF7_ABS=new Point(268,651);
	public static final Point[] PDF_ABS= {PDF1_ABS,PDF2_ABS,PDF3_ABS,PDF4_ABS,PDF5_ABS,PDF6_ABS,PDF7_ABS};
	
    private static Point mousePt=new Point(0,0);
    private static Point lastFileClick;
    private static boolean details=true;
    private static PDFFolder self;
    public static Desktop PARENT;
    public static Robot robot;
    
    public PDFFolder(Desktop parent) throws AWTException {
		super(parent);
		PARENT=parent;
		toFront();
		setTitle("PDF Folder");
		setSize(1797,1183);
		setLocation(20,600);
		setLayout(new BorderLayout());
	    JLabel background=new JLabel(new ImageIcon(PDFFOLDER_IMG));
	    add(background);
	    background.setLayout(new FlowLayout());
	    Robot robot = new Robot();
	    self=this;
	    this.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		System.out.println(e.getClickCount());
	    		if (e.getClickCount() == 2 && !e.isConsumed()) {
	        	     e.consume();
	        	     boolean automation=parent.getPDFUserDecision();
	        	     if(PDF1_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(1);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF1_PATH,PDF1_1_PATH);
		        			lastFileClick=MouseInfo.getPointerInfo().getLocation();
	        	     }
	        	     else if(PDF2_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(2);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF2_PATH,PDF2_1_PATH);
		        			lastFileClick=MouseInfo.getPointerInfo().getLocation();
	        	     }
	        	     else if(PDF3_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(3);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF3_PATH,PDF3_1_PATH);
	        	     }
	        	     else if(PDF4_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(4);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF4_PATH,PDF4_1_PATH);
	        	     }
	        	     else if(PDF5_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(5);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF5_PATH,PDF5_1_PATH);
	        	     }
	        	     else if(PDF6_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(6);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF6_PATH,PDF6_1_PATH);
	        	     }
	        	     else if(PDF7_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(7);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF7_PATH,PDF7_1_PATH);
	        	     }
	        	}
//	        	if (e.getClickCount() == 1 && !e.isConsumed()) {
//	        		mousePt=e.getPoint();
//		    		System.out.println("Single Click");
//	        	}
	    	}
	    
	        
	    	public void mousePressed(MouseEvent e) {
//	        	if (e.getClickCount() == 2 && !e.isConsumed()) {
//	        	     e.consume();
//	        	     boolean automation=parent.getPDFUserDecision();
//	        	     if(PDF1_ICON.contains(e.getPoint())) {
//		        	     //handle double click event.
//		        			parent.setPDFCount(1);
//		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF1_PATH,PDF1_1_PATH);
//		        			lastFileClick=MouseInfo.getPointerInfo().getLocation();
//	        	     }
//	        	     else if(PDF2_ICON.contains(e.getPoint())) {
//		        	     //handle double click event.
//		        			parent.setPDFCount(2);
//		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF2_PATH,PDF2_1_PATH);
//		        			lastFileClick=MouseInfo.getPointerInfo().getLocation();
//	        	     }
//	        	     else if(PDF3_ICON.contains(e.getPoint())) {
//		        	     //handle double click event.
//		        			parent.setPDFCount(3);
//		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF3_PATH,PDF3_1_PATH);
//	        	     }
//	        	     else if(PDF4_ICON.contains(e.getPoint())) {
//		        	     //handle double click event.
//		        			parent.setPDFCount(4);
//		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF4_PATH,PDF4_1_PATH);
//	        	     }
//	        	     else if(PDF5_ICON.contains(e.getPoint())) {
//		        	     //handle double click event.
//		        			parent.setPDFCount(5);
//		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF5_PATH,PDF5_1_PATH);
//	        	     }
//	        	     else if(PDF6_ICON.contains(e.getPoint())) {
//		        	     //handle double click event.
//		        			parent.setPDFCount(6);
//		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF6_PATH,PDF6_1_PATH);
//	        	     }
//	        	     else if(PDF7_ICON.contains(e.getPoint())) {
//		        	     //handle double click event.
//		        			parent.setPDFCount(7);
//		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF7_PATH,PDF7_1_PATH);
//	        	     }
//	        	}
	        	if (e.getClickCount() == 1 && !e.isConsumed()) {
	        		mousePt=e.getPoint();
		    		System.out.println("Single Press");
	        	}
	        }

	    	public void mouseReleased(MouseEvent e) {
       	     if(parent.getPDFUserDecision()&&e.getClickCount() == 1 && !e.isConsumed()) {
       	    	 System.out.println("mouseReleased");
	        	     e.consume();
	        	    	 if(mousePt.x == e.getX()&&mousePt.y == e.getY()) {
	        	    		 if(!parent.getMultiple()) {
	    	        	     boolean automation=parent.getPDFUserDecision();
		    	        	     if(PDF1_ICON.contains(mousePt)) {
					        	     //handle double click event.
				        	    	 	SkipOrDetail();
		 		        				parent.setPDFCount(1);
		 		        				if(parent.getDetails()) {
		 		        					PDFReader pdfReader=new PDFReader(parent,parent.getPDFUserDecision(),PDF1_PATH,PDF1_1_PATH);
		 		        				}
		 		        				else {
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
				        	     else if(PDF2_ICON.contains(mousePt)) {
					        	     //handle double click event.
				        	    	 	SkipOrDetail();
					        			parent.setPDFCount(2);
					        			if(parent.getDetails()) {
					        				PDFReader pdfReader=new PDFReader(parent,parent.getPDFUserDecision(),PDF2_PATH,PDF2_1_PATH);
		 		        				}
		 		        				else {
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
				        	     else if(PDF3_ICON.contains(mousePt)) {
				        	    	 	SkipOrDetail();
					        			parent.setPDFCount(3);
					        			if(parent.getDetails()) {
					        				PDFReader pdfReader=new PDFReader(parent,automation,PDF3_PATH,PDF3_1_PATH);
		 		        				}
		 		        				else {
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
				        	     else if(PDF4_ICON.contains(mousePt)) {
				        	    	 	SkipOrDetail();
					        			parent.setPDFCount(4);
					        			if(parent.getDetails()) {
						        			PDFReader pdfReader=new PDFReader(parent,automation,PDF4_PATH,PDF4_1_PATH);
		 		        				}
		 		        				else {
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
				        	     else if(PDF5_ICON.contains(mousePt)) {
				        	    	 	SkipOrDetail();
					        			parent.setPDFCount(5);
					        			if(parent.getDetails()) {
						        			PDFReader pdfReader=new PDFReader(parent,automation,PDF5_PATH,PDF5_1_PATH);
		 		        				}
		 		        				else {
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
				        	     else if(PDF6_ICON.contains(mousePt)) {
				        	    	 	SkipOrDetail();
					        			parent.setPDFCount(6);
					        			if(parent.getDetails()) {
						        			PDFReader pdfReader=new PDFReader(parent,automation,PDF6_PATH,PDF6_1_PATH);
		 		        				}
		 		        				else {
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
				        	     else if(PDF7_ICON.contains(mousePt)) {
				        	    	 	SkipOrDetail();
					        			parent.setPDFCount(7);
					        			if(parent.getDetails()) {
						        			PDFReader pdfReader=new PDFReader(parent,automation,PDF7_PATH,PDF7_1_PATH);
		 		        				}
		 		        				else {
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
	        	    		 
	        	    		 else {
	        	    			 boolean automation=parent.getPDFUserDecision();
		    	        	     if(PDF1_ICON.contains(mousePt)) {
					        	     //handle double click event.
					        			parent.setPDFCount(1);
					        			PDFReader pdfReader=new PDFReader(parent,parent.getPDFUserDecision(),PDF1_PATH,PDF1_1_PATH);
				        	     }
				        	     else if(PDF2_ICON.contains(mousePt)) {
					        	     //handle double click event.
					        			parent.setPDFCount(2);
					        			PDFReader pdfReader=new PDFReader(parent,parent.getPDFUserDecision(),PDF1_PATH,PDF2_1_PATH);
				        	     }
				        	     else if(PDF3_ICON.contains(mousePt)) {
					        			parent.setPDFCount(3);
					        			PDFReader pdfReader=new PDFReader(parent,automation,PDF3_PATH,PDF3_1_PATH);
				        	     }
				        	     else if(PDF4_ICON.contains(mousePt)) {
					        			parent.setPDFCount(4);
					        			PDFReader pdfReader=new PDFReader(parent,automation,PDF4_PATH,PDF4_1_PATH);
				        	     }
				        	     else if(PDF5_ICON.contains(mousePt)) {
					        			parent.setPDFCount(5);
					        			PDFReader pdfReader=new PDFReader(parent,automation,PDF5_PATH,PDF5_1_PATH);
				        	     }
				        	     else if(PDF6_ICON.contains(mousePt)) {
					        			parent.setPDFCount(6);
					        			PDFReader pdfReader=new PDFReader(parent,automation,PDF6_PATH,PDF6_1_PATH);
				        	     }
				        	     else if(PDF7_ICON.contains(mousePt)) {
					        			parent.setPDFCount(7);
					        			PDFReader pdfReader=new PDFReader(parent,automation,PDF7_PATH,PDF7_1_PATH);
				        	     } 
	        	    		 }
	        	    	 }
		        	     else {
					    		int start=0;
					    		int end=0;
					    		if(PDF1_ICON.contains(mousePt)){
					    			start=1;
					    			
					    		}else if(PDF2_ICON.contains(mousePt)){
					    			start=2;
					    			
					    		}else if(PDF3_ICON.contains(mousePt)){
					    			start=3;
					    			
					    		}else if(PDF4_ICON.contains(mousePt)){
					    			start=4;
					    			
					    		}else if(PDF5_ICON.contains(mousePt)){
					    			start=5;
					    			
					    		}else if(PDF6_ICON.contains(mousePt)){
					    			start=6;
					    			
					    		}else if(PDF7_ICON.contains(mousePt)){
					    			start=7;
					    			
					    		}
					    		if(PDF1_ICON.contains(e.getPoint())){
					    			end=1;
					    			
					    		}else if(PDF2_ICON.contains(e.getPoint())){
					    			end=2;
					    			
					    		}else if(PDF3_ICON.contains(e.getPoint())){
					    			end=3;
					    			
					    		}else if(PDF4_ICON.contains(e.getPoint())){
					    			end=4;
					    			
					    		}else if(PDF5_ICON.contains(e.getPoint())){
					    			end=5;
					    			
					    		}else if(PDF6_ICON.contains(e.getPoint())){
					    			end=6;
					    			
					    		}else if(PDF7_ICON.contains(e.getPoint())){
					    			end=7;
					    			
					    		}
					    		if(start<end) {
					    			parent.setMultiple(true);
			        	    	 	SkipOrDetail();
			        	    	 	if(parent.getDetails()) {			        	    	 		
						    			for(int i=start;i<end+1;i++) {
							    	    	System.out.println(i);
							    	    	robot.mouseMove(0, 0);
							    	    	System.out.println(MouseInfo.getPointerInfo().getLocation());
							    	    	robot.mouseMove(PDF_ABS[i-1].x,PDF_ABS[i-1].y);
							    	    	System.out.println(MouseInfo.getPointerInfo().getLocation());
							    	    	robot.delay(1000);
	//						    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
	//						    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
						    			}
			        	    	 	}
			        	    	 	else {
						    	    	robot.mouseMove(0, 0);
						    	    	System.out.println(MouseInfo.getPointerInfo().getLocation());
						    	    	robot.mouseMove(200, 200);
						    	    	System.out.println(MouseInfo.getPointerInfo().getLocation());
						    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
						    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);			        	    	 		
						    			for(int i=start;i<end+1;i++) {
							    	    	System.out.println(i);
						        			parent.setPDFCount(i);
							    	    	robot.keyPress(KeyEvent.VK_CONTROL);
							    	    	robot.keyPress(KeyEvent.VK_V);
							    	    	robot.keyRelease(KeyEvent.VK_V);
							    	    	robot.keyRelease(KeyEvent.VK_CONTROL);
						    			}
			        	    	 	}
					    			parent.setMultiple(false);
					    		}else if(start>end) {
					    			parent.setMultiple(true);
			        	    	 	if(parent.getDetails()) {	
						    			for(int i=end;i<start+1;i++) {
							    	    	robot.mouseMove(0, 0);
							    	    	robot.mouseMove(PDF_ABS[i-1].x,PDF_ABS[i-1].y);
							    	    	robot.delay(1000);
							    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
							    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
						    			}
			        	    	 	}
			        	    	 	else {
						    	    	robot.mouseMove(0, 0);
						    	    	System.out.println(MouseInfo.getPointerInfo().getLocation());
						    	    	robot.mouseMove(200, 200);
						    	    	System.out.println(MouseInfo.getPointerInfo().getLocation());
						    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
						    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);			        	    	 		
						    			for(int i=end;i<start+1;i++) {
							    	    	System.out.println(i);
						        			parent.setPDFCount(i);
							    	    	robot.keyPress(KeyEvent.VK_CONTROL);
							    	    	robot.keyPress(KeyEvent.VK_V);
							    	    	robot.keyRelease(KeyEvent.VK_V);
							    	    	robot.keyRelease(KeyEvent.VK_CONTROL);
						    			}
			        	    	 		
			        	    	 	}
						    			parent.setMultiple(false);
					    		}
			        	     }
		        	     }
	    	}
	    	});
	    setVisible(true);
	    }

    
//    public void paint(Graphics g) {
//    	System.out.println("BLAH");
//    	super.paint(g);
//        g.setColor(Color.RED);;
//        g.drawRect(100, 100, 100, 100);
//        
//        Component c = this;
//        while((c != null) && (! (c instanceof Desktop)))
//        	c = c.getParent();
//        c.repaint();
//    }
    
	private void SelectTitle() {
		Robot select_title_robot;
		try {
			select_title_robot = new Robot();
	    	System.out.println(MouseInfo.getPointerInfo().getLocation());
			select_title_robot.mouseMove(1000,700);
			//System.out.println("BOUNDS: " + MouseInfo.getPointerInfo().getDevice().getDefaultConfiguration().getBounds());
	    	System.out.println(MouseInfo.getPointerInfo().getLocation());
	    	select_title_robot.delay(1000);
			select_title_robot.mouseMove(MouseInfo.getPointerInfo().getLocation().x+50,MouseInfo.getPointerInfo().getLocation().y+50);
	    	select_title_robot.delay(1000);
			System.out.println(MouseInfo.getPointerInfo().getLocation());
			//select_title_robot.mousePress(InputEvent.BUTTON1_MASK);
			//click_pdf_robot.mouseMove(getX()+1000,getY()+200+50);
			//select_title_robot.mouseRelease(InputEvent.BUTTON1_MASK);
//			click_pdf_robot.mouseMove(700,400);
//			click_pdf_robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//			click_pdf_robot.mouseMove(800,500);
//			click_pdf_robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void SkipOrDetail() {
   	 UIManager.put("OptionPane.messageFont", new Font("System", Font.PLAIN, 30));
   	 UIManager.put("OptionPane.buttonFont", new Font("System", Font.PLAIN, 30));
   	 if (JOptionPane.showConfirmDialog(null,
                "Do you want to skip step details?",
                "Mode Selection", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
   		    // yes option
   		 	PARENT.setDetails(false);
   		} else {
   		    // no option
   		 	PARENT.setDetails(true);
   		}
	}
}

