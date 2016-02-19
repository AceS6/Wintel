package ihm;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class EcouteurItemConfirmAjouter implements ActionListener{

	private WtDialogAjouter dialog;
// Constructeur : lui donner la référence sur Wintel
// sinon l’accès aux méthodes de Wintel est impossible.
	public EcouteurItemConfirmAjouter ( WtDialogAjouter dialog ) {
		this.dialog = dialog;
	}
	// Méthode de REACTION au clic souris sur le menu charger
	public void actionPerformed ( ActionEvent e ) {
		System.out.println("Action Confirm");
		dialog.confirm();
	}
}