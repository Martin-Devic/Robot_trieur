package Package1;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

public class Test {
	 public static void main(String[] args) {
	 //private int getXDechet (int row, int col) {
	   //      int index = row * 20 + col;
	     //    return li.get(index).getX();
	       //  }

	
		 
		
		//Création matrice d'entier alatoire qui simule un terrain avec des 
		//positions de déchets aléatoire et le robot situé en haut a droite (0,0)
		int[][] mat_ini = new int[20][20];
     
     	Map terrain = new Map(mat_ini);
		int[][] mat = terrain.création_map(20,20);
		
    
	    //Création d'une collection comprenant les dechets et le robot
	    ArrayList<Dechet> li = new ArrayList<Dechet>();
	    for (int i=0;i<20;i++) {
		     	for (int j=0;j<20;j++) {
		     		//if(mat[i][j]==1) {
		     			//Robot robot =new Robot(i,j);
		     			//li.add(robot);
		     			
		     		//}
		     		if (mat[i][j]==2) {
		     			Dechet metal =new Métal(i,j);
		     			li.add(metal);
		     		}
		     		else if (mat[i][j]==3) {
		     			Dechet verre =new Verre(i,j);
		     			li.add(verre);
		     		}
		     		
		     		
		     	}
		  }
	      
	     
	     
	     
	     //Itérateur de la collection pour pouvoir la parcourir
		 Iterator it =li.iterator(); 	
	     
	     //System.out.println(li);
	     //System.out.println(li.size());
	     
	    
	     
	     while (it.hasNext()) {
	    	 Object o = it.next();
	    	 if(o.getClass().toString().contains("Métal")) {
	    		System.out.println(o); 
	    	 }
	     }
	     
	     
	     //Affichage de la fenetre
	     Fenetre fen0 = new Fenetre(mat);
	     fen0.setVisible(true);
	     
	     

	}

}


