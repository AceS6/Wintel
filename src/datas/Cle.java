package datas;
import java.io.*;

//FAIRE JAVADOC 1.6 et pas 1.7

/**
* <b>Classe Cle</b>
* Manages keys of a "Fiche" object
* @author Quentin Pitalier / Antoine Sauray
* @version 1.5
*/

public class Cle implements Serializable{ 
	
	private String key;
	private static final long serialVersionUID=0;
	
	/**
	* <b>Cle()</b>
	* Constructor - Creates a key made of a name and a first name
	* @param unNom the name of the contact
	* @param unPrenom the first name of the contact
	*/
	
	public Cle(String unNom, String unPrenom){
		this.key=unNom+"_"+unPrenom;
	}
	
	/**
	* <b>hashCode()</b>
	* Controller - Returns 1
	* @return int
	*/
	
	public int hashCode(){
		return 1;
	}
	
	/**
	* <b>getPrenom()</b>
	* Controller - Checks if the two objects "Cle" have the same key.
	* @param obj the object to compare to
	* @return ret return true if the objects have the same key. False otherwise
	*/
	
	public boolean equals(Object obj){
		boolean ret=false;
		Cle tmp=(Cle) obj; //transtypage obligatoire pour les comparer
		if(this.getKey().equals(tmp.getKey())){
			ret=true;
		}
		return ret;
	}
	
	/**
	* <b>getKey()</b>
	* Getter - Returns the key
	* @return key the key of the "Cle" object
	*/
	
	public String getKey(){
		return this.key;	
	}
		
}