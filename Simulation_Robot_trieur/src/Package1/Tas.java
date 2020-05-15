package Package1;

import java.util.ArrayList;
import java.util.List;


public class Tas implements Coordonnées {
	
	List<Dechet> tas_dechets =new ArrayList<Dechet>();
	
	
	public Tas() {
		
	}
	
	public void add_dechet(Dechet dechet) {
		this.tas_dechets.add(dechet);
	}
	
	public int getNbr() {
		return tas_dechets.size();
	}
	
	public int getX() {
		return tas_dechets.get(0).getX();
	}
	
	public int getY() {
		return tas_dechets.get(0).getY();
	}
	
		
	public String getName() {
		return tas_dechets.get(0).toString();
	}
}
