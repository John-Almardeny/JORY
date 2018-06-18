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
 * This class handles the MP3 files that are browsed 
 * by the user in the AddWindow & EditWindow
 * particularly when the user wants to edit old / add new item to the subject 
 * @author Yahya Almardeny
 * @version 03/12/2016
 */
public class MP3IO {

	private static String mp3Dir; // file directory for manipulating the real-stored file later from other classes on demand
		 

	
	/**
	 * This method to add a new mp3
	 * to the specified subject folder
	 * if succeed it returns true else returns false 
	 * @param subject
	 * @return boolean
	 */
	public static boolean addMP3(Subjects subject){	
		// creating the File Dialog 
		FileDialog loadDialog = new FileDialog(new Frame(), "Load", FileDialog.LOAD );
		loadDialog.setFile("*.mp3");
		loadDialog.setTitle("Add MP3");
		loadDialog.setVisible(true);
		String fileName = loadDialog.getFile();
			if (fileName != null){ // if the user did not press "Cancel" button
				FileChannel source = null;  // create a byte channel source for the mp3 file 
				FileChannel destination = null; // create a byte channel destination for the file
				try {
					source = new FileInputStream(new File(loadDialog.getDirectory()+fileName)).getChannel(); // the source is where the user select the file from in the FileDialog
					destination = new FileOutputStream(new File(generateMP3Name(subject))).getChannel(); // the destination is always fixed to every subject, that will be determined internally via calling generateMP3Name() method  
					destination.transferFrom(source, 0, source.size()); // simply transfer the mp3 file from the source to the destination
					} 
					catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "Failed To Add The MP3 File", "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Failed To Add The MP3 File", "Error", JOptionPane.ERROR_MESSAGE);
					}		
					finally {
						try {
							source.close();
							destination.close();
						} 
						catch (IOException e) {
								e.printStackTrace();
						}
					}
				 loadDialog.dispose();
				 return true;	
		   }
		   else{loadDialog.dispose(); return false;}
		
	}
			
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * A static method to delete 
	 * the MP3 from the directory
	 */
	public static void deleteMP3(){
		new File(mp3Dir).delete();
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * A getter method of the last browsed mp3Dir
	 * @return mp3Dir
	 */
	public static String getMp3Dir() {
		return mp3Dir;
	}

	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * A setter method to set the mp3Dir
	 * @param mp3Dir
	 */
	public static void setMp3Dir(String mp3Dir) {
		MP3IO.mp3Dir = mp3Dir;	
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This method creates (if not exist) and returns the mp3Folder of the subject
	 * that is specified in the parameter
	 * @param subject
	 * @return mp3Folder
	 */
	private static String folder(Subjects subject){
		
		final String mp3Folder   =   (subject.toString().equalsIgnoreCase("Alphabet"))? Resource.getAlphabetpronounciationfolder()+"AddedMP3":
									 (subject.toString().equalsIgnoreCase("Numbers"))? Resource.getNumberspronounciationfolder()+"AddedMP3":
									 (subject.toString().equalsIgnoreCase("Animals"))? Resource.getAnimalspronounciationfolder()+"AddedMP3":
									 (subject.toString().equalsIgnoreCase("Colors"))? Resource.getColorspronounciationfolder()+"AddedMP3":
									 (subject.toString().equalsIgnoreCase("Shapes"))? Resource.getShapespronounciationfolder()+"AddedMP3":
									 (subject.toString().equalsIgnoreCase("Vegetable"))? Resource.getVegetablepronounciationfolder()+"AddedMP3":
									 (subject.toString().equalsIgnoreCase("Fruit"))? Resource.getFruitpronounciationfolder()+"AddedMP3":null;
		if (!new File(mp3Folder).exists()){ // check if it's the first time
    			new File(mp3Folder).mkdir();// then create a folder to contain all images from now then
		}
		return mp3Folder;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * This methods generates the names for the new-added MP3 Files
	 * of the specified subject and returns the 
	 * mp3 File Directory with its new generated name
	 * @param subject
	 * @return mp3Dir
	 */
	private static String generateMP3Name(Subjects subject){
	
    	File file = new File(folder(subject), "generatedMp3Name.txt"); // a text file to hold the last generated name in each subject's folder
    	PrintWriter pw = null;
    	Scanner scanner = null;
    	int newNumber = 0; // starts with number zero
   
    	if (!file.exists()){ // if it's the very first time
    		try {
				pw = new PrintWriter(file);
				pw.print("0"); // write the number zero to be the first name of the new added mp3 file
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    		finally {pw.close();}
    	}
    	
    	else { // if it is not the first time
    		try {
				scanner = new Scanner(file);
				String lastNumber = scanner.next(); // read the last added mp3 file name
				newNumber = Integer.parseInt(lastNumber);
				newNumber++; // increment it to prevent duplicates names and errors 
				pw = new PrintWriter(file); 
				pw.print(newNumber); //overwrite the last name with the new one
				pw.flush();
				
				  
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    	
    		finally {
	    		scanner.close();
	    		pw.close();
	    	}
    	}
    	
    	
    	setMp3Dir(folder(subject)+File.separator+newNumber+".mp3"); // set the new mp3 file directory and name and extension
    	return mp3Dir; // return it
    	
    }

	
	
	
}