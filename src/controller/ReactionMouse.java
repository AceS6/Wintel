package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import datas.*;
import ihm.*;

public class ReactionMouse extends MouseAdapter implements Globale{

	public void mouseClicked ( MouseEvent e ) {
		Object src = e.getSource();
		if(src==(Globale.w).getListeGche()){
			reactionClicListe(e);
		}
	}
	private void reactionClicListe(MouseEvent e){

		if((Fiche) ((Globale.w).getListeGche().getSelectedValue())!=null){

			  Fiche laFiche;

			  // Accès à la JList
			  JList maListe = (Globale.w).getListeGche();

			  // getListeGche accesseur de Wintel
			  // Récupération de l’endroit (index) où l’utilisateur a cliqué
			  int index = maListe.locationToIndex(e.getPoint());

			  // Récupération du tableau qui mémorise les éléments de la JList

			  DefaultListModel tab = (DefaultListModel)maListe.getModel();

			  // L’index correspond précisément à la case du tableau contenant la donnée
			  // sélectionnée par l’utilisateur avec la souris

			  laFiche = (Fiche)tab.get(index);

			  // Affichage des informations de la fiche dans les 3 champs textuels
			  // de droite

			  JLabel nom = (Globale.w).getLabelNom();
			  nom.setText(laFiche.getNom());

			  // accesseur de Wintel
			  JLabel prenom = (Globale.w).getLabelPrenom();
			  prenom.setText(laFiche.getPrenom());

			  // accesseur de Wintel

			  JLabel num = (Globale.w).getLabelNumero();
			  num.setText(laFiche.getTelephone());

			  JLabel adresse = (Globale.w).getLabelAdresse();
			  adresse.setText(laFiche.getAdresse());

			  JLabel profession = (Globale.w).getLabelProfession();
			  profession.setText(laFiche.getProfession());
			  }
	}

}