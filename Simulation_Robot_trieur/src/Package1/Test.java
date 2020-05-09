package Package1;


import java.util.ArrayList;

import java.util.List;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;



public class Test {
	
	//nombre d�finissant le nombre de robots , initialis� � un
	static int nbr_robots =1; 
	
	
	//m�thode d�finissant le nombre de robots
	
	public static void setNbrRobots(int a) {
		nbr_robots=a;
	}
	//bool�en permettant de d�marrer la simulation
	static boolean startb =false;
	
	//m�thode permettant de modifier le bool�en startb
	public static void setStartb(boolean a) {
		startb=a;
	}
	
	//M�thode qui cr�e la liste des robots
		public static List collectionR(int [][] mat){
			List<Robot> rob =new ArrayList<Robot>();
			
			for (int i=0;i<20;i++) {
				for (int j=0;j<20;j++) {
					if (mat[i][j]==1) {
			     		Robot robot =new Robot(i,j);
			     		robot.setFree(true);
			     		rob.add(robot);
			     	}	
			     }	
			}
			return rob;
		}
		
		
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
		     	else if (mat[i][j]==4) {
		     		Dechet plastique =new Plastique(i,j);
		     		
		     		dech.add(plastique);
		     
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
	public static void MatriceAffichage(List<Robot> robots ,List<Dechet> dechet,int[][] mat,List<Tas>tas) {
		
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
			else if (d.toString().contains("Plastique")) {
				mat[d.getX()][d.getY()]=4;
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
			else if (t.getName().contains("Plastique")) {
				int nbr=t.getNbr();
				mat[t.getX()][t.getY()]=300+nbr;
			}
		}
		
		}	
		for (Robot r : robots) {
			
			if (r.getFree()) {
				mat[r.getX()][r.getY()] = 1;	
			}
			
			else {
				String ctype=r.getDechet().toString();
				if (ctype.contains("Verre")){
					mat[r.getX()][r.getY()] = 12;
				}
				if (ctype.contains("M�tal")){
					mat[r.getX()][r.getY()] = 13;
				}
				if (ctype.contains("Plastique")){
					mat[r.getX()][r.getY()] = 14;
				}
			}
				
		}
		
		
		
		
	}
	
	public static void affichage_fenetre(int[][] mat, List<Robot> robots ,List<Dechet> dechet,List<Tas>tas,Fenetre fen0) {
		MatriceAffichage(robots,dechet,mat,tas);
		Panel pan1 =new Panel(mat);
		
		fen0.setContentPane(pan1);
		fen0.setVisible(true);
	}
	

	
	//cr�ation barre de d�marrage
  	private static JToolBar createToolBar() {
  		JToolBar tb =new JToolBar();
  		JButton start = new JButton("Start");
  		start.addActionListener(new BoutonListener());
  		tb.add(start);
  		tb.add(new JLabel("Simulation de robots trieurs"));
  		return tb;
  	}
  	
  	//cr�ation panneau des boutons pour le nombre de robots
  	private static JPanel createBoutons() {
  		JPanel panneau =new JPanel();
  		JButton b1 = new JButton("1 robot");
  		JButton b2 = new JButton("2 robots");
  		b2.addActionListener(new Bouton2rListener());
  		JButton b3 = new JButton("3 robots");
  		b3.addActionListener(new Bouton3rListener());
  		JButton b4 = new JButton("4 robots");
  		b4.addActionListener(new Bouton4rListener());
  		panneau.add(b1);
  		panneau.add(b2);
  		panneau.add(b3);
  		panneau.add(b4);
  		return panneau;
  	}
  
	 public static void main(String[] args) throws InterruptedException {
		 int nb_dechets =40;
	
		//Cr�ation fenetre de d�marrage
		Fenetre fen1 = new Fenetre();
		fen1.setVisible(true);
		JPanel start = new JPanel();
		
		start.add(createToolBar());
		start.add(createBoutons());
		String mot1="Robots en noir  /";
		String mot2="Verre en vert(lol) / ";
		String mot3="M�tal en bleu  /  ";
		String mot4="Plastique en jaune  ";
		
		
		JLabel txt =new JLabel(mot1+mot2+mot3+mot4);
		start.add(txt);
		fen1.setContentPane(start);
		
		
		//condition de d�part 
		while(startb==false) {
			Thread.sleep(1);
		}

		
		//Cr�ation matrice d'entier alatoire qui simule un terrain avec des 
		//positions de d�chets al�atoire et le robot situ� en haut a droite (0,0)
		int[][] mat_ini = new int[20][20];
     
     	Map terrain = new Map(mat_ini);
		int[][] mat = terrain.cr�ation_map(20,20, nb_dechets,nbr_robots);
		
    
	    //Cr�ation d'une collection comprenant les dechets 
		
		List<Dechet> liste_dechet =collectionD(mat);
		List<Tas>liste_tas=new ArrayList();
		 
		
		//Cr�ation objet Robot
		
		List<Robot> liste_robots=collectionR(mat);
		
		
		//Cr�ation Tas
		
		Tas tVerre = new Tas();
		Tas tM�tal = new Tas();
		Tas tPlastique= new Tas();
		
		liste_tas.add(tVerre);
		liste_tas.add(tM�tal);
		liste_tas.add(tPlastique);
		
				
		
		
		
		Panel pan =new Panel(mat);
		Fenetre fen0 = new Fenetre();
		fen0.setVisible(true);
		fen0.setContentPane(pan);
		System.out.println(nbr_robots);


		
		while ( liste_dechet.size()!=0 || ( tVerre.getNbr()+tM�tal.getNbr()+tPlastique.getNbr() != nb_dechets ) ) {
			System.out.println(" \n "+ tVerre.getNbr() + "/" + tM�tal.getNbr()+"/"+tPlastique.getNbr());
			for (Robot robot : liste_robots) {
				
				// si le robot est libre et cherche un dechet 
				if (robot.getFree() && robot.getCible()==null) {
					int l = robot.dist_robot(liste_dechet);
					if (l==-1)
						continue;
					
					Dechet d = liste_dechet.get(l);
					robot.setCible(d);
					robot.deplacement(d.getX(),d.getY());
					
					continue;
				}
				
				//si le robot est libre et vise un dechet 
				if (robot.getFree() && robot.getCible()!=null ) {
					
					// si la cible du robot est encore un dechet a terre
					if ( liste_dechet.contains( robot.getCible() )){
						
						//si le robot est sur sa cible
						if (robot.getX() == robot.getCible().getX() && robot.getY() == robot.getCible().getY()) {
							
							robot.setFree(false);
							robot.setDechet(robot.getCible());
							
							liste_dechet.remove(robot.getCible());
							robot.setCible(null);
						}
						
						// si le robot n'est pas sur sa cible
						else {
							
								robot.deplacement(robot.getCible().getX(),robot.getCible().getY());
								continue;
							}
						
						}
					//si la cible du robot est un dechet deja pris 
					else {
						robot.setCible(null);
						continue;
					}
				}
					
				//si le robot est charg� d'un dechet 
				if( robot.getFree() == false ) {
					
					if(robot.getDechet().toString().contains("Verre")) {
						
						//cr�ation du tas si il n'existe pas 
						if(tVerre.getNbr()==0) {
							int p = robot.dist_robot_type(liste_dechet);
							tVerre.add_dechet(liste_dechet.get(p));
							robot.deplacement(tVerre.getX(),tVerre.getY());
							liste_dechet.remove(liste_dechet.get(p));
							continue;
							}
						
						if (tVerre.getNbr()!=0 && (robot.stick_w(tVerre)||robot.on(tVerre))) {
							robot.setFree(true);
							tVerre.add_dechet(robot.getDechet());
							
							continue;
						}
						if (tVerre.getNbr()!=0 ) {
							robot.deplacement(tVerre.getX(),tVerre.getY());
							continue;
						}
						
						
							
					}
					
					// si le robot est charg� d'un dechet metal 
					if(robot.getDechet().toString().contains("M�tal")) {
							
							if (tM�tal.getNbr()==0) {
								int p =robot.dist_robot_type(liste_dechet);
								tM�tal.add_dechet(liste_dechet.get(p));
								liste_dechet.remove(liste_dechet.get(p));
								robot.deplacement(tM�tal.getX(),tM�tal.getY());
								continue;
						
							}
							if (tM�tal.getNbr()!=0 && (robot.stick_w(tM�tal)||robot.on(tM�tal))) {
								robot.setFree(true);
								tM�tal.add_dechet(robot.getDechet());
								continue;
							}
							if (tM�tal.getNbr()!=0 ) {
								robot.deplacement(tM�tal.getX(),tM�tal.getY());
								continue;
							}
							
					}
					
					if(robot.getDechet().toString().contains("Plastique")) {
						
						if (tPlastique.getNbr()==0) {
							int p =robot.dist_robot_type(liste_dechet);
							tPlastique.add_dechet(liste_dechet.get(p));
							liste_dechet.remove(liste_dechet.get(p));
							robot.deplacement(tPlastique.getX(),tPlastique.getY());
							continue;
					
						}
						if (tPlastique.getNbr()!=0 && (robot.stick_w(tPlastique)||robot.on(tPlastique))) {
							robot.setFree(true);
							tPlastique.add_dechet(robot.getDechet());
							continue;
						}
						if (tPlastique.getNbr()!=0 ) {
							robot.deplacement(tPlastique.getX(),tPlastique.getY());
							continue;
						}	
				}
			
			}
			}
			Thread.sleep(150);
			affichage_fenetre(mat, liste_robots,liste_dechet,liste_tas,fen0);
		
		System.out.println(" \n "+ tVerre.getNbr() + "/" + tM�tal.getNbr()+"/"+tPlastique.getNbr());
	 }
}

}
