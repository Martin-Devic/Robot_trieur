package Package1;
import java.util.Random;

public class Map {
	int[][]map =new int [20][20];
	
	public Map(int[][] map) {
		this.map=map;
	}
	
	public void setMap(int[][]map) {
		this.map=map;
	}
	
	public static int nb_aleatoire(int Binf, int Bsup) {
		int nb;
		Random random = new Random();
		nb = Binf+random.nextInt(Bsup-Binf);
		return nb;
	}
	
	public int[][] cr�ation_map(int l , int c, int nbr_dechets){
		// Matrice de 0 
		int[][] mat_ini = new int[l][c];
		for (int i=0;i<20;i++) {
			for (int j=0;j<20;j++) {
        				mat_ini[i][j]=0;
        			}
			}
		//Positionnement du robot 
		mat_ini[0][0]=1;
		
		//Positionnement des dechets 
		int cpt=0;
		while(cpt != nbr_dechets) {
			int x, y, val ;
			x=nb_aleatoire(0,20);
			y=nb_aleatoire(0,20);
			if (mat_ini[x][y] == 0) {
				val=nb_aleatoire(2,4);
				mat_ini[x][y]=val;
				cpt+=1;
			}
		}
		
		return mat_ini;	
	}
}
