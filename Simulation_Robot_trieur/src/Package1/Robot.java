package Package1;

import java.util.List;

public class Robot implements Coordonnées {
	
	int x;
	int y;
	boolean free ;
	Dechet dechet;
	Dechet cible;
	
	//CONSTRUCTEUR
	public Robot(int x , int y) {
		this.x=x;
		this.y=y;
	}
	
	//SETTERS
	
	//Position
	public void setX(int x) {
		this.x=x;
		
	}
	
	public void setY(int y) {
		this.y=y;
		
	}
	
	//Définit si le robot porte un dechet
	public void setFree(boolean a) {
		this.free=a;
	}
	
	
	//Définit le dechet que le robot porte 
	public void setDechet(Dechet d) {
		this.dechet=d;
	}
	
	//Définit la cible du robot 
	public void setCible(Dechet cible) {
		this.cible=cible;
	}
	
	
	
	//GETTERS
	
	//position
	@Override
	 public int getX() {
		 return this.x;
	 }
	 
	@Override
	 public int getY() {
		 return this.y;
	 }
	//Renvoie si le robot porte un dechet
	public boolean getFree() {
		return this.free;
	}
	
	
	//Renvoie le dechet que le robot porte 
	public Dechet getDechet() {
		return this.dechet;
	}
	 
	
	//Renvoit la cible du robot 
	public Dechet getCible() {
		return this.cible;
	}
	
	
	
	//Méthode dechet le plus proche du robot 
	
	 public int dist_robot(List<Dechet> dech) {
		 int d =-1;
		
		 double min=Math.sqrt(Math.pow(20, 2)*2);
		 for (int k =0;k<dech.size();k++) {
			 int x =dech.get(k).getX();
			 int y =dech.get(k).getY();
			 double dist =Math.sqrt(Math.pow((this.getX()-x), 2)+Math.pow((this.getY()-y), 2));
			 if (dist<min) {
				 min= dist;
				 d=k;
				 
			 }
		 }
		 return d; 
	 }
	 //Méthode permettant d'eviter les déchets au sol
/*	
	 public void avoid_contact(int vX,int vY,int xd,int yd, List<Dechet> ld) {
		 for (int k =0; k<ld.size();k++) {
			 if (ld.get(k).getX()==this.getX() && ld.get(k).getY()==this.getY()) {
				 if (vX==1) {
					 this.setX(this.x-1);
					 if (yd-this.getY()<0) {
						 this.setY(this.y-1);
					 }
					 else {
						 this.setY(this.y+1);
					 } 
				 }
				 else if(vX==-1) {
					 this.setX(this.x+1);
					 if (yd-this.getY()<0) {
						 this.setY(this.y-1);
					 }
					 else {
						 this.setY(this.y+1);
					 } 
				 }
				 else if (vY==1) {
					 this.setY(this.x-1);
					 if (xd-this.getX()<0) {
						 this.setX(this.x-1);
					 }
					 else {
						 this.setX(this.x+1);
					 } 
				 }
				 else {
					 this.setY(this.x+1);
					 if (xd-this.getX()<0) {
						 this.setX(this.x-1);
					 }
					 else {
						 this.setX(this.x+1);
					 } 
				 }
			 }
		 }
	 }
*/	 
	 //méthode de deplacement du robot avec en paramètre la cible du robot 
	 //Déplacement en qui va etre suivant l'horizontale (x) dans un premier 
	 //temps, puis suivant y dans un second temps 
/*	 
	 public void deplacement(int xd,int yd,List<Dechet> ld) {
		 
		 if ((this.x-xd)!=0){
			 if ((this.x-xd)<0) {
				 this.setX(x+1);
				 this.avoid_contact(1,0, xd, yd, ld);
				 return;
			 }
			 if ((this.x-xd>0) ) {
				 this.setX(x-1);
				 this.avoid_contact(-1,0, xd, yd, ld);
				 return;		 
			 }
		 }
		 
		 
		 if ((this.y-yd)!=0 ) {
			 if ((this.y-yd)<0 ) {
				 this.setY(y+1);
				 this.avoid_contact(0,1, xd, yd, ld);
				 return;
			 }
			 if ((this.y-yd>0)) {
				 this.setY(y-1);
				 this.avoid_contact(0,-1, xd, yd, ld);
				 return;
			 }
		 }

	 }
	
*/ 
	 
	 
	 
public void deplacement(int xd,int yd) {
		 
		 if ((this.x-xd)!=0){
			 if ((this.x-xd)<0) {
				 this.setX(x+1);				 
				 return;
			 }
			 if ((this.x-xd>0) ) {
				 this.setX(x-1);
				 return;		 
			 }
		 }
		 
		 
		 if ((this.y-yd)!=0 ) {
			 if ((this.y-yd)<0 ) {
				 this.setY(y+1);
				 return;
			 }
			 if ((this.y-yd>0)) {
				 this.setY(y-1);
				 return;
			 }
		 }

	 }
	 
	 
	//méthode renvoyant l'indice du plus proche dechet du meme type que celui que porte le robot 
	public int dist_robot_type(List<Dechet> dech) {
		
		String type;
		if(this.getDechet().toString().contains("Verre")) {
			type ="Verre";
		}
		else if (this.getDechet().toString().contains("Métal")){
			type ="Métal";
		}
		else {
			type ="Plastique";
		}
		
		int d =-1;
		double min=Math.sqrt(Math.pow(20, 2)*2);
		for (int k =0;k<dech.size();k++) {
			if (dech.get(k).toString().contains(type)) {
				int x =dech.get(k).getX();
				int y =dech.get(k).getY();
				double dist =Math.sqrt(Math.pow((this.getX()-x), 2)+Math.pow((this.getY()-y), 2));
				if (dist<min) {
					min= dist;
					d=k;
				}
			}
	 
		}
		return d;
	}
	
	//méthode renvoyant si le tas est sur une cellule adjacente du Tas entré en paramètre
	public boolean stick_w(Tas tas) {
		int x=this.getX();
		int y=this.getY();
		int tx=tas.getX();
		int ty=tas.getY();
		if ((x-tx==0)&&(Math.abs(y-ty)==1)) {
			return true;
		}
		else if ((y-ty==0)&&(Math.abs(x-tx)==1)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean stick_w(Dechet d) {
		int x=this.getX();
		int y=this.getY();
		int tx=d.getX();
		int ty=d.getY();
		if ((x-tx==0)&&(Math.abs(y-ty)==1)) {
			return true;
		}
		else if ((y-ty==0)&&(Math.abs(x-tx)==1)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//méthode renvoyant si le tas est sur le tas entré en paramètre
	public boolean on(Tas tas) {
		int x=this.getX();
		int y=this.getY();
		int tx=tas.getX();
		int ty=tas.getY();
		if (x==tx && y==ty) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
}