package controller;

import ihm.*;

import java.awt.event.*;

public class EcouteurOuvrirAide implements ActionListener{

	private DialogText dial;
// Constructeur : lui donner la référence sur Wintel
// sinon l’accès aux méthodes de Wintel est impossible.
	public EcouteurOuvrirAide ( DialogText dial ) {
		this.dial = dial;
	}
	// Méthode de REACTION au clic souris sur le menu charger
	public void actionPerformed ( ActionEvent e ) {
		dial.setVisible(true);
	}
}