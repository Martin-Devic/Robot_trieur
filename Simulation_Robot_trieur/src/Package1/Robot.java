package Package1;

import java.util.List;

public class Robot implements Coordonnées {
	
	int x;
	int y;
	boolean free ;
	Dechet dechet;
	
	
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
	
	public void setDechet(Dechet d) {
		this.dechet=d;
	}
	
	public Dechet getDechet() {
		return this.dechet;
	}
	 
	
	//Méthode dechet le plus proche du robot 
	
	 public int dist_robot(List<Dechet> dech) {
		 int d =0;
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
	 
	 public void deplacement(int xd,int yd ) {
		 
		 if ((this.x-xd)!=0){
			 if ((this.x-xd)<0) {
				 this.setX(this.x+1);
			 }
			 else if ((this.x-xd>0)) {
				 this.setX(this.x-1);
			 }
		 }
		 
		 else if ((this.y-yd)!=0) {
			 if ((this.y-yd)<0 ) {
				 this.setY(this.y+1);
			 }
			 else if ((this.y-yd>0)) {
				 this.setY(this.y-1);
			 }
		 }
		 
		 
	 }
	 
	//doit renvoyer l'indice du plus proche dechet du meme type que celui que porte le robot 
	public int dist_robot_type(List<Dechet> dech) {
		
		String type;
		if(this.getDechet().toString().contains("Verre")) {
			type ="Verre";
		}
		else {
			type ="Métal";
		}
		
		int d =0;
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
}