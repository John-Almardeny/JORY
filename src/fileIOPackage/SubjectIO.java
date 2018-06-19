package fileIOPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

import coursePackage.Course;


import resourcesPackage.Subjects;
import subjectsPackage.Subject;


/**
 * This class retrieves the subjects' objects 
 * in specific directories with every run of the program and
 * saves those objects when the program shuts off
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class SubjectIO implements Serializable{

	private static final long serialVersionUID = 1L;
	//the directories of the objects
	private final static String alphabetFolder = Course.programFolder + File.separator + "Data" + File.separator + "Alphabet"+File.separator;
	private final static String numbersFolder = Course.programFolder + File.separator + "Data" + File.separator + "Numbers"+File.separator;
	private final static String animalsFolder = Course.programFolder + File.separator + "Data" + File.separator + "Animals"+File.separator;
	private final static String colorsFolder = Course.programFolder + File.separator + "Data" + File.separator + "Colors"+File.separator;
	private final static String shapesFolder = Course.programFolder + File.separator +"Data" + File.separator + "Shapes"+File.separator;
	private final static String vegetableFolder = Course.programFolder + File.separator + "Data" + File.separator + "Vegetable"+File.separator;
	private final static String fruitFolder = Course.programFolder + File.separator + "Data" + File.separator + "Fruit"+File.separator;
	
	
	
	
	/**
	 * This methods invoked only in the very first run of this program
	 * it creates the necessary directories for the subjects' objects
	 */
	public static void initialize(){
		try{
			new File(alphabetFolder).mkdirs();
			new File(numbersFolder).mkdir();
			new File(animalsFolder).mkdir();
			new File(colorsFolder).mkdir();
			new File(shapesFolder).mkdir();
			new File(vegetableFolder).mkdir();
			new File(fruitFolder).mkdir();
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error in creating the database folders", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This method saves the Subject's object in its directory 
	 * @param subject
	 * @param object
	 */
	public static void save(Subjects subject, Subject object){
		//set the directory according to the subject chosen
		String dir = (subject.equals(Subjects.Alphabet))?alphabetFolder+"alphabet.dat":
					 (subject.equals(Subjects.Numbers))?numbersFolder+"numbers.dat":
					 (subject.equals(Subjects.Animals))?animalsFolder+"animals.dat":
					 (subject.equals(Subjects.Colors))?colorsFolder+"colors.dat":
					 (subject.equals(Subjects.Shapes))?shapesFolder+"shapes.dat":
					 (subject.equals(Subjects.Vegetable))?vegetableFolder+"vegetable.dat":
					 (subject.equals(Subjects.Fruit))?fruitFolder+"fruit.dat":null;
		
		
		try{ // it tries to overwrite the old one if any or saves for the first time
			new ObjectOutputStream(new FileOutputStream(new File(dir))).writeObject(object);
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error in saving the data of " + subject, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This method retrieves the saved object of the specified subject
	 * it returns the object data file or not if failed
	 * @param subject
	 * @return object
	 */
	public static Object retrieve(Subjects subject){
		String dir = (subject.equals(Subjects.Alphabet))?alphabetFolder+"alphabet.dat":
					 (subject.equals(Subjects.Numbers))?numbersFolder+"numbers.dat":
				     (subject.equals(Subjects.Animals))?animalsFolder+"animals.dat":
					 (subject.equals(Subjects.Colors))?colorsFolder+"colors.dat":
					 (subject.equals(Subjects.Shapes))?shapesFolder+"shapes.dat":
					 (subject.equals(Subjects.Vegetable))?vegetableFolder+"vegetable.dat":
					 (subject.equals(Subjects.Fruit))?fruitFolder+"fruit.dat":null;
	
		try{
			return new ObjectInputStream(new FileInputStream(new File(dir))).readObject();
		}
		catch (Exception e){
				JOptionPane.showMessageDialog(null, "Error in loading the data of the " + subject, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return null;
		
	}
	
}
