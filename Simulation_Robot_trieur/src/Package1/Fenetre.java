package Package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel= new JPanel();
    JPanel grid= new JPanel();
    JPanel Conteneur = (JPanel) this.getContentPane();
    
    
    		
    		
    public Fenetre() {

    	//Création fenetre
    	this.setTitle("Terrain");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.isAlwaysOnTop();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.add(createToolBar(),BorderLayout.NORTH);
        
        
        
      }
    
    
  
      
   
}


