package controller;

import java.awt.event.*;
import ihm.*;

public class EcouteurItemCancelModifier implements ActionListener{

	private WtDialogModifier dialog;
// Constructeur : lui donner la référence sur Wintel
// sinon l’accès aux méthodes de Wintel est impossible.
	public EcouteurItemCancelModifier ( WtDialogModifier dialog) {
		this.dialog = dialog;
	}
	// Méthode de REACTION au clic souris sur le menu charger
	public void actionPerformed ( ActionEvent e ) {
		dialog.cancel();
	}
}