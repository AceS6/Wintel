package ihm;

import datas.*;
import controller.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;


import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
*	Class WtDialogAjouter
*	@author : Quentin Pitalier / Antoine Sauray 
*   @version : 1.0
*	WtDialogAjouter is a dialog to add a contact
**/
public class WtDialogAjouter extends JDialog implements Globale{
	
	//Attributs//
	
	private Hashtable<Cle,Fiche> table; //Cet attribut mémorisera tous les objets de type Fiche lus à partir de table.bin
	
	// Objets affichés dans la fenêtre
	
	private JLabel instruction;
	
	private JLabel name;
	private JLabel firstname;
	private JLabel number;
	private JLabel home;
	private JLabel work;
	
	private JComboBox box;	
	
	private JButton confirm;
	private JButton cancel;

	private JPanel pan;	// JPanel de la fenetre entiere
	private JPanel centerPan;	// Panel du centre = tout sauf les boutons et la box
	private JPanel panLigne1;	// Panel contenant la photo et le panel nom du contact
	private JPanel panNom;		// Panel contenant le nom
	private JPanel infoPan;		// Panel contenant les informations relatives au contact
	private JPanel lowerPan;	// Panel contenant les boutons du bas

	private JPanel panTelephone;// Panel contenant le logo et le numéro de téléphone
	private JPanel panAdresse;// Panel contenant le logo et le numéro de téléphone
	private JPanel panProfession;// Panel contenant le logo et le numéro de téléphone

	private JLabel imageLabel;
	private ImageIcon icon;

	private JLabel phoneImageLabel;
	private ImageIcon phoneIcon;

	private JLabel homeImageLabel;
	private ImageIcon homeIcon;

	private JLabel workImageLabel;
	private ImageIcon workIcon;

	private Color BackgroundBlueColor = new Color(0x003542);
	
	/**
	*	Constructor
	**/
	public WtDialogAjouter(){
		super (Globale.w, "Ajouter un nouveau contact", true ); 	
		//Appel du constructeur de JDialog
		System.out.println("Construction WtDialogAJouter");
		
		this.lireTableFiches();		//Lecture des fiches à partir du fichier
		this.creerInterface();		//Mise en place de l'interface
		this.attacherReactions(); 	//Ecouteurs des JBoutons et de JComboBox
		
		this.setSize(550,450);
		this.setResizable(false);
		this.setVisible(true);
	}
	/**
	*	Reads a binary file to file the combo box with the contacts the user can add
	**/
	private void lireTableFiches(){
		
		//Effectue la lecture des objets Fiche à partir de table.bin

		table = new Hashtable<Cle,Fiche>();
		
		Fiche f= null;
		Cle c = null;

		try{

			String fich ="./table.bin";
			FileInputStream in = new FileInputStream(fich);
			ObjectInputStream flux = new ObjectInputStream(in);

			while(true) {
				f = (Fiche)flux.readObject();
				c = new Cle(f.getNom(), f.getPrenom());
				table.put(c,f);
			}
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"L'importation du fichier a échoué",JOptionPane.WARNING_MESSAGE);
		}
		
		catch(IOException e){
			//JOptionPane.showMessageDialog(null,e.getMessage(),"L'importation du fichier a échoué",JOptionPane.WARNING_MESSAGE);
		}
		catch(ClassNotFoundException e){
			//l'exception permettant de sortir de la boucle
		}		
		
	}	
	
	/**
	*	Initialises the interface
	**/
	private void creerInterface(){

		this.getContentPane().setBackground(BackgroundBlueColor);

		box= new JComboBox();
		Fiche laFiche;
		Cle laCle;

		for(Enumeration<Cle> lesCles = table.keys(); lesCles.hasMoreElements();){
			laCle = lesCles.nextElement();
			laFiche = table.get(laCle);
			box.addItem(laFiche);
		}
		
		name = new JLabel();
		name.setFont(new Font("Calibri", Font.BOLD, 24));
		name.setForeground(Color.white);

		firstname = new JLabel();
		firstname.setFont(new Font("Calibri", Font.PLAIN, 18));
		firstname.setForeground(Color.white);


		number = new JLabel();
		number.setFont(new Font("Calibri", Font.PLAIN, 14));
		number.setForeground(Color.white);

		home = new JLabel();
		home.setFont(new Font("Calibri", Font.PLAIN, 14));
		home.setForeground(Color.white);

		work = new JLabel();
		work.setFont(new Font("Calibri", Font.PLAIN, 14));
		work.setForeground(Color.white);


		confirm = new JButton("Confirmer");
		cancel = new JButton("Annuler");

		icon = new ImageIcon(new ImageIcon("../data/Profil.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		imageLabel = new JLabel();
		imageLabel.setIcon(icon);
		imageLabel.setVisible(true);


		pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));

		lowerPan = new JPanel();
		lowerPan.setLayout(new GridLayout(1,2));

		panNom = new JPanel();
		panNom.setBackground(BackgroundBlueColor);
		panNom.setLayout(new BoxLayout(panNom, BoxLayout.Y_AXIS));
		panNom.add(name);
		panNom.add(firstname);

		panLigne1 = new JPanel();
		panLigne1.setBackground(BackgroundBlueColor);
		panLigne1.setLayout(new BoxLayout(panLigne1, BoxLayout.X_AXIS));
		panLigne1.add(imageLabel);
		panLigne1.add(panNom);

		panTelephone = new JPanel();
		panTelephone.setLayout(new BoxLayout(panTelephone, BoxLayout.X_AXIS));
		panTelephone.setBackground(BackgroundBlueColor);

		panAdresse = new JPanel();
		panAdresse.setLayout(new BoxLayout(panAdresse, BoxLayout.X_AXIS));
		panAdresse.setBackground(BackgroundBlueColor);

		panProfession = new JPanel();
		panProfession.setLayout(new BoxLayout(panProfession, BoxLayout.X_AXIS));
		panProfession.setBackground(BackgroundBlueColor);

		phoneImageLabel = new JLabel();
		phoneIcon = new ImageIcon(new ImageIcon("../data/Telephone.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		phoneImageLabel.setIcon(phoneIcon);
		panTelephone.add(phoneImageLabel);
		panTelephone.add(number);

		homeImageLabel = new JLabel();
		homeIcon = new ImageIcon(new ImageIcon("../data/Adresse.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		homeImageLabel.setIcon(homeIcon);
		panAdresse.add(homeImageLabel);
		panAdresse.add(home);

		
		infoPan = new JPanel();
		infoPan.setLayout(new GridLayout(3, 1));
		
		
		infoPan.add(panLigne1);
		
		infoPan.add(panTelephone);
		infoPan.add(panAdresse);
		infoPan.setBackground(BackgroundBlueColor);

		centerPan = new JPanel();
		centerPan.setLayout(new BorderLayout());
		centerPan.add(infoPan,BorderLayout.LINE_START);
		//centerPan.add(imageLabel,BorderLayout.LINE_END);
		centerPan.setBackground(BackgroundBlueColor);

		lowerPan.add(confirm);
		lowerPan.add(cancel);
		lowerPan.setBackground(BackgroundBlueColor);

		pan.add(box);
		pan.add(centerPan);
		pan.add(lowerPan);
		
		pan.setBackground(BackgroundBlueColor);

		this.add(pan);
	}
	/**
	*	Links elements to their proper reaction
	**/
	private void attacherReactions(){
		box.addActionListener(new EcouteurItemBox(this));
		confirm.addActionListener(new EcouteurItemConfirmAjouter(this));
		cancel.addActionListener(new EcouteurItemCancelAjouter(this));
	}

	// Getters

	public JLabel getLabelNom(){
		return name;
	}
	public JLabel getLabelPrenom(){
		return firstname;
	}
	public JLabel getLabelNumero(){
		return number;
	}	
	public JLabel getLabelImage(){
			return imageLabel;
	}
	public JComboBox getBox(){
		return box;
	}
	public JButton getConfirm(){
		return confirm;
	}
	public JButton getCancel(){
		return cancel;
	}
	/**
	*	called when the user confirms he wants to add a contact
	**/
	public void confirm(){
		Fiche f = (Fiche) box.getSelectedItem();
		(Globale.w).ajouterAbonne(f.getNom(), f.getPrenom(), f.getTelephone());
		this.setVisible(false);
	}
	/**
	*	called when the user cancels what he is doing
	**/
	public void cancel(){
		this.setVisible(false);
	}
}