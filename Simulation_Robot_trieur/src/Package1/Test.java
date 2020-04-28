package Package1;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
	 
	 

	public static void main(String[] args) {
		
		
		//Cr�ation matrice d'entier alatoire qui simule un terrain avec des 
		//positions de d�chets al�atoire et le robot situ� en haut a droite (0,0)
		int[][] mat_ini = new int[20][20];
     for (int i=0;i<20;i++) {
     	for (int j=0;j<20;j++) {
     	
     		double d = Math.random();
         	double nbr_alea =d *100;
         		if (nbr_alea<10.0 && nbr_alea>5.0) { 
         			mat_ini[i][j]=2;
         			
         		}
         		else if(0<nbr_alea && nbr_alea<5 ) {
         			mat_ini[i][j]=3;
         		}
         		else {
         			mat_ini[i][j]=0;
         		}
     	}
     }
     mat_ini[0][0]=1;
     
	 int[][] mat = mat_ini;
     Map terrain = new Map(mat);
     Robot robot1=new Robot(3,4);
     System.out.println(robot1.getX());
     
     
	     //Cr�ation d'une collection comprenant les dechets et le robot
	     ArrayList li = new ArrayList();
	     for (int i=0;i<20;i++) {
		     	for (int j=0;j<20;j++) {
		     		if(mat[i][j]==1) {
		     			Robot robot =new Robot(i,j);
		     			li.add(robot);
		     			
		     		}
		     		else if (mat[i][j]==2) {
		     			M�tal metal =new M�tal(i,j);
		     			li.add(metal);
		     		}
		     		else if (mat[i][j]==3) {
		     			Verre verre =new Verre(i,j);
		     			li.add(verre);
		     		}
		     		
		     		
		     	}
		  }
	     
	     //It�rateur de la collection pour pouvoir la parcourir
		 Iterator it =li.iterator(); 	
	     
	     //System.out.println(li);
	     //System.out.println(li.size());
	     
	     
	     
	     while (it.hasNext()) {
	    	 Object o = it.next();
	    	 if(o.getClass().toString().contains("Verre")) {
	    		System.out.println(o.getClass()); 
	    	 }
	     }
	     
	     
	     //Affichage de la fenetre
	     Fenetre fen = new Fenetre(mat);
	     fen.setVisible(true);

}

	}


