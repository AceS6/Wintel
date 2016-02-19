package ihm;

import datas.*;
import controller.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
*	Class WtDialogModifier
*	@author : Quentin Pitalier / Antoine Sauray 
*   @version : 1.0
*	WtDialogModifier is a dialog to confirm the modification of a contact
**/
public class WtDialogModifier extends JDialog implements Globale{
	
	
	private JLabel instruction;

	private JTextField newTextNumber;
	private JTextField newTextHome;
	private JTextField newTextWork;
	
	private JLabel name;
	private JLabel firstname;
	private JLabel number;
	private JLabel home;
	private JLabel work;
	
	
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
	public WtDialogModifier(){
		super (Globale.w, "Modification du contact : "+(Globale.w).getLabelNom().getText()+ " "+(Globale.w).getLabelPrenom().getText(), true ); 	//Appel du constructeur de JDialog
		// On vérifie si un contact est selectionné
		if((Fiche) ((Globale.w).getListeGche().getSelectedValue())!=null){
		
			this.creerInterface();		//Mise en place de l'interface
			this.attacherReactions(); 	//Ecouteurs des JBoutons et de JComboBox
		
			this.setSize(600,500);
			this.setResizable(false);
			this.setVisible(true);
		}
		// Si il n'y en a pas on avertit l'utilisateur
		else{
			JOptionPane.showMessageDialog(null,"Veuillez selectionner un contact à modifier", "Aucun contact selectionné",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	/**
	*	Initalise the graphical interface
	**/
	private void creerInterface(){

		newTextNumber = new JTextField();
		newTextNumber.setMaximumSize(new Dimension(500, 20));
		newTextNumber.setText((Globale.w).getLabelNom().getText());

		newTextHome = new JTextField();
		newTextHome.setMaximumSize(new Dimension(500, 20));
		newTextHome.setText((Globale.w).getLabelAdresse().getText());

		newTextWork = new JTextField();
		newTextWork.setMaximumSize(new Dimension(500, 20));
		newTextWork.setText((Globale.w).getLabelProfession().getText());

		this.getContentPane().setBackground(BackgroundBlueColor);

		// Labels contenants les informations du contact

		name = new JLabel((Globale.w).getLabelNom().getText());
		name.setFont(new Font("Calibri", Font.BOLD, 24));
		name.setForeground(Color.white);

		firstname = new JLabel((Globale.w).getLabelPrenom().getText());
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

		// 


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
		panTelephone.add(newTextNumber);

		homeImageLabel = new JLabel();
		homeIcon = new ImageIcon(new ImageIcon("../data/Adresse.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		homeImageLabel.setIcon(homeIcon);
		panAdresse.add(homeImageLabel);
		panAdresse.add(newTextHome);

		workImageLabel = new JLabel();
		workIcon = new ImageIcon(new ImageIcon("../data/Profession.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		workImageLabel.setIcon(workIcon);
		panProfession.add(workImageLabel);
		panProfession.add(newTextWork);

		
		infoPan = new JPanel();
		infoPan.setLayout(new GridLayout(4, 1));
		
		
		infoPan.add(panLigne1);
		
		infoPan.add(panTelephone);
		infoPan.add(panAdresse);
		infoPan.add(panProfession);
		infoPan.setBackground(BackgroundBlueColor);

		centerPan = new JPanel();
		centerPan.setLayout(new BorderLayout());
		centerPan.add(infoPan,BorderLayout.LINE_START);
		centerPan.setBackground(BackgroundBlueColor);

		lowerPan.add(confirm);
		lowerPan.add(cancel);
		lowerPan.setBackground(BackgroundBlueColor);

		pan.add(centerPan);
		pan.add(lowerPan);
		
		pan.setBackground(BackgroundBlueColor);

		this.add(pan);
	}
	/**
	*	Links buttons to their proper reaction
	**/
	private void attacherReactions(){
		confirm.addActionListener(new EcouteurItemConfirmModifier(this));
		cancel.addActionListener(new EcouteurItemCancelModifier(this));
	}
	/**
	*	called when the user confirms the modification of a contact
	**/
	public void confirm(){
		
		try{
			Fiche f = new Fiche( (Globale.w).getLabelNom().getText(), (Globale.w).getLabelPrenom().getText(), newTextNumber.getText(),newTextHome.getText(),newTextWork.getText());
			(Globale.w).getAnnuaire().modifier( ((Fiche) ((Globale.w).getListeGche().getSelectedValue() ) ).getLaCle(), f);	
			DefaultListModel tab = (DefaultListModel) ((Globale.w).getListeGche().getModel());
			tab.removeElement(((Fiche) ((Globale.w).getListeGche().getSelectedValue() ) ));
			tab.addElement(f);
			this.setVisible(false);	
		}
		catch(IllegalArgumentException e){
			JOptionPane.showMessageDialog(null,e.getMessage(), name.getText()+ " "+firstname.getText() + " n'a pas été modifié ",JOptionPane.WARNING_MESSAGE);
		}
		catch(NoSuchElementException e){
			JOptionPane.showMessageDialog(null,e.getMessage(), name.getText()+ " "+firstname.getText() + " n'a pas été modifié ",JOptionPane.WARNING_MESSAGE);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage(), name.getText()+ " "+firstname.getText() + " n'a pas été modifié ",JOptionPane.WARNING_MESSAGE);
		}

	/**
	*	called when the user cancels the modification of a contact
	**/
	}
	public void cancel(){
		this.setVisible(false);
	}

}

