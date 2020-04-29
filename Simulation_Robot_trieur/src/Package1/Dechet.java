package Package1;

public class Dechet implements Coordonnées {
	int x;
	int y;
	
	public Dechet(){}
	
	public Dechet(int x,int y) {
		this.x=x;
		this.y=y;
		
	}
	 @Override
	 public int getX() {
		 return this.x;
	 }
	 
	 @Override
	 public int getY() {
		 return this.y;
	 }

}
