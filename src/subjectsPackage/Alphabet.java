package subjectsPackage;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import resourcesPackage.Resource;
import customizedExceptionPackage.FirstRunException;




/**
 * This is a subclass of the Subject Abstract Class
 * It represents the Alphabet subject and implements all the declared
 * methods in the Subject Abstract Class 
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class Alphabet extends Subject implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * The constructor invokes the internal initialize() method
	 * if it's the very first run of the program
	 * that is determined by a boolean parameter
	 * @param firstRun
	 * @throws FirstRunException
	 */
	public Alphabet(boolean firstRun)throws FirstRunException {
		if (firstRun){initialize();} // if it's the first time, initialize the alphabet
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public void addNew(String noun, String pronounciation, String image){
		this.noun.add(noun); // add the new noun to the noun LinkedList
		content.put(noun, new ArrayList<String>(Arrays.asList(new String[]{pronounciation, image}))); // add the new element to the content TreeMap

	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public void delete(String noun){
		new File(content.get(noun).get(0)).delete();
		new File(content.get(noun).get(1)).delete();
		this.noun.remove(noun); // then remove the noun from the noun LinkedList
		content.remove(noun); // and remove the element from the content TreeMap
		
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public void edit(String oldNoun, String newNoun, String pronounciation, String image){
		String nounTemp = oldNoun; // create a temporary String to hold the oldNoun
		ArrayList<String> valueTemp = new ArrayList<String>(2); // create a temporary ArrayList of size 2 to hold pronunciation and the image
		if (newNoun!=null && !newNoun.replaceAll(" ", "").isEmpty()){ // if the newNoun is valid input
			this.noun.set(this.noun.indexOf(oldNoun), newNoun); //replace the old noun with the new 
			nounTemp = newNoun; // set the temporary String to the new noun
		}
		if (pronounciation!=null && !pronounciation.isEmpty()){ // if the pronunciation is valid input
			valueTemp.add(0, pronounciation); // add it to the first index in the temporary ArrayList 
			new File(content.get(oldNoun).get(0)).delete();
		}
		else { // it it's not valid
			valueTemp.add(0, content.get(oldNoun).get(0)); // keep the old pronunciation and add it to the temporary ArrayList
		}
		if(image!=null && !image.isEmpty()){ // if the image is valid input
			valueTemp.add(1, image); // add it to the second index in the temporary ArrayList
			new File(content.get(oldNoun).get(1)).delete();
		}
		else{ // it it's not valid
			valueTemp.add(1, content.get(oldNoun).get(1)); // keep the old image and add it to the temporary ArrayList
		}
		content.remove(oldNoun); // remove the old elements from the content  
		content.put(nounTemp, valueTemp); // and add the new entry to the content TreeMap
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public void initialize(){
	    noun.addAll(getAlphabet()); // add the alphabet list by invoking the internal method getAlphabet()
	    Iterator<ArrayList<String>> it = Resource.getAlphabet().iterator(); // create an iterator of the alphabet in the database 
		for(String letter : noun){ // fill the content TreeMap with the entries for the first time
			content.put(letter, it.next());
			}
	}

	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This method is invoked internally and 
	 * returns the basic initial alphabet nouns for the first run as a List
	 * @return alphabet
	 */
	private List<String> getAlphabet(){
		return Arrays.asList(new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M",
										  "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"});	
	}
	


	
	
}
