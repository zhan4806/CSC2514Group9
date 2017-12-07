import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.*;

public class Notepad 
extends JDialog  {

	public static final String PREFIX="./imgs/notepad";
	public static final String SURFIX=".png";
 	public static final String PDF1="ERACER: A Database Approach for Statistical Inference and Data Cleaning";
	public static final String PDF2="KATARA: A Data Cleaning System Powered by KnowledgeBases and Crowdsourcing";
	public static final String PDF3="Answering Table Queries on the Web using Column Keywords";
	public static final String PDF4="LSH Ensemble: Internet-Scale Domain Search";
	public static final String PDF5="Scaling Up All Pairs Similarity Search";
	public static final String PDF6="Schema Extraction for Tabular Data on the Web *";
	public static final String PDF7="Stitching Web Tables for Improving Matching Quality";
	public static final String[] PDF_TITLES= {PDF1,PDF2,PDF3,PDF4,PDF5,PDF6,PDF7};
	private static LinkedList<String> last_step=new LinkedList<String>();
	private static LinkedList<String> future_step=new LinkedList<String>();
	private static int ID;
	private static Notepad self;
	
	public Notepad(Desktop parent) {
		super(parent);
		setTitle("Untitled");
		setName("Notepad");
		setSize(2035,1222);
		setLocation(300,300);
		self=this;
		JTextArea txtArea = new JTextArea("");
		txtArea.setFont(txtArea.getFont().deriveFont(24f));
		this.add(txtArea);
		Action doClipboard = new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {	          
	        	int line_count=parent.lastPDF;
	    	     String title=PDF_TITLES[line_count-1];
	    	     if(!parent.getPDFUserDecision()) {
		    	     last_step.addLast(txtArea.getText());
	    	 		 txtArea.append(title+"\n");

		              if(!parent.getPDFUserDecision()) {
		         	      ActionItem action= new ActionItem(parent.PASTE_TO_NOTEPAD,self);
		         	      parent.addAction(action);          	  
		              }
	    	     }else {
		    	     last_step.addLast(txtArea.getText());
		    	     System.out.println("Notepad line 58: "+parent.getPDFCount());
	    	 		 txtArea.append(title+"\n");
	    	     }
	    	     future_step=new LinkedList<String>();

	             
	      }
	  };
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK);
		txtArea.getInputMap().put(key,doClipboard);
		
		Action doUndo = new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {
	        	String previous_step=last_step.pollLast();
	        	future_step.addFirst(txtArea.getText());
	        	txtArea.setText(previous_step);  
	      }
	  };
		KeyStroke undo_key = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Event.CTRL_MASK);
		txtArea.getInputMap().put(undo_key,doUndo);
		
		Action doRedo = new AbstractAction() {
	        public void actionPerformed(ActionEvent e) {
	        	String next_step;
	        	if(future_step.size()==1) {
		        	next_step=future_step.peekFirst();
	        	}else {
		        	next_step=future_step.pollFirst();
	        	}
	        	last_step.addLast(txtArea.getText());
	        	txtArea.setText(next_step);  
	      }
	  };
		KeyStroke redo_key = KeyStroke.getKeyStroke(KeyEvent.VK_Y, Event.CTRL_MASK);
		txtArea.getInputMap().put(redo_key,doRedo);
		
	    this.addWindowListener(new java.awt.event.WindowAdapter() {
	        @Override
	        public void windowClosing(java.awt.event.WindowEvent e) {
	            parent.init();
	            e.getWindow().dispose();
	        }
	    });
		setVisible(true);
	}

}
