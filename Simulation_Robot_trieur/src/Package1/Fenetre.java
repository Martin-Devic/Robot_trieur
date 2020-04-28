package Package1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel= new JPanel();
    JPanel grid= new JPanel();
    
    public Fenetre(int[][] mat_ini) {

    	//Création fenetre
    	this.setTitle("Terrain");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.isAlwaysOnTop();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Création contenu dans la fenetre
        JPanel Conteneur = (JPanel) this.getContentPane(); 
        
        //Creation grille
        Conteneur.setLayout(new GridLayout(20,20,1,1)); 
        Conteneur.setBackground(Color.black);
        
        
        //Ajout des panels de couleurs dans la grille
        for (int i=0;i<20;i++) {
        	for (int j=0;j<20;j++) {
        		if (mat_ini[i][j]==2) { 
        			Conteneur.add(creationpanel2());
        		}
        		else if(mat_ini[i][j]==3 ) {
        		Conteneur.add(creationpanel3());
        		}
        		else if (mat_ini[i][j]==1) {
        			Conteneur.add(creationpanelr());
        		}
        		else {
        			Conteneur.add(creationpanel());
        		} 
        
        
        }
       
    }
    }
        
    	//Création préalable des panels de différentes couleurs
        private JPanel creationpanel() {
        	JPanel panel1=new JPanel();
        	panel1.setBackground(Color.white);
        	return panel1;
        }
        private JPanel creationpanel2() {
        	JPanel panel1=new JPanel();
        	panel1.setBackground(Color.blue);
        	return panel1;
        }
       
        private JPanel creationpanel3() {
        	JPanel panel1=new JPanel();
        	panel1.setBackground(Color.green);
        	return panel1;
        }
         
        private JPanel creationpanelr() {
        	JPanel panel1=new JPanel();
        	panel1.setBackground(Color.black);
        	return panel1;
        }
        
      
      
   
}


