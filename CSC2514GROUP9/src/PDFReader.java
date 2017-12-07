import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.*;

public class PDFReader extends JDialog {

	public static final Rectangle TITLE = new Rectangle(420, 100, 980, 150);
	private static Point mousePt;
	private static int startX = -1;
	private static int startY = -1;
	private static int endX = -1;
	private static int endY = -1;
	private static PDFReader self;
	private static int ID;

	public PDFReader(Desktop parent, boolean auto, String first_img, String second_img) {
		super(parent);
		toFront();
		setFocusable(true);
		requestFocus();
		setTitle("PDF Reader");
		setName("PDF Reader");
		setSize(1820, 1610);
		setLocation(900, 40);
		self = this;
		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(first_img));
		add(background);
		background.setLayout(new FlowLayout());
		
		this.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_C&& e.isControlDown()) {
		        	parent.lastPDF=parent.getPDFCount();
		        	ActionItem action=new ActionItem(parent.COPY_TITLE,self);
		        	parent.addAction(action);
                }
          }
		});
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) {
					e.consume();
					if (TITLE.contains(e.getPoint())) {
						// handle double click event.
						background.setIcon(new ImageIcon(second_img));
					}
				} else {
					mousePt = e.getPoint();
					System.out.println("line 41, PDFReader: " + "x:" + mousePt.x + "y:" + mousePt.y);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (TITLE.contains(e.getPoint()) && TITLE.contains(mousePt)) {
					background.setIcon(new ImageIcon(second_img));
					if (!parent.getPDFUserDecision()) {
						ActionItem action = new ActionItem(parent.SELECT_TITLE, self);
						parent.addAction(action);
					}
				}
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {
		});

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				if (!parent.getPDFUserDecision()) {
					ActionItem action = new ActionItem(parent.CLOSE_PDFFILE, self);
					parent.addAction(action);
				}
				e.getWindow().dispose();
			}
		});

		setVisible(true);

		if (auto) {
			Thread one = new Thread() {
				public void run() {
					try {
						Thread.sleep(1000);
						Robot robot = parent.getRobot();
						for (int i = parent.currentStepID; i < parent.repetitiveList.size(); i++) {
							if (parent.repetitiveList.get(i) == parent.SELECT_TITLE) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								;
								robot.mouseMove(0, 0);
								robot.mouseMove(700*2, 80*2);
								System.out.println("LINE90: "+MouseInfo.getPointerInfo().getLocation());

								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								robot.mousePress(InputEvent.BUTTON1_MASK);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								robot.mouseMove(0, 0);
								robot.mouseMove(905*2, 120*2);
								System.out.println("LINE107: "+MouseInfo.getPointerInfo().getLocation());

								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								robot.mouseRelease(InputEvent.BUTTON1_MASK);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								parent.completeAction(parent.SELECT_TITLE);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (parent.repetitiveList.get(i) == parent.CLOSE_PDFFILE) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								robot.mouseMove(0, 0);
								robot.mouseMove(1350*2, 25*2);
								System.out.println("LINE107: "+MouseInfo.getPointerInfo().getLocation());

								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								robot.mousePress(InputEvent.BUTTON1_MASK);
								robot.mouseRelease(InputEvent.BUTTON1_MASK);								System.out.println("LINE107: "+MouseInfo.getPointerInfo().getLocation());

								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								parent.completeAction(parent.CLOSE_PDFFILE);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (parent.repetitiveList.get(i) == parent.COPY_TITLE) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								robot.mouseMove(0, 0);
								robot.mouseMove(700*2, 180*2);

								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								robot.keyPress(KeyEvent.VK_CONTROL);
								robot.keyPress(KeyEvent.VK_C);
								robot.keyRelease(KeyEvent.VK_C);
								robot.keyRelease(KeyEvent.VK_CONTROL);								

								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								parent.completeAction(parent.COPY_TITLE);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} else if (parent.repetitiveList.get(i) == parent.PASTE_TO_NOTEPAD) {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								robot.mouseMove(0, 0);
								System.out.println("LINE146: "+MouseInfo.getPointerInfo().getLocation());
								robot.mouseMove(160*2, 151*2);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("LINE148: "+MouseInfo.getPointerInfo().getLocation());
								robot.mousePress(InputEvent.BUTTON1_MASK);
								robot.mouseRelease(InputEvent.BUTTON1_MASK);
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
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								parent.completeAction(parent.PASTE_TO_NOTEPAD);
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			one.start();
		}

	}

}
