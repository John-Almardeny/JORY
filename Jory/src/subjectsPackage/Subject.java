package subjectsPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;



/**
 * This is an abstract class of all subjects
 * it defines and initializes the fields of all subject
 * and it declares some of the core methods that will be used in the subclasses and defines others
 * @author Yahya Almardeny
 * @version 03/12/2016
 */

public abstract class Subject implements Serializable{


	private static final long serialVersionUID = 1L;
	protected LinkedList<String> noun; // the nouns of each subject
	protected TreeMap <String, ArrayList<String>> content; // the content (Pronunciation and Image) that corresponds to each noun 

	
	/**
	 * The constructor initializes the fields
	 */
	public Subject(){
		noun = new LinkedList<String>();
		content = new TreeMap<String, ArrayList<String>>();
	}


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * A getter method of the noun
	 * @return noun
	 */
	public LinkedList<String> getNoun() {
		return noun;
	}


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * A setter method for the noun
	 * @param noun
	 */
	public void setNoun(LinkedList<String> noun) {
		this.noun = noun;
	}


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * A getter method of the content
	 * @return content
	 */
	public TreeMap<String, ArrayList<String>> getContent() {
		return content;
	}


	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * A setter method for the content
	 * @param content
	 */
	public void setContent(TreeMap<String, ArrayList<String>> content) {
		this.content = content;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * Abstract method to initialize the subject for first time
	 */
	public abstract void initialize();
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Abstract method to add new element to the subject
	 * @param noun
	 * @param pronounciation
	 * @param image
	 */
	public abstract void addNew(String noun, String pronounciation, String image);
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Abstract method to delete existing element from the subject
	 * @param noun
	 */
	public abstract void delete(String noun);
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Abstract method to edit existing element in the subject
	 * @param oldNoun
	 * @param newNoun
	 * @param pronounciation
	 * @param image
	 */
	public abstract void edit(String oldNoun, String newNoun, String pronounciation, String image);

	
	
}
