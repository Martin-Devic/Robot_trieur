package Package1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

import javax.swing.JButton;



public class Test {
	
	
	//M�thode qui cr�e la liste des dechets de la matrice initiale
	public static List collectionD(int [][] mat){
		//Dechet dech[];
		List<Dechet> dech =new ArrayList<Dechet>();
		//dech = new Dechet[40];
		//int cpt=0;
		for (int i=0;i<20;i++) {
			for (int j=0;j<20;j++) {
				if (mat[i][j]==2) {
		     		Dechet metal =new M�tal(i,j);
		     		
		     		dech.add(metal);
		     		
		     		//cpt+=1;
		
		     	}
		     	else if (mat[i][j]==3) {
		     		Dechet verre =new Verre(i,j);
		     		
		     		dech.add(verre);
		     
		     		//cpt+=1;
		     		
		     	}	
		     }
	    }
		return dech;
	}
	
	//M�thode qui cr�e l'objet robot a partir de la matrice initiale
	public static Robot objetR(int [][] mat) {
		Robot robot=new Robot(0,0);
		for (int i=0;i<20;i++) {
			for (int j=0;j<20;j++) {
				if (mat[i][j]==1) {
					robot.setX(i);
					robot.setY(j);
				}
			}
		}
		return robot;
	}
	
	
	//m�thode modifiant la matrice qui permet de faire l'affichage
	public static void MatriceAffichage(Robot robot,List<Dechet> dechet,int[][] mat,List<Tas>tas) {
		
		for (int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				mat[i][j]=0;
			}
		}
		for(Dechet d : dechet) {
			if(d.toString().contains("M�tal")) {
				mat[d.getX()][d.getY()]=2;
			}
			else if (d.toString().contains("Verre")) {
				mat[d.getX()][d.getY()]=3;
			}
		}
		
		for (Tas t : tas) {
			if (t.getNbr()>0) {
				
			
			if (t.getName().contains("Verre")) {
				int nbr=t.getNbr();
				mat[t.getX()][t.getY()]=100+nbr;
			}
			else if (t.getName().contains("M�tal")) {
				int nbr=t.getNbr();
				mat[t.getX()][t.getY()]=200+nbr;
			}
		}
		
		}	
		
		mat[robot.getX()][robot.getY()]=1;
		
		
	}
	
	//**********************************************************
	
	
	 public static void main(String[] args) throws InterruptedException {
		 int nb_dechets =40;
	
		 
		
		//Cr�ation matrice d'entier alatoire qui simule un terrain avec des 
		//positions de d�chets al�atoire et le robot situ� en haut a droite (0,0)
		int[][] mat_ini = new int[20][20];
     
     	Map terrain = new Map(mat_ini);
		int[][] mat = terrain.cr�ation_map(20,20, nb_dechets);
		
    
	    //Cr�ation d'une collection comprenant les dechets 
		
		List<Dechet> liste_dechet =collectionD(mat);
		List<Tas>liste_tas=new ArrayList();
		 
		  //It�rateur de la collection pour pouvoir la parcourir
		for(int i = 0; i < nb_dechets; i++){
			//System.out.println("donn�e � l'indice " + i + " = " + liste_dechet.get(i) +" "+ liste_dechet.get(i).getX()+"-"+liste_dechet.get(i).getY());
		}
		
		//Cr�ation objet Robot
		
		Robot robot= objetR(mat);
		robot.setFree(true);
		
		//Cr�ation Tas
		
		Tas tVerre = new Tas();
		Tas tM�tal = new Tas();
		
		liste_tas.add(tVerre);
		liste_tas.add(tM�tal);
		
		Panel pan =new Panel(mat);
		Fenetre fen0 = new Fenetre();
		fen0.setVisible(true);
		fen0.setContentPane(pan);

		
		
		while(liste_dechet.size()!=0) {
		if (robot.getFree()) {
			int l =robot.dist_robot(liste_dechet);
			Dechet d =liste_dechet.get(l);
			
			//System.out.println("Coordonn�es dechet");
			//System.out.println(d.getX());
			//System.out.println(d.getY());
			//System.out.println("******************");
			
			while (robot.getX()!=d.getX() || robot.getY()!=d.getY()) {
				robot.deplacement(d.getX(),d.getY());
				//System.out.println(robot.getX()+" "+robot.getY());
				Thread.sleep(500);
				
				//Affichage de la fenetre
				
				MatriceAffichage(robot,liste_dechet,mat,liste_tas);
				Panel pan1 =new Panel(mat);
				fen0.setContentPane(pan1);
				fen0.setVisible(true);
				
				
			}
			robot.setFree(false);
			robot.setDechet(d);
			liste_dechet.remove(l);
		}
		else {
			
			if(robot.getDechet().toString().contains("Verre")) {
				if(tVerre.getNbr()==0) {
					int p =robot.dist_robot_type(liste_dechet);
					tVerre.add_dechet(liste_dechet.get(p));
					
				}
				
				while(robot.getX()!=tVerre.getX() || robot.getY()!=tVerre.getY()) {
					robot.deplacement(tVerre.getX(),tVerre.getY());
					//System.out.println(robot.getX()+" "+robot.getY());
					Thread.sleep(500);
					
					//Affichage de la fenetre
					MatriceAffichage(robot,liste_dechet,mat,liste_tas);
					Panel pan1 =new Panel(mat);
					fen0.setContentPane(pan1);
					fen0.setVisible(true);
				}
				robot.setFree(true);
				tVerre.add_dechet(robot.getDechet());
				
			}
			
			else {
				
				if (tM�tal.getNbr()==0) {
					int p =robot.dist_robot_type(liste_dechet);
					tM�tal.add_dechet(liste_dechet.get(p));
					
				}
				while(robot.getX()!=tM�tal.getX() || robot.getY()!=tM�tal.getY()) {
					robot.deplacement(tM�tal.getX(),tM�tal.getY());
					//System.out.println(robot.getX()+" "+robot.getY());
					Thread.sleep(500);
					
					
					//Affichage de la fenetre
					MatriceAffichage(robot,liste_dechet,mat,liste_tas);
					Panel pan1 =new Panel(mat);
					fen0.setContentPane(pan1);
					fen0.setVisible(true);
				}
				robot.setFree(true);
				tM�tal.add_dechet(robot.getDechet());
				System.out.println(tM�tal.getX());
				System.out.println(tM�tal.toString());
			}
			
		}
		
	
	     
	     
	 }

	}

}






