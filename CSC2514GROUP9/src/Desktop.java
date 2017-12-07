import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.*;

public class Desktop
extends JFrame {
	public static  Robot robot = null;
	
	public static final String DESKTOP_IMG="./imgs/desktop.png";
	public static final Rectangle PDF_FOLDER=new Rectangle(0,173,152,196);
	public static final Rectangle NOTEPAD_ICON=new Rectangle(1000,1744,70,60);
	public final Integer OPEN_PDFFOLDER=0;
	public final Integer SELECT_PDFFILE=1;
	public final Integer SELECT_TITLE=2;
	public final Integer CLOSE_PDFFILE=3;
	public final Integer COPY_TITLE=4;
	public final Integer OPEN_NOTEPAD=5;
	public final Integer PASTE_TO_NOTEPAD=6;
	public final Integer CLOSE_PDFFOLDER=7;
	public final Integer CLOSE_NOTEPAD=8;
	public final Integer OPEN_PDFFILE=9;
	
	public final Integer PDFFOLDER=0;
	public final Integer PDFFILE=1;
	public final Integer NOTEPAD=2;	
	
    public boolean PDF_USERDECISION=false;
    public boolean DETAILS=true;
    public int PDF_COUNT=0;
    public boolean do_not_bother=false;
    public static boolean multiple=false;
	private static int repetitive_count=0;
	private boolean repetitive_detected=false;
	public static PDFFolder pdfFolder;
	public static Notepad notepad;
	public Integer currentStepID=-1;
	
	public static LinkedList<ActionItem> actionList=new LinkedList<ActionItem>();
	//private static LinkedList<Integer> actionList;
	public static LinkedList<Integer> repetitiveList=new LinkedList<Integer>();
	
	private LinkedList<Integer> actionQueue=new LinkedList<Integer>();
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
	
	public void addAction(ActionItem action) {
		actionList.add(action);
		actionQueue.add(action.getID());
		System.out.println(actionQueue);
		if(!do_not_bother && !PDF_USERDECISION)
			checkRepetitive();
	}
	
	public void completeAction(Integer actionID) throws AWTException {
		int index=repetitiveList.indexOf(actionID);
		if(index+1<repetitiveList.size()) {
			currentStepID=index+1;			
		}
		else if(index+1==repetitiveList.size()){
			currentStepID=-1;
		 	if(!multiple) {
		 		DoneAndContinue();
		 	}
		}
	}
	
	private void checkRepetitive() {
		Integer start_action;
		int start_index=-1;
		int end_index=-1;
		for(int i=0; i<actionList.size();i++) {
			ActionItem current=actionList.get(i);
			int repeated_times=1;
			for(int j=i+1;j<actionList.size();j++) {
				ActionItem compareTo=actionList.get(j);
				if(current.getID()==compareTo.getID()) {
					repeated_times++;
				}
				if(repeated_times==3 && current.getID()==SELECT_PDFFILE) {
					repetitive_detected=true;
					repetitiveList.add(current.getID());
					start_action=current.getID();
					start_index=i;
					end_index=j;
					break;
				}
			}
			if(repetitive_detected) {
				break;
			}
		}
		if(repetitive_detected) {
			LinkedList<Integer> candidate_list=new LinkedList<Integer>();
			 for(int i=start_index+1;i<end_index;i++) {
				 candidate_list.add(actionList.get(i).getID());			
			 }
			 while(!candidate_list.isEmpty()) {
				 Integer currentActionID=candidate_list.pollFirst();
				 for(int i=1;i<candidate_list.size();i++) {
					 if(currentActionID==candidate_list.get(i)) {
						 repetitiveList.add(currentActionID);
						 candidate_list.remove(i);
						 break;
					 }
				 }
			 }
			 System.out.println("Repetitive Detected: "+repetitiveList);
			 UIManager.put("OptionPane.messageFont", new Font("System", Font.PLAIN, 30));
	    	 UIManager.put("OptionPane.buttonFont", new Font("System", Font.PLAIN, 30));
	    	 if (JOptionPane.showConfirmDialog(null,
                    "Repetitive task detected, do you want to automate it?",
                    "Automate Request", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
	    		    // yes option
	    		 	setPDFUserDecision(true);
	    		 	do_not_bother=true;
	    		 	if(repetitiveList.getFirst()==SELECT_PDFFILE) {
	    		 		pdfFolder.toFront();
	    		 		pdfFolder.repaint();
	    		 		pdfFolder.requestFocus();
	    		 	}
	    		} else {
	    		    // no option
	    		 	setPDFUserDecision(false);
	    		 	do_not_bother=true;
	    		 	
	    		}
		}
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
    do_not_bother=false;
    multiple=false;
	repetitive_count=0;
	repetitive_detected=false;
	pdfFolder=null;
	notepad=null;
	currentStepID=-1;
	
	actionList.clear();
	//private static LinkedList<Integer> actionList;
	repetitiveList.clear();
	actionQueue.clear();
    }

	public void DoneAndContinue(){
   	 UIManager.put("OptionPane.messageFont", new Font("System", Font.PLAIN, 30));
   	 UIManager.put("OptionPane.buttonFont", new Font("System", Font.PLAIN, 30));
   	 if (JOptionPane.showConfirmDialog(null,
                "The selected items were done! Do you want to continue the automation?",
                "Task Done", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
   		    // yes option
	    	robot.mouseMove(0, 0);
	    	robot.mouseMove(20, 880);
	    	robot.mousePress(InputEvent.BUTTON1_MASK);
	    	robot.mouseRelease(InputEvent.BUTTON1_MASK);	
   		} else {
   		    // no option
   		 	setPDFUserDecision(false);
   		}
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
								pdfFolder=new PDFFolder(desktop);
							} catch (AWTException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	        	     }
	        	     else if(NOTEPAD_ICON.contains(e.getPoint())) {
		        	     //handle double click event.
		        			 notepad=new Notepad(desktop);
	        	     }
	        	}
	        }
	     });
	}
}
