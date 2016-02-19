package ihm;

import datas.*;
import controller.ReactionAction;
import controller.ReactionMouse;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


/**
*	Classe Wintel
*	@author : Quentin Pitalier / Antoine Sauray 
*   @version : 1.0
*	Wintel manages the graphica interface of the project
**/

public class Wintel extends JFrame{

	private Annuaire a;

	/********************************
	Interface Graphique
	*********************************/
	
	private JPanel panelNord;
	private JLabel abonnes;
	private JLabel caracteristiques;

	private JPanel panelCentre;
	private JPanel panelGauche;
	private JPanel panelCaract;
	
	private JPanel panelSud;

	private GridLayout grilleCentre;
	private JList listeGche;
	

	
	//Zone d'affichage de la bannière du logiciel
	
	private ImageIcon banniere;
	private ImageIcon banniereContact;
	private JPanel bannierePan;
	private JLabel bannierelabel;	// Label contenant l'icone
	private JLabel banniereTexte;
	

	// Zone d'affichage du nom et du prénom du contact

	private JPanel nomPan;
	private JLabel userlabel;	// Label contenant l'icone
	private ImageIcon user;		// Icone d'utilisateur
	private JLabel prenom;		// Zone d'affichage du prénom
	private JLabel espace;		// Espace entre prenom et nom
	private JLabel nom;		// Zone d'affichage du nom

	// Zone d'affichage du numéro de téléphone du contact

	private JPanel numPan;
	private JLabel phonelabel;	// Label contenant l'icone
	private ImageIcon phone;	// Icone de téléphone
	private JLabel numero;		// Zone d'affichage du numéro

	// Zone d'affichage de l'adresse du contact

	private JPanel homePan;
	private JLabel homelabel;
	private ImageIcon home;
	private JLabel adresse;

	// Zone d'affichage de la profession du contact
	private JPanel workPan;
	private JLabel worklabel;
	private ImageIcon work;
	private JLabel profession;

	// Boutons en bas à droite
	private JPanel downButtonsPan;
	private ImageIcon add;
	private JButton addbutton;
	private ImageIcon modify;
	private JButton modifybutton;
	private ImageIcon delete;
	private JButton deletebutton;

	// boutons charger et sauver en bas à gauche
	private JPanel loadAndSavePan;
	private ImageIcon load;
	private JButton loadbutton;
	private ImageIcon save;
	private JButton savebutton;

	
	//Menu de Wintel
	
	private JMenuBar menuBar;

	private JMenu menuFichier;
	private JMenu menuAbonnes;
	private JMenu menuAide;

	private JMenuItem itemCharger;
	private JMenuItem itemSauver;
	private JMenuItem itemQuitter;
	private JMenuItem itemAjouter;
	private JMenuItem itemModifier;
	private JMenuItem itemSupprimer;
	private JMenuItem itemAide;

	
		//Créations des couleurs utilisé pour le logiciel
	
	    //Couleur de Background
	
	private Color BackgroundBlueColor = new Color(0x003542);
	
	    //Couleurs de base.
	private Color yellowColor = new Color(0xFEB80A); // Jaune
	private Color greenColor = new Color(0x00B050); // Vert
	private Color blueColor = new Color(0x2E82E5); // Bleu
	private Color redColor = new Color(0x781108); // RougeFoncé
	
	    //Couleur des boutons
	
	private Color blueBoutonColor = new Color(0x7B94D4); //Bleu/Violet
	private Color redBoutonColor = new Color(0xA41A3E); //RougeFushia
	private Color orangeBoutonColor = new Color(0xD0562D); //OrangeFoncé
	private Color greenBoutonColor = new Color(0x0B2161); //VertClair 

	//Créations des boutons Sud
	
	private JLabel boutonLabelEast;
	private JLabel boutonLabelWest;
	private JPanel boutonPan;


	private WtDialogAjouter ajouter;
	private WtDialogModifier modifier;
	private WtDialogSupprimer supprimer;
	private DialogText aide;

	/**
	* 	Generates Wintel
	* 	@param title the window's title
	**/
	public void start(String title){
		this.setTitle( title ); // appel constructeur de JFrame 
		this.init();
		this.setIconImage((new ImageIcon("../data/icoWintel.png")).getImage());
		this.creerInterface(); // mise en place du décor 
		this.attacherReactions();
		this.setSize( 800, 600 ); // dimensionnement de la fenêtre 
		this.setVisible( true ); // rendre la fenêtre visible 
		this.setDefaultCloseOperation ( EXIT_ON_CLOSE ); // clic sur la croix 
		this.startupHelp();
	}

	/**
	*	Initalises Wintel's directory
	**/
	private void init(){
		a = new Annuaire();
	}
	/**
	*	Creates Wintel interface
	**/
	private void creerInterface(){

		menuBar = new JMenuBar();
		menuFichier = new JMenu("Fichier");
		menuAbonnes = new JMenu("Abonnés");
		menuAide = new JMenu("Aide");

		itemCharger = new JMenuItem("Charger");
		itemSauver = new JMenuItem("Sauver");
		itemQuitter = new JMenuItem("Quitter");
		itemAjouter = new JMenuItem("Ajouter");
		itemModifier = new JMenuItem("Modifier");
		itemSupprimer = new JMenuItem("Supprimer");
		itemAide = new JMenuItem("Aide");

		menuFichier.add(itemCharger);
		menuFichier.add(itemSauver);
		menuFichier.add(itemQuitter);

		menuAbonnes.add(itemAjouter);
		menuAbonnes.add(itemModifier);
		menuAbonnes.add(itemSupprimer);

		menuAide.add(itemAide);

		menuBar.add(menuFichier);
		menuBar.add(menuAbonnes);
		menuBar.add(menuAide);


		this.setJMenuBar(menuBar);


		panelNord = new JPanel();
		panelCentre = new JPanel();
		panelSud = new JPanel();
		panelCaract = new JPanel();
		nomPan = new JPanel();
		numPan = new JPanel();
		homePan = new JPanel();
		workPan = new JPanel();


		panelNord.setLayout(new GridLayout(1, 1));
		panelNord.setBackground(BackgroundBlueColor);

		
		//Construction de la banniere du logiciel
		
		bannierePan = new JPanel();		
		
		bannierelabel = new JLabel();
		bannierePan.setLayout(new BorderLayout());
		banniere = new ImageIcon(new ImageIcon("../data/Wintel.png").getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH));
		
		
		banniereTexte = new JLabel();
		banniereContact = new ImageIcon(new ImageIcon("../data/ListedeContact.png").getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH));
		
		banniereTexte.setIcon(banniereContact);
		bannierelabel.setIcon(banniere);
		
		bannierePan.add(banniereTexte, BorderLayout.LINE_START);
		bannierePan.add(bannierelabel,BorderLayout.LINE_END);
		
		bannierePan.setBackground(BackgroundBlueColor);
		bannierePan.setBorder(BorderFactory.createMatteBorder(10, 40, 0, 40, BackgroundBlueColor));
		
		panelNord.add(bannierePan);
		
		

		/////////////////////////////////////////////


		// Affichage de Fiche

		GridBagConstraints gbcH = new GridBagConstraints();
		gbcH.gridx = 0;
		gbcH.gridy = GridBagConstraints.RELATIVE;
		gbcH.fill = GridBagConstraints.HORIZONTAL;
		gbcH.insets = new Insets(30, 30, 30, 30);

		// Construction nomPan : Icone + Prénom + Nom du contact
		nomPan.setLayout(new BoxLayout(nomPan, BoxLayout.X_AXIS));
		user = new ImageIcon(new ImageIcon("../data/Contact.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		userlabel = new JLabel();
		userlabel.setIcon(user);
		prenom = new JLabel();
		prenom.setFont(new Font("Calibri", Font.PLAIN, 24));
		espace = new JLabel(" ");
		espace.setFont(new Font("Calibri", Font.PLAIN, 24));
		prenom.setForeground(Color.white);
		nom = new JLabel();
		nom.setFont(new Font("Calibri", Font.BOLD, 24));
		nom.setForeground(Color.white);
		
		nomPan.add(userlabel);
		nomPan.add(prenom);
		nomPan.add(espace);
		nomPan.add(nom);



		// Construction numPan : icone + numéro de téléphone du contact
		numPan.setLayout(new BoxLayout(numPan, BoxLayout.X_AXIS));
		phone = new ImageIcon(new ImageIcon("../data/Telephone.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		phonelabel = new JLabel();
		phonelabel.setIcon(phone);
		numero = new JLabel();
		
		numero.setFont(new Font("Calibri", Font.PLAIN, 24));
		numero.setForeground(Color.white);
		
		numPan.add(phonelabel);
		numPan.add(numero);


		// Construction homePan : Icone + adresse du contact
		homePan.setLayout(new BoxLayout(homePan, BoxLayout.X_AXIS));
		home = new ImageIcon(new ImageIcon("../data/Adresse.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		homelabel = new JLabel();
		homelabel.setIcon(home);

		adresse = new JLabel();
		
		adresse.setFont(new Font("Calibri", Font.PLAIN, 24));
		adresse.setForeground(Color.white);
		
		homePan.add(homelabel);
		homePan.add(adresse);


		// Construction workPan : Icone + profession
		workPan.setLayout(new BoxLayout(workPan, BoxLayout.X_AXIS));
		work = new ImageIcon(new ImageIcon("../data/Profession.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		worklabel = new JLabel();
		worklabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		worklabel.setIcon(work);
		profession = new JLabel();
		
		profession.setFont(new Font("Calibri", Font.PLAIN, 24));
		profession.setForeground(Color.white);
		
		workPan.add(worklabel);
		workPan.add(profession);
		
		//Mise en place des couleurs de Background
		 String param="grey";
		 
		 panColoredBackground(param);

		// Panel des boutons 
		 downButtonsPan = new JPanel();
		 downButtonsPan.setBackground(BackgroundBlueColor);
		 downButtonsPan.setLayout(new GridLayout(0,3));

		 add = new ImageIcon(new ImageIcon("../data/Ajouter.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		 addbutton = new JButton();
		 addbutton.setBackground(greenBoutonColor);
		 addbutton.setIcon(add);

		 modify = new ImageIcon(new ImageIcon("../data/Modifier.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		 modifybutton = new JButton();
		 modifybutton.setBackground(greenBoutonColor);
		 modifybutton.setIcon(modify);

		 delete = new ImageIcon(new ImageIcon("../data/Supprimer.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		 deletebutton = new JButton();
		 deletebutton.setBackground(greenBoutonColor);
		 deletebutton.setIcon(delete);

		 downButtonsPan.add(addbutton);
		 downButtonsPan.add(modifybutton);
		 downButtonsPan.add(deletebutton);

		 //

		 // Sauvegarder et charger
		 loadAndSavePan = new JPanel();
		 loadAndSavePan.setLayout(new FlowLayout());
		 loadAndSavePan.setBackground(BackgroundBlueColor);
		 load = new ImageIcon(new ImageIcon("../data/Charger.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		 loadbutton = new JButton();
		 loadbutton.setBackground(greenBoutonColor);
		 loadbutton.setIcon(load);
		 save = new ImageIcon(new ImageIcon("../data/Sauvegarder.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		 savebutton = new JButton();
		 savebutton.setBackground(greenBoutonColor);
		 savebutton.setIcon(save);

		 loadAndSavePan.add(loadbutton);
		 loadAndSavePan.add(savebutton);




		// Construction panelCaract : Contient tous les autres panels d'informations du contact (vertical)
		panelCaract.setLayout(new GridLayout(5,1,20,20));

		GridLayout gbcV = new GridLayout();
		


		panelCaract.setBackground(BackgroundBlueColor);
		//panelCaract.setVisible(false);
		panelCaract.add(nomPan, gbcV);
		panelCaract.add(numPan, gbcV);
		panelCaract.add(homePan, gbcV);
		panelCaract.add(workPan, gbcV);
		panelCaract.add(downButtonsPan, gbcV);
		panelCaract.setBorder(BorderFactory.createMatteBorder(20, 40, 40, 40, BackgroundBlueColor));
		

		/////////////////////////////////////////////

		//Affichage de Annuaire
		
		////////////////////////////////////////////

		grilleCentre = new GridLayout(1, 2, 10, 0);

		listeGche = new JList();
		listeGche.setFont(new Font("Verdana",Font.PLAIN,18)); 
		listeGche.setModel(new DefaultListModel());
		listeGche.addMouseListener(new ReactionMouse());
		listeGche.setBackground(blueColor);

		//Création d'une bordure autour de la JList
		
		listeGche.setBorder(BorderFactory.createMatteBorder(20, 40, 40, 40, BackgroundBlueColor)); 

		// Création du panel de gauche
		panelGauche = new JPanel();
		panelGauche.setLayout(new BorderLayout());
		panelGauche.setBackground(BackgroundBlueColor);
		panelGauche.add(listeGche,BorderLayout.CENTER);
		panelGauche.add(loadAndSavePan,BorderLayout.PAGE_END);
		
		panelCentre.setLayout(grilleCentre);
		panelCentre.setBackground(BackgroundBlueColor);
		panelCentre.add(panelGauche);


		panelCentre.add(panelCaract);
		
		/////////////////////////////////////////////////////
		// Affichage des boutons de contrôle supplémentaires
		/////////////////////////////////////////////////////
		
		boutonPan = new JPanel();
		boutonPan.setLayout(new BorderLayout());		
		
		boutonLabelEast = new JLabel();
		boutonPan.setLayout(new BorderLayout());
		
		boutonLabelWest = new JLabel();
		
		boutonPan.add(boutonLabelEast, BorderLayout.LINE_START);
		boutonPan.add(boutonLabelWest,BorderLayout.LINE_END);
		
		
		panelSud.add(boutonPan);
		panelSud.setBackground(BackgroundBlueColor);
		
		
		

		this.add(panelNord, BorderLayout.NORTH);
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelSud, BorderLayout.SOUTH);

	}

	private  void attacherReactions(){
		itemSauver.addActionListener(new ReactionAction());
		itemCharger.addActionListener(new ReactionAction());
		itemQuitter.addActionListener(new ReactionAction());
		itemAide.addActionListener(new ReactionAction());
		itemAjouter.addActionListener(new ReactionAction());
		itemModifier.addActionListener(new ReactionAction());
		itemSupprimer.addActionListener(new ReactionAction());

		addbutton.addActionListener(new ReactionAction());
		modifybutton.addActionListener(new ReactionAction());
		deletebutton.addActionListener(new ReactionAction());

		loadbutton.addActionListener(new ReactionAction());
		savebutton.addActionListener(new ReactionAction());
	}
	private void startupHelp(){
		try {
 			BufferedReader br = new BufferedReader(new FileReader("../data/config.cfg"));
 
			if(br.readLine().equals("showHelpOnStartup=true")){
				aide();
			}
			else if(br.readLine().equals("showHelpOnStartup=false")){

			}
			else{
				aide();
			}

			br.close();
 
		} catch (IOException ex) {
			ex.printStackTrace();
			try{
				File file = new File("../data/config.cfg");
				file.createNewFile();
			}
			catch(IOException ex2){
				ex2.printStackTrace();
			}
		}
	}


	/**
	*	Loads and displays the directory
	**/
	public void chargerEtAfficherAnnuaire(){

		a = Annuaire.charger();
		Fiche laFiche;
		Cle laCle;
		DefaultListModel monTab = (DefaultListModel) listeGche.getModel();
		monTab.clear();
		
		for(Enumeration<Cle> lesCles = a.cles(); lesCles.hasMoreElements();){
			laCle = lesCles.nextElement();
			laFiche = a.consulter(laCle);
			monTab.addElement(laFiche);
		}
		listeGche.setModel(monTab);
	}

	/**
	*	Adds a new person
	*	@param nom the name of the contact
	*	@param prenom the first name of the contact
	*	@param numTel the phone number of the contact
	**/
	public void ajouterAbonne(String nom, String prenom, String numTel){
		try{

			// Création de la clé et de la fiche du nouvel abonné
			Cle c = new Cle (nom, prenom);
			Fiche f = new Fiche(nom, prenom, numTel);

			// Ajout à l'annuaire
			a.ajouter(c,f);

			// Si l'ajout a réussi on peut ajouter l'élément à la jlist pour confirmer l'insertion
			DefaultListModel tab = (DefaultListModel) listeGche.getModel();
			tab.addElement(f);
		}
		catch(IllegalArgumentException e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Un contact n'a pas été ajouté",JOptionPane.WARNING_MESSAGE);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Un contact n'a pas été ajouté",JOptionPane.WARNING_MESSAGE);
		}
	
	}
	
	/**
	*	@param param the color to apply to the panel
	**/
	public void panColoredBackground(String param){
		 //boolean randomBackground;
		 int nbrCouleurs = 6;
		 Color colorTable[] = new Color[nbrCouleurs];
		 Color colorTableAlea[] = new Color[4];
		 int alea;
		 boolean doublon=false;
		 
		//Couleurs par défaut du contact
		
		      colorTable[0]=yellowColor;  	//Jaune
		      colorTable[1]=redColor;		//Rouge
		      colorTable[2]=new Color(0x9e00a4); //Violet
		      colorTable[3]=greenColor;		//Vert
		      colorTable[4]=new Color(0x4f617c); //BleuGris
		      colorTable[5]=new Color(0x313230); //Gris
		      
		      if (param.matches("(?i).*grey.*")){ //Remplis le tableau de nuances de gris.
		      
		      colorTable[0]=new Color(0x292929);
		      colorTable[1]=new Color(0x4e4e4e);
		      colorTable[2]=new Color(0x949494); 
		      colorTable[3]=new Color(0xbfbfbf);
		      colorTable[4]=new Color(0xd4d4d4); 
		      colorTable[5]=new Color(0x191919); 
		      }
		      
		      if (param.matches("(?i).*random.*")){
		      
			    for (int i=0; i!=4; i++){
				  alea = (int)(Math.random() * nbrCouleurs);
				  colorTableAlea[i]=colorTable[alea];
				  doublon=false;
			    
			    //On boucle de nouveau si les couleurs apparaissent en double
				  
				  for(int j=0; j<i; j++){
				      if (colorTableAlea[i]==colorTableAlea[j]){doublon=true;}
				  }
				  
				  if (doublon){i--;}
				  }
			    //On remplace les valeurs originales de colorTable par celles de AleaTable
				  
			    for (int i=0; i!=4; i++){
				  colorTable[i]=colorTableAlea[i];
			    }
		      }
		
		      nomPan.setBackground(colorTable[0]);
		      numPan.setBackground(colorTable[1]);
		      homePan.setBackground(colorTable[2]);
		      workPan.setBackground(colorTable[3]);
	}

	/**
	*	Opens a WtDialogAjouter
	*	@see WtDialogAjouter
	**/
	public void ajouter(){
		ajouter = new WtDialogAjouter();
	}
	/**
	*	Opens a WtDialogModifier
	*	@see WtDialogModifier
	**/
	public void modifier(){
		modifier = new WtDialogModifier();
	}
	/**
	*	Opens a window to confirm the user's request to delete the contact
	**/
	public void supprimer(){

				// On vérifie si un contact est selectionné
		if((Fiche) ((this).getListeGche().getSelectedValue())!=null){
			if (JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer "+((Fiche) ((this).getListeGche().getSelectedValue() ) ).getPrenom()+" "+((Fiche) ((this).getListeGche().getSelectedValue() ) ).getNom()+"?", "Suppression d'un contact", 
    			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
   	 				== JOptionPane.YES_OPTION)
			{
				(this).getAnnuaire().supprimer( ((Fiche) ((this).getListeGche().getSelectedValue() ) ).getLaCle());	
				DefaultListModel tab = (DefaultListModel) ((this).getListeGche().getModel());
				tab.removeElement(((Fiche) ((this).getListeGche().getSelectedValue() ) ));
			}
		}
		// Si il n'y en a pas on avertit l'utilisateur
		else{
			JOptionPane.showMessageDialog(null,"Veuillez selectionner un contact à supprimer", "Aucun contact selectionné",JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	*	Opens a help window
	*	@see DialogText
	**/
	public void aide(){
		aide = new DialogText();
	}
	/**
	*	Action to apply if the box is clicked
	**/
	public void clicBox(){
		System.out.println("Action Box");
		ajouter.getLabelImage().setVisible(true);

		Fiche laFiche = (Fiche) ajouter.getBox().getSelectedItem();

		// Accès à la JList
		JComboBox maListe = ajouter.getBox();

		// Affichage des informations de la fiche dans les 3 champs textuels
		// de droite

		JLabel nom = ajouter.getLabelNom();
		nom.setText("Nom : "+laFiche.getNom());

		// accesseur de Wintel

		JLabel prenom = ajouter.getLabelPrenom();
		prenom.setText("Prénom : "+laFiche.getPrenom());

		// accesseur de Wintel

		JLabel num = ajouter.getLabelNumero();
		num.setText("Numéro : "+laFiche.getTelephone());
	}

	// Getters


	public WtDialogAjouter getDialogAjouter(){
		return ajouter;
	}
	public WtDialogModifier getDialogModifier(){
		return modifier;
	}
	public WtDialogSupprimer getDialogSupprimer(){
		return supprimer;
	}
	public JButton getAdd(){return addbutton;}
	public JButton getModify(){return modifybutton;}
	public JButton getDelete(){return deletebutton;}
	public JButton getLoad(){return loadbutton;}
	public JButton getSave(){return savebutton;}

	public JList getListeGche(){
		return listeGche;
	}
	public JLabel getLabelNom(){
		return nom;
	}
	public JLabel getLabelPrenom(){
		return prenom;
	}
	public JLabel getLabelNumero(){
		return numero;
	}
	public JLabel getLabelAdresse(){
		return adresse;
	}
	public JLabel getLabelProfession(){
		return profession;
	}
	public Annuaire getAnnuaire(){
		return a;
	}
	public JPanel getPanelCaract(){
		return panelCaract;
	}
	public JMenuItem getItemCharger(){
		return itemCharger;
	}
	public JMenuItem getItemSauver(){
		return itemSauver;
	}
	public JMenuItem getItemQuitter(){
		return itemQuitter;
	}
	public JMenuItem getItemAjouter(){
		return itemAjouter;
	}
	public JMenuItem getItemModifier(){
		return itemModifier;
	}
	public JMenuItem getItemSupprimer(){
		return itemSupprimer;
	}
	public JMenuItem getItemAide(){
		return itemAide;
	}
}
