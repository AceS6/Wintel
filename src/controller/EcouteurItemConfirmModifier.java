package controller;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import ihm.*;

public class EcouteurItemConfirmModifier implements ActionListener{

	private WtDialogModifier dialog;
// Constructeur : lui donner la référence sur Wintel
// sinon l’accès aux méthodes de Wintel est impossible.
	public EcouteurItemConfirmModifier ( WtDialogModifier dialog ) {
		this.dialog = dialog;
	}
	// Méthode de REACTION au clic souris sur le menu charger
	public void actionPerformed ( ActionEvent e ) {
		dialog.confirm();
	}
}