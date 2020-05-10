package Package1;


import java.util.ArrayList;

import java.util.List;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;



public class Test {
	
	//nombre définissant le nombre de robots , initialisé à un
	static int nbr_robots =1; 
	
	
	//méthode définissant le nombre de robots
	
	public static void setNbrRobots(int a) {
		nbr_robots=a;
	}
	//booléen permettant de démarrer la simulation
	static boolean startb =false;
	
	//méthode permettant de modifier le booléen startb
	public static void setStartb(boolean a) {
		startb=a;
	}
	
	//Méthode qui crée la liste des robots à partir de la matrice initiale
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
		
		
	//Méthode qui crée la liste des dechets de la matrice initiale
	public static List collectionD(int [][] mat){
		List<Dechet> dech =new ArrayList<Dechet>();
		for (int i=0;i<20;i++) {
			for (int j=0;j<20;j++) {
				
				if (mat[i][j]==2) {
		     		Dechet metal =new Métal(i,j);
		     		dech.add(metal);
		     	}
				
		     	else if (mat[i][j]==3) {
		     		Dechet verre =new Verre(i,j);
		     		dech.add(verre);
		     	}
				
		     	else if (mat[i][j]==4) {
		     		Dechet plastique =new Plastique(i,j);
		     		dech.add(plastique);
		     	}	

		     }
	    }
		return dech;
	}
	
	
	
	
	
	//méthode modifiant la matrice initiale a chaque deplacement de tous les robots 
	//Chaque type d'objet possède un entier propre
	public static void MatriceAffichage(List<Robot> robots ,List<Dechet> dechet,int[][] mat,List<Tas>tas) {
		
		for (int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				mat[i][j]=0;
			}
		}
		for(Dechet d : dechet) {
			if(d.toString().contains("Métal")) {
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
			else if (t.getName().contains("Métal")) {
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
				if (ctype.contains("Métal")){
					mat[r.getX()][r.getY()] = 13;
				}
				if (ctype.contains("Plastique")){
					mat[r.getX()][r.getY()] = 14;
				}
			}
				
		}
		
	}
	
	//Méthode permettant d'afficher la matrice dependant de tous les objets sur la map 
	public static void affichage_fenetre(int[][] mat, List<Robot> robots ,List<Dechet> dechet,List<Tas>tas,Fenetre fen0) {
		MatriceAffichage(robots,dechet,mat,tas);
		Panel pan1 =new Panel(mat);
		
		fen0.setContentPane(pan1);
		fen0.setVisible(true);
	}
	

	//FONCTIONS AFFICHAGE FENETRE DE DEMARRAGE
	//création barre de démarrage
  	private static JToolBar createToolBar() {
  		JToolBar tb =new JToolBar();
  		JButton start = new JButton("Start");
  		start.addActionListener(new BoutonListener());
  		tb.add(start);
  		tb.add(new JLabel("Simulation de robots trieurs"));
  		return tb;
  	}
  	
  	//création d'un panneau comprennant des boutons permettant de décider du nombre de robots
  	//présents sur le terrain
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
  	//Création du texte expliquant le code couleur
  	private static JLabel createTxt() {
  		String mot1="Robots en noir  /";
		String mot2="Verre en vert(lol) / ";
		String mot3="Métal en bleu  /  ";
		String mot4="Plastique en jaune  ";
		JLabel txt =new JLabel(mot1+mot2+mot3+mot4);
		return txt;
  	}
  //FIN FONCTIONS AFFICHAGE FENETRE DE DEMARRAGE 
  	 
  	
//*******************************MAIN***************************************
  	
  	
	 public static void main(String[] args) throws InterruptedException {
		 
		 //nombre de céchets définis a 40
		 int nb_dechets =40;
	
		//Création fenetre de démarrage
		Fenetre fen1 = new Fenetre(500,200);
		
		
		//Ajout de la barre contenant le bouton start et d'un panneau contenant les boutons 
		//choisissant le nombre de robots , puis Label contenant code couleur ,dans un panneau 
		//principale contenu dans la fenetre de démarrage
		
		JPanel start = new JPanel();
		
		
		start.add(createToolBar());
		start.add(createBoutons());
		start.add(createTxt());
		fen1.setContentPane(start);
		fen1.setVisible(true);
		//condition de départ 
		while(startb==false) {
			Thread.sleep(1);
		}
		
		
		//dès que condition de depart est remplie , on rend la fenetre de demarrage invisible
		fen1.setVisible(false);
		
		//Création matrice d'entier alatoire qui simule un terrain avec des 
		//positions de 40 déchets répartis aléatoirement et de "nbr_robots" 
		//robots repartis dans les coins
		
		int[][] mat_ini = new int[20][20];
     	Map terrain = new Map(mat_ini);
		int[][] mat = terrain.création_map(20,20, nb_dechets,nbr_robots);
		
    
	    //Création d'une liste comprenant tous les dechets quelquesoit leur type
		List<Dechet> liste_dechet =collectionD(mat);
		
		//Création d'une liste comprenant les tas de chaque type de dechet
		List<Tas>liste_tas=new ArrayList();
		 
		//Création d'une liste comprenant tous les robots
		List<Robot> liste_robots=collectionR(mat);
		
		
		//Création Tas
		
		Tas tVerre = new Tas();
		Tas tMétal = new Tas();
		Tas tPlastique= new Tas();
		
		//Ajout de chaque tas dans la liste des tas
		
		liste_tas.add(tVerre);
		liste_tas.add(tMétal);
		liste_tas.add(tPlastique);
		
		//Affichage de la configuration terrain à l'instant initial
		
		Panel pan =new Panel(mat);
		Fenetre fen0 = new Fenetre(500,500);
		fen0.setVisible(true);
		fen0.setContentPane(pan);


		//DEMARRAGE DE LA BOUCLE 
		//La boucle se termine lorsque la liste des dechets est vide ou que la somme des dechets
		//de tous les tas est égale au nombre de déchets dans la liste dechet a l'instant initial
		while ( liste_dechet.size()!=0 || ( tVerre.getNbr()+tMétal.getNbr()+tPlastique.getNbr() != nb_dechets ) ) {
			
			//Visualisation dans la console en temps réel de l'avancement des tas
			System.out.println(" \n "+ tVerre.getNbr() + "/" + tMétal.getNbr()+"/"+tPlastique.getNbr());
			
			//parcourt a chaque boucle du while tous les robots de la liste 
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
					
				//si le robot est chargé d'un dechet 
				if( robot.getFree() == false ) {
					
					//si le dechet porté est de type Verre
					if(robot.getDechet().toString().contains("Verre")) {
						
						//création du tas si il n'existe pas 
						if(tVerre.getNbr()==0) {
							int p = robot.dist_robot_type(liste_dechet);
							tVerre.add_dechet(liste_dechet.get(p));
							robot.deplacement(tVerre.getX(),tVerre.getY());
							liste_dechet.remove(liste_dechet.get(p));
							continue;
							}
						//Si le tas et deja créé et que le robot est sur le tas ou sur une 
						//cellule adjacente 
						if (tVerre.getNbr()!=0 && (robot.stick_w(tVerre)||robot.on(tVerre))) {
							robot.setFree(true);
							tVerre.add_dechet(robot.getDechet());
							
							continue;
						}
						//Sinon 
						if (tVerre.getNbr()!=0 ) {
							robot.deplacement(tVerre.getX(),tVerre.getY());
							continue;
						}
						
						
							
					}
					
					// si le robot est chargé d'un dechet metal 
					if(robot.getDechet().toString().contains("Métal")) {
							
							if (tMétal.getNbr()==0) {
								int p =robot.dist_robot_type(liste_dechet);
								tMétal.add_dechet(liste_dechet.get(p));
								liste_dechet.remove(liste_dechet.get(p));
								robot.deplacement(tMétal.getX(),tMétal.getY());
								continue;
						
							}
							if (tMétal.getNbr()!=0 && (robot.stick_w(tMétal)||robot.on(tMétal))) {
								robot.setFree(true);
								tMétal.add_dechet(robot.getDechet());
								continue;
							}
							if (tMétal.getNbr()!=0 ) {
								robot.deplacement(tMétal.getX(),tMétal.getY());
								continue;
							}
							
					}
					//Si le dechet est de type Plastique
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
			//affichage du terrain dès qu'on a parcouru tous les robots de la liste
			affichage_fenetre(mat, liste_robots,liste_dechet,liste_tas,fen0);
		
		System.out.println(" \n "+ tVerre.getNbr() + "/" + tMétal.getNbr()+"/"+tPlastique.getNbr());
	 }
}

}
