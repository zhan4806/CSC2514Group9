import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Notepad 
extends JDialog  {

	public static final String PREFIX="./imgs/notepad";
	public static final String SURFIX=".png";
	private static int repetitive_count=0;
 	public static final String PDF1="ERACER: A Database Approach for Statistical Inference and Data Cleaning";
	public static final String PDF2="KATARA: A Data Cleaning System Powered by KnowledgeBases and Crowdsourcing";
	public static final String PDF3="Answering Table Queries on the Web using Column Keywords";
	public static final String PDF4="LSH Ensemble: Internet-Scale Domain Search";
	public static final String PDF5="Scaling Up All Pairs Similarity Search";
	public static final String PDF6="Schema Extraction for Tabular Data on the Web *";
	public static final String PDF7="Stitching Web Tables for Improving Matching Quality";
	public static final String[] PDF_TITLES= {PDF1,PDF2,PDF3,PDF4,PDF5,PDF6,PDF7};
	private static String last_step="";
	
	public Notepad(Desktop parent) {
		super(parent);
		setTitle("Untitled");
		setSize(2035,1222);
		setLocation(300,300);
		JTextArea txtArea = new JTextArea("");
		txtArea.setFont(txtArea.getFont().deriveFont(24f));
		this.add(txtArea);
		Action doClipboard = new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {	          
	        	int line_count=parent.getPDFCount();
	    	     String title=PDF_TITLES[line_count-1];
	    	     if(!parent.getPDFUserDecision()) {
	    	    	 repetitive_count++;
	    	    	 if(!parent.getMultiple()) {
		    	    	 last_step=txtArea.getText();    	    		 
	    	    	 }
	    	 		 txtArea.append(title+"\n");
		    	     if(repetitive_count==2) {
		    	    	 UIManager.put("OptionPane.messageFont", new Font("System", Font.PLAIN, 30));
		    	    	 UIManager.put("OptionPane.buttonFont", new Font("System", Font.PLAIN, 30));
		    	    	 if (JOptionPane.showConfirmDialog(null,
	                             "Repetitive task detected, do you want to automate it?",
	                             "Automate Request", 
	                             JOptionPane.YES_NO_OPTION,
	                             JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
		    	    		    // yes option
		    	    		 	parent.setPDFUserDecision(true);
		    	    		 	System.out.println(parent.getPDFUserDecision());
		    	    		} else {
		    	    		    // no option
		    	    		 	parent.setPDFUserDecision(false);
		    	    		 	System.out.println(parent.getPDFUserDecision());
		    	    		}
		    	     }	    	    	 
	    	     }else {
	    	    	 if(!parent.getMultiple()) {
		    	    	 last_step=txtArea.getText();    	    		 
	    	    	 }
	    	    	 System.out.println(parent.getPDFCount());
	    	 		 txtArea.append(title+"\n");
	    	     }
	             
	      }
	  };
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK);
		txtArea.getInputMap().put(key,doClipboard);
		
		Action doUndo = new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {	          
	        	txtArea.setText(last_step);  
	      }
	  };
		KeyStroke undo_key = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.CTRL_MASK);
		txtArea.getInputMap().put(undo_key,doUndo);
//	    this.addKeyListener(new KeyAdapter(){
//	    	public void keyPressed(KeyEvent e) {                
//            if(e.isControlDown() && e.getKeyChar() != 'v' && e.getKeyCode() == 86){
//	             e.consume();
//	             int line_count=parent.getPDFCount();
//	    	     String title=PDF_TITLES[line_count-1];
//	    	     if(!parent.getPDFUserDecision()) {
//	    	    	 repetitive_count++;
//	    	    	 last_step=txtArea.getText();
//	    	 		 txtArea.append(title+"\n");
//		    	     if(repetitive_count==2) {
//		    	    	 UIManager.put("OptionPane.messageFont", new Font("System", Font.PLAIN, 30));
//		    	    	 UIManager.put("OptionPane.buttonFont", new Font("System", Font.PLAIN, 30));
//		    	    	 if (JOptionPane.showConfirmDialog(null,
//	                             "Repetitive task detected, do you want to automate it?",
//	                             "Automate Request", 
//	                             JOptionPane.YES_NO_OPTION,
//	                             JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
//		    	    		    // yes option
//		    	    		 	parent.setPDFUserDecision(true);
//		    	    		} else {
//		    	    		    // no option
//		    	    		 	parent.setPDFUserDecision(false);
//		    	    		}
//		    	     }	    	    	 
//	    	     }else {
//	    	    	 last_step=txtArea.getText();
//	    	 		 txtArea.append(title+"\n");
//	    	     }
//    	     }
//            
//            if(e.isControlDown() && e.getKeyChar() != 'z' && e.getKeyCode() == 86){
//            	txtArea.setText(last_step);
//            }
//          }    
//	    });
		setVisible(true);
	}

}
