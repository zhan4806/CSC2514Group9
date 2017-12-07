import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
	public static final Rectangle FILEAREA=new Rectangle(383,430,317,294);
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
	public static final Point PDF1_ABS=new Point(268*2,525*2);
	public static final Point PDF2_ABS=new Point(268*2,546*2);
	public static final Point PDF3_ABS=new Point(268*2,567*2);
	public static final Point PDF4_ABS=new Point(268*2,588*2);
	public static final Point PDF5_ABS=new Point(268*2,609*2);
	public static final Point PDF6_ABS=new Point(268*2,630*2);
	public static final Point PDF7_ABS=new Point(268*2,651*2);
	public static final Point[] PDF_ABS= {PDF1_ABS,PDF2_ABS,PDF3_ABS,PDF4_ABS,PDF5_ABS,PDF6_ABS,PDF7_ABS};
	
    private static Point mousePt=new Point(0,0);
    private static Point lastFileClick;
    private static boolean details=true;
    private static PDFFolder self;
    public static Desktop PARENT;
    public static Robot robot;
    private static boolean alt=false;
    LinkedList<Integer> selected = new LinkedList<Integer>();
	private static int ID;

	int start=0;
	int end=0;
    
    public PDFFolder(Desktop parent) throws AWTException {
		super(parent);
		PARENT=parent;
		toFront();
		setTitle("PDF Folder");
		setName("PDF Folder");
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
	    		//System.out.println(e.getClickCount());
	    		if (e.getClickCount() == 2 && !e.isConsumed()) {
	        	     e.consume();
	        	     boolean automation=parent.getPDFUserDecision();
	        	     if(PDF1_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(1);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF1_PATH,PDF1_1_PATH);
		        			parent.setRepetitiveCount(parent.getRepetitiveCount()+1);
	        	     }
	        	     else if(PDF2_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(2);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF2_PATH,PDF2_1_PATH);
		        			parent.setRepetitiveCount(parent.getRepetitiveCount()+1);
	        	     }
	        	     else if(PDF3_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(3);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF3_PATH,PDF3_1_PATH);
		        			parent.setRepetitiveCount(parent.getRepetitiveCount()+1);
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
		        			parent.setRepetitiveCount(parent.getRepetitiveCount()+1);
	        	     }
	        	     else if(PDF6_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(6);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF6_PATH,PDF6_1_PATH);
		        			parent.setRepetitiveCount(parent.getRepetitiveCount()+1);
	        	     }
	        	     else if(PDF7_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			parent.setPDFCount(7);
		        			PDFReader pdfReader=new PDFReader(parent,automation,PDF7_PATH,PDF7_1_PATH);
		        			parent.setRepetitiveCount(parent.getRepetitiveCount()+1);
	        	     }
	                 if(!parent.getPDFUserDecision()) {
	            	      ActionItem action= new ActionItem(parent.OPEN_PDFFILE,self);
	            	      parent.addAction(action);          	  
	                 }
	        	}
	    	}
	    
	        
	    	public void mousePressed(MouseEvent e) {
	        	if (e.getClickCount() == 1 && !e.isConsumed()) {
	        		mousePt=e.getPoint();

	                if(!parent.getPDFUserDecision()&&FILEAREA.contains(mousePt)) {
	           	      ActionItem action= new ActionItem(parent.SELECT_PDFFILE,self);
	           	      parent.addAction(action);          	  
	                }
		    		//System.out.println("Single Press");
	        	}
	        }

	    	public void mouseReleased(MouseEvent e) {
       	     if(parent.getPDFUserDecision()&&e.getClickCount() == 1 && !e.isConsumed()) {
       	    	// System.out.println("mouseReleased");
	        	     e.consume();
	        	    	 if(mousePt.x == e.getX()&&mousePt.y == e.getY()) {
	        	    		 if(alt) {
	        	    			 if(PDF1_ICON.contains(mousePt)) 
	        	    				 selected.addLast(1);
	        	    			 if(PDF2_ICON.contains(mousePt)) 
	        	    				 selected.addLast(2);
	        	    			 if(PDF3_ICON.contains(mousePt)) 
	        	    				 selected.addLast(3);
	        	    			 if(PDF4_ICON.contains(mousePt)) 
	        	    				 selected.addLast(4);
	        	    			 if(PDF5_ICON.contains(mousePt)) 
	        	    				 selected.addLast(5);
	        	    			 if(PDF6_ICON.contains(mousePt)) 
	        	    				 selected.addLast(6);
	        	    			 if(PDF7_ICON.contains(mousePt)) 
	        	    				 selected.addLast(7);
	        	    			 
	        	    		 }
	        	    		 else {
	    	        	     boolean automation=parent.getPDFUserDecision();
		    	        	     if(PDF1_ICON.contains(mousePt)) {
						    			try {
											parent.completeAction(parent.SELECT_PDFFILE);
										} catch (AWTException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
					        	     //handle double click event.
				        	    		 if(!parent.getMultiple()) {
				        	    			 if(parent.repetitiveList.contains(parent.PASTE_TO_NOTEPAD))
					        	    	 		SkipOrDetail();
				        	    		 }
		 		        				parent.setPDFCount(1);
		 		        				if(parent.getDetails()) {
		 					    	    	Thread one = new Thread() {
		 					    	    		public void run() {
									    	    	robot.mouseMove(0, 0);
									    	    	robot.mouseMove(PDF_ABS[1-1].x,PDF_ABS[1-1].y);
									    	    	try {
														Thread.sleep(500);
														} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
														}
									    	    	PDFReader pdfReader=new PDFReader(parent,parent.getPDFUserDecision(),PDF1_PATH,PDF1_1_PATH);							    											    			
									    	    	try {
														Thread.sleep((parent.repetitiveList.size())*2000);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}

			 							    			try {
															parent.completeAction(parent.OPEN_PDFFILE);
														} catch (AWTException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
		 							    			}		 					    	    		 		
		 					    	    	};
		 					    	    	one.start();

		 		        				}
		 		        				else {

						        			parent.lastPDF=1;
							    	    	try {
												Thread.sleep(500);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
		 		        					SkipSingleDoc(robot);
		 		        				}
					        			
				        	     }
				        	     else if(PDF2_ICON.contains(mousePt)) {
						    			try {
											parent.completeAction(parent.SELECT_PDFFILE);
										} catch (AWTException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
					        	     //handle double click event.
				        	    		 if(!parent.getMultiple()) {
				        	    			 if(parent.repetitiveList.contains(parent.PASTE_TO_NOTEPAD))
					        	    	 		SkipOrDetail();
				        	    		 }
					        			parent.setPDFCount(2);
					        			if(parent.getDetails()) {
		 					    	    	Thread one = new Thread() {
		 					    	    		public void run() {
									    	    	robot.mouseMove(0, 0);
									    	    	robot.mouseMove(PDF_ABS[2-1].x,PDF_ABS[2-1].y);
									    	    	try {
														Thread.sleep(500);
														} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
														}
									    	    	PDFReader pdfReader=new PDFReader(parent,parent.getPDFUserDecision(),PDF2_PATH,PDF2_1_PATH);							    											    			
									    	    	try {
														Thread.sleep((parent.repetitiveList.size())*2000);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}

			 							    			try {
															parent.completeAction(parent.OPEN_PDFFILE);
														} catch (AWTException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
		 							    			}		 					    	    		 		
		 					    	    	};
		 					    	    	one.start();
		 		        				}
		 		        				else {

						        			parent.lastPDF=2;
							    	    	try {
												Thread.sleep(500);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
		 		        					SkipSingleDoc(robot);
		 		        				}
					        			
				        	     }
				        	     else if(PDF3_ICON.contains(mousePt)) {
						    			try {
											parent.completeAction(parent.SELECT_PDFFILE);
										} catch (AWTException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
				        	    		 if(!parent.getMultiple()) {
				        	    			 if(parent.repetitiveList.contains(parent.PASTE_TO_NOTEPAD))
					        	    	 		SkipOrDetail();
				        	    		 }
					        			parent.setPDFCount(3);
					        			if(parent.getDetails()) {
		 					    	    	Thread one = new Thread() {
		 					    	    		public void run() {
									    	    	robot.mouseMove(0, 0);
									    	    	robot.mouseMove(PDF_ABS[3-1].x,PDF_ABS[3-1].y);
									    	    	try {
														Thread.sleep(500);
														} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
														}
									    	    	PDFReader pdfReader=new PDFReader(parent,parent.getPDFUserDecision(),PDF3_PATH,PDF3_1_PATH);							    											    			
									    	    	try {
														Thread.sleep((parent.repetitiveList.size())*2000);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}

			 							    			try {
															parent.completeAction(parent.OPEN_PDFFILE);
														} catch (AWTException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
		 							    			}		 					    	    		 		
		 					    	    	};
		 					    	    	one.start();
		 		        				}
		 		        				else {
						        			parent.lastPDF=3;
							    	    	try {
												Thread.sleep(500);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
		 		        					SkipSingleDoc(robot);
		 		        				}
					        			
				        	     }
				        	     else if(PDF4_ICON.contains(mousePt)) {
						    			try {
											parent.completeAction(parent.SELECT_PDFFILE);
										} catch (AWTException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
				        	    		 if(!parent.getMultiple()) {
				        	    			 if(parent.repetitiveList.contains(parent.PASTE_TO_NOTEPAD))
					        	    	 		SkipOrDetail();
				        	    		 }
					        			parent.setPDFCount(4);
					        			if(parent.getDetails()) {
		 					    	    	Thread one = new Thread() {
		 					    	    		public void run() {
									    	    	robot.mouseMove(0, 0);
									    	    	robot.mouseMove(PDF_ABS[4-1].x,PDF_ABS[4-1].y);
									    	    	try {
														Thread.sleep(500);
														} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
														}
									    	    	PDFReader pdfReader=new PDFReader(parent,parent.getPDFUserDecision(),PDF4_PATH,PDF4_1_PATH);							    											    			
									    	    	try {
														Thread.sleep((parent.repetitiveList.size())*2000);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}

			 							    			try {
															parent.completeAction(parent.OPEN_PDFFILE);
														} catch (AWTException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
		 							    			}		 					    	    		 		
		 					    	    	};
		 					    	    	one.start();
		 		        				}
		 		        				else {
						        			parent.lastPDF=4;
							    	    	try {
												Thread.sleep(500);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
		 		        					SkipSingleDoc(robot);
		 		        				}
				        	     }
				        	     else if(PDF5_ICON.contains(mousePt)) {
						    			try {
											parent.completeAction(parent.SELECT_PDFFILE);
										} catch (AWTException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
				        	    		 if(!parent.getMultiple()) {
				        	    			 if(parent.repetitiveList.contains(parent.PASTE_TO_NOTEPAD))
					        	    	 		SkipOrDetail();
				        	    		 }
					        			parent.setPDFCount(5);
					        			if(parent.getDetails()) {
		 					    	    	Thread one = new Thread() {
		 					    	    		public void run() {
									    	    	robot.mouseMove(0, 0);
									    	    	robot.mouseMove(PDF_ABS[5-1].x,PDF_ABS[5-1].y);
									    	    	try {
														Thread.sleep(500);
														} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
														}
									    	    	PDFReader pdfReader=new PDFReader(parent,parent.getPDFUserDecision(),PDF5_PATH,PDF5_1_PATH);							    											    			
									    	    	try {
														Thread.sleep((parent.repetitiveList.size())*2000);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}

			 							    			try {
															parent.completeAction(parent.OPEN_PDFFILE);
														} catch (AWTException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
		 					    	    		}
		 					    	    	};
		 					    	    	one.start();
		 		        				}
		 		        				else {
						        			parent.lastPDF=5;
							    	    	try {
												Thread.sleep(500);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
		 		        					SkipSingleDoc(robot);
		 		        				}
				        	     }
				        	     else if(PDF6_ICON.contains(mousePt)) {
						    			try {
											parent.completeAction(parent.SELECT_PDFFILE);
										} catch (AWTException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
			        	    		 if(!parent.getMultiple()) {
			        	    			 if(parent.repetitiveList.contains(parent.PASTE_TO_NOTEPAD))
				        	    	 		SkipOrDetail();
			        	    		 }
					        			parent.setPDFCount(6);
					        			if(parent.getDetails()) {
		 					    	    	Thread one = new Thread() {
		 					    	    		public void run() {
									    	    	robot.mouseMove(0, 0);
									    	    	robot.mouseMove(PDF_ABS[6-1].x,PDF_ABS[6-1].y);
									    	    	try {
														Thread.sleep(500);
														} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
														}
									    	    	PDFReader pdfReader=new PDFReader(parent,parent.getPDFUserDecision(),PDF6_PATH,PDF6_1_PATH);							    											    			
									    	    	try {
														Thread.sleep((parent.repetitiveList.size())*2000);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}

			 							    			try {
															parent.completeAction(parent.OPEN_PDFFILE);
														} catch (AWTException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
		 							    			}		 					    	    		 		
		 					    	    	};
		 					    	    	one.start();
		 		        				}
		 		        				else {
						        			parent.lastPDF=6;
							    	    	try {
												Thread.sleep(500);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
		 		        					SkipSingleDoc(robot);
		 		        				}
				        	     }
				        	     else if(PDF7_ICON.contains(mousePt)) {
						    			try {
											parent.completeAction(parent.SELECT_PDFFILE);
										} catch (AWTException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
				        	    		 if(!parent.getMultiple()) {
				        	    			 if(parent.repetitiveList.contains(parent.PASTE_TO_NOTEPAD))
					        	    	 		SkipOrDetail();
				        	    		 }
					        			parent.setPDFCount(7);
					        			if(parent.getDetails()) {
		 					    	    	Thread one = new Thread() {
		 					    	    		public void run() {

									    	    	robot.mouseMove(0, 0);
									    	    	robot.mouseMove(PDF_ABS[7-1].x,PDF_ABS[7-1].y);
									    	    	try {
														Thread.sleep(500);
														} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
														}
									    	    	PDFReader pdfReader=new PDFReader(parent,parent.getPDFUserDecision(),PDF7_PATH,PDF7_1_PATH);							    											    			
									    	    	try {
														Thread.sleep((parent.repetitiveList.size())*2000);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}

			 							    			try {
															parent.completeAction(parent.OPEN_PDFFILE);
														} catch (AWTException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
		 							    			}		 					    	    		 		
		 					    	    	};
		 					    	    	one.start();
		 		        				}
		 		        				else {
						        			parent.lastPDF=7;
							    	    	try {
												Thread.sleep(500);
											} catch (InterruptedException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
		 		        					SkipSingleDoc(robot);
		 		        				}
				        	     }
	        	    	 }
	        	    	 }
		        	     else {
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
					    			try {
										parent.completeAction(parent.SELECT_PDFFILE);
									} catch (AWTException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
		        	    			 if(parent.repetitiveList.contains(parent.PASTE_TO_NOTEPAD))
		        	    				 SkipOrDetail();
			        	    	 	if(parent.getDetails()) {
			        	    	 		Thread one = new Thread() {
					    	    		public void run() {		
							    			for(int i=start;i<end+1;i++) {
								    	    	robot.mouseMove(0, 0);
								    	    	robot.mouseMove(20, 880);
								    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
								    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);							    											    			
								    	    	try {
													Thread.sleep(1000);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
								    	    	robot.mouseMove(0, 0);
								    	    	robot.mouseMove(PDF_ABS[i-1].x,PDF_ABS[i-1].y);
								    	    	try {
													Thread.sleep(500);
													} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
													}
								    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
								    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);							    											    			
								    	    	try {
													Thread.sleep((parent.repetitiveList.size())*2000);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
							    			} 
								    		parent.setMultiple(false);
								    		parent.DoneAndContinue();
								    		start=0;
								    		end=0;
						                	;
					    	    		}	    		
					    	    	};
					    	    	one.start();
			        	    	 	}
			        	    	 	else {
						    	    	robot.mouseMove(0, 0);
						    	    	//System.out.println(MouseInfo.getPointerInfo().getLocation());
						    	    	robot.mouseMove(400, 400);
						    	    	//System.out.println(MouseInfo.getPointerInfo().getLocation());
						    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
						    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);			        	    	 		
						    	    	Thread one = new Thread() {
						    	    		public void run() {							    	    			
						    	    			for(int i=start;i<end+1;i++) {
									    	    	System.out.println(i);
								        			parent.lastPDF=i;
									    	    	try {
														Thread.sleep(500);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
									    	    	robot.keyPress(KeyEvent.VK_CONTROL);
									    	    	robot.keyPress(KeyEvent.VK_V);
									    	    	robot.keyRelease(KeyEvent.VK_V);
									    	    	robot.keyRelease(KeyEvent.VK_CONTROL);
								    										    			
									    	    	try {
														Thread.sleep(1000);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
								    			} 
									    		parent.setMultiple(false);
									    		parent.DoneAndContinue();
									    		start=0;
									    		end=0;
							                	;
						    	    		}	    		
						    	    	};
						    	    	one.start();
			        	    	 	}
					    		}else if(start>end) {
					    			parent.setMultiple(true);
					    			try {
										parent.completeAction(parent.SELECT_PDFFILE);
									} catch (AWTException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
		        	    			if(parent.repetitiveList.contains(parent.PASTE_TO_NOTEPAD))
		        	    				 SkipOrDetail();
			        	    	 	if(parent.getDetails()) {
			        	    	 		Thread one = new Thread() {
					    	    		public void run() {		
							    			for(int i=start;i>end-1;i--) {
								    	    	robot.mouseMove(0, 0);
								    	    	robot.mouseMove(20, 880);
								    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
								    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);							    											    			
								    	    	try {
													Thread.sleep(1000);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
								    	    	robot.mouseMove(0, 0);
								    	    	robot.mouseMove(PDF_ABS[i-1].x,PDF_ABS[i-1].y);
								    	    	try {
													Thread.sleep(500);
													} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
													}
								    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
								    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);							    											    			
								    	    	try {
													Thread.sleep((parent.repetitiveList.size())*2000);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
							    			} 
								    		parent.setMultiple(false);
								    		parent.DoneAndContinue();
								    		start=0;
								    		end=0;
						                	;
					    	    		}	    		
					    	    	};
					    	    	one.start();
			        	    	 	}
			        	    	 	else {
						    	    	robot.mouseMove(0, 0);
						    	    	//System.out.println(MouseInfo.getPointerInfo().getLocation());
						    	    	robot.mouseMove(400, 400);
						    	    	//System.out.println(MouseInfo.getPointerInfo().getLocation());
						    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
						    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
						    	    	Thread one = new Thread() {
						    	    		public void run() {							    	    			
						    	    			for(int i=start;i>end-1;i--) {
									    	    	System.out.println(i);
								        			parent.lastPDF=i;
									    	    	try {
														Thread.sleep(500);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
									    	    	robot.keyPress(KeyEvent.VK_CONTROL);
									    	    	robot.keyPress(KeyEvent.VK_V);
									    	    	robot.keyRelease(KeyEvent.VK_V);
									    	    	robot.keyRelease(KeyEvent.VK_CONTROL);								    			
									    	    	try {
														Thread.sleep(1000);
													} catch (InterruptedException e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
								    			} 
									    		parent.setMultiple(false);
									    		parent.DoneAndContinue();
									    		start=0;
									    		end=0;
							                	;
						    	    		}	    		
						    	    	};
						    	    	one.start();
			        	    	 		
			        	    	 	}
					    		}
			        	     }
		        	     }
	    	}
	    	});
	    this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode()==KeyEvent.VK_ALT) {
                	alt=true;
                }
          }
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode()==KeyEvent.VK_ALT) {
                	if(selected.size()>1) {
                		parent.setMultiple(true);
                	}
                	else{
                		parent.setMultiple(false);
                	}
                	if(selected.size()>0) {
                		parent.setMultiple(true);
		    			try {
							parent.completeAction(parent.SELECT_PDFFILE);
						} catch (AWTException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
   	    			 	if(parent.repetitiveList.contains(parent.PASTE_TO_NOTEPAD))
   	    			 		SkipOrDetail();
        	    	 	if(parent.getDetails()) {		
			    	    	int selected_size=selected.size();
        	    	 		Thread one = new Thread() {
		    	    		public void run() {		
				    			for(int i=0;i<selected_size;i++) {
					    	    	int pdfFile=selected.pollFirst()-1;					    											    			
					    	    	try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
					    	    	robot.mouseMove(0, 0);
					    	    	robot.mouseMove(20, 880);
					    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
					    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);							    											    			
					    	    	try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
					    	    	//System.out.println(pdfFile);
					    	    	robot.mouseMove(0, 0);
					    	    	robot.mouseMove(PDF_ABS[pdfFile].x,PDF_ABS[pdfFile].y);
					    			
									try {
									Thread.sleep(500);
									} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									}
					    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
					    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);					    											    			
					    	    	try {
										Thread.sleep((parent.repetitiveList.size())*2000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
				    			} 
			                	parent.setMultiple(false);
					    		parent.DoneAndContinue();
			                	;
		    	    		}	    		
		    	    	};
		    	    	one.start();
        	    	 	}
        	    	 	else {
			    	    	robot.mouseMove(0, 0);
			    	    	//System.out.println(MouseInfo.getPointerInfo().getLocation());
			    	    	robot.mouseMove(400, 400);
			    	    	//System.out.println(MouseInfo.getPointerInfo().getLocation());
			    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
			    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);	
			    	    	int selected_size=selected.size();
			    	    	Thread one = new Thread() {
			    	    		public void run() {
					    			for(int i=0;i<selected_size;i++) {
						    	    	System.out.println(i);
					        			parent.lastPDF=selected.pollFirst();
						    	    	try {
											Thread.sleep(500);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    	    	robot.keyPress(KeyEvent.VK_CONTROL);
						    	    	robot.keyPress(KeyEvent.VK_V);
						    	    	robot.keyRelease(KeyEvent.VK_V);
						    	    	robot.keyRelease(KeyEvent.VK_CONTROL);
						    	    	try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					    			} 
				                	parent.setMultiple(false);
						    		parent.DoneAndContinue();
			    	    		}	    		
			    	    	};
			    	    	one.start();
		
        	    	 	}
                }
                	alt=false;
                }
          }
    });
	    
	    this.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent e) {
	            parent.init();
	            e.getWindow().dispose();
	        }
	    });
	    setVisible(true);
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


	
	private void SkipSingleDoc(Robot robot) {
		Thread one = new Thread() {
    		public void run() {
    			robot.mouseMove(0, 0);
    	    	//System.out.println(MouseInfo.getPointerInfo().getLocation());
    	    	robot.mouseMove(400, 400);
    	    	//System.out.println(MouseInfo.getPointerInfo().getLocation());
    	    	robot.mousePress(InputEvent.BUTTON1_MASK);
    	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
    		    robot.keyPress(KeyEvent.VK_CONTROL);
    		    robot.keyPress(KeyEvent.VK_V);
    		    robot.keyRelease(KeyEvent.VK_V);
    		    robot.keyRelease(KeyEvent.VK_CONTROL);
    		    try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			PARENT.DoneAndContinue();
    		}
    	};
    	one.start();
	}
}

