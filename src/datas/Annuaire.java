package datas;
import java.io.*;
import java.util.*;

	/**
	* <b>Class Fiche</b>
	* This class is a directory. It contains contacts and provides informations on each of them.
	* @author Quentin Pitalier / Antoine Sauray
	* @version 1.0
	*/
public class Annuaire implements Serializable{
	
	//Attributes
	private static long serialVersionUID = 0;	
	private Hashtable<Cle,Fiche> tabFiches;

	
	/**
	* <b>Annuaire()</b>
	* Constructor.
	* Builds a "Annuaire" object
	*/
	public Annuaire(){                                 
		tabFiches = new Hashtable<Cle,Fiche>();	
	}


	/**
	* <b>ajouter()</b>
	* adds a new contact to the Annuaire
	* @param cle the "Cle" object of the contact
	* @see Cle
	* @param personne The "Fiche" object of the contact
	* @see Fiche
	* @throws IllegalArgumentException if one of the parameters is null.
	* @throws Exception if the binary file "annuaire.out" is not found or if it is empty
	*/
	public void ajouter(Cle cle, Fiche personne) throws IllegalArgumentException, Exception{
		if(this.existe(cle)){
			throw new Exception("Erreur: clé déjà présente dans l'annuaire");
		}
		else{
			tabFiches.put(cle, personne);
		}
	}

	public static Annuaire charger(){
		Annuaire ret= null;

		try{
			String fich ="./annuaire.out";
			FileInputStream in = new FileInputStream(fich);
			ObjectInputStream flux = new ObjectInputStream(in);
			ret = (Annuaire)flux.readObject();
		}
		
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		
		catch(IOException e){
			System.out.println(e.getMessage());
		}

		catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
			
		return ret;
 
	}

	/**
	* <b>Enumeration</b>
	* returns an Enumerations of all the "Cle" in the annuaire
	* @return an Enumerations of all the "Cle" in the annuaire
	*/
	public Enumeration<Cle> cles(){
		return tabFiches.keys();
	
	}

	/** 
	* <b>conslter(Cle cle)</b>
	* looks for a contact
	* @param cle the "Cle" to identify the right contact
	* @see Fiche
	* @return the "Fiche" object which correspond to the "Cle"
	*/
	public Fiche consulter(Cle cle) throws IllegalArgumentException{
		Fiche ret = null;

		if (cle == null){
			throw new IllegalArgumentException("Erreur: clé nulle");
		}
		else{
			ret = tabFiches.get(cle);
		}
			
		return ret;
	
	}	  
	/** 
	* <b>existe(Cle cle)</b>
	* checks if a contact exists
	* @param cle the "Cle" to identify the right contact
	* @see Cle
	* @return true if the "Cle" exists in the Annuaire, false otherwise
	*/
	public boolean existe(Cle cle){
	
		return tabFiches.containsKey(cle);
	}
	/** 
	* <b>modifier(Cle cle, Fiche personne)</b>
	* modifies a contact
	* @param cle the "Cle" to identify the right contact
	* @param personne the "Fiche" which will replace the current one
	* @throws IllegalArgumentException if one of the parameters is null
	* @throws NoSuchElementException if there is no "Cle" which corresponds to the one provided by the user
	* @throws Exception if the "Fiche" and the "Cle" don't correspond
	* @see Cle
	* @see Fiche
	*/
	public void modifier(Cle cle, Fiche personne) throws IllegalArgumentException,NoSuchElementException, Exception{

		if (cle == null){
			throw new IllegalArgumentException("Erreur: clé nulle");
		}

		else if(this.existe(cle) == false){
			throw new NoSuchElementException("Erreur: clé inexistante dans la table");		
		}

		
		else if(!personne.getLaCle().equals(cle)){
			throw new Exception("La clé de la nouvelle fiche ne correspond pas à la clé de la fiche à remplacer");
		}
		else{	
			tabFiches.remove(cle);
			tabFiches.put(cle,personne);
		}
	}
	/** 
	* <b>sauver()</b>
	* save the "Annuaire" into a binary file named "annuaire.out"
	*/
	public void sauver(){
		String fich ="./annuaire.out";
		
		try{
			FileOutputStream out = new FileOutputStream(fich);
			ObjectOutputStream flux = new ObjectOutputStream(out);
			flux.writeObject(this);
		}

		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	/** 
	* <b>supprimer(Cle cle)</b>
	* delete a contact
	* @param cle the key to identify the contact
	* @see Cle
	*/
	public void supprimer(Cle cle) throws IllegalArgumentException, NoSuchElementException{

		if (cle == null){
			throw new IllegalArgumentException("Erreur: clé nulle");
		}

		else if(this.existe(cle) == false){
			throw new NoSuchElementException("Erreur: clé inexistante dans la table");		
		}

		else{
			tabFiches.remove(cle);	
		}
	}
	/** 
	* <b>taille()</b>
	* gets the number of contacts
	* @return the number of contacts
	*/
	public int taille(){
		return tabFiches.size();
	}
}
