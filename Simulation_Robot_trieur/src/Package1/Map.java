package Package1;

public class Map {
	int[][]map =new int [20][20];
	
	public Map(int[][] map) {
		this.map=map;
	}
	
	public void setMap(int[][]map) {
		this.map=map;
	}
	public int[][] création_map(int l , int c){
		
	
		int[][] mat_ini = new int[l][c];
		for (int i=0;i<20;i++) {
			for (int j=0;j<20;j++) {
    	
				double d = Math.random();
				double nbr_alea =d *100;
        			if (nbr_alea<10.0 && nbr_alea>5.0) { 
        				mat_ini[i][j]=2;
        			
        			}
        			else if(0<nbr_alea && nbr_alea<5 ) {
        				mat_ini[i][j]=3;
        			}
        			else {
        				mat_ini[i][j]=0;
        			}
			}
		}
		mat_ini[0][0]=1;
		return mat_ini;
	
	}
}

