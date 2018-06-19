package coursePackage;

import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import customizedExceptionPackage.FirstRunException;
import fileIOPackage.SubjectIO;
import guiPackage.InitializationWin;
import resourcesPackage.Resource;
import resourcesPackage.Subjects;
import subjectsPackage.*;

/**
 * This Class contains objects of all Subjects
 * and manipulates them for the first program run and every time
 * the programs runs and closes
 * All the work from other classes and the UIs happens on those objects
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class Course implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Alphabet alphabet;
	private static Numbers numbers;
	private static Animals animals;
	private static Colors colors;
	private static Shapes shapes;
	private static Vegetable vegetable;
	private static Fruits fruit;
	public final static File programFolder  = new File(System.getProperty("user.home")+ File.separator + "Jory");
	private final static File settings = new File(programFolder, "settings.txt"); // this file will be as a reference to know the first time run
	
	/**
	 * The Constructor of the Class Course
	 * Initializes the program if it's the first time 
	 * or retrieve the data from the last run
	 */
	public Course(){
		if (!settings.exists()){ // if the file does not exist that means it is the first run on this computer
			new Thread (new Runnable(){public void run(){
				new InitializationWin(); 
			}}).start();
			programFolder.mkdirs();
			Resource.extractDatabase();
			
			try {
				PrintWriter pw = new PrintWriter(settings);
				pw.print("Jory Program First Run"); // create the file
				pw.close();
				Process p = Runtime.getRuntime().exec("attrib +H " + programFolder.getPath()); // hide the folder
			    p.waitFor(); // wait for it
			} 
			catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error in Initializing The Program", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			try{
				Resource.initialize(); // initialize the database for the first time
				SubjectIO.initialize(); // initialize the Subjects' Objects Folders for the first time
				alphabet = new Alphabet(true); // start creating the objects of subjects for first time
				numbers = new Numbers(true);
				animals = new Animals(true);
				colors = new Colors(true);
				shapes = new Shapes(true);
				vegetable = new Vegetable(true);
				fruit = new Fruits(true);
			}
			catch(FirstRunException e){
				JOptionPane.showMessageDialog(null, "Error in Initializing The Program Database For First Run", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		else { // if the file exists that means it's not the first run
			InitializationWin.end = true;
			//retrieve the save objects of the subjects from the last run
			alphabet = (Alphabet)SubjectIO.retrieve(Subjects.Alphabet);
			numbers = (Numbers)SubjectIO.retrieve(Subjects.Numbers);
			animals = (Animals)SubjectIO.retrieve(Subjects.Animals);
			colors = (Colors)SubjectIO.retrieve(Subjects.Colors);
			shapes = (Shapes)SubjectIO.retrieve(Subjects.Shapes);
			vegetable = (Vegetable)SubjectIO.retrieve(Subjects.Vegetable);
			fruit = (Fruits)SubjectIO.retrieve(Subjects.Fruit);
		}
	}
	
	

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * This static methods returns the image value from the content
	 * TreeSet at the specified subject and noun
	 * @param subject
	 * @param noun
	 * @return image
	 */
	public static String getImage(Subjects subject, String noun){
	
		Iterator<Entry<String, ArrayList<String>>> contentIterator; //iterator the the entry Set of the content TreeSet
		switch(subject.toString()){
			case "Alphabet":
				contentIterator = alphabet.getContent().entrySet().iterator(); // get the content entry set iterator
				Entry<String, ArrayList<String>> temp; // create temporary Entry to hold the entries of the content entry set in every loop
				while(contentIterator.hasNext()){
					 temp = contentIterator.next(); //cycle through each entry of the EntrySet of the content 
					 if(noun.equals(temp.getKey())){ // key here is a String and the corresponding value is an ArrayList
						 return temp.getValue().get(1); // the audio file always at index 1 of the value ArrayList
					 }
				}
				break;
			
			case "Numbers":
				contentIterator = numbers.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(1);
					 }
				}
			 break;
			 
			case "Animals":
				contentIterator = animals.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(1);
					 }
				}
			break;
			
			case "Colors":
				contentIterator = colors.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(1);
					 }
				}
			break;
				
			case "Shapes":
				contentIterator = shapes.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(1);
					 }
				}
			break;
					
			case "Vegetable":
				contentIterator = vegetable.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(1);
					 }
				}
			break;
			
			case "Fruit":
				contentIterator = fruit.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(1);
					 }
				}
			break;
		}
		
		return null;
	}
	
	

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * This static methods returns the audio file value from the content
	 * TreeSet at the specified subject and noun
	 * @param subject
	 * @param noun
	 * @return audioFile
	 */
	public static String getSound(Subjects subject, String noun){
		Iterator<Entry<String, ArrayList<String>>> contentIterator;
		switch(subject.toString()){
			case "Alphabet":
				contentIterator = alphabet.getContent().entrySet().iterator();
				Entry<String, ArrayList<String>> temp;
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ // key here is a string and the value corresponding is an ArrayList
						 return temp.getValue().get(0); // the sound always at index 0
					 }
				}
			break;
			
			case "Numbers":
				contentIterator = numbers.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(0);
					 }
				}
			 break;
			 
			case "Animals":
				contentIterator = animals.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(0);
					 }
				}
			break;
			
			case "Colors":
				contentIterator = colors.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(0);
					 }
				}
			break;
				
			case "Shapes":
				contentIterator = shapes.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(0);
					 }
				}
			break;
					
			case "Vegetable":
				contentIterator = vegetable.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(0);
					 }
				}
			break;
			
			case "Fruit":
				contentIterator = fruit.getContent().entrySet().iterator();
				while(contentIterator.hasNext()){
					 temp = contentIterator.next();
					 if(noun.equals(temp.getKey())){ 
						 return temp.getValue().get(0);
					 }
				}
			break;
		}
		
		return null;
	}
	
	

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * This static methods updates the database of the program when 
	 * the program shutdown
	 */
	public static void updateDatabase(){
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		    public void run() {
		    	// save all the subjects in the data folder
				SubjectIO.save(Subjects.Alphabet, alphabet);
				SubjectIO.save(Subjects.Numbers, numbers);
		    	SubjectIO.save(Subjects.Animals, animals);
		    	SubjectIO.save(Subjects.Colors, colors);
		    	SubjectIO.save(Subjects.Shapes, shapes);
		    	SubjectIO.save(Subjects.Vegetable, vegetable);
		    	SubjectIO.save(Subjects.Fruit, fruit);
		    	
		    	}
		}));
	}
	

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/* Getters for the Fields */
	
	public static Alphabet getAlphabet() {
		return alphabet;
	}




	public static Numbers getNumbers() {
		return numbers;
	}



	public static Animals getAnimals() {
		return animals;
	}



	public static Colors getColors() {
		return colors;
	}



	public static Shapes getShapes() {
		return shapes;
	}



	public static Vegetable getVegetable() {
		return vegetable;
	}



	public static Fruits getFruit() {
		return fruit;
	}



	public static File getSettings() {
		return settings;
	}
	
	


}
