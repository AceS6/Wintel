package controller;

import ihm.*;
import java.io.*;
import java.awt.event.*;

public class EcouteurDemarrageAide implements ActionListener{

	private DialogText dial;
// Constructeur : lui donner la référence sur Wintel
// sinon l’accès aux méthodes de Wintel est impossible.
	public EcouteurDemarrageAide ( DialogText dial ) {
		this.dial = dial;
	}
	// Méthode de REACTION au clic souris sur le menu charger
	public void actionPerformed ( ActionEvent e ) {

		try {
			File file = new File("../data/config.cfg");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			if(dial.getBoxState()==true){
				bw.write("showHelpOnStartup=true");
			}
			else{
				bw.write("showHelpOnStartup=false");
			}
			bw.close();
 
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}