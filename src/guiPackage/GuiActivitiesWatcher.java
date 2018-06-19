package guiPackage;

import resourcesPackage.Subjects;

/**
 * This class contains reference to the activities
 * performed in the GUIs, so it watches the GUIs
 * and keep some unique records of what last activity happened
 * by the user and which are shared between many of the GUI components
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class GuiActivitiesWatcher {

	public static boolean loop = false; // reference for loopCheckBox
	public static boolean firstRecording = true; // if it's first time of recording 
	public static boolean firstMP3Browse = true; // if it's the first time of MP3 Browsing
	public static boolean firstImageBrowse = true; // if it's the first time of Image Browsing
	public static boolean stop = false; // if the stop button is pressed
	public static String flag; // a flag to indicate what is the current subject
	public static int counter = 0; // counter to the list elements
	public static boolean mp3; // reference for the last sound type chosen by user in the Add/Edit windows
	public static boolean voice; // reference for the last sound type chosen by user in the Add/Edit windows
	public static boolean playAll = false;
	public static String indexToDelete = null;
	public static boolean delete = false;

	
	/**
	 * resets all fields values to the default
	 * and change the flag to the current subject
	 * @param subject
	 */
	public static void reset(Subjects subject){
		loop = stop = mp3 = voice = playAll = false;
		firstRecording = true;
		firstMP3Browse = firstImageBrowse =true;
		counter = 0;
		flag =  (subject.toString().equalsIgnoreCase("Alphabet"))? "Alphabet":
				(subject.toString().equalsIgnoreCase("Numbers"))? "Numbers":
				(subject.toString().equalsIgnoreCase("Animals"))? "Animals":
				(subject.toString().equalsIgnoreCase("Colors"))? "Colors":
				(subject.toString().equalsIgnoreCase("Shapes"))? "Shapes":
				(subject.toString().equalsIgnoreCase("Vegetable"))? "Vegetable":
				(subject.toString().equalsIgnoreCase("Fruit"))? "Fruit":null;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * increments the counter
	 */
	public static void incrementCounter(){
		counter++;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * decrement the counter
	 */
	public static void decrementCounter(){
		counter--;
	}


}
