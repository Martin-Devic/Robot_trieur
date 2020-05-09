package Package1;

import java.util.List;

public class Robot implements Coordonnées {
	
	int x;
	int y;
	
	boolean free ;
	Dechet dechet;
	Dechet cible;
	
	public Robot(int x , int y) {
		this.x=x;
		this.y=y;
	}
	
	//Setters
	
	//Position
	public void setX(int x) {
		this.x=x;
		
	}
	
	public void setY(int y) {
		this.y=y;
		
	}
	
	//robot porte 
	public void setFree(boolean a) {
		this.free=a;
	}
	
	
	
	public void setDechet(Dechet d) {
		this.dechet=d;
	}
	//Getteurs
	
	//position
	@Override
	 public int getX() {
		 return this.x;
	 }
	 
	@Override
	 public int getY() {
		 return this.y;
	 }
	//Porte dechet
	public boolean getFree() {
		return this.free;
	}
	
	
	
	public Dechet getDechet() {
		return this.dechet;
	}
	 
	public void setCible(Dechet cible) {
		this.cible=cible;
	}
	
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
	 
	 //méthode du deplacement du robot
	 
	 public void deplacement(int xd,int yd ,int [][] mat) {
		 
		 if ((this.x-xd)!=0){
			 if ((this.x-xd)<0 && (mat[this.x+1][this.y]<1 || mat[this.x+1][this.y]>3)) {
				 this.setX(this.x+1);
				 return;
			 }
			 if ((this.x-xd>0)&& (mat[this.x-1][this.y]<1 || mat[this.x-1][this.y]>3)) {
				 this.setX(this.x-1);
				 return;		 
			 }
		 }
		 
		 
		 if ((this.y-yd)!=0 ) {
			 if  (this.y-yd<0 && (mat[this.x][this.y+1]<1 || mat[this.x][this.y+1]>3) ) {
				 this.setY(this.y+1);
				 return;
			 }
			 if (this.y-yd>0 && (mat[this.x][this.y-1]<1 || mat[this.x][this.y-1]>3) ) {
				 this.setY(this.y-1);
				 return;
			 }
		 }
		 
		 
	 }
	 
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
	//doit renvoyer l'indice du plus proche dechet du meme type que celui que porte le robot 
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