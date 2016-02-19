package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import datas.*;
import ihm.*;

public class ReactionAction implements ActionListener, Globale{

	// Pas de constructeur particulier

	public static void main(String [] args){
		ReactionAction r = new ReactionAction();
		(Globale.w).start("Wintel 1.0");
	}

	// Méthode de réaction au "clic" sur items
	public void actionPerformed(ActionEvent e){
		Object src = e.getSource();
		if(src==(Globale.w).getItemCharger() || src==(Globale.w).getLoad() ){reactionClicItemCharger();}
		else if(src==(Globale.w).getItemSauver() || src==(Globale.w).getSave()){reactionClicItemSauver();}
		else if(src==(Globale.w).getItemQuitter()){reactionClicItemQuitter();}
		else if(src==(Globale.w).getItemAjouter() || src==(Globale.w).getAdd()){reactionClicItemAjouter();}
		else if(src==(Globale.w).getItemModifier() || src==(Globale.w).getModify()){reactionClicItemModifier();}
		else if(src==(Globale.w).getItemSupprimer() || src==(Globale.w).getDelete()){reactionClicItemSupprimer();}
		else if(src==(Globale.w).getItemAide()){reactionClicItemAide();}

		/*
		else if(src==(Globale.w).getDialogAjouter().getBox()){reactionClicItemBox();}
		else if(src==(Globale.w).getDialogAjouter().getConfirm()){reactionClicConfirmerAjouter();}
		else if(src==(Globale.w).getDialogAjouter().getCancel()){reactionClicAnnulerAjouter();}
		*/

	}
	private void reactionClicItemCharger(){
		(Globale.w).chargerEtAfficherAnnuaire();
	}
	private void reactionClicItemSauver(){
		(Globale.w).getAnnuaire().sauver();
	}
	private void reactionClicItemQuitter(){
		System.exit(0);
	}

	// Réaction concernant la fenêtre ajouter
	private void reactionClicItemAjouter(){
		(Globale.w).ajouter();
	}
	private void reactionClicAnnulerAjouter(){
		(Globale.w).getDialogAjouter().cancel();
	}
	private void reactionClicConfirmerAjouter(){
		(Globale.w).getDialogAjouter().confirm();
	}

	// Réactions concernant la fenetre modifier
	private void reactionClicItemModifier(){
		(Globale.w).modifier();
	}
	private void reactionClicAnnulerModifier(){
		(Globale.w).getDialogModifier().setVisible(false);
	}
	private void reactionClicConfirmerModifier(){
	
	}


	private void reactionClicItemSupprimer(){
		(Globale.w).supprimer();
	}
	private void reactionClicItemAide(){
		DialogText dialog = new DialogText();
	}
	private void reactionClicFermerAide(){
		
	}
}