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
 * It represents the Animals subject and implements all the declared
 * methods in the Subject Abstract Class 
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class Animals extends Subject implements Serializable{


	private static final long serialVersionUID = 1L;


	/**
	 * The constructor invokes the internal initialize() method
	 * if it's the very first run of the program
	 * that is determined by a boolean parameter
	 * @param firstRun
	 * @throws FirstRunException
	 */
	public Animals(boolean firstRun) throws FirstRunException{
		if (firstRun){initialize();}
	}

	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	@Override
	public void addNew(String noun, String pronounciation, String image){
		this.noun.add(noun);
		content.put(noun, new ArrayList<String>(Arrays.asList(new String[]{pronounciation, image})));
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public void delete(String noun){
		new File(content.get(noun).get(0)).delete();
		new File(content.get(noun).get(1)).delete();
		this.noun.remove(noun);
		content.remove(noun);	
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Override
	public void edit(String oldNoun, String newNoun, String pronounciation, String image){
		String nounTemp = oldNoun;
		ArrayList<String> valueTemp = new ArrayList<String>(2);
		if (newNoun!=null && !newNoun.replaceAll(" ", "").isEmpty()){
			this.noun.set(this.noun.indexOf(oldNoun), newNoun);
			nounTemp = newNoun;
		}
		if (pronounciation!=null && !pronounciation.isEmpty()){
			valueTemp.add(0, pronounciation);
			new File(content.get(oldNoun).get(0)).delete();
		}
		else {
			valueTemp.add(0, content.get(oldNoun).get(0));
		}
		if(image!=null && !image.isEmpty()){
			valueTemp.add(1, image);
			new File(content.get(oldNoun).get(1)).delete();
		}
		else{
			valueTemp.add(1, content.get(oldNoun).get(1));
		}
		content.remove(oldNoun);
		content.put(nounTemp, valueTemp);
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	@Override
	public void initialize(){
	    noun.addAll(getAnimals());
	    Iterator<ArrayList<String>> it = Resource.getAnimals().iterator();
		for(String animal : noun){
			content.put(animal, it.next());
		}
	}

	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	/**
	 * This method is invoked internally and 
	 * returns the basic initial animals nouns for the first run as a List
	 * @return animals
	 */
	private List<String> getAnimals(){
		return Arrays.asList(new String[]{
										"Cat","Dog","Rabbit","Horse","Donkey",
										"Elephant","Lion","Cow","Duck","Hen",
										"Fish","Sheep","Bear","Tiger","Monkey"});
	}
	
	
}
