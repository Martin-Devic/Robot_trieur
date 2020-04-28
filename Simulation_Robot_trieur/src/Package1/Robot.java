package Package1;

public class Robot implements Coordonnées {
	int x;
	int y;
	
	public Robot(int x , int y) {
		this.x=x;
		this.y=y;
	}

	@Override
	 public int getX() {
		 return this.y;
	 }
	 
	@Override
	 public int getY() {
		 return this.y;
	 }
	 
	 public double dist_robot(int a , int b) {
		 double dist =Math.sqrt(Math.pow((this.getX()-a), 2)+Math.pow((this.getY()-b), 2));
		 return dist;
		 
	 }
	
	//Necessitera un booléen porter
	
	

}
