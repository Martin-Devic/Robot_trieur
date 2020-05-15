package Package1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Listener pour definit le nombre de robots à 1
public class Bouton1rListener implements ActionListener  {
	
	public void actionPerformed(ActionEvent arg0) {

	    Test.setNbrRobots(1);        

	    }

}
