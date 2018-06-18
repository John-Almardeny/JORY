package resourcesPackage;

import guiPackage.InitializationWin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javax.swing.JOptionPane;

import coursePackage.Course;



/**
 * This Class contains the Database 
 * in which the program will be initialized upon 
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class Resource {
	
	// the initial content of the subjects
	private static ArrayList<ArrayList<String>> alphabet;
	private static ArrayList<ArrayList<String>> numbers;
	private static ArrayList<ArrayList<String>> animals;
	private static ArrayList<ArrayList<String>> colors;
	private static ArrayList<ArrayList<String>> shapes;
	private static ArrayList<ArrayList<String>> vegetable;
	private static ArrayList<ArrayList<String>> fruit;

	// the folders and directories of the program subjects database
	private final static String alphabetPronounciationFolder = Course.programFolder + File.separator+ "Database" + File.separator + "Audio" + File.separator + "alphabetPronounciation" + File.separator;
	private final static String alphabetImagesFolder = Course.programFolder + File.separator+ "Database" + File.separator +  "Images" + File.separator + "alphabetImages" + File.separator;
	private final static String numbersPronounciationFolder = Course.programFolder + File.separator+ "Database" + File.separator +  "Audio" + File.separator + "numbersPronounciation" + File.separator;
	private final static String numbersImagesFolder = Course.programFolder + File.separator+ "Database" + File.separator +  "Images" + File.separator + "numbersImages" + File.separator;
	private final static String animalsPronounciationFolder = Course.programFolder + File.separator+ "Database" + File.separator +  "Audio" + File.separator + "animalsPronounciation" + File.separator;
	private final static String animalsImagesFolder = Course.programFolder + File.separator+ "Database" + File.separator +  "Images" + File.separator + "animalsImages" + File.separator;
	private final static String colorsPronounciationFolder = Course.programFolder + File.separator+ "Database" + File.separator +   "Audio" + File.separator + "colorsPronounciation" + File.separator;
	private final static String colorsImagesFolder = Course.programFolder + File.separator+ "Database" + File.separator +  "Images" + File.separator + "colorsImages" + File.separator;
	private final static String shapesPronounciationFolder = Course.programFolder + File.separator+ "Database" + File.separator +  "Audio" + File.separator + "shapesPronounciation" + File.separator;
	private final static String shapesImagesFolder = Course.programFolder + File.separator+ "Database" + File.separator +  "Images" + File.separator + "shapesImages" + File.separator;
	private final static String vegetablePronounciationFolder = Course.programFolder + File.separator+ "Database" + File.separator +   "Audio" + File.separator + "vegetablePronounciation" + File.separator;
	private final static String vegetableImagesFolder = Course.programFolder + File.separator+ "Database" + File.separator +  "Images" + File.separator + "vegetableImages" + File.separator;
	private final static String fruitPronounciationFolder = Course.programFolder + File.separator+ "Database" + File.separator +  "Audio" + File.separator + "fruitPronounciation" + File.separator;
	private final static String fruitImagesFolder = Course.programFolder + File.separator+ "Database" + File.separator +  "Images" + File.separator + "fruitImages" + File.separator;


	/**
	 * A static method that initializes the content database
	 * of the program
	 */
	public static void initialize(){
		alphabet = new ArrayList<ArrayList<String>>(alphabetDatabase());
		numbers = new ArrayList<ArrayList<String>>(numbersDatabase());
		animals = new ArrayList<ArrayList<String>>(animalsDatabase());
		colors = new ArrayList<ArrayList<String>>(colorsDatabase());
		shapes = new ArrayList<ArrayList<String>>(shapesDatabase());
		vegetable = new ArrayList<ArrayList<String>>(vegetableDatabase());
		fruit = new ArrayList<ArrayList<String>>(fruitDatabase());
	   }


	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * A private method that returns an ArrayList of ArrayLists
	 * of the Alphabet Content (Pronunciations and Nouns)
	 * @return container
	 */
	private static ArrayList<ArrayList<String>> alphabetDatabase(){
		List<String> pronounciation = Arrays.asList(new String[]{ // list of pronunciations strings 
				alphabetPronounciationFolder+"a.mp3",alphabetPronounciationFolder+"b.mp3",alphabetPronounciationFolder+"c.mp3",alphabetPronounciationFolder+"d.mp3",
				alphabetPronounciationFolder+"e.mp3",alphabetPronounciationFolder+"f.mp3",alphabetPronounciationFolder+"g.mp3",alphabetPronounciationFolder+"h.mp3",
				alphabetPronounciationFolder+"i.mp3",alphabetPronounciationFolder+"j.mp3",alphabetPronounciationFolder+"k.mp3",alphabetPronounciationFolder+"l.mp3",
				alphabetPronounciationFolder+"m.mp3",alphabetPronounciationFolder+"n.mp3",alphabetPronounciationFolder+"o.mp3",alphabetPronounciationFolder+"p.mp3",
				alphabetPronounciationFolder+"q.mp3",alphabetPronounciationFolder+"r.mp3",alphabetPronounciationFolder+"s.mp3",alphabetPronounciationFolder+"t.mp3",
				alphabetPronounciationFolder+"u.mp3",alphabetPronounciationFolder+"v.mp3",alphabetPronounciationFolder+"w.mp3",alphabetPronounciationFolder+"x.mp3",
				alphabetPronounciationFolder+"y.mp3",alphabetPronounciationFolder+"z.mp3"});
		
		List<String>images = Arrays.asList(new String[]{ // list of images strings
				alphabetImagesFolder+"a.jpg",alphabetImagesFolder+"b.jpg",alphabetImagesFolder+"c.jpg",alphabetImagesFolder+"d.jpg",
				alphabetImagesFolder+"e.jpg",alphabetImagesFolder+"f.jpg",alphabetImagesFolder+"g.jpg",alphabetImagesFolder+"h.jpg",
				alphabetImagesFolder+"i.jpg",alphabetImagesFolder+"j.jpg",alphabetImagesFolder+"k.jpg",alphabetImagesFolder+"l.jpg",
				alphabetImagesFolder+"m.jpg",alphabetImagesFolder+"n.jpg",alphabetImagesFolder+"o.jpg",alphabetImagesFolder+"p.jpg",
				alphabetImagesFolder+"q.jpg",alphabetImagesFolder+"r.jpg",alphabetImagesFolder+"s.jpg",alphabetImagesFolder+"t.jpg",
				alphabetImagesFolder+"u.jpg",alphabetImagesFolder+"v.jpg",alphabetImagesFolder+"w.jpg",alphabetImagesFolder+"x.jpg",
				alphabetImagesFolder+"y.jpg",alphabetImagesFolder+"z.jpg"});
		
		Iterator<String> pronounciationIterator = pronounciation.iterator(); // iterator for the pronunciation list
		Iterator<String> imagesIterator = images.iterator(); // iterator for the images list
		ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>(); // container to hold ArrayLists of pairs of pronunciation-image
		
		while (pronounciationIterator.hasNext()&& imagesIterator.hasNext()){
				ArrayList<String> temp = new ArrayList<String>(); // temporary ArrayList to hold a pair of pronunciation-image
				temp.add(0,pronounciationIterator.next()); // pronunciation always at index 0
				temp.add(1,imagesIterator.next()); // image always at index 1
				container.add(temp); // add the temp ArrayList to the container
		}
		
		return container; // at the end return the container
}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	/**
	 * A private method that returns an ArrayList of ArrayLists
	 * of the Numbers Content (Pronunciations and Nouns)
	 * @return container
	 */
	private static ArrayList<ArrayList<String>> numbersDatabase(){
		List<String> pronounciation = Arrays.asList(new String[]{
				numbersPronounciationFolder+"0.mp3",numbersPronounciationFolder+"1.mp3",numbersPronounciationFolder+"2.mp3",
				numbersPronounciationFolder+"3.mp3",numbersPronounciationFolder+"4.mp3",numbersPronounciationFolder+"5.mp3",
				numbersPronounciationFolder+"6.mp3",numbersPronounciationFolder+"7.mp3",numbersPronounciationFolder+"8.mp3",
				numbersPronounciationFolder+"9.mp3",numbersPronounciationFolder+"10.mp3"});
		
		List<String> images = Arrays.asList(new String[]{
				numbersImagesFolder+"0.jpg",numbersImagesFolder+"1.jpg",numbersImagesFolder+"2.jpg",numbersImagesFolder+"3.jpg",
				numbersImagesFolder+"4.jpg",numbersImagesFolder+"5.jpg",numbersImagesFolder+"6.jpg",numbersImagesFolder+"7.jpg",
				numbersImagesFolder+"8.jpg",numbersImagesFolder+"9.jpg",numbersImagesFolder+"10.jpg"});
		
		Iterator<String> pronounciationIterator = pronounciation.iterator();
		Iterator<String> imagesIterator = images.iterator();
		
		ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>();
		
		while (pronounciationIterator.hasNext()&& imagesIterator.hasNext()){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(0,pronounciationIterator.next());
			temp.add(1,imagesIterator.next());
			container.add(new ArrayList<String>(temp));
		}
		
		return container;
	}
	

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * A private method that returns an ArrayList of ArrayLists
	 * of the Animals Content(Pronunciations and Nouns)
	 * @return container
	 */
	private static ArrayList<ArrayList<String>> animalsDatabase(){
		List<String> pronounciation = Arrays.asList(new String[]{
				animalsPronounciationFolder+"Cat.mp3",animalsPronounciationFolder+"Dog.mp3",animalsPronounciationFolder+"Rabbit.mp3",
				animalsPronounciationFolder+"Horse.mp3",animalsPronounciationFolder+"Donkey.mp3",animalsPronounciationFolder+"Elephant.mp3",
				animalsPronounciationFolder+"Lion.mp3",animalsPronounciationFolder+"Cow.mp3",animalsPronounciationFolder+"Duck.mp3",
				animalsPronounciationFolder+"Hen.mp3",animalsPronounciationFolder+"Fish.mp3",animalsPronounciationFolder+"Sheep.mp3",
				animalsPronounciationFolder+"Bear.mp3",animalsPronounciationFolder+"Tiger.mp3",animalsPronounciationFolder+"Monkey.mp3"});
		
		List<String> images = Arrays.asList(new String[]{
				animalsImagesFolder+"Cat.jpg",animalsImagesFolder+"Dog.jpg",animalsImagesFolder+"Rabbit.jpg",animalsImagesFolder+"Horse.jpg",
				animalsImagesFolder+"Donkey.jpg",animalsImagesFolder+"Elephant.jpg",animalsImagesFolder+"Lion.jpg",animalsImagesFolder+"Cow.jpg",
				animalsImagesFolder+"Duck.jpg",animalsImagesFolder+"Hen.jpg",animalsImagesFolder+"Fish.jpg",animalsImagesFolder+"Sheep.jpg",
				animalsImagesFolder+"Bear.jpg",animalsImagesFolder+"Tiger.jpg",animalsImagesFolder+"Monkey.jpg"});
		
		Iterator<String> pronounciationIterator = pronounciation.iterator();
		Iterator<String> imagesIterator = images.iterator();
		
		ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>();
		
		while (pronounciationIterator.hasNext()&& imagesIterator.hasNext()){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(0,pronounciationIterator.next());
			temp.add(1,imagesIterator.next());
			container.add(new ArrayList<String>(temp));
		}
		
		
		return container;
	}
		
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
	/**
	 * A private method that returns an ArrayList of ArrayLists
	 * of the Colors Content(Pronunciations and Nouns)
	 * @return container
	 */
	private static ArrayList<ArrayList<String>> colorsDatabase(){
		List<String> pronounciation = Arrays.asList(new String[]{
				colorsPronounciationFolder+"White.mp3",colorsPronounciationFolder+"Black.mp3",colorsPronounciationFolder+"Red.mp3",
				colorsPronounciationFolder+"Green.mp3",colorsPronounciationFolder+"Blue.mp3",colorsPronounciationFolder+"Yellow.mp3",
				colorsPronounciationFolder+"Brown.mp3",colorsPronounciationFolder+"Pink.mp3",colorsPronounciationFolder+"Gray.mp3",
				colorsPronounciationFolder+"Orange.mp3"});
		
		List<String> images = Arrays.asList(new String[]{
				colorsImagesFolder+"White.jpg",colorsImagesFolder+"Black.jpg",colorsImagesFolder+"Red.jpg",
				colorsImagesFolder+"Green.jpg",colorsImagesFolder+"Blue.jpg",colorsImagesFolder+"Yellow.jpg",
				colorsImagesFolder+"Brown.jpg",colorsImagesFolder+"Pink.jpg",colorsImagesFolder+"Gray.jpg",
				colorsImagesFolder+"Orange.jpg"});
		
		Iterator<String> pronounciationIterator = pronounciation.iterator();
		Iterator<String> imagesIterator = images.iterator();
		
		ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>();
		
		while (pronounciationIterator.hasNext()&& imagesIterator.hasNext()){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(0,pronounciationIterator.next());
			temp.add(1,imagesIterator.next());
			container.add(new ArrayList<String>(temp));
		}
		
		
		return container;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * A private method that returns an ArrayList of ArrayLists
	 * of the Shapes Content(Pronunciations and Nouns)
	 * @return container
	 */
	private static ArrayList<ArrayList<String>> shapesDatabase(){
		List<String> pronounciation = Arrays.asList(new String[]{
				shapesPronounciationFolder+"Square.mp3",shapesPronounciationFolder+"Triangle.mp3",
				shapesPronounciationFolder+"Rectangle.mp3",shapesPronounciationFolder+"Circle.mp3",
				shapesPronounciationFolder+"Line.mp3",shapesPronounciationFolder+"Star.mp3"});
		
		List<String> images = Arrays.asList(new String[]{
				shapesImagesFolder+"Square.jpg",shapesImagesFolder+"Triangle.jpg",
				shapesImagesFolder+"Rectangle.jpg",shapesImagesFolder+"Circle.jpg",
				shapesImagesFolder+"Line.jpg",shapesImagesFolder+"Star.jpg"});
		
		Iterator<String> pronounciationIterator = pronounciation.iterator();
		Iterator<String> imagesIterator = images.iterator();
		
		ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>();
		
		while (pronounciationIterator.hasNext()&& imagesIterator.hasNext()){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(0,pronounciationIterator.next());
			temp.add(1,imagesIterator.next());
			container.add(new ArrayList<String>(temp));
		}
		
		return container;
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * A private method that returns an ArrayList of ArrayLists
	 * of the Vegetable Content(Pronunciations and Nouns)
	 * @return container
	 */
	private static ArrayList<ArrayList<String>> vegetableDatabase(){
		List<String> pronounciation = Arrays.asList(new String[]{
				vegetablePronounciationFolder+"Tomato.mp3",vegetablePronounciationFolder+"Potato.mp3",
				vegetablePronounciationFolder+"Carrot.mp3",vegetablePronounciationFolder+"Cucumber.mp3",
				vegetablePronounciationFolder+"Onion.mp3",vegetablePronounciationFolder+"Mushroom.mp3",
				vegetablePronounciationFolder+"Lettuce.mp3",vegetablePronounciationFolder+"Pea.mp3",
				vegetablePronounciationFolder+"Bean.mp3",vegetablePronounciationFolder+"Olive.mp3",
				vegetablePronounciationFolder+"Aubergine.mp3",vegetablePronounciationFolder+"Lemon.mp3",
				vegetablePronounciationFolder+"Corn.mp3"});
		
		List<String> images = Arrays.asList(new String[]{
				vegetableImagesFolder+"Tomato.jpg",vegetableImagesFolder+"Potato.jpg",vegetableImagesFolder+"Carrot.jpg",
				vegetableImagesFolder+"Cucumber.jpg",vegetableImagesFolder+"Onion.jpg",vegetableImagesFolder+"Mushroom.jpg",
				vegetableImagesFolder+"Lettuce.jpg",vegetableImagesFolder+"Pea.jpg",vegetableImagesFolder+"Bean.jpg",
				vegetableImagesFolder+"Olive.jpg",vegetableImagesFolder+"Aubergine.jpg",vegetableImagesFolder+"Lemon.jpg",
				vegetableImagesFolder+"Corn.jpg"});
		
		Iterator<String> pronounciationIterator = pronounciation.iterator();
		Iterator<String> imagesIterator = images.iterator();
		
		ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>();
		
		while (pronounciationIterator.hasNext()&& imagesIterator.hasNext()){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(0,pronounciationIterator.next());
			temp.add(1,imagesIterator.next());
			container.add(new ArrayList<String>(temp));
		}
		
		
		return container;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	/**
	 * A private method that returns an ArrayList of ArrayLists
	 * of the Fruit Content(Pronunciations and Nouns)
	 * @return container
	 */
	private static ArrayList<ArrayList<String>> fruitDatabase(){
		List<String> pronounciation = Arrays.asList(new String[]{
				fruitPronounciationFolder+"Apple.mp3",fruitPronounciationFolder+"Banana.mp3",fruitPronounciationFolder+"Orange.mp3",
				fruitPronounciationFolder+"Grape.mp3",fruitPronounciationFolder+"Pineapple.mp3",
				fruitPronounciationFolder+"Pear.mp3",fruitPronounciationFolder+"Watermelon.mp3",
				fruitPronounciationFolder+"Strawberry.mp3",fruitPronounciationFolder+"Kiwi.mp3",
				fruitPronounciationFolder+"Fig.mp3",fruitPronounciationFolder+"Melon.mp3",
				fruitPronounciationFolder+"Apricot.mp3",fruitPronounciationFolder+"Mango.mp3",
				fruitPronounciationFolder+"Plum.mp3", fruitPronounciationFolder+"Cherry.mp3",fruitPronounciationFolder+"Peach.mp3"});
		
		List<String> images = Arrays.asList(new String[]{
				fruitImagesFolder+"Apple.jpg",fruitImagesFolder+"Banana.jpg",fruitImagesFolder+"Orange.jpg",
				fruitImagesFolder+"Grape.jpg",fruitImagesFolder+"Pineapple.jpg",fruitImagesFolder+"Pear.jpg",
				fruitImagesFolder+"Watermelon.jpg",fruitImagesFolder+"Strawberry.jpg",fruitImagesFolder+"Kiwi.jpg",
				fruitImagesFolder+"Fig.jpg",fruitImagesFolder+"Melon.jpg",fruitImagesFolder+"Apricot.jpg",
				fruitImagesFolder+"Mango.jpg" , fruitImagesFolder+"Plum.jpg", fruitImagesFolder+"Cherry.jpg",fruitImagesFolder+"Peach.jpg"});
		
		Iterator<String> pronounciationIterator = pronounciation.iterator();
		Iterator<String> imagesIterator = images.iterator();
		
		ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>();
		
		while (pronounciationIterator.hasNext()&& imagesIterator.hasNext()){
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(0,pronounciationIterator.next());
			temp.add(1,imagesIterator.next());
			container.add(new ArrayList<String>(temp));
		}
		
		
		return container;
	}
	
	

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	

	/*Getters & Setters*/
	
	public static String getFruitpronounciationfolder() {
		return fruitPronounciationFolder;
	}
	
	
	
	public static String getFruitimagesfolder() {
		return fruitImagesFolder;
	}
	
	public static ArrayList<ArrayList<String>> getAlphabet() {
		return alphabet;
	}
	
	
	
	public static void setAlphabet(ArrayList<ArrayList<String>> alphabet) {
		Resource.alphabet = alphabet;
	}
	
	
	
	public static ArrayList<ArrayList<String>> getNumbers() {
		return numbers;
	}
	
	
	
	public static void setNumbers(ArrayList<ArrayList<String>> numbers) {
		Resource.numbers = numbers;
	}
	

	public static ArrayList<ArrayList<String>> getAnimals() {
		return animals;
	}
	
	
	
	public static void setAnimals(ArrayList<ArrayList<String>> animals) {
		Resource.animals = animals;
	}
	
	
	
	public static ArrayList<ArrayList<String>> getColors() {
		return colors;
	}
	
	
	public static void setColors(ArrayList<ArrayList<String>> colors) {
		Resource.colors = colors;
	}
	
	
	
	public static ArrayList<ArrayList<String>> getShapes() {
		return shapes;
	}
	

	public static void setShapes(ArrayList<ArrayList<String>> shapes) {
		Resource.shapes = shapes;
	}
	
	
	
	public static ArrayList<ArrayList<String>> getVegetable() {
		return vegetable;
	}
	
	

	public static void setVegetable(ArrayList<ArrayList<String>> vegetable) {
		Resource.vegetable = vegetable;
	}
	
	
	
	public static String getAlphabetpronounciationfolder() {
		return alphabetPronounciationFolder;
	}
	
	
	
	public static String getAlphabetimagesfolder() {
		return alphabetImagesFolder;
	}
	
	
	
	public static String getNumberspronounciationfolder() {
		return numbersPronounciationFolder;
	}
	
	
	
	public static String getNumbersimagesfolder() {
		return numbersImagesFolder;
	}
	
	
	
	public static String getAnimalspronounciationfolder() {
		return animalsPronounciationFolder;
	}
	
	
	
	public static String getAnimalsimagesfolder() {
		return animalsImagesFolder;
	}
	
	
	
	public static String getColorspronounciationfolder() {
		return colorsPronounciationFolder;
	}
	
	
	
	public static String getColorsimagesfolder() {
		return colorsImagesFolder;
	}
	

	
	public static String getShapespronounciationfolder() {
		return shapesPronounciationFolder;
	}
	
	
	
	public static String getShapesimagesfolder() {
		return shapesImagesFolder;
	}
	

	public static String getVegetablepronounciationfolder() {
		return vegetablePronounciationFolder;
	}
	
	
	
	public static String getVegetableimagesfolder() {
		return vegetableImagesFolder;
	}
	
	
	
	public static ArrayList<ArrayList<String>> getFruit() {
		return fruit;
	}
	
	
	
	public static void setFruit(ArrayList<ArrayList<String>> fruit) {
		Resource.fruit = fruit;
	}
	
	
	
	public static void extractDatabase(){
		int i =0;
		try {
			@SuppressWarnings("resource")
			JarFile jar = new JarFile(System.getProperty("user.dir") + File.separator + "Jory.jar"); // create a jar object of the jar file in the specific path
			Enumeration<JarEntry> jarEntries = jar.entries(); // enumerator to traverse the jar entries
			while (jarEntries.hasMoreElements()) { // while there is more entries 
			    JarEntry jarEntry = (JarEntry) jarEntries.nextElement(); // hold the entry
			    File file = new File(System.getProperty("user.home")+File.separator+"Jory" + File.separator + jarEntry.getName()); //create a file in the destination directory with the same name
			    if (jarEntry.isDirectory() && file.getAbsolutePath().contains("Database")) { // if it's the database folder or one of its subfolders, create it
			    	file.mkdir();
			    }
			    if (file.getAbsolutePath().contains("Database") &&!jarEntry.isDirectory()){  // now if it's a file (not a folder) inside the database folder or subfolders
			    	InputStream inputStream = jar.getInputStream(jarEntry); // get the input stream of the entry
					FileOutputStream fileOutputStream = new FileOutputStream(file); // specify the output stream destination
					while (inputStream.available() > 0) {  //the number of bytes that can be read from this input stream
							fileOutputStream.write(inputStream.read()); // read from input stream and and write in the output stream
					}
					fileOutputStream.close();
					inputStream.close();
					i++;
					InitializationWin.update(i,file.getName() );
			    }
			}
		}
		    catch (Exception e){JOptionPane.showMessageDialog(null, "Failed to read the database, You may have changed Jory Program Name", "Error", JOptionPane.ERROR_MESSAGE);}
			InitializationWin.end = true;
			InitializationWin.frame.dispose();
		}

}


