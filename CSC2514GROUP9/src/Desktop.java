import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Desktop
extends JFrame {
	public static  Robot robot = null;
	
	public static final String DESKTOP_IMG="./imgs/desktop.png";
	public static final Rectangle PDF_FOLDER=new Rectangle(0,173,152,196);
	public static final Rectangle NOTEPAD_ICON=new Rectangle(1000,1744,70,60);
    public boolean PDF_USERDECISION=false;
    public boolean DETAILS=true;
    public int PDF_COUNT=0;
    public static boolean multiple=false;
	private static int repetitive_count=0;
    
	public Desktop() {
		setSize(2736,1824);		
		setLayout(new BorderLayout());
	    JLabel background=new JLabel(new ImageIcon(DESKTOP_IMG));
	    add(background);
	    background.setLayout(new FlowLayout());
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setUndecorated(true);
	    
		setVisible(true);
	}
	public boolean getMultiple(){
        return multiple;
    }

    public void setMultiple( boolean multi ){
    	multiple = multi; 
    }
	public boolean getPDFUserDecision(){
        return PDF_USERDECISION;
    }

    public void setPDFUserDecision( boolean decision ){
    	PDF_USERDECISION = decision; 
    }

	public boolean getDetails(){
        return DETAILS;
    }

    public void setDetails( boolean details ){
    	DETAILS = details; 
    }
	public int getPDFCount(){
        return PDF_COUNT;
    }

    public void setPDFCount( int count ){
    	PDF_COUNT = count; 
    }
    

	public Robot getRobot(){
        return robot;
    }

    public void setRobot( Robot new_robot ){
    	robot = new_robot; 
    }

	public int getRepetitiveCount(){
        return repetitive_count;
    }

    public void setRepetitiveCount( int count ){
    	repetitive_count = count; 
    }
    public void init() {
        PDF_USERDECISION=false;
        DETAILS=true;
        PDF_COUNT=0;
        multiple=false;    	
        repetitive_count=0;
    }
    
	public static void main(String[] args) throws AWTException {
		
		Desktop desktop=new Desktop();
		robot= new Robot();
		desktop.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mousePressed(MouseEvent e) {
	        	if (e.getClickCount() == 2 && !e.isConsumed()) {
	        	     e.consume();
	        	     if(PDF_FOLDER.contains(e.getPoint())) {
		        	     //handle double click event.
		        			try {
								PDFFolder pdfFolder=new PDFFolder(desktop);
							} catch (AWTException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	        	     }
	        	     else if(NOTEPAD_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			Notepad notepad=new Notepad(desktop);
	        	     }
	        	}
	        }
	     });
	}
}