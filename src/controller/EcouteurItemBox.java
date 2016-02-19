package ihm;

import datas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurItemBox implements ActionListener{

	private WtDialogAjouter dialog;
// Constructeur : lui donner la référence sur Wintel
// sinon l’accès aux méthodes de Wintel est impossible.
	public EcouteurItemBox ( WtDialogAjouter dialog ) {
		this.dialog = dialog;
	}
	// Méthode de REACTION au clic souris sur un élément de la JList
	public void actionPerformed ( ActionEvent e ) {

		dialog.getLabelImage().setVisible(true);

		Fiche laFiche = (Fiche) dialog.getBox().getSelectedItem();

		// Accès à la JList
		JComboBox maListe = dialog.getBox();

		// Affichage des informations de la fiche dans les 3 champs textuels
		// de droite

		JLabel nom = dialog.getLabelNom();

		// accesseur de Wintel

		nom.setText("Nom : "+laFiche.getNom());
		JLabel prenom = dialog.getLabelPrenom();

		// accesseur de Wintel

		prenom.setText("Prénom : "+laFiche.getPrenom());
		JLabel num = dialog.getLabelNumero();
		num.setText("Numéro : "+laFiche.getTelephone());
		
	}
}