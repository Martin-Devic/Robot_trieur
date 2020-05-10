package Package1;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JPanel panel= new JPanel();
    JPanel grid= new JPanel();
    JPanel Conteneur = (JPanel) this.getContentPane();
    
    
    		
    //CONSTRUCTEUR
    public Fenetre(int l , int c) {

    	//Création fenetre
    	this.setTitle("Terrain");
        this.setSize(l, c);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.isAlwaysOnTop();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.add(createToolBar(),BorderLayout.NORTH);
        
        
        
      }
    
    
  
      
   
}


