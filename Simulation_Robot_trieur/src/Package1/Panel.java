package Package1;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class Panel extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	
	//CONSTRUCTEUR
	
	public Panel(int [][] mat_ini) {
		this.setLayout(new GridLayout(20,20,1,1)); 
		this.setBackground(Color.black);
		//this.add(createToolBar(),BorderLayout.NORTH);
		
		
     
     //Ajout des panels de couleurs dans la grille en fonction de la matrice rentrée en paramètre
	
		for (int j=0;j<20;j++) {
			for (int i=0;i<20;i++) {
				if (mat_ini[i][j]==2) { 
					this.add(creationpanelD(2));
				}
				else if(mat_ini[i][j]==3 ) {
					this.add(creationpanelD(3));
				}
				else if(mat_ini[i][j]==4 ) {
					this.add(creationpanelD(4));
				}
				
				else if (mat_ini[i][j]==1) {
					this.add(new Img(img1.getImage()));
				}
				else if (mat_ini[i][j]==12) {
					this.add(new Img(img12.getImage()));
				}
				else if (mat_ini[i][j]==13) {
					this.add(new Img(img13.getImage()));
				}
				else if (mat_ini[i][j]==14) {
					this.add(new Img(img14.getImage()));
				}
				
				else if (mat_ini[i][j]>=100 && mat_ini[i][j]<200) {
					this.add(creationpaneltV(mat_ini[i][j]%100));
				}
				else if (mat_ini[i][j]>=200 && mat_ini[i][j]<300) {
					this.add(creationpaneltM(mat_ini[i][j]%200));
				}
				else if (mat_ini[i][j]>=300 && mat_ini[i][j]<400) {
					this.add(creationpaneltP(mat_ini[i][j]%300));
				}
				else {
					this.add(creationpanel());
				} 
				
				

 
			}

		}	

	}
	
	//Images des robots
	
	ImageIcon img1 =new ImageIcon("image1/WALLE.png");
	ImageIcon img12 =new ImageIcon("image1/WALLE_métal.png");
	ImageIcon img13 =new ImageIcon("image1/WALLE_verre.png");
	ImageIcon img14 =new ImageIcon("image1/WALLE_plastique.png");

	public class Img extends JPanel {
        private static final long serialVersionUID = -9129537057351390955L;
 
        private Image img;
         
        public Img(Image img) {
        	
        		this.img = img;
        		this.setBackground(Color.white);
        }
        public void paintComponent(Graphics g) {
            //tu peux changer la taille ici
            g.drawImage(img, 0, 0, 20, 20, this);
        }
        
    }
	
     
 	//Création préalable des panels de différentes couleurs
	
	//Cellule vierge 
     private JPanel creationpanel() {
     	JPanel panel1=new JPanel();
     	panel1.setBackground(Color.white);
     	return panel1;
     }
     
     
     //Cellule contenat dechet
     
     private JPanel creationpanelD(int a) {
    	JPanel panel1=new JPanel();
      	JLabel label=new JLabel();
      	if (a==2) {
      		label.setText(new String("M"));
      		panel1.setBackground(Color.blue);
      	}
      	else if (a==4){
      		label.setText(new String("P"));
          	panel1.setBackground(Color.yellow);
      	}
      	else if(a==3) {
      		label.setText(new String("V"));
          	panel1.setBackground(Color.green);
      	}
      	panel1.add(label);
      	return panel1;
     }
     
      
     //Cellule contenant un robot ne portant rien
     private JPanel creationpanelr() {
     	JPanel panel1=new JPanel();
     	panel1.setBackground(Color.black); 
     	
     	return panel1;
     }
     

     
   //Tas des déchets de type Verre
     private JPanel creationpaneltV(int n) {
    	 JPanel panel1=new JPanel();
        	
        	panel1.setBackground(Color.gray); 
        	panel1.setLayout(new GridLayout(4,5,1,1));

        	for (int k =0;k<n;k++) {
        		JPanel souspanel=new JPanel();
        		panel1.add(souspanel);
        		souspanel.setBackground(Color.green);
        	}
        	for (int j =0;j<20-n;j++) {
        		JPanel souspanel2=new JPanel();
        		souspanel2.setBackground(Color.gray);
        		panel1.add(souspanel2);
      		
      	}
      	return panel1;
      }
     
     
     //Tas des déchets de type Métal
     private JPanel creationpaneltM(int n) {
    	 JPanel panel1=new JPanel();
       	
       	panel1.setBackground(Color.gray); 
       	panel1.setLayout(new GridLayout(4,5,1,1));

       	for (int k =0;k<n;k++) {
       		JPanel souspanel=new JPanel();
       		panel1.add(souspanel);
       		souspanel.setBackground(Color.blue);
       	}
       	for (int j =0;j<20-n;j++) {
       		JPanel souspanel2=new JPanel();
       		souspanel2.setBackground(Color.gray);
       		panel1.add(souspanel2);
       		
       	}
       	return panel1;
      }
     
     //Tas des déchets de type Plastique
     private JPanel creationpaneltP(int n) {
    	 JPanel panel1=new JPanel();
       	
       	panel1.setBackground(Color.gray); 
       	panel1.setLayout(new GridLayout(4,5,1,1));

       	for (int k =0;k<n;k++) {
       		JPanel souspanel=new JPanel();
       		panel1.add(souspanel);
       		souspanel.setBackground(Color.yellow);
       	}
       	for (int j =0;j<20-n;j++) {
       		JPanel souspanel2=new JPanel();
       		souspanel2.setBackground(Color.gray);
       		panel1.add(souspanel2);
       		
       	}
       	return panel1;
      }
     
     
     
    
    

}
     




