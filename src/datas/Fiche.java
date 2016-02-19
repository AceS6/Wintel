package datas;
import java.io.*;

	/**
	* <b>Class Fiche</b>
	* This class provides all the informations on a contact.
	* @author Quentin Pitalier / Antoine Sauray
	* @version 1.5
	*/

public class Fiche implements Serializable{
	private Cle laCle;
	private String nom, prenom, telephone, adresse, profession;
	private static final long serialVersionUID=0;
	
	/**
	* <b>Fiche()</b>
	* Constructor no1.
	* Builds a "Fiche" object using 3 parameters
	* @param leNom the name of the contact
	* @param lePrenom the first name of the contact
	* @param leTelephone the phone number of the contact
	* @throws IllegalArgumentException if one of the parameters is null.
	*/
	
	public Fiche(String leNom, String lePrenom, String leTelephone) throws IllegalArgumentException{
		if (leNom != null && lePrenom != null && leTelephone != null){
				this.nom=leNom;
				this.prenom=lePrenom;
				this.telephone=leTelephone;
				this.adresse="Non Renseigné";
				this.profession="Non Renseigné";
				laCle=new Cle(nom, prenom);
		}
		else{
			throw new IllegalArgumentException("Argument non Valide");
		}
	}

	/**
	* <b>Fiche()</b>
	* Constructor no2.
	* Builds a "Fiche" object using 4 parameters
	* @param leNom the name of the contact
	* @param lePrenom the first name of the contact
	* @param leTelephone the phone number of the contact
	* @param adresse the adress of the contact
	* @throws IllegalArgumentException if one of the parameters is null.
	*/
	
	public Fiche(String leNom, String lePrenom, String leTelephone, String adresse) throws IllegalArgumentException{
		if (leNom != null && lePrenom != null && leTelephone != null){
				this.nom=leNom;
				this.prenom=lePrenom;
				this.telephone=leTelephone;
				this.adresse=adresse;
				this.profession="Non Renseigné";
				laCle=new Cle(nom, prenom);
		}
		else{
			throw new IllegalArgumentException("Argument non Valide");
		}
	}

	/**
	* <b>Fiche()</b>
	* Constructor no2.
	* Builds a "Fiche" object using 4 parameters
	* @param leNom the name of the contact
	* @param lePrenom the first name of the contact
	* @param leTelephone the phone number of the contact
	* @param adresse the adress of the contact
	* @param profession the job of the contact
	* @throws IllegalArgumentException if one of the parameters is null.
	*/
	
	public Fiche(String leNom, String lePrenom, String leTelephone, String adresse, String profession) throws IllegalArgumentException{
		if (leNom != null && lePrenom != null && leTelephone != null){
				this.nom=leNom;
				this.prenom=lePrenom;
				this.telephone=leTelephone;
				this.adresse=adresse;
				this.profession=profession;
				laCle=new Cle(nom, prenom);
		}
		else{
			throw new IllegalArgumentException("Argument non Valide");
		}
	}
	
	/**
	* <b>getNom()</b>
	* Getter - Returns the name of the contact
	* @return the name of the contact
	*/
	
	public String getNom(){ return this.nom;}
	
	/**
	* <b>getPrenom()</b>
	* Getter - Returns the first name of the contact
	* @return the first name of the contact
	*/
	
	public String getPrenom(){ return this.prenom;}
	
	/**
	* <b>getTelephone()</b>
	* Getter - Returns the phone number of the contact
	* @return the phone number of the contact
	*/

	public String getTelephone(){ return this.telephone;}
	
	/**
	* <b>getAdresse()</b>
	* Getter - Returns the adress of the contact
	* @return the adress of the contact
	*/

	public String getAdresse(){return this.adresse;}
	
	/**
	* <b>getProfession()</b>
	* Getter - Returns the job of the contact
	* @return the job of the contact
	*/

	public String getProfession(){return this.profession;}
	
	/**
	* <b>getLaCle()</b>
	* Getter - Returns the key object of the "Fiche"
	* @see Fiche
	* @return the object "Cle" of the contact
	*/

	public Cle getLaCle(){ return this.laCle;}
	
	/**
	* <b>toString()</b>
	* Getter - Returs the name and the first name of the "Fiche" object. 
	* @return the "Cle" object of the contact
	*/
	
	public String toString(){ return this.prenom+" "+this.nom;}
	
	/**
	* <b>FicheComplete()</b>
	* Getter - Retourne all the informations available on the "Fiche" object
	* name, first name, phone number, adress, job
	* @return  all the informations on the contact
	*/
	
	public String FicheComplete(){
		String ret="";
		ret="Nom= "+this.getNom()+"\nPrenom= "+this.getPrenom()+"\nN°Tel= "+this.getTelephone()+"\nAdresse="+adresse+"\nProfession="+profession+"\nCle= "+this.getLaCle();
		return ret;
	}
		
}
