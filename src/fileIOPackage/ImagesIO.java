package fileIOPackage;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import javax.swing.JOptionPane;

import resourcesPackage.Resource;
import resourcesPackage.Subjects;



/**
 * This Class contains static methods to
 * manipulate the images files (add and delete)
 * that are browsed by the user
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class ImagesIO {
	
	private static String imageDir; // the image file directory
	
	
	
	/**
	 * Static method that transfers an image from 
	 * a source which the user chose via a FileDialog to specific
	 * directory according to the subject passed as a parameter
	 * @param subject
	 * @return boolean
	 */
	public static boolean addImage(Subjects subject){
			// create the File Dialog
			FileDialog loadDialog = new FileDialog(new Frame(), "Load", FileDialog.LOAD );
			loadDialog.setFile("*.jpg; *.png"); // set the filter
			loadDialog.setTitle("Add Image");
			loadDialog.setVisible(true);
			String fileName = loadDialog.getFile();
			if (fileName != null){ // if the user did not press cancel
					FileChannel source = null;
					FileChannel destination = null;
					try {
						source = new FileInputStream(new File(loadDialog.getDirectory()+fileName)).getChannel();
						destination = new FileOutputStream(new File(generateImageName(subject))).getChannel();
						destination.transferFrom(source, 0, source.size());
						
					} 
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Failed To Add The Image", "Error", JOptionPane.ERROR_MESSAGE);
						
					}
					try {source.close(); destination.close();} 
					catch (IOException e) {e.printStackTrace();}
					
					loadDialog.dispose();
						
					return true;
			}
			
			loadDialog.dispose();
			return false;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * delete the last image file from its directory 
	 */
	public static void deleteImage(){
		new File(imageDir).delete();
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	/**
	 * create a folder (if not exists) for the added image in specific directory
	 * according to the subject passed as a parameter
	 * it returns the full path of the folder
	 * @param subject
	 * @return imagesFolder
	 */
	private static String folder(Subjects subject){
		
		final String imagesFolder =  (subject.toString().equalsIgnoreCase("Alphabet"))? Resource.getAlphabetimagesfolder()+"AddedImages":
									 (subject.toString().equalsIgnoreCase("Numbers"))? Resource.getNumbersimagesfolder()+"AddedImages":
									 (subject.toString().equalsIgnoreCase("Animals"))? Resource.getAnimalsimagesfolder()+"AddedImages":
									 (subject.toString().equalsIgnoreCase("Colors"))? Resource.getColorsimagesfolder()+"AddedImages":
									 (subject.toString().equalsIgnoreCase("Shapes"))? Resource.getShapesimagesfolder()+"AddedImages":
									 (subject.toString().equalsIgnoreCase("Vegetable"))? Resource.getVegetableimagesfolder()+"AddedImages":
									 (subject.toString().equalsIgnoreCase("Fruit"))? Resource.getFruitimagesfolder()+"AddedImages":null;
		if (!new File(imagesFolder).exists()){
    			// create a folder to contain all images from now then
    			new File(imagesFolder).mkdir();
		}
		return imagesFolder;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * Generates names for the added images
	 * @param subject
	 * @return imageDir
	 */
	private static String generateImageName(Subjects subject){
	
    	File file = new File(folder(subject), "generatedImageName.txt");
    	PrintWriter pw = null;
    	Scanner scanner = null;
    	int newNumber = 0;
   
    	if (!file.exists()){ // if it's the first time
    		try {
				pw = new PrintWriter(file);
				pw.print("0"); // start first name with Zero
			} catch (FileNotFoundException e) {e.printStackTrace();}	
    	}
    	
    	else { // if it's not the first time
    		try {
				scanner = new Scanner(file); 
				String lastNumber = scanner.next(); // read the last name
				newNumber = Integer.parseInt(lastNumber); // parse the string to number
				newNumber++; // increment the number
				pw = new PrintWriter(file);
				pw.print(newNumber); // write the new name
				pw.flush();
				scanner.close();
				  
			} catch (FileNotFoundException e) {e.printStackTrace();}
    	}
    	
    	pw.close();
    	
    	imageDir = folder(subject)+File.separator+newNumber+".jpg"; // set the full path and the generated name
    	return imageDir; // return the image directory
    	
    }

	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * A getter method for the imageDir
	 * @return imageDir
	 */
	public static String getImageDir() {
		return imageDir;
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * A setter method for the imageDir
	 * @param imageDir
	 */
	public static void setImageDir(String imageDir) {
		ImagesIO.imageDir = imageDir;
	}
	
	
	
}




